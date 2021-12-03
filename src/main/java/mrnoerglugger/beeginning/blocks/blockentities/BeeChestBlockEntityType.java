package mrnoerglugger.beeginning.blocks.blockentities;

import mrnoerglugger.beeginning.Beeginning;
import net.minecraft.block.BlockState;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class BeeChestBlockEntityType extends BeeChestBlockEntity{
    public BeeChestBlockEntityType(BlockPos pos, BlockState state) {
        super(Beeginning.BEE_CHEST_BLOCK_ENTITY, pos, state);
    }
    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }
}
