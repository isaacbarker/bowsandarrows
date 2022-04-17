package me.isaacbarker.bowsandarrows.EventListeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.UUID;

public class EntityShootListener implements CommandExecutor, Listener {

    static ArrayList<UUID> missingPlayers = new ArrayList<>();

    @EventHandler
    public void onShoot(EntityShootBowEvent e) {
        if (e.getEntity() instanceof Player p) {
            if (missingPlayers.contains(p.getUniqueId())) {
                Entity proj = e.getProjectile();
                Vector v = proj.getVelocity();
                // Add a new random velocity
                double x = (Math.random() * (5 - 1) + 1) - 3; // random between 1 and 5 offset to -2 and 2
                double y = (Math.random() * (5 - 1) + 1) - 3;
                double z = (Math.random() * (5 - 1) + 1) - 3;
                Vector add = new Vector(x, y, z);
                v.add(add);
                // Update velocity
                proj.setVelocity(v);
            }
        }
    }

    // Toggle this listener
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("bowsandarrows.togglemissing")) {
            // Get the target for the command
            Player p = null;
            if (args.length >= 1) {
                p = Bukkit.getPlayer(args[0]);
            } else if (sender instanceof Player) {
                p = (Player) sender;
            } else {
                return false;
            }
            UUID uuid = p.getUniqueId();

            // Toggle missing for user
            if (missingPlayers.contains(uuid)) {
                missingPlayers.remove(uuid);
                sender.sendMessage(ChatColor.RED + "Missing was disabled for " + p.getDisplayName());
            } else {
                missingPlayers.add(uuid);
                sender.sendMessage(ChatColor.GREEN + "Missing was enabled for " + p.getDisplayName());
            }

            return true;
        }

        return true;
    }
}
