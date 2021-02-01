package com.quantum.QuantumEssentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class statsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "(!) This command can only be executed by players!");
            return true;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("stats")) {
            double ticks_played = player.getStatistic(Statistic.PLAY_ONE_MINUTE);

            long hours_played = Math.round(ticks_played/20/60/60);

            player.sendMessage("§6                " + player.getName() + "'s Statistics:");
            player.sendMessage("§6Hours Played: §c" + String.valueOf(hours_played));
            player.sendMessage("§6Jumps: §c" + String.valueOf(player.getStatistic(Statistic.JUMP)));
            player.sendMessage("§6Players Killed: §c" + String.valueOf(player.getStatistic(Statistic.PLAYER_KILLS)));
            player.sendMessage("§6Deaths: §c" + String.valueOf(player.getStatistic(Statistic.DEATHS)));
            player.sendMessage("§6Mobs Kiled: §c" + String.valueOf(player.getStatistic(Statistic.MOB_KILLS)));
        }

        return true;
    }
}
