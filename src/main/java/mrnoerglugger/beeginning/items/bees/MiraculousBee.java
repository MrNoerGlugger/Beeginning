package mrnoerglugger.beeginning.items.bees;

import mrnoerglugger.beeginning.items.BeeItem;
import mrnoerglugger.beeginning.items.HoneyDrops;
import mrnoerglugger.beeginning.items.combs.TierCombs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

import static mrnoerglugger.beeginning.Beeginning.BEE_GROUP;
import static mrnoerglugger.beeginning.Beeginning.MODID;

public class MiraculousBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = TierCombs.MIRACULOUS_COMB;
    static Item item3 = HoneyDrops.MIRACULOUS_DROP;
    public static final DefaultedList<ItemStack> MiraculousOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> MiraculousCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] MiraculousMutations = {};

    public static final Item MIRACULOUS_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item MIRACULOUS_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item MIRACULOUS_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerMiraculousBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "miraculous_princess"), MIRACULOUS_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "miraculous_drone"), MIRACULOUS_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "miraculous_queen"), MIRACULOUS_QUEEN);
        MiraculousOutput.set(0, new ItemStack(item));
        MiraculousOutput.set(1, new ItemStack(item2));
        MiraculousCombOutput.set(0, new ItemStack(item3));
    }
}
