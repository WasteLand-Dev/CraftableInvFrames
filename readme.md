# CraftableInvFrames (Moved to [codeberg](https://codeberg.org/WasteLandOrigin/CraftableInvFrames))
### A fork of Survival Invisiframes

This plugin enables the use of 1.20's invisible item frames for survival players

Invisible item frames are crafted similar to tipped arrows - one lingering invisibility potion surrounded by 8 item frames\
![Recipe Screenshot](https://i.imgur.com/RtX84ic.png)

In 1.17+, an invisible item frame can be crafted with a glow ink sac to create a glowing invisible item frame

## Permissions
Permission | Description
--- | ---
`craftableinvframes.place` | Allows the player to place an invisible item frame (enabled by default)
`craftableinvframes.craft`| Allows the player to craft an invisible item frame (enabled by default)
`craftableinvframes.cmd` | Allows the player to run commands from this plugin
`craftableinvframes.reload` | Permission to run `/iframe reload`
`craftableinvframes.forcerecheck` | Permission to run `/iframe force-recheck`
`craftableinvframes.get` | Permission to run `/iframe get`
`craftableinvframes.give` | Permission to run `/iframe give <player>`
`craftableinvframes.setitem` | Permission to run `/iframe setitem`

## Commands
Permission required for all commands: `craftableinvframes.cmd`

Command | Description | Permission
--- | --- | ---
`/iframe` or `/iframe get` | Gives the player an invisible item frame | `craftableinvframes.get`
`/iframe give` | Gives a certain player an invisible item frame | `craftableinvframes.give`
`/iframe reload` | Reloads the config | `craftableinvframes.reload`
`/iframe force-recheck` | Rechecks all loaded invisible item frames to add/remove slimes manually | `craftableinvframes.forcerecheck`
`/iframe setitem` | Sets the recipe center item to the held item | `craftableinvframes.setitem`

## Config
```yaml
# Whether or not to enable invisible item frames glowing when there's no item in them
# This will also make them visible when there's no item in them
item-frames-glow: true

# The item in the center of the recipe
# Recommended to use "/iframe setitem" to change this
recipe:
  ==: org.bukkit.inventory.ItemStack
  v: 2567
  type: LINGERING_POTION
  meta:
    ==: ItemMeta
    meta-type: POTION
    potion-type: minecraft:invisibility
```
