package com.malek.ap.malek;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Objects;

public class PutClick implements Listener {

    @EventHandler
    public void put (PlayerInteractEvent e){
        if(e.getHand() == EquipmentSlot.OFF_HAND){
            Material material = e.getPlayer().getTargetBlock(null , 1000).getType();
            if(material==Material.WHITE_WOOL){
                int pos = Accept.locations.indexOf(Objects.requireNonNull(e.getPlayer().getTargetBlockExact(1000)).getLocation())+1;
                e.getPlayer().performCommand("put " +pos);
            }
        }
    }
}
