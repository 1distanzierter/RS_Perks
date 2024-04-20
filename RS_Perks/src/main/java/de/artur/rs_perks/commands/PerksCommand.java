package de.artur.rs_perks.commands;

import de.artur.rs_perks.RS_Perks;
import de.artur.rs_perks.utils.ItemUtil;
import de.artur.rs_perks.utils.UpdatePerk;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

public class PerksCommand implements CommandExecutor {

    private String prefix = RS_Perks.getInstance().getConfig().getString("Prefix").replace("&", "§");
    private FileConfiguration config = RS_Perks.getInstance().getConfig();
    @Override
    public boolean onCommand(@NotNull CommandSender s, @NotNull Command cmd, @NotNull String l, @NotNull String[] args) {
        if(s instanceof Player) {
            Player p = (Player) s;
            if (args.length != 0) {
                p.sendMessage(prefix + "§eUsage: §7/perks");

            } else {
                Inventory perksinv = Bukkit.createInventory(null, 45, config.getString("InventoryName").replace("&", "§"));
                for (int i = 0; i < 45; i++) {
                    perksinv.setItem(i, new ItemUtil(Material.GRAY_STAINED_GLASS_PANE).setName("§8-/-").build(false, false, false));
                }
                perksinv.setItem(config.getInt("Kein Fallschaden.Slot"), new ItemUtil(Material.getMaterial(config.getString("Kein Fallschaden.Material"))).setLore(config.getString("Kein Fallschaden.Lore").replace("&", "§")).setLore(config.getString("Kein Fallschaden.PriceLore").replace("&", "§")).setName(config.getString("Kein Fallschaden.Name").replace("&", "§")).build(true,true,true));
                perksinv.setItem(config.getInt("Nachtsicht.Slot"), new ItemUtil(Material.getMaterial(config.getString("Nachtsicht.Material"))).setLore(config.getString("Nachtsicht.Lore").replace("&", "§")).setLore(config.getString("Nachtsicht.PriceLore").replace("&", "§")).setName(config.getString("Nachtsicht.Name").replace("&", "§")).build(true,true,true));
                perksinv.setItem(config.getInt("Kein Ertrinken.Slot"), new ItemUtil(Material.getMaterial(config.getString("Kein Ertrinken.Material"))).setLore(config.getString("Kein Ertrinken.Lore").replace("&", "§")).setLore(config.getString("Kein Ertrinken.PriceLore").replace("&", "§")).setName(config.getString("Kein Ertrinken.Name").replace("&", "§")).build(true,true,true));
                perksinv.setItem(config.getInt("Kein Hunger.Slot"), new ItemUtil(Material.getMaterial(config.getString("Kein Hunger.Material"))).setLore(config.getString("Kein Hunger.Lore").replace("&", "§")).setLore(config.getString("Kein Hunger.PriceLore").replace("&", "§")).setName(config.getString("Kein Hunger.Name").replace("&", "§")).build(true,true,true));
                perksinv.setItem(config.getInt("Sofort Schmelzen.Slot"), new ItemUtil(Material.getMaterial(config.getString("Sofort Schmelzen.Material"))).setLore(config.getString("Sofort Schmelzen.Lore").replace("&", "§")).setLore(config.getString("Sofort Schmelzen.PriceLore").replace("&", "§")).setName(config.getString("Sofort Schmelzen.Name").replace("&", "§")).build(true,true,true));
                perksinv.setItem(config.getInt("Feuerresistenz.Slot"), new ItemUtil(Material.getMaterial(config.getString("Feuerresistenz.Material"))).createPotion(PotionType.FIRE_RESISTANCE).setLore(config.getString("Feuerresistenz.Lore").replace("&", "§")).setLore(config.getString("Feuerresistenz.PriceLore").replace("&", "§")).setName(config.getString("Feuerresistenz.Name").replace("&", "§")).build(true,true,true));
                perksinv.setItem(config.getInt("XP.Slot"), new ItemUtil(Material.getMaterial(config.getString("XP.Material"))).setLore(config.getString("XP.Lore").replace("&", "§")).setLore(config.getString("XP.PriceLore").replace("&", "§")).setName(config.getString("XP.Name").replace("&", "§")).build(true,true,true));
                if(UpdatePerk.getFallschadenPerk(p.getUniqueId()) == 0) {
                    perksinv.setItem(10, new ItemUtil(Material.getMaterial(config.getString("Nicht Verfügbar.Material"))).setName(config.getString("Nicht Verfügbar.Name").replace("&", "§")).setLore(config.getString("Nicht Verfügbar.Lore").replace("&", "§")).build(true, true, true));
                } else if(UpdatePerk.getFallschadenPerk(p.getUniqueId()) == 1) {
                    if(UpdatePerk.getFallschadenPerkStatus(p.getUniqueId()) == 0) {
                        perksinv.setItem(10, new ItemUtil(Material.getMaterial(config.getString("Deaktiviert.Material"))).setName(config.getString("Deaktiviert.Name").replace("&", "§")).setLore(config.getString("Deaktiviert.Lore").replace("&", "§")).build(true, true, true));
                    } else if (UpdatePerk.getFallschadenPerkStatus(p.getUniqueId()) == 1) {
                        perksinv.setItem(10, new ItemUtil(Material.getMaterial(config.getString("Aktiviert.Material"))).setName(config.getString("Aktiviert.Name").replace("&", "§")).setLore(config.getString("Aktiviert.Lore").replace("&", "§")).build(true, true, true));
                    }
                }
                if(UpdatePerk.getNachtsichtPerk(p.getUniqueId()) == 0) {
                    perksinv.setItem(12, new ItemUtil(Material.getMaterial(config.getString("Nicht Verfügbar.Material"))).setName(config.getString("Nicht Verfügbar.Name").replace("&", "§")).setLore(config.getString("Nicht Verfügbar.Lore").replace("&", "§")).build(true, true, true));
                } else if(UpdatePerk.getNachtsichtPerk(p.getUniqueId()) == 1) {
                    if (UpdatePerk.getNachtsichtPerkStatus(p.getUniqueId()) == 0) {
                        perksinv.setItem(12, new ItemUtil(Material.getMaterial(config.getString("Deaktiviert.Material"))).setName(config.getString("Deaktiviert.Name").replace("&", "§")).setLore(config.getString("Deaktiviert.Lore").replace("&", "§")).build(true, true, true));
                    } else if (UpdatePerk.getNachtsichtPerkStatus(p.getUniqueId()) == 1) {
                        perksinv.setItem(12, new ItemUtil(Material.getMaterial(config.getString("Aktiviert.Material"))).setName(config.getString("Aktiviert.Name").replace("&", "§")).setLore(config.getString("Aktiviert.Lore").replace("&", "§")).build(true, true, true));
                    }
                }
                if(UpdatePerk.getErtrinkenPerk(p.getUniqueId()) == 0) {
                    perksinv.setItem(14, new ItemUtil(Material.getMaterial(config.getString("Nicht Verfügbar.Material"))).setName(config.getString("Nicht Verfügbar.Name").replace("&", "§")).setLore(config.getString("Nicht Verfügbar.Lore").replace("&", "§")).build(true, true, true));
                } else if(UpdatePerk.getErtrinkenPerk(p.getUniqueId()) == 1) {
                    if (UpdatePerk.getErtrinkenPerkStatus(p.getUniqueId()) == 0) {
                        perksinv.setItem(14, new ItemUtil(Material.getMaterial(config.getString("Deaktiviert.Material"))).setName(config.getString("Deaktiviert.Name").replace("&", "§")).setLore(config.getString("Deaktiviert.Lore").replace("&", "§")).build(true, true, true));
                    } else if (UpdatePerk.getErtrinkenPerkStatus(p.getUniqueId()) == 1) {
                        perksinv.setItem(14, new ItemUtil(Material.getMaterial(config.getString("Aktiviert.Material"))).setName(config.getString("Aktiviert.Name").replace("&", "§")).setLore(config.getString("Aktiviert.Lore").replace("&", "§")).build(true, true, true));
                    }
                }
                if(UpdatePerk.getHungerPerk(p.getUniqueId()) == 0) {
                    perksinv.setItem(16, new ItemUtil(Material.getMaterial(config.getString("Nicht Verfügbar.Material"))).setName(config.getString("Nicht Verfügbar.Name").replace("&", "§")).setLore(config.getString("Nicht Verfügbar.Lore").replace("&", "§")).build(true, true, true));
                } else if(UpdatePerk.getHungerPerk(p.getUniqueId()) == 1) {
                    if (UpdatePerk.getHungerPerkStatus(p.getUniqueId()) == 0) {
                        perksinv.setItem(16, new ItemUtil(Material.getMaterial(config.getString("Deaktiviert.Material"))).setName(config.getString("Deaktiviert.Name").replace("&", "§")).setLore(config.getString("Deaktiviert.Lore").replace("&", "§")).build(true, true, true));
                    } else if (UpdatePerk.getHungerPerkStatus(p.getUniqueId()) == 1) {
                        perksinv.setItem(16, new ItemUtil(Material.getMaterial(config.getString("Aktiviert.Material"))).setName(config.getString("Aktiviert.Name").replace("&", "§")).setLore(config.getString("Aktiviert.Lore").replace("&", "§")).build(true, true, true));
                    }
                }
                if(UpdatePerk.getSchmelzenPerk(p.getUniqueId()) == 0) {
                    perksinv.setItem(38, new ItemUtil(Material.getMaterial(config.getString("Nicht Verfügbar.Material"))).setName(config.getString("Nicht Verfügbar.Name").replace("&", "§")).setLore(config.getString("Nicht Verfügbar.Lore").replace("&", "§")).build(true, true, true));
                } else if(UpdatePerk.getSchmelzenPerk(p.getUniqueId()) == 1) {
                    if (UpdatePerk.getSchmelzenPerkStatus(p.getUniqueId()) == 0) {
                        perksinv.setItem(38, new ItemUtil(Material.getMaterial(config.getString("Deaktiviert.Material"))).setName(config.getString("Deaktiviert.Name").replace("&", "§")).setLore(config.getString("Deaktiviert.Lore").replace("&", "§")).build(true, true, true));
                    } else if (UpdatePerk.getSchmelzenPerkStatus(p.getUniqueId()) == 1) {
                        perksinv.setItem(38, new ItemUtil(Material.getMaterial(config.getString("Aktiviert.Material"))).setName(config.getString("Aktiviert.Name").replace("&", "§")).setLore(config.getString("Aktiviert.Lore").replace("&", "§")).build(true, true, true));
                    }
                }
                if(UpdatePerk.getFeuerPerk(p.getUniqueId()) == 0) {
                    perksinv.setItem(40, new ItemUtil(Material.getMaterial(config.getString("Nicht Verfügbar.Material"))).setName(config.getString("Nicht Verfügbar.Name").replace("&", "§")).setLore(config.getString("Nicht Verfügbar.Lore").replace("&", "§")).build(true, true, true));
                } else if(UpdatePerk.getFeuerPerk(p.getUniqueId()) == 1) {
                    if (UpdatePerk.getFeuerPerkStatus(p.getUniqueId()) == 0) {
                        perksinv.setItem(40, new ItemUtil(Material.getMaterial(config.getString("Deaktiviert.Material"))).setName(config.getString("Deaktiviert.Name").replace("&", "§")).setLore(config.getString("Deaktiviert.Lore").replace("&", "§")).build(true, true, true));
                    } else if (UpdatePerk.getFeuerPerkStatus(p.getUniqueId()) == 1) {
                        perksinv.setItem(40, new ItemUtil(Material.getMaterial(config.getString("Aktiviert.Material"))).setName(config.getString("Aktiviert.Name").replace("&", "§")).setLore(config.getString("Aktiviert.Lore").replace("&", "§")).build(true, true, true));
                    }
                }
                if(UpdatePerk.getXPPerk(p.getUniqueId()) == 0) {
                    perksinv.setItem(42, new ItemUtil(Material.getMaterial(config.getString("Nicht Verfügbar.Material"))).setName(config.getString("Nicht Verfügbar.Name").replace("&", "§")).setLore(config.getString("Nicht Verfügbar.Lore").replace("&", "§")).build(true, true, true));
                } else if(UpdatePerk.getXPPerk(p.getUniqueId()) == 1) {
                    if (UpdatePerk.getXPPerkStatus(p.getUniqueId()) == 0) {
                        perksinv.setItem(42, new ItemUtil(Material.getMaterial(config.getString("Deaktiviert.Material"))).setName(config.getString("Deaktiviert.Name").replace("&", "§")).setLore(config.getString("Deaktiviert.Lore").replace("&", "§")).build(true, true, true));
                    } else if (UpdatePerk.getXPPerkStatus(p.getUniqueId()) == 1) {
                        perksinv.setItem(42, new ItemUtil(Material.getMaterial(config.getString("Aktiviert.Material"))).setName(config.getString("Aktiviert.Name").replace("&", "§")).setLore(config.getString("Aktiviert.Lore").replace("&", "§")).build(true, true, true));
                    }
                }
                p.openInventory(perksinv);
            }
        }
        return false;
    }
}
