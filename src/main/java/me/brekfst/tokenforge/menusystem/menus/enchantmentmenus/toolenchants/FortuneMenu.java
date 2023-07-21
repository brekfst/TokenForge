package me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.toolenchants;

import me.brekfst.tokenforge.managers.ToolMenuManager;
import me.brekfst.tokenforge.menusystem.Menu;
import me.brekfst.tokenforge.utilitys.EnchantmentUtility;
import me.brekfst.tokenforge.utilitys.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class FortuneMenu extends Menu {

    public FortuneMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Fortune Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "fortune", 3);
                break;
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "fortune", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "fortune", 5);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // fortune III
        ItemStack fortuneIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fortuneIIIMeta = fortuneIII.getItemMeta();
        fortuneIIIMeta.setDisplayName(ChatColor.GOLD + "Fortune III");
        fortuneIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        fortuneIII.setItemMeta(fortuneIIIMeta);

        // fortune IV
        ItemStack fortuneIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fortuneIVMeta = fortuneIV.getItemMeta();
        fortuneIVMeta.setDisplayName(ChatColor.GOLD + "Fortune IV");
        fortuneIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        fortuneIV.setItemMeta(fortuneIVMeta);

        // fortune V
        ItemStack fortuneV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fortuneVMeta = fortuneV.getItemMeta();
        fortuneVMeta.setDisplayName(ChatColor.GOLD + "Fortune V");
        fortuneVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1250 Points"));
        fortuneV.setItemMeta(fortuneVMeta);

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
        inventory.setItem(21, fortuneIII);
        inventory.setItem(22, fortuneIV);
        inventory.setItem(23, fortuneV);
        inventory.setItem(36, close);
    }
}
