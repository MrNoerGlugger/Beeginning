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

public class MesaBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.MESA_COMB;
    static Item item3 = Items.TERRACOTTA;
    public static final DefaultedList<ItemStack> MesaOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> MesaCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] MesaMutations = {};

    public static final Item MESA_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item MESA_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item MESA_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock MESA_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f), MESA_QUEEN);

    public static void registerMesaBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "mesa_hive"), MESA_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "mesa_hive"), new BlockItem(MESA_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "mesa_princess"), MESA_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "mesa_drone"), MESA_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "mesa_queen"), MESA_QUEEN);
        MesaOutput.set(0, new ItemStack(item));
        MesaOutput.set(1, new ItemStack(item2));
        MesaCombOutput.set(0, new ItemStack(item3));
    }
}
