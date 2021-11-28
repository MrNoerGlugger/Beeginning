package mrnoerglugger.beeginning.items.combs;

import mrnoerglugger.beeginning.Beeginning;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static mrnoerglugger.beeginning.Beeginning.MODID;

public class OreCombs {
    public static final Item CARBO_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item GLOWING_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item CUPRUM_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item FERRUM_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item SILICA_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item ENGINEERED_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item AURUM_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item LAZURITE_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item CRYSTAL_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item SHINING_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item SMARAGDUS_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item PRIMORDIAL_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));

    public static void registerOreCombs() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "carbo_comb"), CARBO_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "glowing_comb"), GLOWING_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "cuprum_comb"), CUPRUM_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "ferrum_comb"), FERRUM_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "silica_comb"), SILICA_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "engineered_comb"), ENGINEERED_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "aurum_comb"), AURUM_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "lazurite_comb"), LAZURITE_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "crystal_comb"), CRYSTAL_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "shining_comb"), SHINING_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "smaragdus_comb"), SMARAGDUS_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "primordial_comb"), PRIMORDIAL_COMB);
    }
}
