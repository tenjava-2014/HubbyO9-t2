package com.tenjava.entries.HubbyO9.t2;

import com.tenjava.entries.HubbyO9.t2.Listeners.RemoveBlock;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class TenJava extends JavaPlugin {

	public static EMManager manager;

	@Override
	public void onEnable() {
		manager = new EMManager();
		loadListeners();
		loadCommands();
		createRecipes();
	}

	@Override
	public void onDisable(){

	}

	public void loadListeners() {
		Bukkit.getPluginManager().registerEvents(new RemoveBlock(), this);
	}

	public void loadCommands(){

	}

	public void createRecipes() {
		/*Solar Panel*/
		ItemMeta solarMeta = new ItemStack(Material.DAYLIGHT_DETECTOR).getItemMeta();
		solarMeta.setDisplayName(ChatColor.GOLD + "Solar Panel");
		List<String> solarLore = new ArrayList<String>();
		solarLore.add(ChatColor.RED + "Output : " + ChatColor.GOLD + "20 Watts");
		solarMeta.setLore(solarLore);
		ItemStack solarPanels = new ItemStack(Material.DAYLIGHT_DETECTOR);
		solarPanels.setAmount(4);
		ShapedRecipe solarPanel = new ShapedRecipe(solarPanels);
		solarPanel.shape("G","G","G", "R", "D", "R", "I", "I", "I");
		solarPanel.setIngredient('G', Material.GLASS);
		solarPanel.setIngredient('R', Material.REDSTONE);
		solarPanel.setIngredient('D', Material.DIAMOND);
		solarPanel.setIngredient('I', Material.IRON_INGOT);
		Bukkit.addRecipe(solarPanel);
		/*EM Storage Unit*/
		ItemMeta chestMeta = new ItemStack(Material.CHEST).getItemMeta();
		chestMeta.setDisplayName(ChatColor.GOLD + "Storage Unit");
		List<String> chestLore = new ArrayList<String>();
		chestLore.add(ChatColor.RED + "Max Input : " + ChatColor.GOLD + "200");
		chestLore.add(ChatColor.RED + "Max Output : " + ChatColor.GOLD + "500");
		chestMeta.setLore(chestLore);
		ItemStack chest = new ItemStack(Material.CHEST);
		chest.setItemMeta(chestMeta);
		ShapedRecipe energystorage = new ShapedRecipe(chest);
		energystorage.shape("I", "R", "I","R", "B", "R","I", "R", "I");
		energystorage.setIngredient('I', Material.IRON_INGOT);
		energystorage.setIngredient('R', Material.REDSTONE);
		energystorage.setIngredient('B', Material.REDSTONE_BLOCK);
		Bukkit.addRecipe(energystorage);
		/*EM Wire*/
		ItemMeta railMeta = new ItemStack(Material.RAILS).getItemMeta();
		railMeta.setDisplayName(ChatColor.GOLD + "Simple Wire");
		ItemStack rails = new ItemStack(Material.RAILS);
		rails.setItemMeta(railMeta);
		rails.setAmount(8);
		ShapedRecipe wire = new ShapedRecipe(rails);
		wire.shape("I", "R", "I", "I", "R", "I", "I", "R", "I");
		wire.setIngredient('I', Material.IRON_INGOT);
		wire.setIngredient('R', Material.REDSTONE);
		Bukkit.addRecipe(wire);
		/*Techno Phreak Wand*/
		ItemMeta blazeMeta = new ItemStack(Material.BLAZE_ROD).getItemMeta();
		blazeMeta.setDisplayName(ChatColor.RED + "Techno Phreak Wand");
		ItemStack blazeRod = new ItemStack(Material.BLAZE_ROD);
		blazeRod.setItemMeta(blazeMeta);
		ShapedRecipe technoPhreak = new ShapedRecipe(blazeRod);
		technoPhreak.shape("R", "R", "R", "R", "I", "R", "R", "R", "R");
		technoPhreak.setIngredient('R', Material.REDSTONE);
		technoPhreak.setIngredient('I', Material.IRON_INGOT);
		Bukkit.addRecipe(technoPhreak);
	}
}
