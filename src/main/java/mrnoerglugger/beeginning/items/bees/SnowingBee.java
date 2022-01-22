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
import org.lwjgl.system.CallbackI;

import static mrnoerglugger.beeginning.Beeginning.*;

public class SnowingBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.SNOWING_COMB;
    static Item item3 = Items.SPRUCE_LOG;
    static Item item4 = Items.SPRUCE_LEAVES;
    static Item item5 = Items.SPRUCE_SAPLING;
    static Item item6 = Items.STICK;
    public static final DefaultedList<ItemStack> SnowingOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> SnowingCombOutput = DefaultedList.ofSize(4, ItemStack.EMPTY);
    public static String[][] SnowingMutations = {};

    public static final Item SNOWING_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item SNOWING_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item SNOWING_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock SNOWING_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f), SNOWING_QUEEN);

    public static void registerSnowingBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "snowing_hive"), SNOWING_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "snowing_hive"), new BlockItem(SNOWING_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "snowing_princess"), SNOWING_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "snowing_drone"), SNOWING_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "snowing_queen"), SNOWING_QUEEN);
        SnowingOutput.set(0, new ItemStack(item));
        SnowingOutput.set(1, new ItemStack(item2));
        SnowingCombOutput.set(0, new ItemStack(item3, 5));
        SnowingCombOutput.set(1, new ItemStack(item4, 5));
        SnowingCombOutput.set(2, new ItemStack(item5, 5));
        SnowingCombOutput.set(3, new ItemStack(item6, 5));
    }
}
