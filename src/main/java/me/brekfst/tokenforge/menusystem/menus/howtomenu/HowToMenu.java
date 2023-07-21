package me.brekfst.tokenforge.menusystem.menus.howtomenu;

import me.brekfst.tokenforge.menusystem.Menu;
import me.brekfst.tokenforge.menusystem.menus.toolmenu.ToolMenu;
import me.brekfst.tokenforge.utilitys.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class HowToMenu extends Menu {

    public HowToMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "How to use TokenForge";
    }

    @Override
    public int getSlots() {
        return 45;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        int slot = event.getRawSlot();

        switch (slot) {
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                new ToolMenu(playerMenuUtility).open();
        }

    }

    @Override
    public void setMenuItems() {

        // tool menu
        ItemStack toolMenu = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta toolMenuMeta = toolMenu.getItemMeta();
        toolMenuMeta.setDisplayName(ChatColor.GOLD + "Tool Menu");
        toolMenuMeta.setLore(Arrays.asList(ChatColor.GRAY + "Tool Menu: ",
                ChatColor.GRAY + "Select the tool you want to enchant.")
        );
        toolMenu.setItemMeta(toolMenuMeta);

        // enchantment menu
        ItemStack enchantmentMenu = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta enchantmentMenuMeta = enchantmentMenu.getItemMeta();
        enchantmentMenuMeta.setDisplayName(ChatColor.GOLD + "Enchantment Menu");
        enchantmentMenuMeta.setLore(Arrays.asList(ChatColor.GRAY + "Enchantment Menu: ",
                ChatColor.GRAY + "Select your desired enchantments ",
                ChatColor.GRAY + "You have 5000 points to spend on enchantments.",
                ChatColor.GRAY + "To unselect an enchantment click the book again" ));
        enchantmentMenu.setItemMeta(enchantmentMenuMeta);

        // confirmation menu
        ItemStack confirmationMenu = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta confirmationMenuMeta = confirmationMenu.getItemMeta();
        confirmationMenuMeta.setDisplayName(ChatColor.GOLD + "Confirmation Menu");
        confirmationMenuMeta.setLore(Arrays.asList(ChatColor.GRAY + "Confirmation Menu: ",
                ChatColor.GRAY + "Hover over your tool and make sure its what you want. ",
                ChatColor.GRAY + "If it is, click the green pane to confirm. ",
                ChatColor.GRAY + "If not, click the red pane to go back." ));
        confirmationMenu.setItemMeta(confirmationMenuMeta);

        // close
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        // frame
        ItemStack frame = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 17, 26, 35, 44, 43, 42, 41, 40, 39, 38, 37, 27, 18, 9, 0}) {
            inventory.setItem(i, frame);
        }

        inventory.setItem(20, toolMenu);
        inventory.setItem(22, enchantmentMenu);
        inventory.setItem(24, confirmationMenu);
        inventory.setItem(36, close);

    }

}
