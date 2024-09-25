package dev.huls.elysium_farm.items;

import dev.huls.elysium_farm.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FarmsBuild {

    public static ItemStack beterraba = new ItemBuilder(Material.BEETROOT)
            .name("§cBeterraba")
            .lore("§fValor: §6✪10,000")
            .lore("")
            .lore("§fVenda-a em §7/vender§a.")
            .build();

    public static ItemStack fungo = new ItemBuilder(Material.NETHER_WART)
            .name("§cFungo")
            .lore("§fValor: §6✪125,000")
            .lore("")
            .lore("§fVenda-a em §7/vender§a.")
            .build();

    public static ItemStack batata = new ItemBuilder(Material.POTATO)
            .name("§eBatata")
            .lore("§fValor: §6✪450,000")
            .lore("")
            .lore("§fVenda-a em §7/vender§a.")
            .build();
}
