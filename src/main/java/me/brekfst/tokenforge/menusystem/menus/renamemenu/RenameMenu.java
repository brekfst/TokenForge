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
            case 21:
                player.sendMessage(ChatColor.GOLD + "Please enter the new name for your tool in chat!");
                playerMenuUtility.setSettingCustomName(true);
                playerMenuUtility.setCurrentMenu(this);
                player.closeInventory();
                break;
            case 23:
                player.sendMessage(ChatColor.GOLD + "Please enter the new lore for your tool in chat!");
                playerMenuUtility.setSettingCustomLore(true);
                playerMenuUtility.setCurrentMenu(this);
                player.closeInventory();
                break;
            case 36:
                // close
                playerMenuUtility.getPreviousMenu().open();
                break;
            case 40:
                // how to
                break;
            case 44:
                // reset
                playerMenuUtility.clearCustomName();
                playerMenuUtility.clearCustomLore();
                player.sendMessage(ChatColor.GOLD + "Your tool name and lore has been reset!");
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

        // how to
        ItemStack howTo = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta howToMeta = howTo.getItemMeta();
        howToMeta.setDisplayName(ChatColor.GOLD + "Rename Menu Help");
        howToMeta.setLore(Arrays.asList(ChatColor.GRAY + "How to Rename: ",
                ChatColor.GRAY + "you can use hex codes! begin each code with &# ",
                ChatColor.GRAY + "you may also use custom fonts from the internet!",
                ChatColor.GRAY + "for example you could do &#09c4e0&lᴛ for a blue",
                ChatColor.GRAY + "bolded letter T. for more help see a staff member!"));
        howTo.setItemMeta(howToMeta);

        // reset
        ItemStack reset = new ItemStack(Material.MAP);
        ItemMeta resetMeta = reset.getItemMeta();
        resetMeta.setDisplayName(ChatColor.GOLD + "Reset");
        resetMeta.setLore(Arrays.asList(ChatColor.GRAY + "Reset the name and lore of your tool!"));
        reset.setItemMeta(resetMeta);

        // close
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        closeMeta.setLore(Arrays.asList(ChatColor.GRAY + "Close"));
        close.setItemMeta(closeMeta);

        // frame
        ItemStack frame = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 17, 26, 35, 43, 42, 41, 39, 38, 37, 27, 18, 9, 0}) {
            inventory.setItem(i, frame);
        }

        inventory.setItem(21, rename);
        inventory.setItem(23, lore);
        inventory.setItem(36, close);
        inventory.setItem(40, howTo);
        inventory.setItem(44, reset);

    }

}
