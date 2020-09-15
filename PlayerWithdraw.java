package com.jun.hollymolly;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
//HollyMollyPlugIn ver.0.0.2(latest release on 2020.09.15)
public class PlayerWithdraw implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Connect_DB connect = new Connect_DB();
            Player player = (Player) sender;
            if(label.equalsIgnoreCase("imout")) {
                if(args.length == 2) {
                    String ID = player.getName();
                    String Password = args[0];
                    String PasswordConfirm = args[1];
                    if(Password.equals(PasswordConfirm)){
                        connect.JoinQueryCommand("DELETE FROM PLAYERLOGININFO WHERE ID =\'" + ID + "\';");
                        connect.JoinQueryCommand("DELETE FROM PLAYERINFO WHERE ID =\'" + ID + "\';");
                        player.sendMessage("Bye:" + ID);
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
}