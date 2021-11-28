package mrnoerglugger.beeginning.world;

import com.mojang.serialization.Codec;
import mrnoerglugger.beeginning.items.bees.FinalisBee;
import mrnoerglugger.beeginning.items.bees.VoidBee;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class EndHiveFeature extends Feature<DefaultFeatureConfig> {
    public EndHiveFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        BlockPos pos = context.getOrigin();
        BlockPos pos2 = new BlockPos(pos.getX(), pos.getY() + 60 + Math.abs(Math.random() * 60), pos.getZ());
        StructureWorldAccess world = context.getWorld();
        BlockStateProvider block = BlockStateProvider.of(Blocks.OBSIDIAN);
        if (java.lang.Math.random() > 0.5) {
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.Y, 1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.Y, 1);
            world.setBlockState(pos2, BlockStateProvider.of(VoidBee.VOID_HIVE).getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.Y, 1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.Y, 1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.Y, -3);
            pos2 = pos2.offset(Direction.Axis.X, -1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.X, 2);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.X, -1);
            pos2 = pos2.offset(Direction.Axis.Z, -1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.Z, 2);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.Y, 1);
            pos2 = pos2.offset(Direction.Axis.Z, 1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.Z, -1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.X, -1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.X, 2);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.Z, -1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.X, 1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.X, -3);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.X, -1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.X, 1);
            pos2 = pos2.offset(Direction.Axis.Z, -1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.X, 1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.X, 1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.X, -1);
            pos2 = pos2.offset(Direction.Axis.Z, -1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.Y, 1);
            pos2 = pos2.offset(Direction.Axis.Z, 1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.Z, 2);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.X, -1);
            pos2 = pos2.offset(Direction.Axis.Z, -1);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
            pos2 = pos2.offset(Direction.Axis.X, 2);
            world.setBlockState(pos2, block.getBlockState(context.getRandom(), pos2), 3);
        }
        else {
            world.setBlockState(pos, BlockStateProvider.of(FinalisBee.FINALIS_HIVE).getBlockState(context.getRandom(), pos), 3);
        }
        return true;
    }
}

