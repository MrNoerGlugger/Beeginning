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

public class WarpedBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.WARPED_COMB;
    static Item item3 = Items.WARPED_STEM;
    static Item item4 = Items.WARPED_WART_BLOCK;
    static Item item5 = Items.SHROOMLIGHT;
    public static final DefaultedList<ItemStack> WarpedOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> WarpedCombOutput = DefaultedList.ofSize(3, ItemStack.EMPTY);
    public static String[][] WarpedMutations = {{"advanced", "silica"}};

    public static final Item WARPED_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item WARPED_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item WARPED_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock WARPED_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f), WARPED_QUEEN);

    public static void registerWarpedBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "warped_hive"), WARPED_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "warped_hive"), new BlockItem(WARPED_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "warped_princess"), WARPED_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "warped_drone"), WARPED_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "warped_queen"), WARPED_QUEEN);
        WarpedOutput.set(0, new ItemStack(item));
        WarpedOutput.set(1, new ItemStack(item2));
        WarpedCombOutput.set(0, new ItemStack(item3, 5));
        WarpedCombOutput.set(1, new ItemStack(item4, 5));
        WarpedCombOutput.set(2, new ItemStack(item5, 5));
    }
}
