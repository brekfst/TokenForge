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

public class PunchMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public PunchMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Punch Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "punch", 2);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "punch", 3);
                break;
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "punch", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "punch", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "punch", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // punch II
        ItemStack punchII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta punchIIMeta = punchII.getItemMeta();
        punchIIMeta.setDisplayName(ChatColor.GOLD + "Punch II");
        punchIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        punchII.setItemMeta(punchIIMeta);

        // punch III
        ItemStack punchIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta punchIIIMeta = punchIII.getItemMeta();
        punchIIIMeta.setDisplayName(ChatColor.GOLD + "Punch III");
        punchIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        punchIII.setItemMeta(punchIIIMeta);

        // punch IV
        ItemStack punchIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta punchIVMeta = punchIV.getItemMeta();
        punchIVMeta.setDisplayName(ChatColor.GOLD + "Punch IV");
        punchIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        punchIV.setItemMeta(punchIVMeta);

        // punch V
        ItemStack punchV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta punchVMeta = punchV.getItemMeta();
        punchVMeta.setDisplayName(ChatColor.GOLD + "Punch V");
        punchVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1250 Points"));
        punchV.setItemMeta(punchVMeta);

        // punch VI
        ItemStack punchVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta punchVIMeta = punchVI.getItemMeta();
        punchVIMeta.setDisplayName(ChatColor.GOLD + "Punch VI");
        punchVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1750 Points"));
        punchVI.setItemMeta(punchVIMeta);

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
        inventory.setItem(20, punchII);
        inventory.setItem(21, punchIII);
        inventory.setItem(22, punchIV);
        inventory.setItem(23, punchV);
        inventory.setItem(24, punchVI);
        inventory.setItem(36, close);
    }
}
