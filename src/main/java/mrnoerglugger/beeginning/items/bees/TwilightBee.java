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

public class TwilightBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.TWILIGHT_COMB;
    static Item item3 = Items.DARK_OAK_LOG;
    static Item item4 = Items.DARK_OAK_LEAVES;
    static Item item5 = Items.DARK_OAK_SAPLING;
    static Item item6 = Items.STICK;
    public static final DefaultedList<ItemStack> TwilightOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> TwilightCombOutput = DefaultedList.ofSize(4, ItemStack.EMPTY);
    public static String[][] TwilightMutations = {};

    public static final Item TWILIGHT_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item TWILIGHT_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item TWILIGHT_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock TWILIGHT_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f), TWILIGHT_QUEEN);

    public static void registerTwilightBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "twilight_hive"), TWILIGHT_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "twilight_hive"), new BlockItem(TWILIGHT_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "twilight_princess"), TWILIGHT_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "twilight_drone"), TWILIGHT_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "twilight_queen"), TWILIGHT_QUEEN);
        TwilightOutput.set(0, new ItemStack(item));
        TwilightOutput.set(1, new ItemStack(item2));
        TwilightCombOutput.set(0, new ItemStack(item3, 5));
        TwilightCombOutput.set(1, new ItemStack(item4, 5));
        TwilightCombOutput.set(2, new ItemStack(item5, 5));
        TwilightCombOutput.set(3, new ItemStack(item6, 5));
    }
}
