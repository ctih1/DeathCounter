package xyz.s4hype.deathcounter.Tools;

import xyz.s4hype.deathcounter.DeathCounter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Modify {
    static DeathCounter deathCounter;
    static int newAmount;
    static String result;
    public static void init() {
        if(deathCounter==null) {
            deathCounter = DeathCounter.getInstance();
        }
    }
    public static void Set(String UUID, int amount, String reason) throws NumberFormatException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        deathCounter.getConfig().set(UUID+".amount",amount);
        deathCounter.getConfig().set(UUID+"."+amount+".reason",reason);
        deathCounter.getConfig().set(UUID+"."+amount+".time",date);
        deathCounter.saveConfig();
    }
    public static void Increment(String UUID, int amount, String reason) {
        if(deathCounter.getConfig().getString(UUID+".amount")==null) {
            Set(UUID,amount,reason);
            return;
        }
        newAmount = Integer.parseInt(deathCounter.getConfig().getString(UUID+".amount"));
        newAmount += amount;
        Set(UUID,newAmount, reason);
    }

    public static int Get(String UUID) {
        if(deathCounter.getConfig().getString(UUID+".amount")==null) {
            return 0;
        }
        return Integer.parseInt(deathCounter.getConfig().getString(UUID+".amount"));
    }

    public static String GetFromList(String UUID, int id) {
        if(deathCounter.getConfig().getString(UUID+".amount")==null) {
            return "None";
        }
        result = deathCounter.getConfig().getString(UUID+"."+id+".reason");
        result += deathCounter.getConfig().getString(UUID+"."+id+".time");
        return result;
    }
}
