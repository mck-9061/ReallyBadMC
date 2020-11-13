package me.therealmck.BadMC.BadIdeas.MobSpawningRules;

import me.therealmck.BadMC.Main;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Phantom;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PhantomMitosis implements Listener {
    @EventHandler
    public void onPhantomSpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof Phantom) {
            event.getHandlers().unregister(this);
            ((Phantom)event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 1));

            for (int i = 0 ; i < 10; i++) {
                Phantom p = (Phantom) event.getEntity().getWorld().spawnEntity(event.getLocation(), EntityType.PHANTOM);
                p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 1));
            }

            Main.instance.getServer().getPluginManager().registerEvents(new PhantomMitosis(), Main.instance);
        }
    }
}
