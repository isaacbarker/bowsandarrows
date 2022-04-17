package me.isaacbarker.bowsandarrows.EventListeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;

import java.util.UUID;

public class EntityHitListener implements CommandExecutor, Listener {

    static ArrayList<UUID> explosivePlayers = new ArrayList<>();

    @EventHandler
    public void onEntityHit(EntityDamageByEntityEvent e) {
        // Check if damage is an arrow or trident
        if (e.getDamager() instanceof Arrow a) {
            if (a.getShooter() instanceof Player p) {
                if (explosivePlayers.contains(p.getUniqueId())) {
                    // Get data about
                    Location loc = e.getEntity().getLocation();
                    World w = e.getEntity().getWorld();

                    if (a.getFireTicks() > 0) { // Arrow is on fire -> fire explosion
                        w.createExplosion(loc, 3f, true);
                    } else { // Arrow is not on fire -> plain explosion
                        w.createExplosion(loc, 3f, false);
                    }
                }
            }
        }
    }

    // Toggle this listener
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("bowsandarrows.toggleexplosive")) {
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
            if (explosivePlayers.contains(uuid)) {
                explosivePlayers.remove(uuid);
                sender.sendMessage(ChatColor.RED + "Explosive arrows was disabled for " + p.getDisplayName());
            } else {
                explosivePlayers.add(uuid);
                sender.sendMessage(ChatColor.GREEN + "Explosive arrows was enabled for " + p.getDisplayName());
            }

            return true;
        }

        return true;
    }
}
