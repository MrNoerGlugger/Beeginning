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

public class SmaragdusBee {
    static Item item = TierCombs.EXTRAORDINARY_COMB;
    static Item item2 = OreCombs.SMARAGDUS_COMB;
    static Item item3 = Items.EMERALD;
    public static final DefaultedList<ItemStack> SmaragdusOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> SmaragdusCombOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static String[][] SmaragdusMutations = {};

    public static final Item SMARAGDUS_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item SMARAGDUS_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item SMARAGDUS_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerSmaragdusBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "smaragdus_princess"), SMARAGDUS_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "smaragdus_drone"), SMARAGDUS_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "smaragdus_queen"), SMARAGDUS_QUEEN);
        SmaragdusOutput.set(0, new ItemStack(item));
        SmaragdusOutput.set(1, new ItemStack(item2));
        SmaragdusCombOutput.set(0, new ItemStack(item3));
    }
}
