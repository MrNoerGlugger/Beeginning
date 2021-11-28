package mrnoerglugger.beeginning.items.combs;

import mrnoerglugger.beeginning.Beeginning;
import mrnoerglugger.beeginning.items.HoneyDrops;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

import static mrnoerglugger.beeginning.Beeginning.*;

public class TierCombs {
    static Item item = HoneyDrops.HONEY_DROP;
    static Item item2 = HoneyDrops.ORDINARY_DROP;
    public static final DefaultedList<ItemStack> baseCombOutput = DefaultedList.ofSize(4, ItemStack.EMPTY);
    public static final Item BASE_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item ORDINARY_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item ADVANCED_COMB = new Item(new FabricItemSettings().group(Beeginning.COMB_GROUP));
    public static final Item NOTEWORTHY_COMB = new Item(new FabricItemSettings().group(COMB_GROUP));
    public static final Item EXTRAORDINARY_COMB = new Item(new FabricItemSettings().group(COMB_GROUP));
    public static final Item MIRACULOUS_COMB = new Item(new FabricItemSettings().group(COMB_GROUP));

    public static void registerTierCombs() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "base_comb"), BASE_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "ordinary_comb"), ORDINARY_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "advanced_comb"), ADVANCED_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "noteworthy_comb"), NOTEWORTHY_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "extraordinary_comb"), EXTRAORDINARY_COMB);
        Registry.register(Registry.ITEM, new Identifier(MODID, "miraculous_comb"), MIRACULOUS_COMB);
        baseCombOutput.set(0, new ItemStack(item));
        baseCombOutput.set(1, new ItemStack(item));
        baseCombOutput.set(2, new ItemStack(item));
        baseCombOutput.set(3, new ItemStack(item2));
    }
}
