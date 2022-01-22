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

public class AmaryllisBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.AMARYLLIS_COMB;
    static Item item3 = Items.WHITE_DYE;
    public static final DefaultedList<ItemStack> AmaryllisOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> AmaryllisCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] AmaryllisMutations = {{"advanced", "rainbow"}};

    public static final Item AMARYLLIS_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item AMARYLLIS_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item AMARYLLIS_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerAmaryllisBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "amaryllis_princess"), AMARYLLIS_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "amaryllis_drone"), AMARYLLIS_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "amaryllis_queen"), AMARYLLIS_QUEEN);
        AmaryllisOutput.set(0, new ItemStack(item));
        AmaryllisOutput.set(1, new ItemStack(item2));
        AmaryllisCombOutput.set(0, new ItemStack(item3));
    }
}
