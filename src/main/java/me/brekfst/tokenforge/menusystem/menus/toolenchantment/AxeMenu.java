package me.brekfst.tokenforge.menusystem.menus.toolenchantment;

import me.brekfst.tokenforge.managers.PointsManager;
import me.brekfst.tokenforge.menusystem.Menu;
import me.brekfst.tokenforge.menusystem.menus.confirmationmenu.ConfirmationMenu;
import me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.generalenchants.MendingMenu;
import me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.generalenchants.UnbreakingMenu;
import me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.meleeenchants.BaneOfArthropodsMenu;
import me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.meleeenchants.SharpnessMenu;
import me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.meleeenchants.SmiteMenu;
import me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.toolenchants.EfficiencyMenu;
import me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.toolenchants.FortuneMenu;
import me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.toolenchants.SilkTouchMenu;
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

public class AxeMenu extends Menu {


    public AxeMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Axe Enchantments!";
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
                new EfficiencyMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 20:
                new SharpnessMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 21:
                new FortuneMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 22:
                new SilkTouchMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 23:
                new SmiteMenu(playerMenuUtility).open();
                playerMenuUtility.setPreviousMenu(this);
                break;
            case 24:
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

        // efficiency
        ItemStack efficiency = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta efficiencyMeta = efficiency.getItemMeta();
        efficiencyMeta.setDisplayName(ChatColor.GOLD + "Efficiency");
        efficiencyMeta.setLore(Arrays.asList(ChatColor.GRAY + "Efficiency"));
        efficiency.setItemMeta(efficiencyMeta);

        // sharpness
        ItemStack sharpness = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta sharpnessMeta = sharpness.getItemMeta();
        sharpnessMeta.setDisplayName(ChatColor.GOLD + "Sharpness");
        sharpnessMeta.setLore(Arrays.asList(ChatColor.GRAY + "Sharpness"));
        sharpness.setItemMeta(sharpnessMeta);

        // fortune
        ItemStack fortune = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fortuneMeta = fortune.getItemMeta();
        fortuneMeta.setDisplayName(ChatColor.GOLD + "Fortune");
        fortuneMeta.setLore(Arrays.asList(ChatColor.GRAY + "Fortune"));
        fortune.setItemMeta(fortuneMeta);

        // silk touch
        ItemStack silk = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta silkMeta = silk.getItemMeta();
        silkMeta.setDisplayName(ChatColor.GOLD + "Silk Touch");
        silkMeta.setLore(Arrays.asList(ChatColor.GRAY + "Silk Touch"));
        silk.setItemMeta(silkMeta);

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

        // close
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        closeMeta.setLore(Arrays.asList(ChatColor.GRAY + "Close"));
        close.setItemMeta(closeMeta);

        // points remaining
        ItemStack pointsRemaining = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta pointsRemainingMeta = (SkullMeta) pointsRemaining.getItemMeta();
        pointsRemainingMeta.setDisplayName(ChatColor.GOLD + "Your Points: " + ChatColor.GREEN + PointsManager.getRemainingPoints(player));
        pointsRemainingMeta.setOwningPlayer(player);
        pointsRemaining.setItemMeta(pointsRemainingMeta);

        // reset
        ItemStack reset = new ItemStack(Material.MAP);
        ItemMeta resetMeta = reset.getItemMeta();
        resetMeta.setDisplayName(ChatColor.RED + "Reset");
        resetMeta.setLore(Arrays.asList(ChatColor.GRAY + "Restart"));
        reset.setItemMeta(resetMeta);

        // confirm
        ItemStack confirm = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta confirmMeta = confirm.getItemMeta();
        confirmMeta.setDisplayName(ChatColor.GREEN + "Confirm");
        confirmMeta.setLore(Arrays.asList(ChatColor.GRAY + "Confirm"));
        confirm.setItemMeta(confirmMeta);

        //frame
        ItemStack frame = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 17, 26, 35, 44, 43, 42, 41, 40, 39, 38, 37, 27, 18, 9, 0}) {
            inventory.setItem(i, frame);
        }

        inventory.setItem(4, pointsRemaining);
        inventory.setItem(12, mending);
        inventory.setItem(13, unbreaking);
        inventory.setItem(14, efficiency);
        inventory.setItem(20, sharpness);
        inventory.setItem(21, fortune);
        inventory.setItem(22, silk);
        inventory.setItem(23, smite);
        inventory.setItem(24, bane);
        inventory.setItem(36, close);
        inventory.setItem(40, confirm);
        inventory.setItem(44, reset);

    }
}
