package com.jun.hollymolly;


import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;


public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		System.out.println("HOLLY MOLLY ONLINE: Activated");
		this.getServer().getPluginManager().registerEvents(new PlayerLevel(), this);
		getCommand("join").setExecutor(new PlayerJoin());
		getCommand("login").setExecutor(new PlayerLogin());
		getCommand("ImOut").setExecutor(new PlayerWithdraw());
		getCommand("shop").setExecutor(new Shop());
		this.getServer().getPluginManager().registerEvents(new PlayerLogin(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerStuff(), this);
		this.getServer().getPluginManager().registerEvents(new Skills(), this);
		this.getServer().getPluginManager().registerEvents(new Shop(), this);

		EntityLabel();
	}
	@Override
	public void onDisable() {
		System.out.println("EXCEPTION: HOLLYMOLLY PLUGIN ERROR");
	}

	public void EntityLabel() {
		new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				for(LivingEntity e: getServer().getWorld("world").getLivingEntities()){
					e.setCustomName(e.getType() + "[" + ChatColor.RED + e.getHealth() + "/" +
							(int)e.getMaxHealth() + "]");
					e.setCustomNameVisible(false);
				}
			}
		}.runTaskTimerAsynchronously(this,0,1);
	}

}
