package de.nonbi.eclipse.listener;

import de.nonbi.eclipse.Main;

public class ListenerRegisterHandler {
    public static void init(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(new PlayerListener(), plugin);
    }
}
