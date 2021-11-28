package mrnoerglugger.beeginning.blocks.blockentities;

import mrnoerglugger.beeginning.Beeginning;
import net.minecraft.block.BlockState;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class ApiaryBlockEntityType extends ApiaryBlockEntity{
    public ApiaryBlockEntityType(BlockPos pos, BlockState state) {
        super(Beeginning.APIARY_BLOCK_ENTITY, pos, state);
    }
    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }
}
