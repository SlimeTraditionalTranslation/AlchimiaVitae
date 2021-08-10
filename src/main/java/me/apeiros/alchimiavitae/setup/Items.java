package me.apeiros.alchimiavitae.setup;

import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.apeiros.alchimiavitae.AlchimiaVitae;
import me.apeiros.alchimiavitae.utils.PotionUtils;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import net.kyori.adventure.text.serializer.craftbukkit.BukkitComponentSerializer;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

import static me.apeiros.alchimiavitae.AlchimiaVitae.MM;

public class Items {

    public static final SlimefunItemStack SOUL_COLLECTOR = new SlimefunItemStack("AV_SOUL_COLLECTOR",
            Material.DIAMOND_SWORD, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#6baefa:#7145b0>靈魂收集者</gradient>")),
            "&b收集靈魂", "&b用這個殺死任何怪物", "&b來抽取它的靈魂");

    private static final Configuration cfg = AlchimiaVitae.i().getConfig();

    static {
        ItemMeta meta = SOUL_COLLECTOR.getItemMeta();
        meta.setUnbreakable(true);

        SOUL_COLLECTOR.setItemMeta(meta);
        SOUL_COLLECTOR.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
    }

    public static final SlimefunItemStack CONDENSED_SOUL = new SlimefunItemStack("AV_CONDENSED_SOUL",
            Material.LIGHT_BLUE_DYE, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#6baefa:#7145b0>凝魂</gradient>")),
            "&b一個靈魂, 凝聚成一顆球", "&9&o也許有方法", "&9&o可以操縱它的力量...");

    static {
        CONDENSED_SOUL.addUnsafeEnchantment(Enchantment.LUCK, 1);
        CONDENSED_SOUL.addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final SlimefunItemStack PLANT_INFUSION_CHAMBER = new SlimefunItemStack("AV_PLANT_INFUSION_CHAMBER",
            Material.LIME_STAINED_GLASS, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#549c64:#1de078>植物浸液室</gradient>")),
            "&b可以為植物注入暗", "&b或光能量, 用於", "&b靈魂與魔法顆粒", "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(1),
            LoreBuilder.powerPerSecond(64));

    public static final SlimefunItemStack GOOD_MAGIC_PLANT = new SlimefunItemStack("AV_GOOD_MAGIC_PLANT",
            Material.OAK_SAPLING, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#2ddae0:#31f876>光魔法植物</gradient>")),
            "&7光魔法 III", "&a散發著至高無上的光芒", "&a發光的與眾不同...");

    static {
        GOOD_MAGIC_PLANT.addUnsafeEnchantment(Enchantment.LUCK, 1);
        GOOD_MAGIC_PLANT.addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final SlimefunItemStack EVIL_MAGIC_PLANT = new SlimefunItemStack("AV_EVIL_MAGIC_PLANT",
            Material.OAK_SAPLING, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#ff5555:#ffa012>暗魔法植物</gradient>")),
            "&7暗魔法 III", "&c包含了無數的黑暗", "&c魔法被鎖在它的木質中...");

    static {
        EVIL_MAGIC_PLANT.addUnsafeEnchantment(Enchantment.LUCK, 1);
        EVIL_MAGIC_PLANT.addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final SlimefunItemStack GOOD_ESSENCE = new SlimefunItemStack("AV_GOOD_ESSENCE",
            Material.SUGAR, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#2ddae0:#31f876>光之精華</gradient>")),
            "&7光魔法 III", "&a生命. 照亮身旁. ");

    public static final SlimefunItemStack EVIL_ESSENCE = new SlimefunItemStack("AV_EVIL_ESSENCE",
            Material.GUNPOWDER, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#ff5555:#ffa012>暗之精華</gradient>")),
            "&7暗魔法 III", "&c死亡. 黑暗侵蝕.");

    public static final SlimefunItemStack EXP_CRYSTALLIZER = new SlimefunItemStack("AV_EXP_CRYSTALLIZER",
            Material.LIME_STAINED_GLASS, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#50fa75:#3dd2ff>經驗結晶機</gradient>")),
            "&a將經驗球轉化成晶體狀,", "&a耐用並充滿活力的形式.",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(1),
            LoreBuilder.powerPerSecond(32));

    public static final SlimefunItemStack EXP_CRYSTAL = new SlimefunItemStack("AV_EXP_CRYSTAL",
            Material.EMERALD, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#50fa75:#3dd2ff>經驗結晶</gradient>")),
            "&a一大塊晶瑩剔透的經驗");

    static {
        EXP_CRYSTAL.addUnsafeEnchantment(Enchantment.LUCK, 1);
        EXP_CRYSTAL.addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final SlimefunItemStack ILLUMIUM = new SlimefunItemStack("AV_ILLUMIUM",
            Material.IRON_INGOT, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#2ddae0:#31f876>光明錠</gradient>")),
            "&a它有力的在你手上散發出光芒");

    static {
        ILLUMIUM.addUnsafeEnchantment(Enchantment.LUCK, 1);
        ILLUMIUM.addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final SlimefunItemStack DARKSTEEL = new SlimefunItemStack("AV_DARKSTEEL",
            Material.NETHERITE_INGOT, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#ff5555:#ffa012>暗鋼錠</gradient>")),
            "&c它散發著... 無盡的黑暗?");

    static {
        DARKSTEEL.addUnsafeEnchantment(Enchantment.LUCK, 1);
        DARKSTEEL.addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final SlimefunItemStack DIVINE_ALTAR = new SlimefunItemStack("AV_DIVINE_ALTAR",
            Material.ENCHANTING_TABLE, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#ff5555:#ff6cfd>神聖祭壇</gradient>")),
            "&5用於進行古代儀式", "&5的神聖裝置");

    public static final SlimefunItemStack MOLTEN_MYSTERY_METAL = new SlimefunItemStack("AV_MOLTEN_MYSTERY_METAL",
            Material.LAVA_BUCKET, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#ff6745:#ff5555>融化的神秘金屬</gradient>")),
            "&6不同於金屬的聚合體");

    public static final SlimefunItemStack MYSTERY_METAL = new SlimefunItemStack("AV_MYSTERY_METAL",
            Material.IRON_INGOT, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#ff6745:#ff5555>神秘金屬錠</gradient>")),
            "&6含有多種金屬");

    public static final SlimefunItemStack POTION_OF_OSMOSIS = new SlimefunItemStack("AV_POTION_OF_OSMOSIS",
            Material.DRAGON_BREATH, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#6274e7:#8752a3>滲透藥水</gradient>")),
            "&6吸收你的藥水效果", "&6並將它們儲存在瓶子中 &e右鍵點擊");

    public static final SlimefunItemStack ORNATE_CAULDRON = new SlimefunItemStack("AV_ORNATE_CAULDRON",
            Material.CAULDRON, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#57ebbe:#f6fa2a>華麗鍋釜</gradient>")),
            "&2用於釀造藥水的高級鍋釜");

    // Make sure to make the int pair at the end {time in seconds * 20, level}
    private static final Map<PotionEffectType, int[]> potEffectsMap = new HashMap<>();

    static {
        // Add effects
        potEffectsMap.put(PotionEffectType.DAMAGE_RESISTANCE, new int[]{
                cfg.getInt("options.potions.benevolent-brew.resistance.ticks"),
                cfg.getInt("options.potions.benevolent-brew.resistance.level") - 1
        });
        potEffectsMap.put(PotionEffectType.FAST_DIGGING, new int[]{
                cfg.getInt("options.potions.benevolent-brew.haste.ticks"),
                cfg.getInt("options.potions.benevolent-brew.haste.level") - 1
        });
        potEffectsMap.put(PotionEffectType.REGENERATION, new int[]{
                cfg.getInt("options.potions.benevolent-brew.regen.ticks"),
                cfg.getInt("options.potions.benevolent-brew.regen.level") - 1
        });
        potEffectsMap.put(PotionEffectType.SPEED, new int[]{
                cfg.getInt("options.potions.benevolent-brew.speed.ticks"),
                cfg.getInt("options.potions.benevolent-brew.speed.level") - 1
        });
        potEffectsMap.put(PotionEffectType.JUMP, new int[]{
                cfg.getInt("options.potions.benevolent-brew.jump.ticks"),
                cfg.getInt("options.potions.benevolent-brew.jump.level") - 1
        });
    }

    public static final SlimefunItemStack BENEVOLENT_BREW = PotionUtils.makePotion(MM.parse(
            "<gradient:#2ddae0:#31f876>仁慈釀造</gradient>"), Color.LIME, potEffectsMap);

    static {
        // Clear the map from the previous usage
        potEffectsMap.clear();

        // Add effects
        potEffectsMap.put(PotionEffectType.WEAKNESS, new int[]{
                cfg.getInt("options.potions.malevolent-concoction.weakness.ticks"),
                cfg.getInt("options.potions.malevolent-concoction.weakness.level") - 1
        });
        potEffectsMap.put(PotionEffectType.SLOW, new int[]{
                cfg.getInt("options.potions.malevolent-concoction.slowness.ticks"),
                cfg.getInt("options.potions.malevolent-concoction.slowness.level") - 1
        });
        potEffectsMap.put(PotionEffectType.POISON, new int[]{
                cfg.getInt("options.potions.malevolent-concoction.poison.ticks"),
                cfg.getInt("options.potions.malevolent-concoction.poison.level") - 1
        });
        potEffectsMap.put(PotionEffectType.BLINDNESS, new int[]{
                cfg.getInt("options.potions.malevolent-concoction.blindness.ticks"),
                cfg.getInt("options.potions.malevolent-concoction.blindness.level") - 1
        });
        potEffectsMap.put(PotionEffectType.HUNGER, new int[]{
                cfg.getInt("options.potions.malevolent-concoction.hunger.ticks"),
                cfg.getInt("options.potions.malevolent-concoction.hunger.level") - 1
        });
    }

    public static final SlimefunItemStack MALEVOLENT_CONCOCTION = PotionUtils.makeSplashPotion(MM.parse(
            "<gradient:#ff5555:#ffa012>惡毒的混合物</gradient>"), Color.MAROON, potEffectsMap);

    public static final SlimefunItemStack ALTAR_OF_INFUSION = new SlimefunItemStack("AV_ALTAR_OF_INFUSION",
            Material.LODESTONE, BukkitComponentSerializer.legacy().serialize
            (MM.parse("<gradient:#f78770:#ff607b>灌注祭壇</gradient>")),
            "&5結合科技的祭壇", "&5和巫術來注入物品", "&5具有強大的屬性",
            "&d只能注入 金,鐵, 鑽石, 或獄髓,", "&弓與弩也可以在這個祭壇上使用");

}
