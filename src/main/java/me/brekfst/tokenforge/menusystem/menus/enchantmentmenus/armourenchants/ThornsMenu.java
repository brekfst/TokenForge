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

public class ThornsMenu extends Menu {

    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public ThornsMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Thorns Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "thorns", 3);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "thorns", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "thorns", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "thorns", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // thorns III
        ItemStack thornsIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta thornsIIIMeta = thornsIII.getItemMeta();
        thornsIIIMeta.setDisplayName(ChatColor.GOLD + "Thorns III");
        thornsIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        thornsIII.setItemMeta(thornsIIIMeta);

        // thorns IV
        ItemStack thornsIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta thornsIVMeta = thornsIV.getItemMeta();
        thornsIVMeta.setDisplayName(ChatColor.GOLD + "Thorns IV");
        thornsIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "500 Points"));
        thornsIV.setItemMeta(thornsIVMeta);

        // thorns V
        ItemStack thornsV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta thornsVMeta = thornsV.getItemMeta();
        thornsVMeta.setDisplayName(ChatColor.GOLD + "Thorns V");
        thornsVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        thornsV.setItemMeta(thornsVMeta);

        // thorns VI
        ItemStack thornsVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta thornsVIMeta = thornsVI.getItemMeta();
        thornsVIMeta.setDisplayName(ChatColor.GOLD + "Thorns VI");
        thornsVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1250 Points"));
        thornsVI.setItemMeta(thornsVIMeta);

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
        inventory.setItem(20, thornsIII);
        inventory.setItem(21, thornsIV);
        inventory.setItem(23, thornsV);
        inventory.setItem(24, thornsVI);
        inventory.setItem(36, close);
    }
}