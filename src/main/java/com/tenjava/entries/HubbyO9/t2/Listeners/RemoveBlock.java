package com.tenjava.entries.HubbyO9.t2.Listeners;


import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class RemoveBlock implements Listener {

	@EventHandler
	public void onBlockRemove(BlockBreakEvent event){
		if(event.getBlock().getType().equals(Material.RAILS)){

		}else if(event.getBlock().getType().equals(Material.DAYLIGHT_DETECTOR)){
			//Solar Panel
		}else if(event.getBlock().getType().equals(Material.REDSTONE_BLOCK)){
			//Energy Storage
		}else if(event.getBlock().getType().equals(Material.CHEST)){
			//Mass Fabricator thingy
		}
	}
}
