package xyz.s4hype.deathcounter;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.s4hype.deathcounter.Commands.GetDeathFromID;
import xyz.s4hype.deathcounter.Commands.GetDeaths;
import xyz.s4hype.deathcounter.Commands.SetDeaths;
import xyz.s4hype.deathcounter.EventListener.PlayerDeathListener;

public final class DeathCounter extends JavaPlugin {

    static DeathCounter instance;
    public static Server server;
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        instance = this;
        server = getServer();
        this.getCommand("set_death").setExecutor(new SetDeaths());
        this.getCommand("deaths").setExecutor(new GetDeaths());
        this.getCommand("death_id").setExecutor(new GetDeathFromID());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static DeathCounter getInstance() {
        return instance;
    }
    public static Server _getServer() {
        return server;
    }
}
