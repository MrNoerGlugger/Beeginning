package mrnoerglugger.beeginning.items.bees;

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

public class PeriwinkleBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.PERIWINKLE_COMB;
    static Item item3 = Items.BLUE_DYE;
    public static final DefaultedList<ItemStack> PeriwinkleOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> PeriwinkleCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] PeriwinkleMutations = {{"advanced", "rainbow"}};

    public static final Item PERIWINKLE_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item PERIWINKLE_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item PERIWINKLE_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerPeriwinkleBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "periwinkle_princess"), PERIWINKLE_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "periwinkle_drone"), PERIWINKLE_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "periwinkle_queen"), PERIWINKLE_QUEEN);
        PeriwinkleOutput.set(0, new ItemStack(item));
        PeriwinkleOutput.set(1, new ItemStack(item2));
        PeriwinkleCombOutput.set(0, new ItemStack(item3));
    }
}
