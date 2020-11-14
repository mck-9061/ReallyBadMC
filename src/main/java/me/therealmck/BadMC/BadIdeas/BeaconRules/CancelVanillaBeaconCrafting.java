package me.therealmck.BadMC.BadIdeas.BeaconRules;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;

public class CancelVanillaBeaconCrafting implements Listener {
    @EventHandler
    public void onCraft(CraftItemEvent event) {
        if (event.getRecipe().getResult().getType().equals(Material.BEACON)
                && event.getInventory().getContents()[1].getType().equals(Material.GLASS)) {

            event.setCancelled(true);
            event.getWhoClicked().sendMessage(ChatColor.RED + "(That recipe is disabled. Please use 9 nether stars.)");
        }
    }
}
