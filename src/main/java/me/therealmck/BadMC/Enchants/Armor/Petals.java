package me.therealmck.BadMC.Enchants.Armor;

import me.therealmck.BadMC.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Petals extends Enchantment implements Listener {

    public Petals() {
        super(new NamespacedKey(Main.instance, "petals"));
    }

    @Override
    public @NotNull String getName() {
        return "Petals";
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public @NotNull EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.ARMOR;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public boolean conflictsWith(@NotNull Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean canEnchantItem(@NotNull ItemStack itemStack) {
        return true;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) event.getDamager();
            Player p = (Player) event.getEntity();

            boolean hasEnchant = false;
            int level = 0;

            for (ItemStack i : p.getInventory().getArmorContents()) {
                for (Enchantment e : i.getEnchantments().keySet()) {
                    if (e.getName().equals("Petals")) {
                        hasEnchant = true;
                        level = i.getEnchantmentLevel(e);
                        break;
                    }
                }
                if (hasEnchant) break;
            }

            if (hasEnchant) {
                int chance = 15 * level;
                Random r = new Random();

                if (r.nextInt(100) <= chance) {
                    int heal = r.nextInt(4) + 1;
                    entity.setHealth(entity.getHealth() + heal);
                }
            }
        }
    }
}
