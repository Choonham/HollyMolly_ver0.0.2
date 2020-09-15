package com.jun.hollymolly;

import com.sun.scenario.effect.InvertMask;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Shop implements CommandExecutor, Listener {
    ArrayList<Object> GetUserInfo = new ArrayList<Object>();
    static public Inventory vault;
    static public ArrayList<ItemStack> items = new ArrayList<ItemStack>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            vault = Bukkit.createInventory(player, 18, "shop");
            if(label.equalsIgnoreCase("shop")) {
                if(args.length == 1) {
                    String material = args[0];
                        if(material.equalsIgnoreCase("block")) {
                            items.add(0,new ItemStack(Material.IRON_BLOCK, 1));
                            items.add(1,new ItemStack(Material.ICE, 1));
                            vault.setItem(1, items.get(0));
                            vault.setItem(2, items.get(1));
                            player.openInventory(vault);
                        }
                }
            }
        }else {
            System.out.println("shiddd");
        }
        return true;
    }
    @EventHandler
    public void OnPlayerClickInventory(InventoryClickEvent e){
        Inventory Clicked = e.getClickedInventory();
        if(Clicked.equals(vault)){
            Player player = (Player) e.getWhoClicked();
            Connect_DB connect = new Connect_DB();
            PlayerLevel PL = new PlayerLevel();
            String ID = player.getName();
            GetUserInfo = PL.GetUserInfo(ID);
            int Money = (int)GetUserInfo.get(7);
            ItemStack Selected = e.getCurrentItem();
            if(Selected.equals(items.get(0))){
                if(Money >= 10000){
                    Money = Money - 10000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(1))){
                if(Money >= 10000){
                    Money = Money - 10000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            }
            UpdateQuery(ID,Money);
            PL.ShowBoard(player);
        }
    }

    public void UpdateQuery(String ID, int Money){
        Connect_DB connect = new Connect_DB();
        String UpdateMoney = "UPDATE PLAYERINFO SET MONEY = ? WHERE ID = ?";
        try {
            PreparedStatement stmt = connect.connection.prepareStatement(UpdateMoney);
            stmt.setInt(1, Money);
            stmt.setString(2, ID);
            stmt.executeUpdate();
        }catch(Exception E) {
            E.printStackTrace();
        }

    }
}
