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

public class MorassBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.MORASS_COMB;
    static Item item3 = Items.LILY_PAD;
    public static final DefaultedList<ItemStack> MorassOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> MorassCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] MorassMutations = {};

    public static final Item MORASS_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item MORASS_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item MORASS_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock MORASS_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f), MORASS_QUEEN);

    public static void registerMorassBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "morass_hive"), MORASS_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "morass_hive"), new BlockItem(MORASS_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "morass_princess"), MORASS_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "morass_drone"), MORASS_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "morass_queen"), MORASS_QUEEN);
        MorassOutput.set(0, new ItemStack(item));
        MorassOutput.set(1, new ItemStack(item2));
        MorassCombOutput.set(0, new ItemStack(item3));
    }
}
