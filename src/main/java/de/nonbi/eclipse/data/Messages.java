package de.nonbi.eclipse.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Messages {

    private static JavaPlugin plugin;
    private static File configFile;
    private static FileConfiguration file;

    public Messages(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        configFile = new File(plugin.getDataFolder(), "messages.yml");

        if (!configFile.exists()) {
            plugin.saveResource("messages.yml", false); // Kopiert die Datei aus resources
        }

        file = YamlConfiguration.loadConfiguration(configFile);
    }

    public static void reloadMessages() {
        file = YamlConfiguration.loadConfiguration(configFile);
    }

    public static Boolean isJoinMsgEnabled() {
        return file.getBoolean("player.join.message.enabled");
    }

    public static String getJoinMsg(Player player, String prefix) {
        return file.getString("player.join.message.message")
                .replace("%player%", player.getName())
                .replace("%prefix%", prefix);
    }

    public static Boolean isQuitMsgEnabled() {
        return file.getBoolean("player.quit.message.enabled");
    }

    public static String getQuitMsg(Player player, String prefix) {
        return file.getString("player.quit.message.message")
                .replace("%player%", player.getName())
                .replace("%prefix%", prefix);
    }

    public static String getMaintenanceKickMsg() {
        return file.getString("maintenance.kick.message")
                .replace("\n", "\n")
                .replace("&", "§");
    }
}