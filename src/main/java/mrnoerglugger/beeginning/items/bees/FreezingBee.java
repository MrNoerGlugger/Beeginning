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

public class FreezingBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.FREEZING_COMB;
    static Item item3 = Items.SNOW;
    public static final DefaultedList<ItemStack> FreezingOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> FreezingCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] FreezingMutations = {};

    public static final Item FREEZING_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item FREEZING_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item FREEZING_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock FREEZING_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f), FREEZING_QUEEN);

    public static void registerFreezingBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "freezing_hive"), FREEZING_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "freezing_hive"), new BlockItem(FREEZING_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "freezing_princess"), FREEZING_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "freezing_drone"), FREEZING_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "freezing_queen"), FREEZING_QUEEN);
        FreezingOutput.set(0, new ItemStack(item));
        FreezingOutput.set(1, new ItemStack(item2));
        FreezingCombOutput.set(0, new ItemStack(item3));
    }
}
