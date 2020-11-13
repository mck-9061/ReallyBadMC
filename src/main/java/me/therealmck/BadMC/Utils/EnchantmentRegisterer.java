package me.therealmck.BadMC.Utils;

import me.therealmck.BadMC.Enchants.CustomEnchantsEnum;
import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;

public class EnchantmentRegisterer {
    public static void registerEnchants() {
        try {
            Field fieldAcceptingNew = Enchantment.class.getDeclaredField("acceptingNew");
            fieldAcceptingNew.setAccessible(true);
            fieldAcceptingNew.set(null, true);

            Enchantment.registerEnchantment(CustomEnchantsEnum.PETALS);
            Enchantment.registerEnchantment(CustomEnchantsEnum.VULNERABILITY);
            Enchantment.registerEnchantment(CustomEnchantsEnum.BLAST_VULNERABILITY);
            Enchantment.registerEnchantment(CustomEnchantsEnum.PROJ_VULNERABILITY);
            Enchantment.registerEnchantment(CustomEnchantsEnum.FIRE_VULNERABILITY);
            Enchantment.registerEnchantment(CustomEnchantsEnum.STONE_TOUCH);

            fieldAcceptingNew.setAccessible(false);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
