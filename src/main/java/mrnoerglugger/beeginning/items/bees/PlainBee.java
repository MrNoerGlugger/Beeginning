package mrnoerglugger.beeginning.items.bees;

import mrnoerglugger.beeginning.blocks.HiveBlock;
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

public class PlainBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.PLAIN_COMB;
    static Item item3 = Items.WHEAT_SEEDS;
    public static final DefaultedList<ItemStack> PlainOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> PlainCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] PlainMutations = {};

    public static final Item PLAIN_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item PLAIN_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item PLAIN_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock PLAIN_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f));;

    public static void registerPlainBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "plain_hive"), PLAIN_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "plain_hive"), new BlockItem(PLAIN_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));//
        Registry.register(Registry.ITEM, new Identifier(MODID, "plain_princess"), PLAIN_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "plain_drone"), PLAIN_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "plain_queen"), PLAIN_QUEEN);
        PlainOutput.set(0, new ItemStack(item));
        PlainOutput.set(1, new ItemStack(item2));
        PlainCombOutput.set(0, new ItemStack(item3));
    }
}
