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

public class ForgetMeNotBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.FORGET_ME_NOT_COMB;
    static Item item3 = Items.LIGHT_BLUE_DYE;
    public static final DefaultedList<ItemStack> ForgetMeNotOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> ForgetMeNotCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] ForgetMeNotMutations = {{"advanced", "rainbow"}};

    public static final Item FORGET_ME_NOT_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item FORGET_ME_NOT_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item FORGET_ME_NOT_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerForgetMeNotBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "forget_me_not_princess"), FORGET_ME_NOT_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "forget_me_not_drone"), FORGET_ME_NOT_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "forget_me_not_queen"), FORGET_ME_NOT_QUEEN);
        ForgetMeNotOutput.set(0, new ItemStack(item));
        ForgetMeNotOutput.set(1, new ItemStack(item2));
        ForgetMeNotCombOutput.set(0, new ItemStack(item3));
    }
}
