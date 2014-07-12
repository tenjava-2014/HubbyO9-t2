package com.tenjava.entries.HubbyO9.t2.Listeners;

import com.tenjava.entries.HubbyO9.t2.TenJava;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		if(event.getItem() != null && event.getClickedBlock() != null){
			if(event.getAction().equals(Action.LEFT_CLICK_BLOCK)){
				if(event.getItem().getType().equals(Material.BLAZE_ROD)){
					if(event.getClickedBlock().getType().equals(Material.CHEST)){
						if(TenJava.manager.storageExists(event.getClickedBlock().getLocation())){
							TenJava.manager.unregisterStorage(event.getClickedBlock().getLocation());
							event.getPlayer().sendMessage(ChatColor.BLUE + "Unregistered Energy Storage.");
						}else {
							TenJava.manager.registerStorage(event.getClickedBlock().getLocation());
							event.getPlayer().sendMessage(ChatColor.BLUE + "Registered Energy Storage.");
						}
					}else if(event.getClickedBlock().getType().equals(Material.DAYLIGHT_DETECTOR)){
						if(TenJava.manager.generatorExists(event.getClickedBlock().getLocation())){
							TenJava.manager.unregisterGenerator(event.getClickedBlock().getLocation());
							event.getPlayer().sendMessage(ChatColor.BLUE + "Unregistered Energy Generator.");
						}else {
							event.getPlayer().sendMessage(ChatColor.BLUE + "Registered Energy Generator.");
							TenJava.manager.registerGenerator(event.getClickedBlock().getLocation());
						}
					}else if(event.getClickedBlock().getType().equals(Material.REDSTONE_COMPARATOR)){
						if(TenJava.manager.relayExists(event.getClickedBlock().getLocation())) {
							TenJava.manager.unregisterRelay(event.getClickedBlock().getLocation());
							event.getPlayer().sendMessage(ChatColor.BLUE + "Unregistered Energy Relay.");
						}else{
							TenJava.manager.registerRelay(event.getClickedBlock().getLocation());
							event.getPlayer().sendMessage(ChatColor.BLUE + "Registered Energy Relay.");
						}
					}
				}
			}
		}
	}
}
