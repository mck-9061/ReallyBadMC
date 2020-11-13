package me.therealmck.BadMC.BadIdeas.PetRules;

import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Objects;

public class UnTame implements Listener {
    @EventHandler
    public void onPetHit(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Tameable && ((Tameable)event.getEntity()).isTamed()
        && event.getDamager() instanceof AnimalTamer && Objects.equals(((Tameable) event.getEntity()).getOwner(), (AnimalTamer) event.getDamager())) {
            ((Tameable)event.getEntity()).setTamed(false);
        }
    }
}
