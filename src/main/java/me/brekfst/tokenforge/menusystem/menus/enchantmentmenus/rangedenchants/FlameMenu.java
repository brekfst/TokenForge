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

public class FlameMenu extends Menu {

    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public FlameMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Flame Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "flame", 1);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "flame", 2);
                break;
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "flame", 3);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "flame", 4);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "flame", 5);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // flame I
        ItemStack flameI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta flameIMeta = flameI.getItemMeta();
        flameIMeta.setDisplayName(ChatColor.GOLD + "Flame I");
        flameIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        flameI.setItemMeta(flameIMeta);

        // flame II
        ItemStack flameII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta flameIIMeta = flameII.getItemMeta();
        flameIIMeta.setDisplayName(ChatColor.GOLD + "Flame II");
        flameIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "500 Points"));
        flameII.setItemMeta(flameIIMeta);

        // flame III
        ItemStack flameIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta flameIIIMeta = flameIII.getItemMeta();
        flameIIIMeta.setDisplayName(ChatColor.GOLD + "Flame III");
        flameIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        flameIII.setItemMeta(flameIIIMeta);

        // flame IV
        ItemStack flameIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta flameIVMeta = flameIV.getItemMeta();
        flameIVMeta.setDisplayName(ChatColor.GOLD + "Flame IV");
        flameIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        flameIV.setItemMeta(flameIVMeta);

        // flame V
        ItemStack flameV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta flameVMeta = flameV.getItemMeta();
        flameVMeta.setDisplayName(ChatColor.GOLD + "Flame V");
        flameVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1250 Points"));
        flameV.setItemMeta(flameVMeta);

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
        inventory.setItem(20, flameI);
        inventory.setItem(21, flameII);
        inventory.setItem(22, flameIII);
        inventory.setItem(23, flameIV);
        inventory.setItem(24, flameV);
        inventory.setItem(36, close);
    }
}
