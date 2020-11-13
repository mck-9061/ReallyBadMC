package me.therealmck.BadMC.Enchants;

import me.therealmck.BadMC.Enchants.CustomEnchantsEnum;
import me.therealmck.BadMC.Utils.Utils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player) {
            if (commandSender.hasPermission("*")) {
                ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta meta = item.getItemMeta();
                List<String> lore = new ArrayList<>();
                lore.add("§r§cVulnerability " + Utils.toRoman(Integer.parseInt(args[0])));
                assert meta != null;
                meta.setLore(lore);
                item.setItemMeta(meta);
                item.addUnsafeEnchantment(CustomEnchantsEnum.VULNERABILITY, Integer.parseInt(args[0]));
                ((Player) commandSender).getInventory().addItem(item.clone());

                item = new ItemStack(Material.ENCHANTED_BOOK);
                meta = item.getItemMeta();
                lore = new ArrayList<>();
                lore.add("§r§cBlast Vulnerability " + Utils.toRoman(Integer.parseInt(args[0])));
                assert meta != null;
                meta.setLore(lore);
                item.setItemMeta(meta);
                item.addUnsafeEnchantment(CustomEnchantsEnum.BLAST_VULNERABILITY, Integer.parseInt(args[0]));
                ((Player) commandSender).getInventory().addItem(item.clone());

                item = new ItemStack(Material.ENCHANTED_BOOK);
                meta = item.getItemMeta();
                lore = new ArrayList<>();
                lore.add("§r§cProjectile Vulnerability " + Utils.toRoman(Integer.parseInt(args[0])));
                assert meta != null;
                meta.setLore(lore);
                item.setItemMeta(meta);
                item.addUnsafeEnchantment(CustomEnchantsEnum.PROJ_VULNERABILITY, Integer.parseInt(args[0]));
                ((Player) commandSender).getInventory().addItem(item.clone());

                item = new ItemStack(Material.ENCHANTED_BOOK);
                meta = item.getItemMeta();
                lore = new ArrayList<>();
                lore.add("§r§cFire Vulnerability " + Utils.toRoman(Integer.parseInt(args[0])));
                assert meta != null;
                meta.setLore(lore);
                item.setItemMeta(meta);
                item.addUnsafeEnchantment(CustomEnchantsEnum.FIRE_VULNERABILITY, Integer.parseInt(args[0]));
                ((Player) commandSender).getInventory().addItem(item.clone());

                item = new ItemStack(Material.ENCHANTED_BOOK);
                meta = item.getItemMeta();
                lore = new ArrayList<>();
                lore.add("§r§cPetals " + Utils.toRoman(Integer.parseInt(args[0])));
                assert meta != null;
                meta.setLore(lore);
                item.setItemMeta(meta);
                item.addUnsafeEnchantment(CustomEnchantsEnum.PETALS, Integer.parseInt(args[0]));
                ((Player) commandSender).getInventory().addItem(item.clone());

                item = new ItemStack(Material.ENCHANTED_BOOK);
                meta = item.getItemMeta();
                lore = new ArrayList<>();
                lore.add("§r§cStone Touch");
                assert meta != null;
                meta.setLore(lore);
                item.setItemMeta(meta);
                item.addUnsafeEnchantment(CustomEnchantsEnum.STONE_TOUCH, Integer.parseInt(args[0]));
                ((Player) commandSender).getInventory().addItem(item.clone());

            }
        }
        return true;
    }
}
