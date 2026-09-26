#!/usr/bin/env bash
# Launches the game (server or client) from the dev environment, waits until it has
# finished loading, stops it and fails if the mod caused errors while loading.
#
# The client run loads the world created by the server run with a small datapack that
# builds a scene (AMOGUS of several colours, armor stands wearing the SUS armor) and
# takes screenshots of it.
set -uo pipefail

side="$1"   # server | client
log=run/logs/latest.log

mkdir -p run
echo "eula=true" > run/eula.txt
rm -rf run/logs run/crash-reports

if [ "$side" = client ]; then
  ready='smoke-scene-ready'
  rm -rf run/saves/smoke
  mkdir -p run/saves screenshots
  cp -r run/world run/saves/smoke
  mkdir -p run/saves/smoke/datapacks
  cp -r .github/smoke/datapack run/saves/smoke/datapacks/smoke
  cp .github/smoke/options.txt run/options.txt

  export DISPLAY=:99
  Xvfb :99 -screen 0 1280x720x24 > /dev/null 2>&1 &
  sleep 3
  ./gradlew runClient -PquickPlayWorld=smoke > "$side.log" 2>&1 &
else
  ready='Done \('
  ./gradlew runServer > "$side.log" 2>&1 &
fi

loaded=false
for _ in $(seq 1 180); do
  if grep -qE "$ready" "$log" 2>/dev/null; then loaded=true; break; fi
  if [ -d run/crash-reports ] && [ -n "$(ls -A run/crash-reports)" ]; then break; fi
  sleep 5
done

# Give the game a moment to finish loading chunks and play the animations
sleep 30

if [ "$side" = client ] && [ "$loaded" = true ]; then
  import -window root screenshots/scene.png
  xdotool key F1 && sleep 3
  import -window root screenshots/scene_no_hud.png
  xdotool key F5 && sleep 5
  import -window root screenshots/third_person.png
fi

pkill -f 'net.neoforged' || true
sleep 10
pkill -9 -f 'net.neoforged' || true

cat "$log" || true

status=0
if [ "$loaded" != true ]; then
  echo "::error::The $side did not finish loading"
  status=1
fi
if [ -d run/crash-reports ] && [ -n "$(ls -A run/crash-reports)" ]; then
  echo "::error::The $side crashed"
  cat run/crash-reports/*
  status=1
fi
if grep -nE 'ERROR\].*(amogusmod|geckolib)|Missing textures|Couldn.t parse|Failed to parse|Unknown geo model format|(Exception|Error).*amogusmod' "$log" "$side.log"; then
  echo "::error::Errors related to the mod were logged by the $side"
  status=1
fi
exit $status
