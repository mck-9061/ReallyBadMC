package me.therealmck.BadMC.BadIdeas.MobSpawningRules;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpiderEffectsAndJockey implements Listener {
    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof Spider) {
            Spider spider = (Spider) event.getEntity();
            Skeleton skeleton = (Skeleton) spider.getWorld().spawnEntity(spider.getLocation(), EntityType.SKELETON);

            spider.addPassenger(skeleton);

            spider.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 2));
            spider.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 2));
            spider.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1000000, 2));
            spider.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, 2));
            spider.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 2));
            spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 2));
            spider.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 2));
        }
    }
}
