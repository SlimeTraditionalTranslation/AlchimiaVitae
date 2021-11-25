package me.apeiros.alchimiavitae.utils;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import net.kyori.adventure.platform.bukkit.BukkitComponentSerializer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static me.apeiros.alchimiavitae.AlchimiaVitae.MM;

/**
 * This class holds {@link ItemStack}s
 * that are frequently used in inventories
 */
@UtilityClass
public class ChestMenuItems {

    public static final ItemStack IN_BG = new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE,
            BukkitComponentSerializer.legacy().serialize(MM.parse("<gradient:#ff68fc:#ff9a5c>輸入</gradient>")));

    public static final ItemStack CRAFT_BTN = new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,
            BukkitComponentSerializer.legacy().serialize(MM.parse("<gradient:#39f792:#5c95ff>製作</gradient>")),
            "&a點擊製作");

    public static final ItemStack CRAFT_BG = new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE,
            BukkitComponentSerializer.legacy().serialize(MM.parse("<gradient:#39f792:#5c95ff>製作</gradient>")));

    public static final ItemStack OUT_BG = new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE,
            BukkitComponentSerializer.legacy().serialize(MM.parse("<gradient:#5cb8ff:#39f7e1>輸出</gradient>")));

}
