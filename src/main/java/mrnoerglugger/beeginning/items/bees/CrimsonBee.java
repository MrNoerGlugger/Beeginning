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

public class CrimsonBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.CRIMSON_COMB;
    static Item item3 = Items.CRIMSON_STEM;
    static Item item4 = Items.NETHER_WART_BLOCK;
    static Item item5 = Items.SHROOMLIGHT;
    public static final DefaultedList<ItemStack> CrimsonOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> CrimsonCombOutput = DefaultedList.ofSize(3, ItemStack.EMPTY);
    public static String[][] CrimsonMutations = {{"advanced", "silica"}};

    public static final Item CRIMSON_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item CRIMSON_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item CRIMSON_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock CRIMSON_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f), CRIMSON_QUEEN);

    public static void registerCrimsonBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "crimson_hive"), CRIMSON_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "crimson_hive"), new BlockItem(CRIMSON_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "crimson_princess"), CRIMSON_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "crimson_drone"), CRIMSON_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "crimson_queen"), CRIMSON_QUEEN);
        CrimsonOutput.set(0, new ItemStack(item));
        CrimsonOutput.set(1, new ItemStack(item2));
        CrimsonCombOutput.set(0, new ItemStack(item3, 5));
        CrimsonCombOutput.set(1, new ItemStack(item4, 5));
        CrimsonCombOutput.set(2, new ItemStack(item5, 5));
    }
}
