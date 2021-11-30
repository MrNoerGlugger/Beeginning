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

public class BloomingBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.BLOOMING_COMB;
    static Item item3 = Items.DANDELION;
    static Item item4 = Items.POPPY;
    public static final DefaultedList<ItemStack> BloomingOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> BloomingCombOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static String[][] BloomingMutations = {{"ordinary", "amaryllis"}, {"ordinary", "begonia"}, {"ordinary", "fuchsia"}, {"ordinary", "forget_me_not"}, {"ordinary", "marigold"}, {"ordinary", "bells_of_ireland"}, {"ordinary", "azalea"}, {"ordinary", "santolina"}, {"ordinary", "allium"}, {"ordinary", "ipomoea"}, {"ordinary", "lavender"}, {"ordinary", "periwinkle"}, {"ordinary", "cattleya_velutina"}, {"ordinary", "gerbera_daisy"}, {"ordinary", "rose"}, {"ordinary", "queen_of_the_night_tulip"}, {"advanced", "rainbow"}};

    public static final Item BLOOMING_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item BLOOMING_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item BLOOMING_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock BLOOMING_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f));

    public static void registerBloomingBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "blooming_hive"), BLOOMING_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "blooming_hive"), new BlockItem(BLOOMING_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "blooming_princess"), BLOOMING_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "blooming_drone"), BLOOMING_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "blooming_queen"), BLOOMING_QUEEN);
        BloomingOutput.set(0, new ItemStack(item));
        BloomingOutput.set(1, new ItemStack(item2));
        BloomingCombOutput.set(0, new ItemStack(item3));
        BloomingCombOutput.set(1, new ItemStack(item4));
    }
}
