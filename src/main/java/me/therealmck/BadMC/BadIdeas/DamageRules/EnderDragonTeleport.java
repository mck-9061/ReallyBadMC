package me.therealmck.BadMC.BadIdeas.DamageRules;

import org.bukkit.Location;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Random;

public class EnderDragonTeleport implements Listener {
    @EventHandler
    public void onDragonHit(EntityDamageEvent event) {
        if (event.getEntity() instanceof EnderDragon) {
            Random r = new Random();
            Location location = event.getEntity().getLocation();
            location.setX(r.nextInt(2000)-1000);
            location.setZ(r.nextInt(2000)-1000);

            event.getEntity().teleport(location);
        }
    }
}
