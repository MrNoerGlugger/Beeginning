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

public class NoteworthyBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = TierCombs.NOTEWORTHY_COMB;
    static Item item3 = HoneyDrops.NOTEWORTHY_DROP;
    static Item item4 = HoneyDrops.EXTRAORDINARY_DROP;
    public static final DefaultedList<ItemStack> NoteworthyOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> NoteworthyCombOutput = DefaultedList.ofSize(16, ItemStack.EMPTY);
    public static String[][] NoteworthyMutations = {};

    public static final Item NOTEWORTHY_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item NOTEWORTHY_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item NOTEWORTHY_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerNoteworthyBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "noteworthy_princess"), NOTEWORTHY_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "noteworthy_drone"), NOTEWORTHY_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "noteworthy_queen"), NOTEWORTHY_QUEEN);
        NoteworthyOutput.set(0, new ItemStack(item));
        NoteworthyOutput.set(1, new ItemStack(item2));
        NoteworthyCombOutput.set(0, new ItemStack(item3));
        NoteworthyCombOutput.set(1, new ItemStack(item3));
        NoteworthyCombOutput.set(2, new ItemStack(item3));
        NoteworthyCombOutput.set(3, new ItemStack(item3));
        NoteworthyCombOutput.set(4, new ItemStack(item3));
        NoteworthyCombOutput.set(5, new ItemStack(item3));
        NoteworthyCombOutput.set(6, new ItemStack(item3));
        NoteworthyCombOutput.set(7, new ItemStack(item3));
        NoteworthyCombOutput.set(8, new ItemStack(item3));
        NoteworthyCombOutput.set(9, new ItemStack(item3));
        NoteworthyCombOutput.set(10, new ItemStack(item3));
        NoteworthyCombOutput.set(11, new ItemStack(item3));
        NoteworthyCombOutput.set(12, new ItemStack(item3));
        NoteworthyCombOutput.set(13, new ItemStack(item3));
        NoteworthyCombOutput.set(14, new ItemStack(item3));
        NoteworthyCombOutput.set(15, new ItemStack(item4));
    }
}
