package com.tenjava.entries.HubbyO9.t2.Instances;


import org.bukkit.Location;

public class EMStorage {
	public int max;
	public int current;
	public int MaxOutput;
	public int MaxInput;
	public String id;
	public Location location;

	public void storeEM(int amount){
		if(amount <= MaxInput){
			if(current + amount < max){
				current += amount;
			}else{
				current = max;
			}
			current += amount;
		}
	}

	public void callEM(int amount){
		if(amount <= MaxOutput){
			if(current - amount > 0){
				current -= amount;
			}else{
				current = 0;
			}
		}
	}
}
