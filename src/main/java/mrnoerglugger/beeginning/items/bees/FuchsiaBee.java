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

public class FuchsiaBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.FUCHSIA_COMB;
    static Item item3 = Items.MAGENTA_DYE;
    public static final DefaultedList<ItemStack> FuchsiaOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> FuchsiaCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] FuchsiaMutations = {{"advanced", "rainbow"}};

    public static final Item FUCHSIA_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item FUCHSIA_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item FUCHSIA_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerFuchsiaBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "fuchsia_princess"), FUCHSIA_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "fuchsia_drone"), FUCHSIA_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "fuchsia_queen"), FUCHSIA_QUEEN);
        FuchsiaOutput.set(0, new ItemStack(item));
        FuchsiaOutput.set(1, new ItemStack(item2));
        FuchsiaCombOutput.set(0, new ItemStack(item3));
    }
}
