package me.brekfst.tokenforge.commands;

import me.brekfst.tokenforge.TokenForge;
import me.brekfst.tokenforge.files.EnchantmentFile;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class ReloadConfigCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        // Check if the sender has the required permission, if applicable
        if (!commandSender.hasPermission("tokenforge.reloadconfig")) {
            commandSender.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            return true;
        }

        // Reload the plugin's config
        Plugin forge = TokenForge.getPlugin(TokenForge.class);
        forge.reloadConfig();
        // reload enchant point config
        EnchantmentFile.reload();
        commandSender.sendMessage(ChatColor.GREEN + "TokenForge configuration reloaded.");

        return true;
    }
}
