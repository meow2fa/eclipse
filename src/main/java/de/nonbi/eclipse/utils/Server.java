package de.nonbi.eclipse.utils;

import org.bukkit.Bukkit;

public class Server {
    public static void shout(String message) {
        Bukkit.getConsoleSender().sendMessage(message);
    }

    public static void warn(String message) {
        Bukkit.getConsoleSender().sendMessage("§8[§6⚠§8] §e" + message);
    }

    public static void info(String message) {
        Bukkit.getConsoleSender().sendMessage("§8[§3ℹ§8] §b" + message);
    }

    public static void error(String message) {
        Bukkit.getConsoleSender().sendMessage("§8[§4✖§8] §c" + message);
    }

    public static void success(String message) {
        Bukkit.getConsoleSender().sendMessage("§8[§2✔§8] §a" + message);
    }
}
