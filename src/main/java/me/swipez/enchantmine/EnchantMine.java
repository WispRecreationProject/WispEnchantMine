package me.swipez.enchantmine;

import me.swipez.enchantmine.commands.CommandComplete;
import me.swipez.enchantmine.commands.StartCommand;
import me.swipez.enchantmine.listeners.BlockBreakListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class EnchantMine extends JavaPlugin {

    public boolean gamestarted = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("enchantmine").setExecutor(new StartCommand(this));
        getCommand("enchantmine").setTabCompleter(new CommandComplete());
        getServer().getPluginManager().registerEvents(new BlockBreakListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
