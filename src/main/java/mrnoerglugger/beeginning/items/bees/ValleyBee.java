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

public class ValleyBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.VALLEY_COMB;
    static Item item3 = Items.SOUL_SAND;
    public static final DefaultedList<ItemStack> ValleyOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> ValleyCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] ValleyMutations = {{"advanced", "silica"}};

    public static final Item VALLEY_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item VALLEY_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item VALLEY_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock VALLEY_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(5).breakByTool(ItemTags.SCOOP_NETS).requiresTool().strength(1.5f));;

    public static void registerValleyBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "valley_hive"), VALLEY_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "valley_hive"), new BlockItem(VALLEY_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));//
        Registry.register(Registry.ITEM, new Identifier(MODID, "valley_princess"), VALLEY_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "valley_drone"), VALLEY_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "valley_queen"), VALLEY_QUEEN);
        ValleyOutput.set(0, new ItemStack(item));
        ValleyOutput.set(1, new ItemStack(item2));
        ValleyCombOutput.set(0, new ItemStack(item3));
    }
}