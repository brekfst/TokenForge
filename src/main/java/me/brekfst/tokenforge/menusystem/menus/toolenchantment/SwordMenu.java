package me.brekfst.tokenforge.menusystem.menus.toolenchantment;

import me.brekfst.tokenforge.managers.PointsManager;
import me.brekfst.tokenforge.menusystem.Menu;
import me.brekfst.tokenforge.menusystem.menus.confirmationmenu.ConfirmationMenu;
import me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.generalenchants.MendingMenu;
import me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.generalenchants.UnbreakingMenu;
import me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.meleeenchants.*;
import me.brekfst.tokenforge.menusystem.menus.toolmenu.ToolMenu;
import me.brekfst.tokenforge.utilitys.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import javax.tools.Tool;
import java.util.Arrays;

public class SwordMenu extends Menu {

    public SwordMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Sword Enchantments!";
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
            case 4:
                // points remaining
                break;
            case 12:
                new MendingMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 13:
                new UnbreakingMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 14:
                new SharpnessMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 20:
                new KnockbackMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 21:
                new FireAspectMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 22:
                new LootingMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 23:
                new SweepingEdgeMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 24:
                new SmiteMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 31:
                new BaneOfArthropodsMenu(playerMenuUtility).open();
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

        // sharpness
        ItemStack sharpness = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta sharpnessMeta = sharpness.getItemMeta();
        sharpnessMeta.setDisplayName(ChatColor.GOLD + "Sharpness");
        sharpnessMeta.setLore(Arrays.asList(ChatColor.GRAY + "Sharpness"));
        sharpness.setItemMeta(sharpnessMeta);

        // knockback
        ItemStack knockback = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta knockbackMeta = knockback.getItemMeta();
        knockbackMeta.setDisplayName(ChatColor.GOLD + "Knockback");
        knockbackMeta.setLore(Arrays.asList(ChatColor.GRAY + "Knockback"));
        knockback.setItemMeta(knockbackMeta);

        // fire aspect
        ItemStack fireAspect = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fireAspectMeta = fireAspect.getItemMeta();
        fireAspectMeta.setDisplayName(ChatColor.GOLD + "Fire Aspect");
        fireAspectMeta.setLore(Arrays.asList(ChatColor.GRAY + "Fire Aspect"));
        fireAspect.setItemMeta(fireAspectMeta);

        // looting
        ItemStack looting = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta lootingMeta = looting.getItemMeta();
        lootingMeta.setDisplayName(ChatColor.GOLD + "Looting");
        lootingMeta.setLore(Arrays.asList(ChatColor.GRAY + "Looting"));
        looting.setItemMeta(lootingMeta);

        // sweeping edge
        ItemStack sweepingEdge = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta sweepingEdgeMeta = sweepingEdge.getItemMeta();
        sweepingEdgeMeta.setDisplayName(ChatColor.GOLD + "Sweeping Edge");
        sweepingEdgeMeta.setLore(Arrays.asList(ChatColor.GRAY + "Sweeping Edge"));
        sweepingEdge.setItemMeta(sweepingEdgeMeta);

        // smite
        ItemStack smite = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta smiteMeta = smite.getItemMeta();
        smiteMeta.setDisplayName(ChatColor.GOLD + "Smite");
        smiteMeta.setLore(Arrays.asList(ChatColor.GRAY + "Smite"));
        smite.setItemMeta(smiteMeta);

        // bane of arthropods
        ItemStack bane = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta baneMeta = bane.getItemMeta();
        baneMeta.setDisplayName(ChatColor.GOLD + "Bane of Arthropods");
        baneMeta.setLore(Arrays.asList(ChatColor.GRAY + "Bane of Arthropods"));
        bane.setItemMeta(baneMeta);

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
        inventory.setItem(12, mending);
        inventory.setItem(13, unbreaking);
        inventory.setItem(14, sharpness);
        inventory.setItem(20, knockback);
        inventory.setItem(21, fireAspect);
        inventory.setItem(22, looting);
        inventory.setItem(23, sweepingEdge);
        inventory.setItem(24, smite);
        inventory.setItem(31, bane);
        inventory.setItem(36, close);
        inventory.setItem(40, confirm);
        inventory.setItem(44, reset);

    }
}
