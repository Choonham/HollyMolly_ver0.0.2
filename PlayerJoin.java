package com.jun.hollymolly;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

//HollyMollyPlugIn ver.0.0.2(latest release on 2020.10.20)

public class PlayerJoin implements Listener {
	public int LV = 1;
	public int EXP = 0;
	/*
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Connect_DB connect = new Connect_DB();
			Player player = (Player) sender;
			if(label.equalsIgnoreCase("join")) {
				if(args.length == 3) {
					String ID = player.getName();
					String Password = args[0];
					String PasswordConfirm = args[1];
					String Class = args[2];
					if(Password.equals(PasswordConfirm)){
					connect.JoinQueryCommand("INSERT INTO PLAYERLOGININFO VALUES (\'"+ID+"\',\'"+Password+"\')");
					connect.JoinQueryCommand("INSERT INTO PLAYERINFO (ID, LV, EXP, class) VALUES (\'"+ ID + "\',\'"+ LV + "\',\'" + EXP + "\',\'" + Class + "\')");
					player.sendMessage("WELCOME, " + ID + "<" + Class + ">");
					//connect.JoinQueryCommand("CREATE TABLE " + ID +"ITEMS (ITEMNAME VARCHAR(255), NUM INT);");
					} else {
						player.sendMessage("비밀번호가 일치하지 않습니다.");
					}
				}
			}
		}else {
			System.out.println("shit");
		}
		return true;
	}
	*/
	@EventHandler
	public void OnJoin(PlayerJoinEvent e){
		if(NPC.getNPCs() == null) return;
		if(NPC.getNPCs().isEmpty()) return;
		NPC.addJoinPacket(e.getPlayer());

	}

}



