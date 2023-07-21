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

public class PiercingMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public PiercingMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Piercing Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "piercing", 4);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "piercing", 5);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "piercing", 6);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "piercing", 7);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // piercing IV
        ItemStack piercingIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta piercingIVMeta = piercingIV.getItemMeta();
        piercingIVMeta.setDisplayName(ChatColor.GOLD + "Piercing IV");
        piercingIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        piercingIV.setItemMeta(piercingIVMeta);

        // piercing V
        ItemStack piercingV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta piercingVMeta = piercingV.getItemMeta();
        piercingVMeta.setDisplayName(ChatColor.GOLD + "Piercing V");
        piercingVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        piercingV.setItemMeta(piercingVMeta);

        // piercing VI
        ItemStack piercingVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta piercingVIMeta = piercingVI.getItemMeta();
        piercingVIMeta.setDisplayName(ChatColor.GOLD + "Piercing VI");
        piercingVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        piercingVI.setItemMeta(piercingVIMeta);

        // piercing VII
        ItemStack piercingVII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta piercingVIIMeta = piercingVII.getItemMeta();
        piercingVIIMeta.setDisplayName(ChatColor.GOLD + "Piercing VII");
        piercingVIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1250 Points"));
        piercingVII.setItemMeta(piercingVIIMeta);

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
        inventory.setItem(20, piercingIV);
        inventory.setItem(21, piercingV);
        inventory.setItem(23, piercingVI);
        inventory.setItem(24, piercingVII);
        inventory.setItem(36, close);
    }
}
