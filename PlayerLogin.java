package com.jun.hollymolly;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
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

//HollyMollyPlugIn ver.0.0.2(latest release on 2020.10.06)
public class PlayerLogin implements CommandExecutor, Listener {
	//public static boolean isLogin = false;
	public PlayerLogin() {
	}

	;
	public static ArrayList<String> isLoginList = new ArrayList<String>();
	public static HashMap<String, ArrayList<Object>> playerInfoMap = new HashMap<>();
	Properties Pr = new Properties();

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
					String getPlayerInfo = "SELECT * FROM PLAYERINFO WHERE ID = ?";
					try {
						PreparedStatement stmt = connect.connection.prepareStatement(LoginProcess);
						stmt.setString(1, ID);
						ResultSet rs = stmt.executeQuery();
						if (rs.next()) {
							if (rs.getString(1).equals(Password)) {
								isLoginList.add(ID);
								ArrayList<Object> UserInfoList = new ArrayList<Object>();
								try {
									PreparedStatement getInfoStmt = connect.connection.prepareStatement(getPlayerInfo);
									getInfoStmt.setString(1, ID);
									ResultSet RS = getInfoStmt.executeQuery();
									while(RS.next()){
										String LoginedID =RS.getString("ID");
										int LoginedLV = RS.getInt("Lv");
										int LoginedEXP = RS.getInt("exp");
										String LoginedClass = RS.getString("class");
										float LoginedHomeX = RS.getFloat("homelocx");
										float LoginedHomeY = RS.getFloat("homelocy");
										float LoginedHomeZ = RS.getFloat("homelocz");
										int LoginedMoney = RS.getInt("Money");
										UserInfoList.add(0,LoginedID);
										UserInfoList.add(1,LoginedLV);
										UserInfoList.add(2,LoginedEXP);
										UserInfoList.add(3,LoginedClass);
										UserInfoList.add(4,LoginedHomeX);
										UserInfoList.add(5,LoginedHomeY);
										UserInfoList.add(6,LoginedHomeZ);
										UserInfoList.add(7, LoginedMoney);
										playerInfoMap.put(LoginedID, UserInfoList);
									}
								} catch (Exception e){
									e.printStackTrace();
									player.sendMessage("데이터베이스 오류: 관리자에게 문의하세요.");
								}
								player.sendMessage(ChatColor.AQUA + player.getName() + ChatColor.DARK_GREEN + "님, 어서오세요.");
								player.sendMessage(  "***************명령어***************");
								player.sendMessage("회원가입: /join password password class(Arc, predator, hunter)");
								player.sendMessage("로그인: /login ID password");
								player.sendMessage("회원 탈퇴(데이터 복구 불가능): /imout password password");
								player.sendMessage("토지 구매(5개 한정): /myblocks 정수 <서있는 곳 기준으로 정사각형 생김(ex: 3 --> 7x7의 사각형 토지 매입)>");
								player.sendMessage("소유 토지 확인: /check");
								player.sendMessage("소유 토지 매입: /rm X 첫번째 좌표");
								player.sendMessage("현금 교환: /exchange toCash 10000원 단위");
								player.sendMessage("계좌 이체: /exchange toAccount 금블록 개수");
								Pr.onID = Pr.getProperty();
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
		Connect_DB connect = new Connect_DB();
		ArrayList<Object> UpdateList = new ArrayList<Object>();
		UpdateList = playerInfoMap.get(ID);
		if(isLoginList.contains(ID)){
			isLoginList.remove(ID);
		}
		String GetExp = "UPDATE PLAYERINFO SET LV = ?, EXP = ?, MONEY = ? WHERE ID = ?";
		try {
			PreparedStatement stmt = connect.connection.prepareStatement(GetExp);
			stmt.setInt(1, (int)UpdateList.get(1));
			stmt.setInt(2, (int)UpdateList.get(2));
			stmt.setInt(3, (int)UpdateList.get(7));
			stmt.setString(4, (String)UpdateList.get(0));
			stmt.executeUpdate();
		} catch (Exception E) {
			E.printStackTrace();
		}
	}
}


