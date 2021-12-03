package mrnoerglugger.beeginning.beekeeping;

import mrnoerglugger.beeginning.items.combs.TierCombs;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.system.CallbackI;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BeeFunctions {
    public BeeFunctions() {
    }
    static DefaultedList<ItemStack> base_comb = TierCombs.baseCombOutput;

    public static String[] species;
    public static double[] lifespan = {0.3, 0.5, 0.7, 1, 1.5, 2, 3};
    public static double[] production = {0.5, 0.7, 0.9, 1, 1.1, 1.3, 1.5};
    public static int[] drones = {1, 2, 3, 4};
    static Block[][] flowerBlocks = {{null}, {Blocks.CACTUS}, {Blocks.SNOW_BLOCK, Blocks.SNOW_BLOCK, Blocks.POWDER_SNOW}, {Blocks.SOUL_SAND, Blocks.SOUL_SOIL}, {Blocks.CHORUS_FLOWER, Blocks.CHORUS_PLANT}, {Blocks.AMETHYST_BLOCK}, {Blocks.ANCIENT_DEBRIS}};
    static Tag<Block>[][] flowerTags = new Tag[][]{{null}, {BlockTags.FLOWERS}, {BlockTags.LOGS}, {BlockTags.BASE_STONE_OVERWORLD}, {BlockTags.BASE_STONE_NETHER}, {BlockTags.COAL_ORES, BlockTags.COPPER_ORES, BlockTags.GOLD_ORES, BlockTags.IRON_ORES, BlockTags.DIAMOND_ORES, BlockTags.EMERALD_ORES, BlockTags.LAPIS_ORES, BlockTags.REDSTONE_ORES}};
    public static int[][] AoE = {{7, 7, 7}, {11, 11, 11}, {15, 15, 15}, {19, 19, 19}, {25, 25, 25}};
    static boolean[] time = {false, true};
    static boolean[] framing = {false, true};
    public static int[] temperature = {-20, -10, 0, 10, 20, 30, 40};
    public static int[] downfall = {0, 20, 50, 80, 100};
    public static int[][] temperatureTolerance = {{0, 0}, {-19, 0}, {0, 19}, {-19, 19}, {-60, 0}, {-60, 19}, {0, 60}, {-19, 60}, {-60, 60}};
    public static int[][] downfallTolerance = {{0, 0}, {-100, 0}, {0, 100}, {-100, 100}};

    static int[][] defaultValues;
    static Item[] QueenList;
    static Item[] PrincessList;
    static Item[] DroneList;
    static DefaultedList[] OutputList;
    static DefaultedList[] CombOutputList;
    static int[][][] MutationList;
    static double[] MutationChance;
    static int[] effectArray;
    public static String[] effectStrings;

    static int[][] values;

    public static void registerBeeValues() {
        species = BeeDefaultValues.species;
        defaultValues = BeeDefaultValues.defaultValues;
        QueenList = BeeDefaultValues.Queens;
        PrincessList = BeeDefaultValues.Princesses;
        DroneList = BeeDefaultValues.Drones;
        OutputList = BeeDefaultValues.Outputs;
        CombOutputList = BeeDefaultValues.CombOutputs;
        MutationList = BeeDefaultValues.MutationList;
        MutationChance = BeeDefaultValues.MutationChance;
        effectArray = BeeDefaultValues.effectArray;
        effectStrings = BeeDefaultValues.effectStrings;
    }

    public static ItemStack setPrincessValues(ItemStack itemStack) {
        NbtCompound nbt = new NbtCompound();
        String speciesName = itemStack.getItem().asItem().toString();
        int index = 0;
        for (int i = 0; i < species.length; i++) {
            if(speciesName.equals(species[i] + "_princess")) {
                index = i; break;
            }
        }
        nbt.putIntArray("princess", defaultValues[index]);
        nbt.putIntArray("princess_inactive", defaultValues[index]);
        itemStack.setNbt(nbt);
        return itemStack;
    }
    public static ItemStack setDroneValues(ItemStack itemStack) {
        NbtCompound nbt = new NbtCompound();
        String speciesName = itemStack.getItem().asItem().toString();
        int index = 0;
        for (int i = 0; i < species.length; i++) {
            if(speciesName.equals(species[i] + "_drone")) {
                index = i; break;
            }
        }
        nbt.putIntArray("drone", defaultValues[index]);
        nbt.putIntArray("drone_inactive", defaultValues[index]);
        itemStack.setNbt(nbt);
        return itemStack;
    }
    public static ItemStack setQueenValues(ItemStack itemStack, int[] i1, int[] i2, int[] i3, int[] i4) {
        NbtCompound nbt = new NbtCompound();
        nbt.putInt("Damage", itemStack.getDamage());
        nbt.putIntArray("princess", i1);
        nbt.putIntArray("princess_inactive", i2);
        nbt.putIntArray("drone", i3);
        nbt.putIntArray("drone_inactive", i4);
        int[][] ii1 = getPrincessIntArrayArray(nbt);
        nbt.putIntArray("princess_descendant", ii1[0]);
        nbt.putIntArray("princess_descendant_inactive", ii1[1]);
        int i;
        for (i = 0; i < drones[i1[3]]; ++i) {
            int[][] ii2 = getDroneIntArrayArray(nbt);
            nbt.putIntArray("drone_descendant" + i, ii2[0]);
            nbt.putIntArray("drone_descendant" + i + "_inactive", ii2[1]);
        }
        itemStack.setNbt(nbt);
        return itemStack;
    }
    public static ItemStack setDefaultQueenValues(ItemStack itemStack) {
        NbtCompound nbt = new NbtCompound();
        String speciesName = itemStack.getItem().asItem().toString();
        int index = 0;
        for (int i = 0; i < species.length; i++) {
            if(speciesName.equals(species[i] + "_queen")) {
                index = i; break;
            }
        }
        nbt.putIntArray("princess", defaultValues[index]);
        nbt.putIntArray("princess_inactive", defaultValues[index]);
        nbt.putIntArray("drone", defaultValues[index]);
        nbt.putIntArray("drone_inactive", defaultValues[index]);
        nbt.putIntArray("princess_descendant", getPrincessIntArrayArray(nbt)[0]);
        nbt.putIntArray("princess_descendant_inactive", getPrincessIntArrayArray(nbt)[1]);
        int i;
        for (i = 0; i < drones[nbt.getIntArray("princess")[3]]; ++i) {
            nbt.putIntArray("drone_descendant" + i, getDroneIntArrayArray(nbt)[0]);
            nbt.putIntArray("drone_descendant" + i + "_inactive", getDroneIntArrayArray(nbt)[1]);
        }
        itemStack.setNbt(nbt);
        return itemStack;
    }

    public static int[][] getPrincessValues(NbtCompound nbt) {
        int[][] values = {nbt.getIntArray("princess"), nbt.getIntArray("princess_inactive")};
        return values;
    }
    public static int[][] getDroneValues(NbtCompound nbt) {
        int[][] values = {nbt.getIntArray("drone"), nbt.getIntArray("drone_inactive")};
        return values;
    }
    public static int[][] getQueenValues(NbtCompound nbt) {
        int[][] values = {nbt.getIntArray("princess"), nbt.getIntArray("princess_inactive"), nbt.getIntArray("drone"), nbt.getIntArray("drone_inactive")};
        return values;
    }

    public static Item getQueenItem(ItemStack stack) {
        int i = stack.getNbt().getIntArray("princess")[0];
        Item item = QueenList[i];
        return item;
    }
    public static ItemStack generatePrincessItemStack(NbtCompound nbt) {
        ItemStack princess = new ItemStack(PrincessList[nbt.getIntArray("princess_descendant")[0]]);
        NbtCompound nbt2 = new NbtCompound();
        nbt2.putIntArray("princess", nbt.getIntArray("princess_descendant"));
        nbt2.putIntArray("princess_inactive", nbt.getIntArray("princess_descendant_inactive"));
        princess.setNbt(nbt2);
        return princess;
    }
    public static ItemStack generateDroneItemStack(NbtCompound nbt, int i) {
        if (i >= drones[nbt.getIntArray("princess")[3]]) {
            return ItemStack.EMPTY;
        }
        else {
            ItemStack drone = new ItemStack(DroneList[nbt.getIntArray("drone_descendant" + i)[0]]);
            NbtCompound nbt2 = new NbtCompound();
            nbt2.putIntArray("drone", nbt.getIntArray("drone_descendant" + i));
            nbt2.putIntArray("drone_inactive", nbt.getIntArray("drone_descendant" + i + "_inactive"));
            drone.setNbt(nbt2);
            return drone;
        }
    }
    public static ItemStack[] generateDescendantItemStackArray(ItemStack stack5, ItemStack stack4, ItemStack stack3, ItemStack stack2, ItemStack stack1) {
        ItemStack[] stack = {stack1, stack2, stack3, stack4, stack5};
        int i;
        for (i = 4; i > -1; --i) {
            if (stack[i] == ItemStack.EMPTY) {
                stack = ArrayUtils.remove(stack, i);
            }
        }
        return stack;
    }

    public static int[][] getPrincessIntArrayArray(NbtCompound nbt) {
        int[] i1 = nbt.getIntArray("princess");
        int[] i2 = nbt.getIntArray("princess_inactive");
        int[] i3 = nbt.getIntArray("drone");
        int[] i4 = nbt.getIntArray("drone_inactive");
        int[][] i5 = randomizeBeeStats(i1, i2, i3, i4);
        int[][] ii = {i5[0], i5[1]};
        return ii;
    }
    public static int[][] getDroneIntArrayArray(NbtCompound nbt) {
        int[] i1 = nbt.getIntArray("princess");
        int[] i2 = nbt.getIntArray("princess_inactive");
        int[] i3 = nbt.getIntArray("drone");
        int[] i4 = nbt.getIntArray("drone_inactive");
        int[][] i5 = randomizeBeeStats(i1, i2, i3, i4);
        int[][] ii = {i5[0], i5[1]};
        return ii;
    }

    private static int[][] randomizeBeeStats(int[] i1, int[] i2, int[] i3, int[] i4) {
        Random random = new Random();
        int index;
        int[][] ii1 = {i1, i2};
        int[][] ii2 = {i3, i4};
        int[][] ii = {{0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 2, 0, 0, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 2, 0, 0, 0}};
        for (index = 0; index < i1.length; ++index) {
            if (index == 9) {
                ii[0][9] = defaultValues[ii[0][0]][9];
                ii[1][9] = defaultValues[ii[1][0]][9];
                ii[0][10] = defaultValues[ii[0][0]][10];
                ii[1][10] = defaultValues[ii[1][0]][10];
                index = index + 2;
            }
            int[] i5 = ii1[random.ints(0, 2).findFirst().getAsInt()];
            int[] i6 = ii2[random.ints(0, 2).findFirst().getAsInt()];
            int[][] ii3 = {i5, i6};
            int i = random.ints(0, 2).findFirst().getAsInt();
            ii[0][index] = ii3[i][index];
            ii[1][index] = ii3[Math.abs(i - 1)][index];
            if (index == 4) {
                ii[0][index + 1] = ii3[i][index + 1];
                ii[1][index + 1] = ii3[Math.abs(i - 1)][index + 1];
                index++;
            }
        }
        int[][] possibleMutations = MutationList[ii[0][0]];
        int index1;
        if (!(possibleMutations.length <= 0) && !(possibleMutations[0].length <= 0)) {
            for (index1 = 0; index1 < possibleMutations.length; index1++) {
                if (ii[1][0] == possibleMutations[index1][0]) {
                    int speciesType = possibleMutations[index1][1];
                    if (Math.random() < MutationChance[speciesType]) {
                        int i = random.ints(0, 2).findFirst().getAsInt();
                        ii[i] = defaultValues[speciesType];
                    }
                    break;
                }
            }
        }
        return ii;
    }

    public static DefaultedList<ItemStack> getBeeOutput(NbtCompound nbt) {
        int[] i = getQueenValues(nbt)[0];
        DefaultedList<ItemStack> itemStack = OutputList[i[0]];
        return itemStack;
    }
    public static DefaultedList<ItemStack> getCombOutput(ItemStack item) {
        String speciesName = item.getItem().asItem().toString();
        int index = 0;
        for (int i = 0; i < species.length; i++) {
            if(speciesName.equals(species[i] + "_comb")) {
                index = i; break;
            }
            if (i == species.length - 1) {
                return base_comb;
            }
        }
        DefaultedList<ItemStack> list = CombOutputList[index];
        return list;
    }

    public static boolean checkFlower(World world, BlockPos pos, NbtCompound nbt) {
        int[] i = AoE[nbt.getIntArray("princess")[6]];
        int index1;
        int index2;
        int index3;
        for (index1 = 0; index1 < i[0]; index1++) {
            for (index2 = 0; index2 < i[1]; index2++) {
                for (index3 = 0; index3 < i[2]; index3++) {
                    BlockPos pos2 = new BlockPos(pos.getX() - (i[0] / 2) + index1, pos.getY() - (i[1] / 2) + index2, pos.getZ() - (i[2] / 2) + index3);
                    Block[] flowerBlocks = getFlowerBlock(nbt);
                    int index4;
                    for (index4 = 0; index4 < flowerBlocks.length; index4++) {
                        if (world.getBlockState(pos2).getBlock() == flowerBlocks[index4]) {
                            return true;
                        }
                    }
                    Tag<Block>[] tags = getFlowerBlockTag(nbt);
                    int index5;
                    int index6;
                    for (index5 = 0; index5 < tags.length; index5++) {
                        Tag<Block> tags2 = tags[index5];
                        if (tags2 != null) {
                            for (index6 = 0; index6 < tags2.values().toArray().length; index6++) {
                                if (world.getBlockState(pos2).getBlock().asItem().toString().equals(tags2.values().get(index6).asItem().toString())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public static boolean checkClimate(World world, BlockPos pos, NbtCompound nbt) {
        int temp = (int) (world.getBiome(pos).getTemperature() * 20);
        int down = (int) (world.getBiome(pos).getDownfall() * 100);
        int[] climate = getClimate(nbt);
        int temp2 = climate[0];
        int down2 = climate[1];
        int[][] climateTol = getClimateTolerance(nbt);
        int[] tempTol = climateTol[0];
        int[] downTol = climateTol[1];
        if (temp >= ((temp2 - 10) + tempTol[0]) && temp <= ((temp2 + 10) + tempTol[1]) && down >= ((down2 - 20) + downTol[0]) && down <= ((down2 + 20) + downTol[1])) {
            return true;
        }
        return false;
    }
    public static boolean checkTime(NbtCompound nbt, World world, BlockPos pos) {
        int dayTime = (int) (world.getTimeOfDay() % 24000);
        boolean timeTime2 = false;
        if (dayTime <= 13000 || dayTime >= 23000) {
            timeTime2 = true;
        }
        boolean timeTime = time[nbt.getIntArray("princess")[7]];
        BlockPos pos1 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
        BlockPos pos2 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
        BlockPos pos3 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        BlockPos pos4 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
        BlockPos pos5 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
        BlockPos pos6 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
        int[] lightlevels = {world.getLightLevel(LightType.SKY, pos1), world.getLightLevel(LightType.SKY, pos2), world.getLightLevel(LightType.SKY, pos3), world.getLightLevel(LightType.SKY, pos4), world.getLightLevel(LightType.SKY, pos5), world.getLightLevel(LightType.SKY, pos6)};
        if (timeTime) {
            return true;
        }
        else if (Arrays.stream(lightlevels).max().getAsInt() > 0 & timeTime2) {
            return true;
        }
        else return false;
    }

    public static boolean nbtComparison(NbtCompound nbt1, NbtCompound nbt2) {
        if (nbt1.getIntArray("drone").length == nbt2.getIntArray("drone").length && !(nbt1.getIntArray("drone").length == 0)) {
            int i;
            for (i = 0; i < nbt1.getIntArray("drone").length; ++i) {
                if (!(nbt1.getIntArray("drone")[i] == nbt2.getIntArray("drone")[i])) {
                    return false;
                }
                else if (i == (nbt1.getIntArray("drone").length - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static double getProduction(NbtCompound nbt) {
        double i = production[nbt.getIntArray("princess")[2]];
        return i;
    }
    public static double getLifetime(NbtCompound nbt) {
        double i = lifespan[nbt.getIntArray("princess")[1]];
        return i;
    }
    public static Block[] getFlowerBlock(NbtCompound nbt) {
        Block[] i = flowerBlocks[nbt.getIntArray("princess")[4]];
        return i;
    }
    public static Tag<Block>[] getFlowerBlockTag(NbtCompound nbt) {
        Tag<Block>[] i = flowerTags[nbt.getIntArray("princess")[5]];
        return i;
    }
    public static boolean getFraming(NbtCompound nbt) {
        return framing[nbt.getIntArray("princess")[8]];
    }
    public static int[] getClimate(NbtCompound nbt) {
        return new int[]{temperature[nbt.getIntArray("princess")[9]], downfall[nbt.getIntArray("princess")[10]]};
    }
    public static int[][] getClimateTolerance(NbtCompound nbt) {
        return new int[][]{temperatureTolerance[nbt.getIntArray("princess")[11]], downfallTolerance[nbt.getIntArray("princess")[12]]};
    }
    public static int getDiameter(NbtCompound nbt) {
        int i = AoE[nbt.getIntArray("princess")[6]][0];
        return i;
    }
    public static int getEffect(NbtCompound nbt) {
        int i = nbt.getIntArray("princess")[13];
        return i;
    }
    public static int getEffect(int[] i) {
        int i2 = effectArray[i[0]];
        return i2;
    }

    public static int getSpecies(String s) {
        int index = 0;
        for (int i = 0; i < BeeDefaultValues.species.length; i++) {
            if(s.equals(BeeDefaultValues.species[i])) {
                index = i; break;
            }
        }
        return index;
    }

    public static int getColor(NbtCompound nbt) {
        int index = nbt.getIntArray("princess")[0] - getSpecies("amaryllis");
        if (index < 0 || index > 16) {
            index = 16;
        }
        return index;
    }
}
