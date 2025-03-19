package de.nonbi.eclipse;

import de.nonbi.eclipse.utils.Config;
import de.nonbi.eclipse.utils.Messages;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main main;

    @Override
    public void onEnable() {
        // Plugin startup logic
        main = this;
        new Config(this);
        new Messages(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return main;
    }
}
