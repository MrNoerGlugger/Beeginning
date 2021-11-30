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

public class QueenOfTheNightTulipBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = DyeCombs.QUEEN_OF_THE_NIGHT_TULIP_COMB;
    static Item item3 = Items.BLACK_DYE;
    public static final DefaultedList<ItemStack> QueenOfTheNightTulipOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> QueenOfTheNightTulipCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] QueenOfTheNightTulipMutations = {{"advanced", "rainbow"}};

    public static final Item QUEEN_OF_THE_NIGHT_TULIP_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item QUEEN_OF_THE_NIGHT_TULIP_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item QUEEN_OF_THE_NIGHT_TULIP_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerQueenOfTheNightTulipBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "queen_of_the_night_tulip_princess"), QUEEN_OF_THE_NIGHT_TULIP_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "queen_of_the_night_tulip_drone"), QUEEN_OF_THE_NIGHT_TULIP_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "queen_of_the_night_tulip_queen"), QUEEN_OF_THE_NIGHT_TULIP_QUEEN);
        QueenOfTheNightTulipOutput.set(0, new ItemStack(item));
        QueenOfTheNightTulipOutput.set(1, new ItemStack(item2));
        QueenOfTheNightTulipCombOutput.set(0, new ItemStack(item3));
    }
}
