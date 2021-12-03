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

public class DryBee {
    static Item item = TierCombs.BASE_COMB;
    static Item item2 = BaseCombs.DRY_COMB;
    static Item item3 = Items.SAND;
    static Item item4 = Items.CACTUS;
    public static final DefaultedList<ItemStack> DryOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final DefaultedList<ItemStack> DryCombOutput = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static String[][] DryMutations = {};

    public static final Item DRY_PRINCESS = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP));
    public static final Item DRY_DRONE = new Item(new FabricItemSettings().group(BEE_GROUP));
    public static final Item DRY_QUEEN = new Item(new FabricItemSettings().maxCount(1).group(BEE_GROUP).maxDamage(2000));
    public static final HiveBlock DRY_HIVE = new HiveBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).requiresTool().strength(1.5f), DRY_QUEEN);

    public static void registerDryBee() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "dry_hive"), DRY_HIVE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "dry_hive"), new BlockItem(DRY_HIVE, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MODID, "dry_princess"), DRY_PRINCESS);
        Registry.register(Registry.ITEM, new Identifier(MODID, "dry_drone"), DRY_DRONE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "dry_queen"), DRY_QUEEN);
        DryOutput.set(0, new ItemStack(item));
        DryOutput.set(1, new ItemStack(item2));
        DryCombOutput.set(0, new ItemStack(item3, 2));
        DryCombOutput.set(1, new ItemStack(item4, 2));
    }
}
