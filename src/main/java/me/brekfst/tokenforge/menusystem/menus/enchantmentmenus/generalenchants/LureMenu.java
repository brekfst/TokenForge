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

public class LureMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public LureMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Lure Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "lure", 3);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "lure", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "lure", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "lure", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // lure III
        ItemStack lureIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta lureIIIMeta = lureIII.getItemMeta();
        lureIIIMeta.setDisplayName(ChatColor.GOLD + "Lure III");
        lureIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        lureIII.setItemMeta(lureIIIMeta);

        // lure IV
        ItemStack lureIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta lureIVMeta = lureIV.getItemMeta();
        lureIVMeta.setDisplayName(ChatColor.GOLD + "Lure IV");
        lureIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        lureIV.setItemMeta(lureIVMeta);

        // lure V
        ItemStack lureV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta lureVMeta = lureV.getItemMeta();
        lureVMeta.setDisplayName(ChatColor.GOLD + "Lure V");
        lureVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        lureV.setItemMeta(lureVMeta);

        // lure VI
        ItemStack lureVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta lureVIMeta = lureVI.getItemMeta();
        lureVIMeta.setDisplayName(ChatColor.GOLD + "Lure VI");
        lureVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1300 Points"));
        lureVI.setItemMeta(lureVIMeta);

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
        inventory.setItem(20, lureIII);
        inventory.setItem(21, lureIV);
        inventory.setItem(23, lureV);
        inventory.setItem(24, lureVI);
        inventory.setItem(36, close);
    }
}
