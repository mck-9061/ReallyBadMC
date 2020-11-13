package me.therealmck.BadMC.BadIdeas.FoodRules;

import me.therealmck.BadMC.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class NauseaOnTooMuch implements Listener {
    @EventHandler
    public void onEat(PlayerItemConsumeEvent event) {
        if (Main.justEaten.contains(event.getPlayer())) {
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1000000, 1));
            event.getPlayer().sendMessage(ChatColor.RED + "(You were warned.)");
            Bukkit.broadcastMessage(ChatColor.RED + event.getPlayer().getName() + " ate too much and is now nauseous.");

        } else {
            Main.justEaten.add(event.getPlayer());
            event.getPlayer().sendMessage(ChatColor.RED + "(Do not eat for another 60 seconds.)");
            new BukkitRunnable() {
                @Override
                public void run() {
                    Main.justEaten.remove(event.getPlayer());
                    event.getPlayer().sendMessage(ChatColor.GREEN + "(You can eat again!)");
                }
            }.runTaskLaterAsynchronously(Main.instance, 1200);
        }
    }
}
