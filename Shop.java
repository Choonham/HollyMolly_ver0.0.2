package com.jun.hollymolly;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.PreparedStatement;
import java.util.ArrayList;

//HollyMollyPlugIn ver.0.0.2(latest release on 2020.09.15)j
public class Shop implements CommandExecutor, Listener {
    ArrayList<Object> GetUserInfo = new ArrayList<Object>();
    static public Inventory vault;
    static public ArrayList<ItemStack> items = new ArrayList<ItemStack>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            vault = Bukkit.createInventory(player, 36, "shop");
            if(label.equalsIgnoreCase("shop")) {
                if(args.length == 1) {
                    String material = args[0];
                        if(material.equalsIgnoreCase("block")) {
                            vault.setItem(1, SetItem(items, 0, Material.BEDROCK, "100000"));
                            vault.setItem(2, SetItem(items, 1, Material.GLASS, "1000"));
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
                if(Money >= 100000){
                    Money = Money - 100000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(1))){
                if(Money >= 1000){
                    Money = Money - 1000;
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
    public ItemStack SetItem(ArrayList<ItemStack> items, int i,
                        Material material, String Price){
        items.add(i, new ItemStack(material, 1));
        ItemMeta meta = items.get(i).getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + Price);
        items.get(i).setItemMeta(meta);
        return items.get(i);
    }
}
