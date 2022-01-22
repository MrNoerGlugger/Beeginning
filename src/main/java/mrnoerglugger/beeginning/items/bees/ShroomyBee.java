package mrnoerglugger.beeginning.items.bees;

import mrnoerglugger.beeginning.blocks.HiveBlock;
import mrnoerglugger.beeginning.items.BeeItem;
import mrnoerglugger.beeginning.items.combs.BaseCombs;
import mrnoerglugger.beeginning.items.combs.TierCombs;
import mrnoerglugger.beeginning.tags.ItemTags;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

import static mrnoerglugger.beeginning.Beeginning.*;

public class ShroomyBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.SHROOMY_COMB;
    static Item item3 = Items.BROWN_MUSHROOM;
    static Item item4 = Items.RED_MUSHROOM;
    public static final DefaultedList<ItemStack> ShroomyOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> ShroomyCombOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static String[][] ShroomyMutations = {};

    public static final Item SHROOMY_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item SHROOMY_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item SHROOMY_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock SHROOMY_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f), SHROOMY_QUEEN);

    public static void registerShroomyBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "shroomy_hive"), SHROOMY_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "shroomy_hive"), new BlockItem(SHROOMY_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "shroomy_princess"), SHROOMY_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "shroomy_drone"), SHROOMY_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "shroomy_queen"), SHROOMY_QUEEN);
        ShroomyOutput.set(0, new ItemStack(item));
        ShroomyOutput.set(1, new ItemStack(item2));
        ShroomyCombOutput.set(0, new ItemStack(item3, 5));
        ShroomyCombOutput.set(1, new ItemStack(item4, 5));
    }
}
