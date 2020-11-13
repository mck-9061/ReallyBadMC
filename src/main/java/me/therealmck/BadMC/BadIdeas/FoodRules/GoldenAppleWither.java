package me.therealmck.BadMC.BadIdeas.FoodRules;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
            Bukkit.broadcastMessage(ChatColor.RED + event.getPlayer().getName() + " ate an apple made out of literal metal, and now has Wither.");

        }
    }
}
