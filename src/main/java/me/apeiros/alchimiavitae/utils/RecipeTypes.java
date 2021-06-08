package me.apeiros.alchimiavitae.utils;

import lombok.experimental.UtilityClass;
import me.apeiros.alchimiavitae.AlchimiaVitae;
import me.apeiros.alchimiavitae.setup.Items;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import org.bukkit.NamespacedKey;

/**
 * Holds this addon's {@link RecipeType}s
 */
@UtilityClass
public class RecipeTypes {

    public static final RecipeType SOUL_COLLECTOR_TYPE = new RecipeType(new NamespacedKey(AlchimiaVitae.i(), "soul_collector_type"), Items.SOUL_COLLECTOR, "", "&b&o使用靈魂收集者來提取");
    public static final RecipeType PLANT_INFUSION_CHAMBER_TYPE = new RecipeType(new NamespacedKey(AlchimiaVitae.i(), "plant_infusion_chamber_type"), Items.PLANT_INFUSION_CHAMBER, "", "&b&o使用植物浸液室來注入");
    public static final RecipeType EXP_CRYSTALLIZER_TYPE = new RecipeType(new NamespacedKey(AlchimiaVitae.i(), "exp_crystallizer_type"), Items.EXP_CRYSTALLIZER, "", "&b&o使用經驗結晶機來結晶化");
    public static final RecipeType DIVINE_ALTAR_TYPE = new RecipeType(new NamespacedKey(AlchimiaVitae.i(), "divine_altar_type"), Items.DIVINE_ALTAR, "", "&b&o使用神聖祭壇製作");
    public static final RecipeType ORNATE_CAULDRON_TYPE = new RecipeType(new NamespacedKey(AlchimiaVitae.i(), "ornate_cauldron_type"), Items.ORNATE_CAULDRON, "", "&b&o使用華麗鍋釜釀造");
    public static final RecipeType INFUSION_ALTAR_TYPE = new RecipeType(new NamespacedKey(AlchimiaVitae.i(), "infusion_altar_type"), Items.ALTAR_OF_INFUSION, "", "&b&o使用灌注祭壇注入");

}
