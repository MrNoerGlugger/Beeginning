package mrnoerglugger.beeginning.items.bees;

import mrnoerglugger.beeginning.blocks.ApiaryBlock;
import mrnoerglugger.beeginning.items.Frames;
import mrnoerglugger.beeginning.items.combs.OreCombs;
import mrnoerglugger.beeginning.items.combs.TierCombs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

import static mrnoerglugger.beeginning.Beeginning.BEE_GROUP;
import static mrnoerglugger.beeginning.Beeginning.MODID;

public class FerrumBee {
    static Item item = TierCombs.ADVANCED_COMB;
    static Item item2 = OreCombs.FERRUM_COMB;
    static Item item3 = Items.IRON_ORE;
    static Item item4 = Items.DEEPSLATE_IRON_ORE;
    public static final DefaultedList<ItemStack> FerrumOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> FerrumCombOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static String[][] FerrumMutations = {{"noteworthy", "engineered"}, {"noteworthy", "aurum"}, {"noteworthy", "lazurite"}, {"noteworthy", "crystal"}};

    public static final Item FERRUM_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item FERRUM_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item FERRUM_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerFerrumBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "ferrum_princess"), FERRUM_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "ferrum_drone"), FERRUM_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "ferrum_queen"), FERRUM_QUEEN);
        FerrumOutput.set(0, new ItemStack(item));
        FerrumOutput.set(1, new ItemStack(item2));
        FerrumCombOutput.set(0, new ItemStack(item3));
        FerrumCombOutput.set(1, new ItemStack(item4));
    }
}
