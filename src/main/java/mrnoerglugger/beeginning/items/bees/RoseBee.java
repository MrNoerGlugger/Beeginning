package mrnoerglugger.beeginning.items.bees;

import mrnoerglugger.beeginning.blocks.HiveBlock;
import mrnoerglugger.beeginning.items.combs.DyeCombs;
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

public class RoseBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.ROSE_COMB;
    static Item item3 = Items.RED_DYE;
    public static final DefaultedList<ItemStack> RoseOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> RoseCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] RoseMutations = {{"advanced", "rainbow"}};

    public static final Item ROSE_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item ROSE_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item ROSE_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerRoseBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "rose_princess"), ROSE_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "rose_drone"), ROSE_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "rose_queen"), ROSE_QUEEN);
        RoseOutput.set(0, new ItemStack(item));
        RoseOutput.set(1, new ItemStack(item2));
        RoseCombOutput.set(0, new ItemStack(item3));
    }
}
