package me.brekfst.tokenforge.managers;

import me.brekfst.tokenforge.menusystem.Menu;
import me.brekfst.tokenforge.utilitys.PlayerMenuUtility;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ToolMenuManager {

    private static final Map<Material, Function<PlayerMenuUtility, Menu>> toolMenus = new HashMap<>();

    public static Map<Material, Function<PlayerMenuUtility, Menu>> getToolMenus() {
        return toolMenus;
    }

    public static void openToolMenu(PlayerMenuUtility playerMenuUtility) {
        Player player = playerMenuUtility.getOwner();
        ItemStack selectedTool = playerMenuUtility.getSelectedTool();
        if (selectedTool == null) {
            player.sendMessage("Selected tool is null.");
            return;
        }

        Material toolMaterial = selectedTool.getType();
        Function<PlayerMenuUtility, Menu> menuFunction = toolMenus.get(toolMaterial);
        if (menuFunction != null) {
            player.sendMessage("Found menuFunction for tool: " + toolMaterial.name());
            Menu menu = menuFunction.apply(playerMenuUtility);
            if (menu == null) {
                player.sendMessage("Menu is null.");
                return;
            }
            player.sendMessage("Opening menu: " + menu.getClass().getSimpleName());
            player.playSound(player.getLocation(), "block.anvil.break", 1, 1);
            menu.open();
        } else {
            player.sendMessage("No menuFunction found for tool: " + toolMaterial.name());
        }
    }
}