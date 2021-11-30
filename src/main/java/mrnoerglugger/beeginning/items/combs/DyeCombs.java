package mrnoerglugger.beeginning.items.combs;

import mrnoerglugger.beeginning.Beeginning;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static mrnoerglugger.beeginning.Beeginning.MODID;

public class DyeCombs {
    public static final Item AMARYLLIS_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item BEGONIA_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item FUCHSIA_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item FORGET_ME_NOT_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item MARIGOLD_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item BELLS_OF_IRELAND_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item AZALEA_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item SANTOLINA_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item ALLIUM_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item IPOMOEA_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item LAVENDER_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item PERIWINKLE_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item CATTLEYA_VELUTINA_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item GERBERA_DAISY_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item ROSE_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item QUEEN_OF_THE_NIGHT_TULIP_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item RAINBOW_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));

    public static void registerDyeCombs() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "amaryllis_comb"), AMARYLLIS_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "begonia_comb"), BEGONIA_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "fuchsia_comb"), FUCHSIA_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "forget_me_not_comb"), FORGET_ME_NOT_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "marigold_comb"), MARIGOLD_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "bells_of_ireland_comb"), BELLS_OF_IRELAND_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "azalea_comb"), AZALEA_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "santolina_comb"), SANTOLINA_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "allium_comb"), ALLIUM_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "ipomoea_comb"), IPOMOEA_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "lavender_comb"), LAVENDER_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "periwinkle_comb"), PERIWINKLE_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "cattleya_velutina_comb"), CATTLEYA_VELUTINA_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "gerbera_daisy_comb"), GERBERA_DAISY_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "rose_comb"), ROSE_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "queen_of_the_night_tulip_comb"), QUEEN_OF_THE_NIGHT_TULIP_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "rainbow_comb"), RAINBOW_COMB);
    }
}
