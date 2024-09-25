package dev.huls.elysium_farm;

import dev.huls.elysium_farm.commands.FarmlandGiveCommand;
import dev.huls.elysium_farm.commands.SeedChangeCommand;
import dev.huls.elysium_farm.commands.SellCommand;
import dev.huls.elysium_farm.inventories.SeedChangeInventory;
import dev.huls.elysium_farm.listeners.*;
import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    private PlayerPointsAPI ppAPI;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new CancelInventoryDragListener(), this);
        Bukkit.getPluginManager().registerEvents(new SeedChangeListener(), this);
        Bukkit.getPluginManager().registerEvents(new FarmCollectListener(), this);
        Bukkit.getPluginManager().registerEvents(new FarmlandChangeListener(), this);
        Bukkit.getPluginManager().registerEvents(new FarmlandPlaceListener(), this);
        Objects.requireNonNull(getCommand("farmland")).setExecutor(new FarmlandGiveCommand());
        Objects.requireNonNull(getCommand("sementes")).setExecutor(new SeedChangeCommand());
        Objects.requireNonNull(getCommand("vender")).setExecutor(new SellCommand());
        SeedChangeInventory seedChangeInventory = new SeedChangeInventory();

        if (Bukkit.getPluginManager().isPluginEnabled("PlayerPoints")) {
            this.ppAPI = PlayerPoints.getInstance().getAPI();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
