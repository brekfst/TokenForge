package me.brekfst.tokenforge;

import me.brekfst.tokenforge.commands.ReloadConfigCommand;
import me.brekfst.tokenforge.commands.TokenForgeCommand;
import me.brekfst.tokenforge.files.EnchantmentFile;
import me.brekfst.tokenforge.listeners.MenuListener;
import me.brekfst.tokenforge.managers.PointsManager;
import me.brekfst.tokenforge.utilitys.PlayerMenuUtility;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class TokenForge extends JavaPlugin {

    private PointsManager pointsManager;
    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();

    @Override
    public void onEnable() {

        // Config
        EnchantmentFile.setup();
        EnchantmentFile.setDefaultValues();

        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        // gui command
        getCommand("Forge").setExecutor(new TokenForgeCommand());
        // reload command
        getCommand("ForgeReload").setExecutor(new ReloadConfigCommand());

        getServer().getPluginManager().registerEvents(new MenuListener(), this);

    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player player) {
        return playerMenuUtilityMap.computeIfAbsent(player, PlayerMenuUtility::new);
    }
}