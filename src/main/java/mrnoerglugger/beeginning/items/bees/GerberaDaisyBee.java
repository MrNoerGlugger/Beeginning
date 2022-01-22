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

public class GerberaDaisyBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.GERBERA_DAISY_COMB;
    static Item item3 = Items.GREEN_DYE;
    public static final DefaultedList<ItemStack> GerberaDaisyOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> GerberaDaisyCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] GerberaDaisyMutations = {{"advanced", "rainbow"}};

    public static final Item GERBERA_DAISY_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item GERBERA_DAISY_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item GERBERA_DAISY_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerGerberaDaisyBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "gerbera_daisy_princess"), GERBERA_DAISY_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "gerbera_daisy_drone"), GERBERA_DAISY_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "gerbera_daisy_queen"), GERBERA_DAISY_QUEEN);
        GerberaDaisyOutput.set(0, new ItemStack(item));
        GerberaDaisyOutput.set(1, new ItemStack(item2));
        GerberaDaisyCombOutput.set(0, new ItemStack(item3));
    }
}
