package dev.huls.elysium_farm.commands;

import dev.huls.elysium_farm.utils.Formatter;
import dev.huls.elysium_farm.utils.NumberFormatter;
import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Arrays;

public class SellCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem executar este comando.");
            return false;
        }
        Player player = (Player) sender;
        Inventory inventory = player.getInventory();

        int beetrootTotal = Arrays.stream(inventory.getContents())
                .filter(item -> item != null && item.getType() == Material.BEETROOT)
                .mapToInt(ItemStack::getAmount)
                .sum() * 10000;

        // Calcula o total de fungos e multiplica por 125.000
        int mushroomTotal = Arrays.stream(inventory.getContents())
                .filter(item -> item != null && (item.getType() == Material.NETHER_WART))
                .mapToInt(ItemStack::getAmount)
                .sum() * 125000;

        // Calcula o total de batatas e multiplica por 450.000
        int potatoTotal = Arrays.stream(inventory.getContents())
                .filter(item -> item != null && item.getType() == Material.POTATO)
                .mapToInt(ItemStack::getAmount)
                .sum() * 450000;

        // Soma total dos valores calculados
        int totalValue = beetrootTotal + mushroomTotal + potatoTotal;

        // Verifica se o total é 0 e envia uma mensagem ao jogador
        if (totalValue == 0) {
            player.sendMessage("§cVocê não tem farms para vender.");
            return true;
        } else {
            // Adiciona o valor total ao jogador
            player.getInventory().remove(Material.BEETROOT);
            player.getInventory().remove(Material.NETHER_WART);
            player.getInventory().remove(Material.POTATO);
            PlayerPointsAPI ppAPI = PlayerPoints.getInstance().getAPI();
            if (ppAPI != null) {
                ppAPI.give(player.getUniqueId(), totalValue);
                player.sendMessage("§6Você vendeu suas farms por §6✪" + NumberFormatter.formatBigDecimal(BigDecimal.valueOf(totalValue)) + "§6.");
                return true;
            }
        }
        return false;
    }
}
