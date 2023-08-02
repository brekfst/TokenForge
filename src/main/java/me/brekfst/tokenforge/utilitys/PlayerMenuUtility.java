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
    private String customName;
    private String customLore;
    private ItemStack selectedTool;
    private Menu previousMenu;
    private Menu currentMenu;
    private Map<Player, Map<Enchantment, Integer>> selectedEnchantments;

    public PlayerMenuUtility(Player owner) {
        this.owner = owner;
        this.selectedTool = null;
        this.selectedEnchantments = new HashMap<>();
        this.customName = "";
        this.customLore = "";
    }

    private boolean settingCustomLore = false;

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

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void setPreviousMenu(Menu previousMenu) {
        this.previousMenu = previousMenu;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getCustomLore() {
        return customLore;
    }

    public void setCustomLore(String customLore) {
        this.customLore = customLore;
    }

    public void clearCustomLore () {
        this.customLore = "";
    }

    public void clearCustomName () {
        this.customName = "";
    }

    public boolean isSettingCustomLore() {
        return settingCustomLore;
    }

    public void setSettingCustomLore(boolean settingCustomLore) {
        this.settingCustomLore = settingCustomLore;
    }

    public void clearPlayerData() {
        removeSelectedTool();
        selectedEnchantments.remove(owner);
        PointsManager.removePlayerPoints(owner);
        clearCustomName();
        clearCustomLore();
    }
}