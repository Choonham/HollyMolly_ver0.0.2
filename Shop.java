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

//HollyMollyPlugIn ver.0.0.2(latest release on 2020.09.15)jjk
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
                            vault.setItem(1, SetItem(items, 0, Material.BEDROCK, "기반암: 100000"));
                            vault.setItem(2, SetItem(items, 1, Material.GLASS, "유리: 1000"));
                            vault.setItem(3, SetItem(items, 2, Material.BLACK_WOOL, "검정색 양털: 1000"));
                            vault.setItem(4, SetItem(items, 3, Material.BLUE_WOOL, "파랑색 양털: 1000"));
                            vault.setItem(5, SetItem(items, 4, Material.WHITE_WOOL, "흰색 양털: 1000"));
                            vault.setItem(7, SetItem(items, 6, Material.ORANGE_WOOL, "오렌지색 양털: 1000"));
                            vault.setItem(8, SetItem(items, 7, Material.YELLOW_WOOL, "노랑색 양털: 1000"));
                            vault.setItem(9, SetItem(items, 8, Material.PINK_WOOL, "핑크색 양털: 1000"));
                            vault.setItem(10, SetItem(items, 9, Material.GRAY_WOOL, "회색 양털: 1000"));
                            vault.setItem(11, SetItem(items, 10, Material.CYAN_WOOL, "읭: 1000"));
                            vault.setItem(12, SetItem(items, 11, Material.BROWN_WOOL, "갈색 양털: 1000"));
                            vault.setItem(13, SetItem(items, 12, Material.GREEN_WOOL, "초록색 양털: 1000"));
                            vault.setItem(14, SetItem(items, 13, Material.RED_WOOL, "빨간색 양털: 1000"));
                            vault.setItem(15, SetItem(items, 14, Material.LIME_WOOL, "라임색 양털: 1000"));
                            vault.setItem(16, SetItem(items, 15, Material.STONE_BRICK_SLAB, "돌 반블록: 500"));
                            vault.setItem(17, SetItem(items, 16, Material.BRICK_SLAB, "벽돌 반블록: 1000"));
                            vault.setItem(18, SetItem(items, 17, Material.NETHER_BRICK_SLAB, "네더 벽돌 반블록: 3000"));
                            vault.setItem(19, SetItem(items, 18, Material.QUARTZ_SLAB, "읭 반블록: 5000"));
                            vault.setItem(20, SetItem(items, 19, Material.BRICKS, "벽돌: 5000"));
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
            } else if(Selected.equals(items.get(2))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(3))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(4))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(5))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(6))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(7))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(8))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(9))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(10))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(11))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(12))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(13))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(14))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(15))){
                if(Money >= 500){
                    Money = Money - 500;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(16))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(17))){
                if(Money >= 3000){
                    Money = Money - 3000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(18))){
                if(Money >= 5000){
                    Money = Money - 5000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if(Selected.equals(items.get(19))){
                if(Money >= 5000){
                    Money = Money - 5000;
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
