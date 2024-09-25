package dev.huls.elysium_farm.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

public class FarmlandChangeListener implements Listener {

    @EventHandler
    public void farmlandChange(BlockFadeEvent event) {
        if (event.getBlock().getType() == Material.FARMLAND) {
            event.setCancelled(true);
        }
    }
}