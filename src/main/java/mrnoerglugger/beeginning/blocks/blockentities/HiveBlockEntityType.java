package mrnoerglugger.beeginning.blocks.blockentities;

import mrnoerglugger.beeginning.Beeginning;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class HiveBlockEntityType extends HiveBlockEntity{
    public HiveBlockEntityType(BlockPos pos, BlockState state) {
        super(Beeginning.HIVE_BLOCK_ENTITY, pos, state);
    }
}
