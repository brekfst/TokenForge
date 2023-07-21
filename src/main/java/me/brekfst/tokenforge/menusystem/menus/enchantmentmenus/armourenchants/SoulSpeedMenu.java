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

public class SoulSpeedMenu extends Menu {

    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public SoulSpeedMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Soul Speed Enchantments!";
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
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "soul speed", 3);
                break;
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "soul speed", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "soul speed", 5);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // soul speed III
        ItemStack soulSpeedIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta soulSpeedIIIMeta = soulSpeedIII.getItemMeta();
        soulSpeedIIIMeta.setDisplayName(ChatColor.GOLD + "Soul Speed III");
        soulSpeedIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        soulSpeedIII.setItemMeta(soulSpeedIIIMeta);

        // soul speed IV
        ItemStack soulSpeedIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta soulSpeedIVMeta = soulSpeedIV.getItemMeta();
        soulSpeedIVMeta.setDisplayName(ChatColor.GOLD + "Soul Speed IV");
        soulSpeedIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "500 Points"));
        soulSpeedIV.setItemMeta(soulSpeedIVMeta);

        // soul speed V
        ItemStack soulSpeedV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta soulSpeedVMeta = soulSpeedV.getItemMeta();
        soulSpeedVMeta.setDisplayName(ChatColor.GOLD + "Soul Speed V");
        soulSpeedVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        soulSpeedV.setItemMeta(soulSpeedVMeta);

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
        inventory.setItem(21, soulSpeedIII);
        inventory.setItem(22, soulSpeedIV);
        inventory.setItem(23, soulSpeedV);
        inventory.setItem(36, close);
    }
}
