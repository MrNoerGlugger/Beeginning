package mrnoerglugger.beeginning.items.combs;

import mrnoerglugger.beeginning.Beeginning;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static mrnoerglugger.beeginning.Beeginning.MODID;

public class DyeCombs {
    public static final Item PALE_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item BURNING_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item FUCHSIA_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item SKY_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item SUNNY_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item PICKLE_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item UNICORN_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item RAIN_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item CLOUD_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item CYANIDE_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item LAVENDER_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item MARE_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item COCOA_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item CACTUS_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item BLOODY_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item NIGHT_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item RAINBOW_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));

    public static void registerDyeCombs() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "pale_comb"), PALE_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "burning_comb"), BURNING_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "fuchsia_comb"), FUCHSIA_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "sky_comb"), SKY_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "sunny_comb"), SUNNY_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "pickle_comb"), PICKLE_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "unicorn_comb"), UNICORN_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "rain_comb"), RAIN_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "cloud_comb"), CLOUD_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "cyanide_comb"), CYANIDE_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "lavender_comb"), LAVENDER_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "mare_comb"), MARE_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "cocoa_comb"), COCOA_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "cactus_comb"), CACTUS_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "bloody_comb"), BLOODY_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "night_comb"), NIGHT_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "rainbow_comb"), RAINBOW_COMB);
    }
}
