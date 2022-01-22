package mrnoerglugger.beeginning.items.bees;

import mrnoerglugger.beeginning.items.BeeItem;
import mrnoerglugger.beeginning.items.combs.DyeCombs;
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

public class MarigoldBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.MARIGOLD_COMB;
    static Item item3 = Items.YELLOW_DYE;
    public static final DefaultedList<ItemStack> MarigoldOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> MarigoldCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] MarigoldMutations = {{"advanced", "rainbow"}};

    public static final Item MARIGOLD_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item MARIGOLD_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item MARIGOLD_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerMarigoldBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "marigold_princess"), MARIGOLD_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "marigold_drone"), MARIGOLD_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "marigold_queen"), MARIGOLD_QUEEN);
        MarigoldOutput.set(0, new ItemStack(item));
        MarigoldOutput.set(1, new ItemStack(item2));
        MarigoldCombOutput.set(0, new ItemStack(item3));
    }
}
