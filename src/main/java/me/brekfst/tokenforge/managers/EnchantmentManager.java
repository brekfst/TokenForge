package me.brekfst.tokenforge.managers;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class EnchantmentManager {

    public static boolean canEnchantItem(Enchantment enchantment, ItemStack item) {
        // check if the enchantment and item are not null
        if (enchantment != null && item != null) {
            // check if the enchantment can be applied to the item
            return enchantment.canEnchantItem(item);
        }
        return false;
    }
    public static void applyEnchantment(ItemStack item, Enchantment enchantment, int level) {
        // check if the item and enchantment are not null
        if (item != null && enchantment != null) {
            // check if the enchantment can be applied to the item
            if (enchantment.canEnchantItem(item)) {
                // apply the enchantment to the item
                item.addEnchantment(enchantment, level);
            }
        }

    }

    public static void applyEnchantment(ItemStack selectedTool, Map<Enchantment, Integer> enchantments) {
    }
}
