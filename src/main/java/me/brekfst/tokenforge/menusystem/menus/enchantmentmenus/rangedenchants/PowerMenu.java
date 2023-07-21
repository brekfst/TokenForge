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

public class PowerMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public PowerMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Power Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "power", 5);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "power", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // power V
        ItemStack powerV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta powerVMeta = powerV.getItemMeta();
        powerVMeta.setDisplayName(ChatColor.GOLD + "Power V");
        powerVMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        powerV.setItemMeta(powerVMeta);

        // power VI
        ItemStack powerVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta powerVIMeta = powerVI.getItemMeta();
        powerVIMeta.setDisplayName(ChatColor.GOLD + "Power VI");
        powerVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        powerVI.setItemMeta(powerVIMeta);

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
        inventory.setItem(21, powerV);
        inventory.setItem(23, powerVI);
        inventory.setItem(36, close);
    }
}
