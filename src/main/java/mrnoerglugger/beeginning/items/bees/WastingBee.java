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

public class WastingBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.WASTING_COMB;
    static Item item3 = Items.NETHERRACK;
    public static final DefaultedList<ItemStack> WastingOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> WastingCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] WastingMutations = {{"ordinary", "glowing"}, {"advanced", "silica"}};

    public static final Item WASTING_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item WASTING_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item WASTING_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock WASTING_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(5).requiresTool().strength(1.5f));

    public static void registerWastingBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "wasting_hive"), WASTING_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "wasting_hive"), new BlockItem(WASTING_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "wasting_princess"), WASTING_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "wasting_drone"), WASTING_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "wasting_queen"), WASTING_QUEEN);
        WastingOutput.set(0, new ItemStack(item));
        WastingOutput.set(1, new ItemStack(item2));
        WastingCombOutput.set(0, new ItemStack(item3));
    }
}
