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

public class LavenderBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.LAVENDER_COMB;
    static Item item3 = Items.PURPLE_DYE;
    public static final DefaultedList<ItemStack> LavenderOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> LavenderCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] LavenderMutations = {{"advanced", "rainbow"}};

    public static final Item LAVENDER_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item LAVENDER_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item LAVENDER_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerLavenderBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "lavender_princess"), LAVENDER_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "lavender_drone"), LAVENDER_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "lavender_queen"), LAVENDER_QUEEN);
        LavenderOutput.set(0, new ItemStack(item));
        LavenderOutput.set(1, new ItemStack(item2));
        LavenderCombOutput.set(0, new ItemStack(item3));
    }
}
