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

public class VoidBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.VOID_COMB;
    static Item item3 = Items.OBSIDIAN;
    public static final DefaultedList<ItemStack> VoidOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> VoidCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] VoidMutations = {};

    public static final Item VOID_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item VOID_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item VOID_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock VOID_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(0).requiresTool().strength(1.5f), VOID_QUEEN);

    public static void registerVoidBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "void_hive"), VOID_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "void_hive"), new BlockItem(VOID_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "void_princess"), VOID_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "void_drone"), VOID_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "void_queen"), VOID_QUEEN);
        VoidOutput.set(0, new ItemStack(item));
        VoidOutput.set(1, new ItemStack(item2));
        VoidCombOutput.set(0, new ItemStack(item3));
    }
}
