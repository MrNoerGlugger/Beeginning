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

public class BegoniaBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.BEGONIA_COMB;
    static Item item3 = Items.ORANGE_DYE;
    public static final DefaultedList<ItemStack> BegoniaOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> BegoniaCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] BegoniaMutations = {{"advanced", "rainbow"}};

    public static final Item BEGONIA_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item BEGONIA_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item BEGONIA_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerBegoniaBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "begonia_princess"), BEGONIA_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "begonia_drone"), BEGONIA_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "begonia_queen"), BEGONIA_QUEEN);
        BegoniaOutput.set(0, new ItemStack(item));
        BegoniaOutput.set(1, new ItemStack(item2));
        BegoniaCombOutput.set(0, new ItemStack(item3));
    }
}
