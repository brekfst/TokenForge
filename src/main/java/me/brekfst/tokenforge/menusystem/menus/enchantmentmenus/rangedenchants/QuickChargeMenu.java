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

public class QuickChargeMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public QuickChargeMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Quick Charge Enchantments!";
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
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "quick charge", 3);
                break;
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "quick charge", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "quick charge", 5);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // quick charge III
        ItemStack quickIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta quickIIIMeta = quickIII.getItemMeta();
        quickIIIMeta.setDisplayName(ChatColor.GOLD + "Quick Charge III");
        quickIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        quickIII.setItemMeta(quickIIIMeta);

        // quick charge IV
        ItemStack quickIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta quickIVMeta = quickIV.getItemMeta();
        quickIVMeta.setDisplayName(ChatColor.GOLD + "Quick Charge IV");
        quickIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "500 Points"));
        quickIV.setItemMeta(quickIVMeta);

        // quick charge V
        ItemStack quickV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta quickVMeta = quickV.getItemMeta();
        quickVMeta.setDisplayName(ChatColor.GOLD + "Quick Charge V");
        quickVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        quickV.setItemMeta(quickVMeta);

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
        inventory.setItem(21, quickIII);
        inventory.setItem(22, quickIV);
        inventory.setItem(23, quickV);
        inventory.setItem(36, close);
    }
}
