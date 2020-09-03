package com.jun.hollymolly;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PlayerLevel implements Listener {
	Player p;
	public PlayerLevel() {}
	@EventHandler
	public void onPlayerOnline(PlayerJoinEvent e) {
		this.p = e.getPlayer();
		//ShowBoard();
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
		Score PlayerExp = objective.getScore("Exp: ");
		PlayerExp.setScore(GetExp);

		
	}

	public ArrayList<Object> GetUserInfo(String ID){
		ArrayList<Object> UserInfoList = new ArrayList<Object>();
		Connect_DB connect = new Connect_DB();
		String GetProcess = "SELECT *	 FROM PLAYERINFO WHERE ID= ?";
		try {
			PreparedStatement stmt = connect.connection.prepareStatement(GetProcess);
			stmt.setString(1,  ID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String LoginedID =rs.getString("ID");
				int LoginedLV = rs.getInt("Lv");
				int LoginedEXP = rs.getInt("exp");
				int LoginedClass = rs.getInt("class");
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
