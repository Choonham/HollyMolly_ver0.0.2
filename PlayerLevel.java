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
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class PlayerLevel implements Listener {
	Player p;
	PlayerLogin login = new PlayerLogin();
	public HashMap<Player, ItemStack[]> items = new HashMap<>();
	Random rand = new Random();
	ArrayList<Object> GetKillerInfo = new ArrayList<Object>();
	ArrayList<Object> GetKilledInfo = new ArrayList<Object>();
	public PlayerLevel() {}

	@EventHandler
	public void onPlayerKilled(PlayerDeathEvent e) {
		Player getKilled = e.getEntity();
		String getKilledName = getKilled.getName();
		Player Killer = e.getEntity().getKiller();
		String KillerName = Killer.getName();
		int randInt = rand.nextInt(40);
		Connect_DB connect = new Connect_DB();

		//*********************killer info********************//
		GetKillerInfo = this.GetUserInfo(KillerName);
		int KillerEXP = (int) GetKillerInfo.get(2);
		int KillerLV = (int) GetKillerInfo.get(1);
		String KillerID = (String) GetKillerInfo.get(0);
		String KillerClass = (String) GetKillerInfo.get(3);
		int KillerMoney = (int) GetKillerInfo.get(7);

		//*********************getKilled info********************//
		GetKilledInfo = this.GetUserInfo(getKilledName);
		int KilledEXP = (int) GetKilledInfo.get(2);
		int KilledLV = (int) GetKilledInfo.get(1);
		String KilledID = (String) GetKilledInfo.get(0);
		String KilledClass = (String) GetKilledInfo.get(3);
		int KilledMoney = (int) GetKilledInfo.get(7);


		if(KillerClass.equals("predator")){
			if(KillerID.equalsIgnoreCase(KilledID)){
				KillerEXP = KillerEXP/2;
			} else {
				KillerEXP = KillerEXP + KilledEXP;
				ItemStack[] content = e.getEntity().getInventory().getContents();
				items.put(e.getEntity(), content);
				ItemStack RandItem = content[randInt];
				Killer.getInventory().addItem(RandItem);
				double FloatEXP2 = KilledEXP*0.9;
				KilledEXP = (int)FloatEXP2;
				double FloatMoney2 = KilledMoney*0.9;
				KilledMoney = (int)FloatMoney2;
			}
		} else {
			getKilled.sendMessage(getKilledName);
			double FloatEXP2 = KilledEXP*0.9;
			KilledEXP = (int)FloatEXP2;
			double FloatMoney2 = KilledMoney*0.9;
			KilledMoney = (int)FloatMoney2;
		}

		if(KillerEXP >= (int) (KillerLV*(500)*(KillerLV*0.75))) {
			int OverFlowExp = KillerEXP - (int) (KillerLV*(1000)*(KillerLV*0.75));
			KillerLV++;
			KillerEXP = OverFlowExp;
			KillerMoney = KillerMoney + 100000;
		}

		String GetKilled = "UPDATE PLAYERINFO SET EXP = ?, MONEY = ? WHERE ID = ?";
		String GetExp = "UPDATE PLAYERINFO SET EXP = ?, LV = ?, MONEY = ? WHERE ID = ?";
		try {
			PreparedStatement stmt = connect.connection.prepareStatement(GetExp);
			stmt.setInt(1, KillerEXP);
			stmt.setInt(2, KillerLV);
			stmt.setInt(3, KillerMoney);
			stmt.setString(4, KillerName);
			stmt.executeUpdate();
			PreparedStatement stmtKilled = connect.connection.prepareStatement(GetKilled);
			stmtKilled.setInt(1, KilledEXP);
			stmtKilled.setInt(2, KilledMoney);
			stmtKilled.setString(3, getKilledName);
			stmtKilled.executeUpdate();
		}catch(Exception E) {
			E.printStackTrace();
		}

		ShowBoard(p);
	}

	@EventHandler
	public void onPlayerSetBlock(BlockPlaceEvent e) {
		p = e.getPlayer();
		int EXP, LV, MONEY = 0;
		Connect_DB connect = new Connect_DB();
		ArrayList<Object> GetUserInfo = new ArrayList<Object>();
		Material[] Give15List = {Material.GLASS, Material.SANDSTONE, Material.WHITE_WOOL, Material.BLACK_WOOL, Material.BLUE_WOOL,
				Material.BROWN_WOOL, Material.CYAN_WOOL, Material.GRAY_WOOL, Material.GREEN_WOOL,
				Material.LIGHT_BLUE_WOOL, Material.LIGHT_GRAY_WOOL, Material.LIME_WOOL, Material.MAGENTA_WOOL,
				Material.ORANGE_WOOL, Material.PINK_WOOL, Material.PURPLE_WOOL, Material.RED_WOOL, Material.YELLOW_WOOL};
		Material[] Give30List = {Material.BRICKS, Material.BRICK_SLAB, Material.IRON_BLOCK, Material.GOLD_BLOCK, Material.GLOWSTONE};
		Material[] Give50List = {Material.DIAMOND_BLOCK};
		
		ArrayList<Material> Give15s = new ArrayList<Material>(Arrays.asList(Give15List));
		ArrayList<Material> Give30s = new ArrayList<Material>(Arrays.asList(Give30List));
		ArrayList<Material> Give50s = new ArrayList<Material>(Arrays.asList(Give50List));

		String ID = p.getName();
		GetUserInfo = this.GetUserInfo(ID);
		EXP = (int) GetUserInfo.get(2);
		LV = (int) GetUserInfo.get(1);
		String Class = (String) GetUserInfo.get(3);
		MONEY = (int) GetUserInfo.get(7);
		Block block = e.getBlock();
		Material getMat = block.getType();

		boolean hasGive15s = Give15s.stream().anyMatch(s ->  s == getMat);
		boolean hasGive30s = Give30s.stream().anyMatch(s ->  s == getMat);
		boolean hasGive50s = Give50s.stream().anyMatch(s ->  s == getMat);
		
		if (hasGive15s) {
			if(Class.equals("Arc")) EXP = EXP + 100;
			else EXP = EXP + 50;
			MONEY = MONEY + 1000;
		} else if(hasGive30s) {
			if(Class.equals("Arc")) EXP = EXP + 100;
			else EXP = EXP + 50;
			MONEY = MONEY + 1000;
		} else if(hasGive50s) {
			if(Class.equals("Arc")) EXP = EXP + 100;
			else EXP = EXP + 50;
			MONEY = MONEY + 1000;
		} else {
			if(Class.equals("Arc")) EXP = EXP + 100;
			else EXP = EXP + 50;
			MONEY = MONEY + 1000;
		}
		
		if(EXP >= (LV*(1000)*(LV*0.75))) {
			LV++;
			EXP = 0;
			MONEY = MONEY + 100000;
		}

		String GetExp = "UPDATE PLAYERINFO SET EXP = ?, LV = ?, MONEY = ? WHERE ID = ?";
		try {
			PreparedStatement stmt = connect.connection.prepareStatement(GetExp);
			stmt.setInt(1, EXP);
			stmt.setInt(2, LV);
			stmt.setInt(3, MONEY);
			stmt.setString(4, ID);
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
		int EXP, LV, MONEY = 0;
		ArrayList<Object> GetUserInfo = new ArrayList<Object>();
		LivingEntity entity = e.getEntity();
		p = entity.getKiller();
		ID = (String)p.getName();
		GetUserInfo = this.GetUserInfo(ID);
		EXP = (int) GetUserInfo.get(2);
		LV = (int) GetUserInfo.get(1);
		String Class = (String) GetUserInfo.get(3);
		MONEY = (int) GetUserInfo.get(7);

		if(entity.getType()==EntityType.ZOMBIE){
			if(Class.equals("hunter"))EXP = EXP + 500;
			else EXP = EXP + 300;
			MONEY = MONEY + 1000;
		} else if(entity.getType()==EntityType.SKELETON){
			if(Class.equals("hunter"))EXP = EXP + 700;
			else EXP = EXP + 300;
			MONEY = MONEY + 1000;
		} else if(entity.getType()==EntityType.ENDERMAN){
			if(Class.equals("hunter"))EXP = EXP + 1000;
			else EXP = EXP + 300;
			MONEY = MONEY + 1000;
		} else if(entity.getType()==EntityType.CREEPER){
			if(Class.equals("hunter"))EXP = EXP + 1300;
			else EXP = EXP + 300;
			MONEY = MONEY + 1000;
		} else {
			if(Class.equals("hunter"))EXP = EXP + 500;
			else EXP = EXP + 300;
			MONEY = MONEY + 1000;
			}

		if(EXP >= (LV*(1000)*(LV*0.75))) {
			LV++;
			EXP = 0;
			MONEY = MONEY + 100000;
		}
		String GetExp = "UPDATE PLAYERINFO SET EXP = ?, LV = ?, MONEY = ? WHERE ID = ?";
		try {
			PreparedStatement stmt = connect.connection.prepareStatement(GetExp);
			stmt.setInt(1, EXP);
			stmt.setInt(2, LV);
			stmt.setInt(3, MONEY);
			stmt.setString(4, ID);
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

		int GetExp = (int)Status.get(2);
		Score PlayerExp = objective.getScore("Exp: (" + (GetLV*(1000)*(GetLV*0.75)) + ")");
		PlayerExp.setScore(GetExp);

		int GetMoney = (int)Status.get(7);
		Score PlayerMoney = objective.getScore(ChatColor.GOLD + "$: ");
		PlayerMoney.setScore(GetMoney);

		p.setScoreboard(scoreboard);
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
				int LoginedMoney = rs.getInt("Money");
				UserInfoList.add(0,LoginedID);
				UserInfoList.add(1,LoginedLV);
				UserInfoList.add(2,LoginedEXP);
				UserInfoList.add(3,LoginedClass);
				UserInfoList.add(4,LoginedHomeX);
				UserInfoList.add(5,LoginedHomeY);
				UserInfoList.add(6,LoginedHomeZ);
				UserInfoList.add(7, LoginedMoney);
			}
			return UserInfoList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
}
