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

public class AdvancedBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = TierCombs.ADVANCED_COMB;
    static Item item3 = HoneyDrops.ADVANCED_DROP;
    static Item item4 = HoneyDrops.NOTEWORTHY_DROP;
    public static final DefaultedList<ItemStack> AdvancedOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> AdvancedCombOutput = DefaultedList.ofSize(12, ItemStack.EMPTY);
    public static String[][] AdvancedMutations = {};

    public static final Item ADVANCED_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item ADVANCED_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item ADVANCED_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerAdvancedBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "advanced_princess"), ADVANCED_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "advanced_drone"), ADVANCED_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "advanced_queen"), ADVANCED_QUEEN);
        AdvancedOutput.set(0, new ItemStack(item));
        AdvancedOutput.set(1, new ItemStack(item2));
        AdvancedCombOutput.set(0, new ItemStack(item3));
        AdvancedCombOutput.set(1, new ItemStack(item3));
        AdvancedCombOutput.set(2, new ItemStack(item3));
        AdvancedCombOutput.set(3, new ItemStack(item3));
        AdvancedCombOutput.set(4, new ItemStack(item3));
        AdvancedCombOutput.set(5, new ItemStack(item3));
        AdvancedCombOutput.set(6, new ItemStack(item3));
        AdvancedCombOutput.set(7, new ItemStack(item3));
        AdvancedCombOutput.set(8, new ItemStack(item3));
        AdvancedCombOutput.set(9, new ItemStack(item3));
        AdvancedCombOutput.set(10, new ItemStack(item3));
        AdvancedCombOutput.set(11, new ItemStack(item4));
    }
}
