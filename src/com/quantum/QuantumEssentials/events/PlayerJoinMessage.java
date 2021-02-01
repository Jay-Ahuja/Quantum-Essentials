package com.quantum.QuantumEssentials.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinMessage implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        String message = "§7[§a+§7] " + player.getName();
        event.setJoinMessage(message);
        
    }

}
