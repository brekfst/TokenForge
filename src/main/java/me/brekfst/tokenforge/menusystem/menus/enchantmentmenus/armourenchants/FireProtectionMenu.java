package me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.armourenchants;

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

public class FireProtectionMenu extends Menu {

    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public FireProtectionMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Fire Protection Enchantments!";
    }

    @Override
    public int getSlots() {
        return 45;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        int rawSlot = event.getRawSlot();

        switch (rawSlot) {
            case 20:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "fire protection", 4);
                break;
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "fire protection", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "fire protection", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // fire protection IV
        ItemStack fireProtectionIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fireProtectionIVMeta = fireProtectionIV.getItemMeta();
        fireProtectionIVMeta.setDisplayName(ChatColor.GOLD + "Fire Protection IV");
        fireProtectionIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        fireProtectionIV.setItemMeta(fireProtectionIVMeta);

        // fire protection V
        ItemStack fireProtectionV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fireProtectionVMeta = fireProtectionV.getItemMeta();
        fireProtectionVMeta.setDisplayName(ChatColor.GOLD + "Fire Protection V");
        fireProtectionVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        fireProtectionV.setItemMeta(fireProtectionVMeta);

        // fire protection VI
        ItemStack fireProtectionVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fireProtectionVIMeta = fireProtectionVI.getItemMeta();
        fireProtectionVIMeta.setDisplayName(ChatColor.GOLD + "Fire Protection VI");
        fireProtectionVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        fireProtectionVI.setItemMeta(fireProtectionVIMeta);

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
        inventory.setItem(20, fireProtectionIV);
        inventory.setItem(22, fireProtectionV);
        inventory.setItem(24, fireProtectionVI);
        inventory.setItem(36, close);
    }
}
