package dev.huls.elysium_farm.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Farmland;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.MoistureChangeEvent;

public class FarmlandPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Block block = event.getBlockPlaced();
        if (block.getType() == Material.FARMLAND) {

            setFarmlandWet(block);
        }
    }

    @EventHandler
    public void onMoistureChange(MoistureChangeEvent event) {
        Block block = event.getBlock();
        if(block.getType() == Material.FARMLAND) {
            event.setCancelled(true);
        }
    }

    private void setFarmlandWet(Block block) {
        BlockData blockData = block.getBlockData();
        if (blockData instanceof Farmland) {
            Farmland farmland = (Farmland) blockData;
            farmland.setMoisture(farmland.getMaximumMoisture()); // Define o nível máximo de umidade (molhado)
            block.setBlockData(farmland);
        }
    }
}