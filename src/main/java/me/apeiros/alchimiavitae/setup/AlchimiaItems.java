package me.apeiros.alchimiavitae.setup;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;

import me.apeiros.alchimiavitae.AlchimiaUtils;
import me.apeiros.alchimiavitae.AlchimiaVitae;

/**
 * Holds {@link SlimefunItemStack} constants used in {@link AlchimiaVitae}
 */
public class AlchimiaItems {

    // {{{ Menu items (for custom crafters)
    public static final ItemStack IN_BG = new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE,
            AlchimiaUtils.format("<gradient:#ff68fc:#ff9a5c>${alchimiavitae.menuitem.input}</gradient>"));

    public static final ItemStack CRAFT_BTN = new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,
            AlchimiaUtils.format("<gradient:#39f792:#5c95ff>${alchimiavitae.menuitem.craft}</gradient>"), "${alchimiavitae.menuitem.craft.lore}");

    public static final ItemStack CRAFT_BG = new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE,
            AlchimiaUtils.format("<gradient:#39f792:#5c95ff>${alchimiavitae.menuitem.craft}</gradient>"));

    public static final ItemStack OUT_BG = new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE,
            AlchimiaUtils.format("<gradient:#5cb8ff:#39f7e1>${alchimiavitae.menuitem.output}</gradient>"));
    // }}}

    // {{{ Tools
    public static final SlimefunItemStack SOUL_COLLECTOR = new SlimefunItemStack("AV_SOUL_COLLECTOR",
            Material.DIAMOND_SWORD, AlchimiaUtils.format("<gradient:#6baefa:#7145b0>${alchimiavitae.soul_collector.name}</gradient>"),
            "${alchimiavitae.soul_collector.lore.01}", "",
            "${alchimiavitae.soul_collector.lore.02}",
            "${alchimiavitae.soul_collector.lore.03}",
            "${alchimiavitae.soul_collector.lore.04}",
            "${alchimiavitae.soul_collector.lore.05}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.tool}"));

    static {
        ItemMeta meta = SOUL_COLLECTOR.getItemMeta();
        meta.setUnbreakable(true);

        SOUL_COLLECTOR.setItemMeta(meta);
        SOUL_COLLECTOR.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
    }
    // }}}

    // {{{ Machines
    public static final SlimefunItemStack PLANT_INFUSION_CHAMBER = new SlimefunItemStack("AV_PLANT_INFUSION_CHAMBER",
            Material.LIME_STAINED_GLASS, AlchimiaUtils.format("<gradient:#549c64:#1de078>${alchimiavitae.av_plant_infusion_chamber.name}</gradient>"),
            "${alchimiavitae.av_plant_infusion_chamber.lore.01}",
            "${alchimiavitae.av_plant_infusion_chamber.lore.02}",
            "${alchimiavitae.av_plant_infusion_chamber.lore.03}", "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(1),
            LoreBuilder.powerPerSecond(64),
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.machine}"));

    public static final SlimefunItemStack EXP_CRYSTALLIZER = new SlimefunItemStack("AV_EXP_CRYSTALLIZER",
            Material.LIME_STAINED_GLASS,
            AlchimiaUtils.format("<gradient:#50fa75:#3dd2ff>${alchimiavitae.av_exp_crystallizer.name}</gradient>"),
            "${alchimiavitae.av_exp_crystallizer.lore.01}",
            "${alchimiavitae.av_exp_crystallizer.lore.02}", "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(1),
            LoreBuilder.powerPerSecond(32),
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.machine}"));
    // }}}

    // {{{ Resources
    public static final SlimefunItemStack CONDENSED_SOUL = new SlimefunItemStack("AV_CONDENSED_SOUL",
            Material.LIGHT_BLUE_DYE, AlchimiaUtils.format("<gradient:#6baefa:#7145b0>${alchimiavitae.av_condensed_soul.name}</gradient>"),
            "${alchimiavitae.av_condensed_soul.lore.01}",
            "${alchimiavitae.av_condensed_soul.lore.02}",
            "${alchimiavitae.av_condensed_soul.lore.03}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.raw_magic_resource}"));

    static {
        ItemMeta meta = CONDENSED_SOUL.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        CONDENSED_SOUL.setItemMeta(meta);
        CONDENSED_SOUL.addUnsafeEnchantment(Enchantment.LUCK, 1);
    }

    public static final SlimefunItemStack LIGHT_MAGIC_PLANT = new SlimefunItemStack("AV_GOOD_MAGIC_PLANT",
            Material.OAK_SAPLING,
            AlchimiaUtils.format("<gradient:#2ddae0:#31f876>${alchimiavitae.av_good_magic_plant.name}</gradient>"),
            "${alchimiavitae.av_good_magic_plant.lore.01}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.base_magic_resource}"));

    static {
        ItemMeta meta = LIGHT_MAGIC_PLANT.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        LIGHT_MAGIC_PLANT.setItemMeta(meta);
        LIGHT_MAGIC_PLANT.addUnsafeEnchantment(Enchantment.LUCK, 1);
    }

    public static final SlimefunItemStack DARK_MAGIC_PLANT = new SlimefunItemStack("AV_EVIL_MAGIC_PLANT",
            Material.OAK_SAPLING,
            AlchimiaUtils.format("<gradient:#ff5555:#ffa012>${alchimiavitae.av_evil_magic_plant.name}</gradient>"),
            "${alchimiavitae.av_evil_magic_plant.lore.01}",
            "${alchimiavitae.av_evil_magic_plant.lore.02}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.base_magic_resource}"));

    static {
        ItemMeta meta = DARK_MAGIC_PLANT.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        DARK_MAGIC_PLANT.setItemMeta(meta);
        DARK_MAGIC_PLANT.addUnsafeEnchantment(Enchantment.LUCK, 1);
    }

    public static final SlimefunItemStack EXP_CRYSTAL = new SlimefunItemStack("AV_EXP_CRYSTAL",
            Material.EMERALD,
            AlchimiaUtils.format("<gradient:#50fa75:#3dd2ff>${alchimiavitae.av_exp_crystal.name}</gradient>"),
            "${alchimiavitae.av_exp_crystal.lore.01}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.base_magic_resource}"));

    static {
        ItemMeta meta = EXP_CRYSTAL.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        EXP_CRYSTAL.setItemMeta(meta);
        EXP_CRYSTAL.addUnsafeEnchantment(Enchantment.LUCK, 1);
    }

    public static final SlimefunItemStack LIGHT_ESSENCE = new SlimefunItemStack("AV_GOOD_ESSENCE",
            Material.SUGAR,
            AlchimiaUtils.format("<gradient:#2ddae0:#31f876>${alchimiavitae.av_good_essence.name}</gradient>"),
            "${alchimiavitae.av_good_essence.lore.01}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.processed_magic_resource}"));

    public static final SlimefunItemStack DARK_ESSENCE = new SlimefunItemStack("AV_EVIL_ESSENCE",
            Material.GUNPOWDER,
            AlchimiaUtils.format("<gradient:#ff5555:#ffa012>${alchimiavitae.av_evil_essence.name}</gradient>"),
            "${alchimiavitae.av_evil_essence.lore.01}",
            "${alchimiavitae.av_evil_essence.lore.02}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.processed_magic_resource}"));

    public static final SlimefunItemStack ILLUMIUM = new SlimefunItemStack("AV_ILLUMIUM",
            Material.IRON_INGOT,
            AlchimiaUtils.format("<gradient:#2ddae0:#31f876>${alchimiavitae.av_illumium.name}</gradient>"),
            "${alchimiavitae.av_illumium.lore.01}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.enriched_magic_resource}"));

    static {
        ItemMeta meta = ILLUMIUM.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ILLUMIUM.setItemMeta(meta);
        ILLUMIUM.addUnsafeEnchantment(Enchantment.LUCK, 1);
    }

    public static final SlimefunItemStack DARKSTEEL = new SlimefunItemStack("AV_DARKSTEEL",
            Material.NETHERITE_INGOT,
            AlchimiaUtils.format("<gradient:#ff5555:#ffa012>${alchimiavitae.av_darksteel.name}</gradient>"),
            "${alchimiavitae.av_darksteel.lore.01}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.enriched_magic_resource}"));

    static {
        ItemMeta meta = DARKSTEEL.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        DARKSTEEL.setItemMeta(meta);
        DARKSTEEL.addUnsafeEnchantment(Enchantment.LUCK, 1);
    }
    // }}}

    // {{{ Divine Altar (Transmutation)
    public static final SlimefunItemStack DIVINE_ALTAR = new SlimefunItemStack("AV_DIVINE_ALTAR",
            Material.ENCHANTING_TABLE,
            AlchimiaUtils.format("<gradient:#ff5555:#ff6cfd>${alchimiavitae.av_divine_altar.name}</gradient>"),
            "${alchimiavitae.av_divine_altar.lore.01}",
            "${alchimiavitae.av_divine_altar.lore.02}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.altar}"));

    public static final SlimefunItemStack MOLTEN_MYSTERY_METAL = new SlimefunItemStack("AV_MOLTEN_MYSTERY_METAL",
            Material.LAVA_BUCKET,
            AlchimiaUtils.format("<gradient:#ff6745:#ff5555>${alchimiavitae.av_molten_mystery_metal.name}</gradient>"),
            "${alchimiavitae.av_molten_mystery_metal.lore.01}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.transmutation_resource}"));

    public static final SlimefunItemStack MYSTERY_METAL = new SlimefunItemStack("AV_MYSTERY_METAL",
            Material.IRON_INGOT,
            AlchimiaUtils.format("<gradient:#ff6745:#ff5555>${alchimiavitae.av_mystery_metal.name}</gradient>"),
            "${alchimiavitae.av_mystery_metal.lore.01}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.transmutation_resource}"));
    // }}}

    // {{{ Cosmic Cauldron (Potions)
    public static final SlimefunItemStack COSMIC_CAULDRON = new SlimefunItemStack("AV_ORNATE_CAULDRON",
            Material.CAULDRON,
            AlchimiaUtils.format("<gradient:#57ebbe:#f6fa2a>${alchimiavitae.av_ornate_cauldron.name}</gradient>"),
            "${alchimiavitae.av_ornate_cauldron.lore.01}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.altar}"));

    private static final Map<PotionEffectType, int[]> potEffectsMap = new HashMap<>();

    public static final SlimefunItemStack POTION_OF_OSMOSIS = AlchimiaUtils.makePotion(
            "AV_POTION_OF_OSMOSIS",
            AlchimiaUtils.format("<gradient:#6274e7:#8752a3>${alchimiavitae.av_potion_of_osmosis.name}</gradient>"),
            Color.SILVER, potEffectsMap, false,
            "${alchimiavitae.av_potion_of_osmosis.lore.01}",
            "${alchimiavitae.av_potion_of_osmosis.lore.02}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.potion}"));

    private static final Configuration cfg = AlchimiaVitae.i().getConfig();

    static {
        // Add effects
        potEffectsMap.put(PotionEffectType.DAMAGE_RESISTANCE, new int[] {
                cfg.getInt("options.potions.benevolent-brew.resistance.ticks"),
                cfg.getInt("options.potions.benevolent-brew.resistance.level") - 1
        });
        potEffectsMap.put(PotionEffectType.FAST_DIGGING, new int[] {
                cfg.getInt("options.potions.benevolent-brew.haste.ticks"),
                cfg.getInt("options.potions.benevolent-brew.haste.level") - 1
        });
        potEffectsMap.put(PotionEffectType.REGENERATION, new int[] {
                cfg.getInt("options.potions.benevolent-brew.regen.ticks"),
                cfg.getInt("options.potions.benevolent-brew.regen.level") - 1
        });
        potEffectsMap.put(PotionEffectType.SPEED, new int[] {
                cfg.getInt("options.potions.benevolent-brew.speed.ticks"),
                cfg.getInt("options.potions.benevolent-brew.speed.level") - 1
        });
        potEffectsMap.put(PotionEffectType.JUMP, new int[] {
                cfg.getInt("options.potions.benevolent-brew.jump.ticks"),
                cfg.getInt("options.potions.benevolent-brew.jump.level") - 1
        });
    }

    public static final SlimefunItemStack BENEVOLENT_BREW = AlchimiaUtils.makePotion(
            "AV_BENEVOLENT_BREW_POTION",
            AlchimiaUtils.format("<gradient:#2ddae0:#31f876>${alchimiavitae.av_benevolent_brew_potion.name}</gradient>"),
            Color.LIME, potEffectsMap, false,
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.potion}"));

    static {
        // Clear the map from the previous usage
        potEffectsMap.clear();

        // Add effects
        potEffectsMap.put(PotionEffectType.WEAKNESS, new int[] {
                cfg.getInt("options.potions.malevolent-concoction.weakness.ticks"),
                cfg.getInt("options.potions.malevolent-concoction.weakness.level") - 1
        });
        potEffectsMap.put(PotionEffectType.SLOW, new int[] {
                cfg.getInt("options.potions.malevolent-concoction.slowness.ticks"),
                cfg.getInt("options.potions.malevolent-concoction.slowness.level") - 1
        });
        potEffectsMap.put(PotionEffectType.POISON, new int[] {
                cfg.getInt("options.potions.malevolent-concoction.poison.ticks"),
                cfg.getInt("options.potions.malevolent-concoction.poison.level") - 1
        });
        potEffectsMap.put(PotionEffectType.BLINDNESS, new int[] {
                cfg.getInt("options.potions.malevolent-concoction.blindness.ticks"),
                cfg.getInt("options.potions.malevolent-concoction.blindness.level") - 1
        });
        potEffectsMap.put(PotionEffectType.HUNGER, new int[] {
                cfg.getInt("options.potions.malevolent-concoction.hunger.ticks"),
                cfg.getInt("options.potions.malevolent-concoction.hunger.level") - 1
        });
    }

    public static final SlimefunItemStack MALEVOLENT_CONCOCTION = AlchimiaUtils.makePotion(
            "AV_MALEVOLENT_CONCOCTION_SPLASH_POTION",
            AlchimiaUtils.format("<gradient:#ff5555:#ffa012>${alchimiavitae.av_malevolent_concoction_splash_potion.name}</gradient>"),
            Color.MAROON, potEffectsMap, true,
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.potion}"));
    // }}}

    // {{{ Altar of Infusion (Infusion)
    public static final SlimefunItemStack ALTAR_OF_INFUSION = new SlimefunItemStack("AV_ALTAR_OF_INFUSION",
            Material.LODESTONE, AlchimiaUtils.format("<gradient:#f78770:#ff607b>${alchimiavitae.av_altar_of_infusion.name}</gradient>"),
            "${alchimiavitae.av_altar_of_infusion.lore.01}", "",
            "${alchimiavitae.av_altar_of_infusion.lore.02}",
            "${alchimiavitae.av_altar_of_infusion.lore.03}",
            "", AlchimiaUtils.itemType("${alchimiavitae.itemtype.altar}"));
    // }}}

}
