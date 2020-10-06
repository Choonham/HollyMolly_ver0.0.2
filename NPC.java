package com.jun.hollymolly;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_15_R1.CraftServer;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//HollyMollyPlugIn ver.0.0.2(latest release on 2020.10.06)
public class NPC {
    private static List<EntityPlayer> NPC = new ArrayList<EntityPlayer>();
    public static void createNPC(Player player){
        MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer world = ((CraftWorld) Bukkit.getWorld(player.getWorld().getName())).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "What the hack");
        EntityPlayer npc = new EntityPlayer(server, world, gameProfile, new PlayerInteractManager(world));
        npc.setLocation(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ()
                ,player.getLocation().getYaw(), player.getLocation().getPitch());
        addNPCPacket(npc);
        NPC.add(npc);
    }
    public static void clearNPC(Player player){
        NPC.clear();
    }
    public static void addNPCPacket(EntityPlayer npc){
        for(Player player: Bukkit.getOnlinePlayers()){
            PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
            connection.sendPacket(new PacketPlayOutEntityEquipment(npc.getBukkitEntity().getEntityId(), EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(new ItemStack(Material.IRON_AXE))));
            connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (npc.yaw * 256/360)));
        }
    }
    public static void addJoinPacket(Player player){
        for(EntityPlayer npc: NPC){
            PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
            connection.sendPacket(new PacketPlayOutEntityEquipment(npc.getBukkitEntity().getEntityId(), EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(new ItemStack(Material.IRON_AXE))));
            connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (npc.yaw * 256/360)));
        }
    }
    public static List<EntityPlayer> getNPCs() {
        return NPC;
    }
}
