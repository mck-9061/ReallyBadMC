package me.therealmck.BadMC.BadIdeas.MobSpawningRules;

import org.bukkit.entity.Rabbit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.List;

public class RemoveRabbits implements Listener {
    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof Rabbit) event.setCancelled(true);
    }
}
