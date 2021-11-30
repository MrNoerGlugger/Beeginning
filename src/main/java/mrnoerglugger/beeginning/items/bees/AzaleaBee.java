package mrnoerglugger.beeginning.items.bees;

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

public class AzaleaBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.AZALEA_COMB;
    static Item item3 = Items.PINK_DYE;
    public static final DefaultedList<ItemStack> AzaleaOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> AzaleaCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] AzaleaMutations = {{"advanced", "rainbow"}};

    public static final Item AZALEA_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item AZALEA_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item AZALEA_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerAzaleaBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "azalea_princess"), AZALEA_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "azalea_drone"), AZALEA_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "azalea_queen"), AZALEA_QUEEN);
        AzaleaOutput.set(0, new ItemStack(item));
        AzaleaOutput.set(1, new ItemStack(item2));
        AzaleaCombOutput.set(0, new ItemStack(item3));
    }
}
