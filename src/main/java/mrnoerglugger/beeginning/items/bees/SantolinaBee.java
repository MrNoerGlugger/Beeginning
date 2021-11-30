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

public class SantolinaBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.SANTOLINA_COMB;
    static Item item3 = Items.GRAY_DYE;
    public static final DefaultedList<ItemStack> SantolinaOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> SantolinaCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] SantolinaMutations = {{"advanced", "rainbow"}};

    public static final Item SANTOLINA_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item SANTOLINA_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item SANTOLINA_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerSantolinaBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "santolina_princess"), SANTOLINA_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "santolina_drone"), SANTOLINA_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "santolina_queen"), SANTOLINA_QUEEN);
        SantolinaOutput.set(0, new ItemStack(item));
        SantolinaOutput.set(1, new ItemStack(item2));
        SantolinaCombOutput.set(0, new ItemStack(item3));
    }
}
