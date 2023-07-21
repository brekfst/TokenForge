package me.brekfst.tokenforge.listeners;

import me.brekfst.tokenforge.menusystem.Menu;
import me.brekfst.tokenforge.utilitys.PlayerMenuUtility;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.InventoryHolder;

import java.lang.reflect.InvocationTargetException;

public class MenuListener implements Listener {

    PlayerMenuUtility playerMenuUtility;

    @EventHandler
    public void onMenuClick(InventoryClickEvent e)  {

        if (e.getClickedInventory() != null) {

            Player player = (Player) e.getWhoClicked();

            InventoryHolder holder = e.getClickedInventory().getHolder();

            if (holder instanceof Menu) {

                e.setCancelled(true);

                if (e.getCurrentItem() == null) {
                    return;
                }

                Menu menu = (Menu) holder;
                menu.handleMenu(e);

            }
        }
    }
}