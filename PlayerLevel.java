package com.jun.hollymolly;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerLevel implements Listener {
	Player p;
	public PlayerLevel() {}

	@EventHandler
	public void onPlayerSetBlock(BlockPlaceEvent e) {
		p = e.getPlayer();
		int EXP, LV= 0;
		Connect_DB connect = new Connect_DB();
		ArrayList<Object> GetUserInfo = new ArrayList<Object>();
		Material[] Give15List = {Material.GLASS, Material.SANDSTONE, Material.WHITE_WOOL, Material.BLACK_WOOL, Material.BLUE_WOOL,
				Material.BROWN_WOOL, Material.CYAN_WOOL, Material.GRAY_WOOL, Material.GREEN_WOOL,
				Material.LIGHT_BLUE_WOOL, Material.LIGHT_GRAY_WOOL, Material.LIME_WOOL, Material.MAGENTA_WOOL,
				Material.ORANGE_WOOL, Material.PINK_WOOL, Material.PURPLE_WOOL, Material.RED_WOOL, Material.YELLOW_WOOL};
		Material[] Give30List = {Material.BRICK, Material.BRICK_SLAB, Material.IRON_BLOCK, Material.GOLD_BLOCK, Material.GLOWSTONE};
		Material[] Give50List = {Material.DIAMOND_BLOCK};
		ArrayList<Material> Give15s = new ArrayList<Material>(Arrays.asList(Give15List));
		ArrayList<Material> Give30s = new ArrayList<Material>(Arrays.asList(Give30List));
		ArrayList<Material> Give50s = new ArrayList<Material>(Arrays.asList(Give50List));

		String ID = p.getName();
		GetUserInfo = this.GetUserInfo(ID);
		EXP = (int) GetUserInfo.get(2);
		LV = (int) GetUserInfo.get(1);
		String Class = (String) GetUserInfo.get(3);
		Block block = e.getBlock();
		Material getMat = block.getType();
		if(Class.equals("Arc")) {
			if (getMat.equals(Material.DIAMOND_BLOCK)) {
				EXP = EXP + 5;
			}
		}
		if(EXP >= (LV*(1000)*(LV*0.75))) {
			LV++;
			EXP = 0;
		}
		String GetExp = "UPDATE PLAYERINFO SET EXP = ?, LV = ? WHERE ID = ?";
		try {
			PreparedStatement stmt = connect.connection.prepareStatement(GetExp);
			stmt.setInt(1, EXP);
			stmt.setInt(2, LV);
			stmt.setString(3, ID);
			stmt.executeUpdate();
		}catch(Exception E) {
			E.printStackTrace();
		}
		ShowBoard(p);
	}

	//**********************사냥꾼 LV***************************//
	@EventHandler
	public void onPlayerKillMob(EntityDeathEvent e) {
		Connect_DB connect = new Connect_DB();
		String ID = null;
		int EXP, LV= 0;
		ArrayList<Object> GetUserInfo = new ArrayList<Object>();
		LivingEntity entity = e.getEntity();
		p = entity.getKiller();
		ID = (String)p.getName();
		GetUserInfo = this.GetUserInfo(ID);
		EXP = (int) GetUserInfo.get(2);
		LV = (int) GetUserInfo.get(1);
		String Class = (String) GetUserInfo.get(3);
		if(Class.equalsIgnoreCase("hunter")) {
		if(entity.getType()==EntityType.ZOMBIE){
			EXP = EXP + 50;
		} else if(entity.getType()==EntityType.SKELETON){
			EXP = EXP + 70;
		} else if(entity.getType()==EntityType.ENDERMAN){
			EXP = EXP + 150;
		} else if(entity.getType()==EntityType.CREEPER){
			EXP = EXP + 100;
		} else {
			EXP = EXP + 30;
			}
		}
		if(EXP >= (LV*(1000)*(LV*0.75))) {
			LV++;
			EXP = 0;
		}
		String GetExp = "UPDATE PLAYERINFO SET EXP = ?, LV = ? WHERE ID = ?";
		try {
			PreparedStatement stmt = connect.connection.prepareStatement(GetExp);
			stmt.setInt(1, EXP);
			stmt.setInt(2, LV);
			stmt.setString(3, ID);
			stmt.executeUpdate();
		}catch(Exception E) {
			E.printStackTrace();
		}
		ShowBoard(p);
	}

	public void ShowBoard(Player p) {
		String ID = p.getName();
		PlayerLogin isLogin = new PlayerLogin();
		ArrayList<Object> Status = new ArrayList<Object>();
		if(isLogin.isLoginList.contains(p.getName())) {
			Status = GetUserInfo(ID);
		}
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard scoreboard = manager.getNewScoreboard();
		Objective objective =  scoreboard.registerNewObjective("test", "dummy", ChatColor.BLUE + "Status");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		String GetID = (String)Status.get(0);
		int GetLV = (int)Status.get(1);
		Score PlayerID = objective.getScore(GetID);
		PlayerID.setScore(GetLV);
		p.setScoreboard(scoreboard);
		int GetExp = (int)Status.get(2);
		Score PlayerExp = objective.getScore("Exp: (" + (GetLV*(1000)*(GetLV*0.75)) + ")");
		PlayerExp.setScore(GetExp);
	}

	public ArrayList<Object> GetUserInfo(String ID){
		ArrayList<Object> UserInfoList = new ArrayList<Object>();
		Connect_DB connect = new Connect_DB();
		String GetProcess = "SELECT * FROM PLAYERINFO WHERE ID= ?";
		try {
			PreparedStatement stmt = connect.connection.prepareStatement(GetProcess);
			stmt.setString(1,  ID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String LoginedID =rs.getString("ID");
				int LoginedLV = rs.getInt("Lv");
				int LoginedEXP = rs.getInt("exp");
				String LoginedClass = rs.getString("class");
				float LoginedHomeX = rs.getFloat("homelocx");
				float LoginedHomeY = rs.getFloat("homelocy");
				float LoginedHomeZ = rs.getFloat("homelocz");
				UserInfoList.add(0,LoginedID);
				UserInfoList.add(1,LoginedLV);
				UserInfoList.add(2,LoginedEXP);
				UserInfoList.add(3,LoginedClass);
				UserInfoList.add(4,LoginedHomeX);
				UserInfoList.add(5,LoginedHomeY);
				UserInfoList.add(6,LoginedHomeZ);
			}
			return UserInfoList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
}
