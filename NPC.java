package com.jun.hollymolly;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.server.v1_16_R2.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R2.CraftServer;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R2.inventory.CraftItemStack;
import org.bukkit.entity.Player;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//HollyMollyPlugIn ver.0.0.2(latest release on 2020.10.20)
public class NPC {
    private static List<EntityPlayer> NPC = new ArrayList<EntityPlayer>();
    public static void createNPC(Player player, String skin){
        MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer world = ((CraftWorld) Bukkit.getWorld(player.getWorld().getName())).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), skin);
        EntityPlayer npc = new EntityPlayer(server, world, gameProfile, new PlayerInteractManager(world));
        npc.setLocation(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ()
                ,player.getLocation().getYaw(), player.getLocation().getPitch());
        String[] name = getSkin(player, skin);
        gameProfile.getProperties().put("textures", new Property("textures", name[0], name[1]));
        addNPCPacket(npc);
        NPC.add(npc);
    }

    public static void RemoveNPC(Player player, String skin){
        MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer world = ((CraftWorld) Bukkit.getWorld(player.getWorld().getName())).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), skin);
        EntityPlayer npc = new EntityPlayer(server, world, gameProfile, new PlayerInteractManager(world));
        NPC.clear();
        RemoveNPCPacket(npc);
    }
    //303e7c79ccb04a59a675cc923931c32d
    private static String[] getSkin(Player player, String name){
        try{
            URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + name);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            String uuid = new JsonParser().parse(reader).getAsJsonObject().get("id").getAsString();
            URL url2 = new URL("https://sessionserver.mojang.com/session/minecraft/profile/"+uuid+"?unsigned=false");
            InputStreamReader reader2 = new InputStreamReader(url2.openStream());
            JsonObject  property = new JsonParser().parse(reader2).getAsJsonObject().get("properties").getAsJsonArray().get(0).getAsJsonObject();
            String texture = property.get("value").getAsString();
            String signature = property.get("signature").getAsString();
            return new String[] {texture, signature};
        } catch(Exception e){
            EntityPlayer p = ((CraftPlayer)player).getHandle();
            GameProfile profile = p.getProfile();
            Property property = profile.getProperties().get("textures").iterator().next();
            String texture = property.getValue();
            String signature = property.getSignature();
            return new String[] {texture, signature};
        }
    }
    public static void clearNPC(Player player){
        NPC.clear();
    }
    public static void addNPCPacket(EntityPlayer npc){
        for(Player player: Bukkit.getOnlinePlayers()){
            PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
            //connection.sendPacket(new PacketPlayOutEntityEquipment(npc.getBukkitEntity().getEntityId(), EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(new ItemStack(Material.IRON_AXE))));
            connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (npc.yaw * 256/360)));
        }
    }
    public static void RemoveNPCPacket(EntityPlayer npc){
        for(Player player: Bukkit.getOnlinePlayers()){
            PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));
            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
            //connection.sendPacket(new PacketPlayOutEntityEquipment(npc.getBukkitEntity().getEntityId(), EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(new ItemStack(Material.IRON_AXE))));
            //connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (npc.yaw * 256/360)));
        }
    }
    public static void addJoinPacket(Player player){
        for(EntityPlayer npc: NPC){
            PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
            //connection.sendPacket(new PacketPlayOutEntityEquipment(npc.getBukkitEntity().getEntityId(), EnumItemSlot.MAINHAND, CraftItemStack.asBukkitCopy(new ItemStack()));
            connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (npc.yaw * 256/360)));
            //npc.getBukkitEntity().getEntityId(), EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(new ItemStack(Material.IRON_AXE)))
        }
    }
    public static List<EntityPlayer> getNPCs() {
        return NPC;
    }
}
