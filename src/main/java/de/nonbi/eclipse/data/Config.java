package de.nonbi.eclipse.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Config {

    private static JavaPlugin plugin;
    private static File configFile;
    private static FileConfiguration config;

    public Config(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        configFile = new File(plugin.getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            plugin.saveResource("config.yml", false); // Kopiert die Datei aus resources
        }

        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static String getPrefix() {
        return config.getString("server.prefix", "&x&4&2&0&5&A&5E&x&5&1&1&7&B&3c&x&5&F&2&9&C&1l&x&6&E&3&C&D&0i&x&7&D&4&E&D&Ep&x&8&B&6&0&E&Cs&x&9&A&7&2&F&Ae &7➪ &r").replace("&", "§");
    }

    public static Boolean isMaintenance() {
        return config.getBoolean("maintenance.enabled");
    }

    public static String getMaintenanceMotdFirst() {
        return config.getString("maintenance.motd.first")
                .replace("&", "§");
    }

    public static String getMaintenanceMotdSecond() {
        return config.getString("maintenance.motd.second")
                .replace("&", "§");
    }
}