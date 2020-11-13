package me.therealmck.BadMC.BadIdeas.FoodRules;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GoldenAppleWither implements Listener {
    @EventHandler
    public void onEat(PlayerItemConsumeEvent event) {
        if (event.getItem().getType().equals(Material.GOLDEN_APPLE) || event.getItem().getType().equals(Material.ENCHANTED_GOLDEN_APPLE)) {
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 1000000, 1));
        }
    }
}
