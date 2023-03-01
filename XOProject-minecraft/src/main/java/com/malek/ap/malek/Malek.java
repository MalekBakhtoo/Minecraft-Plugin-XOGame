package com.malek.ap.malek;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Malek extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(getServer().getPluginCommand("challenge")).setExecutor(new challenge());
        Objects.requireNonNull(getServer().getPluginCommand("deny")).setExecutor(new denyChallenge());
        Objects.requireNonNull(getServer().getPluginCommand("accept")).setExecutor(new Accept());
        Objects.requireNonNull(getServer().getPluginCommand("save")).setExecutor(new save());
        Objects.requireNonNull(getServer().getPluginCommand("put")).setExecutor(new Put());
        getServer().getPluginManager().registerEvents(new PutClick(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}