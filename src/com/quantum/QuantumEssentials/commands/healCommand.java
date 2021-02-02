package com.quantum.QuantumEssentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class healCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "(!) This command can only be executed by players!");
            return true;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (player.hasPermission("quantumessentials.heal")) {
                player.setHealth(20);
                player.setSaturation(20.0f);
                player.sendMessage("§6Healed");
            } else {
                player.sendMessage(ChatColor.RED + "(!) You don't have permission to use this command!");
            }
        }

        return true;
    }
}
