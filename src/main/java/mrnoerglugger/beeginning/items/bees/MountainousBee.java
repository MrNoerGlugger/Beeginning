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

public class MountainousBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.MOUNTAINOUS_COMB;
    static Item item3 = Items.STONE;
    public static final DefaultedList<ItemStack> MountainousOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> MountainousCombOutput = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static String[][] MountainousMutations = {};

    public static final Item MOUNTAINOUS_PRINCESS = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item MOUNTAINOUS_DRONE = new BeeItem(new FabricItemSettings().group(BEE_GROUP));
    public static final Item MOUNTAINOUS_QUEEN = new BeeItem(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock MOUNTAINOUS_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f), MOUNTAINOUS_QUEEN);

    public static void registerMountainousBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "mountainous_hive"), MOUNTAINOUS_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "mountainous_hive"), new BlockItem(MOUNTAINOUS_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "mountainous_princess"), MOUNTAINOUS_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "mountainous_drone"), MOUNTAINOUS_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "mountainous_queen"), MOUNTAINOUS_QUEEN);
        MountainousOutput.set(0, new ItemStack(item));
        MountainousOutput.set(1, new ItemStack(item2));
        MountainousCombOutput.set(0, new ItemStack(item3));
    }
}
