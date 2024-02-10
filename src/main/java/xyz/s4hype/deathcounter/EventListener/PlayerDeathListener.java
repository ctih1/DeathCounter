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
    String time;
    String formattedNumber;
    public PlayerDeathListener() {
        deathCounter = DeathCounter.getInstance();
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Modify.init();
        if(event != null && event.getEntity() != null) {
            player = event.getEntity();
            System.out.println(player.getDisplayName());
            if(deathCounter==null) {
                deathCounter = DeathCounter.getInstance();
            }
            time = deathCounter.getConfig().getString(String.valueOf(player.getUniqueId())+".amount");
            if(time==null) {
                time = "0";
            }
            formattedNumber = NumberFormat.addOrdinalSuffix(Integer.parseInt(time));
            System.out.println(time);
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
            deathCounter.getServer().broadcastMessage(" ");
            Modify.Increment(String.valueOf(player.getUniqueId()),1,event.getDeathMessage());
        }
    }
}
