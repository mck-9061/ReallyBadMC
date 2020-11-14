package me.therealmck.BadMC.BadIdeas;

import me.therealmck.BadMC.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EndPortalChecks implements Listener {
    @EventHandler
    public void onPortalMove(PlayerPortalEvent event) {
        if (event.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL)) {
            boolean hasEffect = false;
            for (PotionEffect effect : event.getPlayer().getActivePotionEffects()) {
                if (effect.getType().equals(PotionEffectType.JUMP)) {
                    hasEffect = true;
                    break;
                }
            }

            if (!hasEffect) {
                event.setCancelled(true);
                event.getPlayer().setHealth(0);
                event.getPlayer().sendMessage(ChatColor.RED + "(You need jump boost to do that. Obviously.)");
                Bukkit.broadcastMessage(ChatColor.RED + event.getPlayer().getName() + " entered the End without Jump Boost.");
            } else if (!Main.justEatenGap.contains(event.getPlayer())) {
                event.setCancelled(true);
                event.getPlayer().setHealth(0);
                event.getPlayer().sendMessage(ChatColor.RED + "(You need to eat an Enchanted Golden Apple to do that. Obviously.)");
                Bukkit.broadcastMessage(ChatColor.RED + event.getPlayer().getName() + " entered the End without a God Apple.");
            }

        }
    }
}
