package me.brekfst.tokenforge.utilitys;

import me.brekfst.tokenforge.managers.EnchantmentNameManager;
import me.brekfst.tokenforge.managers.PointsManager;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class EnchantmentUtility {
    private Map<Enchantment, Map<Integer, Integer>> enchantmentPoints;

    public EnchantmentUtility(Map<Enchantment, Map<Integer, Integer>> enchantmentPoints) {
        this.enchantmentPoints = enchantmentPoints;
    }

    public static void selectEnchantment(Player player, PlayerMenuUtility playerMenuUtility, String enchantmentName, int level) {
        Map<Enchantment, Integer> selectedEnchantments = new HashMap<>(playerMenuUtility.getSelectedEnchantments());

        Enchantment enchantment = EnchantmentNameManager.getEnchantmentAPI(enchantmentName);

        // Check if the enchantment is already selected
        if (selectedEnchantments.containsKey(enchantment)) {
            // Enchantment is already selected, so unselect it
            int previousLevel = selectedEnchantments.get(enchantment);

            selectedEnchantments.remove(enchantment);

            int refundedPoints = PointsManager.getEnchantmentPoints(enchantment, previousLevel);
            PointsManager.addPoints(player, refundedPoints);

            player.playSound(player.getLocation(), "entity.player.levelup", 1, 1);
            player.sendMessage(ChatColor.YELLOW + "Unselected " + enchantmentName + " and refunded " + refundedPoints + " points!");

            int remainingPoints = PointsManager.getRemainingPoints(player);
            player.sendMessage(ChatColor.GOLD + "Remaining Points: " + remainingPoints);
        } else {
            int enchantmentPoints = PointsManager.getEnchantmentPoints(enchantment, level);
            if (PointsManager.canAffordPoints(player, enchantmentPoints)) {
                PointsManager.deductPoints(player, enchantmentPoints); // Deduct points here
                // add enchantment to selected enchantment map
                selectedEnchantments.put(enchantment, level);

                player.playSound(player.getLocation(), "entity.player.levelup", 1, 1);
                player.sendMessage(ChatColor.GREEN + "You have selected " + enchantmentName + " " + level + "!");

                int remainingPoints = PointsManager.getRemainingPoints(player);
                player.sendMessage(ChatColor.GOLD + "Remaining Points: " + remainingPoints);
            } else {
                player.sendMessage(ChatColor.RED + "You don't have enough points to select " + enchantmentName + " " + level + "!");
            }
        }

        playerMenuUtility.setSelectedEnchantments(selectedEnchantments);
    }
}
