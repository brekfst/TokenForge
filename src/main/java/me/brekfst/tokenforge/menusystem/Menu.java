package me.brekfst.tokenforge.menusystem;

import me.brekfst.tokenforge.utilitys.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.lang.reflect.InvocationTargetException;

public abstract class Menu implements InventoryHolder {

    protected Inventory inventory;
    protected PlayerMenuUtility playerMenuUtility;
    protected Menu previousMenu;

    public Menu(PlayerMenuUtility playerMenuUtility) {
        this.playerMenuUtility = playerMenuUtility;
        this.previousMenu = null;
    }

    public void setPreviousMenu(Menu previousMenu) {
        this.previousMenu = previousMenu;
    }

    // Implement the back functionality
    public void goBack() {
        if (previousMenu != null) {
            previousMenu.open(); // Open the previous menu
        }
    }

    public abstract String getMenuName();
    public abstract int getSlots();
    public abstract void handleMenu(InventoryClickEvent event);

    public abstract void setMenuItems();

    public void open() {
        inventory = Bukkit.createInventory(this, getSlots(), getMenuName());

        this.setMenuItems();

        playerMenuUtility.getOwner().openInventory(inventory);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

}