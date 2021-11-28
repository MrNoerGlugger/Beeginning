package mrnoerglugger.beeginning.beekeeping;

import mrnoerglugger.beeginning.blocks.blockentities.ApiaryBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class BeeEffects {
    public static void Ore_I_Fication(World world, BlockPos pos, ApiaryBlockEntity be) {
        ItemStack queen = be.getItems().get(2);
        int range = BeeFunctions.getDiameter(queen.getNbt());
        int range2 = (int) (range - 1) / 2;
        Random random = new Random();
        int x = pos.getX() + random.ints(0, range + 1).findFirst().getAsInt() - range2;
        int y = pos.getY() + random.ints(0, range + 1).findFirst().getAsInt() - range2;
        int z = pos.getZ() + random.ints(0, range + 1).findFirst().getAsInt() - range2;
        BlockPos ore = new BlockPos(x, y, z);
        Block block = world.getBlockState(ore).getBlock();
        if (Math.random() < 0.000002 * range * range * range) {
            if (block == Blocks.STONE) {
                if (Math.random() < 0.5) {
                    world.setBlockState(ore, Blocks.COAL_ORE.getDefaultState());
                }
                else if (Math.random() < 0.5) {
                    if (Math.random() < 0.5) {
                        world.setBlockState(ore, Blocks.IRON_ORE.getDefaultState());
                    }
                    else world.setBlockState(ore, Blocks.COPPER_ORE.getDefaultState());
                }
                else if (Math.random() < 0.5) {
                    if (Math.random() < 0.33) {
                        world.setBlockState(ore, Blocks.REDSTONE_ORE.getDefaultState());
                    }
                    else if (Math.random() < 0.5) {
                        world.setBlockState(ore, Blocks.GOLD_ORE.getDefaultState());
                    }
                    else world.setBlockState(ore, Blocks.LAPIS_ORE.getDefaultState());
                }
                else if (Math.random() < 0.5) {
                    if (Math.random() < 0.5) {
                        world.setBlockState(ore, Blocks.DIAMOND_ORE.getDefaultState());
                    }
                    else world.setBlockState(ore, Blocks.EMERALD_ORE.getDefaultState());
                }
            }
            if (block == Blocks.DEEPSLATE) {
                if (Math.random() < 0.5) {
                    world.setBlockState(ore, Blocks.DEEPSLATE_COAL_ORE.getDefaultState());
                }
                else if (Math.random() < 0.5) {
                    if (Math.random() < 0.5) {
                        world.setBlockState(ore, Blocks.DEEPSLATE_IRON_ORE.getDefaultState());
                    }
                    else world.setBlockState(ore, Blocks.DEEPSLATE_COPPER_ORE.getDefaultState());
                }
                else if (Math.random() < 0.5) {
                    if (Math.random() < 0.33) {
                        world.setBlockState(ore, Blocks.DEEPSLATE_REDSTONE_ORE.getDefaultState());
                    }
                    else if (Math.random() < 0.5) {
                        world.setBlockState(ore, Blocks.DEEPSLATE_GOLD_ORE.getDefaultState());
                    }
                    else world.setBlockState(ore, Blocks.DEEPSLATE_LAPIS_ORE.getDefaultState());
                }
                else if (Math.random() < 0.5) {
                    if (Math.random() < 0.5) {
                        world.setBlockState(ore, Blocks.DEEPSLATE_DIAMOND_ORE.getDefaultState());
                    }
                    else world.setBlockState(ore, Blocks.DEEPSLATE_EMERALD_ORE.getDefaultState());
                }
            }
            if (block == Blocks.NETHERRACK || block == Blocks.BLACKSTONE || block == Blocks.BASALT) {
                if (Math.random() < 0.5) {
                    world.setBlockState(ore, Blocks.GLOWSTONE.getDefaultState());
                }
                else if (Math.random() < 0.5) {
                    world.setBlockState(ore, Blocks.NETHER_QUARTZ_ORE.getDefaultState());
                }
                else if (Math.random() < 0.5) {
                    world.setBlockState(ore, Blocks.NETHER_GOLD_ORE.getDefaultState());
                }
                else if (Math.random() < 0.1) {
                    world.setBlockState(ore, Blocks.ANCIENT_DEBRIS.getDefaultState());
                }
            }
            if (block == Blocks.COAL_ORE && Math.random() < 0.1) {
                world.setBlockState(ore, Blocks.DIAMOND_ORE.getDefaultState());
            }
            if (block == Blocks.DEEPSLATE_COAL_ORE && Math.random() < 0.1) {
                world.setBlockState(ore, Blocks.DEEPSLATE_DIAMOND_ORE.getDefaultState());
            }
            if (block == Blocks.NETHER_QUARTZ_ORE && Math.random() < 0.2) {
                world.setBlockState(ore, Blocks.AMETHYST_BLOCK.getDefaultState());
            }
        }
    }
}
