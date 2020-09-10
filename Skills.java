package com.jun.hollymolly;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;

public class Skills implements Listener {
    PlayerLevel PL = new PlayerLevel();
    Connect_DB connect = new Connect_DB();
    ArrayList<Object> GetPlayerInfo = new ArrayList<Object>();
    HashMap<String, Long> ArcSkill1CoolTime = new HashMap<String, Long>();
    HashMap<String, Long> ArcSkill2CoolTime = new HashMap<String, Long>();
    HashMap<String, Long> ArcSkill3CoolTime = new HashMap<String, Long>();

    HashMap<String, Long> predatorSkill1CoolTime = new HashMap<String, Long>();
    HashMap<String, Long> predatorSkill2CoolTime = new HashMap<String, Long>();
    HashMap<String, Long> predatorSkill3CoolTime = new HashMap<String, Long>();

    HashMap<String, Long> hunterSkill1CoolTime = new HashMap<String, Long>();
    HashMap<String, Long> hunterSkill2CoolTime = new HashMap<String, Long>();
    HashMap<String, Long> hunterSkill3CoolTime = new HashMap<String, Long>();

    HashMap<String, Long> FlashSkill3CoolTime = new HashMap<String, Long>();


    @SuppressWarnings("deprecation")
    @EventHandler
    public void PlayerSkill(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        String ID = p.getName();
        World currentWorld = p.getWorld();
        Action action = e.getAction();

        GetPlayerInfo = PL.GetUserInfo(ID);
        int LV = (int) GetPlayerInfo.get(1);
        String Class = (String) GetPlayerInfo.get(3);
        //************각 직업별 10랩 스킬
        if ((action.equals(Action.LEFT_CLICK_BLOCK)||(action.equals(Action.LEFT_CLICK_AIR)))
                && (p.getItemInHand().getType().equals(Material.COAL))){
            if(Class.equals("Arc") && LV > 10){
                if(ArcSkill1CoolTime.containsKey(p.getName())){
                    if(ArcSkill1CoolTime.get(p.getName())>System.currentTimeMillis()) {
                        long timeleft = (ArcSkill1CoolTime.get(p.getName()) - System.currentTimeMillis())/1000;
                        p.sendMessage("cooldown left: " + timeleft);
                        return;
                    }
                }
                ArcSkill1CoolTime.put(p.getName(), System.currentTimeMillis() + (5*1000));
            Block b = p.getTargetBlock(null,10);
            int x = b.getX();
            int y = b.getY();
            int z = b.getZ();
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++) {
                    Block w1 = currentWorld.getBlockAt(x - 2 + i, y+j, z - 2);
                    Block w2 = currentWorld.getBlockAt(x - 2 + i, y+j, z + 2);
                    Block w3 = currentWorld.getBlockAt(x - 2, y+j, z - 2 + i);
                    Block w4 = currentWorld.getBlockAt(x + 2, y+j, z - 2 + i);
                    w1.setType(Material.IRON_BLOCK);
                    w2.setType(Material.IRON_BLOCK);
                    w3.setType(Material.IRON_BLOCK);
                    w4.setType(Material.IRON_BLOCK);
                }
                }
            }
            if(Class.equals("hunter") && LV > 10){
                if(hunterSkill1CoolTime.containsKey(p.getName())){
                    if(hunterSkill1CoolTime.get(p.getName())>System.currentTimeMillis()) {
                        long timeleft = (hunterSkill1CoolTime.get(p.getName()) - System.currentTimeMillis())/1000;
                        p.sendMessage("cooldown left: " + timeleft);
                        return;
                    }
                }
                hunterSkill1CoolTime.put(p.getName(), System.currentTimeMillis() + (10*1000));
                e.getPlayer().launchProjectile(Fireball.class);
            }
            if(Class.equals("predator")){
                if(predatorSkill1CoolTime.containsKey(p.getName())){
                    if(predatorSkill1CoolTime.get(p.getName())>System.currentTimeMillis()) {
                        long timeleft = (predatorSkill1CoolTime.get(p.getName()) - System.currentTimeMillis())/1000;
                        p.sendMessage("cooldown left: " + timeleft);
                        return;
                    }
                }
                predatorSkill1CoolTime.put(p.getName(), System.currentTimeMillis() + (60*1000));
                p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,300,1));
            }
        }
        //************각 직업별 10랩 스킬

        //************Flash********//
        if (action.equals(Action.LEFT_CLICK_BLOCK)||(action.equals(Action.LEFT_CLICK_AIR))
                && p.getItemInHand().getType().equals(Material.GOLDEN_CARROT)){
            if(FlashSkill3CoolTime.containsKey(p.getName())){
                if(FlashSkill3CoolTime.get(p.getName())>System.currentTimeMillis()) {
                    long timeleft = (FlashSkill3CoolTime.get(p.getName()) - System.currentTimeMillis())/1000;
                    p.sendMessage("cooldown left: " + timeleft);
                    return;
                }
            }
            FlashSkill3CoolTime.put(p.getName(), System.currentTimeMillis() + (1*1000));
            Block b = p.getTargetBlock(null,3);

            Location pLoc = p.getLocation();
            Location bLoc = b.getLocation();

            int px = pLoc.getBlockX();
            int py = pLoc.getBlockY();
            int pz = pLoc.getBlockZ();

            int bx = bLoc.getBlockX();
            int by = bLoc.getBlockY();
            int bz = bLoc.getBlockZ();

        }
        //************Flash********//
    }
}
