package dev.huls.elysium_farm.listeners;

import dev.huls.elysium_farm.items.FarmsBuild;
import org.bukkit.CropState;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.material.Crops;

public class FarmCollectListener implements Listener {

    @EventHandler
    public void onSeedPlace(BlockBreakEvent event) {
        if (!(event.getBlock().getType() == Material.BEETROOTS) || (event.getBlock().getType() == Material.NETHER_WART)) return;

        Block block = event.getBlock();
        BlockState state = block.getState();

        if (state.getData() instanceof Crops) {
            Crops crops = (Crops) state.getData();

            if (crops.getState() == CropState.RIPE) {
                event.setCancelled(true);
                event.getBlock().getDrops().clear();

                switch(event.getBlock().getType()) {
                    case BEETROOTS -> event.getPlayer().getInventory().addItem(FarmsBuild.beterraba);
                    case NETHER_WART -> event.getPlayer().getInventory().addItem(FarmsBuild.fungo);
                    case POTATO -> event.getPlayer().getInventory().addItem(FarmsBuild.batata);
                }
                crops.setState(CropState.MEDIUM);
                state.setData(crops);
                state.update(true);
            } else {
                event.setCancelled(true);
            }
        }
    }
}