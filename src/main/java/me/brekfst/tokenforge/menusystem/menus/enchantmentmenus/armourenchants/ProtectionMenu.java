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

public class ProtectionMenu extends Menu {

    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public ProtectionMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Protection Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "protection", 4);
                break;
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "protection", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "protection", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // protection IV
        ItemStack protectionIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta protectionIVMeta = protectionIV.getItemMeta();
        protectionIVMeta.setDisplayName(ChatColor.GOLD + "Protection IV");
        protectionIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        protectionIV.setItemMeta(protectionIVMeta);

        // protection V
        ItemStack protectionV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta protectionVMeta = protectionV.getItemMeta();
        protectionVMeta.setDisplayName(ChatColor.GOLD + "Protection V");
        protectionVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1500 Points"));
        protectionV.setItemMeta(protectionVMeta);

        // protection VI
        ItemStack protectionVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta protectionVIMeta = protectionVI.getItemMeta();
        protectionVIMeta.setDisplayName(ChatColor.GOLD + "Protection VI");
        protectionVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "2500 Points"));
        protectionVI.setItemMeta(protectionVIMeta);

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
            inventory.setItem(20, protectionIV);
            inventory.setItem(22, protectionV);
            inventory.setItem(24, protectionVI);
            inventory.setItem(36, close);
    }
}
