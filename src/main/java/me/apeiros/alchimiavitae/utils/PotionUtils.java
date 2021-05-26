package me.apeiros.alchimiavitae.utils;

import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.chat.ChatColors;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

/**
 * Holds methods that can create any potion
 */
@UtilityClass
public class PotionUtils {

    public static SlimefunItemStack makePotion(PotionEffect[] effects, String name, String suffix, Color color) {
        return new SlimefunItemStack(
        "AV_" + ChatColor.stripColor(ChatColors.color(name.replace(" ", "_"))).
                toUpperCase() + "_" + suffix.toUpperCase().replace(" ", "_"),
        Material.POTION, name, meta -> {
            PotionMeta potionMeta = (PotionMeta) meta;

            for (PotionEffect effect : effects) {
                potionMeta.addCustomEffect(effect, true);
            }

            potionMeta.setColor(color);
        });
    }

}
