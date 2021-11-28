package mrnoerglugger.beeginning.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static mrnoerglugger.beeginning.Beeginning.GENERIC_GROUP;
import static mrnoerglugger.beeginning.Beeginning.MODID;

public class ScoopNets {
    public static final Item WOODEN_SCOOP_NET = new ScoopItem(ToolMaterials.WOOD, 3, -2.4f, (new FabricItemSettings().group(GENERIC_GROUP).maxDamage(10)));
    public static final Item STONE_SCOOP_NET = new ScoopItem(ToolMaterials.STONE, 3, -2.4f, (new FabricItemSettings().group(GENERIC_GROUP).maxDamage(20)));
    public static final Item IRON_SCOOP_NET = new ScoopItem(ToolMaterials.IRON, 3, -2.4f, (new FabricItemSettings().group(GENERIC_GROUP).maxDamage(40)));
    public static final Item GOLDEN_SCOOP_NET = new ScoopItem(ToolMaterials.GOLD, 3, -2.4f, (new FabricItemSettings().group(GENERIC_GROUP).maxDamage(5)));
    public static final Item DIAMOND_SCOOP_NET = new ScoopItem(ToolMaterials.DIAMOND, 3, -2.4f, (new FabricItemSettings().group(GENERIC_GROUP).maxDamage(150)));
    public static final Item NETHERITE_SCOOP_NET = new ScoopItem(ToolMaterials.NETHERITE, 3, -2.4f, (new FabricItemSettings().group(GENERIC_GROUP).maxDamage(300)));

    public static void registerScoopNets() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "wooden_scoop_net"), WOODEN_SCOOP_NET);
        Registry.register(Registry.ITEM, new Identifier(MODID, "stone_scoop_net"), STONE_SCOOP_NET);
        Registry.register(Registry.ITEM, new Identifier(MODID, "iron_scoop_net"), IRON_SCOOP_NET);
        Registry.register(Registry.ITEM, new Identifier(MODID, "golden_scoop_net"), GOLDEN_SCOOP_NET);
        Registry.register(Registry.ITEM, new Identifier(MODID, "diamond_scoop_net"), DIAMOND_SCOOP_NET);
        Registry.register(Registry.ITEM, new Identifier(MODID, "netherite_scoop_net"), NETHERITE_SCOOP_NET);
    }
}
