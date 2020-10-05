package com.jun.hollymolly;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.BlockProjectileSource;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//HollyMollyPlugIn ver.0.0.2(latest release on 2020.09.29)
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
    static boolean isCool = false;

    @EventHandler
    public void PlayerGetRequirments(PlayerBedEnterEvent e){
        Player player = (Player) e.getPlayer();
        if(player==null){return;}
        String ID = player.getName();
        GetPlayerInfo = PlayerLogin.playerInfoMap.get(ID);
        int LV = (int) GetPlayerInfo.get(1);
        Inventory inventory = player.getInventory();
        ItemStack requirment10 = new ItemStack(Material.COAL);
        ItemStack requirment20 = new ItemStack(Material.SUNFLOWER);
        ItemStack requirment30 = new ItemStack(Material.LILAC);
        if(LV<10) return;
        if(LV>=10) {
            ItemMeta requirment10Meta = requirment10.getItemMeta();
            requirment10Meta.setDisplayName("10랩 스킬");
            requirment10.setItemMeta(requirment10Meta);
            if(!inventory.contains(requirment10)){
                inventory.addItem(requirment10);
            }
        }
        if(LV>=20){
            ItemMeta requirment20Meta = requirment20.getItemMeta();
            requirment20Meta.setDisplayName("20랩 스킬");
            requirment20.setItemMeta(requirment20Meta);
            if(!inventory.contains(requirment20)){
                inventory.addItem(requirment20);
            }
        }
        if(LV>=30){
            ItemMeta requirment30Meta = requirment30.getItemMeta();
            requirment30Meta.setDisplayName("30랩 스킬");
            requirment30.setItemMeta(requirment30Meta);
            if(!inventory.contains(requirment30)){
                inventory.addItem(requirment30);
            }
        }


    }
    @SuppressWarnings("deprecation")
    @EventHandler
    public void PlayerSkill(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        String ID = p.getName();
        World currentWorld = p.getWorld();
        Action action = e.getAction();
        NPC NPC = new NPC();
        GetPlayerInfo = PlayerLogin.playerInfoMap.get(ID);
        int LV = (int) GetPlayerInfo.get(1);
        String Class = (String) GetPlayerInfo.get(3);
        /*
        if ((p.getLocation().getBlockX() < 105) && (p.getLocation().getBlockX() > -185)) {
            if ((p.getLocation().getBlockZ() < 131) && (p.getLocation().getBlockZ() > -251)) {
                p.sendMessage(ChatColor.RED +"Public property에서는 스킬 사용이 불가능합니다.");
                return;
            }
        }

         */
        //************각 직업별 10랩 스킬
        if ((action.equals(Action.LEFT_CLICK_BLOCK)||(action.equals(Action.LEFT_CLICK_AIR)))
                && (p.getItemInHand().getType().equals(Material.COAL)) && (p.getItemInHand().getItemMeta().getDisplayName().equals("10랩 스킬"))){
            if(Class.equals("Arc") && LV > 9){
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
            if(Class.equals("hunter") && LV > 9){
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
            if(Class.equals("predator")&&LV > 9){
                if(predatorSkill1CoolTime.containsKey(p.getName())){
                    if(predatorSkill1CoolTime.get(p.getName())>System.currentTimeMillis()) {
                        long timeleft = (predatorSkill1CoolTime.get(p.getName()) - System.currentTimeMillis())/1000;
                        p.sendMessage("cooldown left: " + timeleft);
                        return;
                    }
                }
                predatorSkill1CoolTime.put(p.getName(), System.currentTimeMillis() + (20*1000));
                p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,300,1));
            }
        }
        //************각 직업별 10랩 스킬

        //************각 직업별 20랩 스킬
        if ((action.equals(Action.LEFT_CLICK_BLOCK)||(action.equals(Action.LEFT_CLICK_AIR)))
                && (p.getItemInHand().getType().equals(Material.SUNFLOWER))&& (p.getItemInHand().getItemMeta().getDisplayName().equals("20랩 스킬"))) {
            if(Class.equals("Arc")&& LV >= 20) {
                if(ArcSkill2CoolTime.containsKey(p.getName())){
                    if(ArcSkill2CoolTime.get(p.getName())>System.currentTimeMillis()) {
                        long timeleft = (ArcSkill2CoolTime.get(p.getName()) - System.currentTimeMillis())/1000;
                        p.sendMessage("cooldown left: " + timeleft);
                        return;
                    }
                }
                ArcSkill2CoolTime.put(p.getName(), System.currentTimeMillis() + (10*1000));
                Location PlayerLoc = p.getLocation();
                int x = PlayerLoc.getBlockX();
                int y = PlayerLoc.getBlockY();
                int z = PlayerLoc.getBlockZ();
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++) {
                        Block w1 = currentWorld.getBlockAt(x - 1 + i, y+j, z - 1);
                        Block w2 = currentWorld.getBlockAt(x - 1 + i, y+j, z + 1);
                        Block w3 = currentWorld.getBlockAt(x - 1, y+j, z - 1 + i);
                        Block w4 = currentWorld.getBlockAt(x + 1, y+j, z - 1 + i);
                        w1.setType(Material.OBSIDIAN);
                        w2.setType(Material.OBSIDIAN);
                        w3.setType(Material.OBSIDIAN);
                        w4.setType(Material.OBSIDIAN);
                    }
                }
                Block w5 = currentWorld.getBlockAt(x, y+2, z);
                Block u = currentWorld.getBlockAt(x, y-1, z);
                u.setType(Material.OBSIDIAN);
                w5.setType(Material.OBSIDIAN);
                p.sendMessage("콩!!!!");

            }
            if(Class.equals("hunter")&& LV >= 20) {
                if((hunterSkill2CoolTime.containsKey(p.getName()))){
                    if(hunterSkill2CoolTime.get(p.getName())>System.currentTimeMillis()) {
                        long timeleft = (hunterSkill2CoolTime.get(p.getName()) - System.currentTimeMillis())/1000;
                        p.sendMessage("cooldown left: " + timeleft);
                        return;
                    }
                }
                hunterSkill2CoolTime.put(p.getName(), System.currentTimeMillis() + (15*1000));
                int X = p.getLocation().getBlockX();
                int Y = p.getLocation().getBlockY();
                int Z = p.getLocation().getBlockZ();
                List<Location> LocAvobeList = new ArrayList<Location>();
                Location playerLoc = new Location(p.getWorld(), X, Y+1, Z);
                Block b = p.getTargetBlock(null, 10);
                Location bloc = b.getLocation();
                Vector v = bloc.toVector().subtract(playerLoc.toVector());
                //playerLoc.setPitch(playerLoc.getPitch() + PL.rand.nextInt(10));
                for(int i = 0; i <= 12; i++) {
                    playerLoc.getWorld().spawnArrow(playerLoc, v, (float) 8, (float) i);
                }
            }
            if(Class.equals("predator")&& LV >= 20) {
                if(predatorSkill2CoolTime.containsKey(p.getName())){
                    if(predatorSkill2CoolTime.get(p.getName())>System.currentTimeMillis()) {
                        long timeleft = (predatorSkill2CoolTime.get(p.getName()) - System.currentTimeMillis())/1000;
                        p.sendMessage("cooldown left: " + timeleft);
                        return;
                    }
                }
                NPC.clearNPC(p);
                predatorSkill2CoolTime.put(p.getName(), System.currentTimeMillis() + (10*1000));
                NPC.createNPC(p);
                predatorSkill1CoolTime.clear();
                FlashSkill3CoolTime.clear();
            }
        }
        //************각 직업별 20랩 스킬

        if ((action.equals(Action.LEFT_CLICK_BLOCK)||(action.equals(Action.LEFT_CLICK_AIR)))
                && (p.getItemInHand().getType().equals(Material.LILAC))&& (p.getItemInHand().getItemMeta().getDisplayName().equals("30랩 스킬"))) {
            if(Class.equals("Arc")&& LV >= 30){
                if(ArcSkill3CoolTime.containsKey(p.getName())){
                    if(ArcSkill3CoolTime.get(p.getName())>System.currentTimeMillis()) {
                        long timeleft = (ArcSkill3CoolTime.get(p.getName()) - System.currentTimeMillis())/1000;
                        p.sendMessage("cooldown left: " + timeleft);
                        return;
                    }
                }
                ArcSkill3CoolTime.put(p.getName(), System.currentTimeMillis() + (5*1000));
                Block b = p.getTargetBlock(null,10);
                int x = b.getX();
                int y = b.getY();
                int z = b.getZ();
                Block w1 = currentWorld.getBlockAt(x,y,z);
                Block w2 = currentWorld.getBlockAt(x,y-1,z);
                w1.setType(Material.TNT);
                w2.setType(Material.REDSTONE_BLOCK);

            }
            if(Class.equals("predator")&& LV >= 30){
                    if(predatorSkill3CoolTime.containsKey(p.getName())){
                        if(predatorSkill3CoolTime.get(p.getName())>System.currentTimeMillis()) {
                            long timeleft = (predatorSkill3CoolTime.get(p.getName()) - System.currentTimeMillis())/1000;
                            p.sendMessage("cooldown left: " + timeleft);
                            return;
                        }
                    }
                    predatorSkill3CoolTime.put(p.getName(), System.currentTimeMillis() + (10*1000));
                for(Player player: Bukkit.getOnlinePlayers()) {
                    int i = 1;
                    p.sendMessage(i + "번: " + player.getName() + ", 위치: X: " + player.getLocation().getBlockX()
                            + ", Y: " + player.getLocation().getBlockY() + ", Z: " + player.getLocation().getBlockZ());
                    i++;
                }

            }
            if(Class.equals("hunter")&& LV >= 30){
                if(hunterSkill3CoolTime.containsKey(p.getName())){
                    if(hunterSkill3CoolTime.get(p.getName())>System.currentTimeMillis()) {
                        long timeleft = (hunterSkill3CoolTime.get(p.getName()) - System.currentTimeMillis())/1000;
                        p.sendMessage("cooldown left: " + timeleft);
                        isCool = true;
                        return;
                    }
                }
                hunterSkill3CoolTime.put(p.getName(), System.currentTimeMillis() + (1*1000));
                p.launchProjectile(Trident.class);
                isCool = false;
            }

        }

            //************Cancel Action********//
        if ((action.equals(Action.RIGHT_CLICK_BLOCK)||(action.equals(Action.RIGHT_CLICK_AIR)))
                && (p.getItemInHand().getType().equals(Material.SUNFLOWER))){
            if(Class.equals("Arc")&& LV >= 20){
                Location PlayerLoc = p.getLocation();
                int x = PlayerLoc.getBlockX();
                int y = PlayerLoc.getBlockY();
                int z = PlayerLoc.getBlockZ();
                Block w5 = currentWorld.getBlockAt(x, y+2, z);
                if(w5.getType().equals(Material.OBSIDIAN)){
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 3; j++) {
                            Block w1 = currentWorld.getBlockAt(x - 1 + i, y+j, z - 1);
                            Block w2 = currentWorld.getBlockAt(x - 1 + i, y+j, z + 1);
                            Block w3 = currentWorld.getBlockAt(x - 1, y+j, z - 1 + i);
                            Block w4 = currentWorld.getBlockAt(x + 1, y+j, z - 1 + i);
                            w1.setType(Material.AIR);
                            w2.setType(Material.AIR);
                            w3.setType(Material.AIR);
                            w4.setType(Material.AIR);
                        }
                    }
                    w5.setType(Material.AIR);
                }
            }
        }
        //************Flash********//
        if ((action.equals(Action.LEFT_CLICK_BLOCK)||(action.equals(Action.LEFT_CLICK_AIR)))
                && (p.getItemInHand().getType().equals(Material.GOLDEN_CARROT))){
            if(FlashSkill3CoolTime.containsKey(p.getName())){
                if(FlashSkill3CoolTime.get(p.getName())>System.currentTimeMillis()) {
                    long timeleft = (FlashSkill3CoolTime.get(p.getName()) - System.currentTimeMillis())/1000;
                    p.sendMessage("cooldown left: " + timeleft);
                    return;
                }
            }
            FlashSkill3CoolTime.put(p.getName(), System.currentTimeMillis() + (30*1000));
            String Dir = rpGetPlayerDirection(p);
            Location pLoc = p.getLocation();
            double pX = pLoc.getX();
            double pY = pLoc.getY();
            double pZ = pLoc.getZ();
            float yaw = (float)pLoc.getYaw();
            if(Dir.equals("west")) {
                Location Flash = new Location(p.getWorld(), pX, pY, pZ + 6, yaw, 1);
                p.teleport(Flash);

            } else if(Dir.equals("west northwest")){
                Location Flash = new Location(p.getWorld(), pX - 3, pY, pZ + 6, yaw, 1);
                p.teleport(Flash);
            } else if(Dir.equals("northwest")){
                Location Flash = new Location(p.getWorld(), pX - 6, pY, pZ + 6, yaw, 1);
                p.teleport(Flash);
            } else if(Dir.equals("north northwest")){
                Location Flash = new Location(p.getWorld(), pX - 6, pY, pZ + 3, yaw, 1);
                p.teleport(Flash);
            } else if(Dir.equals("north")){
                Location Flash = new Location(p.getWorld(), pX - 6, pY, pZ, yaw, 1);
                p.teleport(Flash);
            } else if(Dir.equals("north northeast")){
                Location Flash = new Location(p.getWorld(), pX - 6, pY, pZ -3, yaw, 1);
                p.teleport(Flash);
            } else if(Dir.equals("northeast")){
                Location Flash = new Location(p.getWorld(), pX - 6, pY, pZ -6, yaw, 1);
                p.teleport(Flash);
            } else if(Dir.equals("east northeast")){
                Location Flash = new Location(p.getWorld(), pX -3, pY, pZ - 6, yaw, 1);
                p.teleport(Flash);
            } else if(Dir.equals("east")){
                Location Flash = new Location(p.getWorld(), pX, pY, pZ - 6, yaw, 1);
                p.teleport(Flash);
            } else if(Dir.equals("east southeast")){
                Location Flash = new Location(p.getWorld(), pX + 3, pY, pZ - 6, yaw, 1);
                p.teleport(Flash);
            } else if(Dir.equals("southeast")){
                Location Flash = new Location(p.getWorld(), pX + 6, pY, pZ - 6, yaw, 1);
                p.teleport(Flash);
            } else if(Dir.equals("south southeast")){
                Location Flash = new Location(p.getWorld(), pX + 6, pY, pZ - 3, yaw, 1);
                p.teleport(Flash);
            } else if(Dir.equals("south")){
                Location Flash = new Location(p.getWorld(), pX + 6, pY, pZ, yaw, 1);
                p.teleport(Flash);
            } else if(Dir.equals("south southwest")){
                Location Flash = new Location(p.getWorld(), pX + 6, pY, pZ + 3, yaw, 1);
                p.teleport(Flash);
            } else if(Dir.equals("southwest")){
                Location Flash = new Location(p.getWorld(), pX + 6, pY, pZ + 6, yaw, 1);
                p.teleport(Flash);
            } else {
                Location Flash = new Location(p.getWorld(), pX + 3, pY, pZ + 6, yaw, 1);
               p.teleport(Flash);;
            }
            }
        }
    @EventHandler
    public void ProjectileHit(EntityDamageByEntityEvent e){
        if (e.getDamager() instanceof Trident) {
            Trident sn = (Trident)e.getDamager();
            if (sn.getShooter() instanceof Player) {
                if(!isCool){
                    Entity getHit = (Entity)e.getEntity();
                    getHit.setFireTicks(1000);
                }
            }
        }
    }
    public String rpGetPlayerDirection(Player playerSelf) {
        String dir = "";
        float y = playerSelf.getLocation().getYaw();
        if( y < 0 ){y += 360;}
        y %= 360;
        int i = (int)((y+8) / 22.5);
        if(i == 0){dir = "west";}
        else if(i == 1){dir = "west northwest";}
        else if(i == 2){dir = "northwest";}
        else if(i == 3){dir = "north northwest";}
        else if(i == 4){dir = "north";}
        else if(i == 5){dir = "north northeast";}
        else if(i == 6){dir = "northeast";}
        else if(i == 7){dir = "east northeast";}
        else if(i == 8){dir = "east";}
        else if(i == 9){dir = "east southeast";}
        else if(i == 10){dir = "southeast";}
        else if(i == 11){dir = "south southeast";}
        else if(i == 12){dir = "south";}
        else if(i == 13){dir = "south southwest";}
        else if(i == 14){dir = "southwest";}
        else if(i == 15){dir = "west southwest";}
        else {dir = "west";}
        return dir;
    }
        //************Flash********//
}
