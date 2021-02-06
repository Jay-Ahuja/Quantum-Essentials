package com.quantum.QuantumEssentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;



public class todoCommand implements CommandExecutor {

    private ArrayList<String> todo_list = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;


        if (cmd.getName().equalsIgnoreCase("todo")) {
            if (player.hasPermission("quantumessentials.todo")) {
                if (args.length == 0) {
                    // Loops through all contents of todo_list and sends it to player.
                    for (String message : todo_list) {
                        player.sendMessage(message);
                    }


                } else if (args[0].equalsIgnoreCase("add")) {
                    String message = ""; // Message to add to ArrayList with messages.

                    for (int i = 1; i < args.length; i++) {
                        String arg = (args[i] + " ");
                        message = (message + arg);
                    }

                    todo_list.add(message);
                    player.sendMessage("Added Message: " + message);

                } else if (args[0].equalsIgnoreCase("remove")) {
                    int message_remove = Integer.parseInt(args[1]) - 1;
                    player.sendMessage("Removed message: " + todo_list.get(message_remove));
                    todo_list.remove(message_remove);

                }

            }
        }
        return true;
    }
}
