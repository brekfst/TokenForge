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

public class RiptideMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public RiptideMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Riptide Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "riptide", 3);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "riptide", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "riptide", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "riptide", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // riptide III
        ItemStack riptideIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta riptideIIIMeta = riptideIII.getItemMeta();
        riptideIIIMeta.setDisplayName(ChatColor.GOLD + "Riptide III");
        riptideIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        riptideIII.setItemMeta(riptideIIIMeta);

        // riptide IV
        ItemStack riptideIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta riptideIVMeta = riptideIV.getItemMeta();
        riptideIVMeta.setDisplayName(ChatColor.GOLD + "Riptide IV");
        riptideIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "500 Points"));
        riptideIV.setItemMeta(riptideIVMeta);

        // riptide V
        ItemStack riptideV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta riptideVMeta = riptideV.getItemMeta();
        riptideVMeta.setDisplayName(ChatColor.GOLD + "Riptide V");
        riptideVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        riptideV.setItemMeta(riptideVMeta);

        // riptide VI
        ItemStack riptideVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta riptideVIMeta = riptideVI.getItemMeta();
        riptideVIMeta.setDisplayName(ChatColor.GOLD + "Riptide VI");
        riptideVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        riptideVI.setItemMeta(riptideVIMeta);

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
        inventory.setItem(20, riptideIII);
        inventory.setItem(21, riptideIV);
        inventory.setItem(23, riptideV);
        inventory.setItem(24, riptideVI);
        inventory.setItem(36, close);
    }
}
