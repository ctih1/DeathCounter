package xyz.s4hype.deathcounter.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.s4hype.deathcounter.Tools.Modify;
import xyz.s4hype.deathcounter.Tools.NumberFormat;

public class GetDeaths implements CommandExecutor {

    Player player;
    int amount;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Modify.init();
        if(args.length!=0) {
            player = Bukkit.getPlayer(args[0]);
        }
        else {
            player = (Player) sender;
        }
        if(player==null) {
            sender.sendMessage(String.format("%sInvalid player %s'%s'%s",ChatColor.RED,ChatColor.BOLD,args[0], ChatColor.RESET));
            return false;
        }
        amount = Modify.Get(String.valueOf(player.getUniqueId()));
        sender.sendMessage(String.format(
                "%s%s%s has died %s%s%s time(s)",
                ChatColor.BOLD,
                player.getDisplayName(),
                ChatColor.RESET,
                ChatColor.GOLD,
                NumberFormat.addOrdinalSuffix(amount),
                ChatColor.RESET
        ));
        return true;
    }
}
