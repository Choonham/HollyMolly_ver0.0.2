package com.jun.hollymolly;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Random;

//HollyMollyPlugIn ver.0.0.2(latest release on 2020.10.20)
public class Shop implements CommandExecutor, Listener {
    ArrayList<Object> GetUserInfo = new ArrayList<Object>();
    static public Inventory vault_block, vault_block2, vault_block3, vault_block4,
            vault_weapons, vault_arm, vault_spawn, vault_utils;
    
    static public ArrayList<ItemStack> items = new ArrayList<ItemStack>();

    @EventHandler
    public void onClickBlock(PlayerInteractEntityEvent e){
        Player player = e.getPlayer();
        Entity clickedEntity = e.getRightClicked();
        if(clickedEntity!=null) {
            Location blockLoc = clickedEntity.getLocation();
            int blockX = blockLoc.getBlockX();
            int blockY = blockLoc.getBlockY();
            int blockZ = blockLoc.getBlockZ();
            Location clickedBlockLoc = new Location(player.getWorld(), blockX, blockY, blockZ);
            Location Arc1Block = new Location(player.getWorld(), -64, 70, -83);
            Location Arc2Block = new Location(player.getWorld(), -65, 70, -83);
            Location Arc3Block = new Location(player.getWorld(), -68, 70, -83);
            Location Arc4Block = new Location(player.getWorld(), -69, 70, -83);
            Location WeaponsBlock = new Location(player.getWorld(), -64, 70, -80);
            Location ArmBlock = new Location(player.getWorld(), -65, 70, -80);
            Location SpawnerBlock = new Location(player.getWorld(), -68, 70, -80);
            Location UtilsBlock = new Location(player.getWorld(), -69, 70, -80);


            if (clickedBlockLoc.equals(Arc1Block)&&clickedEntity instanceof ItemFrame) {
                vault_block = Bukkit.createInventory(player, 36, "Arc1");
                vault_block.setItem(0, SetItem(items, 0, Material.BEDROCK, "기반암: 100000"));
                vault_block.setItem(1, SetItem(items, 1, Material.GLASS, "유리: 1000"));
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
                vault_block.setItem(16, SetItem(items, 16, Material.NETHER_BRICK_SLAB, "네더 벽돌 반블록: 1500"));
                vault_block.setItem(17, SetItem(items, 17, Material.QUARTZ_SLAB, "읭 반블록: 1500"));
                vault_block.setItem(18, SetItem(items, 18, Material.BRICKS, "벽돌: 1500"));
                vault_block.setItem(19, SetItem(items, 19, Material.CLAY, "점토: 1000"));
                vault_block.setItem(20, SetItem(items, 20, Material.GLOWSTONE, "발광석: 1500"));
                vault_block.setItem(21, SetItem(items, 21, Material.JACK_O_LANTERN, "잭-오 랜턴: 1700"));
                vault_block.setItem(22, SetItem(items, 22, Material.GLASS_PANE, "유리판: 500"));
                player.openInventory(vault_block);
                //e.setCancelled(true);
            }
            if (clickedBlockLoc.equals(Arc2Block)&&clickedEntity instanceof ItemFrame){
                vault_block2 = Bukkit.createInventory(player, 36, "Arc2");
                vault_block2.setItem(0, SetItem(items, 0, Material.BLACK_STAINED_GLASS, "검은색 유리: 1500"));
                vault_block2.setItem(1, SetItem(items, 1, Material.BLUE_STAINED_GLASS, "파란색 유리: 1500"));
                vault_block2.setItem(2, SetItem(items, 2, Material.BROWN_STAINED_GLASS, "갈색 유리: 1500"));
                vault_block2.setItem(3, SetItem(items, 3, Material.CYAN_STAINED_GLASS, "청록색 유리: 1500"));
                vault_block2.setItem(4, SetItem(items, 4, Material.GRAY_STAINED_GLASS, "회색 유리: 1500"));
                vault_block2.setItem(5, SetItem(items, 5, Material.GREEN_STAINED_GLASS, "초록색 유리: 1500"));
                vault_block2.setItem(6, SetItem(items, 6, Material.LIGHT_BLUE_STAINED_GLASS, "밝은 파란색 유리: 1500"));
                vault_block2.setItem(7, SetItem(items, 7, Material.LIGHT_GRAY_STAINED_GLASS, "밝은 회색 유리: 1500"));
                vault_block2.setItem(8, SetItem(items, 8, Material.LIME_STAINED_GLASS, "라임색 유리: 1500"));
                vault_block2.setItem(9, SetItem(items, 9, Material.MAGENTA_STAINED_GLASS, "마젠타색 유리: 1500"));
                vault_block2.setItem(10, SetItem(items, 10, Material.PINK_STAINED_GLASS, "분홍색 유리: 1500"));
                vault_block2.setItem(11, SetItem(items, 11, Material.ORANGE_STAINED_GLASS, "오렌지색 유리: 1500"));
                vault_block2.setItem(12, SetItem(items, 12, Material.PURPLE_STAINED_GLASS, "보라색 유리: 1500"));
                vault_block2.setItem(13, SetItem(items, 13, Material.RED_STAINED_GLASS, "빨간색 유리: 1500"));
                vault_block2.setItem(14, SetItem(items, 14, Material.WHITE_STAINED_GLASS, "흰색 유리: 1500"));
                vault_block2.setItem(15, SetItem(items, 15, Material.YELLOW_STAINED_GLASS, "노란색 유리: 1500"));
                vault_block2.setItem(16, SetItem(items, 16, Material.BLACK_STAINED_GLASS_PANE, "검은색 유리판: 500"));
                vault_block2.setItem(17, SetItem(items, 17, Material.BLUE_STAINED_GLASS_PANE, "파란색 유리판: 500"));
                vault_block2.setItem(18, SetItem(items, 18, Material.BROWN_STAINED_GLASS_PANE, "갈색 유리판: 500"));
                vault_block2.setItem(19, SetItem(items, 19, Material.CYAN_STAINED_GLASS_PANE, "청록색 유리판: 500"));
                vault_block2.setItem(20, SetItem(items, 20, Material.GRAY_STAINED_GLASS_PANE, "회색 유리판: 500"));
                vault_block2.setItem(21, SetItem(items, 21, Material.GREEN_STAINED_GLASS_PANE, "초록색 유리판: 500"));
                vault_block2.setItem(22, SetItem(items, 22, Material.LIGHT_BLUE_STAINED_GLASS_PANE, "밝은 파란색 유리판: 500"));
                vault_block2.setItem(23, SetItem(items, 23, Material.LIGHT_GRAY_STAINED_GLASS_PANE, "밝은 회색 유리판: 500"));
                vault_block2.setItem(24, SetItem(items, 24, Material.LIME_STAINED_GLASS_PANE, "라임색 유리판: 500"));
                vault_block2.setItem(25, SetItem(items, 25, Material.MAGENTA_STAINED_GLASS_PANE, "마젠타색 유리판: 500"));
                vault_block2.setItem(26, SetItem(items, 26, Material.PINK_STAINED_GLASS_PANE, "분홍색 유리판: 500"));
                vault_block2.setItem(27, SetItem(items, 27, Material.ORANGE_STAINED_GLASS_PANE, "오렌지색 유리판: 500"));
                vault_block2.setItem(28, SetItem(items, 28, Material.PURPLE_STAINED_GLASS_PANE, "보라색 유리판: 500"));
                vault_block2.setItem(29, SetItem(items, 29, Material.RED_STAINED_GLASS_PANE, "빨간색 유리판: 500"));
                vault_block2.setItem(30, SetItem(items, 30, Material.WHITE_STAINED_GLASS_PANE, "흰색 유리판: 500"));
                vault_block2.setItem(31, SetItem(items, 31, Material.YELLOW_STAINED_GLASS_PANE, "노란색 유리판: 500"));
                player.openInventory(vault_block2);
            }
            if (clickedBlockLoc.equals(Arc3Block)&&clickedEntity instanceof ItemFrame){
                vault_block3 = Bukkit.createInventory(player, 36, "Arc3");
                vault_block3.setItem(0, SetItem(items, 0, Material.STONE_BRICKS, "돌: 500"));
                vault_block3.setItem(1, SetItem(items, 1, Material.MOSSY_STONE_BRICKS, "이끼낀 돌: 500"));
                vault_block3.setItem(2, SetItem(items, 2, Material.CRACKED_STONE_BRICKS, "금간 돌: 500"));
                vault_block3.setItem(3, SetItem(items, 3, Material.CHISELED_STONE_BRICKS, "재련된 돌: 500"));
                vault_block3.setItem(4, SetItem(items, 4, Material.BROWN_MUSHROOM_BLOCK, "갈색 버섯: 1000"));
                vault_block3.setItem(5, SetItem(items, 5, Material.RED_MUSHROOM_BLOCK, "빨간 버섯: 1000"));
                vault_block3.setItem(6, SetItem(items, 6, Material.REDSTONE_LAMP, "레드스톤 램프: 1500"));
                vault_block3.setItem(7, SetItem(items, 7, Material.QUARTZ_BLOCK, "대리석: 3000"));
                vault_block3.setItem(8, SetItem(items, 8, Material.CHISELED_QUARTZ_BLOCK, "깎은 대리석: 3500"));
                vault_block3.setItem(9, SetItem(items, 9, Material.PRISMARINE_BRICKS, "프리즈마린 블록: 3000"));
                vault_block3.setItem(10, SetItem(items, 10, Material.PRISMARINE, "프리즈마린: 3000"));
                vault_block3.setItem(11, SetItem(items, 11, Material.DARK_PRISMARINE, "어두운 프리즈마린: 3000"));
                vault_block3.setItem(12, SetItem(items, 12, Material.SEA_LANTERN, "바다 랜턴: 1500"));
                vault_block3.setItem(13, SetItem(items, 13, Material.RED_SANDSTONE, "붉은 샌드스톤: 1000"));
                vault_block3.setItem(14, SetItem(items, 14, Material.PURPUR_BLOCK  , "PURPUR_BLOCK: 2000"));
                vault_block3.setItem(15, SetItem(items, 15, Material.PURPUR_PILLAR  , "PURPUR_PILLAR: 2500"));
                vault_block3.setItem(16, SetItem(items, 16, Material.RED_NETHER_BRICKS, "RED_NETHER_BRICKS: 2000"));
                vault_block3.setItem(17, SetItem(items, 17, Material.TERRACOTTA, "테라코타: 4000"));
                vault_block3.setItem(18, SetItem(items, 18, Material.BLACK_GLAZED_TERRACOTTA, "BLACK_GLAZED_TERRACOTTA: 4000"));
                vault_block3.setItem(19, SetItem(items, 19, Material.BLACK_TERRACOTTA, "BLACK_TERRACOTTA: 4000"));
                vault_block3.setItem(20, SetItem(items, 20, Material.BLUE_GLAZED_TERRACOTTA, "BLUE_GLAZED_TERRACOTTA: 4000"));
                vault_block3.setItem(21, SetItem(items, 21, Material.BLUE_TERRACOTTA, "BLUE_TERRACOTTA: 4000"));
                vault_block3.setItem(22, SetItem(items, 22, Material.BROWN_GLAZED_TERRACOTTA, "BROWN_GLAZED_TERRACOTTA: 4000"));
                vault_block3.setItem(23, SetItem(items, 23, Material.BROWN_TERRACOTTA, "BROWN_TERRACOTTA: 4000"));
                vault_block3.setItem(24, SetItem(items, 24, Material.CYAN_TERRACOTTA, "CYAN_TERRACOTTA: 4000"));
                vault_block3.setItem(25, SetItem(items, 25, Material.CYAN_GLAZED_TERRACOTTA, "CYAN_GLAZED_TERRACOTTA: 4000"));
                vault_block3.setItem(26, SetItem(items, 26, Material.GRAY_GLAZED_TERRACOTTA, "GRAY_GLAZED_TERRACOTTA: 4000"));
                vault_block3.setItem(27, SetItem(items, 27, Material.GRAY_TERRACOTTA, "GRAY_TERRACOTTA: 4000"));
                vault_block3.setItem(28, SetItem(items, 28, Material.GREEN_GLAZED_TERRACOTTA, "GREEN_GLAZED_TERRACOTTA: 4000"));
                vault_block3.setItem(29, SetItem(items, 29, Material.LIME_GLAZED_TERRACOTTA, "LIME_GLAZED_TERRACOTTA: 4000"));
                vault_block3.setItem(30, SetItem(items, 30, Material.LIME_TERRACOTTA, "LIME_TERRACOTTA: 4000"));
                vault_block3.setItem(31, SetItem(items, 31, Material.MAGENTA_GLAZED_TERRACOTTA, "MAGENTA_GLAZED_TERRACOTTA: 4000"));
                vault_block3.setItem(32, SetItem(items, 32, Material.ORANGE_GLAZED_TERRACOTTA, "ORANGE_GLAZED_TERRACOTTA: 4000"));
                vault_block3.setItem(33, SetItem(items, 33, Material.PINK_GLAZED_TERRACOTTA, "PINK_GLAZED_TERRACOTTA: 4000"));
                vault_block3.setItem(34, SetItem(items, 34, Material.PURPLE_GLAZED_TERRACOTTA, "PURPLE_GLAZED_TERRACOTTA: 4000"));
                vault_block3.setItem(35, SetItem(items, 35, Material.RED_GLAZED_TERRACOTTA, "RED_GLAZED_TERRACOTTA: 4000"));
                player.openInventory(vault_block3);}
            if (clickedBlockLoc.equals(Arc4Block)&&clickedEntity instanceof ItemFrame){
                vault_block4 = Bukkit.createInventory(player, 36, "Arc4");
                vault_block4.setItem(0, SetItem(items, 0, Material.CYAN_CARPET, "CYAN_CARPET: 500"));
                vault_block4.setItem(1, SetItem(items, 1, Material.BLACK_CARPET, "BLACK_CARPET: 500"));
                vault_block4.setItem(2, SetItem(items, 2, Material.BLUE_CARPET, "BLUE_CARPET: 500"));
                vault_block4.setItem(3, SetItem(items, 3, Material.BROWN_CARPET, "BROWN_CARPET: 500"));
                vault_block4.setItem(4, SetItem(items, 4, Material.GRAY_CARPET, "GRAY_CARPET: 500"));
                vault_block4.setItem(5, SetItem(items, 5, Material.GREEN_CARPET, "GREEN_CARPET: 500"));
                vault_block4.setItem(6, SetItem(items, 6, Material.LIGHT_BLUE_CARPET, "LIGHT_BLUE_CARPET: 500"));
                vault_block4.setItem(7, SetItem(items, 7, Material.LIGHT_GRAY_CARPET, "LIGHT_GRAY_CARPET: 500"));
                vault_block4.setItem(8, SetItem(items, 8, Material.LIME_CARPET, "LIME_CARPET: 500"));
                vault_block4.setItem(9, SetItem(items, 9, Material.MAGENTA_CARPET, "MAGENTA_CARPET: 500"));
                vault_block4.setItem(10, SetItem(items, 10, Material.ORANGE_CARPET, "ORANGE_CARPET: 500"));
                vault_block4.setItem(11, SetItem(items, 11, Material.PINK_CARPET, "PINK_CARPET: 500"));
                vault_block4.setItem(12, SetItem(items, 12, Material.PURPLE_CARPET, "PURPLE_CARPET: 500"));
                vault_block4.setItem(13, SetItem(items, 13, Material.RED_CARPET, "RED_CARPET: 500"));
                vault_block4.setItem(14, SetItem(items, 14, Material.WHITE_CARPET, "WHITE_CARPET: 500"));
                vault_block4.setItem(15, SetItem(items, 15, Material.YELLOW_CARPET, "YELLOW_CARPET: 500"));
                vault_block4.setItem(16, SetItem(items, 16, Material.BLACK_CONCRETE_POWDER, "BLACK_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(17, SetItem(items, 17, Material.BLUE_CONCRETE_POWDER, "BLUE_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(18, SetItem(items, 18, Material.BROWN_CONCRETE_POWDER, "BROWN_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(19, SetItem(items, 19, Material.CYAN_CONCRETE_POWDER, "CYAN_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(20, SetItem(items, 20, Material.GRAY_CONCRETE_POWDER, "GRAY_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(21, SetItem(items, 21, Material.GREEN_CONCRETE_POWDER, "GREEN_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(22, SetItem(items, 22, Material.LIGHT_BLUE_CONCRETE_POWDER, "LIGHT_BLUE_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(23, SetItem(items, 23, Material.LIGHT_GRAY_CONCRETE_POWDER, "LIGHT_GRAY_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(24, SetItem(items, 24, Material.LIME_CONCRETE_POWDER, "LIME_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(25, SetItem(items, 25, Material.MAGENTA_CONCRETE_POWDER, "MAGENTA_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(26, SetItem(items, 26, Material.ORANGE_CONCRETE_POWDER, "ORANGE_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(27, SetItem(items, 27, Material.PINK_CONCRETE_POWDER, "PINK_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(28, SetItem(items, 28, Material.PURPLE_CONCRETE_POWDER, "PURPLE_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(29, SetItem(items, 29, Material.RED_CONCRETE_POWDER, "RED_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(30, SetItem(items, 30, Material.WHITE_CONCRETE_POWDER, "WHITE_CONCRETE_POWDER: 2000"));
                vault_block4.setItem(31, SetItem(items, 31, Material.YELLOW_CONCRETE_POWDER, "YELLOW_CONCRETE_POWDER: 2000"));
                player.openInventory(vault_block4);
            }
            if (clickedBlockLoc.equals(WeaponsBlock)&&clickedEntity instanceof ItemFrame){
                vault_weapons = Bukkit.createInventory(player, 36, "Weapon_Shop");
                vault_weapons.setItem(0, SetItem(items, 0, Material.DIAMOND_SWORD, "랜덤 인챈트 검: 100,000"));
                vault_weapons.setItem(1, SetItem(items, 1, Material.BOW, "랜덤 인챈트 활: 100,000"));
                vault_weapons.setItem(2, SetItem(items, 2, Material.CROSSBOW, "랜덤 인챈트 석궁: 200,000"));
                vault_weapons.setItem(3, SetItem(items, 3, Material.ARROW, "랜덤 갯수 화살: 10,000"));
                player.openInventory(vault_weapons);
            }
            if (clickedBlockLoc.equals(ArmBlock)&&clickedEntity instanceof ItemFrame) {
                    vault_arm = Bukkit.createInventory(player, 36, "Arm");
                    vault_arm.setItem(0, SetItem(items, 0, Material.LEATHER_HELMET, "가죽 뚝빼기: 1,000"));
                    vault_arm.setItem(1, SetItem(items, 1, Material.LEATHER_CHESTPLATE, "가죽 갑빠: 1,000"));
                    vault_arm.setItem(2, SetItem(items, 2, Material.LEATHER_LEGGINGS, "가죽 다리: 1,000"));
                    vault_arm.setItem(3, SetItem(items, 3, Material.LEATHER_BOOTS, "가죽 신발: 1,000"));
                    vault_arm.setItem(4, SetItem(items, 4, Material.IRON_HELMET, "철 뚝: 10,000"));
                    vault_arm.setItem(5, SetItem(items, 5, Material.IRON_CHESTPLATE, "철 갑빠: 10,000"));
                    vault_arm.setItem(6, SetItem(items, 6, Material.IRON_LEGGINGS, "철 다리: 10,000"));
                    vault_arm.setItem(7, SetItem(items, 7, Material.IRON_BOOTS, "철 신발: 10,000"));
                    vault_arm.setItem(8, SetItem(items, 8, Material.DIAMOND_HELMET, "다이아 뚝: 50,000"));
                    vault_arm.setItem(9, SetItem(items, 9, Material.DIAMOND_CHESTPLATE, "다이아 갑빠: 50,000"));
                    vault_arm.setItem(10, SetItem(items, 10, Material.DIAMOND_LEGGINGS, "다이아 다리: 50,000"));
                    vault_arm.setItem(11, SetItem(items, 11, Material.DIAMOND_BOOTS, "다이아 신발: 10,000"));
                    vault_arm.setItem(12, SetItem(items, 12, Material.DIAMOND_HELMET, "랜덤 인챈트 다이아 뚝빼기: 100,000"));
                    vault_arm.setItem(13, SetItem(items, 13, Material.DIAMOND_CHESTPLATE, "랜덤 인챈트 다이아 갑빠: 100,000"));
                    vault_arm.setItem(14, SetItem(items, 14, Material.DIAMOND_LEGGINGS, "랜덤 인챈트 다이아 다리: 100,000"));
                    vault_arm.setItem(15, SetItem(items, 15, Material.DIAMOND_BOOTS, "랜덤 인챈트 다이아 신발: 100,000"));
                    player.openInventory(vault_arm);
                //e.setCancelled(true);
            }
            if (clickedBlockLoc.equals(UtilsBlock)&&clickedEntity instanceof ItemFrame){
                vault_utils = Bukkit.createInventory(player, 36, "Utils_Shop");
                vault_utils.setItem(0, SetItem(items, 0, Material.DIAMOND_PICKAXE, "랜덤 인챈트 곡괭이: 100,000"));
                vault_utils.setItem(1, SetItem(items, 1, Material.DIAMOND_AXE, "랜덤 인챈트 도끼: 100,000"));
                vault_utils.setItem(2, SetItem(items, 2, Material.DIAMOND_HOE, "랜덤 인챈트 괭이: 100,000"));
                vault_utils.setItem(3, SetItem(items, 3, Material.DIAMOND_SHOVEL, "랜덤 인챈트 삽: 100,000"));
                player.openInventory(vault_utils);
            }
            if (clickedBlockLoc.equals(SpawnerBlock)&&clickedEntity instanceof ItemFrame){
                vault_spawn = Bukkit.createInventory(player, 36, "Spawner");
                vault_spawn.setItem(0, SetItem(items, 0, Material.BLAZE_SPAWN_EGG, "블레이즈 스폰 알: 100,000"));
                vault_spawn.setItem(1, SetItem(items, 1, Material.CAVE_SPIDER_SPAWN_EGG, "동굴 거미 스폰 알: 90,000"));
                vault_spawn.setItem(2, SetItem(items, 2, Material.CREEPER_SPAWN_EGG, "크리퍼 스폰 알: 200,000"));
                vault_spawn.setItem(3, SetItem(items, 3, Material.GHAST_SPAWN_EGG, "가스트 스폰 알: 230,000"));
                vault_spawn.setItem(4, SetItem(items, 4, Material.PHANTOM_SPAWN_EGG, "팬텀 스폰 알: 150,000"));
                vault_spawn.setItem(5, SetItem(items, 5, Material.SPIDER_SPAWN_EGG, "거미 스폰 알: 30,000"));
                vault_spawn.setItem(6, SetItem(items, 6, Material.SKELETON_SPAWN_EGG, "스켈레톤 스폰 알: 50,000"));
                vault_spawn.setItem(7, SetItem(items, 7, Material.WITCH_SPAWN_EGG, "마녀 스폰 알: 100,000"));
                vault_spawn.setItem(8, SetItem(items, 8, Material.ZOMBIFIED_PIGLIN_SPAWN_EGG, "좀비 피그맨 스폰 알: 150,000"));
                vault_spawn.setItem(9, SetItem(items, 9, Material.ZOMBIE_SPAWN_EGG, "좀비 스폰 알: 30,000"));
                player.openInventory(vault_spawn);
            }

        } else return;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(label.equalsIgnoreCase("exchange")) {
                if(args.length == 2) {
                    String type = args[0];
                    String howMuchString = args[1];
                    ItemStack cash = new ItemStack(Material.GOLD_BLOCK);
                    ItemMeta cashMeta = cash.getItemMeta();
                    cashMeta.setDisplayName(ChatColor.GOLD + "$10,000");
                    cash.setItemMeta(cashMeta);
                    int howMuch = Integer.parseInt(howMuchString);
                    Connect_DB connect = new Connect_DB();
                    PlayerLevel PL = new PlayerLevel();
                    String ID = player.getName();
                    GetUserInfo = PlayerLogin.playerInfoMap.get(ID);
                    int Money = (int)GetUserInfo.get(7);
                    if(type.equalsIgnoreCase("toCash")){
                        if(Money >= howMuch){
                            double billDouble = howMuch/10000;
                            int bill = (int)billDouble;
                            if(billDouble - bill != 0){
                                player.sendMessage("환전 단위는 $10,000 입니다.");
                            } else {
                                Money = Money - howMuch;
                                for(int i = 1; i <= bill; i++) {
                                    player.getInventory().addItem(cash);
                                }
                                player.sendMessage("현금 $" + howMuch + "원 환전 완료.");
                            }

                        } else player.sendMessage("잔액이 부족합니다.");

                    }
                    else if(type.equalsIgnoreCase("toAccount")){
                            if(player.getInventory().containsAtLeast(cash, howMuch)){
                                for(int i = 1; i <= howMuch; i++){
                                    player.getInventory().removeItem(cash);
                                }
                                Money = Money + howMuch * 10000;
                                player.sendMessage("지갑에 현금 $" + howMuch*10000 + " 을 입금했습니다.");
                            } else player.sendMessage("입금할 현금이 부족합니다.");
                    }
                    UpdateQuery(ID,Money);
                    PL.ShowBoard(player);
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
        if(Clicked!=null) {
            if (Clicked.equals(vault_block)) {
                Player player = (Player) e.getWhoClicked();
                Connect_DB connect = new Connect_DB();
                PlayerLevel PL = new PlayerLevel();
                String ID = player.getName();
                GetUserInfo = PlayerLogin.playerInfoMap.get(ID);
                int Money = (int) GetUserInfo.get(7);
                ItemStack Selected = e.getCurrentItem();
                if (Selected.equals(items.get(0))) {
                    if (Money >= 100000) {
                        Money = Money - 100000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(1))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(2))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(3))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(4))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(5))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(6))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(7))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(8))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(9))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(10))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(11))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(12))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(13))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(14))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(15))) {
                    if (Money >= 500) {
                        Money = Money - 500;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(16))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(17))) {
                    if (Money >= 1500) {
                        Money = Money - 1500;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(18))) {
                    if (Money >= 1500) {
                        Money = Money - 1500;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(19))) {
                    if (Money >= 1500) {
                        Money = Money - 1500;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(20))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(21))) {
                    if (Money >= 1500) {
                        Money = Money - 1500;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(22))) {
                    if (Money >= 1700) {
                        Money = Money - 1700;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(23))) {
                    if (Money >= 500) {
                        Money = Money - 500;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                }
                UpdateQuery(ID, Money);
                PL.ShowBoard(player);
            }
            if (Clicked.equals(vault_block2)) {
                Player player = (Player) e.getWhoClicked();
                Connect_DB connect = new Connect_DB();
                PlayerLevel PL = new PlayerLevel();
                String ID = player.getName();
                GetUserInfo = PlayerLogin.playerInfoMap.get(ID);
                int Money = (int) GetUserInfo.get(7);
                ItemStack Selected = e.getCurrentItem();

                if ((Selected.equals(items.get(0))) || (Selected.equals(items.get(1))) || (Selected.equals(items.get(2))) ||
                        (Selected.equals(items.get(3))) || (Selected.equals(items.get(4))) || (Selected.equals(items.get(5))) ||
                        (Selected.equals(items.get(6))) || (Selected.equals(items.get(7))) || (Selected.equals(items.get(8))) ||
                        (Selected.equals(items.get(9))) || (Selected.equals(items.get(10))) || (Selected.equals(items.get(11))) ||
                        (Selected.equals(items.get(12))) || (Selected.equals(items.get(13))) || (Selected.equals(items.get(14)))) {
                    if (Money >= 1500) {
                        Money = Money - 1500;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(17))) || (Selected.equals(items.get(18))) || (Selected.equals(items.get(19))) ||
                        (Selected.equals(items.get(20))) || (Selected.equals(items.get(21))) || (Selected.equals(items.get(22))) ||
                        (Selected.equals(items.get(23))) || (Selected.equals(items.get(24))) || (Selected.equals(items.get(25))) ||
                        (Selected.equals(items.get(26))) || (Selected.equals(items.get(27))) || (Selected.equals(items.get(28))) ||
                        (Selected.equals(items.get(29))) || (Selected.equals(items.get(30))) || (Selected.equals(items.get(31))) ||
                        (Selected.equals(items.get(15)))) {
                    if (Money >= 500) {
                        Money = Money - 500;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                }
                UpdateQuery(ID, Money);
                PL.ShowBoard(player);
            }
            if (Clicked.equals(vault_block3)) {
                Player player = (Player) e.getWhoClicked();
                Connect_DB connect = new Connect_DB();
                PlayerLevel PL = new PlayerLevel();
                String ID = player.getName();
                GetUserInfo = PlayerLogin.playerInfoMap.get(ID);
                int Money = (int) GetUserInfo.get(7);
                ItemStack Selected = e.getCurrentItem();

                if ((Selected.equals(items.get(0))) || (Selected.equals(items.get(1)))
                        || (Selected.equals(items.get(2))) || (Selected.equals(items.get(3)))) {
                    if (Money >= 500) {
                        Money = Money - 500;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(4))) || (Selected.equals(items.get(5)))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(6)))) {
                    if (Money >= 1500) {
                        Money = Money - 1500;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(7)))) {
                    if (Money >= 3000) {
                        Money = Money - 3000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(8)))) {
                    if (Money >= 3500) {
                        Money = Money - 3500;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(9)))) {
                    if (Money >= 3000) {
                        Money = Money - 3000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(10)))) {
                    if (Money >= 3000) {
                        Money = Money - 3000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(11)))) {
                    if (Money >= 3000) {
                        Money = Money - 3000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(12)))) {
                    if (Money >= 1500) {
                        Money = Money - 1500;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(13)))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(14)))) {
                    if (Money >= 2000) {
                        Money = Money - 2000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(15)))) {
                    if (Money >= 2500) {
                        Money = Money - 2500;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(16)))) {
                    if (Money >= 2000) {
                        Money = Money - 2000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(17))) || (Selected.equals(items.get(18))) || (Selected.equals(items.get(19))) ||
                        (Selected.equals(items.get(20))) || (Selected.equals(items.get(21))) || (Selected.equals(items.get(22))) ||
                        (Selected.equals(items.get(23))) || (Selected.equals(items.get(24))) || (Selected.equals(items.get(25))) ||
                        (Selected.equals(items.get(26))) || (Selected.equals(items.get(27))) || (Selected.equals(items.get(28))) ||
                        (Selected.equals(items.get(29))) || (Selected.equals(items.get(30))) || (Selected.equals(items.get(31))) ||
                        (Selected.equals(items.get(32))) || (Selected.equals(items.get(33))) || (Selected.equals(items.get(34))) ||
                        (Selected.equals(items.get(35)))) {
                    if (Money >= 4000) {
                        Money = Money - 4000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                }
                UpdateQuery(ID, Money);
                PL.ShowBoard(player);
            }
            if (Clicked.equals(vault_block4)) {
                Player player = (Player) e.getWhoClicked();
                Connect_DB connect = new Connect_DB();
                PlayerLevel PL = new PlayerLevel();
                String ID = player.getName();
                GetUserInfo = PlayerLogin.playerInfoMap.get(ID);
                int Money = (int) GetUserInfo.get(7);
                ItemStack Selected = e.getCurrentItem();

                if ((Selected.equals(items.get(0))) || (Selected.equals(items.get(1))) || (Selected.equals(items.get(2))) ||
                        (Selected.equals(items.get(3))) || (Selected.equals(items.get(4))) || (Selected.equals(items.get(5))) ||
                        (Selected.equals(items.get(6))) || (Selected.equals(items.get(7))) || (Selected.equals(items.get(8))) ||
                        (Selected.equals(items.get(9))) || (Selected.equals(items.get(10))) || (Selected.equals(items.get(11))) ||
                        (Selected.equals(items.get(12))) || (Selected.equals(items.get(13))) || (Selected.equals(items.get(14))) ||
                        (Selected.equals(items.get(15)))) {
                    if (Money >= 500) {
                        Money = Money - 500;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if ((Selected.equals(items.get(17))) || (Selected.equals(items.get(18))) || (Selected.equals(items.get(19))) ||
                        (Selected.equals(items.get(20))) || (Selected.equals(items.get(21))) || (Selected.equals(items.get(22))) ||
                        (Selected.equals(items.get(23))) || (Selected.equals(items.get(24))) || (Selected.equals(items.get(25))) ||
                        (Selected.equals(items.get(26))) || (Selected.equals(items.get(27))) || (Selected.equals(items.get(28))) ||
                        (Selected.equals(items.get(29))) || (Selected.equals(items.get(30))) || (Selected.equals(items.get(31))) ||
                        (Selected.equals(items.get(16)))) {
                    if (Money >= 2000) {
                        Money = Money - 2000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                }
                UpdateQuery(ID, Money);
                PL.ShowBoard(player);
            }
            if (Clicked.equals(vault_weapons)) {
                Player player = (Player) e.getWhoClicked();
                Connect_DB connect = new Connect_DB();
                PlayerLevel PL = new PlayerLevel();
                String ID = player.getName();
                GetUserInfo = PlayerLogin.playerInfoMap.get(ID);
                int Money = (int) GetUserInfo.get(7);
                ItemStack Selected = e.getCurrentItem();
                if (Selected.equals(items.get(0))) {
                    if (Money >= 100000) {
                        Money = Money - 100000;
                        Random rand = new Random();
                        int RandInt_1 = rand.nextInt(100);
                        int RandInt_2 = rand.nextInt(100);
                        int RandInt_3 = rand.nextInt(100);
                        int RandInt_4 = rand.nextInt(100);
                        if (RandInt_1 < 11) {
                            player.sendMessage(ChatColor.RED + "꽝!! set HP = 1!!");
                            player.setHealth(1);
                        } else if (RandInt_1 > 10 && RandInt_1 < 31) {
                            Selected.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 2);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 30 && RandInt_1 < 41) {
                            Selected.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.KNOCKBACK, 4);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 4);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 4);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 40 && RandInt_1 < 51) {
                            Selected.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 3);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 3);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 50 && RandInt_1 < 95) {
                            Selected.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 1);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 94 && RandInt_1 <= 99) {
                            Selected.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 10);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
                                    }
                                }
                            }
                        } else if (RandInt_1 == 100) {
                            Selected.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 25);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.KNOCKBACK, 25);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 25);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 25);
                                    }
                                }
                            }
                        } else {
                            player.sendMessage("꽝!");
                        }
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(1))) {
                    if (Money >= 100000) {
                        Money = Money - 100000;
                        Random rand = new Random();
                        int RandInt_1 = rand.nextInt(100);
                        int RandInt_2 = rand.nextInt(100);
                        int RandInt_3 = rand.nextInt(100);
                        int RandInt_4 = rand.nextInt(100);
                        if (RandInt_1 < 11) {
                            player.sendMessage(ChatColor.RED + "꽝!! set HP = 1!!");
                            player.setHealth(1);
                        } else if (RandInt_1 > 10 && RandInt_1 < 31) {
                            Selected.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 2);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 2);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 30 && RandInt_1 < 41) {
                            Selected.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 4);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 4);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 4);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 40 && RandInt_1 < 51) {
                            Selected.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 3);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 3);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 3);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 3);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 50 && RandInt_1 < 95) {
                            Selected.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 94 && RandInt_1 <= 99) {
                            Selected.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 10);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 10);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 10);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 10);
                                    }
                                }
                            }
                        } else if (RandInt_1 == 100) {
                            Selected.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 25);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 100);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 25);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 25);
                                    }
                                }
                            }
                        } else {
                            player.sendMessage("꽝!");
                        }
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(2))) {
                    if (Money >= 200000) {
                        Money = Money - 200000;
                        Random rand = new Random();
                        int RandInt_1 = rand.nextInt(100);
                        int RandInt_2 = rand.nextInt(100);
                        int RandInt_3 = rand.nextInt(100);
                        int RandInt_4 = rand.nextInt(100);
                        int RandInt_5 = rand.nextInt(100);
                        int RandInt_6 = rand.nextInt(100);
                        int RandInt_7 = rand.nextInt(100);
                        if (RandInt_1 < 11) {
                            player.sendMessage(ChatColor.RED + "꽝!! set HP = 1!!");
                            player.setHealth(1);
                        } else if (RandInt_1 > 10 && RandInt_1 < 31) {
                            Selected.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 2);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.QUICK_CHARGE, 2);
                                        if (RandInt_5 % 2 == 0) {
                                            Selected.addUnsafeEnchantment(Enchantment.PIERCING, 2);
                                            if (RandInt_6 % 2 == 0) {
                                                Selected.addUnsafeEnchantment(Enchantment.MULTISHOT, 2);
                                                if (RandInt_7 % 2 == 0) {
                                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (RandInt_1 > 30 && RandInt_1 < 41) {
                            Selected.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 4);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 4);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.QUICK_CHARGE, 4);
                                        if (RandInt_5 % 2 == 0) {
                                            Selected.addUnsafeEnchantment(Enchantment.PIERCING, 4);
                                            if (RandInt_6 % 2 == 0) {
                                                Selected.addUnsafeEnchantment(Enchantment.MULTISHOT, 4);
                                                if (RandInt_7 % 2 == 0) {
                                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 4);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (RandInt_1 > 40 && RandInt_1 < 51) {
                            Selected.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 3);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 3);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 3);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.QUICK_CHARGE, 3);
                                        if (RandInt_5 % 2 == 0) {
                                            Selected.addUnsafeEnchantment(Enchantment.PIERCING, 3);
                                            if (RandInt_6 % 2 == 0) {
                                                Selected.addUnsafeEnchantment(Enchantment.MULTISHOT, 3);
                                                if (RandInt_7 % 2 == 0) {
                                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 3);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (RandInt_1 > 50 && RandInt_1 < 95) {
                            Selected.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.QUICK_CHARGE, 1);
                                        if (RandInt_5 % 2 == 0) {
                                            Selected.addUnsafeEnchantment(Enchantment.PIERCING, 1);
                                            if (RandInt_6 % 2 == 0) {
                                                Selected.addUnsafeEnchantment(Enchantment.MULTISHOT, 1);
                                                if (RandInt_7 % 2 == 0) {
                                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (RandInt_1 > 94 && RandInt_1 <= 99) {
                            Selected.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 10);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 10);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 10);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.QUICK_CHARGE, 10);
                                        if (RandInt_5 % 2 == 0) {
                                            Selected.addUnsafeEnchantment(Enchantment.PIERCING, 10);
                                            if (RandInt_6 % 2 == 0) {
                                                Selected.addUnsafeEnchantment(Enchantment.MULTISHOT, 10);
                                                if (RandInt_7 % 2 == 0) {
                                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 10);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (RandInt_1 == 100) {
                            Selected.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 25);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 25);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 25);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.QUICK_CHARGE, 25);
                                        if (RandInt_5 % 2 == 0) {
                                            Selected.addUnsafeEnchantment(Enchantment.PIERCING, 25);
                                            if (RandInt_6 % 2 == 0) {
                                                Selected.addUnsafeEnchantment(Enchantment.MULTISHOT, 25);
                                                if (RandInt_7 % 2 == 0) {
                                                    Selected.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 25);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            player.sendMessage("꽝!");
                        }
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(3))) {
                    if (Money >= 10000) {
                        Money = Money - 10000;
                        Random rand = new Random();
                        int RandInt_1 = rand.nextInt(100);
                        int i;
                        for (i = 0; i < RandInt_1; i++) {
                            player.getInventory().addItem(Selected);
                        }
                        player.sendMessage("화살" + Integer.toString(i) + "개가 지급되었습니다.");
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else e.setCancelled(true);

                UpdateQuery(ID, Money);
                PL.ShowBoard(player);
            }
            if (Clicked.equals(vault_arm)) {
                Player player = (Player) e.getWhoClicked();
                Connect_DB connect = new Connect_DB();
                PlayerLevel PL = new PlayerLevel();
                String ID = player.getName();
                GetUserInfo = PlayerLogin.playerInfoMap.get(ID);
                int Money = (int) GetUserInfo.get(7);
                ItemStack Selected = e.getCurrentItem();
                if (Selected.equals(items.get(0))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(1))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(2))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(3))) {
                    if (Money >= 1000) {
                        Money = Money - 1000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(4))) {
                    if (Money >= 10000) {
                        Money = Money - 10000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(5))) {
                    if (Money >= 10000) {
                        Money = Money - 10000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(6))) {
                    if (Money >= 10000) {
                        Money = Money - 10000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(7))) {
                    if (Money >= 10000) {
                        Money = Money - 10000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(8))) {
                    if (Money >= 50000) {
                        Money = Money - 50000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(9))) {
                    if (Money >= 50000) {
                        Money = Money - 50000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(10))) {
                    if (Money >= 50000) {
                        Money = Money - 50000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(11))) {
                    if (Money >= 50000) {
                        Money = Money - 50000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(12))) {
                    if (Money >= 100000) {
                        Money = Money - 100000;
                        Random rand = new Random();
                        int RandInt_1 = rand.nextInt(100);
                        int RandInt_2 = rand.nextInt(100);
                        int RandInt_3 = rand.nextInt(100);
                        int RandInt_4 = rand.nextInt(100);
                        if (RandInt_1 < 11) {
                            player.sendMessage("꽝!");
                        } else if (RandInt_1 > 10 && RandInt_1 < 31) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.OXYGEN, 2);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 30 && RandInt_1 < 41) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.OXYGEN, 4);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 40 && RandInt_1 < 51) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.OXYGEN, 3);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 50 && RandInt_1 < 95) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.OXYGEN, 1);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 94 && RandInt_1 <= 100) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 10);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.OXYGEN, 10);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 10);
                                    }
                                }
                            }
                        } else {
                            player.sendMessage("꽝!");
                        }
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(13))) {
                    if (Money >= 100000) {
                        Money = Money - 100000;
                        Random rand = new Random();
                        int RandInt_1 = rand.nextInt(99);
                        int RandInt_2 = rand.nextInt(99);
                        int RandInt_3 = rand.nextInt(99);
                        int RandInt_4 = rand.nextInt(99);
                        if (RandInt_1 < 11) {
                            player.sendMessage("꽝!");
                        } else if (RandInt_1 > 10 && RandInt_1 < 31) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 30 && RandInt_1 < 41) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 40 && RandInt_1 < 51) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 50 && RandInt_1 < 95) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 94 && RandInt_1 <= 100) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 10);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 10);
                                        Selected.addUnsafeEnchantment(Enchantment.THORNS, 10);
                                    }
                                }
                            }
                        } else {
                            player.sendMessage("꽝!");
                        }
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(14))) {
                    if (Money >= 100000) {
                        Money = Money - 100000;
                        Random rand = new Random();
                        int RandInt_1 = rand.nextInt(99);
                        int RandInt_2 = rand.nextInt(99);
                        int RandInt_3 = rand.nextInt(99);
                        int RandInt_4 = rand.nextInt(99);
                        if (RandInt_1 < 11) {
                            player.sendMessage("꽝!");
                        } else if (RandInt_1 > 10 && RandInt_1 < 31) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 30 && RandInt_1 < 41) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 40 && RandInt_1 < 51) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 50 && RandInt_1 < 95) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 94 && RandInt_1 <= 100) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 10);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 10);
                                    }
                                }
                            }
                        } else {
                            player.sendMessage("꽝!");
                        }
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(15))) {
                    if (Money >= 100000) {
                        Money = Money - 100000;
                        Random rand = new Random();
                        int RandInt_1 = rand.nextInt(99);
                        int RandInt_2 = rand.nextInt(99);
                        int RandInt_3 = rand.nextInt(99);
                        int RandInt_4 = rand.nextInt(99);
                        if (RandInt_1 < 11) {
                            player.sendMessage("꽝!");
                        } else if (RandInt_1 > 10 && RandInt_1 < 31) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 2);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 30 && RandInt_1 < 41) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 40 && RandInt_1 < 51) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 3);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 50 && RandInt_1 < 95) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 1);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 94 && RandInt_1 <= 100) {
                            Selected.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 10);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 10);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 10);
                                    }
                                }
                            }
                        } else {
                            player.sendMessage("꽝!");
                        }
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else e.setCancelled(true);
                UpdateQuery(ID, Money);
                PL.ShowBoard(player);
            }
            if (Clicked.equals(vault_utils)){
                Player player = (Player) e.getWhoClicked();
                Connect_DB connect = new Connect_DB();
                PlayerLevel PL = new PlayerLevel();
                String ID = player.getName();
                GetUserInfo = PlayerLogin.playerInfoMap.get(ID);
                int Money = (int) GetUserInfo.get(7);
                ItemStack Selected = e.getCurrentItem();
                if (Selected.equals(items.get(0))) {
                    if (Money >= 100000) {
                        Money = Money - 100000;
                        Random rand = new Random();
                        int RandInt_1 = rand.nextInt(100);
                        int RandInt_2 = rand.nextInt(100);
                        int RandInt_3 = rand.nextInt(100);
                        int RandInt_4 = rand.nextInt(100);
                        if (RandInt_1 < 11) {
                            player.sendMessage(ChatColor.RED + "꽝!! set HP = 1!!");
                            player.setHealth(1);
                        } else if (RandInt_1 > 10 && RandInt_1 < 31) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 2);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 2);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 30 && RandInt_1 < 41) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 4);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 4);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 40 && RandInt_1 < 51) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 3);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 3);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 50 && RandInt_1 < 95) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 94 && RandInt_1 <= 99) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 10);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
                                    }
                                }
                            }
                        } else if (RandInt_1 == 100) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 25);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 25);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 25);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 25);
                                    }
                                }
                            }
                        } else {
                            player.sendMessage("꽝!");
                        }
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(1))) {
                    if (Money >= 100000) {
                        Money = Money - 100000;
                        Random rand = new Random();
                        int RandInt_1 = rand.nextInt(100);
                        int RandInt_2 = rand.nextInt(100);
                        int RandInt_3 = rand.nextInt(100);
                        int RandInt_4 = rand.nextInt(100);
                        if (RandInt_1 < 11) {
                            player.sendMessage(ChatColor.RED + "꽝!! set HP = 1!!");
                            player.setHealth(1);
                        } else if (RandInt_1 > 10 && RandInt_1 < 31) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 2);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 2);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 30 && RandInt_1 < 41) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 4);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 4);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 40 && RandInt_1 < 51) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 3);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 3);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 50 && RandInt_1 < 95) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 94 && RandInt_1 <= 99) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 10);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
                                    }
                                }
                            }
                        } else if (RandInt_1 == 100) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 25);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 25);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 25);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 25);
                                    }
                                }
                            }
                        } else {
                            player.sendMessage("꽝!");
                        }
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(2))) {
                    if (Money >= 100000) {
                        Money = Money - 100000;
                        Random rand = new Random();
                        int RandInt_1 = rand.nextInt(100);
                        int RandInt_2 = rand.nextInt(100);
                        int RandInt_3 = rand.nextInt(100);
                        int RandInt_4 = rand.nextInt(100);
                        if (RandInt_1 < 11) {
                            player.sendMessage(ChatColor.RED + "꽝!! set HP = 1!!");
                            player.setHealth(1);
                        } else if (RandInt_1 > 10 && RandInt_1 < 31) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 2);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 2);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 30 && RandInt_1 < 41) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 4);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 4);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 40 && RandInt_1 < 51) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 3);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 3);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 50 && RandInt_1 < 95) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 94 && RandInt_1 <= 99) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 10);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
                                    }
                                }
                            }
                        } else if (RandInt_1 == 100) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 25);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 25);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 25);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 25);
                                    }
                                }
                            }
                        } else {
                            player.sendMessage("꽝!");
                        }
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(3))) {
                    if (Money >= 100000) {
                        Money = Money - 100000;
                        Random rand = new Random();
                        int RandInt_1 = rand.nextInt(100);
                        int RandInt_2 = rand.nextInt(100);
                        int RandInt_3 = rand.nextInt(100);
                        int RandInt_4 = rand.nextInt(100);
                        if (RandInt_1 < 11) {
                            player.sendMessage(ChatColor.RED + "꽝!! set HP = 1!!");
                            player.setHealth(1);
                        } else if (RandInt_1 > 10 && RandInt_1 < 31) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 2);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 2);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 30 && RandInt_1 < 41) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 4);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 4);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 4);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 40 && RandInt_1 < 51) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 3);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 3);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 50 && RandInt_1 < 95) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
                                    }
                                }
                            }
                        } else if (RandInt_1 > 94 && RandInt_1 <= 99) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 10);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
                                    }
                                }
                            }
                        } else if (RandInt_1 == 100) {
                            Selected.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 25);
                            if (RandInt_2 % 2 == 0) {
                                Selected.addUnsafeEnchantment(Enchantment.DIG_SPEED, 25);
                                if (RandInt_3 % 2 == 0) {
                                    Selected.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 25);
                                    if (RandInt_4 % 2 == 0) {
                                        Selected.addUnsafeEnchantment(Enchantment.DURABILITY, 25);
                                    }
                                }
                            }
                        } else {
                            player.sendMessage("꽝!");
                        }
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else e.setCancelled(true);
            }
            if (Clicked.equals(vault_spawn)){
                Player player = (Player) e.getWhoClicked();
                Connect_DB connect = new Connect_DB();
                PlayerLevel PL = new PlayerLevel();
                String ID = player.getName();
                GetUserInfo = PlayerLogin.playerInfoMap.get(ID);
                int Money = (int) GetUserInfo.get(7);
                ItemStack Selected = e.getCurrentItem();
                if (Selected.equals(items.get(0))) {
                    if (Money >= 100000) {
                        Money = Money - 100000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(1))) {
                    if (Money >= 90000) {
                        Money = Money - 90000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(2))) {
                    if (Money >= 200000) {
                        Money = Money - 200000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(3))) {
                    if (Money >= 230000) {
                        Money = Money - 230000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(4))) {
                    if (Money >= 150000) {
                        Money = Money - 150000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(5))) {
                    if (Money >= 30000) {
                        Money = Money - 30000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(6))) {
                    if (Money >= 50000) {
                        Money = Money - 50000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(7))) {
                    if (Money >= 100000) {
                        Money = Money - 100000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(8))) {
                    if (Money >= 150000) {
                        Money = Money - 150000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                } else if (Selected.equals(items.get(9))) {
                    if (Money >= 30000) {
                        Money = Money - 30000;
                        player.getInventory().addItem(Selected);
                        e.setCancelled(true);
                    } else e.setCancelled(true);
                }
                UpdateQuery(ID, Money);
                PL.ShowBoard(player);
            }

        }
    }

    public void UpdateQuery(String ID, int Money){
        /*
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
         */
        GetUserInfo = PlayerLogin.playerInfoMap.get(ID);
        GetUserInfo.set(7, Money);
        PlayerLogin.playerInfoMap.replace(ID, GetUserInfo);
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
