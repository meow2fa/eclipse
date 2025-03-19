package de.nonbi.eclipse;

import de.nonbi.eclipse.data.DataManager;
import de.nonbi.eclipse.listener.ListenerRegisterHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main main;

    @Override
    public void onEnable() {
        // Plugin startup logic
        main = this;
        new DataManager(this);
        new Startup(this);
        ListenerRegisterHandler.init(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return main;
    }
}
