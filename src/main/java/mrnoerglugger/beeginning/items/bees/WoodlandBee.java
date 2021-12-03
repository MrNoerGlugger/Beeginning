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

public class WoodlandBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.WOODLAND_COMB;
    static Item item3 = Items.OAK_LOG;
    static Item item4 = Items.OAK_LEAVES;
    static Item item5 = Items.OAK_SAPLING;
    static Item item6 = Items.STICK;
    public static final DefaultedList<ItemStack> WoodlandOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> WoodlandCombOutput = DefaultedList.ofSize(4, ItemStack.EMPTY);
    public static String[][] WoodlandMutations = {};

    public static final Item WOODLAND_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item WOODLAND_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item WOODLAND_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock WOODLAND_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f), WOODLAND_QUEEN);

    public static void registerWoodlandBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "woodland_hive"), WOODLAND_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "woodland_hive"), new BlockItem(WOODLAND_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "woodland_princess"), WOODLAND_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "woodland_drone"), WOODLAND_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "woodland_queen"), WOODLAND_QUEEN);
        WoodlandOutput.set(0, new ItemStack(item));
        WoodlandOutput.set(1, new ItemStack(item2));
        WoodlandCombOutput.set(0, new ItemStack(item3, 5));
        WoodlandCombOutput.set(1, new ItemStack(item4, 5));
        WoodlandCombOutput.set(2, new ItemStack(item5, 5));
        WoodlandCombOutput.set(3, new ItemStack(item6, 5));
    }
}
