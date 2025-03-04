package xyz.s4hype.deathcounter.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.s4hype.deathcounter.Tools.Modify;

public class SetDeaths implements CommandExecutor {
    int amount;
    Player player;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Modify.init();

        if(args.length==2) {
            player = Bukkit.getPlayer(args[0]);
            amount = Integer.parseInt(args[1]);
        }
        else {
            player = (Player) sender;
            amount = Integer.parseInt(args[0]);
        }
        if(player==null) {
            sender.sendMessage(String.format("Invalid player %s'%s'%s",ChatColor.BOLD,args[0],ChatColor.RESET));
            return false;
        }

        System.out.println(player.getDisplayName());
        System.out.println(amount);
        Modify.Set(String.valueOf(player.getUniqueId()),amount,"Manually added.");
        sender.sendMessage(String.format(
                "Set %s%s%s deaths to %s%s%s\n",
                ChatColor.BOLD,
                player.getDisplayName(),
                ChatColor.RESET,
                ChatColor.GOLD,
                amount,
                ChatColor.RESET
        ));
        return true;
    }
}
