package me.therealmck.BadMC.BadIdeas.DamageRules;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Rabbit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class RabbitKiller implements Listener {
    @EventHandler
    public void onRabbitKill(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Rabbit && ((Rabbit) event.getEntity()).getHealth() == 0) {
            ((LivingEntity) event.getDamager()).setHealth(0);
            Bukkit.broadcastMessage(ChatColor.RED + event.getDamager().getName() + " killed a rabbit and lost their own life.");
        }
    }
}
