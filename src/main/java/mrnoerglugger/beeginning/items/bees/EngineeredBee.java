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

public class EngineeredBee {
    static Item item = TierCombs.NOTEWORTHY_COMB;
    static Item item2 = OreCombs.ENGINEERED_COMB;
    static Item item3 = Items.REDSTONE_ORE;
    static Item item4 = Items.DEEPSLATE_REDSTONE_ORE;
    public static final DefaultedList<ItemStack> EngineeredOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> EngineeredCombOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static String[][] EngineeredMutations = {{"extraordinary", "shining"}, {"extraordinary", "smaragdus"}};

    public static final Item ENGINEERED_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item ENGINEERED_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item ENGINEERED_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerEngineeredBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "engineered_princess"), ENGINEERED_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "engineered_drone"), ENGINEERED_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "engineered_queen"), ENGINEERED_QUEEN);
        EngineeredOutput.set(0, new ItemStack(item));
        EngineeredOutput.set(1, new ItemStack(item2));
        EngineeredCombOutput.set(0, new ItemStack(item3));
        EngineeredCombOutput.set(1, new ItemStack(item4));
    }
}
