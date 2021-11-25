package me.apeiros.alchimiavitae.utils;

import io.github.mooy1.infinitylib.groups.MultiGroup;
import io.github.mooy1.infinitylib.groups.SubGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;

/**
 * Holds the three subcategories and the main category for this addon
 */
@UtilityClass
public class Categories {

    public static final ItemGroup GENERAL = new SubGroup(
            "av_general",
            new CustomItemStack(Material.ENCHANTED_BOOK, "&6煉金術自傳 &7- &2一般")
    );

    public static final ItemGroup ALTAR_RECIPES = new SubGroup(
            "av_altar_recipes",
            new CustomItemStack(Material.ENCHANTING_TABLE, "&6煉金術自傳 &7- &5祭壇轉換配方")
    );

    public static final ItemGroup INFUSIONS = new SubGroup(
            "av_infusions",
            new CustomItemStack(Material.LODESTONE, "&6煉金術自傳 &7- &d注入物")
    );

    public static final ItemGroup MAIN = new MultiGroup(
            "alchimia_vitae",
            new CustomItemStack(Material.TOTEM_OF_UNDYING, "&6煉金術自傳"),
            GENERAL, ALTAR_RECIPES, INFUSIONS
    );

}
