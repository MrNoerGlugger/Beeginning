package mrnoerglugger.beeginning.items;

import mrnoerglugger.beeginning.items.bees.MountainousBee;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static mrnoerglugger.beeginning.Beeginning.GENERIC_GROUP;
import static mrnoerglugger.beeginning.Beeginning.MODID;

public class HoneyDrops {
    public static final Item HONEY_DROP = new Item(new FabricItemSettings().group(GENERIC_GROUP));
    public static final Item ORDINARY_DROP = new Item(new FabricItemSettings().group(GENERIC_GROUP));
    public static final Item ADVANCED_DROP = new Item(new FabricItemSettings().group(GENERIC_GROUP));
    public static final Item NOTEWORTHY_DROP = new Item(new FabricItemSettings().group(GENERIC_GROUP));
    public static final Item EXTRAORDINARY_DROP = new Item(new FabricItemSettings().group(GENERIC_GROUP));
    public static final Item MIRACULOUS_DROP = new Item(new FabricItemSettings().group(GENERIC_GROUP));

    public static void registerHoneyDrops() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "honey_drop"), HONEY_DROP);
        Registry.register(Registry.ITEM, new Identifier(MODID, "ordinary_drop"), ORDINARY_DROP);
        Registry.register(Registry.ITEM, new Identifier(MODID, "advanced_drop"), ADVANCED_DROP);
        Registry.register(Registry.ITEM, new Identifier(MODID, "noteworthy_drop"), NOTEWORTHY_DROP);
        Registry.register(Registry.ITEM, new Identifier(MODID, "extraordinary_drop"), EXTRAORDINARY_DROP);
        Registry.register(Registry.ITEM, new Identifier(MODID, "miraculous_drop"), MIRACULOUS_DROP);
    }
}
