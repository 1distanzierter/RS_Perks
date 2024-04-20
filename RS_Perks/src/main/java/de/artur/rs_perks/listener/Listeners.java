package de.artur.rs_perks.listener;

import de.artur.rs_perks.RS_Perks;
import de.artur.rs_perks.utils.UpdatePerk;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.Collection;
import java.util.HashMap;

public class Listeners implements Listener {

    HashMap<Player, Integer> lvl = new HashMap<Player, Integer>();

    private String prefix = RS_Perks.getInstance().getConfig().getString("Prefix").replace("&", "§");
    private FileConfiguration config = RS_Perks.getInstance().getConfig();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        UpdatePerk.createPlayer(String.valueOf(p.getUniqueId()));
        if(UpdatePerk.getNachtsichtPerkStatus(p.getUniqueId()) == 1)
            p.addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(900000, 4));
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(UpdatePerk.getNachtsichtPerkStatus(p.getUniqueId()) == 1)
            p.removePotionEffect(PotionEffectType.NIGHT_VISION);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        Player p = (Player) e.getEntity();
        if (UpdatePerk.getFallschadenPerkStatus(p.getUniqueId()) == 1) {
            if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL))
                e.setCancelled(true);
        }
        if(UpdatePerk.getFeuerPerkStatus(p.getUniqueId()) == 1) {
            if(e.getCause().equals(EntityDamageEvent.DamageCause.FIRE) || e.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK) || e.getCause().equals(EntityDamageEvent.DamageCause.LAVA)) {
                e.setCancelled(true);
            }
        }
        if(UpdatePerk.getErtrinkenPerkStatus(p.getUniqueId()) == 1) {
            if(e.getCause().equals(EntityDamageEvent.DamageCause.DROWNING)) {
                e.setCancelled(true);
            }
        }
        if(UpdatePerk.getXPPerkStatus(p.getUniqueId()) == 1) {
            if(p.getHealth() <= 0) {
                lvl.put(p, p.getLevel());
            }
        }
    }

    @EventHandler
    public void onFood(FoodLevelChangeEvent e) {
        Player p = (Player) e.getEntity();
        if(UpdatePerk.getHungerPerkStatus(p.getUniqueId()) == 1) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getPlayer();
        if(UpdatePerk.getXPPerkStatus(p.getUniqueId()) == 1) {
            e.setKeepLevel(true);
            e.setShouldDropExperience(false);
        }
    }
    @EventHandler
    public void breakEvent(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if(UpdatePerk.getSchmelzenPerkStatus(p.getUniqueId()) == 1) {
            ItemStack tool = e.getPlayer().getInventory().getItemInMainHand();
            int drops = e.getBlock().getDrops(tool).size();

            Material blockType = e.getBlock().getType();
            String typeName = blockType.name();

            if (e.getBlock().getType().equals(Material.IRON_ORE) || e.getBlock().getType().equals(Material.DEEPSLATE_IRON_ORE)) {
                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                for (int i=0; i<drops; i++) {
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
                }
            }
            if (e.getBlock().getType().equals(Material.GOLD_ORE) || e.getBlock().getType().equals(Material.DEEPSLATE_GOLD_ORE)) {
                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                for (int i=0; i<drops; i++) {
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
                }
            }
            if (e.getBlock().getType().equals(Material.COPPER_ORE) || e.getBlock().getType().equals(Material.DEEPSLATE_COPPER_ORE)) {
                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                for (int i=0; i<drops; i++) {
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.COPPER_INGOT));
                }
            }
        }
        }
}
