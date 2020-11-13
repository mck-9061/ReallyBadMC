package me.therealmck.BadMC;

import me.therealmck.BadMC.Enchants.Armor.*;
import me.therealmck.BadMC.Enchants.BookEnchantAddListener;
import me.therealmck.BadMC.Enchants.GetCommand;
import me.therealmck.BadMC.Enchants.Tools.StoneTouch;
import me.therealmck.BadMC.Utils.EnchantmentRegisterer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {
    public static Plugin instance;
    public static List<Player> justEaten;
    @Override
    public void onEnable() {
        instance = this;
        justEaten = new ArrayList<>();
        EnchantmentRegisterer.registerEnchants();

        getServer().getPluginManager().registerEvents(new BookEnchantAddListener(), this);

        getServer().getPluginManager().registerEvents(new Petals(), this);
        getServer().getPluginManager().registerEvents(new Vulnerability(), this);
        getServer().getPluginManager().registerEvents(new BlastVulnerability(), this);
        getServer().getPluginManager().registerEvents(new FireVulnerability(), this);
        getServer().getPluginManager().registerEvents(new ProjVulnerability(), this);
        getServer().getPluginManager().registerEvents(new StoneTouch(), this);

        this.getCommand("getenchant").setExecutor(new GetCommand());
    }
}
