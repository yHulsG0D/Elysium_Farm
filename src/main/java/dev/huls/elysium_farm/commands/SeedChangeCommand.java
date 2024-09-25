package dev.huls.elysium_farm.commands;

import dev.huls.elysium_farm.inventories.SeedChangeInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SeedChangeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem executar este comando!");
            return false;
        }
        Player player = (Player) sender;
        player.openInventory(SeedChangeInventory.getSeedChangeInventory());
        return false;
    }
}
