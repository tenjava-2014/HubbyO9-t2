package com.tenjava.entries.HubbyO9.t2.Listeners;

import com.tenjava.entries.HubbyO9.t2.TenJava;
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
						TenJava.manager.registerStorage(event.getClickedBlock().getLocation());
					}else if(event.getClickedBlock().getType().equals(Material.RAILS)){
						TenJava.manager.registerWire(event.getClickedBlock().getLocation());
					}else if(event.getClickedBlock().getType().equals(Material.DETECTOR_RAIL)){
						TenJava.manager.registerGenerator(event.getClickedBlock().getLocation());
					}
				}
			}
		}
	}
}
