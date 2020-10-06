package com.jun.hollymolly;

import com.mysql.fabric.xmlrpc.base.Array;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//HollyMollyPlugIn ver.0.0.2(latest release on 2020.10.06)
public class Properties implements Listener, CommandExecutor {
    Connect_DB connect = new Connect_DB();
    ArrayList<Integer> X1 = new ArrayList<Integer>();
    ArrayList<Integer> Z1 = new ArrayList<Integer>();
    ArrayList<Integer> X2 = new ArrayList<Integer>();
    ArrayList<Integer> Z2 = new ArrayList<Integer>();
    ArrayList<String> who = new ArrayList<String>();

    public static ArrayList<ArrayList<?>> onID = new ArrayList<>();
    public Properties() {
    }

    @EventHandler
    public void OnBlockSet(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        String ID = p.getName();
        Location PlayerLoc = p.getLocation();
        Location BlockLoc = e.getBlock().getLocation();

        //onID = getProperty();
        PlayerLevel PL = new PlayerLevel();
        who = (ArrayList<String>)onID.get(0);
        X1 = (ArrayList<Integer>)onID.get(1);
        Z1 = (ArrayList<Integer>)onID.get(2);
        X2 = (ArrayList<Integer>)onID.get(3);
        Z2 = (ArrayList<Integer>)onID.get(4);
        PL.isHome = true;
        if ((BlockLoc.getBlockX() < 105) && (BlockLoc.getBlockX() > -185)) {
            if ((BlockLoc.getBlockZ() < 131) && (BlockLoc.getBlockZ() > -251)) {
                //p.sendMessage(ChatColor.RED +"Public property는 변경이 불가능합니다!");
                //e.setCancelled(true);
                PL.isHome = false;
            }
        }
        for(int i = 0; i < who.size(); i++) {
            if ((BlockLoc.getBlockX() <= X1.get(i)) && (BlockLoc.getBlockX() >= X2.get(i))) {
                if ((BlockLoc.getBlockZ() <= Z1.get(i)) && (BlockLoc.getBlockZ() >= Z2.get(i))) {
                    if (!who.get(i).equals(ID)) {
                        e.setCancelled(true);
                        p.sendMessage("This is not your property!!");
                        PL.isHome = false;
                    } else {
                        PL.isHome = true;
                        return;
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
        //ArrayList<ArrayList<?>> onID = new ArrayList<>();
        //onID = getProperty();
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
                //p.sendMessage(ChatColor.RED +"Public property는 변경이 불가능합니다!");
                //e.setCancelled(true);
                PL.isHome = false;
            }
        }
        for(int i = 0; i < who.size(); i++){
            if ((BlockLoc.getBlockX() <= X1.get(i)) && (BlockLoc.getBlockX() >= X2.get(i))) {
                if ((BlockLoc.getBlockZ() <= Z1.get(i)) && (BlockLoc.getBlockZ() >= Z2.get(i))) {
                    if(!who.get(i).equals(ID)) {
                        e.setCancelled(true);
                        p.sendMessage("This is not your property!!");
                        PL.isHome = false;
                    } else{
                        PL.isHome = true;
                        return;
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
                    int count = getCount(ID);
                    //String countString = Integer.toString(count);
                    if(count<=5) {
                        //player.sendMessage(countString);
                        GetUserInfo = PL.GetUserInfo(ID);
                        int Money = (int) GetUserInfo.get(7);
                        String distance = args[0];
                        int distanceInt = Integer.parseInt(distance);
                        if (Money >= distanceInt * 10000) {
                            Location playerLoc = player.getLocation();
                            int x = playerLoc.getBlockX();
                            int z = playerLoc.getBlockZ();
                            int x1 = x + distanceInt;
                            int x2 = x - distanceInt;
                            int z1 = z + distanceInt;
                            int z2 = z - distanceInt;
                            Location loc1 = new Location(player.getWorld(), x1, playerLoc.getBlockY()+1, z1);
                            Location loc2 = new Location(player.getWorld(), x2, playerLoc.getBlockY()+1, z2);

                            String StringX = Integer.toString(x);
                            String StringZ = Integer.toString(z);
                            Money = Money - (distanceInt * 10000);
                            player.sendMessage(ChatColor.GOLD + "(" + StringX + " , y , " + StringZ + " ) 기준" + distance + " x2 제곱미터 면적의 소유권을 구매했습니다!");
                            player.sendMessage(ChatColor.AQUA + "위 지역은 " + ID + "님 외 다른 사람이 임의 변경이 불가능합니다!");
                            Block block1 = player.getWorld().getBlockAt(loc1);
                            Block block2 = player.getWorld().getBlockAt(loc2);
                            block1.setType(Material.BEDROCK);
                            block2.setType(Material.BEDROCK);
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
                            onID = getProperty();
                            PL.ShowBoard(player);
                        } else {
                            player.sendMessage("You don't have enough money for this.");
                        }
                    } else player.sendMessage("토지는 6개 초과로 소유할 수 없습니다!");
                }
            } else if (label.equalsIgnoreCase("check")){
                ArrayList<ArrayList<?>> onIDs = new ArrayList<>();
                onIDs = getIDsProperty(player.getName());
                who = (ArrayList<String>)onIDs.get(0);
                X1 = (ArrayList<Integer>)onIDs.get(1);
                Z1 = (ArrayList<Integer>)onIDs.get(2);
                X2 = (ArrayList<Integer>)onIDs.get(3);
                Z2 = (ArrayList<Integer>)onIDs.get(4);
                for(int i = 0; i < who.size(); i++){
                    player.sendMessage(i + "번 째 토지: X( " + X2.get(i) + " ~ " + X1.get(i) + " ), Z( "
                                            + Z2.get(i) + " ~ " + Z1.get(i) + " )");
                }
            } else if(label.equalsIgnoreCase("rm")){
                if (args.length == 1){
                    ArrayList<ArrayList<?>> onIDs = new ArrayList<>();
                    String X2String = args[0];
                    String ID = player.getName();
                    onIDs = getIDsProperty(ID);
                    X1 = (ArrayList<Integer>)onIDs.get(1);
                    X2 = (ArrayList<Integer>)onIDs.get(3);
                    GetUserInfo = PL.GetUserInfo(ID);
                    int Money = (int) GetUserInfo.get(7);
                    int x2 = Integer.parseInt(X2String);
                    int X2index = X2.indexOf(x2);
                    int x1 = X1.get(X2index);
                    int difference = (x1 - x2)/2;
                    Money = Money + (Math.abs(difference)*10000);
                    String delete = "DELETE FROM PROPERTIES WHERE X2 = ?";
                    String UpdateMoney = "UPDATE PLAYERINFO SET MONEY = ? WHERE ID = ?";
                    try{
                        PreparedStatement deleteStmt = connect.connection.prepareStatement(delete);
                        deleteStmt.setInt(1, x2);
                        PreparedStatement moneyStmt = connect.connection.prepareStatement(UpdateMoney);
                        moneyStmt.setString(2, ID);
                        moneyStmt.setInt(1, Money);
                        deleteStmt.executeUpdate();
                        moneyStmt.executeUpdate();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    onID = getProperty();
                    PL.ShowBoard(player);
                    player.sendMessage("X 값 : " + x2 + " 의 땅 처분 완료, " + Math.abs(difference) + "만원이 입금되었습니다.");


                }

            }
        } else {
            System.out.println("shit");
        }
        return true;
    }

    public ArrayList<ArrayList<?>> getProperty() {
        ArrayList<String> IDs = new ArrayList<>();
        ArrayList<Integer> X1 = new ArrayList<>();
        ArrayList<Integer> Z1 = new ArrayList<>();
        ArrayList<Integer> X2 = new ArrayList<>();
        ArrayList<Integer> Z2 = new ArrayList<>();

        ArrayList<ArrayList<?>> onID = new ArrayList<>();
        Connect_DB connect = new Connect_DB();
        String GetProcess = "SELECT * FROM PROPERTIES";
        try {
            PreparedStatement stmt = connect.connection.prepareStatement(GetProcess);
            //stmt.setString(1,  ID);
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

    public ArrayList<ArrayList<?>> getIDsProperty(String ID) {
        ArrayList<String> IDs = new ArrayList<>();
        ArrayList<Integer> X1 = new ArrayList<>();
        ArrayList<Integer> Z1 = new ArrayList<>();
        ArrayList<Integer> X2 = new ArrayList<>();
        ArrayList<Integer> Z2 = new ArrayList<>();

        ArrayList<ArrayList<?>> onID = new ArrayList<>();
        Connect_DB connect = new Connect_DB();
        String GetProcess = "SELECT * FROM PROPERTIES WHERE ID = ?";
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

    public int getCount(String ID){
        int count = 0;
        Connect_DB connect = new Connect_DB();
        String Count = "SELECT COUNT(id) FROM PROPERTIES WHERE ID = ?";
        try {
            PreparedStatement countStmt = connect.connection.prepareStatement(Count);
            countStmt.setString(1, ID);
            ResultSet rs = countStmt.executeQuery();
            while(rs.next()){
                count = rs.getInt(1);
            }
            return count;
        } catch(Exception e){
            e.printStackTrace();
            return -1;
        }

    }
}

