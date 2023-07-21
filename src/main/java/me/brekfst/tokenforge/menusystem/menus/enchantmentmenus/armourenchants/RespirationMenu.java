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

public class RespirationMenu extends Menu {

    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public RespirationMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Respiration Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "respiration", 3);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "respiration", 4);
                break;
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "respiration", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "respiration", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // respiration III
        ItemStack respirationIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta respirationIIIMeta = respirationIII.getItemMeta();
        respirationIIIMeta.setDisplayName(ChatColor.GOLD + "Respiration III");
        respirationIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        respirationIII.setItemMeta(respirationIIIMeta);

        // respiration IV
        ItemStack respirationIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta respirationIVMeta = respirationIV.getItemMeta();
        respirationIVMeta.setDisplayName(ChatColor.GOLD + "Respiration IV");
        respirationIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "500 Points"));
        respirationIV.setItemMeta(respirationIVMeta);

        // respiration V
        ItemStack respirationV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta respirationVMeta = respirationV.getItemMeta();
        respirationVMeta.setDisplayName(ChatColor.GOLD + "Respiration V");
        respirationVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        respirationV.setItemMeta(respirationVMeta);

        // respiration VI
        ItemStack respirationVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta respirationVIMeta = respirationVI.getItemMeta();
        respirationVIMeta.setDisplayName(ChatColor.GOLD + "Respiration VI");
        respirationVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1250 Points"));
        respirationVI.setItemMeta(respirationVIMeta);

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
        inventory.setItem(20, respirationIII);
        inventory.setItem(21, respirationIV);
        inventory.setItem(23, respirationV);
        inventory.setItem(24, respirationVI);
        inventory.setItem(36, close);
    }
}
