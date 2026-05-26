package com.fabian.gamemodeplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class GamemodePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Rejestrujemy komendę
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getLogger().info("GamemodePlugin został załadowany!");
    }

    @Override
    public void onDisable() {
        getLogger().info("GamemodePlugin został wyładowany!");
    }
}
