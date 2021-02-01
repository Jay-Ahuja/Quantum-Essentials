package com.quantum.QuantumEssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "(!) This command can only be executed by players!");
            return true;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("msg")) {

            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "(!) Please input a username and message!");
                return true;

            } else if (args.length == 1) {
                sender.sendMessage(ChatColor.RED + "(!) Please input a message!");
                return true;

            } else {
                try {
                    Bukkit.getServer().getPlayer(args[0]);
                } catch (NullPointerException e) {
                    player.sendMessage(ChatColor.RED + "(!) That player either isn't online or doesn't exist!");
                    return true;
                }

                final Player sendPlayer = Bukkit.getServer().getPlayer(args[0]); // Player to send message
                String message = ""; // Message to send to playerToSend

                for (int i = 1; i < args.length; i++) {
                    String arg = (args[i] + " ");
                    message = (message + arg);
                }

                player.sendMessage("§6(!)§c You --> " + sendPlayer.getName() + "§6: " + message);
                sendPlayer.sendMessage("§6(!)§c " + player.getName() + " --> " + "You§6: " + message);

            }


            return true;
        }

        return true;
    }
}

