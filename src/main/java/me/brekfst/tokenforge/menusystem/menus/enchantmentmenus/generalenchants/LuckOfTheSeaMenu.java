package me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.generalenchants;

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

public class LuckOfTheSeaMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public LuckOfTheSeaMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Luck of the Sea Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "luck of the sea", 3);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "luck of the sea", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "luck of the sea", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "luck of the sea", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // luck of the sea III
        ItemStack luckIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta luckIIIMeta = luckIII.getItemMeta();
        luckIIIMeta.setDisplayName(ChatColor.GOLD + "Luck of the Sea III");
        luckIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        luckIII.setItemMeta(luckIIIMeta);

        // luck of the sea IV
        ItemStack luckIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta luckIVMeta = luckIV.getItemMeta();
        luckIVMeta.setDisplayName(ChatColor.GOLD + "Luck of the Sea IV");
        luckIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "500 Points"));
        luckIV.setItemMeta(luckIVMeta);

        // luck of the sea V
        ItemStack luckV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta luckVMeta = luckV.getItemMeta();
        luckVMeta.setDisplayName(ChatColor.GOLD + "Luck of the Sea V");
        luckVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        luckV.setItemMeta(luckVMeta);

        // luck of the sea VI
        ItemStack luckVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta luckVIMeta = luckVI.getItemMeta();
        luckVIMeta.setDisplayName(ChatColor.GOLD + "Luck of the Sea VI");
        luckVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        luckVI.setItemMeta(luckVIMeta);

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
        inventory.setItem(20, luckIII);
        inventory.setItem(21, luckIV);
        inventory.setItem(23, luckV);
        inventory.setItem(24, luckVI);
        inventory.setItem(36, close);
    }
}

