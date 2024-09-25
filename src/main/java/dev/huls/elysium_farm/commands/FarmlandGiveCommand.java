package dev.huls.elysium_farm.commands;

import dev.huls.elysium_farm.items.FarmlandBuild;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class FarmlandGiveCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem executar este comando.");
            return false;
        }
        Player player = (Player) sender;
        player.getInventory().addItem(FarmlandBuild.farmland);
        player.getInventory().addItem(new ItemStack(Material.BEETROOT_SEEDS, 64));
        player.sendMessage("§aVocê recebeu uma terra arada e sementes para iniciar o cultivo.");
        return false;
    }
}