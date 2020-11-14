package me.therealmck.BadMC.BadIdeas.BeaconRules;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Beacon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class FifteenLayersBeacons implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType().equals(Material.BEACON)) {
            List<Material> allowedMaterials = new ArrayList<>();
            allowedMaterials.add(Material.NETHERITE_BLOCK);
            allowedMaterials.add(Material.IRON_BLOCK);
            allowedMaterials.add(Material.GOLD_BLOCK);
            allowedMaterials.add(Material.DIAMOND_BLOCK);
            allowedMaterials.add(Material.EMERALD_BLOCK);
            Beacon beacon = (Beacon) event.getBlock().getState();
            // Check that for 15 layers of blocks.
            // Time for lots of jank code to check every single block!

            boolean allBeaconBlocks = true;
            Location beaconLocation = beacon.getLocation();

            int iter = 0;

            while (true) {
                System.out.println(beaconLocation.getBlockY() - 1);
                for (int x = -1; x < 2; x++) {
                    for (int z = -1; z < 2; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 1, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                if (!allBeaconBlocks) break;

                System.out.println(beaconLocation.getBlockY() - 2);
                for (int x = -2; x < 3; x++) {
                    for (int z = -2; z < 3; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 2, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                if (!allBeaconBlocks) break;

                System.out.println(beaconLocation.getBlockY() - 3);
                for (int x = -3; x < 4; x++) {
                    for (int z = -3; z < 4; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 3, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                if (!allBeaconBlocks) break;

                System.out.println(beaconLocation.getBlockY() - 4);
                for (int x = -4; x < 5; x++) {
                    for (int z = -4; z < 5; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 4, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                if (!allBeaconBlocks) break;

                System.out.println(beaconLocation.getBlockY() - 5);
                for (int x = -5; x < 6; x++) {
                    for (int z = -5; z < 6; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 5, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                if (!allBeaconBlocks) break;

                System.out.println(beaconLocation.getBlockY() - 6);
                for (int x = -6; x < 7; x++) {
                    for (int z = -6; z < 7; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 6, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                if (!allBeaconBlocks) break;

                System.out.println(beaconLocation.getBlockY() - 7);
                for (int x = -7; x < 8; x++) {
                    for (int z = -7; z < 8; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 7, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                if (!allBeaconBlocks) break;

                System.out.println(beaconLocation.getBlockY() - 8);
                for (int x = -8; x < 9; x++) {
                    for (int z = -8; z < 9; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 8, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                if (!allBeaconBlocks) break;

                System.out.println(beaconLocation.getBlockY() - 9);
                for (int x = -9; x < 10; x++) {
                    for (int z = -9; z < 10; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 9, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                if (!allBeaconBlocks) break;

                System.out.println(beaconLocation.getBlockY() - 10);
                for (int x = -10; x < 11; x++) {
                    for (int z = -10; z < 11; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 10, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                if (!allBeaconBlocks) break;

                System.out.println(beaconLocation.getBlockY() - 11);
                for (int x = -11; x < 12; x++) {
                    for (int z = -11; z < 12; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 11, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                if (!allBeaconBlocks) break;

                System.out.println(beaconLocation.getBlockY() - 12);
                for (int x = -12; x < 13; x++) {
                    for (int z = -12; z < 13; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 12, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                if (!allBeaconBlocks) break;

                System.out.println(beaconLocation.getBlockY() - 13);
                for (int x = -13; x < 14; x++) {
                    for (int z = -13; z < 14; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 13, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                if (!allBeaconBlocks) break;

                System.out.println(beaconLocation.getBlockY() - 14);
                for (int x = -14; x < 15; x++) {
                    for (int z = -14; z < 15; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 14, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                if (!allBeaconBlocks) break;

                System.out.println(beaconLocation.getBlockY() - 15);
                for (int x = -15; x < 16; x++) {
                    for (int z = -15; z < 16; z++) {
                        iter++;
                        try {
                            if (!allowedMaterials.contains(beaconLocation.getWorld().getBlockAt(beaconLocation.getBlockX() + x, beaconLocation.getBlockY() - 15, beaconLocation.getBlockZ() + z).getType())) {
                                allBeaconBlocks = false;
                                System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                                break;
                            }
                        } catch (Exception e) {
                            allBeaconBlocks = false;
                            System.out.println(String.format("Postion %s, %s is not netherite!", beaconLocation.getBlockX() + x, beaconLocation.getBlockZ() + z));
                            break;
                        }
                    }
                    if (!allBeaconBlocks) break;
                }
                break;
            }

            if (!allBeaconBlocks) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "(You need a 15-layered pyramid to place the Beacon.)");
            } else {
                beacon.setLock("jake is a bald nobo head");
                beacon.setPrimaryEffect(PotionEffectType.JUMP);
                System.out.println(iter);
            }
        }
    }
}
