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

public class SwiftSneakMenu extends Menu {

    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public SwiftSneakMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Swift Sneak Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "swift sneak", 3);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "swift sneak", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "swift sneak", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "swift sneak", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // swift sneak III
        ItemStack swiftIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta swiftIIIMeta = swiftIII.getItemMeta();
        swiftIIIMeta.setDisplayName(ChatColor.GOLD + "Swift Sneak III");
        swiftIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        swiftIII.setItemMeta(swiftIIIMeta);

        // swift sneak IV
        ItemStack swiftIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta swiftIVMeta = swiftIV.getItemMeta();
        swiftIVMeta.setDisplayName(ChatColor.GOLD + "Swift Sneak IV");
        swiftIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "500 Points"));
        swiftIV.setItemMeta(swiftIVMeta);

        // swift sneak V
        ItemStack swiftV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta swiftVMeta = swiftV.getItemMeta();
        swiftVMeta.setDisplayName(ChatColor.GOLD + "Swift Sneak V");
        swiftVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        swiftV.setItemMeta(swiftVMeta);

        // swift sneak VI
        ItemStack swiftVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta swiftVIMeta = swiftVI.getItemMeta();
        swiftVIMeta.setDisplayName(ChatColor.GOLD + "Swift Sneak VI");
        swiftVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1250 Points"));
        swiftVI.setItemMeta(swiftVIMeta);

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
        inventory.setItem(20, swiftIII);
        inventory.setItem(21, swiftIV);
        inventory.setItem(23, swiftV);
        inventory.setItem(24, swiftVI);
        inventory.setItem(36, close);
    }
}
