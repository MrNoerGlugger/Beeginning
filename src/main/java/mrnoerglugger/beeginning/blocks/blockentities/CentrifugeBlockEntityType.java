package mrnoerglugger.beeginning.blocks.blockentities;

import mrnoerglugger.beeginning.Beeginning;
import net.minecraft.block.BlockState;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class CentrifugeBlockEntityType extends CentrifugeBlockEntity{
    public CentrifugeBlockEntityType(BlockPos blockPos, BlockState blockState) {
        super(Beeginning.CENTRIFUGE_BLOCK_ENTITY, blockPos, blockState);
    }
    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }
}
