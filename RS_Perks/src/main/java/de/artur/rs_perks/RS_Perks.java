package de.artur.rs_perks;

import de.artur.rs_perks.commands.PerksCommand;
import de.artur.rs_perks.listener.Listeners;
import de.artur.rs_perks.listener.PerksActivate;
import de.artur.rs_perks.utils.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class RS_Perks extends JavaPlugin {

    public static RS_Perks instance;
    public static RS_Perks plugin;
    public static MySQL mysql;
    @Override
    public void onEnable() {
        instance = this;
        plugin = this;
        Bukkit.getConsoleSender().sendMessage("§aPerks startet...");
        loadConfig();
        getCommand("perks").setExecutor(new PerksCommand());
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
        Bukkit.getPluginManager().registerEvents(new PerksActivate(), this);;
        connectMySQL();
    }

    private void loadConfig() {
        this.getConfig().addDefault("Prefix", "§a&lPerks §8| ");
        this.getConfig().addDefault("InventoryName", "§a§lPerks");
        this.getConfig().addDefault("Kein Fallschaden.Material", "FEATHER");
        this.getConfig().addDefault("Kein Fallschaden.Name", "§6Kein Fallschaden Perk");
        this.getConfig().addDefault("Kein Fallschaden.Lore", "&7Durch dieses Perk bekommst du keinen Fallschaden mehr.");
        this.getConfig().addDefault("Kein Fallschaden.PriceLore", "&7Preis: &a30.000$");
        this.getConfig().addDefault("Kein Fallschaden.Slot", 1);
        this.getConfig().addDefault("Kein Fallschaden.Price", 30000);
        this.getConfig().addDefault("Nachtsicht.Material", "ENDER_EYE");
        this.getConfig().addDefault("Nachtsicht.Name", "§6Nachtsicht Perk");
        this.getConfig().addDefault("Nachtsicht.Lore", "&7Durch dieses Perk bekommst du durchgehend Nachtsicht.");
        this.getConfig().addDefault("Nachtsicht.PriceLore", "&7Preis: &a20.000$");
        this.getConfig().addDefault("Nachtsicht.Slot", 3);
        this.getConfig().addDefault("Nachtsicht.Price", 20000);
        this.getConfig().addDefault("Kein Ertrinken.Material", "WATER_BUCKET");
        this.getConfig().addDefault("Kein Ertrinken.Name", "§6Kein Ertrinken Perk");
        this.getConfig().addDefault("Kein Ertrinken.Lore", "&7Durch dieses Perk kannst du nicht mehr Ertrinken.");
        this.getConfig().addDefault("Kein Ertrinken.PriceLore", "&7Preis: &a10.000$");
        this.getConfig().addDefault("Kein Ertrinken.Slot", 5);
        this.getConfig().addDefault("Kein Ertrinken.Price", 10000);
        this.getConfig().addDefault("Kein Hunger.Material", "COOKED_BEEF");
        this.getConfig().addDefault("Kein Hunger.Name", "§6Kein Hunger Perk");
        this.getConfig().addDefault("Kein Hunger.Lore", "&7Durch dieses Perk bekommst du keinen Hunger mehr.");
        this.getConfig().addDefault("Kein Hunger.PriceLore", "&7Preis: &a25.000$");
        this.getConfig().addDefault("Kein Hunger.Slot", 7);
        this.getConfig().addDefault("Kein Hunger.Price", 25000);
        this.getConfig().addDefault("Sofort Schmelzen.Material", "FURNACE");
        this.getConfig().addDefault("Sofort Schmelzen.Name", "§6Sofort Schmelzen Perk");
        this.getConfig().addDefault("Sofort Schmelzen.Lore", "&7Durch dieses Perk werden deine abgebauten Erze direkt geschmolzen.");
        this.getConfig().addDefault("Sofort Schmelzen.PriceLore", "&7Preis: &a15.000$");
        this.getConfig().addDefault("Sofort Schmelzen.Slot", 29);
        this.getConfig().addDefault("Sofort Schmelzen.Price", 15000);
        this.getConfig().addDefault("Feuerresistenz.Material", "POTION");
        this.getConfig().addDefault("Feuerresistenz.Name", "§6Feuerresistenz Perk");
        this.getConfig().addDefault("Feuerresistenz.Lore", "&7Durch dieses Perk bekommst du durchgehend Feuerresistenz.");
        this.getConfig().addDefault("Feuerresistenz.PriceLore", "&7Preis: &a15.000$");
        this.getConfig().addDefault("Feuerresistenz.Slot", 31);
        this.getConfig().addDefault("Feuerresistenz.Price", 15000);
        this.getConfig().addDefault("XP.Material", "EXPERIENCE_BOTTLE");
        this.getConfig().addDefault("XP.Name", "§6KeepXP Perk");
        this.getConfig().addDefault("XP.Lore", "&7Durch dieses Perk behälst du deine XP.");
        this.getConfig().addDefault("XP.PriceLore", "&7Preis: &a50.000$");
        this.getConfig().addDefault("XP.Slot", 33);
        this.getConfig().addDefault("XP.Price", 50000);
        this.getConfig().addDefault("Nicht Verfügbar.Material", "YELLOW_STAINED_GLASS_PANE");
        this.getConfig().addDefault("Nicht Verfügbar.Name", "§6Nicht verfügbar");
        this.getConfig().addDefault("Nicht Verfügbar.Lore", "§7Klicke, um das Perk zu kaufen.");
        this.getConfig().addDefault("Aktiviert.Material", "LIME_STAINED_GLASS_PANE");
        this.getConfig().addDefault("Aktiviert.Name", "§aAktiviert");
        this.getConfig().addDefault("Aktiviert.Lore", "§7Klicke, um das Perk zu deaktivieren");
        this.getConfig().addDefault("Deaktiviert.Material", "RED_STAINED_GLASS_PANE");
        this.getConfig().addDefault("Deaktiviert.Name", "§cDeaktiviert");
        this.getConfig().addDefault("Deaktiviert.Lore", "§7Klicke, um das Perk zu aktivieren");
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§cPerks fährt runter...");
    }

    public static RS_Perks getInstance() {return instance;}

    public static RS_Perks getPlugin() {return plugin;}

    public void connectMySQL() {
        File mysqlf = new File("plugins/RS_Perks", "mysql.yml");
        YamlConfiguration mysqly = YamlConfiguration.loadConfiguration(mysqlf);
        if(mysqly.get("host") == null)
            mysqly.set("host", "host");
        if(mysqly.get("database") == null)
            mysqly.set("database", "database");
        if(mysqly.get("user") == null)
            mysqly.set("user", "user");
        if(mysqly.get("password") == null)
            mysqly.set("password", "password");
        try {
            mysqly.save(mysqlf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String host = mysqly.getString("host");
        String database = mysqly.getString("database");
        String user = mysqly.getString("user");
        String password = mysqly.getString("password");
        if (host.equalsIgnoreCase("host") && database.equalsIgnoreCase("database") && user.equalsIgnoreCase("user") && password.equalsIgnoreCase("password")) {
            Bukkit.getConsoleSender().sendMessage("§r§cBitte trage deine MySQL-Daten in der Config ein!");
            Bukkit.getPluginManager().disablePlugin(getInstance());
        } else {
            mysql = new MySQL(host, database, user, password);
            mysql.connect();
            mysql.update("CREATE TABLE IF NOT EXISTS perks(UUID varchar(64), FallschadenPerk int, FallschadenPerkStatus int, NachtsichtPerk int, NachtsichtPerkStatus int, HungerPerk int, HungerPerkStatus int, ErtrinkenPerk int, ErtrinkenPerkStatus int, SchmelzenPerk int, SchmelzenPerkStatus int, FeuerresistenzPerk int, FeuerresistenzPerkStatus int, XPPerk int, XPPerkStatus int);");
        }
    }
}
