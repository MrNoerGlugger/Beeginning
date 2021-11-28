package mrnoerglugger.beeginning;

import mrnoerglugger.beeginning.beekeeping.BeeDefaultValues;
import mrnoerglugger.beeginning.beekeeping.BeeFunctions;
import mrnoerglugger.beeginning.blocks.ApiaryBlock;
import mrnoerglugger.beeginning.blocks.CentrifugeBlock;
import mrnoerglugger.beeginning.blocks.blockentities.ApiaryBlockEntityType;
import mrnoerglugger.beeginning.blocks.blockentities.CentrifugeBlockEntityType;
import mrnoerglugger.beeginning.items.bees.CavingBee;
import mrnoerglugger.beeginning.screens.ApiaryScreenHandler;
import mrnoerglugger.beeginning.screens.BeePackScreenHandler;
import mrnoerglugger.beeginning.screens.BeePhoneScreenHandler;
import mrnoerglugger.beeginning.screens.CentrifugeScreenHandler;
import mrnoerglugger.beeginning.setup.ModBlocks;
import mrnoerglugger.beeginning.setup.ModItems;
import mrnoerglugger.beeginning.setup.ServerNetwork;
import mrnoerglugger.beeginning.world.EndHiveFeature;
import mrnoerglugger.beeginning.world.HiveFeature;
import mrnoerglugger.beeginning.world.NetherHiveFeature;
import mrnoerglugger.beeginning.world.TreeHiveFeature;
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
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;

import java.util.List;

import static mrnoerglugger.beeginning.items.bees.FerrumBee.FERRUM_PRINCESS;
import static net.minecraft.stat.Stats.CUSTOM;

public class Beeginning implements ModInitializer {
    public static BlockEntityType<ApiaryBlockEntityType> APIARY_BLOCK_ENTITY;
    public static BlockEntityType<CentrifugeBlockEntityType> CENTRIFUGE_BLOCK_ENTITY;
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
    public static final ConfiguredFeature<?, ?> HIVING = HIVE.configure(FeatureConfig.DEFAULT);
    public static final ConfiguredFeature<?, ?> END_HIVING = END_HIVE.configure(FeatureConfig.DEFAULT);
    public static final ConfiguredFeature<?, ?> TREE_HIVING = TREE_HIVE.configure(FeatureConfig.DEFAULT);
    public static final ConfiguredFeature<?, ?> NETHER_HIVING = NETHER_HIVE.configure(FeatureConfig.DEFAULT);
    public static final ConfiguredFeature<?, ?> HIVE_ORE = Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, CavingBee.CAVING_HIVE.getDefaultState(), 3));

    private static Identifier register(String id, StatFormatter formatter) {
        Identifier identifier = new Identifier(id);
        Registry.register(Registry.CUSTOM_STAT, (String)id, identifier);
        CUSTOM.getOrCreateStat(identifier, formatter);
        return identifier;
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModfier) {
        return modifiers(CountPlacementModifier.of(count), heightModfier);
    }

    static {
        APIARY_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(APIARY, ApiaryScreenHandler::new);
        CENTRIFUGE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(CENTRIFUGE, CentrifugeScreenHandler::new);
        BEEPHONE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(BEEPHONE, BeePhoneScreenHandler::new);
        BEEPACK_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(BEEPACK, BeePackScreenHandler::new);
        APIARY_INTERACTIONS = register("interact_with_apiary", StatFormatter.DEFAULT);
        HIVING_FEATURE = PlacedFeatures.register("hive", HIVING.withPlacement(SquarePlacementModifier.of(), RarityFilterPlacementModifier.of(5), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP));
        END_HIVING_FEATURE = PlacedFeatures.register("end_hive", END_HIVING.withPlacement(SquarePlacementModifier.of(), RarityFilterPlacementModifier.of(75), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP));
        TREE_HIVING_FEATURE = PlacedFeatures.register("tree_hive", TREE_HIVING.withPlacement(SquarePlacementModifier.of(), CountPlacementModifier.of(2), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP));
        NETHER_HIVING_FEATURE = PlacedFeatures.register("nether_hive", NETHER_HIVING.withPlacement(SquarePlacementModifier.of(), CountPlacementModifier.of(20), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP));
        HIVE_ORE_FEATURE = PlacedFeatures.register("hive_ore", HIVE_ORE.withPlacement(modifiersWithCount(20, HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(10)))));
    }

    @Override
    public void onInitialize() {
        ModBlocks.RegisterBlocks();
        ModItems.registerItems();
        APIARY_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "beeginning:apiary_block_entity", FabricBlockEntityTypeBuilder.create(ApiaryBlockEntityType::new, ApiaryBlock.APIARY).build(null));
        CENTRIFUGE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "beeginning:centrifuge_block_entity", FabricBlockEntityTypeBuilder.create(CentrifugeBlockEntityType::new, CentrifugeBlock.CENTRIFUGE).build(null));
        Registry.register(Registry.FEATURE, new Identifier("beeginning", "hive"), HIVE);
        Registry.register(Registry.FEATURE, new Identifier("beeginning", "tree_hive"), TREE_HIVE);
        Registry.register(Registry.FEATURE, new Identifier("beeginning", "end_hive"), END_HIVE);
        Registry.register(Registry.FEATURE, new Identifier("beeginning", "nether_hive"), NETHER_HIVE);
        RegistryKey<ConfiguredFeature<?, ?>> hive = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("beeginning", "hive"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, hive.getValue(), HIVING);
        RegistryKey<ConfiguredFeature<?, ?>> end_hive = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("beeginning", "end_hive"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, end_hive.getValue(), END_HIVING);
        RegistryKey<ConfiguredFeature<?, ?>> tree_hive = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("beeginning", "tree_hive"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, tree_hive.getValue(), TREE_HIVING);
        RegistryKey<ConfiguredFeature<?, ?>> nether_hive = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("beeginning", "nether_hive"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, nether_hive.getValue(), NETHER_HIVING);
        RegistryKey<ConfiguredFeature<?, ?>> hive_ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("beeginning", "hive_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, hive_ore.getValue(), HIVE_ORE);
        BeeDefaultValues.registerBeeValues(BeeDefaultValues.createBaseBeeList());
        BeeDefaultValues.createBeeArrays();
        BeeDefaultValues.createEffectArrays();
        BeeFunctions.registerBeeValues();
        ServerNetwork.init();
    }
}