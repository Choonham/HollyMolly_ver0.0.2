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
    static public Inventory vault_block;
    static public Inventory vault_block2;
    static public Inventory vault_block3;
    static public ArrayList<ItemStack> items = new ArrayList<ItemStack>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(label.equalsIgnoreCase("shop")) {
                if(args.length == 1) {
                    String material = args[0];
                        if(material.equalsIgnoreCase("Arc1")) {
                            vault_block = Bukkit.createInventory(player, 36, "shop");
                            vault_block.setItem(0, SetItem(items, 0, Material.BEDROCK, "기반암: 100000"));
                            vault_block.setItem(1, SetItem(items, 1, Material.GLASS, "유리: 3000"));
                            vault_block.setItem(2, SetItem(items, 2, Material.BLACK_WOOL, "검정색 양털: 1000"));
                            vault_block.setItem(3, SetItem(items, 3, Material.BLUE_WOOL, "파랑색 양털: 1000"));
                            vault_block.setItem(4, SetItem(items, 4, Material.WHITE_WOOL, "흰색 양털: 1000"));
                            vault_block.setItem(5, SetItem(items, 5, Material.ORANGE_WOOL, "오렌지색 양털: 1000"));
                            vault_block.setItem(6, SetItem(items, 6, Material.YELLOW_WOOL, "노랑색 양털: 1000"));
                            vault_block.setItem(7, SetItem(items, 7, Material.PINK_WOOL, "핑크색 양털: 1000"));
                            vault_block.setItem(8, SetItem(items, 8, Material.GRAY_WOOL, "회색 양털: 1000"));
                            vault_block.setItem(9, SetItem(items, 9, Material.CYAN_WOOL, "읭: 1000"));
                            vault_block.setItem(10, SetItem(items, 10, Material.BROWN_WOOL, "갈색 양털: 1000"));
                            vault_block.setItem(11, SetItem(items, 11, Material.GREEN_WOOL, "초록색 양털: 1000"));
                            vault_block.setItem(12, SetItem(items, 12, Material.RED_WOOL, "빨간색 양털: 1000"));
                            vault_block.setItem(13, SetItem(items, 13, Material.LIME_WOOL, "라임색 양털: 1000"));
                            vault_block.setItem(14, SetItem(items, 14, Material.STONE_BRICK_SLAB, "돌 반블록: 500"));
                            vault_block.setItem(15, SetItem(items, 15, Material.BRICK_SLAB, "벽돌 반블록: 1000"));
                            vault_block.setItem(16, SetItem(items, 16, Material.NETHER_BRICK_SLAB, "네더 벽돌 반블록: 3000"));
                            vault_block.setItem(17, SetItem(items, 17, Material.QUARTZ_SLAB, "읭 반블록: 5000"));
                            vault_block.setItem(18, SetItem(items, 18, Material.BRICKS, "벽돌: 5000"));
                            vault_block.setItem(19, SetItem(items, 19, Material.CLAY, "점토: 1000"));
                            vault_block.setItem(20, SetItem(items, 20, Material.GLOWSTONE, "발광석: 5000"));
                            vault_block.setItem(21, SetItem(items, 21, Material.JACK_O_LANTERN, "잭-오 랜턴: 7000"));
                            vault_block.setItem(22, SetItem(items, 22, Material.GLASS_PANE, "유리판: 1500"));

                            player.openInventory(vault_block);
                        }
                        if(material.equalsIgnoreCase("Arc2")) {
                            vault_block2 = Bukkit.createInventory(player, 36, "shop");
                            vault_block2.setItem(0, SetItem(items, 0, Material.BLACK_STAINED_GLASS, "검은색 유리: 5000"));
                            vault_block2.setItem(1, SetItem(items, 1, Material.BLUE_STAINED_GLASS, "파란색 유리: 5000"));
                            vault_block2.setItem(2, SetItem(items, 2, Material.BROWN_STAINED_GLASS, "갈색 유리: 5000"));
                            vault_block2.setItem(3, SetItem(items, 3, Material.CYAN_STAINED_GLASS, "청록색 유리: 5000"));
                            vault_block2.setItem(4, SetItem(items, 4, Material.GRAY_STAINED_GLASS, "회색 유리: 5000"));
                            vault_block2.setItem(5, SetItem(items, 5, Material.GREEN_STAINED_GLASS, "초록색 유리: 5000"));
                            vault_block2.setItem(6, SetItem(items, 6, Material.LIGHT_BLUE_STAINED_GLASS, "밝은 파란색 유리: 5000"));
                            vault_block2.setItem(7, SetItem(items, 7, Material.LIGHT_GRAY_STAINED_GLASS, "밝은 회색 유리: 5000"));
                            vault_block2.setItem(8, SetItem(items, 8, Material.LIME_STAINED_GLASS, "라임색 유리: 5000"));
                            vault_block2.setItem(9, SetItem(items, 9, Material.MAGENTA_STAINED_GLASS, "마젠타색 유리: 5000"));
                            vault_block2.setItem(10, SetItem(items, 10, Material.PINK_STAINED_GLASS, "분홍색 유리: 5000"));
                            vault_block2.setItem(11, SetItem(items, 11, Material.ORANGE_STAINED_GLASS, "오렌지색 유리: 5000"));
                            vault_block2.setItem(12, SetItem(items, 12, Material.PURPLE_STAINED_GLASS, "보라색 유리: 5000"));
                            vault_block2.setItem(13, SetItem(items, 13, Material.RED_STAINED_GLASS, "빨간색 유리: 5000"));
                            vault_block2.setItem(14, SetItem(items, 14, Material.WHITE_STAINED_GLASS, "흰색 유리: 5000"));
                            vault_block2.setItem(15, SetItem(items, 15, Material.YELLOW_STAINED_GLASS, "노란색 유리: 5000"));
                            vault_block2.setItem(16, SetItem(items, 16, Material.BLACK_STAINED_GLASS_PANE, "검은색 유리판: 1500"));
                            vault_block2.setItem(17, SetItem(items, 17, Material.BLUE_STAINED_GLASS_PANE, "파란색 유리판: 1500"));
                            vault_block2.setItem(18, SetItem(items, 18, Material.BROWN_STAINED_GLASS_PANE, "갈색 유리판: 1500"));
                            vault_block2.setItem(19, SetItem(items, 19, Material.CYAN_STAINED_GLASS_PANE, "청록색 유리판: 1500"));
                            vault_block2.setItem(20, SetItem(items, 20, Material.GRAY_STAINED_GLASS_PANE, "회색 유리판: 1500"));
                            vault_block2.setItem(21, SetItem(items, 21, Material.GREEN_STAINED_GLASS_PANE, "초록색 유리판: 1500"));
                            vault_block2.setItem(22, SetItem(items, 22, Material.LIGHT_BLUE_STAINED_GLASS_PANE, "밝은 파란색 유리판: 1500"));
                            vault_block2.setItem(23, SetItem(items, 23, Material.LIGHT_GRAY_STAINED_GLASS_PANE, "밝은 회색 유리판: 1500"));
                            vault_block2.setItem(24, SetItem(items, 24, Material.LIME_STAINED_GLASS_PANE, "라임색 유리판: 1500"));
                            vault_block2.setItem(25, SetItem(items, 25, Material.MAGENTA_STAINED_GLASS_PANE, "마젠타색 유리판: 1500"));
                            vault_block2.setItem(26, SetItem(items, 26, Material.PINK_STAINED_GLASS_PANE, "분홍색 유리판: 1500"));
                            vault_block2.setItem(27, SetItem(items, 27, Material.ORANGE_STAINED_GLASS_PANE, "오렌지색 유리판: 1500"));
                            vault_block2.setItem(28, SetItem(items, 28, Material.PURPLE_STAINED_GLASS_PANE, "보라색 유리판: 1500"));
                            vault_block2.setItem(29, SetItem(items, 29, Material.RED_STAINED_GLASS_PANE, "빨간색 유리판: 1500"));
                            vault_block2.setItem(30, SetItem(items, 30, Material.WHITE_STAINED_GLASS_PANE, "흰색 유리판: 1500"));
                            vault_block2.setItem(31, SetItem(items, 31, Material.YELLOW_STAINED_GLASS_PANE, "노란색 유리판: 1500"));
                            player.openInventory(vault_block2);

                        }
                        if(material.equalsIgnoreCase("Arc3")) {
                            vault_block3 = Bukkit.createInventory(player, 36, "shop");
                            vault_block3.setItem(0, SetItem(items, 0, Material.STONE_BRICKS, "돌: 500"));
                            vault_block3.setItem(1, SetItem(items, 1, Material.MOSSY_STONE_BRICKS, "이끼낀 돌: 500"));
                            vault_block3.setItem(2, SetItem(items, 2, Material.CRACKED_STONE_BRICKS, "금간 돌: 500"));
                            vault_block3.setItem(3, SetItem(items, 3, Material.CHISELED_STONE_BRICKS, "재련된 돌: 500"));
                            vault_block3.setItem(4, SetItem(items, 4, Material.BROWN_MUSHROOM_BLOCK, "갈색 버섯: 1000"));
                            vault_block3.setItem(5, SetItem(items, 5, Material.RED_MUSHROOM_BLOCK, "빨간 버섯: 1000"));
                            vault_block3.setItem(6, SetItem(items, 6, Material.REDSTONE_LAMP, "레드스톤 램프: 3000"));
                            vault_block3.setItem(7, SetItem(items, 7, Material.QUARTZ_BLOCK, "대리석: 5000"));
                            vault_block3.setItem(8, SetItem(items, 8, Material.CHISELED_QUARTZ_BLOCK, "깎은 대리석: 5500"));
                            vault_block3.setItem(9, SetItem(items, 9, Material.PRISMARINE_BRICKS, "프리즈마린 블록: 5000"));
                            vault_block3.setItem(10, SetItem(items, 10, Material.PRISMARINE, "프리즈마린: 5000"));
                            vault_block3.setItem(11, SetItem(items, 11, Material.DARK_PRISMARINE, "어두운 프리즈마린: 5000"));
                            vault_block3.setItem(12, SetItem(items, 12, Material.SEA_LANTERN, "바다 랜턴: 3000"));
                            vault_block3.setItem(13, SetItem(items, 13, Material.RED_SANDSTONE, "붉은 샌드스톤: 1000"));
                            vault_block3.setItem(14, SetItem(items, 14, Material.PURPUR_BLOCK  , "PURPUR_BLOCK: 2000"));
                            vault_block3.setItem(15, SetItem(items, 15, Material.PURPUR_PILLAR  , "PURPUR_PILLAR: 2500"));
                            vault_block3.setItem(16, SetItem(items, 16, Material.RED_NETHER_BRICKS, "RED_NETHER_BRICKS: 2000"));
                            vault_block3.setItem(17, SetItem(items, 17, Material.TERRACOTTA, "테라코타: 10000"));
                            vault_block3.setItem(18, SetItem(items, 18, Material.BLACK_GLAZED_TERRACOTTA, "BLACK_GLAZED_TERRACOTTA: 10000"));
                            vault_block3.setItem(19, SetItem(items, 19, Material.BLACK_TERRACOTTA, "BLACK_TERRACOTTA: 10000"));
                            vault_block3.setItem(20, SetItem(items, 20, Material.BLUE_GLAZED_TERRACOTTA, "BLUE_GLAZED_TERRACOTTA: 10000"));
                            vault_block3.setItem(21, SetItem(items, 21, Material.BLUE_TERRACOTTA, "BLUE_TERRACOTTA: 10000"));
                            vault_block3.setItem(22, SetItem(items, 22, Material.BROWN_GLAZED_TERRACOTTA, "BROWN_GLAZED_TERRACOTTA: 10000"));
                            vault_block3.setItem(23, SetItem(items, 23, Material.BROWN_TERRACOTTA, "BROWN_TERRACOTTA: 10000"));
                            vault_block3.setItem(24, SetItem(items, 24, Material.CYAN_TERRACOTTA, "CYAN_TERRACOTTA: 10000"));
                            vault_block3.setItem(25, SetItem(items, 25, Material.CYAN_GLAZED_TERRACOTTA, "CYAN_GLAZED_TERRACOTTA: 10000"));
                            vault_block3.setItem(26, SetItem(items, 26, Material.GRAY_GLAZED_TERRACOTTA, "GRAY_GLAZED_TERRACOTTA: 10000"));
                            vault_block3.setItem(27, SetItem(items, 27, Material.GRAY_TERRACOTTA, "GRAY_TERRACOTTA: 10000"));
                            vault_block3.setItem(28, SetItem(items, 28, Material.GREEN_GLAZED_TERRACOTTA, "GREEN_GLAZED_TERRACOTTA: 10000"));
                            vault_block3.setItem(29, SetItem(items, 29, Material.LIME_GLAZED_TERRACOTTA, "LIME_GLAZED_TERRACOTTA: 10000"));
                            vault_block3.setItem(30, SetItem(items, 30, Material.LIME_TERRACOTTA, "LIME_TERRACOTTA: 10000"));
                            vault_block3.setItem(31, SetItem(items, 31, Material.MAGENTA_GLAZED_TERRACOTTA, "MAGENTA_GLAZED_TERRACOTTA: 10000"));
                            vault_block3.setItem(32, SetItem(items, 32, Material.ORANGE_GLAZED_TERRACOTTA, "ORANGE_GLAZED_TERRACOTTA: 10000"));
                            vault_block3.setItem(33, SetItem(items, 33, Material.PINK_GLAZED_TERRACOTTA, "PINK_GLAZED_TERRACOTTA: 10000"));
                            vault_block3.setItem(34, SetItem(items, 34, Material.PURPLE_GLAZED_TERRACOTTA, "PURPLE_GLAZED_TERRACOTTA: 10000"));
                            vault_block3.setItem(35, SetItem(items, 35, Material.RED_GLAZED_TERRACOTTA, "RED_GLAZED_TERRACOTTA: 10000"));
                            player.openInventory(vault_block3);
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
        if(Clicked.equals(vault_block)){
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
                }  else e.setCancelled(true);
            } else if(Selected.equals(items.get(20))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                }  else e.setCancelled(true);
            } else if(Selected.equals(items.get(21))){
                if(Money >= 5000){
                    Money = Money - 5000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                }  else e.setCancelled(true);
            } else if(Selected.equals(items.get(22))){
                if(Money >= 7000){
                    Money = Money - 7000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                }  else e.setCancelled(true);
            } else if(Selected.equals(items.get(23))){
                if(Money >= 1500){
                    Money = Money - 1500;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                }  else e.setCancelled(true);
            }
            UpdateQuery(ID,Money);
            PL.ShowBoard(player);
        }
        if(Clicked.equals(vault_block2)){
            Player player = (Player) e.getWhoClicked();
            Connect_DB connect = new Connect_DB();
            PlayerLevel PL = new PlayerLevel();
            String ID = player.getName();
            GetUserInfo = PL.GetUserInfo(ID);
            int Money = (int)GetUserInfo.get(7);
            ItemStack Selected = e.getCurrentItem();

            if((Selected.equals(items.get(0)))||(Selected.equals(items.get(1)))||(Selected.equals(items.get(2)))||
                    (Selected.equals(items.get(3)))||(Selected.equals(items.get(4)))||(Selected.equals(items.get(5)))||
                    (Selected.equals(items.get(6)))||(Selected.equals(items.get(7)))||(Selected.equals(items.get(8)))||
                    (Selected.equals(items.get(9)))||(Selected.equals(items.get(10)))||(Selected.equals(items.get(11)))||
                    (Selected.equals(items.get(12)))||(Selected.equals(items.get(13)))||(Selected.equals(items.get(14)))||
                    (Selected.equals(items.get(15)))){
                if(Money >= 5000){
                    Money = Money - 5000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if((Selected.equals(items.get(17)))||(Selected.equals(items.get(18)))||(Selected.equals(items.get(19)))||
                    (Selected.equals(items.get(20)))||(Selected.equals(items.get(21)))||(Selected.equals(items.get(22)))||
                    (Selected.equals(items.get(23)))||(Selected.equals(items.get(24)))||(Selected.equals(items.get(25)))||
                    (Selected.equals(items.get(26)))||(Selected.equals(items.get(27)))||(Selected.equals(items.get(28)))||
                    (Selected.equals(items.get(29)))||(Selected.equals(items.get(30)))||(Selected.equals(items.get(31)))||
                    (Selected.equals(items.get(15)))) {
                if(Money >= 1500){
                    Money = Money - 1500;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            }
            UpdateQuery(ID,Money);
            PL.ShowBoard(player);
        }
        if(Clicked.equals(vault_block3)){
            Player player = (Player) e.getWhoClicked();
            Connect_DB connect = new Connect_DB();
            PlayerLevel PL = new PlayerLevel();
            String ID = player.getName();
            GetUserInfo = PL.GetUserInfo(ID);
            int Money = (int)GetUserInfo.get(7);
            ItemStack Selected = e.getCurrentItem();

            if((Selected.equals(items.get(0)))||(Selected.equals(items.get(1)))
                    ||(Selected.equals(items.get(2)))||(Selected.equals(items.get(3)))){
                if(Money >= 500){
                    Money = Money - 500;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if((Selected.equals(items.get(4)))||(Selected.equals(items.get(5)))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if((Selected.equals(items.get(6)))){
                if(Money >= 3000){
                    Money = Money - 3000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if((Selected.equals(items.get(7)))){
                if(Money >= 5000){
                    Money = Money - 5000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if((Selected.equals(items.get(8)))){
                if(Money >= 5500){
                    Money = Money - 5500;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if((Selected.equals(items.get(9)))){
                if(Money >= 5000){
                    Money = Money - 5000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if((Selected.equals(items.get(10)))){
                if(Money >= 5000){
                    Money = Money - 5000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if((Selected.equals(items.get(11)))){
                if(Money >= 5000){
                    Money = Money - 5000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if((Selected.equals(items.get(12)))){
                if(Money >= 3000){
                    Money = Money - 3000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if((Selected.equals(items.get(13)))){
                if(Money >= 1000){
                    Money = Money - 1000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if((Selected.equals(items.get(14)))){
                if(Money >= 2000){
                    Money = Money - 2000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if((Selected.equals(items.get(15)))){
                if(Money >= 2500){
                    Money = Money - 2500;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if((Selected.equals(items.get(16)))){
                if(Money >= 2000){
                    Money = Money - 2000;
                    player.getInventory().addItem(Selected);
                    e.setCancelled(true);
                } else e.setCancelled(true);
            } else if((Selected.equals(items.get(17)))||(Selected.equals(items.get(18)))||(Selected.equals(items.get(19)))||
                    (Selected.equals(items.get(20)))||(Selected.equals(items.get(21)))||(Selected.equals(items.get(22)))||
                    (Selected.equals(items.get(23)))||(Selected.equals(items.get(24)))||(Selected.equals(items.get(25)))||
                    (Selected.equals(items.get(26)))||(Selected.equals(items.get(27)))||(Selected.equals(items.get(28)))||
                    (Selected.equals(items.get(29)))||(Selected.equals(items.get(30)))||(Selected.equals(items.get(31)))||
                    (Selected.equals(items.get(32)))||(Selected.equals(items.get(33)))||(Selected.equals(items.get(34)))||
                    (Selected.equals(items.get(35)))) {
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
    public ItemStack SetItem(ArrayList<ItemStack> items, int i,
                        Material material, String Price){
        items.add(i, new ItemStack(material, 1));
        ItemMeta meta = items.get(i).getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + Price);
        items.get(i).setItemMeta(meta);
        return items.get(i);
    }
}
