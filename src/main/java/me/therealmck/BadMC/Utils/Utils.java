package me.therealmck.BadMC.Utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

public class Utils {
    public static List<Block> getNearbyBlocks(Location location, int radius) {
        List<Block> blocks = new ArrayList<>();
        for (int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
            for (int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
                for (int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
                    try {
                        blocks.add(Objects.requireNonNull(location.getWorld()).getBlockAt(x, y, z));
                    } catch (Exception ignored) {}
                }
            }
        }
        return blocks;
    }
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }

    public static BlockFace getBlockFace(Player player) {
        List<Block> lastTwoTargetBlocks = player.getLastTwoTargetBlocks(null, 100);
        if (lastTwoTargetBlocks.size() != 2 || !lastTwoTargetBlocks.get(1).getType().isOccluding()) return null;
        Block targetBlock = lastTwoTargetBlocks.get(1);
        Block adjacentBlock = lastTwoTargetBlocks.get(0);
        return targetBlock.getFace(adjacentBlock);
    }

    public static void removeItems(Inventory inventory, Material type, int amount) {
        if (amount <= 0) return;
        int size = inventory.getSize();
        for (int slot = 0; slot < size; slot++) {
            ItemStack is = inventory.getItem(slot);
            if (is == null) continue;
            if (type == is.getType()) {
                int newAmount = is.getAmount() - amount;
                if (newAmount > 0) {
                    is.setAmount(newAmount);
                    break;
                } else {
                    inventory.clear(slot);
                    amount = -newAmount;
                    if (amount == 0) break;
                }
            }
        }
    }


    public static int checkArmorEnchant(Player player, String enchantName) {

        boolean hasEnchant = false;
        int level = 0;

        for (ItemStack i : ((Player) player).getInventory().getArmorContents()) {
            for (Enchantment e : i.getEnchantments().keySet()) {
                if (e.getName().equals(enchantName)) {
                    hasEnchant = true;
                    level = i.getEnchantmentLevel(e);
                    break;
                }
            }
            if (hasEnchant) break;
        }

        return level;
    }


    public static int checkToolEnchant(Player player, String enchantName) {

        boolean hasEnchant = false;
        int level = 0;

        for (Enchantment e : player.getInventory().getItemInMainHand().getEnchantments().keySet()) {
            if (e.getName().equals(enchantName)) {
                hasEnchant = true;
                level = player.getInventory().getItemInMainHand().getEnchantmentLevel(e);
                break;
            }
        }

        return level;
    }
}
