package me.brekfst.tokenforge.menusystem.menus.enchantmentmenus.meleeenchants;

import me.brekfst.tokenforge.managers.PointsManager;
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

public class LootingMenu extends Menu {

    private Map<Player, ItemStack> selectedTool;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments = new HashMap<>();

    public LootingMenu(PlayerMenuUtility playerMenuUtility) {
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
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "looting", 3);
                break;
            case 21:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "looting", 4);
                break;
            case 23:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "looting", 5);
                break;
            case 24:
                EnchantmentUtility.selectEnchantment(player, playerMenuUtility, "looting", 6);
                break;
            case 36:
                player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
                playerMenuUtility.getPreviousMenu().open();
                break;
        }
    }

    private void selectLooting(Player player, int level) {
        if (PointsManager.canAffordPoints(player, PointsManager.getEnchantmentPoints(Enchantment.LOOT_BONUS_MOBS, level))) {
            PointsManager.deductPoints(player, PointsManager.getEnchantmentPoints(Enchantment.LOOT_BONUS_MOBS, level));

            Map<Enchantment, Integer> selectedEnchantments = new HashMap<>(playerMenuUtility.getSelectedEnchantments());
            selectedEnchantments.put(Enchantment.LOOT_BONUS_MOBS, level);

            playerMenuUtility.setSelectedEnchantments(selectedEnchantments);

            player.playSound(player.getLocation(), "entity.player.levelup", 1, 1);
            player.sendMessage(ChatColor.GREEN + "You have selected Looting " + level + "!");

            int remainingPoints = PointsManager.getRemainingPoints(player);
            player.sendMessage(ChatColor.GOLD + "Remaining Points: " + remainingPoints);
        } else {
            player.sendMessage(ChatColor.RED + "You don't have enough points to select Looting " + level + "!");
        }
    }

    @Override
    public void setMenuItems() {

        // looting 3
        ItemStack lootingIII = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta lootingIIIMeta = lootingIII.getItemMeta();
        lootingIIIMeta.setDisplayName(ChatColor.GOLD + "Looting III");
        lootingIIIMeta.setLore(Arrays.asList(ChatColor.GRAY + "Free"));
        lootingIII.setItemMeta(lootingIIIMeta);

        // looting 4
        ItemStack lootingIV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta lootingIVMeta = lootingIV.getItemMeta();
        lootingIVMeta.setDisplayName(ChatColor.GOLD + "Looting IV");
        lootingIVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1000 Points"));
        lootingIV.setItemMeta(lootingIVMeta);

        // looting 5
        ItemStack lootingV = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta lootingVMeta = lootingV.getItemMeta();
        lootingVMeta.setDisplayName(ChatColor.GOLD + "Looting V");
        lootingVMeta.setLore(Arrays.asList(ChatColor.GRAY + "1250 Points"));
        lootingV.setItemMeta(lootingVMeta);

        // looting 6
        ItemStack lootingVI = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta lootingVIMeta = lootingVI.getItemMeta();
        lootingVIMeta.setDisplayName(ChatColor.GOLD + "Looting VI");
        lootingVIMeta.setLore(Arrays.asList(ChatColor.GRAY + "2000 Points"));
        lootingVI.setItemMeta(lootingVIMeta);

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
        inventory.setItem(20, lootingIII);
        inventory.setItem(21, lootingIV);
        inventory.setItem(23, lootingV);
        inventory.setItem(24, lootingVI);
        inventory.setItem(36, close);
    }
}
