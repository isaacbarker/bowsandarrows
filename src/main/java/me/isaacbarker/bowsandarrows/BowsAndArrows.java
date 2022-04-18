package me.isaacbarker.bowsandarrows;

import me.isaacbarker.bowsandarrows.EventListeners.EntityHitListener;
import me.isaacbarker.bowsandarrows.EventListeners.EntityShootListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class BowsAndArrows extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new EntityHitListener(this), this);
        getServer().getPluginManager().registerEvents(new EntityShootListener(), this);
        getCommand("missing").setExecutor(new EntityShootListener());
        getCommand("explosive").setExecutor(new EntityHitListener(this));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("reloadconfig")) { // Reload config command
            if (sender.hasPermission("bowsandarrows.reloadconfig")) {
                reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "Successfully reloaded config.yml.");
            }
        }

        return true;
    }
}
