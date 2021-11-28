package mrnoerglugger.beeginning.world;

import com.mojang.serialization.Codec;
import mrnoerglugger.beeginning.items.bees.*;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class HiveFeature extends Feature<DefaultFeatureConfig> {
    public HiveFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        BlockPos pos = context.getOrigin();
        BlockPos pos2 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
        RegistryKey<Biome> key = context.getWorld().getBiomeKey(pos).get();
        BlockStateProvider block;
        if (context.getWorld().isAir(pos) && pos.getY() > 62) {
            if (((key == BiomeKeys.MEADOW) || key == BiomeKeys.FLOWER_FOREST)) {
                context.getWorld().setBlockState(pos, BlockStateProvider.of(BloomingBee.BLOOMING_HIVE).getBlockState(context.getRandom(), pos), 3);
                return true;
            }
            if (key == BiomeKeys.BEACH || key == BiomeKeys.DESERT && pos2.getY() > 63) {
                if (context.getWorld().getBlockState(pos2).getBlock() == Blocks.SAND) {
                    block = BlockStateProvider.of(Blocks.SAND);
                    if (context.getWorld().getBlockState(pos2.offset(Direction.Axis.X, 1)).isAir() || context.getWorld().getBlockState(pos2.offset(Direction.Axis.X, -1)).isAir() || context.getWorld().getBlockState(pos2.offset(Direction.Axis.Z, 1)).isAir() || context.getWorld().getBlockState(pos2.offset(Direction.Axis.Z, -1)).isAir()) {
                        pos = pos.offset(Direction.Axis.Y, -1);
                        pos2 = pos2.offset(Direction.Axis.Y, -1);
                    }
                    context.getWorld().setBlockState(pos2, BlockStateProvider.of(DryBee.DRY_HIVE).getBlockState(context.getRandom(), pos2), 3);
                    context.getWorld().setBlockState(pos, block.getBlockState(context.getRandom(), pos), 3);
                    pos = pos.offset(Direction.Axis.X, 1); context.getWorld().setBlockState(pos, block.getBlockState(context.getRandom(), pos), 3);
                    pos = pos.offset(Direction.Axis.X, -2); context.getWorld().setBlockState(pos, block.getBlockState(context.getRandom(), pos), 3);
                    pos = pos.offset(Direction.Axis.X, 1); pos = pos.offset(Direction.Axis.Z, 1); context.getWorld().setBlockState(pos, block.getBlockState(context.getRandom(), pos), 3);
                    pos = pos.offset(Direction.Axis.Z, -2); context.getWorld().setBlockState(pos, block.getBlockState(context.getRandom(), pos), 3);
                    pos = pos.offset(Direction.Axis.Y, 1); pos = pos.offset(Direction.Axis.Z, 1); context.getWorld().setBlockState(pos, block.getBlockState(context.getRandom(), pos), 3);
                    return true;
                }
            }
            if ((key == BiomeKeys.BADLANDS || key == BiomeKeys.ERODED_BADLANDS || key == BiomeKeys.WOODED_BADLANDS) && pos2.getY() > 63) {
                block = BlockStateProvider.of(context.getWorld().getBlockState(pos2).getBlock());
                if (context.getWorld().getBlockState(pos2.offset(Direction.Axis.X, 1)).isAir() || context.getWorld().getBlockState(pos2.offset(Direction.Axis.X, -1)).isAir() || context.getWorld().getBlockState(pos2.offset(Direction.Axis.Z, 1)).isAir() || context.getWorld().getBlockState(pos2.offset(Direction.Axis.Z, -1)).isAir()) {
                    pos = pos.offset(Direction.Axis.Y, -1);
                    pos2 = pos2.offset(Direction.Axis.Y, -1);
                }
                context.getWorld().setBlockState(pos2, BlockStateProvider.of(MesaBee.MESA_HIVE).getBlockState(context.getRandom(), pos2), 3);
                context.getWorld().setBlockState(pos, block.getBlockState(context.getRandom(), pos), 3);
                pos = pos.offset(Direction.Axis.X, 1);
                context.getWorld().setBlockState(pos, block.getBlockState(context.getRandom(), pos), 3);
                pos = pos.offset(Direction.Axis.X, -2);
                context.getWorld().setBlockState(pos, block.getBlockState(context.getRandom(), pos), 3);
                pos = pos.offset(Direction.Axis.X, 1);
                pos = pos.offset(Direction.Axis.Z, 1);
                context.getWorld().setBlockState(pos, block.getBlockState(context.getRandom(), pos), 3);
                pos = pos.offset(Direction.Axis.Z, -2);
                context.getWorld().setBlockState(pos, block.getBlockState(context.getRandom(), pos), 3);
                pos = pos.offset(Direction.Axis.Y, 1);
                pos = pos.offset(Direction.Axis.Z, 1);
                context.getWorld().setBlockState(pos, block.getBlockState(context.getRandom(), pos), 3);
                return true;
            }
            if (key == BiomeKeys.PLAINS) {
                context.getWorld().setBlockState(pos, BlockStateProvider.of(PlainBee.PLAIN_HIVE).getBlockState(context.getRandom(), pos), 3);
                return true;
            }
            if (key == BiomeKeys.SAVANNA || key == BiomeKeys.SAVANNA_PLATEAU || key == BiomeKeys.WINDSWEPT_SAVANNA) {
                context.getWorld().setBlockState(pos, BlockStateProvider.of(BaobabBee.BAOBAB_HIVE).getBlockState(context.getRandom(), pos), 3);
                return true;
            }
            if ((key == BiomeKeys.STONY_PEAKS || key == BiomeKeys.STONY_SHORE || key == BiomeKeys.WINDSWEPT_HILLS || key == BiomeKeys.WINDSWEPT_GRAVELLY_HILLS) && context.getWorld().getBlockState(pos2).getBlock() == Blocks.STONE) {
                context.getWorld().setBlockState(pos2, BlockStateProvider.of(MountainousBee.MOUNTAINOUS_HIVE).getBlockState(context.getRandom(), pos2), 3);
                return true;
            }
        }
        else if (pos.getY() < 63 && context.getWorld().isWater(pos)) {
            if (key == BiomeKeys.SWAMP) {
                context.getWorld().setBlockState(pos, BlockStateProvider.of(MorassBee.MORASS_HIVE).getBlockState(context.getRandom(), pos), 3);
                return true;
            }
            if (key == BiomeKeys.RIVER || key == BiomeKeys.FROZEN_RIVER || key == BiomeKeys.OCEAN || key == BiomeKeys.DEEP_OCEAN || key == BiomeKeys.FROZEN_OCEAN || key == BiomeKeys.DEEP_FROZEN_OCEAN || key == BiomeKeys.COLD_OCEAN || key == BiomeKeys.DEEP_COLD_OCEAN || key == BiomeKeys.LUKEWARM_OCEAN || key == BiomeKeys.DEEP_LUKEWARM_OCEAN || key == BiomeKeys.WARM_OCEAN) {
                context.getWorld().setBlockState(pos, BlockStateProvider.of(SeaBee.SEA_HIVE).getBlockState(context.getRandom(), pos), 3);
                return true;
            }
        }
        if ((key == BiomeKeys.FROZEN_PEAKS || key == BiomeKeys.SNOWY_BEACH || key == BiomeKeys.SNOWY_PLAINS || key == BiomeKeys.SNOWY_SLOPES || key == BiomeKeys.SNOWY_TAIGA || key == BiomeKeys.ICE_SPIKES || key == BiomeKeys.GROVE || key == BiomeKeys.JAGGED_PEAKS) && pos.getY() > 62) {
            context.getWorld().setBlockState(pos2, BlockStateProvider.of(FreezingBee.FREEZING_HIVE).getBlockState(context.getRandom(), pos2), 3);
            context.getWorld().setBlockState(pos, BlockStateProvider.of(Blocks.BLUE_ICE).getBlockState(context.getRandom(), pos), 3);
            return true;
        }
        return false;
    }
}