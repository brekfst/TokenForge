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

public class UnbreakingMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public UnbreakingMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Unbreaking Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "unbreaking", 3);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "unbreaking", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "unbreaking", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "unbreaking", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // unbreaking III
        ItemStack unbreakingIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta unbreakingIIIMeta = unbreakingIII.getItemMeta();
        unbreakingIIIMeta.setDisplayName(ChatColor.GOLD + "Unbreaking III");
        unbreakingIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        unbreakingIII.setItemMeta(unbreakingIIIMeta);

        // unbreaking IV
        ItemStack unbreakingIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta unbreakingIVMeta = unbreakingIV.getItemMeta();
        unbreakingIVMeta.setDisplayName(ChatColor.GOLD + "Unbreaking IV");
        unbreakingIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        unbreakingIV.setItemMeta(unbreakingIVMeta);

        // unbreaking V
        ItemStack unbreakingV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta unbreakingVMeta = unbreakingV.getItemMeta();
        unbreakingVMeta.setDisplayName(ChatColor.GOLD + "Unbreaking V");
        unbreakingVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1200 Points"));
        unbreakingV.setItemMeta(unbreakingVMeta);

        // unbreaking VI
        ItemStack unbreakingVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta unbreakingVIMeta = unbreakingVI.getItemMeta();
        unbreakingVIMeta.setDisplayName(ChatColor.GOLD + "Unbreaking VI");
        unbreakingVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1500 Points"));
        unbreakingVI.setItemMeta(unbreakingVIMeta);

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
            inventory.setItem(20, unbreakingIII);
            inventory.setItem(21, unbreakingIV);
            inventory.setItem(23, unbreakingV);
            inventory.setItem(24, unbreakingVI);
            inventory.setItem(36, close);
    }
}