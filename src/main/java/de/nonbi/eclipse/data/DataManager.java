package de.nonbi.eclipse.data;

import de.nonbi.eclipse.Main;

public class DataManager {
    public DataManager(Main plugin) {
        new Config(plugin);
        new Messages(plugin);
        new PlayerData(plugin);
    }
}
