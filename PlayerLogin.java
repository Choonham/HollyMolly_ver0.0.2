package com.jun.hollymolly;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//import java.sql.SQLException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerLogin implements CommandExecutor, Listener {
	//public static boolean isLogin = false;
	public PlayerLogin() {
	}

	;
	public static ArrayList<String> isLoginList = new ArrayList<String>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Connect_DB connect = new Connect_DB();
			PlayerLevel Levelboard = new PlayerLevel();
			if (label.equalsIgnoreCase("login")) {
				if (args.length == 2) {
					String ID = args[0];
					String Password = args[1];
					String LoginProcess = "SELECT passwords	 FROM PLAYERLOGININFO WHERE ID= ?";
					try {
						PreparedStatement stmt = connect.connection.prepareStatement(LoginProcess);
						stmt.setString(1, ID);
						ResultSet rs = stmt.executeQuery();
						if (rs.next()) {
							if (rs.getString(1).equals(Password)) {
								player.sendMessage(ID + "로그인");
								isLoginList.add(ID);
								Levelboard.ShowBoard(player);
							} else player.sendMessage("아이디, 비밀번호를 확인해주세요.");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return true;
	}
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if (!isLoginList.contains(player.getName())) {
			e.setCancelled(true);
			player.sendMessage("로그인이 필요합니다.");
		}
	}
}


