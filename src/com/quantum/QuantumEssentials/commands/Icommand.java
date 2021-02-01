package com.quantum.QuantumEssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Icommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "(!) This command can only be executed by players!");
            return true;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("i")) {
            if (player.hasPermission("quantumessentials.i")) {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "(!) Please specify an item and amount!");
                    return true;

                } else if (args.length == 1) {
                    try {
                        Material.valueOf(args[0].toUpperCase());
                    } catch (IllegalArgumentException e) {
                        player.sendMessage(ChatColor.RED + "(!) That is not a valid type!");
                        return true;
                    }

                    int amt = 1;
                    ItemStack item = new ItemStack(Material.valueOf(args[0].toUpperCase()), amt);

                    player.getInventory().addItem(item);
                    player.sendMessage("§6(!) Given§c " + args[1] + " " + args[0] + "§6 to §c" + player.getName());

                } else if (args.length == 2) {
                    try {
                        Material.valueOf(args[0].toUpperCase());
                    } catch (IllegalArgumentException e) {
                        player.sendMessage(ChatColor.RED + "(!) That is not a valid type!");
                        return true;
                    }

                    int amt = Integer.parseInt(args[1]);
                    ItemStack item = new ItemStack(Material.valueOf(args[0].toUpperCase()), amt);

                    player.getInventory().addItem(item);
                    player.sendMessage("§6(!) Given§c " + args[1] + " " + args[0] + "§6 to §c" + player.getName());
                }
                
            } else {
                player.sendMessage(ChatColor.RED + "(!) You don't have permission to use this command!");
            }


        }

        return true;
    }

}
