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

public class BaobabBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.BAOBAB_COMB;
    static Item item3 = Items.ACACIA_LOG;
    static Item item4 = Items.ACACIA_LEAVES;
    static Item item5 = Items.ACACIA_SAPLING;
    static Item item6 = Items.STICK;
    public static final DefaultedList<ItemStack> BaobabOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> BaobabCombOutput = DefaultedList.ofSize(4, ItemStack.EMPTY);
    public static String[][] BaobabMutations = {};

    public static final Item BAOBAB_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item BAOBAB_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item BAOBAB_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock BAOBAB_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f), BAOBAB_QUEEN);;

    public static void registerBaobabBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "baobab_hive"), BAOBAB_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "baobab_hive"), new BlockItem(BAOBAB_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));//
        Registry.register(Registry.ITEM, new Identifier(MODID, "baobab_princess"), BAOBAB_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "baobab_drone"), BAOBAB_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "baobab_queen"), BAOBAB_QUEEN);
        BaobabOutput.set(0, new ItemStack(item));
        BaobabOutput.set(1, new ItemStack(item2));
        BaobabCombOutput.set(0, new ItemStack(item3, 5));
        BaobabCombOutput.set(1, new ItemStack(item4, 5));
        BaobabCombOutput.set(2, new ItemStack(item5, 5));
        BaobabCombOutput.set(3, new ItemStack(item6, 5));
    }
}
