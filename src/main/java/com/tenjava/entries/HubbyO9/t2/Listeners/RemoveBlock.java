package com.tenjava.entries.HubbyO9.t2.Listeners;


import com.tenjava.entries.HubbyO9.t2.TenJava;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class RemoveBlock implements Listener {

	@EventHandler
	public void onBlockRemove(BlockBreakEvent event){
		if(event.getBlock().getType().equals(Material.DAYLIGHT_DETECTOR)){
			if(TenJava.manager.generatorExists(event.getBlock().getLocation())){
				TenJava.manager.unregisterGenerator(event.getBlock().getLocation());
			}
		}else if(event.getBlock().getType().equals(Material.REDSTONE_COMPARATOR)){
			if(TenJava.manager.relayExists(event.getBlock().getLocation())){
				TenJava.manager.unregisterRelay(event.getBlock().getLocation());
			}
		}else if(event.getBlock().getType().equals(Material.CHEST)){
			if(TenJava.manager.storageExists(event.getBlock().getLocation())){
				TenJava.manager.unregisterStorage(event.getBlock().getLocation());
			}
		}
	}
}
