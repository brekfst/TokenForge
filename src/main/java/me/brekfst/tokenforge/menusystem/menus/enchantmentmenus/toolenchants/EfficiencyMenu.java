package me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.toolenchants;

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

public class EfficiencyMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public EfficiencyMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Efficiency Enchantments!";
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
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "efficiency", 5);
                break;
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "efficiency", 6);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "efficiency", 7);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // efficiency V
        ItemStack efficiencyV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta efficiencyVMeta = efficiencyV.getItemMeta();
        efficiencyVMeta.setDisplayName(ChatColor.GOLD + "Efficiency V");
        efficiencyVMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        efficiencyV.setItemMeta(efficiencyVMeta);

        // efficiency VI
        ItemStack efficiencyVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta efficiencyVIMeta = efficiencyVI.getItemMeta();
        efficiencyVIMeta.setDisplayName(ChatColor.GOLD + "Efficiency VI");
        efficiencyVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        efficiencyVI.setItemMeta(efficiencyVIMeta);

        // efficiency VII
        ItemStack efficiencyVII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta efficiencyVIIMeta = efficiencyVII.getItemMeta();
        efficiencyVIIMeta.setDisplayName(ChatColor.GOLD + "Efficiency VII");
        efficiencyVIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1250 Points"));
        efficiencyVII.setItemMeta(efficiencyVIIMeta);

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
        inventory.setItem(21, efficiencyV);
        inventory.setItem(22, efficiencyVI);
        inventory.setItem(23, efficiencyVII);
        inventory.setItem(36, close);
    }
}