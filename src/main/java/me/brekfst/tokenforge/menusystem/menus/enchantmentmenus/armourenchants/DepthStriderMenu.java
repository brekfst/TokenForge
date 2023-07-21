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

public class DepthStriderMenu extends Menu {

    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public DepthStriderMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Depth Strider Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "depth strider", 3);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "depth strider", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "depth strider", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "depth strider", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }


    @Override
    public void setMenuItems() {

        // depth strider III
        ItemStack depthIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta depthIIIMeta = depthIII.getItemMeta();
        depthIIIMeta.setDisplayName(ChatColor.GOLD + "Depth Strider III");
        depthIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        depthIII.setItemMeta(depthIIIMeta);

        // depth strider IV
        ItemStack depthIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta depthIVMeta = depthIV.getItemMeta();
        depthIVMeta.setDisplayName(ChatColor.GOLD + "Depth Strider IV");
        depthIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        depthIV.setItemMeta(depthIVMeta);

        // depth strider V
        ItemStack depthV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta depthVMeta = depthV.getItemMeta();
        depthVMeta.setDisplayName(ChatColor.GOLD + "Depth Strider V");
        depthVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        depthV.setItemMeta(depthVMeta);

        // depth strider VI
        ItemStack depthVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta depthVIMeta = depthVI.getItemMeta();
        depthVIMeta.setDisplayName(ChatColor.GOLD + "Depth Strider VI");
        depthVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1500 Points"));
        depthVI.setItemMeta(depthVIMeta);

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
        inventory.setItem(20, depthIII);
        inventory.setItem(21, depthIV);
        inventory.setItem(23, depthV);
        inventory.setItem(24, depthVI);
        inventory.setItem(36, close);
    }
}
