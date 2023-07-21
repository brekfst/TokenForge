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

public class BlastProtectionMenu extends Menu {

    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public BlastProtectionMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Blast Protection Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "blast protection", 4);
                break;
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "blast protection", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "blast protection", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // blast protection IV
        ItemStack blastProtectionIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta blastProtectionIVMeta = blastProtectionIV.getItemMeta();
        blastProtectionIVMeta.setDisplayName(ChatColor.GOLD + "Blast Protection IV");
        blastProtectionIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        blastProtectionIV.setItemMeta(blastProtectionIVMeta);

        // blast protection V
        ItemStack blastProtectionV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta blastProtectionVMeta = blastProtectionV.getItemMeta();
        blastProtectionVMeta.setDisplayName(ChatColor.GOLD + "Blast Protection V");
        blastProtectionVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        blastProtectionV.setItemMeta(blastProtectionVMeta);

        // blast protection VI
        ItemStack blastProtectionVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta blastProtectionVIMeta = blastProtectionVI.getItemMeta();
        blastProtectionVIMeta.setDisplayName(ChatColor.GOLD + "Blast Protection VI");
        blastProtectionVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        blastProtectionVI.setItemMeta(blastProtectionVIMeta);

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
        inventory.setItem(20, blastProtectionIV);
        inventory.setItem(22, blastProtectionV);
        inventory.setItem(24, blastProtectionVI);
        inventory.setItem(36, close);
    }
}
