package me.therealmck.BadMC.BadIdeas.FoodRules;

import me.therealmck.BadMC.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PortalGapple implements Listener {
    @EventHandler
    public void onEat(PlayerItemConsumeEvent event) {
        if (event.getItem().getType().equals(Material.ENCHANTED_GOLDEN_APPLE)) {
            if (!Main.justEatenGap.contains(event.getPlayer())) Main.justEatenGap.add(event.getPlayer());
            new BukkitRunnable() {
                @Override
                public void run() {
                    Main.justEatenGap.remove(event.getPlayer());
                }
            }.runTaskLater(Main.instance, 6000);
        }
    }
}
