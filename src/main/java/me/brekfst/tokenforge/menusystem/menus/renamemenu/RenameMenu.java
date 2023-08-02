package me.brekfst.tokenforge.menusystem.menus.renamemenu;

import me.brekfst.tokenforge.menusystem.Menu;
import me.brekfst.tokenforge.utilitys.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class RenameMenu extends Menu {

    public RenameMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Rename Menu";
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
            case 22:
                player.sendMessage(ChatColor.GOLD + "Please enter the new name for your tool in chat!");
                playerMenuUtility.setCurrentMenu(this);
                player.closeInventory();
                break;
            case 31:
                player.sendMessage(ChatColor.GOLD + "Please enter the new lore for your tool in chat!");
                playerMenuUtility.setSettingCustomLore(true);
                playerMenuUtility.setCurrentMenu(this);
                player.closeInventory();
                break;
            case 36:
                // close
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // rename item
        ItemStack rename = new ItemStack(Material.NAME_TAG);
        ItemMeta renameMeta = rename.getItemMeta();
        renameMeta.setDisplayName(ChatColor.GOLD + "Rename your tool!");
        renameMeta.setLore(Arrays.asList(ChatColor.GRAY + "Rename your tool!"));
        rename.setItemMeta(renameMeta);

        // set lore line
        ItemStack lore = new ItemStack(Material.PAPER);
        ItemMeta loreMeta = lore.getItemMeta();
        loreMeta.setDisplayName(ChatColor.GOLD + "Set Lore");
        loreMeta.setLore(Arrays.asList(ChatColor.GRAY + "Set the lore of your tool!"));
        lore.setItemMeta(loreMeta);

        // close
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        closeMeta.setLore(Arrays.asList(ChatColor.GRAY + "Close"));
        close.setItemMeta(closeMeta);

        // frame
        ItemStack frame = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 17, 26, 35, 44, 43, 42, 41, 40, 39, 38, 37, 27, 18, 9, 0}) {
            inventory.setItem(i, frame);
        }

        inventory.setItem(22, rename);
        inventory.setItem(31, lore);
        inventory.setItem(36, close);

    }

}
