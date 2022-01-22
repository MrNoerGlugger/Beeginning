package mrnoerglugger.beeginning.items.bees;

import mrnoerglugger.beeginning.blocks.HiveBlock;
import mrnoerglugger.beeginning.items.BeeItem;
import mrnoerglugger.beeginning.items.combs.BaseCombs;
import mrnoerglugger.beeginning.items.combs.TierCombs;
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

public class BetulaBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.BETULA_COMB;
    static Item item3 = Items.BIRCH_LOG;
    static Item item4 = Items.BIRCH_LEAVES;
    static Item item5 = Items.BIRCH_SAPLING;
    static Item item6 = Items.STICK;
    public static final DefaultedList<ItemStack> BetulaOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> BetulaCombOutput = DefaultedList.ofSize(4, ItemStack.EMPTY);
    public static String[][] BetulaMutations = {};

    public static final Item BETULA_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item BETULA_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item BETULA_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock BETULA_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f), BETULA_QUEEN);

    public static void registerBetulaBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "betula_hive"), BETULA_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "betula_hive"), new BlockItem(BETULA_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "betula_princess"), BETULA_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "betula_drone"), BETULA_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "betula_queen"), BETULA_QUEEN);
        BetulaOutput.set(0, new ItemStack(item));
        BetulaOutput.set(1, new ItemStack(item2));
        BetulaCombOutput.set(0, new ItemStack(item3, 5));
        BetulaCombOutput.set(1, new ItemStack(item4, 5));
        BetulaCombOutput.set(2, new ItemStack(item5, 5));
        BetulaCombOutput.set(3, new ItemStack(item6, 5));
    }
}
