package mrnoerglugger.beeginning.items.bees;

import mrnoerglugger.beeginning.items.BeeItem;
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

public class ShiningBee {
    static Item item = TierCombs.EXTRAORDINARY_COMB;
    static Item item2 = OreCombs.SHINING_COMB;
    static Item item3 = Items.DIAMOND;
    public static final DefaultedList<ItemStack> ShiningOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> ShiningCombOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static String[][] ShiningMutations = {{"miraculous", "primordial"}};

    public static final Item SHINING_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item SHINING_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item SHINING_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerShiningBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "shining_princess"), SHINING_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "shining_drone"), SHINING_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "shining_queen"), SHINING_QUEEN);
        ShiningOutput.set(0, new ItemStack(item));
        ShiningOutput.set(1, new ItemStack(item2));
        ShiningCombOutput.set(0, new ItemStack(item3));
    }
}
