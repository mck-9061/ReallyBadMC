package me.therealmck.BadMC.Enchants;

import me.therealmck.BadMC.Utils.Utils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class BookEnchantAddListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        try {
            if (Objects.requireNonNull(e.getCursor()).getType().equals(Material.ENCHANTED_BOOK)) {
                HashMap<Enchantment, Integer> enchants = new HashMap<>();
                boolean shouldRemoveBook = false;
                if (e.getCursor().getItemMeta() instanceof EnchantmentStorageMeta) {
                    enchants.putAll(((EnchantmentStorageMeta) e.getCursor().getItemMeta()).getStoredEnchants());
                    enchants.putAll(e.getCursor().getItemMeta().getEnchants());
                } else {
                    enchants.putAll(e.getCursor().getEnchantments());
                }

                if (enchants.isEmpty()) enchants.putAll(e.getCursor().getItemMeta().getEnchants());
                System.out.println(enchants);
                if (!(e.getCurrentItem() == null) && !(e.getCursor() == null) && !(e.getCurrentItem().getType().equals(Material.AIR))) {
                    //Enchantments
                    for (Enchantment ench : enchants.keySet()) {
                        System.out.println(ench);
                        int level = enchants.get(ench);
                        int currentLevel = 0;

                        try {
                            if (e.getCurrentItem().getItemMeta() instanceof EnchantmentStorageMeta) {
                                EnchantmentStorageMeta meta = (EnchantmentStorageMeta) e.getCurrentItem().getItemMeta();
                                currentLevel = meta.getEnchants().get(ench);
                            } else {
                                currentLevel = e.getCurrentItem().getEnchantmentLevel(ench);
                            }
                        } catch (Exception exception) {
                            currentLevel = 0;
                        }

                        try {
                            if (currentLevel == 0) currentLevel = e.getCurrentItem().getItemMeta().getEnchants().get(ench);
                        } catch (Exception exception) {
                            currentLevel = 0;
                        }

                        if (e.getCurrentItem().getItemMeta() instanceof EnchantmentStorageMeta) {
                            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) e.getCurrentItem().getItemMeta();
                            try {
                                assert meta != null;
                                meta.removeStoredEnchant(ench);
                            } catch (Exception ignored) {}
                            e.getCurrentItem().setItemMeta(meta);
                            System.out.println("Ench. Book: Removing enchant " + ench + currentLevel);
                        } else {
                            e.getCurrentItem().removeEnchantment(ench);
                            ItemMeta meta = e.getCurrentItem().getItemMeta();
                            try {
                                assert meta != null;
                                meta.removeEnchant(ench);
                            } catch (Exception ignored) {}
                            e.getCurrentItem().setItemMeta(meta);
                            System.out.println("Tool: Removing enchant " + ench + currentLevel);
                        }

                        if (!ench.canEnchantItem(e.getCurrentItem()) && !(e.getCurrentItem().getType().equals(Material.ENCHANTED_BOOK))) continue;
                        if (currentLevel > level) e.getCurrentItem().addUnsafeEnchantment(ench, currentLevel);
                        else if (currentLevel == level && (level+1 <= ench.getMaxLevel())) {
                            e.getCurrentItem().addUnsafeEnchantment(ench, level+1);
                            shouldRemoveBook = true;
                            System.out.println("Adding enchant " + ench + (level+1));
                        }
                        else if (currentLevel < level) {
                            e.getCurrentItem().addUnsafeEnchantment(ench, level);
                            shouldRemoveBook = true;
                            System.out.println("Adding enchant " + ench + level);
                        }
                        else e.getCurrentItem().addUnsafeEnchantment(ench, currentLevel);
                    }


                    //Lore (For custom enchants)
//                    ItemMeta meta = e.getCurrentItem().getItemMeta();
////                    List<String> currentLore = null;
////                    try {
////                        assert meta != null;
////                        currentLore = meta.getLore();
////                    } catch (Exception ignored) {}
////
////                    ItemMeta meta2 = e.getCursor().getItemMeta();
////                    List<String> lore = new ArrayList<>();
////                    assert meta2 != null;
////
////                    try {
////                        lore.addAll(Objects.requireNonNull(meta2.getLore()));
////                    } catch (Exception ignored) {}
////
////                    try {
////                        assert currentLore != null;
////                        lore.addAll(currentLore);
////                    } catch (Exception ignored) {}
////
////                    LinkedHashSet<String> hashSet = new LinkedHashSet<>(lore);
////
////                    lore = new ArrayList<>(hashSet);
////
////                    try {
////                        meta.setLore(lore);
////                    } catch (Exception ignored) {}
////                    e.getCurrentItem().setItemMeta(meta);

                    for (Enchantment ench : e.getCurrentItem().getEnchantments().keySet()) {
                        if ((ench.getName().equals("Petals")) ||
                                (ench.getName().equals("Vulnerability")) ||
                                (ench.getName().equals("Blast Vulnerability")) ||
                                (ench.getName().equals("Fire Vulnerability")) ||
                                (ench.getName().equals("Projectile Vulnerability")) ||
                                (ench.getName().equals("Stone Touch"))) {
                            //The enchantment is custom, so add to the lore
                            ItemMeta meta = e.getCurrentItem().getItemMeta();
                            assert meta != null;
                            List<String> lore = meta.getLore();
                            if (lore == null) lore = new ArrayList<>();
                            lore.removeIf(loreLine -> loreLine.contains(ench.getName()));

                            if (ench.isCursed()) lore.add("§r§c" + ench.getName() + " " + Utils.toRoman(e.getCurrentItem().getEnchantments().get(ench)));
                            else if (ench.getMaxLevel() == 1) lore.add("§r§7" + ench.getName());
                            else lore.add("§r§7" + ench.getName() + " " + Utils.toRoman(e.getCurrentItem().getEnchantments().get(ench)));
                            meta.setLore(lore);
                            e.getCurrentItem().setItemMeta(meta);
                        }
                    }

                    e.setCancelled(true);
                    if (shouldRemoveBook) {
                        e.getInventory().remove(e.getCursor());
                        e.setCursor(null);
                        e.getWhoClicked().setItemOnCursor(null);
                    }
                }
            }
        } catch (Exception e1) {e1.printStackTrace();}
    }
}
