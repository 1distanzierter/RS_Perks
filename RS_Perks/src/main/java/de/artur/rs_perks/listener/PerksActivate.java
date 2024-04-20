package de.artur.rs_perks.listener;

import com.Zrips.CMI.CMI;
import com.Zrips.CMI.Containers.CMIUser;
import de.artur.rs_perks.RS_Perks;
import de.artur.rs_perks.utils.Inventorys;
import de.artur.rs_perks.utils.ItemUtil;
import de.artur.rs_perks.utils.UpdatePerk;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffectType;

public class PerksActivate implements Listener {

    private String prefix = RS_Perks.getInstance().getConfig().getString("Prefix").replace("&", "§");
    private FileConfiguration config = RS_Perks.getInstance().getConfig();

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(p.getOpenInventory().getTitle().equalsIgnoreCase(config.getString("InventoryName").replace("&", "§"))) {
            e.setCancelled(true);
            if(e.getCurrentItem().getType().equals(Material.getMaterial(config.getString("Nicht Verfügbar.Material")))) {
                switch (e.getSlot()) {
                    case 10:
                        p.openInventory(Inventorys.confirmFallschadenBuy());
                        break;
                    case 12:
                        p.openInventory(Inventorys.confirmnachtsichtBuy());
                        break;
                    case 14:
                        p.openInventory(Inventorys.confirmErtrinkenBuy());
                        break;
                    case 16:
                        p.openInventory(Inventorys.confirmHungerBuy());
                        break;
                    case 38:
                        p.openInventory(Inventorys.confirmSchmelzenBuy());
                        break;
                    case 40:
                        p.openInventory(Inventorys.confirmFeuerBuy());
                        break;
                    case 42:
                        p.openInventory(Inventorys.confirmXPBuy());
                        break;
                }
            } else if (e.getCurrentItem().getType().equals(Material.getMaterial(config.getString("Deaktiviert.Material")))) {
                switch (e.getSlot()) {
                    case 10:
                        UpdatePerk.setFallschadenPerkStatus(p.getUniqueId(), true);
                        p.getOpenInventory().setItem(e.getSlot(), new ItemUtil(Material.getMaterial(config.getString("Aktiviert.Material"))).setName(config.getString("Aktiviert.Name").replace("&", "§")).setLore(config.getString("Aktiviert.Lore").replace("&", "§")).build(true, true, true));
                        p.sendMessage(prefix + "§7Du hast das Fallschaden Perk §aaktiviert§7!");
                        break;
                    case 12:
                        UpdatePerk.setNachtsichtPerkStatus(p.getUniqueId(), true);
                        p.getOpenInventory().setItem(e.getSlot(), new ItemUtil(Material.getMaterial(config.getString("Aktiviert.Material"))).setName(config.getString("Aktiviert.Name").replace("&", "§")).setLore(config.getString("Aktiviert.Lore").replace("&", "§")).build(true, true, true));
                        p.addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(900000, 4));
                        p.sendMessage(prefix + "§7Du hast das Nachtsicht Perk §aaktiviert§7!");
                        break;
                    case 14:
                        UpdatePerk.setErtrinkenPerkStatus(p.getUniqueId(), true);
                        p.getOpenInventory().setItem(e.getSlot(), new ItemUtil(Material.getMaterial(config.getString("Aktiviert.Material"))).setName(config.getString("Aktiviert.Name").replace("&", "§")).setLore(config.getString("Aktiviert.Lore").replace("&", "§")).build(true, true, true));
                        p.sendMessage(prefix + "§7Du hast das Kein Ertrinken Perk §aaktiviert§7!");
                        break;
                    case 16:
                        UpdatePerk.setHungerPerkStatus(p.getUniqueId(), true);
                        p.getOpenInventory().setItem(e.getSlot(), new ItemUtil(Material.getMaterial(config.getString("Aktiviert.Material"))).setName(config.getString("Aktiviert.Name").replace("&", "§")).setLore(config.getString("Aktiviert.Lore").replace("&", "§")).build(true, true, true));
                        p.sendMessage(prefix + "§7Du hast das Kein Hunger Perk §aaktiviert§7!");
                        break;
                    case 38:
                        UpdatePerk.setSchmelzenPerkStatus(p.getUniqueId(), true);
                        p.getOpenInventory().setItem(e.getSlot(), new ItemUtil(Material.getMaterial(config.getString("Aktiviert.Material"))).setName(config.getString("Aktiviert.Name").replace("&", "§")).setLore(config.getString("Aktiviert.Lore").replace("&", "§")).build(true, true, true));
                        p.sendMessage(prefix + "§7Du hast das Sofort Schmelzen Perk §aaktiviert§7!");
                        break;
                    case 40:
                        UpdatePerk.setFeuerPerkStatus(p.getUniqueId(), true);
                        p.getOpenInventory().setItem(e.getSlot(), new ItemUtil(Material.getMaterial(config.getString("Aktiviert.Material"))).setName(config.getString("Aktiviert.Name").replace("&", "§")).setLore(config.getString("Aktiviert.Lore").replace("&", "§")).build(true, true, true));
                        p.sendMessage(prefix + "§7Du hast das Feuerresistenz Perk §aaktiviert§7!");
                        break;
                    case 42:
                        UpdatePerk.setXPPerkStatus(p.getUniqueId(), true);
                        p.getOpenInventory().setItem(e.getSlot(), new ItemUtil(Material.getMaterial(config.getString("Aktiviert.Material"))).setName(config.getString("Aktiviert.Name").replace("&", "§")).setLore(config.getString("Aktiviert.Lore").replace("&", "§")).build(true, true, true));
                        p.sendMessage(prefix + "§7Du hast das KeepXP Perk §aaktiviert§7!");
                        break;
                }
            } else if (e.getCurrentItem().getType().equals(Material.getMaterial(config.getString("Aktiviert.Material")))) {
                switch (e.getSlot()) {
                    case 10:
                        UpdatePerk.setFallschadenPerkStatus(p.getUniqueId(), false);
                        p.getOpenInventory().setItem(e.getSlot(), new ItemUtil(Material.getMaterial(config.getString("Deaktiviert.Material"))).setName(config.getString("Deaktiviert.Name").replace("&", "§")).setLore(config.getString("Deaktiviert.Lore").replace("&", "§")).build(true, true, true));
                        p.sendMessage(prefix + "§7Du hast das Fallschaden Perk §cdeaktiviert§7!");
                        break;
                    case 12:
                        UpdatePerk.setNachtsichtPerkStatus(p.getUniqueId(), false);
                        p.getOpenInventory().setItem(e.getSlot(), new ItemUtil(Material.getMaterial(config.getString("Deaktiviert.Material"))).setName(config.getString("Deaktiviert.Name").replace("&", "§")).setLore(config.getString("Deaktiviert.Lore").replace("&", "§")).build(true, true, true));
                        p.removePotionEffect(PotionEffectType.NIGHT_VISION);
                        p.sendMessage(prefix + "§7Du hast das Nachtsicht Perk §cdeaktiviert§7!");
                        break;
                    case 14:
                        UpdatePerk.setErtrinkenPerkStatus(p.getUniqueId(), false);
                        p.getOpenInventory().setItem(e.getSlot(), new ItemUtil(Material.getMaterial(config.getString("Deaktiviert.Material"))).setName(config.getString("Deaktiviert.Name").replace("&", "§")).setLore(config.getString("Deaktiviert.Lore").replace("&", "§")).build(true, true, true));
                        p.sendMessage(prefix + "§7Du hast das Kein Ertrinken Perk §cdeaktiviert§7!");
                        break;
                    case 16:
                        UpdatePerk.setHungerPerkStatus(p.getUniqueId(), false);
                        p.getOpenInventory().setItem(e.getSlot(), new ItemUtil(Material.getMaterial(config.getString("Deaktiviert.Material"))).setName(config.getString("Deaktiviert.Name").replace("&", "§")).setLore(config.getString("Deaktiviert.Lore").replace("&", "§")).build(true, true, true));
                        p.sendMessage(prefix + "§7Du hast das Kein Hunger Perk §cdeaktiviert§7!");
                        break;
                    case 38:
                        UpdatePerk.setSchmelzenPerkStatus(p.getUniqueId(), false);
                        p.getOpenInventory().setItem(e.getSlot(), new ItemUtil(Material.getMaterial(config.getString("Deaktiviert.Material"))).setName(config.getString("Deaktiviert.Name").replace("&", "§")).setLore(config.getString("Deaktiviert.Lore").replace("&", "§")).build(true, true, true));
                        p.sendMessage(prefix + "§7Du hast das Sofort Schmelzen Perk §cdeaktiviert§7!");
                        break;
                    case 40:
                        UpdatePerk.setFeuerPerkStatus(p.getUniqueId(), false);
                        p.getOpenInventory().setItem(e.getSlot(), new ItemUtil(Material.getMaterial(config.getString("Deaktiviert.Material"))).setName(config.getString("Deaktiviert.Name").replace("&", "§")).setLore(config.getString("Deaktiviert.Lore").replace("&", "§")).build(true, true, true));
                        p.sendMessage(prefix + "§7Du hast das Feuerresistenz Perk §cdeaktiviert§7!");
                        break;
                    case 42:
                        UpdatePerk.setXPPerkStatus(p.getUniqueId(), false);
                        p.getOpenInventory().setItem(e.getSlot(), new ItemUtil(Material.getMaterial(config.getString("Deaktiviert.Material"))).setName(config.getString("Deaktiviert.Name").replace("&", "§")).setLore(config.getString("Deaktiviert.Lore").replace("&", "§")).build(true, true, true));
                        p.sendMessage(prefix + "§7Du hast das XP Perk §cdeaktiviert§7!");
                        break;
                }
            }
        } else if(p.getOpenInventory().getTitle().equalsIgnoreCase("§aKauf bestätigung §7(Fallschaden)")) {

            e.setCancelled(true);
            switch (e.getSlot()) {
                case 0:
                    CMIUser user = CMI.getInstance().getPlayerManager().getUser(p);
                    if(user.getBalance() >= config.getInt("Kein Fallschaden.Price")) {
                        UpdatePerk.setFallschadenPerk(p.getUniqueId());
                        UpdatePerk.setFallschadenPerkStatus(p.getUniqueId(), true);
                        p.sendMessage(prefix + "§7Du hast erfolgreich das §aFallschaden Perk §7gekauft!");
                        p.closeInventory();
                    }
                    break;
                case 4:
                    p.sendMessage(prefix + "§7Du hast den Kauf abgebrochen!");
                    p.closeInventory();
                    break;
            }
        } else if(p.getOpenInventory().getTitle().equalsIgnoreCase("§aKauf bestätigung §7(Nachtsicht)")) {
            e.setCancelled(true);
            switch (e.getSlot()) {
                case 0:
                    CMIUser user = CMI.getInstance().getPlayerManager().getUser(p);
                    if(user.getBalance() >= config.getInt("Kein Nachtsicht.Price")) {
                        UpdatePerk.setNachtsichtPerk(p.getUniqueId());
                        UpdatePerk.setNachtsichtPerkStatus(p.getUniqueId(), true);
                        p.sendMessage(prefix + "§7Du hast erfolgreich das §aNachtsicht Perk §7gekauft!");
                        p.closeInventory();
                    }
                    break;
                case 4:
                    p.sendMessage(prefix + "§7Du hast den Kauf abgebrochen!");
                    p.closeInventory();
                    break;
            }
        } else if(p.getOpenInventory().getTitle().equalsIgnoreCase("§aKauf bestätigung §7(Kein Ertrinken)")) {
            e.setCancelled(true);
            switch (e.getSlot()) {
                case 0:
                    CMIUser user = CMI.getInstance().getPlayerManager().getUser(p);
                    if(user.getBalance() >= config.getInt("Kein Ertrinken.Price")) {
                        UpdatePerk.setErtrinkenPerk(p.getUniqueId());
                        UpdatePerk.setErtrinkenPerkStatus(p.getUniqueId(), true);
                        p.sendMessage(prefix + "§7Du hast erfolgreich das §aKein Ertrinken Perk §7gekauft!");
                        p.closeInventory();

                    }
                    break;
                case 4:
                    p.sendMessage(prefix + "§7Du hast den Kauf abgebrochen!");
                    p.closeInventory();
                    break;
            }
        } else if(p.getOpenInventory().getTitle().equalsIgnoreCase("§aKauf bestätigung §7(Kein Hunger)")) {
            e.setCancelled(true);
            switch (e.getSlot()) {
                case 0:
                    CMIUser user = CMI.getInstance().getPlayerManager().getUser(p);
                    if(user.getBalance() >= config.getInt("Kein Hunger.Price")) {
                        UpdatePerk.setHungerPerk(p.getUniqueId());
                        UpdatePerk.setHungerPerkStatus(p.getUniqueId(), true);
                        p.sendMessage(prefix + "§7Du hast erfolgreich das §aKein Hunger Perk §7gekauft!");
                        p.closeInventory();
                    }
                    break;
                case 4:
                    p.sendMessage(prefix + "§7Du hast den Kauf abgebrochen!");
                    p.closeInventory();
                    break;
            }
        } else if(p.getOpenInventory().getTitle().equalsIgnoreCase("§aKauf bestätigung §7(Sofort Schmelzen)")) {
            e.setCancelled(true);
            switch (e.getSlot()) {
                case 0:
                    CMIUser user = CMI.getInstance().getPlayerManager().getUser(p);
                    if(user.getBalance() >= config.getInt("Sofort Schmelzen.Price")) {
                        UpdatePerk.setSchmelzenPerk(p.getUniqueId());
                        UpdatePerk.setSchmelzenPerkStatus(p.getUniqueId(), true);
                        p.sendMessage(prefix + "§7Du hast erfolgreich das §aSofort Schmelzen Perk §7gekauft!");
                        p.closeInventory();
                    }
                    break;
                case 4:
                    p.sendMessage(prefix + "§7Du hast den Kauf abgebrochen!");
                    p.closeInventory();
                    break;
            }
        } else if(p.getOpenInventory().getTitle().equalsIgnoreCase("§aKauf bestätigung §7(Feuerresistenz)")) {
            e.setCancelled(true);
            switch (e.getSlot()) {
                case 0:
                    CMIUser user = CMI.getInstance().getPlayerManager().getUser(p);
                    if(user.getBalance() >= config.getInt("Kein Feuerresistenz.Price")) {
                        UpdatePerk.setFeuerPerk(p.getUniqueId());
                        UpdatePerk.setFeuerPerkStatus(p.getUniqueId(), true);
                        p.sendMessage(prefix + "§7Du hast erfolgreich das §aFeuerresistenz Perk §7gekauft!");
                        p.closeInventory();
                    }
                    break;
                case 4:
                    p.sendMessage(prefix + "§7Du hast den Kauf abgebrochen!");
                    p.closeInventory();
                    break;
            }
        } else if(p.getOpenInventory().getTitle().equalsIgnoreCase("§aKauf bestätigung §7(KeepXP)")) {
            e.setCancelled(true);
            switch (e.getSlot()) {
                case 0:
                    CMIUser user = CMI.getInstance().getPlayerManager().getUser(p);
                    if(user.getBalance() >= config.getInt("Kein XP.Price")) {
                        UpdatePerk.setXPPerk(p.getUniqueId());
                        UpdatePerk.setXPPerkStatus(p.getUniqueId(), true);
                        p.sendMessage(prefix + "§7Du hast erfolgreich das §aKeepXP Perk §7gekauft!");
                        p.closeInventory();
                    }
                    break;
                case 4:
                    p.sendMessage(prefix + "§7Du hast den Kauf abgebrochen!");
                    p.closeInventory();
                    break;
            }
        }
    }
}
