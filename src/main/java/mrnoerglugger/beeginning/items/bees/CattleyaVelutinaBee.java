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

public class CattleyaVelutinaBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.CATTLEYA_VELUTINA_COMB;
    static Item item3 = Items.BROWN_DYE;
    public static final DefaultedList<ItemStack> CattleyaVelutinaOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> CattleyaVelutinaCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] CattleyaVelutinaMutations = {{"advanced", "rainbow"}};

    public static final Item CATTLEYA_VELUTINA_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item CATTLEYA_VELUTINA_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item CATTLEYA_VELUTINA_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerCattleyaVelutinaBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "cattleya_velutina_princess"), CATTLEYA_VELUTINA_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "cattleya_velutina_drone"), CATTLEYA_VELUTINA_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "cattleya_velutina_queen"), CATTLEYA_VELUTINA_QUEEN);
        CattleyaVelutinaOutput.set(0, new ItemStack(item));
        CattleyaVelutinaOutput.set(1, new ItemStack(item2));
        CattleyaVelutinaCombOutput.set(0, new ItemStack(item3));
    }
}
