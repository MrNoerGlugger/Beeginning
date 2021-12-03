package mrnoerglugger.beeginning.items.bees;

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

public class LazuriteBee {
    static Item item = TierCombs.NOTEWORTHY_COMB;
    static Item item2 = OreCombs.LAZURITE_COMB;
    static Item item3 = Items.LAPIS_LAZULI;
    public static final DefaultedList<ItemStack> LazuriteOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> LazuriteCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] LazuriteMutations = {{"extraordinary", "shining"}, {"extraordinary", "smaragdus"}};

    public static final Item LAZURITE_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item LAZURITE_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item LAZURITE_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerLazuriteBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "lazurite_princess"), LAZURITE_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "lazurite_drone"), LAZURITE_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "lazurite_queen"), LAZURITE_QUEEN);
        LazuriteOutput.set(0, new ItemStack(item));
        LazuriteOutput.set(1, new ItemStack(item2));
        LazuriteCombOutput.set(0, new ItemStack(item3, 16));
    }
}
