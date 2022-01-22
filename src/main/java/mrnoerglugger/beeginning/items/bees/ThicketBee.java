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

public class ThicketBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.THICKET_COMB;
    static Item item3 = Items.JUNGLE_LOG;
    static Item item4 = Items.JUNGLE_LEAVES;
    static Item item5 = Items.JUNGLE_SAPLING;
    static Item item6 = Items.STICK;
    public static final DefaultedList<ItemStack> ThicketOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> ThicketCombOutput = DefaultedList.ofSize(4, ItemStack.EMPTY);
    public static String[][] ThicketMutations = {};

    public static final Item THICKET_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item THICKET_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item THICKET_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock THICKET_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(8).requiresTool().strength(1.5f), THICKET_QUEEN);

    public static void registerThicketBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "thicket_hive"), THICKET_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "thicket_hive"), new BlockItem(THICKET_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "thicket_princess"), THICKET_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "thicket_drone"), THICKET_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "thicket_queen"), THICKET_QUEEN);
        ThicketOutput.set(0, new ItemStack(item));
        ThicketOutput.set(1, new ItemStack(item2));
        ThicketCombOutput.set(0, new ItemStack(item3, 5));
        ThicketCombOutput.set(1, new ItemStack(item4, 5));
        ThicketCombOutput.set(2, new ItemStack(item5, 5));
        ThicketCombOutput.set(3, new ItemStack(item6, 5));
    }
}
