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

public class BellsOfIrelandBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.BELLS_OF_IRELAND_COMB;
    static Item item3 = Items.LIME_DYE;
    public static final DefaultedList<ItemStack> BellsOfIrelandOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> BellsOfIrelandCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] BellsOfIrelandMutations = {{"advanced", "rainbow"}};

    public static final Item BELLS_OF_IRELAND_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item BELLS_OF_IRELAND_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item BELLS_OF_IRELAND_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerBellsOfIrelandBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "bells_of_ireland_princess"), BELLS_OF_IRELAND_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "bells_of_ireland_drone"), BELLS_OF_IRELAND_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "bells_of_ireland_queen"), BELLS_OF_IRELAND_QUEEN);
        BellsOfIrelandOutput.set(0, new ItemStack(item));
        BellsOfIrelandOutput.set(1, new ItemStack(item2));
        BellsOfIrelandCombOutput.set(0, new ItemStack(item3));
    }
}
