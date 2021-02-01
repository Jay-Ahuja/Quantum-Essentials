package com.quantum.QuantumEssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendCordsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "(!) This command can only be executed by players!");
            return true;
        }

        final Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("sendcords")) {

            final Location loc = player.getLocation(); // Player Location
            final String world = player.getWorld().getName(); // Player World Name
            final Player sendPlayer = Bukkit.getServer().getPlayer(args[0]); // Player to send message

            // Checking to see if player valid
            if (sendPlayer == null) {
                player.sendMessage(ChatColor.RED + "(!) That player isn't online! Try running this command when they're online!");
                return true;
            }

            // Getting player XYZ based on block

            final int intplayerx = loc.getBlockX();
            final int intplayery = loc.getBlockY();
            final int intplayerz = loc.getBlockZ();

            // Converting to strings to send to target player

            final String playerx = Integer.toString(intplayerx);
            final String playery = Integer.toString(intplayery);
            final String playerz = Integer.toString(intplayerz);

            // §
            // Sending confirmation message and cords


            player.sendMessage("§6(!) Successfully sent your cords to §c" + sendPlayer.getName());
            sendPlayer.sendMessage("§6(!)§c " + player.getName() + "§6 is in The§c " + world + "§6 at cords§c " + playerx + "§6,§c " + playery + "§6,§c " + playerz);

        }
        return true;
    }
}
