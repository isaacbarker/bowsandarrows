package me.isaacbarker.bowsandarrows;

import me.isaacbarker.bowsandarrows.EventListeners.EntityHitListener;
import me.isaacbarker.bowsandarrows.EventListeners.EntityShootListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BowsAndArrows extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new EntityHitListener(), this);
        getServer().getPluginManager().registerEvents(new EntityShootListener(), this);
        getCommand("missing").setExecutor(new EntityShootListener());
        getCommand("explosive").setExecutor(new EntityHitListener());
    }

}
