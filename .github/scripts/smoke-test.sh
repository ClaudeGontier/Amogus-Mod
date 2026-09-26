#!/usr/bin/env bash
# Launches the game (server or client) from the dev environment, waits until it has
# finished loading, stops it and fails if the mod caused errors while loading.
set -uo pipefail

side="$1"   # server | client
ready="$2"  # regex matched against the log once the game has finished loading
log=run/logs/latest.log

mkdir -p run
echo "eula=true" > run/eula.txt
rm -rf run/logs run/crash-reports

if [ "$side" = client ]; then
  xvfb-run -a -s "-screen 0 1280x720x24" ./gradlew runClient > "$side.log" 2>&1 &
else
  ./gradlew runServer > "$side.log" 2>&1 &
fi

loaded=false
for _ in $(seq 1 180); do
  if grep -qE "$ready" "$log" 2>/dev/null; then loaded=true; break; fi
  if [ -d run/crash-reports ] && [ -n "$(ls -A run/crash-reports)" ]; then break; fi
  sleep 5
done

# Give the game a moment to finish whatever it was doing, then stop it
sleep 30
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
