package mrnoerglugger.beeginning.beekeeping;

import mrnoerglugger.beeginning.blocks.blockentities.ApiaryBlockEntity;
import net.minecraft.block.BlastFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.system.CallbackI;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Random;

public class BeeEffects {
    private static final Block[] woolTypes = {Blocks.WHITE_WOOL, Blocks.ORANGE_WOOL, Blocks.MAGENTA_WOOL, Blocks.LIGHT_BLUE_WOOL, Blocks.YELLOW_WOOL, Blocks.LIME_WOOL, Blocks.PINK_WOOL, Blocks.GRAY_WOOL, Blocks.LIGHT_GRAY_WOOL, Blocks.CYAN_WOOL, Blocks.PURPLE_WOOL, Blocks.BLUE_WOOL, Blocks.BROWN_WOOL, Blocks.GREEN_WOOL, Blocks.RED_WOOL, Blocks.BLACK_WOOL};
    private static final Block[] glassTypes = {Blocks.WHITE_STAINED_GLASS, Blocks.ORANGE_STAINED_GLASS, Blocks.MAGENTA_STAINED_GLASS, Blocks.LIGHT_BLUE_STAINED_GLASS, Blocks.YELLOW_STAINED_GLASS, Blocks.LIME_STAINED_GLASS, Blocks.PINK_STAINED_GLASS, Blocks.GRAY_STAINED_GLASS, Blocks.LIGHT_GRAY_STAINED_GLASS, Blocks.CYAN_STAINED_GLASS, Blocks.PURPLE_STAINED_GLASS, Blocks.BLUE_STAINED_GLASS, Blocks.BROWN_STAINED_GLASS, Blocks.GREEN_STAINED_GLASS, Blocks.RED_STAINED_GLASS, Blocks.BLACK_STAINED_GLASS};
    private static final Block[] glassPanesTypes = {Blocks.WHITE_STAINED_GLASS_PANE, Blocks.ORANGE_STAINED_GLASS_PANE, Blocks.MAGENTA_STAINED_GLASS_PANE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, Blocks.YELLOW_STAINED_GLASS_PANE, Blocks.LIME_STAINED_GLASS_PANE, Blocks.PINK_STAINED_GLASS_PANE, Blocks.GRAY_STAINED_GLASS_PANE, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, Blocks.CYAN_STAINED_GLASS_PANE, Blocks.PURPLE_STAINED_GLASS_PANE, Blocks.BLUE_STAINED_GLASS_PANE, Blocks.BROWN_STAINED_GLASS_PANE, Blocks.GREEN_STAINED_GLASS_PANE, Blocks.RED_STAINED_GLASS_PANE, Blocks.BLACK_STAINED_GLASS_PANE};
    private static final Block[] terracottaTypes = {Blocks.WHITE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.PINK_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.BLACK_TERRACOTTA};

    public static void Ore_I_Fication(World world, BlockPos pos, ApiaryBlockEntity be) {
        ItemStack queen = be.getItems().get(2);
        int range = BeeFunctions.getDiameter(queen.getNbt());
        int range2 = (int) (range - 1) / 2;
        Random random = new Random();
        int x = pos.getX() + random.ints(0, range).findFirst().getAsInt() - range2;
        int y = pos.getY() + random.ints(0, range).findFirst().getAsInt() - range2;
        int z = pos.getZ() + random.ints(0, range).findFirst().getAsInt() - range2;
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

    public static void Coloring(World world, BlockPos pos, ApiaryBlockEntity be) {
        ItemStack queen = be.getItems().get(2);
        int range = BeeFunctions.getDiameter(queen.getNbt());
        int range2 = (int) (range - 1) / 2;
        Random random = new Random();
        int x = pos.getX() + random.ints(0, range).findFirst().getAsInt() - range2;
        int y = pos.getY() + random.ints(0, range).findFirst().getAsInt() - range2;
        int z = pos.getZ() + random.ints(0, range).findFirst().getAsInt() - range2;
        BlockPos dye = new BlockPos(x, y, z);
        Block block = world.getBlockState(dye).getBlock();
        int color = BeeFunctions.getColor(queen.getNbt());
        if (Math.random() < 0.000002 * range * range * range) {
            if (block == Blocks.WHITE_WOOL || block == Blocks.ORANGE_WOOL || block == Blocks.MAGENTA_WOOL || block == Blocks.LIGHT_BLUE_WOOL || block == Blocks.YELLOW_WOOL || block == Blocks.LIME_WOOL || block == Blocks.PINK_WOOL || block == Blocks.GRAY_WOOL || block == Blocks.LIGHT_GRAY_WOOL || block == Blocks.CYAN_WOOL || block == Blocks.PURPLE_WOOL || block == Blocks.BLUE_WOOL || block == Blocks.BROWN_WOOL || block == Blocks.GREEN_WOOL || block == Blocks.RED_WOOL || block == Blocks.BLACK_WOOL) {
                if (color != 16) {
                    world.setBlockState(dye, woolTypes[color].getDefaultState());
                }
                else {
                    world.setBlockState(dye, woolTypes[random.ints(0, 16).findFirst().getAsInt()].getDefaultState());
                }
            }
            if (block == Blocks.GLASS) {
                if (color != 16) {
                    world.setBlockState(dye, glassTypes[color].getDefaultState());
                }
                else {
                    world.setBlockState(dye, glassTypes[random.ints(0, 16).findFirst().getAsInt()].getDefaultState());
                }
            }
            if (block == Blocks.GLASS_PANE) {
                if (color != 16) {
                    world.setBlockState(dye, glassPanesTypes[color].getDefaultState());
                }
                else {
                    world.setBlockState(dye, glassPanesTypes[random.ints(0, 16).findFirst().getAsInt()].getDefaultState());
                }
            }
            if (block == Blocks.TERRACOTTA) {
                if (color != 16) {
                    world.setBlockState(dye, terracottaTypes[color].getDefaultState());
                }
                else {
                    world.setBlockState(dye, terracottaTypes[random.ints(0, 16).findFirst().getAsInt()].getDefaultState());
                }
            }
        }
    }

    public static void SpawnMobs(World world, BlockPos pos, ApiaryBlockEntity be) {
    }
}
