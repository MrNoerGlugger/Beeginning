package mrnoerglugger.beeginning.items.bees;

import mrnoerglugger.beeginning.items.HoneyDrops;
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

public class OrdinaryBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = TierCombs.ORDINARY_COMB;
    static Item item3 = HoneyDrops.ORDINARY_DROP;
    static Item item4 = HoneyDrops.ADVANCED_DROP;
    public static final DefaultedList<ItemStack> OrdinaryOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> OrdinaryCombOutput = DefaultedList.ofSize(8, ItemStack.EMPTY);
    public static String[][] OrdinaryMutations = {};

    public static final Item ORDINARY_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item ORDINARY_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item ORDINARY_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerOrdinaryBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "ordinary_princess"), ORDINARY_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "ordinary_drone"), ORDINARY_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "ordinary_queen"), ORDINARY_QUEEN);
        OrdinaryOutput.set(0, new ItemStack(item));
        OrdinaryOutput.set(1, new ItemStack(item2));
        OrdinaryCombOutput.set(0, new ItemStack(item3));
        OrdinaryCombOutput.set(1, new ItemStack(item3));
        OrdinaryCombOutput.set(2, new ItemStack(item3));
        OrdinaryCombOutput.set(3, new ItemStack(item3));
        OrdinaryCombOutput.set(4, new ItemStack(item3));
        OrdinaryCombOutput.set(5, new ItemStack(item3));
        OrdinaryCombOutput.set(6, new ItemStack(item3));
        OrdinaryCombOutput.set(7, new ItemStack(item4));
    }
}
