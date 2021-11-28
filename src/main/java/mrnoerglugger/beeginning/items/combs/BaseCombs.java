package mrnoerglugger.beeginning.items.combs;

import mrnoerglugger.beeginning.Beeginning;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static mrnoerglugger.beeginning.Beeginning.MODID;

public class BaseCombs {
    public static final Item PLAIN_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item WOODLAND_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item BETULA_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item TWILIGHT_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item THICKET_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item SNOWING_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item BAOBAB_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item WARPED_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item CRIMSON_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item SHROOMY_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item DRY_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item MESA_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item MORASS_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item BLOOMING_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item SEA_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item FREEZING_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item MOUNTAINOUS_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item CAVING_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item WASTING_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item VALLEY_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item DELTA_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item FINALIS_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item VOID_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));

    public static void registerBaseCombs() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "plain_comb"), PLAIN_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "woodland_comb"), WOODLAND_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "betula_comb"), BETULA_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "twilight_comb"), TWILIGHT_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "thicket_comb"), THICKET_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "snowing_comb"), SNOWING_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "baobab_comb"), BAOBAB_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "warped_comb"), WARPED_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "crimson_comb"), CRIMSON_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "shroomy_comb"), SHROOMY_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "dry_comb"), DRY_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "mesa_comb"), MESA_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "morass_comb"), MORASS_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "blooming_comb"), BLOOMING_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "sea_comb"), SEA_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "freezing_comb"), FREEZING_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "mountainous_comb"), MOUNTAINOUS_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "caving_comb"), CAVING_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "wasting_comb"), WASTING_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "valley_comb"), VALLEY_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "delta_comb"), DELTA_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "finalis_comb"), FINALIS_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "void_comb"), VOID_COMB);
    }
}
