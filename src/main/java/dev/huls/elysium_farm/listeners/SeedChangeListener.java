package dev.huls.elysium_farm.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SeedChangeListener implements Listener {

    @EventHandler
    public void onSeedChange(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("§8Troca de Sementes")) {
            event.setCancelled(true);

            final ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem == null || clickedItem.getType().isAir()) return;

            final Player player = (Player) event.getWhoClicked();
            if(event.getRawSlot() == 12) {
                if (player.getInventory().contains(Material.BEETROOT_SEEDS, 50)) {
                    player.getInventory().removeItem(new ItemStack(Material.BEETROOT_SEEDS, 50));
                    player.getInventory().addItem(new ItemStack(Material.NETHER_WART, 1));
                    player.sendMessage("§e§lGG! §aTroca realizada! §c§l-50x §cBeterrabas por §c§l+1x §cFungo.");
                } else {
                    player.sendMessage("§cVocê não possui sementes suficientes para realizar a troca!");
                    player.closeInventory();
                }
            }
        }
    }
}
