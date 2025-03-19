package de.nonbi.eclipse.listener;

import de.nonbi.eclipse.data.Config;
import de.nonbi.eclipse.data.Messages;
import de.nonbi.eclipse.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class PlayerListener implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        if (Messages.isJoinMsgEnabled()) {
            event.setJoinMessage(Messages.getJoinMsg(event.getPlayer(), Config.getPrefix()));
        }

        event.getPlayer().sendMessage(PlayerData.getPlayerUuid(event.getPlayer().getUniqueId()));
    }

    @EventHandler
    public static void onPlayerQuit(PlayerQuitEvent event) {
        if (Messages.isQuitMsgEnabled()) {
            event.setQuitMessage(Messages.getQuitMsg(event.getPlayer(), Config.getPrefix()));
        }
    }

    @EventHandler
    public static void onPlayerPreLogin(PlayerPreLoginEvent event) {
        UUID playerUUID = event.getUniqueId();

        // Falls der Spieler nicht in der Datenbank existiert, hinzufügen
        if (PlayerData.getPlayerUuid(playerUUID) == null) {
            PlayerData.addPlayer(playerUUID);
        }

        // Falls der Spieler keine Berechtigung für Wartung hat -> kicken
        if (Config.isMaintenance()) {
            if (!PlayerData.isMaintenanceAllowed(playerUUID)) {
                event.disallow(PlayerPreLoginEvent.Result.KICK_OTHER, Messages.getMaintenanceKickMsg());
            }
        }
    }
}
