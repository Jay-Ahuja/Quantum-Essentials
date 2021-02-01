package com.quantum.QuantumEssentials.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveMessage implements Listener {

    @EventHandler

    public static void onLeave(PlayerQuitEvent event) {
        Player player = (Player) event.getPlayer();

        String message = "§7[§c-§7] " + player.getName();

        event.setQuitMessage(message);
    }
}
