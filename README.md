# Bows and Arrows

This plugin is a simple plugin which plays around with projectiles and players in Minecraft. Using the Spigot 1.18 API, I created two listeners and two commands to go alongside them. This is my first Java plugin I built after watching my a couple videos on Youtube.

### Explosive Arrows

Firstly using `/explosive (player)` or just `/explosive` to select yourself causes all arrows shot by you to be explosive. It requires the `bowsandarrows.toggleexplosive` permission or just operator on a server. This will then create a tnt 75% power tnt explosion at the location of the entity that you hit. If you have flame or your arrow catches fire then the explosion will have flames and similar to that of a bed in the nether but with less power. If you do not hit an entity then nothing happens.

### Missing Shots

This I imagine being some sort of punishment or consequence or your Minecraft server or just a trick on your friends. When using `/missing (player)` or just `/missing` to select yourself all of your arrows will be offset by a random number in every direction so you can never hit a shot. These shots vary from something very subtle to extreme changes like straight down or straight up. The commands requires the `bowsandarrows.togglemissing` permission or just operator on a server. It should just add some fun or annoyance into your server.

### Config

So that server owners can configure this server you will find a config.yml created when restarting your server with version `1.1` and upward. Within this config file you can adapt certain functionality of the plugin. To reload the config without restarting or reloading the server use: `/reloadconfig` which requires the `bowsandarrows.reloadconfig` permission which operators have as default.

### How to download

To download this plugin you can:
- Go via SpigotMC: https://www.spigotmc.org/resources/bowsandarrows.101447/
- Access the releases tab: https://github.com/isaacbarker/bowsandarrows/releases
