package me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.rangedenchants;

import me.brekfst.tokenforge.managers.ToolMenuManager;
import me.brekfst.tokenforge.menusystem.Menu;
import me.brekfst.tokenforge.utilitys.EnchantmentUtility;
import me.brekfst.tokenforge.utilitys.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LoyaltyMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public LoyaltyMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Loyalty Enchantments!";
    }

    @Override
    public int getSlots() {
        return 45;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        int rawSlot = e.getRawSlot();

        switch (rawSlot) {
            case 20:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "loyalty", 3);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "loyalty", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "loyalty", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "loyalty", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // loyalty III
        ItemStack loyaltyIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta loyaltyIIIMeta = loyaltyIII.getItemMeta();
        loyaltyIIIMeta.setDisplayName(ChatColor.GOLD + "Loyalty III");
        loyaltyIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        loyaltyIII.setItemMeta(loyaltyIIIMeta);

        // loyalty IV
        ItemStack loyaltyIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta loyaltyIVMeta = loyaltyIV.getItemMeta();
        loyaltyIVMeta.setDisplayName(ChatColor.GOLD + "Loyalty IV");
        loyaltyIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "500 Points"));
        loyaltyIV.setItemMeta(loyaltyIVMeta);

        // loyalty V
        ItemStack loyaltyV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta loyaltyVMeta = loyaltyV.getItemMeta();
        loyaltyVMeta.setDisplayName(ChatColor.GOLD + "Loyalty V");
        loyaltyVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        loyaltyV.setItemMeta(loyaltyVMeta);

        // loyalty VI
        ItemStack loyaltyVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta loyaltyVIMeta = loyaltyVI.getItemMeta();
        loyaltyVIMeta.setDisplayName(ChatColor.GOLD + "Loyalty VI");
        loyaltyVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        loyaltyVI.setItemMeta(loyaltyVIMeta);

        // close button
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        // frame
        ItemStack frame = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 17, 26, 35, 44, 43, 42, 41, 40, 39, 38, 37, 27, 18, 9, 0}) {
            inventory.setItem(i, frame);
        }
        inventory.setItem(20,loyaltyIII);
        inventory.setItem(21, loyaltyIV);
        inventory.setItem(23, loyaltyV);
        inventory.setItem(24, loyaltyVI);
        inventory.setItem(36, close);
    }
}
