package dev.huls.elysium_farm.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;

public class CancelInventoryDragListener implements Listener {

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        if(event.getView().getTitle().equalsIgnoreCase("§8Troca de Sementes")) {
        event.setCancelled(true);
        }
    }
}
