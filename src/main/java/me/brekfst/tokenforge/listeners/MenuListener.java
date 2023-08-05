package me.brekfst.tokenforge.listeners;

import me.brekfst.tokenforge.TokenForge;
import me.brekfst.tokenforge.menusystem.Menu;
import me.brekfst.tokenforge.menusystem.menus.renamemenu.RenameMenu;
import me.brekfst.tokenforge.utilitys.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
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

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
        if (playerMenuUtility != null && playerMenuUtility.getOwner().equals(player)) {
            if (!playerMenuUtility.isSettingCustomLore() && !playerMenuUtility.isSettingCustomName()) {
                return;
            }

            e.setCancelled(true);

            String input = e.getMessage();

            if (playerMenuUtility.isSettingCustomLore()) {
                // Player is setting the lore
                playerMenuUtility.setCustomLore(input);
                player.sendMessage("Item lore updated to " + input);
                playerMenuUtility.setSettingCustomLore(false);
            } else if (playerMenuUtility.isSettingCustomName()) {
                // Player is setting the name
                playerMenuUtility.setCustomName(input);
                player.sendMessage("Item renamed to " + input);
                playerMenuUtility.setSettingCustomName(false);
            }

            TokenForge plugin = TokenForge.getPlugin(TokenForge.class);
            Bukkit.getScheduler().runTask(plugin, () -> {
                RenameMenu renameMenu = (RenameMenu) playerMenuUtility.getCurrentMenu();
                renameMenu.open();
            });
        }
    }
}