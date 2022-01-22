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

public class ExtraordinaryBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = TierCombs.EXTRAORDINARY_COMB;
    static Item item3 = HoneyDrops.EXTRAORDINARY_DROP;
    static Item item4 = HoneyDrops.MIRACULOUS_DROP;
    public static final DefaultedList<ItemStack> ExtraordinaryOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> ExtraordinaryCombOutput = DefaultedList.ofSize(20, ItemStack.EMPTY);
    public static String[][] ExtraordinaryMutations = {};

    public static final Item EXTRAORDINARY_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item EXTRAORDINARY_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item EXTRAORDINARY_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerExtraordinaryBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "extraordinary_princess"), EXTRAORDINARY_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "extraordinary_drone"), EXTRAORDINARY_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "extraordinary_queen"), EXTRAORDINARY_QUEEN);
        ExtraordinaryOutput.set(0, new ItemStack(item));
        ExtraordinaryOutput.set(1, new ItemStack(item2));
        ExtraordinaryCombOutput.set(0, new ItemStack(item3));
        ExtraordinaryCombOutput.set(1, new ItemStack(item3));
        ExtraordinaryCombOutput.set(2, new ItemStack(item3));
        ExtraordinaryCombOutput.set(3, new ItemStack(item3));
        ExtraordinaryCombOutput.set(4, new ItemStack(item3));
        ExtraordinaryCombOutput.set(5, new ItemStack(item3));
        ExtraordinaryCombOutput.set(6, new ItemStack(item3));
        ExtraordinaryCombOutput.set(7, new ItemStack(item3));
        ExtraordinaryCombOutput.set(8, new ItemStack(item3));
        ExtraordinaryCombOutput.set(9, new ItemStack(item3));
        ExtraordinaryCombOutput.set(10, new ItemStack(item3));
        ExtraordinaryCombOutput.set(11, new ItemStack(item3));
        ExtraordinaryCombOutput.set(12, new ItemStack(item3));
        ExtraordinaryCombOutput.set(13, new ItemStack(item3));
        ExtraordinaryCombOutput.set(14, new ItemStack(item3));
        ExtraordinaryCombOutput.set(15, new ItemStack(item3));
        ExtraordinaryCombOutput.set(16, new ItemStack(item3));
        ExtraordinaryCombOutput.set(17, new ItemStack(item3));
        ExtraordinaryCombOutput.set(18, new ItemStack(item3));
        ExtraordinaryCombOutput.set(19, new ItemStack(item4));
    }
}
