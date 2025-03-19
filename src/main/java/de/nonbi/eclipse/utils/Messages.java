package de.nonbi.eclipse.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class Messages {

    private static JavaPlugin plugin;
    private static File configFile;
    private static FileConfiguration config;

    public Messages(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        configFile = new File(plugin.getDataFolder(), "messages.yml");

        if (!configFile.exists()) {
            plugin.saveResource("messages.yml", false); // Kopiert die Datei aus resources
        }

        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static String getPlayerJoinMessage() {
        return config.getString("player.server.join");
    }
}