package com.tenjava.entries.HubbyO9.t2;

import com.tenjava.entries.HubbyO9.t2.Instances.EMGenerator;
import com.tenjava.entries.HubbyO9.t2.Instances.EMStorage;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class EMManager {
	public static List<EMStorage> storages = new ArrayList<EMStorage>();
	public static List<EMGenerator> generators = new ArrayList<EMGenerator>();
	public static List<Location> Relays = new ArrayList<Location>();

	public void startup(){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(TenJava.plugin, new Runnable() {
			@Override
			public void run() {
					secTicker();
			}
		}, 0L, 20L);
	}

	public void secTicker(){
		for(EMGenerator generator : generators){
			for(EMStorage storage : storages){
				if(generator.location.getWorld().getTime() > 0 && generator.location.getWorld().getTime() < 12000) {
					if (generator.LinkedTo.equals(storage.location)) {
						if (generator.location.distance(storage.location) < 50) {
							storage.storeEM(generator.MaxOutput);
						} else {
							for (Location relay : Relays) {
								if (relay.distance(generator.location) <= 50 && relay.distance(storage.location) <= 50) {
									storage.storeEM(generator.MaxOutput);
								}
							}
						}
					}
				}
			}
		}
	}

	public void registerGenerator(Location location){
		EMGenerator generator = new EMGenerator();
		generator.location = location;
		generator.MaxOutput = 20;
		generators.add(generator);
	}

	public void registerStorage(Location location){
		EMStorage storage = new EMStorage();
		storage.location = location;
		storages.add(storage);
	}

	public void registerRelay(Location location){
		Relays.add(location);
	}

	public void unregisterRelay(Location location){
		Relays.remove(location);
	}

	public boolean generatorExists(Location location){
		boolean exists = false;
		for(EMGenerator generator : generators){
			if(generator.location.equals(location)){
				exists = true;
			}
		}
		return exists;
	}

	public boolean relayExists(Location location){
		boolean exists = false;
		for(Location loc : Relays){
			if(loc.equals(location)){
				exists = true;
			}
		}
		return exists;
	}

	public boolean storageExists(Location location){
		boolean exists = false;
		for(EMStorage storage : storages){
			if(storage.location.equals(location)){
				exists = true;
			}
		}
		return exists;
	}

	public void unregisterGenerator(Location location){
		for(EMGenerator generator : generators){
			if(generator.location.equals(location)){
				generators.remove(generator);
			}
		}
	}

	public void unregisterStorage(Location location){
		for(EMStorage storage : storages){
			if(storage.location.equals(location)){
				storages.remove(storage);
			}
		}
	}
}
