package me.brekfst.tokenforge.utilitys;

import me.brekfst.tokenforge.managers.PointsManager;
import me.brekfst.tokenforge.menusystem.Menu;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class PlayerMenuUtility {

    private Player owner;
    private ItemStack selectedTool;
    private Menu previousMenu;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments;

    public PlayerMenuUtility(Player owner) {
        this.owner = owner;
        this.selectedTool = null;
        this.selectedEnchantments = new HashMap<>();
    }

    public Player getOwner() {
        return owner;
    }

    public ItemStack getSelectedTool() {
        return selectedTool;
    }

    public void setSelectedTool(ItemStack selectedTool) {
        this.selectedTool = selectedTool;
    }

    public void removeSelectedTool() {
        selectedTool = null;
    }

    public Map<Enchantment, Integer> getSelectedEnchantments() {
        return selectedEnchantments.getOrDefault(owner, new HashMap<>());
    }

    public void setSelectedEnchantments(Map<Enchantment, Integer> enchantments) {
        selectedEnchantments.put(owner, enchantments);
    }

    public Menu getPreviousMenu() {
        return previousMenu;
    }

    public void setPreviousMenu(Menu previousMenu) {
        this.previousMenu = previousMenu;
    }

    public void clearPlayerData() {
        selectedEnchantments.remove(owner);
        PointsManager.removePlayerPoints(owner);
        removeSelectedTool();
    }
}