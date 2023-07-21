package me.brekfst.tokenforge.menusystem.menus.toolenchantment;

import me.brekfst.tokenforge.managers.PointsManager;
import me.brekfst.tokenforge.menusystem.Menu;
import me.brekfst.tokenforge.menusystem.menus.confirmationmenu.ConfirmationMenu;
import me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.armourenchants.*;
import me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.generalenchants.MendingMenu;
import me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.generalenchants.UnbreakingMenu;
import me.brekfst.tokenforge.menusystem.menus.toolmenu.ToolMenu;
import me.brekfst.tokenforge.utilitys.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class ChestplateMenu extends Menu {

    public ChestplateMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Chestplate Enchantments";
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
            case 4:
                // points remaining
                break;
            case 19:
                new MendingMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 20:
                new UnbreakingMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 21:
                new ProtectionMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 22:
                new FireProtectionMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 23:
                new BlastProtectionMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 24:
                new ProjectileProtectionMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 25:
                new ThornsMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 36:
                new ToolMenu(playerMenuUtility).open();
                playerMenuUtility.clearPlayerData();
                break;
            case 40:
                new ConfirmationMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 44:
                playerMenuUtility.clearPlayerData();
                new ToolMenu(playerMenuUtility).open();
                break;
        }

    }

    @Override
    public void setMenuItems() {

        Player player = playerMenuUtility.getOwner();

        // mending
        ItemStack mending = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta mendingMeta = mending.getItemMeta();
        mendingMeta.setDisplayName(ChatColor.GOLD + "Mending");
        mendingMeta.setLore(Arrays.asList(ChatColor.GRAY + "Mending"));
        mending.setItemMeta(mendingMeta);

        // unbreaking
        ItemStack unbreaking = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta unbreakingMeta = unbreaking.getItemMeta();
        unbreakingMeta.setDisplayName(ChatColor.GOLD + "Unbreaking");
        unbreakingMeta.setLore(Arrays.asList(ChatColor.GRAY + "Unbreaking"));
        unbreaking.setItemMeta(unbreakingMeta);

        // protection
        ItemStack protection = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta protectionMeta = protection.getItemMeta();
        protectionMeta.setDisplayName(ChatColor.GOLD + "Protection");
        protectionMeta.setLore(Arrays.asList(ChatColor.GRAY + "Protection"));
        protection.setItemMeta(protectionMeta);

        // fire protection
        ItemStack fireProtection = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fireProtectionMeta = fireProtection.getItemMeta();
        fireProtectionMeta.setDisplayName(ChatColor.GOLD + "Fire Protection");
        fireProtectionMeta.setLore(Arrays.asList(ChatColor.GRAY + "Fire Protection"));
        fireProtection.setItemMeta(fireProtectionMeta);

        // blast protection
        ItemStack blastProtection = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta blastProtectionMeta = blastProtection.getItemMeta();
        blastProtectionMeta.setDisplayName(ChatColor.GOLD + "Blast Protection");
        blastProtectionMeta.setLore(Arrays.asList(ChatColor.GRAY + "Blast Protection"));
        blastProtection.setItemMeta(blastProtectionMeta);

        // projectile protection
        ItemStack projectileProtection = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta projectileProtectionMeta = projectileProtection.getItemMeta();
        projectileProtectionMeta.setDisplayName(ChatColor.GOLD + "Projectile Protection");
        projectileProtectionMeta.setLore(Arrays.asList(ChatColor.GRAY + "Projectile Protection"));
        projectileProtection.setItemMeta(projectileProtectionMeta);

        // thorns
        ItemStack thorns = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta thornsMeta = thorns.getItemMeta();
        thornsMeta.setDisplayName(ChatColor.GOLD + "Thorns");
        thornsMeta.setLore(Arrays.asList(ChatColor.GRAY + "Thorns"));
        thorns.setItemMeta(thornsMeta);

        // reset
        ItemStack reset = new ItemStack(Material.MAP);
        ItemMeta resetMeta = reset.getItemMeta();
        resetMeta.setDisplayName(ChatColor.RED + "Reset");
        resetMeta.setLore(Arrays.asList(ChatColor.GRAY + "Restart"));
        reset.setItemMeta(resetMeta);

        // points remaining
        ItemStack pointsRemaining = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta pointsRemainingMeta = (SkullMeta) pointsRemaining.getItemMeta();
        pointsRemainingMeta.setDisplayName(ChatColor.GOLD + "Your Points: " + ChatColor.GREEN + PointsManager.getRemainingPoints(player));
        pointsRemainingMeta.setOwningPlayer(player);
        pointsRemaining.setItemMeta(pointsRemainingMeta);

        // confirm
        ItemStack confirm = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta confirmMeta = confirm.getItemMeta();
        confirmMeta.setDisplayName(ChatColor.GREEN + "Confirm");
        confirmMeta.setLore(Arrays.asList(ChatColor.GRAY + "Confirm"));
        confirm.setItemMeta(confirmMeta);

        // close
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        closeMeta.setLore(Arrays.asList(ChatColor.GRAY + "Close"));
        close.setItemMeta(closeMeta);

        //frame
        ItemStack frame = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 17, 26, 35, 44, 43, 42, 41, 40, 39, 38, 37, 27, 18, 9, 0}) {
            inventory.setItem(i, frame);
        }

        inventory.setItem(4, pointsRemaining);
        inventory.setItem(19, mending);
        inventory.setItem(20, unbreaking);
        inventory.setItem(21, protection);
        inventory.setItem(22, fireProtection);
        inventory.setItem(23, blastProtection);
        inventory.setItem(24, projectileProtection);
        inventory.setItem(25, thorns);
        inventory.setItem(36, close);
        inventory.setItem(40, confirm);
        inventory.setItem(44, reset);

    }
}
