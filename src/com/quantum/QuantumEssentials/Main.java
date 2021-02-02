package com.quantum.QuantumEssentials;

import com.quantum.QuantumEssentials.commands.*;
import com.quantum.QuantumEssentials.events.PlayerJoinMessage;
import com.quantum.QuantumEssentials.events.PlayerLeaveMessage;
import com.quantum.QuantumEssentials.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		ItemManager.init();
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Quantum] Plugin activated");
		
		// Commands
		getCommand("sendcords").setExecutor(new SendCordsCommand());
		getCommand("msg").setExecutor(new MessageCommand());
		getCommand("broadcast").setExecutor(new BroadcastCommand());
		getCommand("i").setExecutor(new Icommand());
		getCommand("kit").setExecutor(new kitCommand());
		getCommand("stats").setExecutor(new statsCommand());
		getCommand("fly").setExecutor(new flyCommand());
		getCommand("feed").setExecutor(new feedCommand());
		getCommand("heal").setExecutor(new healCommand());

		// Events

		getServer().getPluginManager().registerEvents(new PlayerJoinMessage(), this);
		getServer().getPluginManager().registerEvents(new PlayerLeaveMessage(), this);
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Quantum] Plugin deactivated");
	}

}
