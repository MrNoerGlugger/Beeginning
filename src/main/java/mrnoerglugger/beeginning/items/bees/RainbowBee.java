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

public class RainbowBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.RAINBOW_COMB;
    static Item item3 = Items.WHITE_DYE;
    static Item item4 = Items.ORANGE_DYE;
    static Item item5 = Items.MAGENTA_DYE;
    static Item item6 = Items.LIGHT_BLUE_DYE;
    static Item item7 = Items.YELLOW_DYE;
    static Item item8 = Items.LIME_DYE;
    static Item item9 = Items.PINK_DYE;
    static Item item10 = Items.GRAY_DYE;
    static Item item11 = Items.LIGHT_GRAY_DYE;
    static Item item12 = Items.CYAN_DYE;
    static Item item13 = Items.PURPLE_DYE;
    static Item item14 = Items.BLUE_DYE;
    static Item item15 = Items.BROWN_DYE;
    static Item item16 = Items.GREEN_DYE;
    static Item item17 = Items.RED_DYE;
    static Item item18 = Items.BLACK_DYE;
    public static final DefaultedList<ItemStack> RainbowOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> RainbowCombOutput = DefaultedList.ofSize(16, ItemStack.EMPTY);
    public static String[][] RainbowMutations = {{"advanced", "rainbow"}};

    public static final Item RAINBOW_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item RAINBOW_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item RAINBOW_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerRainbowBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "rainbow_princess"), RAINBOW_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "rainbow_drone"), RAINBOW_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "rainbow_queen"), RAINBOW_QUEEN);
        RainbowOutput.set(0, new ItemStack(item));
        RainbowOutput.set(1, new ItemStack(item2));
        RainbowCombOutput.set(0, new ItemStack(item3, 16));
        RainbowCombOutput.set(1, new ItemStack(item4, 16));
        RainbowCombOutput.set(2, new ItemStack(item5, 16));
        RainbowCombOutput.set(3, new ItemStack(item6, 16));
        RainbowCombOutput.set(4, new ItemStack(item7, 16));
        RainbowCombOutput.set(5, new ItemStack(item8, 16));
        RainbowCombOutput.set(6, new ItemStack(item9, 16));
        RainbowCombOutput.set(7, new ItemStack(item10, 16));
        RainbowCombOutput.set(8, new ItemStack(item11, 16));
        RainbowCombOutput.set(9, new ItemStack(item12, 16));
        RainbowCombOutput.set(10, new ItemStack(item13, 16));
        RainbowCombOutput.set(11, new ItemStack(item14, 16));
        RainbowCombOutput.set(12, new ItemStack(item15, 16));
        RainbowCombOutput.set(13, new ItemStack(item16, 16));
        RainbowCombOutput.set(14, new ItemStack(item17, 16));
        RainbowCombOutput.set(15, new ItemStack(item18, 16));
    }
}
