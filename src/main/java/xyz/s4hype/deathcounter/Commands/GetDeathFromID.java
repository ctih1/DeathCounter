package xyz.s4hype.deathcounter.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.s4hype.deathcounter.Tools.Modify;

public class GetDeathFromID implements CommandExecutor {
    Player player;
    int id;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Modify.init();
        if(args.length!=0) {
            player = Bukkit.getPlayer(args[0]);
            id = Integer.parseInt(args[1]);
        }
        else {
            player = (Player) sender;
            id = Integer.parseInt(args[0]);
        }
        if(player==null) {
            sender.sendMessage(String.format("Invalid player %s'%s'%s", ChatColor.BOLD,args[0], ChatColor.RESET));
            return false;
        }
        sender.sendMessage(String.format("Death info of %s%s%s of id %s%s%s: %s",
                ChatColor.BOLD,
                player.getDisplayName(),
                ChatColor.RESET,
                ChatColor.GOLD,
                id,
                ChatColor.RESET,
                Modify.GetFromList(String.valueOf(player.getUniqueId()),id)
            ));
        return true;
    }
}
