package mrnoerglugger.beeginning.items.bees;

import mrnoerglugger.beeginning.items.BeeItem;
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

public class CuprumBee {
    static Item item = TierCombs.ADVANCED_COMB;
    static Item item2 = OreCombs.CUPRUM_COMB;
    static Item item3 = Items.RAW_COPPER;
    public static final DefaultedList<ItemStack> CuprumOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> CuprumCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] CuprumMutations = {{"noteworthy", "engineered"}, {"noteworthy", "aurum"}, {"noteworthy", "lazurite"}, {"noteworthy", "crystal"}};

    public static final Item CUPRUM_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item CUPRUM_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item CUPRUM_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerCuprumBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "cuprum_princess"), CUPRUM_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "cuprum_drone"), CUPRUM_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "cuprum_queen"), CUPRUM_QUEEN);
        CuprumOutput.set(0, new ItemStack(item));
        CuprumOutput.set(1, new ItemStack(item2));
        CuprumCombOutput.set(0, new ItemStack(item3, 2));
    }
}
