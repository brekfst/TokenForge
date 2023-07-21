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

public class FireAspectMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public FireAspectMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
        this.selectedTool = new HashMap<>();
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "fire aspect", 2);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "fire aspect", 3);
                break;
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "fire aspect", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "fire aspect", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "fire aspect", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }


    @Override
    public void setMenuItems() {

        // fire aspect 2
        ItemStack fireaspectII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fireaspectIIMeta = fireaspectII.getItemMeta();
        fireaspectIIMeta.setDisplayName(ChatColor.GOLD + "Fire Aspect II");
        fireaspectIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        fireaspectII.setItemMeta(fireaspectIIMeta);

        // fire aspect 3
        ItemStack fireaspectIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fireaspectIIIMeta = fireaspectIII.getItemMeta();
        fireaspectIIIMeta.setDisplayName(ChatColor.GOLD + "Fire Aspect III");
        fireaspectIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "500 Points"));
        fireaspectIII.setItemMeta(fireaspectIIIMeta);

        // fire aspect 4
        ItemStack fireaspectIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fireaspectIVMeta = fireaspectIV.getItemMeta();
        fireaspectIVMeta.setDisplayName(ChatColor.GOLD + "Fire Aspect IV");
        fireaspectIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        fireaspectIV.setItemMeta(fireaspectIVMeta);

        // fire aspect 5
        ItemStack fireaspectV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fireaspectVMeta = fireaspectV.getItemMeta();
        fireaspectVMeta.setDisplayName(ChatColor.GOLD + "Fire Aspect V");
        fireaspectVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        fireaspectV.setItemMeta(fireaspectVMeta);

        // fire aspect 6
        ItemStack fireaspectVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fireaspectVIMeta = fireaspectVI.getItemMeta();
        fireaspectVIMeta.setDisplayName(ChatColor.GOLD + "Fire Aspect VI");
        fireaspectVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1300 Points"));
        fireaspectVI.setItemMeta(fireaspectVIMeta);

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
        inventory.setItem(20, fireaspectII);
        inventory.setItem(21, fireaspectIII);
        inventory.setItem(22, fireaspectIV);
        inventory.setItem(23, fireaspectV);
        inventory.setItem(24, fireaspectVI);
        inventory.setItem(36, close);
    }
}
