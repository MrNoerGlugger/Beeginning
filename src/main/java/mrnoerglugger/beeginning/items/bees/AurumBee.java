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

public class AurumBee {
    static Item item = TierCombs.NOTEWORTHY_COMB;
    static Item item2 = OreCombs.AURUM_COMB;
    static Item item3 = Items.RAW_GOLD;
    public static final DefaultedList<ItemStack> AurumOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> AurumCombOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static String[][] AurumMutations = {{"extraordinary", "shining"}, {"extraordinary", "smaragdus"}};

    public static final Item AURUM_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item AURUM_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item AURUM_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerAurumBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "aurum_princess"), AURUM_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "aurum_drone"), AURUM_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "aurum_queen"), AURUM_QUEEN);
        AurumOutput.set(0, new ItemStack(item));
        AurumOutput.set(1, new ItemStack(item2));
        AurumCombOutput.set(0, new ItemStack(item3));
    }
}
