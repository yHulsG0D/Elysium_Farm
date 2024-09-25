package dev.huls.elysium_farm.items;

import dev.huls.elysium_farm.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FarmlandBuild {

    public static ItemStack farmland = new ItemBuilder(Material.FARMLAND)
            .name("§aTerra arada §a§linfinita")
            .lore("§7Coloque este bloco")
            .lore("§7em seu terreno para")
            .lore("§7gerar uma terra arada.")
            .lore("")
            .lore("§aColoque-o no terreno.")
            .build();
}
