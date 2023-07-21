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

public class ProjectileProtectionMenu extends Menu {

    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public ProjectileProtectionMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Projectile Protection!";
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "projectile protection", 4);
                break;
            case 22:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "projectile protection", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "projectile protection", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    @Override
    public void setMenuItems() {

        // projectile protection IV
        ItemStack projectileProtectionIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta projectileProtectionIVMeta = projectileProtectionIV.getItemMeta();
        projectileProtectionIVMeta.setDisplayName(ChatColor.GOLD + "Projectile Protection IV");
        projectileProtectionIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        projectileProtectionIV.setItemMeta(projectileProtectionIVMeta);

        // projectile protection V
        ItemStack projectileProtectionV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta projectileProtectionVMeta = projectileProtectionV.getItemMeta();
        projectileProtectionVMeta.setDisplayName(ChatColor.GOLD + "Projectile Protection V");
        projectileProtectionVMeta.setLore(Arrays.asList(ChatColor.GRAY + "750 Points"));
        projectileProtectionV.setItemMeta(projectileProtectionVMeta);

        // projectile protection VI
        ItemStack projectileProtectionVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta projectileProtectionVIMeta = projectileProtectionVI.getItemMeta();
        projectileProtectionVIMeta.setDisplayName(ChatColor.GOLD + "Projectile Protection VI");
        projectileProtectionVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        projectileProtectionVI.setItemMeta(projectileProtectionVIMeta);

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
        inventory.setItem(20, projectileProtectionIV);
        inventory.setItem(22, projectileProtectionV);
        inventory.setItem(24, projectileProtectionVI);
        inventory.setItem(36, close);
    }
}
