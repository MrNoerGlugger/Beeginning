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

public class GlowingBee {
    static Item item = TierCombs.ORDINARY_COMB;
    static Item item2 = OreCombs.GLOWING_COMB;
    static Item item3 = Items.GLOWSTONE_DUST;
    public static final DefaultedList<ItemStack> GlowingOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> GlowingCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] GlowingMutations = {{"advanced", "ferrum"}, {"advanced", "cuprum"}, {"advanced", "silica"}, {"noteworthy", "engineered"}, {"noteworthy", "crystal"}};

    public static final Item GLOWING_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item GLOWING_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item GLOWING_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerGlowingBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "glowing_princess"), GLOWING_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "glowing_drone"), GLOWING_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "glowing_queen"), GLOWING_QUEEN);
        GlowingOutput.set(0, new ItemStack(item));
        GlowingOutput.set(1, new ItemStack(item2));
        GlowingCombOutput.set(0, new ItemStack(item3, 4));
    }
}
