package com.quantum.QuantumEssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("broadcast")) {
            if (player.hasPermission("quantumessentials.broadcast")) {

                String message = "";
                for (int i = 0; i < args.length; i++) {
                    String arg = (args[i] + " ");
                    message = (message + arg);

                }

                Bukkit.broadcastMessage(ChatColor.RED + "(!) " + message);


            } else {
                player.sendMessage(ChatColor.RED + "(!) You don't have permission to use this command!");
            }
        }

        return true;
    }
}
