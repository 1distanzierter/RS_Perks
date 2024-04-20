package de.artur.rs_perks.utils;

import de.artur.rs_perks.RS_Perks;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Inventorys {

    private static String prefix = RS_Perks.getInstance().getConfig().getString("Prefix").replace("&", "§");
    private static FileConfiguration config = RS_Perks.getInstance().getConfig();
    public static Inventory confirmFallschadenBuy() {

        ItemStack amount = new ItemStack(HeadUtil.getCustomSkull("§cWillst du dir dieses Perk wirklich kaufen?", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGUwYjQ2ZjEzYTk1ODI3Y2IxYzljZWE5YmM3ZWVhOWE2ZDhkZDA1YTA3OWZhN2JkNjIxNmZhNDU1ZWJhMDI4NCJ9fX0="));
        ItemMeta amount_meta = amount.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§a§l« §7Klicke auf das linke Item um das Perk zu kaufen.");
        lore.add("§c§l» §7Klicke auf das rechts Item um abzubrechen.");
        amount_meta.setLore(lore);
        amount.setItemMeta(amount_meta);

        Inventory inventory = Bukkit.createInventory(null, InventoryType.HOPPER, "§aKauf bestätigung §7(Fallschaden)");
        inventory.setItem(0, new ItemUtil(Material.LIME_CONCRETE).setName("§aJa").setLore("§eBeim klicken des Items bestätigst du den Kauf der nicht mehr rückgängig ist.").build(true, true, true));
        inventory.setItem(2, amount);
        inventory.setItem(4, new ItemUtil(Material.RED_CONCRETE).setName("§cNein").setLore("§eBeim klicken des Items brichst du den Kauf ab.").build(true, true, true));
        return inventory;
    }
    public static Inventory confirmnachtsichtBuy() {

        ItemStack amount = new ItemStack(HeadUtil.getCustomSkull("§cWillst du dir dieses Perk wirklich kaufen?", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGUwYjQ2ZjEzYTk1ODI3Y2IxYzljZWE5YmM3ZWVhOWE2ZDhkZDA1YTA3OWZhN2JkNjIxNmZhNDU1ZWJhMDI4NCJ9fX0="));
        ItemMeta amount_meta = amount.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§a§l« §7Klicke auf das linke Item um das Perk zu kaufen.");
        lore.add("§c§l» §7Klicke auf das rechts Item um abzubrechen.");
        amount_meta.setLore(lore);
        amount.setItemMeta(amount_meta);

        Inventory inventory = Bukkit.createInventory(null, InventoryType.HOPPER, "§aKauf bestätigung §7(Nachtsicht)");
        inventory.setItem(0, new ItemUtil(Material.LIME_CONCRETE).setName("§aJa").setLore("§eBeim klicken des Items bestätigst du den Kauf der nicht mehr rückgängig ist.").build(true, true, true));
        inventory.setItem(2, amount);
        inventory.setItem(4, new ItemUtil(Material.RED_CONCRETE).setName("§cNein").setLore("§eBeim klicken des Items brichst du den Kauf ab.").build(true, true, true));
        return inventory;
    }

    public static Inventory confirmErtrinkenBuy() {

        ItemStack amount = new ItemStack(HeadUtil.getCustomSkull("§cWillst du dir dieses Perk wirklich kaufen?", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGUwYjQ2ZjEzYTk1ODI3Y2IxYzljZWE5YmM3ZWVhOWE2ZDhkZDA1YTA3OWZhN2JkNjIxNmZhNDU1ZWJhMDI4NCJ9fX0="));
        ItemMeta amount_meta = amount.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§a§l« §7Klicke auf das linke Item um das Perk zu kaufen.");
        lore.add("§c§l» §7Klicke auf das rechts Item um abzubrechen.");
        amount_meta.setLore(lore);
        amount.setItemMeta(amount_meta);

        Inventory inventory = Bukkit.createInventory(null, InventoryType.HOPPER, "§aKauf bestätigung §7(Kein Ertrinken)");
        inventory.setItem(0, new ItemUtil(Material.LIME_CONCRETE).setName("§aJa").setLore("§eBeim klicken des Items bestätigst du den Kauf der nicht mehr rückgängig ist.").build(true, true, true));
        inventory.setItem(2, amount);
        inventory.setItem(4, new ItemUtil(Material.RED_CONCRETE).setName("§cNein").setLore("§eBeim klicken des Items brichst du den Kauf ab.").build(true, true, true));
        return inventory;
    }

    public static Inventory confirmHungerBuy() {

        ItemStack amount = new ItemStack(HeadUtil.getCustomSkull("§cWillst du dir dieses Perk wirklich kaufen?", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGUwYjQ2ZjEzYTk1ODI3Y2IxYzljZWE5YmM3ZWVhOWE2ZDhkZDA1YTA3OWZhN2JkNjIxNmZhNDU1ZWJhMDI4NCJ9fX0="));
        ItemMeta amount_meta = amount.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§a§l« §7Klicke auf das linke Item um das Perk zu kaufen.");
        lore.add("§c§l» §7Klicke auf das rechts Item um abzubrechen.");
        amount_meta.setLore(lore);
        amount.setItemMeta(amount_meta);

        Inventory inventory = Bukkit.createInventory(null, InventoryType.HOPPER, "§aKauf bestätigung §7(Kein Hunger)");
        inventory.setItem(0, new ItemUtil(Material.LIME_CONCRETE).setName("§aJa").setLore("§eBeim klicken des Items bestätigst du den Kauf der nicht mehr rückgängig ist.").build(true, true, true));
        inventory.setItem(2, amount);
        inventory.setItem(4, new ItemUtil(Material.RED_CONCRETE).setName("§cNein").setLore("§eBeim klicken des Items brichst du den Kauf ab.").build(true, true, true));
        return inventory;
    }

    public static Inventory confirmSchmelzenBuy() {

        ItemStack amount = new ItemStack(HeadUtil.getCustomSkull("§cWillst du dir dieses Perk wirklich kaufen?", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGUwYjQ2ZjEzYTk1ODI3Y2IxYzljZWE5YmM3ZWVhOWE2ZDhkZDA1YTA3OWZhN2JkNjIxNmZhNDU1ZWJhMDI4NCJ9fX0="));
        ItemMeta amount_meta = amount.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§a§l« §7Klicke auf das linke Item um das Perk zu kaufen.");
        lore.add("§c§l» §7Klicke auf das rechts Item um abzubrechen.");
        amount_meta.setLore(lore);
        amount.setItemMeta(amount_meta);

        Inventory inventory = Bukkit.createInventory(null, InventoryType.HOPPER, "§aKauf bestätigung §7(Sofort Schmelzen)");
        inventory.setItem(0, new ItemUtil(Material.LIME_CONCRETE).setName("§aJa").setLore("§eBeim klicken des Items bestätigst du den Kauf der nicht mehr rückgängig ist.").build(true, true, true));
        inventory.setItem(2, amount);
        inventory.setItem(4, new ItemUtil(Material.RED_CONCRETE).setName("§cNein").setLore("§eBeim klicken des Items brichst du den Kauf ab.").build(true, true, true));
        return inventory;
    }

    public static Inventory confirmFeuerBuy() {

        ItemStack amount = new ItemStack(HeadUtil.getCustomSkull("§cWillst du dir dieses Perk wirklich kaufen?", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGUwYjQ2ZjEzYTk1ODI3Y2IxYzljZWE5YmM3ZWVhOWE2ZDhkZDA1YTA3OWZhN2JkNjIxNmZhNDU1ZWJhMDI4NCJ9fX0="));
        ItemMeta amount_meta = amount.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§a§l« §7Klicke auf das linke Item um das Perk zu kaufen.");
        lore.add("§c§l» §7Klicke auf das rechts Item um abzubrechen.");
        amount_meta.setLore(lore);
        amount.setItemMeta(amount_meta);

        Inventory inventory = Bukkit.createInventory(null, InventoryType.HOPPER, "§aKauf bestätigung §7(Feuerresistenz)");
        inventory.setItem(0, new ItemUtil(Material.LIME_CONCRETE).setName("§aJa").setLore("§eBeim klicken des Items bestätigst du den Kauf der nicht mehr rückgängig ist.").build(true, true, true));
        inventory.setItem(2, amount);
        inventory.setItem(4, new ItemUtil(Material.RED_CONCRETE).setName("§cNein").setLore("§eBeim klicken des Items brichst du den Kauf ab.").build(true, true, true));
        return inventory;
    }
    public static Inventory confirmXPBuy() {

        ItemStack amount = new ItemStack(HeadUtil.getCustomSkull("§cWillst du dir dieses Perk wirklich kaufen?", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGUwYjQ2ZjEzYTk1ODI3Y2IxYzljZWE5YmM3ZWVhOWE2ZDhkZDA1YTA3OWZhN2JkNjIxNmZhNDU1ZWJhMDI4NCJ9fX0="));
        ItemMeta amount_meta = amount.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§a§l« §7Klicke auf das linke Item um das Perk zu kaufen.");
        lore.add("§c§l» §7Klicke auf das rechts Item um abzubrechen.");
        amount_meta.setLore(lore);
        amount.setItemMeta(amount_meta);

        Inventory inventory = Bukkit.createInventory(null, InventoryType.HOPPER, "§aKauf bestätigung §7(KeepXP)");
        inventory.setItem(0, new ItemUtil(Material.LIME_CONCRETE).setName("§aJa").setLore("§eBeim klicken des Items bestätigst du den Kauf der nicht mehr rückgängig ist.").build(true, true, true));
        inventory.setItem(2, amount);
        inventory.setItem(4, new ItemUtil(Material.RED_CONCRETE).setName("§cNein").setLore("§eBeim klicken des Items brichst du den Kauf ab.").build(true, true, true));
        return inventory;
    }

}
