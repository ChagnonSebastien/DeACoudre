package me.poutineqc.deacoudre.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.poutineqc.deacoudre.DeACoudre;
import me.poutineqc.deacoudre.Language;
import me.poutineqc.deacoudre.PlayerData;

public class PlayerConnect implements Listener{

	private DeACoudre plugin;
	private PlayerData playerData;
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		
		if(DeACoudre.getPlugin().getConfig().getBoolean("bungeecord") == true){
			
			
			Language localInstance = playerData.getLanguageOfPlayer(player.getPlayer());
			
			event.setJoinMessage(localInstance.joinGameOthers.replace("%player%", player.getCustomName()));

		}else {
			
		}
	}
}
