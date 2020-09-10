package com.jun.hollymolly;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import java.util.Random;

public class PlayerStuff implements Listener {
    public HashMap<Player, ItemStack[]> items = new HashMap<>();

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        if (items.containsKey(event.getPlayer())) {
            event.getPlayer().getInventory().clear();
            for (ItemStack stack : items.get(event.getPlayer())) {
                if (stack != null) {
                    event.getPlayer().getInventory().addItem(stack);
                }
            }
            items.remove(event.getPlayer());
        }
    }

    @EventHandler()
    public void onDeath(PlayerDeathEvent e) {
        e.getEntity();
        ItemStack[] content = e.getEntity().getInventory().getContents();
        items.put(e.getEntity(), content);
        e.getDrops().clear();
    }

}
