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

public class AlliumBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.ALLIUM_COMB;
    static Item item3 = Items.LIGHT_GRAY_DYE;
    public static final DefaultedList<ItemStack> AlliumOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> AlliumCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] AlliumMutations = {{"advanced", "rainbow"}};

    public static final Item ALLIUM_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item ALLIUM_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item ALLIUM_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerAlliumBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "allium_princess"), ALLIUM_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "allium_drone"), ALLIUM_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "allium_queen"), ALLIUM_QUEEN);
        AlliumOutput.set(0, new ItemStack(item));
        AlliumOutput.set(1, new ItemStack(item2));
        AlliumCombOutput.set(0, new ItemStack(item3));
    }
}
