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

public class FrostWalkerMenu extends Menu {

    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public FrostWalkerMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Frost Walker Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "frost walker", 2);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "frost walker", 3);
                break;
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "frost walker", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "frost walker", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "frost walker", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // frost walker II
        ItemStack frostWalkerII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta frostWalkerIIMeta = frostWalkerII.getItemMeta();
        frostWalkerIIMeta.setDisplayName(ChatColor.GOLD + "Frost Walker II");
        frostWalkerIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        frostWalkerII.setItemMeta(frostWalkerIIMeta);

        // frost walker III
        ItemStack frostWalkerIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta frostWalkerIIIMeta = frostWalkerIII.getItemMeta();
        frostWalkerIIIMeta.setDisplayName(ChatColor.GOLD + "Frost Walker III");
        frostWalkerIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "500 Points"));
        frostWalkerIII.setItemMeta(frostWalkerIIIMeta);

        // frost walker IV
        ItemStack frostWalkerIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta frostWalkerIVMeta = frostWalkerIV.getItemMeta();
        frostWalkerIVMeta.setDisplayName(ChatColor.GOLD + "Frost Walker IV");
        frostWalkerIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        frostWalkerIV.setItemMeta(frostWalkerIVMeta);

        // frost walker V
        ItemStack frostWalkerV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta frostWalkerVMeta = frostWalkerV.getItemMeta();
        frostWalkerVMeta.setDisplayName(ChatColor.GOLD + "Frost Walker V");
        frostWalkerVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        frostWalkerV.setItemMeta(frostWalkerVMeta);

        // frost walker VI
        ItemStack frostWalkerVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta frostWalkerVIMeta = frostWalkerVI.getItemMeta();
        frostWalkerVIMeta.setDisplayName(ChatColor.GOLD + "Frost Walker VI");
        frostWalkerVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1250 Points"));
        frostWalkerVI.setItemMeta(frostWalkerVIMeta);

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
        inventory.setItem(20, frostWalkerII);
        inventory.setItem(21, frostWalkerIII);
        inventory.setItem(22, frostWalkerIV);
        inventory.setItem(23, frostWalkerV);
        inventory.setItem(24, frostWalkerVI);
        inventory.setItem(36, close);
    }
}
