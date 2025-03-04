package xyz.s4hype.deathcounter.EventListener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import xyz.s4hype.deathcounter.DeathCounter;
import xyz.s4hype.deathcounter.Tools.NumberFormat;
import xyz.s4hype.deathcounter.Tools.Modify;

public class PlayerDeathListener implements Listener {

    DeathCounter deathCounter;
    Player player;
    int timesDied;
    String formattedNumber;

    public PlayerDeathListener() {
        deathCounter = DeathCounter.getInstance();
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if(event == null || event.getEntity() == null ) {
            return;
        }

        Modify.init();

        player = event.getEntity();

        timesDied = deathCounter.getConfig().getInt(String.valueOf(player.getUniqueId())+".amount");

        formattedNumber = NumberFormat.addOrdinalSuffix(timesDied);

        deathCounter.getServer().broadcastMessage(" ");
        deathCounter.getServer().broadcastMessage(String.format(
                "%s%s%s died: %s* %s *%s this is their %s%s%s time.",
                ChatColor.BOLD,
                player.getDisplayName(),
                ChatColor.RESET,
                ChatColor.ITALIC,
                event.getDeathMessage(),
                ChatColor.RESET,
                ChatColor.GOLD,
                formattedNumber,
                ChatColor.RESET
            )
        );

        Modify.Increment(String.valueOf(player.getUniqueId()),1,event.getDeathMessage());
    }
}
