package dev.huls.elysium_farm.inventories;

import dev.huls.elysium_farm.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class SeedChangeInventory {

    public static Inventory seedChangeInventory;

    public SeedChangeInventory() {
        seedChangeInventory = Bukkit.createInventory(null, 36, "§8Troca de Sementes");
        initializeItems();
    }

    private void initializeItems() {
        seedChangeInventory.setItem(11, new ItemBuilder(Material.BEETROOT)
                .name("§cBeterraba")
                .lore("§7Essa semente é inicial")
                .lore("§7e não pode ser trocada.")
                .build());

        seedChangeInventory.setItem(12, new ItemBuilder(Material.NETHER_WART)
                .name("§cFungo")
                .lore("")
                .lore(" §fRequisitos de troca:  ")
                .lore(" §8\uD83E\uDC92 §f50x §7Beterrabas.   ")
                .lore("")
                .lore("§fClique para trocar.")
                .build());

        seedChangeInventory.setItem(13, new ItemBuilder(Material.POTATO)
                .name("§eBatata")
                .lore("")
                .lore(" §fRequisitos de troca:  ")
                .lore(" §8\uD83E\uDC92 §f25x §7Fungos.   ")
                .lore("")
                .lore("§fClique para trocar.")
                .build());

        seedChangeInventory.setItem(14, new ItemBuilder(Material.CARROT)
                .name("§cIndisponível")
                .lore("§7Esta semente está bloqueada")
                .lore("§7para troca no momento.")
                .build());

        seedChangeInventory.setItem(15, new ItemBuilder(Material.WHEAT)
                .name("§cIndisponível")
                .lore("§7Esta semente está bloqueada")
                .lore("§7para troca no momento.")
                .build());

        seedChangeInventory.setItem(20, new ItemBuilder(Material.PUMPKIN)
                .name("§cIndisponível")
                .lore("§7Esta semente está bloqueada")
                .lore("§7para troca no momento.")
                .build());

        seedChangeInventory.setItem(21, new ItemBuilder(Material.MELON)
                .name("§cIndisponível")
                .lore("§7Esta semente está bloqueada")
                .lore("§7para troca no momento.")
                .build());
}

    public static Inventory getSeedChangeInventory() {
        return seedChangeInventory;
    }
}