package com.jun.hollymolly;

import com.mysql.fabric.xmlrpc.base.Array;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//76, y, 30//105, y, -251 // -185, y, -238//-185, y, 131
public class Properties implements Listener, CommandExecutor {
    Connect_DB connect = new Connect_DB();
    ArrayList<Integer> X1 = new ArrayList<Integer>();
    ArrayList<Integer> Z1 = new ArrayList<Integer>();
    ArrayList<Integer> X2 = new ArrayList<Integer>();
    ArrayList<Integer> Z2 = new ArrayList<Integer>();

    ArrayList<String> who = new ArrayList<String>();

    public Properties() {
    }

    @EventHandler
    public void OnBlockSet(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        String ID = p.getName();
        Location PlayerLoc = p.getLocation();
        Location BlockLoc = e.getBlock().getLocation();
        ArrayList<ArrayList<?>> onID = new ArrayList<>();
        onID = getProperty(ID);
        PlayerLevel PL = new PlayerLevel();
        who = (ArrayList<String>)onID.get(0);
        X1 = (ArrayList<Integer>)onID.get(1);
        Z1 = (ArrayList<Integer>)onID.get(2);
        X2 = (ArrayList<Integer>)onID.get(3);
        Z2 = (ArrayList<Integer>)onID.get(4);
        PL.isHome = true;
        if ((BlockLoc.getBlockX() < 105) && (BlockLoc.getBlockX() > -185)) {
            if ((BlockLoc.getBlockZ() < 131) && (BlockLoc.getBlockZ() > -251)) {
                e.setCancelled(true);
                PL.isHome = false;
            }
        }
        for(int i = 0; i < who.size(); i++){
            if ((BlockLoc.getBlockX() < X1.get(i)) && (BlockLoc.getBlockX() > X2.get(i))) {
                if ((BlockLoc.getBlockZ() < Z1.get(i)) && (BlockLoc.getBlockZ() > Z2.get(i))) {
                    if(who.get(i).equals(ID)) {
                        PL.isHome = true;
                        return;
                    } else{
                        e.setCancelled(true);
                        p.sendMessage("This is not your property!!");
                        PL.isHome = false;
                    }
                }
            }
        }
    }

    @EventHandler
    public void OnBlockDestroy(BlockBreakEvent e) {
        Player p = e.getPlayer();
        String ID = p.getName();
        Location PlayerLoc = p.getLocation();
        Location BlockLoc = e.getBlock().getLocation();
        ArrayList<ArrayList<?>> onID = new ArrayList<>();
        onID = getProperty(ID);
        PlayerLevel PL = new PlayerLevel();
        who = (ArrayList<String>)onID.get(0);
        X1 = (ArrayList<Integer>)onID.get(1);
        Z1 = (ArrayList<Integer>)onID.get(2);
        X2 = (ArrayList<Integer>)onID.get(3);
        Z2 = (ArrayList<Integer>)onID.get(4);
        PL.isHome = true;
        //Location whereIsP = new Location(p.getWorld(), PlayerLoc.getBlockX(), PlayerLoc.getBlockY(), PlayerLoc.getBlockZ());
        if ((BlockLoc.getBlockX() < 105) && (BlockLoc.getBlockX() > -185)) {
            if ((BlockLoc.getBlockZ() < 131) && (BlockLoc.getBlockZ() > -251)) {
                e.setCancelled(true);
                PL.isHome = false;
            }
        }
        for(int i = 0; i < who.size(); i++){
            if ((BlockLoc.getBlockX() < X1.get(i)) && (BlockLoc.getBlockX() > X2.get(i))) {
                if ((BlockLoc.getBlockZ() < Z1.get(i)) && (BlockLoc.getBlockZ() > Z2.get(i))) {
                    if(who.get(i).equals(ID)) {
                        PL.isHome = true;
                        return;
                    } else{
                        e.setCancelled(true);
                        p.sendMessage("This is not your property!!");
                        PL.isHome = false;
                    }
                }
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Connect_DB connect = new Connect_DB();
            Player player = (Player) sender;
            PlayerLevel PL = new PlayerLevel();
            ArrayList<Object> GetUserInfo = new ArrayList<Object>();
            if (label.equalsIgnoreCase("myblocks")) {
                if (args.length == 1) {
                    String ID = player.getName();
                    GetUserInfo = PL.GetUserInfo(ID);
                    int Money = (int)GetUserInfo.get(7);
                    String distance = args[0];
                    int distanceInt = Integer.parseInt(distance);
                    if(Money >= distanceInt*10000) {
                        Location playerLoc = player.getLocation();
                        int x = playerLoc.getBlockX();
                        int z = playerLoc.getBlockZ();
                        int x1 = x + distanceInt;
                        int x2 = x - distanceInt;
                        int z1 = z + distanceInt;
                        int z2 = z - distanceInt;
                        Money = Money - (distanceInt*10000);
                        String Insert = "INSERT INTO PROPERTIES VALUES (?, ?, ?, ?, ?)";
                        String UpdateMoney = "UPDATE PLAYERINFO SET MONEY = ? WHERE ID = ?";
                        try {
                            PreparedStatement stmt = connect.connection.prepareStatement(Insert);
                            stmt.setString(1, ID);
                            stmt.setInt(2, x1);
                            stmt.setInt(3, z1);
                            stmt.setInt(4, x2);
                            stmt.setInt(5, z2);
                            PreparedStatement moneyStmt = connect.connection.prepareStatement(UpdateMoney);
                            moneyStmt.setString(2, ID);
                            moneyStmt.setInt(1, Money);
                            stmt.executeUpdate();
                            moneyStmt.executeUpdate();
                        } catch (Exception E) {
                            E.printStackTrace();
                        }
                        PL.ShowBoard(player);
                    } else {
                        player.sendMessage("You don't have enough money for this.");
                    }
                }
            }
        } else {
            System.out.println("shit");
        }
        return true;
    }

    public ArrayList<ArrayList<?>> getProperty(String ID) {
        ArrayList<String> IDs = new ArrayList<>();
        ArrayList<Integer> X1 = new ArrayList<>();
        ArrayList<Integer> Z1 = new ArrayList<>();
        ArrayList<Integer> X2 = new ArrayList<>();
        ArrayList<Integer> Z2 = new ArrayList<>();

        ArrayList<ArrayList<?>> onID = new ArrayList<>();
        Connect_DB connect = new Connect_DB();
        String GetProcess = "SELECT * FROM PROPERTIES WHERE ID= ?";
        try {
            PreparedStatement stmt = connect.connection.prepareStatement(GetProcess);
            stmt.setString(1,  ID);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                String LoginedID =rs.getString("ID");
                int x1 = rs.getInt("x1");
                int z1 = rs.getInt("y1");
                int x2 = rs.getInt("x2");
                int z2 = rs.getInt("y2");
                IDs.add(LoginedID);
                X1.add(x1);
                Z1.add(z1);
                X2.add(x2);
                Z2.add(z2);
            }
            onID.add(0, IDs);
            onID.add(1, X1);
            onID.add(2, Z1);
            onID.add(3, X2);
            onID.add(4, Z2);
            return onID;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}

