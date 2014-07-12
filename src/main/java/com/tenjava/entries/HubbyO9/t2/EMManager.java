package com.tenjava.entries.HubbyO9.t2;

import com.tenjava.entries.HubbyO9.t2.Instances.EMGenerator;
import com.tenjava.entries.HubbyO9.t2.Instances.EMStorage;
import com.tenjava.entries.HubbyO9.t2.Instances.EMWire;
import org.bukkit.Location;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class EMManager {
	public static List<EMWire> wires = new ArrayList<EMWire>();
	public static List<EMStorage> storages = new ArrayList<EMStorage>();
	public static List<EMGenerator> generators = new ArrayList<EMGenerator>();

	public void registerGenerator(Location location){
		SecureRandom random = new SecureRandom();
		while(idExists(random.toString())){
			random.nextLong();
		}
		String id = random.toString();
		EMGenerator generator = new EMGenerator();
		generator.id = id;
		generator.location = location;
		generator.maxOutput = 20;
		generators.add(generator);
	}

	public void registerStorage(Location location){
		SecureRandom random = new SecureRandom();
		while(idExists(random.toString())){
			random.nextLong();
		}
		String id = random.toString();
		EMStorage storage = new EMStorage();
		storage.location = location;
		storage.id = id;
		storages.add(storage);
	}

	public void registerWire(Location location){
		SecureRandom random = new SecureRandom();
		while(idExists(random.toString())){
			random.nextLong();
		}
		String id = random.toString();
		EMWire wire = new EMWire();
		wire.id = id;
		wire.location = location;
		wires.add(wire);
	}

	public void unregisterWire(Location location){
		for(EMWire wire : wires){
			if(wire.location.equals(location)){
				wires.remove(wire);
			}
		}
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

	public boolean idExists(String id){
		boolean idExist = false;
		for(EMWire wire : wires){
			if(wire.id.equals(id)){
				idExist = true;
			}
		}
		for(EMStorage storage : storages){
			if(storage.id.equals(id)){
				idExist = true;
			}
		}
		for(EMGenerator generator : generators){
			if(generator.id.equals(id)){
				idExist = true;
			}
		}
		return idExist;
	}
}
