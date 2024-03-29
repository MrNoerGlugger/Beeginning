package mrnoerglugger.beeginning;

import mrnoerglugger.beeginning.beekeeping.BeeDefaultValues;
import mrnoerglugger.beeginning.beekeeping.BeeFunctions;
import mrnoerglugger.beeginning.blocks.*;
import mrnoerglugger.beeginning.blocks.blockentities.ApiaryBlockEntityType;
import mrnoerglugger.beeginning.blocks.blockentities.BeeChestBlockEntityType;
import mrnoerglugger.beeginning.blocks.blockentities.CentrifugeBlockEntityType;
import mrnoerglugger.beeginning.blocks.blockentities.HiveBlockEntityType;
import mrnoerglugger.beeginning.items.bees.*;
import mrnoerglugger.beeginning.screens.ApiaryScreenHandler;
import mrnoerglugger.beeginning.screens.BeePackScreenHandler;
import mrnoerglugger.beeginning.screens.BeePhoneScreenHandler;
import mrnoerglugger.beeginning.screens.CentrifugeScreenHandler;
import mrnoerglugger.beeginning.setup.ModBlocks;
import mrnoerglugger.beeginning.setup.ModItems;
import mrnoerglugger.beeginning.world.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.stat.StatFormatter;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;

import java.io.FileReader;
import java.util.List;

import static mrnoerglugger.beeginning.items.bees.FerrumBee.FERRUM_PRINCESS;
import static net.minecraft.stat.Stats.CUSTOM;

public class Beeginning implements ModInitializer {
    public static BlockEntityType<ApiaryBlockEntityType> APIARY_BLOCK_ENTITY;
    public static BlockEntityType<CentrifugeBlockEntityType> CENTRIFUGE_BLOCK_ENTITY;
    public static BlockEntityType<HiveBlockEntityType> HIVE_BLOCK_ENTITY;
    public static BlockEntityType<BeeChestBlockEntityType> BEE_CHEST_BLOCK_ENTITY;
    public static ScreenHandlerType<ApiaryScreenHandler> APIARY_SCREEN_HANDLER;
    public static ScreenHandlerType<CentrifugeScreenHandler> CENTRIFUGE_SCREEN_HANDLER;
    public static ScreenHandlerType<BeePhoneScreenHandler> BEEPHONE_SCREEN_HANDLER;
    public static ScreenHandlerType<BeePackScreenHandler> BEEPACK_SCREEN_HANDLER;
    public static String MODID = "beeginning";
    public static Identifier APIARY_INTERACTIONS;
    public static PlacedFeature HIVING_FEATURE;
    public static PlacedFeature END_HIVING_FEATURE;
    public static PlacedFeature TREE_HIVING_FEATURE;
    public static PlacedFeature NETHER_HIVING_FEATURE;
    public static PlacedFeature HIVE_ORE_FEATURE;

    public static final Identifier APIARY = new Identifier(MODID, "apiary");
    public static final Identifier CENTRIFUGE = new Identifier(MODID, "centrifuge");
    public static final Identifier BEEPHONE = new Identifier(MODID, "beephone");
    public static final Identifier BEEPACK = new Identifier(MODID, "beepack");
    public static final ItemGroup BEE_GROUP = FabricItemGroupBuilder.create(new Identifier(MODID, "bees")).icon(() -> new ItemStack(FERRUM_PRINCESS)).build();
    public static final ItemGroup COMB_GROUP = FabricItemGroupBuilder.create(new Identifier(MODID, "comb")).icon(() -> new ItemStack(ApiaryBlock.APIARY)).build();
    public static final ItemGroup GENERIC_GROUP = FabricItemGroupBuilder.create(new Identifier(MODID, "general")).icon(() -> new ItemStack(ApiaryBlock.APIARY)).build();

    private static final Feature<DefaultFeatureConfig> HIVE = new HiveFeature(DefaultFeatureConfig.CODEC);
    private static final Feature<DefaultFeatureConfig> TREE_HIVE = new TreeHiveFeature(DefaultFeatureConfig.CODEC);
    private static final Feature<DefaultFeatureConfig> END_HIVE = new EndHiveFeature(DefaultFeatureConfig.CODEC);
    private static final Feature<DefaultFeatureConfig> NETHER_HIVE = new NetherHiveFeature(DefaultFeatureConfig.CODEC);
    private static final Feature<DefaultFeatureConfig> ORE_HIVE = new OreHiveFeature(DefaultFeatureConfig.CODEC);
    public static final ConfiguredFeature<?, ?> HIVING = HIVE.configure(FeatureConfig.DEFAULT);
    public static final ConfiguredFeature<?, ?> END_HIVING = END_HIVE.configure(FeatureConfig.DEFAULT);
    public static final ConfiguredFeature<?, ?> TREE_HIVING = TREE_HIVE.configure(FeatureConfig.DEFAULT);
    public static final ConfiguredFeature<?, ?> NETHER_HIVING = NETHER_HIVE.configure(FeatureConfig.DEFAULT);
    public static final ConfiguredFeature<?, ?> ORE_HIVING = ORE_HIVE.configure(FeatureConfig.DEFAULT);

    private static Identifier register(String id, StatFormatter formatter) {
        Identifier identifier = new Identifier(id);
        Registry.register(Registry.CUSTOM_STAT, (String)id, identifier);
        CUSTOM.getOrCreateStat(identifier, formatter);
        return identifier;
    }

    static {
        APIARY_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(APIARY, ApiaryScreenHandler::new);
        CENTRIFUGE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(CENTRIFUGE, CentrifugeScreenHandler::new);
        BEEPHONE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(BEEPHONE, BeePhoneScreenHandler::new);
        BEEPACK_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(BEEPACK, BeePackScreenHandler::new);
        APIARY_INTERACTIONS = register("interact_with_apiary", StatFormatter.DEFAULT);
        HIVING_FEATURE = PlacedFeatures.register("hive", HIVING.withPlacement(SquarePlacementModifier.of(), RarityFilterPlacementModifier.of(5), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP));
        END_HIVING_FEATURE = PlacedFeatures.register("end_hive", END_HIVING.withPlacement(SquarePlacementModifier.of(), RarityFilterPlacementModifier.of(75), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP));
        TREE_HIVING_FEATURE = PlacedFeatures.register("tree_hive", TREE_HIVING.withPlacement(SquarePlacementModifier.of(), CountPlacementModifier.of(2), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP));
        NETHER_HIVING_FEATURE = PlacedFeatures.register("nether_hive", NETHER_HIVING.withPlacement(SquarePlacementModifier.of(), CountPlacementModifier.of(20), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP));
        HIVE_ORE_FEATURE = PlacedFeatures.register("hive_ore", ORE_HIVING.withPlacement(SquarePlacementModifier.of(), CountPlacementModifier.of(10), PlacedFeatures.BOTTOM_TO_TOP_RANGE));
    }

    @Override
    public void onInitialize() {
        ModBlocks.RegisterBlocks();
        ModItems.registerItems();
        APIARY_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "beeginning:apiary_block_entity", FabricBlockEntityTypeBuilder.create(ApiaryBlockEntityType::new, ApiaryBlock.APIARY).build(null));
        CENTRIFUGE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "beeginning:centrifuge_block_entity", FabricBlockEntityTypeBuilder.create(CentrifugeBlockEntityType::new, CentrifugeBlock.CENTRIFUGE).build(null));
        HIVE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "beeginning:hive_block_entity", FabricBlockEntityTypeBuilder.create(HiveBlockEntityType::new, PlainBee.PLAIN_HIVE, WoodlandBee.WOODLAND_HIVE, BetulaBee.BETULA_HIVE, TwilightBee.TWILIGHT_HIVE, ThicketBee.THICKET_HIVE, SnowingBee.SNOWING_HIVE, BaobabBee.BAOBAB_HIVE, WarpedBee.WARPED_HIVE, CrimsonBee.CRIMSON_HIVE, ShroomyBee.SHROOMY_HIVE, DryBee.DRY_HIVE, MesaBee.MESA_HIVE, MorassBee.MORASS_HIVE, BloomingBee.BLOOMING_HIVE, SeaBee.SEA_HIVE, FreezingBee.FREEZING_HIVE, MountainousBee.MOUNTAINOUS_HIVE, CavingBee.CAVING_HIVE, WastingBee.WASTING_HIVE, ValleyBee.VALLEY_HIVE, DeltaBee.DELTA_HIVE, FinalisBee.FINALIS_HIVE, VoidBee.VOID_HIVE).build(null));
        BEE_CHEST_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "beeginning:bee_chest_block_entity", FabricBlockEntityTypeBuilder.create(BeeChestBlockEntityType::new, BeeChestBlock.BEE_CHEST).build(null));
        Registry.register(Registry.FEATURE, new Identifier("beeginning", "hive"), HIVE);
        Registry.register(Registry.FEATURE, new Identifier("beeginning", "tree_hive"), TREE_HIVE);
        Registry.register(Registry.FEATURE, new Identifier("beeginning", "end_hive"), END_HIVE);
        Registry.register(Registry.FEATURE, new Identifier("beeginning", "nether_hive"), NETHER_HIVE);
        Registry.register(Registry.FEATURE, new Identifier("beeginning", "hive_ore"), ORE_HIVE);
        RegistryKey<ConfiguredFeature<?, ?>> hive = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("beeginning", "hive"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, hive.getValue(), HIVING);
        RegistryKey<ConfiguredFeature<?, ?>> end_hive = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("beeginning", "end_hive"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, end_hive.getValue(), END_HIVING);
        RegistryKey<ConfiguredFeature<?, ?>> tree_hive = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("beeginning", "tree_hive"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, tree_hive.getValue(), TREE_HIVING);
        RegistryKey<ConfiguredFeature<?, ?>> nether_hive = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("beeginning", "nether_hive"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, nether_hive.getValue(), NETHER_HIVING);
        RegistryKey<ConfiguredFeature<?, ?>> hive_ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("beeginning", "hive_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, hive_ore.getValue(), ORE_HIVING);
        BeeDefaultValues.createEffectArrays();
        BeeDefaultValues.registerBeeValues(BeeDefaultValues.createBaseBeeList());
        BeeDefaultValues.createBeeArrays();
        BeeFunctions.registerBeeValues();
    }
}