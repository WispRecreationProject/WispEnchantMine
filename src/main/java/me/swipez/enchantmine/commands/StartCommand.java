package me.swipez.enchantmine.commands;

import me.swipez.enchantmine.EnchantMine;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {

    EnchantMine plugin;

    public StartCommand(EnchantMine plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (sender.hasPermission("enchantmine.trigger")){
                if (args.length == 1){
                    if (args[0].equals("start")){
                        plugin.gamestarted = true;
                        Bukkit.broadcastMessage(ChatColor.GRAY+"[!] Enchantment mining challenge has "+ChatColor.GREEN+"begun"+ChatColor.GRAY+"!");
                    }
                    else if (args[0].equals("stop")){
                        plugin.gamestarted = false;
                        Bukkit.broadcastMessage(ChatColor.GRAY+"[!] Enchantment mining challenge has "+ChatColor.GREEN+"ended"+ChatColor.GRAY+"!");
                    }
                    else {
                        p.sendMessage(ChatColor.RED+"/enchantmine <start/stop>");
                    }
                }
                else {
                    p.sendMessage(ChatColor.RED+"/enchantmine <start/stop>");
                }
            }
            else {
                p.sendMessage(ChatColor.RED+"You do not have the permission to run this command!");
            }
        }
        else {
            sender.sendMessage(ChatColor.RED+"This command is for players only!");
        }
        return true;
    }
}
