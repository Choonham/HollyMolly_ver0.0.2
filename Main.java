package com.jun.hollymolly;

import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin{
	
	
	
	@Override
	public void onEnable() {
		System.out.println("HOLLY MOLLY ONLINE: Activated");
		this.getServer().getPluginManager().registerEvents(new PlayerLevel(), this);
		getCommand("join").setExecutor(new PlayerJoin());
		getCommand("login").setExecutor(new PlayerLogin());
		this.getServer().getPluginManager().registerEvents(new PlayerLogin(), this);
	}
       
     
	@Override
	public void onDisable() {
		System.out.println("EXCEPTION: HOLLYMOLLY PLUGIN ERROR");
		
	}
}
