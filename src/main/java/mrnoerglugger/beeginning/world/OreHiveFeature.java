package mrnoerglugger.beeginning.world;

import com.mojang.serialization.Codec;
import mrnoerglugger.beeginning.items.bees.CavingBee;
import mrnoerglugger.beeginning.items.bees.MesaBee;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.Random;

public class OreHiveFeature extends Feature<DefaultFeatureConfig> {
    public OreHiveFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        BlockPos pos = context.getOrigin();
        Random random = new Random();
        pos = new BlockPos(pos.getX() + (int)(Math.random() * 16), (int)(Math.random() * -64), pos.getZ() + (int)(Math.random() * 16));
        if (OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES.test(context.getWorld().getBlockState(pos), random) && (context.getWorld().getBlockState(pos.offset(Direction.Axis.X, 1)).isAir() || context.getWorld().getBlockState(pos.offset(Direction.Axis.X, -1)).isAir() || context.getWorld().getBlockState(pos.offset(Direction.Axis.Y, 1)).isAir() || context.getWorld().getBlockState(pos.offset(Direction.Axis.Y, -1)).isAir() || context.getWorld().getBlockState(pos.offset(Direction.Axis.Z, 1)).isAir() || context.getWorld().getBlockState(pos.offset(Direction.Axis.Z, -1)).isAir())) {
            context.getWorld().setBlockState(pos, BlockStateProvider.of(CavingBee.CAVING_HIVE).getBlockState(context.getRandom(), pos), 3);
            return true;
        }
        return false;
    }
}
