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

public class CrystalBee {
    static Item item = TierCombs.NOTEWORTHY_COMB;
    static Item item2 = OreCombs.CRYSTAL_COMB;
    static Item item3 = Items.AMETHYST_SHARD;
    static Item item4 = Items.AMETHYST_BLOCK;
    public static final DefaultedList<ItemStack> CrystalOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> CrystalCombOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static String[][] CrystalMutations = {{"extraordinary", "shining"}, {"extraordinary", "smaragdus"}};

    public static final Item CRYSTAL_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item CRYSTAL_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item CRYSTAL_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));

    public static void registerCrystalBee() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "crystal_princess"), CRYSTAL_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "crystal_drone"), CRYSTAL_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "crystal_queen"), CRYSTAL_QUEEN);
        CrystalOutput.set(0, new ItemStack(item));
        CrystalOutput.set(1, new ItemStack(item2));
        CrystalCombOutput.set(0, new ItemStack(item3));
        CrystalCombOutput.set(1, new ItemStack(item4));
    }
}
