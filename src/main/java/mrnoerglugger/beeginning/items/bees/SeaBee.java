package mrnoerglugger.beeginning.items.bees;

import mrnoerglugger.beeginning.blocks.HiveBlock;
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

public class SeaBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.SEA_COMB;
    static Item item3 = Items.SEAGRASS;
    public static final DefaultedList<ItemStack> SeaOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> SeaCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] SeaMutations = {};

    public static final Item SEA_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item SEA_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item SEA_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock SEA_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).breakByTool(ItemTags.SCOOP_NETS).requiresTool().strength(1.5f));;

    public static void registerSeaBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "sea_hive"), SEA_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "sea_hive"), new BlockItem(SEA_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));//
        Registry.register(Registry.ITEM, new Identifier(MODID, "sea_princess"), SEA_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "sea_drone"), SEA_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "sea_queen"), SEA_QUEEN);
        SeaOutput.set(0, new ItemStack(item));
        SeaOutput.set(1, new ItemStack(item2));
        SeaCombOutput.set(0, new ItemStack(item3));
    }
}
