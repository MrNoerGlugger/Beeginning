package mrnoerglugger.beeginning.world;

import com.mojang.serialization.Codec;
import mrnoerglugger.beeginning.items.bees.*;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class TreeHiveFeature extends Feature<DefaultFeatureConfig> {
    public TreeHiveFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        BlockPos pos = context.getOrigin();
        int i1;
        int i2;
        for (i1 = 0; i1 < 2; i1++) {
            for (i2 = 0; i2 < 2; i2++) {
                BlockPos pos2 = new BlockPos(pos.getX() + i1, pos.getY(), pos.getZ() + i2);
                if (context.getWorld().getBlockState(pos2).getBlock().getDefaultState() == Blocks.DARK_OAK_LOG.getDefaultState()) {
                    BlockPos pos3 = new BlockPos(pos2.getX(), pos2.getY() + Math.abs(java.lang.Math.random() * 4), pos2.getZ());
                    context.getWorld().setBlockState(pos3, BlockStateProvider.of(TwilightBee.TWILIGHT_HIVE).getBlockState(context.getRandom(), pos3), 3);
                    return true;
                }
                if (context.getWorld().getBlockState(pos2).getBlock().getDefaultState() == Blocks.SPRUCE_LOG.getDefaultState()) {
                    BlockPos pos3 = new BlockPos(pos2.getX(), pos2.getY() + Math.abs(java.lang.Math.random() * 4), pos2.getZ());
                    context.getWorld().setBlockState(pos3, BlockStateProvider.of(SnowingBee.SNOWING_HIVE).getBlockState(context.getRandom(), pos3), 3);
                    return true;
                }
            }
        }
        for (i1 = 0; i1 < 30; i1++) {
            BlockPos pos2 = new BlockPos(pos.getX(), pos.getY() + i1, pos.getZ());
            BlockPos pos3 = new BlockPos(pos.getX(), pos.getY() + i1 - 1, pos.getZ());
            if ((context.getWorld().getBlockState(pos2).getBlock() == Blocks.ACACIA_LEAVES) && Math.random() > 0.8) {
                context.getWorld().setBlockState(pos2, BlockStateProvider.of(BaobabBee.BAOBAB_HIVE).getBlockState(context.getRandom(), pos2), 3);
                return true;
            }
            else if ((context.getWorld().getBlockState(pos2).getBlock() == Blocks.OAK_LEAVES || context.getWorld().getBlockState(pos2).getBlock() == Blocks.JUNGLE_LEAVES) && (context.getWorld().getBiomeKey(pos2).get() == BiomeKeys.JUNGLE || context.getWorld().getBiomeKey(pos2).get() == BiomeKeys.BAMBOO_JUNGLE || context.getWorld().getBiomeKey(pos2).get() == BiomeKeys.SPARSE_JUNGLE) && Math.random() > 0.8) {
                context.getWorld().setBlockState(pos2, BlockStateProvider.of(ThicketBee.THICKET_HIVE).getBlockState(context.getRandom(), pos2), 3);
                return true;
            }
            else if ((context.getWorld().getBlockState(pos2).getBlock() == Blocks.OAK_LEAVES && context.getWorld().isAir(pos3)) && Math.random() > 0.8) {
                context.getWorld().setBlockState(pos3, BlockStateProvider.of(WoodlandBee.WOODLAND_HIVE).getBlockState(context.getRandom(), pos3), 3);
                return true;
            }
            else if ((context.getWorld().getBlockState(pos2).getBlock() == Blocks.BIRCH_LEAVES && context.getWorld().isAir(pos3)) && Math.random() > 0.8) {
                context.getWorld().setBlockState(pos3, BlockStateProvider.of(BetulaBee.BETULA_HIVE).getBlockState(context.getRandom(), pos3), 3);
                return true;
            }
            else if ((context.getWorld().getBlockState(pos2).getBlock() == Blocks.BROWN_MUSHROOM_BLOCK || context.getWorld().getBlockState(pos2).getBlock() == Blocks.RED_MUSHROOM_BLOCK)&& context.getWorld().isAir(pos3)) {
                context.getWorld().setBlockState(pos3, BlockStateProvider.of(ShroomyBee.SHROOMY_HIVE).getBlockState(context.getRandom(), pos3), 3);
                return true;
            }
        }
        return false;
    }
}