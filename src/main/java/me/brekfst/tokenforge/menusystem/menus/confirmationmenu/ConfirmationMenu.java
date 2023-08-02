package me.brekfst.tokenforge.menusystem.menus.confirmationmenu;

import me.brekfst.tokenforge.TokenForge;
import me.brekfst.tokenforge.managers.EnchantmentManager;
import me.brekfst.tokenforge.managers.PointsManager;
import me.brekfst.tokenforge.menusystem.Menu;
import me.brekfst.tokenforge.menusystem.menus.renamemenu.RenameMenu;
import me.brekfst.tokenforge.utilitys.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;

public class ConfirmationMenu extends Menu {

    private PlayerMenuUtility playerMenuUtility;
    private ItemStack selectedTool;

    public ConfirmationMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
        this.playerMenuUtility = playerMenuUtility;
    }

    @Override
    public String getMenuName() {
        return "Confirmation Menu";
    }

    @Override
    public int getSlots() {
        return 45;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Player player = playerMenuUtility.getOwner();
        ItemStack enchantedEmeraldBlock = null;
        int rawSlot = event.getRawSlot();

        switch (rawSlot) {
            case 4:
                // show points
                break;
            case 22:
                // Show custom tool
                break;
            case 21:
                // Give custom tool to player
                ItemStack selectedTool = playerMenuUtility.getSelectedTool();
                Map<Enchantment, Integer> enchantments = playerMenuUtility.getSelectedEnchantments();
                EnchantmentManager.applyEnchantment(selectedTool, enchantments);
                ItemMeta toolMeta = selectedTool.getItemMeta();
                if (toolMeta != null) {
                    for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
                        toolMeta.addEnchant(entry.getKey(), entry.getValue(), true);
                    }
                    selectedTool.setItemMeta(toolMeta);
                }

                playerMenuUtility.setSelectedTool(selectedTool);

                // get payment item from config
                FileConfiguration config = TokenForge.getPlugin(TokenForge.class).getConfig();
                String paymentItem = config.getString("payment-item");
                String paymentEnchant = config.getString("payment-enchant");
                int paymentLevel = config.getInt("payment-enchant-level");

                // Check for the specified payment item
                boolean hasPaymentItem = false;
                ItemStack paymentItemStack = null;
                ItemStack[] inventoryContents = player.getInventory().getContents();

                for (ItemStack item : inventoryContents) {
                    if (item != null && item.getType().toString().equalsIgnoreCase(paymentItem) && item.getItemMeta().hasLore()) {
                        Enchantment enchantment = Enchantment.getByKey(NamespacedKey.minecraft(paymentEnchant));
                        if (enchantment != null && item.getEnchantmentLevel(enchantment) == paymentLevel) {
                            hasPaymentItem = true;
                            paymentItemStack = item;
                            break; // Found the payment item, no need to continue searching
                        }
                    }
                }

                // If payment item is present, continue
                if (hasPaymentItem) {
                    enchantedEmeraldBlock = paymentItemStack;
                    ItemStack toolCopy = new ItemStack(selectedTool);
                    ItemMeta copyMeta = toolCopy.getItemMeta();
                    if (copyMeta != null) {
                        copyMeta.setLore(null); // Clear the lore of the copied item
                        copyMeta.setDisplayName(null);
                        toolCopy.setItemMeta(copyMeta);
                    }

                    if (toolCopy != null) {
                        ItemMeta toolCopyMeta = toolCopy.getItemMeta();
                        if (toolCopyMeta != null) {
                            for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
                                toolCopyMeta.addEnchant(entry.getKey(), entry.getValue(), true);
                            }

                            String customName = playerMenuUtility.getCustomName();
                            if (customName != null) {
                                toolCopyMeta.setDisplayName(customName);
                            }

                            String customLore = playerMenuUtility.getCustomLore();
                            if (customLore != null) {
                                toolCopyMeta.setLore(Collections.singletonList(customLore));
                            }

                            toolCopy.setItemMeta(toolCopyMeta);

                        } else {
                            // Create a new ItemMeta if it is null
                            ItemMeta newToolMeta = Bukkit.getItemFactory().getItemMeta(toolCopy.getType());
                            if (newToolMeta != null) {
                                for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
                                    newToolMeta.addEnchant(entry.getKey(), entry.getValue(), true);
                                }

                                String customName = playerMenuUtility.getCustomName();
                                if (customName != null) {
                                    toolCopyMeta.setDisplayName(customName);
                                }

                                String customLore = playerMenuUtility.getCustomLore();
                                if (customLore != null) {
                                    toolCopyMeta.setLore(Collections.singletonList(customLore));
                                }

                                toolCopy.setItemMeta(newToolMeta);
                            }
                        }
                    }

                    // Add item to inventory
                    player.getInventory().addItem(toolCopy);

                    // Remove enchanted emerald block as payment
                    ItemStack enchantedEmeraldBlockToRemove = new ItemStack(enchantedEmeraldBlock);
                    enchantedEmeraldBlockToRemove.setAmount(1);
                    player.getInventory().removeItem(enchantedEmeraldBlockToRemove);

                    // Clear player data
                    playerMenuUtility.clearPlayerData();

                    player.closeInventory();
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have the required materials to craft this tool!");
                }
                break;

            case 23:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;

            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;

            case 40:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.setPreviousMenu(this);
                new RenameMenu(playerMenuUtility).open();
                break;
        }
    }


    @Override
    public void setMenuItems() {
        ItemStack selectedTool = playerMenuUtility.getSelectedTool();
        Player player = playerMenuUtility.getOwner();

        // custom tool
        if (selectedTool != null) {
            Map<Enchantment, Integer> enchantments = playerMenuUtility.getSelectedEnchantments();

            // Clone the selected tool
            ItemStack toolCopy = selectedTool.clone();

            // Apply the selected enchantments to the tool copy
            for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
                toolCopy.addUnsafeEnchantment(entry.getKey(), entry.getValue());
            }

            // Set the display name to indicate the selected enchantments
            ItemMeta toolMeta = toolCopy.getItemMeta();
            if (toolMeta != null) {
                toolMeta.setDisplayName(null);
                toolMeta.setLore(null);
                toolCopy.setItemMeta(toolMeta);
            }

            // confirm button
            ItemStack confirm = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta confirmMeta = confirm.getItemMeta();
            confirmMeta.setDisplayName(ChatColor.GREEN + "Confirm");
            confirm.setItemMeta(confirmMeta);

            // cancel button
            ItemStack cancel = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta cancelMeta = cancel.getItemMeta();
            cancelMeta.setDisplayName(ChatColor.RED + "Cancel");
            cancel.setItemMeta(cancelMeta);

            // points remaining
            ItemStack pointsRemaining = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta pointsRemainingMeta = (SkullMeta) pointsRemaining.getItemMeta();
            pointsRemainingMeta.setDisplayName(ChatColor.GOLD + "Your Points: " + ChatColor.GREEN + PointsManager.getRemainingPoints(player));
            pointsRemainingMeta.setOwningPlayer(player);
            pointsRemaining.setItemMeta(pointsRemainingMeta);

            // rename
            ItemStack rename = new ItemStack(Material.NAME_TAG);
            ItemMeta renameMeta = rename.getItemMeta();
            renameMeta.setDisplayName(ChatColor.GOLD + "Rename");
            renameMeta.setLore(Arrays.asList(ChatColor.GRAY + "Rename your tool"));
            rename.setItemMeta(renameMeta);

            // close
            ItemStack close = new ItemStack(Material.BARRIER);
            ItemMeta closeMeta = close.getItemMeta();
            closeMeta.setDisplayName(ChatColor.RED + "Close");
            closeMeta.setLore(Arrays.asList(ChatColor.GRAY + "Close"));
            close.setItemMeta(closeMeta);

            // frame
            ItemStack frame = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
            for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 17, 26, 35, 44, 43, 42, 41, 40, 39, 38, 37, 36, 27, 18, 9, 0}) {
                inventory.setItem(i, frame);
            }

            inventory.setItem(4, pointsRemaining);
            inventory.setItem(22, toolCopy);
            inventory.setItem(21, confirm);
            inventory.setItem(23, cancel);
            inventory.setItem(36, close);
            inventory.setItem(40, rename);
        }
    }
}