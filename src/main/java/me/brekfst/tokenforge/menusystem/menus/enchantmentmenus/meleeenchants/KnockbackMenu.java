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

public class KnockbackMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public KnockbackMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
        this.selectedTool = new HashMap<>();
        this.selectedEnchantments = new HashMap<>();
    }

    @Override
    public String getMenuName() {
        return "Looting Enchantments!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "knockback", 2);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "knockback", 3);
                break;
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "knockback", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "knockback", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "knockback", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // knockback II
        ItemStack knockbackII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta knockbackIIMeta = knockbackII.getItemMeta();
        knockbackIIMeta.setDisplayName(ChatColor.GOLD + "Knockback II");
        knockbackIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        knockbackII.setItemMeta(knockbackIIMeta);

        // knockback III
        ItemStack knockbackIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta knockbackIIIMeta = knockbackIII.getItemMeta();
        knockbackIIIMeta.setDisplayName(ChatColor.GOLD + "Knockback III");
        knockbackIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        knockbackIII.setItemMeta(knockbackIIIMeta);

        // knockback IV
        ItemStack knockbackIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta knockbackIVMeta = knockbackIV.getItemMeta();
        knockbackIVMeta.setDisplayName(ChatColor.GOLD + "Knockback IV");
        knockbackIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        knockbackIV.setItemMeta(knockbackIVMeta);

        // knockback V
        ItemStack knockbackV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta knockbackVMeta = knockbackV.getItemMeta();
        knockbackVMeta.setDisplayName(ChatColor.GOLD + "Knockback V");
        knockbackVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1250 Points"));
        knockbackV.setItemMeta(knockbackVMeta);

        // knockback VI
        ItemStack knockbackVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta knockbackVIMeta = knockbackVI.getItemMeta();
        knockbackVIMeta.setDisplayName(ChatColor.GOLD + "Knockback VI");
        knockbackVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1500 Points"));
        knockbackVI.setItemMeta(knockbackVIMeta);


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
        inventory.setItem(20, knockbackII);
        inventory.setItem(21, knockbackIII);
        inventory.setItem(22, knockbackIV);
        inventory.setItem(23, knockbackV);
        inventory.setItem(24, knockbackVI);
        inventory.setItem(36, close);
    }
}
