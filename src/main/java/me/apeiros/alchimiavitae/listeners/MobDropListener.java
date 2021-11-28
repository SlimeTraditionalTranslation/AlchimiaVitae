package me.apeiros.alchimiavitae.listeners;

import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.apeiros.alchimiavitae.setup.Items;
import net.kyori.adventure.platform.bukkit.BukkitComponentSerializer;
import org.bukkit.Sound;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ThreadLocalRandom;

import static me.apeiros.alchimiavitae.AlchimiaVitae.MM;

public class MobDropListener implements Listener {

    public MobDropListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerHit(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player damager = (Player) e.getDamager();

            if (SlimefunUtils.isItemSimilar(damager.getInventory().getItemInMainHand(),
                    Items.SOUL_COLLECTOR, false, false)) {
                e.setCancelled(true);
                damager.sendMessage(BukkitComponentSerializer.legacy().serialize(MM.parse("<red>你不能用靈魂收集者傷害玩家!")));
                damager.playSound(damager.getLocation(), Sound.BLOCK_GLASS_BREAK, 1, 1);
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onEntityDeath(EntityDeathEvent e) {
        if (e.getEntity().getKiller() != null && !(e.getEntity() instanceof Player) && !(e.getEntity() instanceof EnderDragon)) {
            Player killer = e.getEntity().getKiller();
            ThreadLocalRandom r = ThreadLocalRandom.current();

            if (r.nextInt(2) == 0 && SlimefunUtils.isItemSimilar(killer.getInventory().getItemInMainHand(),
                    Items.SOUL_COLLECTOR, false, false)) {
                killer.playSound(killer.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 0.4F,1);

                if (e.getEntity() instanceof Wither /*(1.19) || e.getEntity() instanceof Warden */) {
                    for (int i = 0; i < r.nextInt(9); i++) {
                        e.getDrops().add(Items.CONDENSED_SOUL);
                    }
                } else if (e.getEntity() instanceof WitherSkeleton) {
                    for (int i = 0; i < r.nextInt(4); i++) {
                        e.getDrops().add(Items.CONDENSED_SOUL);
                        e.setDroppedExp(e.getDroppedExp() * 3);
                    }
                } else if (e.getEntity() instanceof EnderDragon) {
                    e.getDrops().add(Items.CONDENSED_SOUL);
                } else {
                    e.getDrops().add(Items.CONDENSED_SOUL);
                    e.setDroppedExp(e.getDroppedExp() * 3);
                }
            }
        }
    }
}
