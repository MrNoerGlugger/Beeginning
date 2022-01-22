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

public class IpomoeaBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.IPOMOEA_COMB;
    static Item item3 = Items.CYAN_DYE;
    public static final DefaultedList<ItemStack> IpomoeaOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> IpomoeaCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] IpomoeaMutations = {{"advanced", "rainbow"}};

    public static final Item IPOMOEA_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item IPOMOEA_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item IPOMOEA_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerIpomoeaBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "ipomoea_princess"), IPOMOEA_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "ipomoea_drone"), IPOMOEA_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "ipomoea_queen"), IPOMOEA_QUEEN);
        IpomoeaOutput.set(0, new ItemStack(item));
        IpomoeaOutput.set(1, new ItemStack(item2));
        IpomoeaCombOutput.set(0, new ItemStack(item3));
    }
}
