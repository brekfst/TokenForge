package me.brekfst.tokenforge.commands;

import me.brekfst.tokenforge.TokenForge;
import me.brekfst.tokenforge.menusystem.menus.toolmenu.ToolMenu;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TokenForgeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {
            return false;
        }

        Player player = (Player) commandSender;

        FileConfiguration config = TokenForge.getPlugin(TokenForge.class).getConfig();
        String paymentItem = config.getString("payment-item");
        String paymentEnchant = config.getString("payment-enchant");
        Integer paymentLevel = config.getInt("payment-enchant-level");

// Check for the specified payment item
        boolean foundPaymentItem = false;
        ItemStack paymentItemStack = null;
        ItemStack[] inventoryContents = player.getInventory().getContents();

        for (ItemStack item : inventoryContents) {
            if (item != null && item.getType().toString().equalsIgnoreCase(paymentItem) && item.getItemMeta().hasLore()) {
                Enchantment enchantment = Enchantment.getByKey(NamespacedKey.minecraft(paymentEnchant));
                if (enchantment != null && item.getItemMeta().hasEnchant(enchantment)) {
                    foundPaymentItem = true;
                    paymentItemStack = item;
                    break; // Found the payment item, no need to continue searching
                }
            }
        }

        // Open menu if payment item is present
        if (foundPaymentItem) {
            new ToolMenu(TokenForge.getPlayerMenuUtility(player)).open();
            return true;
        } else {
            player.sendMessage(ChatColor.RED + "You do not have the required items to open this inventory!");
            return false;
        }
    }
}

