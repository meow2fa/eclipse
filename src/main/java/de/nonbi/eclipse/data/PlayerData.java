package de.nonbi.eclipse.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class PlayerData {
    private static JavaPlugin plugin;
    private static File dataFile;
    private static FileConfiguration dataConfig;

    public PlayerData(JavaPlugin plugin) {
        PlayerData.plugin = plugin;
        loadDataFile();
    }

    private void loadDataFile() {
        dataFile = new File(plugin.getDataFolder(), "data/players.yml");

        if (!dataFile.exists()) {
            dataFile.getParentFile().mkdirs(); // Erstelle Verzeichnisse, falls sie nicht existieren
            plugin.saveResource("data/players.yml", false);
        }

        dataConfig = YamlConfiguration.loadConfiguration(dataFile);
    }

    public static void saveDataFile() {
        try {
            dataConfig.save(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPlayerUuid(UUID uuid) {
        return dataConfig.getString(uuid + ".uuid");
    }

    public static Boolean isMaintenanceAllowed(UUID uuid) {
        return  dataConfig.getBoolean(uuid + ".whitelist");
    }

    public static void addPlayer(UUID uuid) {
        String path = uuid.toString();

        if (!dataConfig.contains(path)) { // Nur hinzufügen, wenn der Spieler nicht existiert
            dataConfig.set(path + ".uuid", uuid.toString());
            dataConfig.set(path + ".whitelist", false);
            saveDataFile();
        }
    }
}
