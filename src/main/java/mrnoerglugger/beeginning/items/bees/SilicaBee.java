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

public class SilicaBee {
    static Item item = TierCombs.ADVANCED_COMB;
    static Item item2 = OreCombs.SILICA_COMB;
    static Item item3 = Items.NETHER_QUARTZ_ORE;
    public static final DefaultedList<ItemStack> SilicaOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> SilicaCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] SilicaMutations = {{"noteworthy", "engineered"}, {"noteworthy", "aurum"}, {"noteworthy", "lazurite"}, {"noteworthy", "crystal"}, {"extraordinary", "shining"}, {"extraordinary", "smaragdus"}};

    public static final Item SILICA_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item SILICA_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item SILICA_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerSilicaBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "silica_princess"), SILICA_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "silica_drone"), SILICA_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "silica_queen"), SILICA_QUEEN);
        SilicaOutput.set(0, new ItemStack(item));
        SilicaOutput.set(1, new ItemStack(item2));
        SilicaCombOutput.set(0, new ItemStack(item3));
    }
}
