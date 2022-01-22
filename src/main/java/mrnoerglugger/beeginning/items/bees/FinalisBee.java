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

public class FinalisBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.FINALIS_COMB;
    static Item item3 = Items.END_STONE;
    public static final DefaultedList<ItemStack> FinalisOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> FinalisCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] FinalisMutations = {};

    public static final Item FINALIS_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item FINALIS_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item FINALIS_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock FINALIS_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(5).requiresTool().strength(1.5f), FINALIS_QUEEN);

    public static void registerFinalisBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "finalis_hive"), FINALIS_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "finalis_hive"), new BlockItem(FINALIS_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "finalis_princess"), FINALIS_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "finalis_drone"), FINALIS_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "finalis_queen"), FINALIS_QUEEN);
        FinalisOutput.set(0, new ItemStack(item));
        FinalisOutput.set(1, new ItemStack(item2));
        FinalisCombOutput.set(0, new ItemStack(item3));
    }
}
