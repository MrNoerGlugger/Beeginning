package mrnoerglugger.beeginning.items;

import mrnoerglugger.beeginning.tags.BlockTags;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;

public class ScoopItem extends MiningToolItem {
    protected ScoopItem(ToolMaterial toolMaterial, int i, float f, Item.Settings settings) {
        super((float)i, f, toolMaterial, BlockTags.SCOOP_NET_MINEABLE, settings);
    }
}
