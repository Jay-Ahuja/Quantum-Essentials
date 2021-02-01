package com.quantum.QuantumEssentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class kitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "(!) This command can only be executed by players!");
            return true;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("kit")) {
            if (args[0].equalsIgnoreCase("starter")) {
                PlayerInventory inv = player.getInventory();
                int firstEmpty = player.getInventory().firstEmpty();

                if (!player.hasPlayedBefore()) {
                    inv.addItem(new ItemStack(Material.STONE_SWORD, 1));
                    inv.addItem(new ItemStack(Material.STONE_PICKAXE, 1));
                    inv.addItem(new ItemStack(Material.STONE_AXE));
                    inv.addItem(new ItemStack(Material.STONE_SHOVEL, 1));
                    inv.addItem(new ItemStack(Material.COOKED_BEEF, 32));
                    inv.addItem(new ItemStack(Material.LEATHER_HELMET, 1));
                    inv.addItem(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
                    inv.addItem(new ItemStack(Material.LEATHER_LEGGINGS, 1));
                    inv.addItem(new ItemStack(Material.LEATHER_BOOTS, 1));
                    player.kickPlayer("Please Relog!");
                } else {
                    sender.sendMessage(ChatColor.RED + "(!) You don't have permission to use this command!");
                }
            }
        }
        return true;
    }
}
