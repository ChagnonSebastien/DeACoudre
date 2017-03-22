package me.poutineqc.deacoudre.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.poutineqc.deacoudre.DeACoudre;
import me.poutineqc.deacoudre.Language;
import me.poutineqc.deacoudre.PlayerData;
import me.poutineqc.deacoudre.instances.Arena;
import me.poutineqc.deacoudre.instances.User;

public class PlayerConnect implements Listener{

	private DeACoudre plugin;
	private PlayerData playerData;
	
	public PlayerConnect(DeACoudre plugin){
		this.playerData = plugin.getPlayerData();
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		
		if(DeACoudre.getPlugin().getConfig().getBoolean("bungeecord.enabled") == true){	
			
			Language local = playerData.getLanguageOfPlayer(player);
			
			event.setJoinMessage("");
			for(Player allplayer : Bukkit.getOnlinePlayers()){
			local.sendMsg(allplayer, local.joinGameOthers.replace("%player%", player.getName())
					.replace("%amountInGame%", String.valueOf(Bukkit.getOnlinePlayers().size())));
			}
			
			Arena arena = Arena.getArenaFromPlayer(player);
			
			arena = Arena.getArenaFromName(DeACoudre.getPlugin().getConfig().getString("bungeecord.arenaName"));
			if (arena == null) {
				local.sendMsg(player, local.errorArenaNotExist.replace("%arena%", DeACoudre.getPlugin().getConfig().getString("bungeecord.arenaName")));
				return;
			}

			arena.addPlayerToTeam(player, true);

		}else {
			
		}
	}
}
