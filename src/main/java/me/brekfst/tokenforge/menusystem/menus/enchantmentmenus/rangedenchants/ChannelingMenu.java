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

public class ChannelingMenu extends Menu {

    ItemStack selectedTool;

    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public ChannelingMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Channeling Enchantments!";
    }

    @Override
    public int getSlots() {
        return 45;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        switch (event.getRawSlot()) {
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "channeling", 1);
                break;
            case 36: // open relevant tool menu
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // channeling
        ItemStack channeling = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta channelingMeta = channeling.getItemMeta();
        channelingMeta.setDisplayName(ChatColor.GOLD + "Channeling");
        channelingMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        channeling.setItemMeta(channelingMeta);

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
        inventory.setItem(22, channeling);
        inventory.setItem(36, close);
    }
}

