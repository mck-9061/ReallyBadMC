package me.therealmck.BadMC.BadIdeas.FoodRules;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class DoubleHunger implements Listener {
    @EventHandler
    public void onHungerLost(FoodLevelChangeEvent event) {
        int after = event.getFoodLevel();
        event.setCancelled(true);
        int before = ((Player)event.getEntity()).getFoodLevel();
        int difference = before - after;

        event.setCancelled(false);
        event.setFoodLevel(after - difference);
    }
}
