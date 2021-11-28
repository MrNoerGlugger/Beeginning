package mrnoerglugger.beeginning.items.bees;

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

public class CarboBee {
    static Item item = TierCombs.ORDINARY_COMB;
    static Item item2 = OreCombs.CARBO_COMB;
    static Item item3 = Items.COAL_ORE;
    static Item item4 = Items.DEEPSLATE_COAL_ORE;
    public static final DefaultedList<ItemStack> CarboOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> CarboCombOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static String[][] CarboMutations = {{"advanced", "ferrum"}, {"advanced", "cuprum"}, {"noteworthy", "engineered"}, {"noteworthy", "lazurite"}, {"extraodinary", "shining"}};

    public static final Item CARBO_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item CARBO_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item CARBO_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerCarboBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "carbo_princess"), CARBO_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "carbo_drone"), CARBO_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "carbo_queen"), CARBO_QUEEN);
        CarboOutput.set(0, new ItemStack(item));
        CarboOutput.set(1, new ItemStack(item2));
        CarboCombOutput.set(0, new ItemStack(item3));
        CarboCombOutput.set(1, new ItemStack(item4));
    }
}
