package com.jun.hollymolly;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class PlayerJoin implements CommandExecutor {
	public int LV = 1;
	public int EXP = 0; 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Connect_DB connect = new Connect_DB();
			Player player = (Player) sender;
			if(label.equalsIgnoreCase("join")) {
				if(args.length == 3) {
					String ID = args[0];
					String Password = args[1];
					String Class = args[2];
					connect.JoinQueryCommand("INSERT INTO PLAYERLOGININFO VALUES (\'"+ID+"\',\'"+Password+"\')");
					connect.JoinQueryCommand("INSERT INTO PLAYERINFO (ID, LV, EXP, class) VALUES (\'"+ ID + "\',\'"+ LV + "\',\'" + EXP + "\',\'" + Class + "\')");
					player.sendMessage("WELCOME, " + ID + "<" + Class + ">");
					connect.JoinQueryCommand("CREATE TABLE " + ID +"ITEMS (ITEMNAME VARCHAR(255), NUM INT);");
				}
			}
			
			
			
		}else {
			System.out.println("shit");
		}
		return true;
	}
}



