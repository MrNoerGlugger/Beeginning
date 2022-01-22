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

public class PrimordialBee {
    static Item item = TierCombs.MIRACULOUS_COMB;
    static Item item2 = OreCombs.PRIMORDIAL_COMB;
    static Item item3 = Items.ANCIENT_DEBRIS;
    public static final DefaultedList<ItemStack> PrimordialOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> PrimordialCombOutput = DefaultedList.ofSize(3, ItemStack.EMPTY);
    public static String[][] PrimordialMutations = {};

    public static final Item PRIMORDIAL_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item PRIMORDIAL_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item PRIMORDIAL_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerPrimordialBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "primordial_princess"), PRIMORDIAL_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "primordial_drone"), PRIMORDIAL_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "primordial_queen"), PRIMORDIAL_QUEEN);
        PrimordialOutput.set(0, new ItemStack(item));
        PrimordialOutput.set(1, new ItemStack(item2));
        PrimordialCombOutput.set(0, new ItemStack(item3));
    }
}
