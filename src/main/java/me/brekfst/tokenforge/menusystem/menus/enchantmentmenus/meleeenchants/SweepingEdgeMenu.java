package me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.meleeenchants;

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

public class SweepingEdgeMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public SweepingEdgeMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
        this.selectedTool = new HashMap<>();
    }

    @Override
    public String getMenuName() {
        return "Sweeping Edge Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "sweeping edge", 3);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "sweeping edge", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "sweeping edge", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "sweeping edge", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // sweeping edge III
        ItemStack sweepingEdgeIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta sweepingEdgeIIIMeta = sweepingEdgeIII.getItemMeta();
        sweepingEdgeIIIMeta.setDisplayName(ChatColor.GOLD + "Sweeping Edge III");
        sweepingEdgeIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        sweepingEdgeIII.setItemMeta(sweepingEdgeIIIMeta);

        // sweeping edge IV
        ItemStack sweepingEdgeIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta sweepingEdgeIVMeta = sweepingEdgeIV.getItemMeta();
        sweepingEdgeIVMeta.setDisplayName(ChatColor.GOLD + "Sweeping Edge IV");
        sweepingEdgeIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "500 Points"));
        sweepingEdgeIV.setItemMeta(sweepingEdgeIVMeta);

        // sweeping edge V
        ItemStack sweepingEdgeV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta sweepingEdgeVMeta = sweepingEdgeV.getItemMeta();
        sweepingEdgeVMeta.setDisplayName(ChatColor.GOLD + "Sweeping Edge V");
        sweepingEdgeVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        sweepingEdgeV.setItemMeta(sweepingEdgeVMeta);

        // sweeping edge VI
        ItemStack sweepingEdgeVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta sweepingEdgeVIMeta = sweepingEdgeVI.getItemMeta();
        sweepingEdgeVIMeta.setDisplayName(ChatColor.GOLD + "Sweeping Edge VI");
        sweepingEdgeVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        sweepingEdgeVI.setItemMeta(sweepingEdgeVIMeta);

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
        inventory.setItem(20, sweepingEdgeIII);
        inventory.setItem(21, sweepingEdgeIV);
        inventory.setItem(23, sweepingEdgeV);
        inventory.setItem(24, sweepingEdgeVI);
        inventory.setItem(36, close);
    }
}
