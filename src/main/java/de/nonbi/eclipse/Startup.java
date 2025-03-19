package de.nonbi.eclipse;

import de.nonbi.eclipse.data.Config;

public class Startup {
    public Startup(Main plugin) {
        if (Config.isMaintenance()) {
            plugin.getServer().setMotd(Config.getMaintenanceMotdFirst() + "\n" + Config.getMaintenanceMotdSecond());
        }
    }
}
