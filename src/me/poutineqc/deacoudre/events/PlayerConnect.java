package me.poutineqc.deacoudre.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.poutineqc.deacoudre.DeACoudre;
import me.poutineqc.deacoudre.instances.GameState;

public class PlayerConnect implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		
		if(DeACoudre.getPlugin().getConfig().getBoolean("bungeecord") == true){
			
			
		}else {
			event.setJoinMessage("Nop");
		}
	}
}
