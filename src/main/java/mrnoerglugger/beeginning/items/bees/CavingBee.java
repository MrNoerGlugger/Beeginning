package mrnoerglugger.beeginning.items.bees;

import mrnoerglugger.beeginning.blocks.HiveBlock;
import mrnoerglugger.beeginning.items.BeeItem;
import mrnoerglugger.beeginning.items.combs.BaseCombs;
import mrnoerglugger.beeginning.items.combs.TierCombs;
import mrnoerglugger.beeginning.tags.ItemTags;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

import static mrnoerglugger.beeginning.Beeginning.*;

public class CavingBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.CAVING_COMB;
    static Item item3 = Items.DEEPSLATE;
    public static final DefaultedList<ItemStack> CavingOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> CavingCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] CavingMutations = {{"ordinary", "carbo"}};

    public static final Item CAVING_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item CAVING_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item CAVING_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock CAVING_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f), CAVING_QUEEN);

    public static void registerCavingBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "caving_hive"), CAVING_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "caving_hive"), new BlockItem(CAVING_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "caving_princess"), CAVING_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "caving_drone"), CAVING_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "caving_queen"), CAVING_QUEEN);
        CavingOutput.set(0, new ItemStack(item));
        CavingOutput.set(1, new ItemStack(item2));
        CavingCombOutput.set(0, new ItemStack(item3));
    }
}
