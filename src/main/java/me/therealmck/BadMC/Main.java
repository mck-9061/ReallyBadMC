package me.therealmck.BadMC;

import me.therealmck.BadMC.BadIdeas.BeaconRules.NetheriteBeacons;
import me.therealmck.BadMC.Enchants.Armor.*;
import me.therealmck.BadMC.Enchants.BookEnchantAddListener;
import me.therealmck.BadMC.Enchants.GetCommand;
import me.therealmck.BadMC.Enchants.Tools.StoneTouch;
import me.therealmck.BadMC.Utils.EnchantmentRegisterer;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Beacon;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {
    public static Plugin instance;
    public static List<Player> justEaten;
    public static List<Player> justEatenGap;

    @Override
    public void onEnable() {
        instance = this;
        justEaten = new ArrayList<>();
        justEatenGap = new ArrayList<>();

        // Register new beacon recipe
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "beacon"), new ItemStack(Material.BEACON));
        recipe.shape("aaa", "aaa", "aaa");
        recipe.setIngredient('a', Material.NETHER_STAR);

        getServer().addRecipe(recipe);


        EnchantmentRegisterer.registerEnchants();

        getServer().getPluginManager().registerEvents(new BookEnchantAddListener(), this);

        getServer().getPluginManager().registerEvents(new Petals(), this);
        getServer().getPluginManager().registerEvents(new Vulnerability(), this);
        getServer().getPluginManager().registerEvents(new BlastVulnerability(), this);
        getServer().getPluginManager().registerEvents(new FireVulnerability(), this);
        getServer().getPluginManager().registerEvents(new ProjVulnerability(), this);
        getServer().getPluginManager().registerEvents(new StoneTouch(), this);


        getServer().getPluginManager().registerEvents(new NetheriteBeacons(), this);

        this.getCommand("getenchant").setExecutor(new GetCommand());
    }
}
