package me.therealmck.BadMC.BadIdeas.PetRules;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class NoPetSitting implements Listener {
    @EventHandler
    public void onSit(PlayerInteractAtEntityEvent event) {
        if (event.getRightClicked() instanceof Wolf || event.getRightClicked() instanceof Cat || event.getRightClicked() instanceof Parrot) {
            try {
                if (((Tameable) event.getRightClicked()).getOwner().equals(event.getPlayer())) {
                    ((Sittable) event.getRightClicked()).setSitting(false);
                }
            } catch (Exception ignored) {}
        }
    }
}
