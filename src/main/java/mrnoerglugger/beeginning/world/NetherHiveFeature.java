package mrnoerglugger.beeginning.world;

import com.mojang.serialization.Codec;
import mrnoerglugger.beeginning.items.bees.*;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.Random;

public class NetherHiveFeature extends Feature<DefaultFeatureConfig> {
    public NetherHiveFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();
        StructureWorldAccess world = context.getWorld();
        RegistryKey<Biome> key = context.getWorld().getBiomeKey(pos).get();
        BlockPos pos2 = new BlockPos(pos.getX(), Math.abs(Math.random() * 128), pos.getZ());
        if (key == BiomeKeys.NETHER_WASTES && world.getBlockState(pos2).getBlock() == Blocks.NETHERRACK) {
            world.setBlockState(pos2, BlockStateProvider.of(WastingBee.WASTING_HIVE).getBlockState(random, pos2), 3);
            return true;
        }
        else if (key == BiomeKeys.SOUL_SAND_VALLEY && (world.getBlockState(pos2).getBlock() == Blocks.SOUL_SAND || world.getBlockState(pos2).getBlock() == Blocks.SOUL_SOIL)) {
            world.setBlockState(pos2, BlockStateProvider.of(ValleyBee.VALLEY_HIVE).getBlockState(random, pos2), 3);
            return true;
        }
        else if (key == BiomeKeys.BASALT_DELTAS && world.getBlockState(pos2).getBlock() == Blocks.BASALT) {
            world.setBlockState(pos2, BlockStateProvider.of(DeltaBee.DELTA_HIVE).getBlockState(random, pos2), 3);
            return true;
        }
        else if (key == BiomeKeys.WARPED_FOREST && world.getBlockState(pos2).getBlock() == Blocks.WARPED_WART_BLOCK) {
            world.setBlockState(pos2, BlockStateProvider.of(WarpedBee.WARPED_HIVE).getBlockState(random, pos2), 3);
            return true;
        }
        else if (key == BiomeKeys.CRIMSON_FOREST && world.getBlockState(pos2).getBlock() == Blocks.NETHER_WART_BLOCK) {
            world.setBlockState(pos2, BlockStateProvider.of(CrimsonBee.CRIMSON_HIVE).getBlockState(random, pos2), 3);
            return true;
        }
        else return false;
    }
}
