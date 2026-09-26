tag @s add smoke
gamemode creative @s
time set noon
weather clear
fill ~-8 ~-1 ~-2 ~8 ~-1 ~14 minecraft:grass_block
fill ~-8 ~ ~-2 ~8 ~12 ~14 minecraft:air
tp @s ~ ~ ~ 0 15
summon amogusmod:amogus ~-3 ~ ~4 {NoAI:1b,PersistenceRequired:1b,Rotation:[180f,0f],Variant:0}
summon amogusmod:amogus ~-1.5 ~ ~4 {NoAI:1b,PersistenceRequired:1b,Rotation:[180f,0f],Variant:1}
summon amogusmod:amogus ~0 ~ ~4 {NoAI:1b,PersistenceRequired:1b,Rotation:[180f,0f],Variant:5}
summon amogusmod:amogus ~1.5 ~ ~4 {NoAI:1b,PersistenceRequired:1b,Rotation:[180f,0f],Variant:13}
summon amogusmod:amogus ~3 ~ ~4 {NoAI:1b,PersistenceRequired:1b,Rotation:[150f,0f],Variant:10}
summon minecraft:armor_stand ~-1 ~ ~7 {Rotation:[180f,0f],ShowArms:1b,equipment:{head:{id:"amogusmod:sus_helmet"},chest:{id:"amogusmod:sus_chestplate"},legs:{id:"amogusmod:sus_leggings"},feet:{id:"amogusmod:sus_boots"}}}
summon minecraft:armor_stand ~1.5 ~ ~7 {Rotation:[210f,0f],ShowArms:1b,equipment:{head:{id:"amogusmod:sus_helmet"},chest:{id:"amogusmod:sus_chestplate"},legs:{id:"amogusmod:sus_leggings"},feet:{id:"amogusmod:sus_boots"}}}
item replace entity @s hotbar.0 with amogusmod:sus_sword
item replace entity @s hotbar.1 with amogusmod:sus_apple
item replace entity @s hotbar.2 with amogusmod:sus_ingot
item replace entity @s hotbar.3 with amogusmod:sus_nugget
item replace entity @s hotbar.4 with amogusmod:sus_pickaxe
item replace entity @s hotbar.5 with amogusmod:sus_axe
item replace entity @s hotbar.6 with amogusmod:sus_shovel
item replace entity @s hotbar.7 with amogusmod:sus_hoe
item replace entity @s hotbar.8 with amogusmod:sus_helmet
tellraw @a "smoke-scene-ready"
