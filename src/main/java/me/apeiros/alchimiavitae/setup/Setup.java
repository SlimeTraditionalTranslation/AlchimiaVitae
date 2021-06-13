package me.apeiros.alchimiavitae.setup;

import io.github.mooy1.infinitylib.recipes.inputs.MultiInput;
import io.github.thebusybiscuit.slimefun4.core.researching.Research;
import io.github.thebusybiscuit.slimefun4.core.services.CustomTextureService;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import me.apeiros.alchimiavitae.AlchimiaVitae;
import me.apeiros.alchimiavitae.listeners.EntityDeathListener;
import me.apeiros.alchimiavitae.listeners.infusion.*;
import me.apeiros.alchimiavitae.setup.items.crafters.AltarOfInfusion;
import me.apeiros.alchimiavitae.setup.items.crafters.DivineAltar;
import me.apeiros.alchimiavitae.setup.items.crafters.OrnateCauldron;
import me.apeiros.alchimiavitae.setup.items.electric.EXPCrystallizer;
import me.apeiros.alchimiavitae.setup.items.electric.PlantInfusionChamber;
import me.apeiros.alchimiavitae.setup.items.general.*;
import me.apeiros.alchimiavitae.setup.items.plants.EvilEssence;
import me.apeiros.alchimiavitae.setup.items.plants.EvilMagicPlant;
import me.apeiros.alchimiavitae.setup.items.plants.GoodEssence;
import me.apeiros.alchimiavitae.setup.items.plants.GoodMagicPlant;
import me.apeiros.alchimiavitae.setup.items.potions.BenevolentBrew;
import me.apeiros.alchimiavitae.setup.items.potions.MalevolentConcoction;
import me.apeiros.alchimiavitae.setup.items.potions.PotionOfOsmosis;
import me.apeiros.alchimiavitae.utils.Categories;
import me.apeiros.alchimiavitae.utils.RecipeTypes;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class Setup {

    private static final NamespacedKey axeInfusionDestructiveCrits = new NamespacedKey(AlchimiaVitae.i(), "infusion_destructivecrits");
    private static final NamespacedKey axeInfusionPhantomCrits = new NamespacedKey(AlchimiaVitae.i(), "infusion_phantomcrits");
    private static final NamespacedKey chestplateInfusionTotemBattery = new NamespacedKey(AlchimiaVitae.i(), "infusion_totemstorage");
    private static final NamespacedKey bowInfusionTrueAim = new NamespacedKey(AlchimiaVitae.i(), "infusion_trueaim");
    private static final NamespacedKey bowInfusionForceful = new NamespacedKey(AlchimiaVitae.i(), "infusion_forceful");
    private static final NamespacedKey bowInfusionVolatile = new NamespacedKey(AlchimiaVitae.i(), "infusion_volatile");
    private static final NamespacedKey bowInfusionHealing = new NamespacedKey(AlchimiaVitae.i(), "infusion_healing");
    private static final NamespacedKey hoeInfusionAutoReplant = new NamespacedKey(AlchimiaVitae.i(), "infusion_autoreplant");

    public static void setup(AlchimiaVitae p) {
        // Category
        Categories.MAIN.register(p);

        // Items
        new SoulCollector(Categories.GENERAL).register(p);
        new CondensedSoul(Categories.GENERAL).register(p);
        new PlantInfusionChamber(Categories.GENERAL).register(p);
        new GoodMagicPlant(Categories.GENERAL).register(p);
        new EvilMagicPlant(Categories.GENERAL).register(p);
        new GoodEssence(Categories.GENERAL).register(p);
        new EvilEssence(Categories.GENERAL).register(p);
        new EXPCrystallizer(Categories.GENERAL).register(p);
        new EXPCrystal(Categories.GENERAL).register(p);
        new Illumium(Categories.GENERAL).register(p);
        new Darksteel(Categories.GENERAL).register(p);

        // Divine Altar
        new DivineAltar(Categories.GENERAL).register(p);
        setupDivineAltar(p);

        // Items cont.d
        new MoltenMysteryMetal(Categories.GENERAL).register(p);
        new MysteryMetal(Categories.GENERAL).register(p);

        // Ornate Cauldron
        new OrnateCauldron(Categories.GENERAL).register(p);
        setupOrnateCauldron();

        // Items cont.d
        new PotionOfOsmosis(Categories.GENERAL).register(p);
        new BenevolentBrew(Categories.GENERAL, p).register(p);
        new MalevolentConcoction(Categories.GENERAL, p).register(p);

        // Altar of Infusion
        new AltarOfInfusion(Categories.INFUSIONS).register(p);
        setupInfusionAltar(p);

        // Listeners
        new EntityDeathListener(p);
        new InfusionAxeAttackListener(p);
        new InfusionBowShootListener(p);
        new InfusionHoeReapListener(p);
        new InfusionTotemRightClickListener(p);
        new InfusionTotemStorageDeathListener(p);

        // Researches
        setupResearches(p);
    }

    public static void setupResearches(AlchimiaVitae p) {
        new Research(new NamespacedKey(p, "soul"), 131072,
                "破壞生死輪迴", 25)
                .addItems(Items.CONDENSED_SOUL, Items.SOUL_COLLECTOR)
                .register();

        new Research(new NamespacedKey(p, "magic_plants"), 131073,
                "兩極對立", 30)
                .addItems(Items.PLANT_INFUSION_CHAMBER, Items.GOOD_MAGIC_PLANT, Items.EVIL_MAGIC_PLANT)
                .register();

        new Research(new NamespacedKey(p, "magic_essence"), 131074,
                "磨它下來", 10)
                .addItems(Items.GOOD_ESSENCE, Items.EVIL_ESSENCE)
                .register();

        new Research(new NamespacedKey(p, "exp_crystals"), 131075,
                "結晶化經驗", 21)
                .addItems(Items.EXP_CRYSTALLIZER, Items.EXP_CRYSTAL)
                .register();

        new Research(new NamespacedKey(p, "magic_steel"), 131076,
                "神秘金屬", 16)
                .addItems(Items.DARKSTEEL, Items.ILLUMIUM)
                .register();

        new Research(new NamespacedKey(p, "divine_altar"), 131077,
                "古代祭壇失散多年的兄弟", 45)
                .addItems(Items.DIVINE_ALTAR)
                .register();

        new Research(new NamespacedKey(p, "metal_amalgamation"), 131078,
                "一種金屬物質的混和物", 19)
                .addItems(Items.MOLTEN_MYSTERY_METAL, Items.MYSTERY_METAL)
                .register();

        new Research(new NamespacedKey(p, "ornate_cauldron"), 131079,
                "用於釀造高級藥水的裝置", 35)
                .addItems(Items.ORNATE_CAULDRON)
                .register();

        new Research(new NamespacedKey(p, "potion_of_osmosis"), 131080,
                "滲透與吸收", 30)
                .addItems(Items.POTION_OF_OSMOSIS)
                .register();

        new Research(new NamespacedKey(p, "benevolent_brew"), 131081,
                "蓋亞本人的祝福", 35)
                .addItems(Items.BENEVOLENT_BREW)
                .register();

        new Research(new NamespacedKey(p, "malevolent_concoction"), 131082,
                "一種帶有輕微腐壞色彩的物質", 35)
                .addItems(Items.MALEVOLENT_CONCOCTION)
                .register();

        new Research(new NamespacedKey(p, "altar_of_infusion"), 131083,
                "為你的物品注入活力的終極祭壇", 30)
                .addItems(Items.ALTAR_OF_INFUSION)
                .register();
    }

    private static void setupDivineAltar(AlchimiaVitae p) {
        // Get config values
        boolean reinforcedTransmutationEnabled = p.getConfig().getBoolean("options.transmutations.reinforced-transmutation");
        boolean hardenedTransmutationEnabled = p.getConfig().getBoolean("options.transmutations.hardened-transmutation");
        boolean steelTransmutationEnabled = p.getConfig().getBoolean("options.transmutations.steel-transmutation");
        boolean damascusTransmutationEnabled = p.getConfig().getBoolean("options.transmutations.damascus-transmutation");
        boolean compressedCarbonTransmutationEnabled = p.getConfig().getBoolean("options.transmutations.compressed-carbon-transmutation");
        boolean useSlimefunItemCustomModelData = p.getConfig().getBoolean("options.transmutations.use-same-custommodeldata");

        // ItemStack and custom texture service
        SlimefunItemStack item;
        CustomTextureService cts = SlimefunPlugin.getItemTextureService();

        // Add transmutations
        if (reinforcedTransmutationEnabled) {
            DivineAltar.RECIPES.put(new MultiInput(new ItemStack[] {
                    null, SlimefunItems.DAMASCUS_STEEL_INGOT, null,
                    Items.DARKSTEEL, Items.MYSTERY_METAL, Items.ILLUMIUM,
                    null, SlimefunItems.DAMASCUS_STEEL_INGOT, null
            }), new SlimefunItemStack(SlimefunItems.REINFORCED_ALLOY_INGOT, 2));

            item = new SlimefunItemStack("AV_REINFORCED_ALLOY_INGOT", Material.IRON_INGOT, "&b&l強化合金錠");

            if (useSlimefunItemCustomModelData) {
                item.setCustomModel(cts.getModelData("REINFORCED_ALLOY_INGOT"));
                cts.setTexture(item, "AV_REINFORCED_ALLOY_INGOT");
            }

            new SlimefunItem(Categories.ALTAR_RECIPES, item, RecipeTypes.DIVINE_ALTAR_TYPE, new ItemStack[] {
                    null, SlimefunItems.DAMASCUS_STEEL_INGOT, null,
                    Items.DARKSTEEL, Items.MYSTERY_METAL, Items.ILLUMIUM,
                    null, SlimefunItems.DAMASCUS_STEEL_INGOT, null
            }, new SlimefunItemStack(item, 2)).register(p);
        }

        if (hardenedTransmutationEnabled) {
            DivineAltar.RECIPES.put(new MultiInput(new ItemStack[] {
                    null, SlimefunItems.STEEL_INGOT, null,
                    Items.DARKSTEEL, Items.MYSTERY_METAL, Items.ILLUMIUM,
                    null, SlimefunItems.STEEL_INGOT, null
            }), new SlimefunItemStack(SlimefunItems.HARDENED_METAL_INGOT, 2));

            item = new SlimefunItemStack("AV_HARDENED_METAL_INGOT", Material.IRON_INGOT, "&b&l硬化金屬");

            if (useSlimefunItemCustomModelData) {
                item.setCustomModel(cts.getModelData("HARDENED_METAL_INGOT"));
                cts.setTexture(item, "AV_HARDENED_METAL_INGOT");
            }

            new SlimefunItem(Categories.ALTAR_RECIPES, item, RecipeTypes.DIVINE_ALTAR_TYPE, new ItemStack[] {
                    null, SlimefunItems.STEEL_INGOT, null,
                    Items.DARKSTEEL, Items.MYSTERY_METAL, Items.ILLUMIUM,
                    null, SlimefunItems.STEEL_INGOT, null
            }, new SlimefunItemStack(item, 2)).register(p);
        }

        if (steelTransmutationEnabled) {
            DivineAltar.RECIPES.put(new MultiInput(new ItemStack[] {
                    null, new ItemStack(Material.IRON_BLOCK), null,
                    Items.DARKSTEEL, Items.MYSTERY_METAL, Items.ILLUMIUM,
                    null, SlimefunItems.CARBON, null
            }), new SlimefunItemStack(SlimefunItems.STEEL_INGOT, 8));

            item = new SlimefunItemStack("AV_STEEL_INGOT", Material.IRON_INGOT, "&b鋼錠");

            if (useSlimefunItemCustomModelData) {
                item.setCustomModel(cts.getModelData("STEEL_INGOT"));
                cts.setTexture(item, "AV_STEEL_INGOT");
            }

            new SlimefunItem(Categories.ALTAR_RECIPES, item, RecipeTypes.DIVINE_ALTAR_TYPE, new ItemStack[] {
                    null, new ItemStack(Material.IRON_BLOCK), null,
                    Items.DARKSTEEL, Items.MYSTERY_METAL, Items.ILLUMIUM,
                    null, SlimefunItems.CARBON, null
            }, new SlimefunItemStack(item, 8)).register(p);
        }

        if (damascusTransmutationEnabled) {
            DivineAltar.RECIPES.put(new MultiInput(new ItemStack[] {
                    null, new ItemStack(Material.IRON_BLOCK), null,
                    Items.DARKSTEEL, Items.MYSTERY_METAL, Items.ILLUMIUM,
                    null, SlimefunItems.COMPRESSED_CARBON, null
            }), new SlimefunItemStack(SlimefunItems.DAMASCUS_STEEL_INGOT, 8));

            item = new SlimefunItemStack("AV_DAMASCUS_STEEL_INGOT", Material.IRON_INGOT, "&b大馬士革鋼錠");

            if (useSlimefunItemCustomModelData) {
                item.setCustomModel(cts.getModelData("DAMASCUS_STEEL_INGOT"));
                cts.setTexture(item, "AV_DAMASCUS_STEEL_INGOT");
            }

            new SlimefunItem(Categories.ALTAR_RECIPES, item, RecipeTypes.DIVINE_ALTAR_TYPE, new ItemStack[] {
                    null, new ItemStack(Material.IRON_BLOCK), null,
                    Items.DARKSTEEL, Items.MYSTERY_METAL, Items.ILLUMIUM,
                    null, SlimefunItems.COMPRESSED_CARBON, null
            }, new SlimefunItemStack(item, 8)).register(p);
        }

        if (compressedCarbonTransmutationEnabled) {
            DivineAltar.RECIPES.put(new MultiInput(new ItemStack[] {
                    new ItemStack(Material.COAL), new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.COAL),
                    new ItemStack(Material.OAK_LEAVES), new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.KELP),
                    new ItemStack(Material.COAL), new ItemStack(Material.ROTTEN_FLESH), new ItemStack(Material.COAL)
            }), SlimefunItems.COMPRESSED_CARBON);

            item = new SlimefunItemStack("AV_COMPRESSED_CARBON", HeadTexture.COMPRESSED_CARBON, "&c壓縮碳");

            if (useSlimefunItemCustomModelData) {
                item.setCustomModel(cts.getModelData("COMPRESSED_CARBON"));
                cts.setTexture(item, "AV_COMPRESSED_CARBON");
            }

            new SlimefunItem(Categories.ALTAR_RECIPES, item, RecipeTypes.DIVINE_ALTAR_TYPE, new ItemStack[] {
                    new ItemStack(Material.COAL), new ItemStack(Material.COOKED_BEEF), new ItemStack(Material.COAL),
                    new ItemStack(Material.OAK_LEAVES), new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.KELP),
                    new ItemStack(Material.COAL), new ItemStack(Material.ROTTEN_FLESH), new ItemStack(Material.COAL)
            }, item).register(p);
        }

        // Add normal recipes to recipe map
        DivineAltar.RECIPES.put(new MultiInput(new ItemStack[] {
                Items.EXP_CRYSTAL, Items.ILLUMIUM, Items.EXP_CRYSTAL,
                Items.DARKSTEEL, new ItemStack(Material.LAVA_BUCKET), Items.DARKSTEEL,
                Items.EXP_CRYSTAL, Items.ILLUMIUM, Items.EXP_CRYSTAL
        }), Items.MOLTEN_MYSTERY_METAL);

        DivineAltar.RECIPES.put(new MultiInput(new ItemStack[] {
                Items.EXP_CRYSTAL, SlimefunItems.AUTO_BREWER, Items.EXP_CRYSTAL,
                Items.DARKSTEEL, Items.DIVINE_ALTAR, Items.ILLUMIUM,
                SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.FLUID_PUMP, SlimefunItems.BLISTERING_INGOT_3
        }), Items.ORNATE_CAULDRON);

        DivineAltar.RECIPES.put(new MultiInput(new ItemStack[]{
                Items.EXP_CRYSTAL, SlimefunItems.WITHER_PROOF_GLASS, Items.EXP_CRYSTAL,
                SlimefunItems.REINFORCED_PLATE, new ItemStack(Material.BEACON), SlimefunItems.REINFORCED_PLATE,
                SlimefunItems.BLISTERING_INGOT_3, Items.DIVINE_ALTAR, SlimefunItems.BLISTERING_INGOT_3
        }), Items.ALTAR_OF_INFUSION);
    }

    private static void setupOrnateCauldron() {
        // Add recipes to recipe map
        OrnateCauldron.RECIPES.put(new MultiInput(new ItemStack[] {
                Items.EXP_CRYSTAL, new ItemStack(Material.NETHERITE_BLOCK), Items.EXP_CRYSTAL,
                Items.EVIL_ESSENCE, new ItemStack(Material.DRAGON_BREATH), Items.GOOD_ESSENCE,
                Items.DARKSTEEL, new ItemStack(Material.LAVA_BUCKET), Items.ILLUMIUM
        }), Items.POTION_OF_OSMOSIS);

        OrnateCauldron.RECIPES.put(new MultiInput(new ItemStack[] {
                Items.EXP_CRYSTAL, new ItemStack(Material.LILAC), new ItemStack(Material.CORNFLOWER),
                Items.GOOD_ESSENCE, new ItemStack(Material.HONEY_BOTTLE), new ItemStack(Material.TOTEM_OF_UNDYING),
                Items.ILLUMIUM, new ItemStack(Material.LILY_OF_THE_VALLEY), new ItemStack(Material.POPPY)
        }), Items.BENEVOLENT_BREW);
    }

    private static void setupInfusionAltar(AlchimiaVitae p) {
        // Get config values
        boolean destructiveCritsEnabled = p.getConfig().getBoolean("options.infusions.infusion-destructivecrits");
        boolean phantomCritsEnabled = p.getConfig().getBoolean("options.infusions.infusion-phantomcrits");
        boolean trueAimEnabled = p.getConfig().getBoolean("options.infusions.infusion-trueaim");
        boolean forcefulEnabled = p.getConfig().getBoolean("options.infusions.infusion-forceful");
        boolean volatileEnabled = p.getConfig().getBoolean("options.infusions.infusion-volatile");
        boolean healingEnabled = p.getConfig().getBoolean("options.infusions.infusion-healing");
        boolean autoReplantEnabled = p.getConfig().getBoolean("options.infusions.infusion-autoreplant");
        boolean totemStorageEnabled = p.getConfig().getBoolean("options.infusions.infusion-totemstorage");

        // ItemStacks
        CustomItem validInfuseAxe = new CustomItem(Material.DIAMOND_AXE, "&b&l一個有效的斧頭來注入", "&6金&a, &f鐵&a, &b鑽石&a,", "&a或&c獄髓&a斧頭");
        CustomItem validInfuseChestplate = new CustomItem(Material.DIAMOND_CHESTPLATE, "&b&l一個有效的胸甲來注入", "&6金&a, &f鐵&a, &b鑽石&a,", "&a或&c獄髓&a胸甲");
        CustomItem validInfuseBow = new CustomItem(Material.BOW, "&b&l一個有效的弓來注入", "&a弓或弩");
        CustomItem validInfuseHoe = new CustomItem(Material.DIAMOND_HOE, "&b&l一個有效的鋤頭來注入", "&6金&a, &f鐵&a, &b鑽石&a,", "&a或&c獄髓&a鋤頭");
        SlimefunItemStack item;

        // Register Infusions
        if (destructiveCritsEnabled) {
            AltarOfInfusion.RECIPES.put(new MultiInput(new ItemStack[] {
                    new ItemStack(Material.TNT), SlimefunItems.EXPLOSIVE_PICKAXE, new ItemStack(Material.STONECUTTER),
                    Items.DARKSTEEL, SlimefunItems.WITHER_PROOF_OBSIDIAN,
                    new ItemStack(Material.REDSTONE_BLOCK), SlimefunItems.WITHER_PROOF_OBSIDIAN, new ItemStack(Material.TNT)
            }), axeInfusionDestructiveCrits);

            item = new SlimefunItemStack("AV_DESTRUCTIVE_CRITS_INFUSION", Material.TNT, "&c&l破壞性爆擊",
                    "&4爆擊時有 1/20 機率使對手挖掘疲勞 III 持續8秒",
                    "&4爆擊時有 1/5 機率使對手緩速 I 持續15秒",
                    "&4爆擊時有 1/5 機率使對手虛弱 I 持續15秒",
                    "&4爆擊時對對手的護甲造成0-5的額外傷害");

            new SlimefunItem(Categories.INFUSIONS, item, RecipeTypes.INFUSION_ALTAR_TYPE, new ItemStack[] {
                    new ItemStack(Material.TNT), SlimefunItems.EXPLOSIVE_PICKAXE, new ItemStack(Material.STONECUTTER),
                    Items.DARKSTEEL, validInfuseAxe, SlimefunItems.WITHER_PROOF_OBSIDIAN,
                    new ItemStack(Material.REDSTONE_BLOCK), SlimefunItems.WITHER_PROOF_OBSIDIAN, new ItemStack(Material.TNT)
            }, item).register(p);
        }

        if (phantomCritsEnabled) {
            AltarOfInfusion.RECIPES.put(new MultiInput(new ItemStack[] {
                    new ItemStack(Material.PHANTOM_MEMBRANE), SlimefunItems.MAGICAL_GLASS, new ItemStack(Material.PHANTOM_MEMBRANE),
                    Items.DARKSTEEL, SlimefunItems.HARDENED_GLASS,
                    new ItemStack(Material.PHANTOM_MEMBRANE), Items.CONDENSED_SOUL, new ItemStack(Material.PHANTOM_MEMBRANE)
            }), axeInfusionPhantomCrits);

            item = new SlimefunItemStack("AV_PHANTOM_CRITS_INFUSION", Material.PHANTOM_MEMBRANE, "&b幻影性爆擊",
                    "&a1/4 機率造成 (你的攻擊傷害為 1.15",
                    "&a乘以 5/8) 爆擊時額外的傷害並繞過護甲防禦");

            new SlimefunItem(Categories.INFUSIONS, item, RecipeTypes.INFUSION_ALTAR_TYPE, new ItemStack[] {
                    new ItemStack(Material.PHANTOM_MEMBRANE), SlimefunItems.MAGICAL_GLASS, new ItemStack(Material.PHANTOM_MEMBRANE),
                    Items.DARKSTEEL, validInfuseAxe, SlimefunItems.HARDENED_GLASS,
                    new ItemStack(Material.PHANTOM_MEMBRANE), Items.CONDENSED_SOUL, new ItemStack(Material.PHANTOM_MEMBRANE)
            }, item).register(p);
        }

        if (trueAimEnabled) {
            AltarOfInfusion.RECIPES.put(new MultiInput(new ItemStack[] {
                    SlimefunItems.SYNTHETIC_SHULKER_SHELL, SlimefunItems.INFUSED_MAGNET, SlimefunItems.STAFF_WIND,
                    Items.DARKSTEEL, Items.EXP_CRYSTAL,
                    new ItemStack(Material.SHULKER_BOX), SlimefunItems.INFUSED_ELYTRA, SlimefunItems.STEEL_THRUSTER
            }), bowInfusionTrueAim);

            item = new SlimefunItemStack("AV_TRUE_AIM_INFUSION", Material.SHULKER_SHELL, "&d真正的自動瞄準",
                    "&5部分使用懸浮符咒", "&5用界伏蚌來處決它們的受害者,",
                    "&5注入這種魔法可使弓發射時", "&5箭矢不受重力影響");

            new SlimefunItem(Categories.INFUSIONS, item, RecipeTypes.INFUSION_ALTAR_TYPE, new ItemStack[] {
                    SlimefunItems.SYNTHETIC_SHULKER_SHELL, SlimefunItems.INFUSED_MAGNET, SlimefunItems.STAFF_WIND,
                    Items.DARKSTEEL, validInfuseBow, Items.EXP_CRYSTAL,
                    new ItemStack(Material.SHULKER_BOX), SlimefunItems.INFUSED_ELYTRA, SlimefunItems.STEEL_THRUSTER
            }, item).register(p);
        }

        if (forcefulEnabled) {
            AltarOfInfusion.RECIPES.put(new MultiInput(new ItemStack[] {
                    SlimefunItems.ELECTRO_MAGNET, new ItemStack(Material.PISTON), SlimefunItems.STAFF_WIND,
                    SlimefunItems.INFUSED_MAGNET, SlimefunItems.STEEL_THRUSTER,
                    SlimefunItems.ELECTRO_MAGNET, new ItemStack(Material.PISTON), SlimefunItems.TALISMAN_TRAVELLER
            }), bowInfusionForceful);

            item = new SlimefunItemStack("AV_FORCEFUL_INFUSION", Material.PISTON, "&2強力性",
                    "&a這種注入使用機械", "&a裝置與電磁來加速",
                    "&a彈射物以極快的速度", "&a箭矢將會以兩倍遠與更快");

            new SlimefunItem(Categories.INFUSIONS, item, RecipeTypes.INFUSION_ALTAR_TYPE, new ItemStack[] {
                    SlimefunItems.ELECTRO_MAGNET, new ItemStack(Material.PISTON), SlimefunItems.STAFF_WIND,
                    SlimefunItems.INFUSED_MAGNET, validInfuseBow, SlimefunItems.STEEL_THRUSTER,
                    SlimefunItems.ELECTRO_MAGNET, new ItemStack(Material.PISTON), SlimefunItems.TALISMAN_TRAVELLER
            }, item).register(p);
        }

        if (volatileEnabled) {
            AltarOfInfusion.RECIPES.put(new MultiInput(new ItemStack[] {
                    new ItemStack(Material.BLAZE_ROD), SlimefunItems.STAFF_FIRE, SlimefunItems.TALISMAN_FIRE,
                    Items.DARKSTEEL, SlimefunItems.LAVA_GENERATOR_2,
                    new ItemStack(Material.TNT), SlimefunItems.SYNTHETIC_DIAMOND, SlimefunItems.LAVA_CRYSTAL
            }), bowInfusionVolatile);

            item = new SlimefunItemStack("AV_VOLATILE_INFUSION", Material.FIRE_CHARGE, "&4&l揮發性",
                    "&c這種極其危險的注入物會造成", "&c純粹過熱的熔岩所製成的球體,",
                    "&c向目標傳送至迷你地獄", "&41/7 機率發射一顆火球",
                    "&46/7 機率發射小火球");

            new SlimefunItem(Categories.INFUSIONS, item, RecipeTypes.INFUSION_ALTAR_TYPE, new ItemStack[] {
                    new ItemStack(Material.BLAZE_ROD), SlimefunItems.STAFF_FIRE, SlimefunItems.TALISMAN_FIRE,
                    Items.DARKSTEEL, validInfuseBow, SlimefunItems.LAVA_GENERATOR_2,
                    new ItemStack(Material.TNT), SlimefunItems.SYNTHETIC_DIAMOND, SlimefunItems.LAVA_CRYSTAL
            }, item).register(p);
        }

        if (healingEnabled) {
            AltarOfInfusion.RECIPES.put(new MultiInput(new ItemStack[] {
                    Items.BENEVOLENT_BREW, SlimefunItems.MEDICINE, SlimefunItems.VITAMINS,
                    Items.ILLUMIUM, new ItemStack(Material.TOTEM_OF_UNDYING),
                    new ItemStack(Material.ENCHANTED_GOLDEN_APPLE), SlimefunItems.MEDICINE, SlimefunItems.MAGIC_SUGAR
            }), bowInfusionHealing);

            item = new SlimefunItemStack("AV_HEALING_INFUSION", Material.REDSTONE, "&c治療性",
                    "&c這種注入物將治療被擊中的實體", " &c並恢復它們的&4健康", "" +
                    "&a治療量與弓箭傷害相同");

            new SlimefunItem(Categories.INFUSIONS, item, RecipeTypes.INFUSION_ALTAR_TYPE, new ItemStack[] {
                    Items.BENEVOLENT_BREW, SlimefunItems.MEDICINE, SlimefunItems.VITAMINS,
                    Items.ILLUMIUM, validInfuseBow, new ItemStack(Material.TOTEM_OF_UNDYING),
                    new ItemStack(Material.ENCHANTED_GOLDEN_APPLE), SlimefunItems.MEDICINE, SlimefunItems.MAGIC_SUGAR
            }, item).register(p);
        }

        if (autoReplantEnabled) {
            AltarOfInfusion.RECIPES.put(new MultiInput(new ItemStack[] {
                    new ItemStack(Material.COMPOSTER), Items.GOOD_ESSENCE, new ItemStack(Material.WATER_BUCKET),
                    Items.ILLUMIUM, SlimefunItems.FLUID_PUMP,
                    new ItemStack(Material.BONE_BLOCK), Items.GOOD_MAGIC_PLANT, new ItemStack(Material.GRINDSTONE)
            }), hoeInfusionAutoReplant);

            item = new SlimefunItemStack("AV_AUTO_REPLANT_INFUSION", Material.WHEAT, "&a自動化重種",
                    "&2任何完全生長的農作物",
                    "&2使用此注入過的鋤頭破壞", "&2會&a自動&2重新種植");

            new SlimefunItem(Categories.INFUSIONS, item, RecipeTypes.INFUSION_ALTAR_TYPE, new ItemStack[] {
                    new ItemStack(Material.COMPOSTER), Items.GOOD_ESSENCE, new ItemStack(Material.WATER_BUCKET),
                    Items.ILLUMIUM, validInfuseHoe, SlimefunItems.FLUID_PUMP,
                    new ItemStack(Material.BONE_BLOCK), Items.GOOD_MAGIC_PLANT, new ItemStack(Material.GRINDSTONE)
            }, item).register(p);
        }

        if (totemStorageEnabled) {
            AltarOfInfusion.RECIPES.put(new MultiInput(new ItemStack[] {
                    SlimefunItems.NECROTIC_SKULL, Items.CONDENSED_SOUL, Items.BENEVOLENT_BREW,
                    Items.ILLUMIUM, Items.EXP_CRYSTAL,
                    new ItemStack(Material.TOTEM_OF_UNDYING), SlimefunItems.ENERGIZED_CAPACITOR, SlimefunItems.ESSENCE_OF_AFTERLIFE
            }), chestplateInfusionTotemBattery);

            item = new SlimefunItemStack("AV_TOTEM_BATTERY_INFUSION", Material.TOTEM_OF_UNDYING, "&6&l圖騰電池",
                    "&e一個內置的維度, 可容納", "&e8個不死圖騰的能量",
                    "&6在這個裝置中儲存圖騰", "&6Shift-右鍵點擊 &6與手裡拿著圖騰",
                    "&6當配戴有注入此注入物的胸甲時");

            new SlimefunItem(Categories.INFUSIONS, item, RecipeTypes.INFUSION_ALTAR_TYPE, new ItemStack[] {
                    SlimefunItems.NECROTIC_SKULL, Items.CONDENSED_SOUL, Items.BENEVOLENT_BREW,
                    Items.ILLUMIUM, validInfuseChestplate, Items.EXP_CRYSTAL,
                    SlimefunItems.ESSENCE_OF_AFTERLIFE, SlimefunItems.ENERGIZED_CAPACITOR, SlimefunItems.ESSENCE_OF_AFTERLIFE
            }, item).register(p);
        }
    }
}
