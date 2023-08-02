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

public class ImpalingMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public ImpalingMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Impaling Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "impaling", 5);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "impaling", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // impaling V
        ItemStack impalingV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta impalingVMeta = impalingV.getItemMeta();
        impalingVMeta.setDisplayName(ChatColor.GOLD + "Impaling V");
        impalingVMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        impalingV.setItemMeta(impalingVMeta);

        // impaling VI
        ItemStack impalingVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta impalingVIMeta = impalingVI.getItemMeta();
        impalingVIMeta.setDisplayName(ChatColor.GOLD + "Impaling VI");
        impalingVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1250 Points"));
        impalingVI.setItemMeta(impalingVIMeta);

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
        inventory.setItem(21, impalingV);
        inventory.setItem(23, impalingVI);
        inventory.setItem(36, close);
    }
}
