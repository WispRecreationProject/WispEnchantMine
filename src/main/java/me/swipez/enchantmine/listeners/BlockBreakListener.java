package me.swipez.enchantmine.listeners;

import me.swipez.enchantmine.EnchantMine;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockBreakListener implements Listener {

    EnchantMine plugin;

    public BlockBreakListener(EnchantMine plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMine(BlockBreakEvent event){
        if (plugin.gamestarted){
            Random random = new Random();

            Player player = event.getPlayer();
            List<Integer> slots = getSlotsWithItems(player.getInventory());
            int selector = random.nextInt(slots.size());
            int selectedslot = slots.get(selector);
            Enchantment randEnchant = Enchantment.values()[(int) (Math.random() * Enchantment.values().length)];
            ItemStack selecteditem = player.getInventory().getItem(selectedslot);
            ItemMeta selectedmeta = selecteditem.getItemMeta();
            int value = 1;
            if (selectedmeta.hasEnchant(randEnchant)){
                value = selectedmeta.getEnchantLevel(randEnchant)+1;
            }
            selectedmeta.addEnchant(randEnchant, value, true);
            selecteditem.setItemMeta(selectedmeta);
        }
    }

    public List<Integer> getSlotsWithItems(Inventory inventory){
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < inventory.getSize(); i++){
            if (inventory.getItem(i) != null){
                integers.add(i);
            }
        }
        return integers;
    }
}
