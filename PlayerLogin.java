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
import org.bukkit.event.player.PlayerQuitEvent;

//HollyMollyPlugIn ver.0.0.2(latest release on 2020.09.15)
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
								isLoginList.add(ID);
								player.sendMessage(ChatColor.AQUA + player.getName() + ChatColor.DARK_GREEN + "님, 어서오세요.");
								player.sendMessage(  "***************명령어***************");
								player.sendMessage("회원가입: /join password password class(Arc, predator, hunter)");
								player.sendMessage("로그인: /login ID password");
								player.sendMessage("회원 탈퇴(데이터 복구 불가능): /imout password password");
								player.sendMessage("토지 구매(5개 한정): /myblocks 정수 <서있는 곳 기준으로 정사각형 생김(ex: 3 --> 7x7의 사각형 토지 매입)>");
								player.sendMessage("소유 토지 확인: /check");
								player.sendMessage("소유 토지 매입: /rm X2좌표");
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
			player.sendMessage(ChatColor.RED +"로그인이 필요합니다.");
			player.sendMessage("회원가입: /join password password class(Arc, predator, hunter)");
			player.sendMessage("로그인: /login ID password");
		}
	}

	@EventHandler
	public void onLogout(PlayerQuitEvent e){
		Player player = e.getPlayer();
		String ID = player.getName();
		if(isLoginList.contains(ID)){
			isLoginList.remove(ID);
		}
	}
}


