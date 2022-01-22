package mrnoerglugger.beeginning.beekeeping;

import mrnoerglugger.beeginning.blocks.blockentities.ApiaryBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class BeeFlowerizing {
    public static BlockPos[] flowerizerPos = {};
    public static boolean flowerizerChanged = false;
    public static int[] flowerBlocks = {};
    public static int[] flowerTags = {};
    public static BlockPos[] flowerPos = {};
    public static void registerFlowerizer(BlockPos pos) {
        flowerizerPos = ArrayUtils.add(flowerizerPos, pos);
        flowerizerChanged = true;
    }
    public static void removeFlowerizer(BlockPos pos) {
        for (int index = 0; index < flowerizerPos.length; index++) {
            BlockPos flowerizerPos2 = flowerizerPos[index];
            if (flowerizerPos2.equals(pos)) {
                flowerizerPos = ArrayUtils.remove(flowerizerPos, index);
                flowerizerChanged = true;
            }
        }
    }
    private static boolean checkFlowerBlocks(BlockPos pos, World world) {
        for (Block[] blocks : BeeFunctions.flowerBlocks) {
            if (BeeFunctions.checkFlowerBlock(world, pos, blocks, BeeFunctions.flowerTags[0])) {
                return true;
            }
        }
        return false;
    }
    private static boolean checkFlowerTags(BlockPos pos, World world) {
        for (Tag<Block>[] tags : BeeFunctions.flowerTags) {
            if (BeeFunctions.checkFlowerBlock(world, pos, BeeFunctions.flowerBlocks[0], tags)) {
                return true;
            }
        }
        return false;
    }
    private static int getFlowerBlockArray(BlockPos pos, World world) {
        int i = 0;
        for (int index = 0; index < BeeFunctions.flowerBlocks.length; index++) {
            Block[] blocks = BeeFunctions.flowerBlocks[index];
            if (BeeFunctions.checkFlowerBlock(world, pos, blocks, BeeFunctions.flowerTags[0])) {
                i = index; break;
            }
        }
        return i;
    }
    private static int getFlowerTagArray(BlockPos pos, World world) {
        int i = 0;
        for (int index = 0; index < BeeFunctions.flowerTags.length; index++) {
            Tag<Block>[] tags = BeeFunctions.flowerTags[index];
            if (BeeFunctions.checkFlowerBlock(world, pos, BeeFunctions.flowerBlocks[0], tags)) {
                i = index; break;
            }
        }
        return i;
    }
    private static BlockPos[][] generateAllBlockPos(ServerWorld world) {
        BlockPos[][] blockPosPosPos = {};
        for (BlockPos pos : flowerizerPos) {
            if (checkQueenSlot(pos, world)) {
                blockPosPosPos = ArrayUtils.add(blockPosPosPos, BeeFunctions.generateAoEPositions(getQueenSlot(pos, world).getNbt(), pos));
            }
        }
        return blockPosPosPos;
    }
    private static BlockPos[] getAllBlockPos(BlockPos[]... blockPosPosPos) {
        BlockPos[] blockPosPos1 = {};
        for (BlockPos[] blockPosPos2 : blockPosPosPos) {
            blockPosPos1 = ArrayUtils.addAll(blockPosPos1, blockPosPos2);
        }
        return blockPosPos1;
    }
    private static void sortAllBlockPos(BlockPos[] blockPosPos) {
        for (int index = 0 ; index < blockPosPos.length; index++) {
            for (int index2 = 0; index2 < index; index2++) {
                if (blockPosPos[index].getX() < blockPosPos[index2].getX()) {
                    BlockPos blockPos = blockPosPos[index2];
                    blockPosPos[index2] = blockPosPos[index];
                    blockPosPos[index] = blockPos;
                }
            }
        }
        for (int index = 0 ; index < blockPosPos.length; index++) {
            for (int index2 = 0; index2 < index; index2++) {
                if (blockPosPos[index].getY() < blockPosPos[index2].getY()) {
                    BlockPos blockPos = blockPosPos[index2];
                    blockPosPos[index2] = blockPosPos[index];
                    blockPosPos[index] = blockPos;
                }
            }
        }
        for (int index = 0 ; index < blockPosPos.length; index++) {
            for (int index2 = 0; index2 < index; index2++) {
                if (blockPosPos[index].getZ() < blockPosPos[index2].getZ()) {
                    BlockPos blockPos = blockPosPos[index2];
                    blockPosPos[index2] = blockPosPos[index];
                    blockPosPos[index] = blockPos;
                }
            }
        }
    }
    private static BlockPos[] smallifyAllBlockPositions(BlockPos[] blockPosPos) {
        for (int index = 0; index < blockPosPos.length; index++) {
            if (index + 1 == blockPosPos.length) {
                break;
            }
            else {
                while (blockPosPos[index] == blockPosPos[index + 1]) {
                    blockPosPos = ArrayUtils.remove(blockPosPos, index + 1);
                }
            }
        }
        return blockPosPos;
    }
    private static BlockPos[] smallifyAllBlockPositions(BlockPos[][] blockPosPosPos) {
        BlockPos[] blockPosPos = new BlockPos[0];
        for (int index = 0; index < blockPosPosPos.length; index++) {
            BlockPos[] blockPosPos2 = blockPosPosPos[index];
            if (index == 0) {
                blockPosPos = blockPosPos2;
            }
            else {
                for (BlockPos blockPos : blockPosPos2) {
                    boolean input = true;
                    for (BlockPos blockPos1 : blockPosPos) {
                        if (blockPos.getX() == blockPos1.getX() && blockPos.getY() == blockPos1.getY() && blockPos.getZ() == blockPos1.getZ()) {
                            input = false;
                        }
                    }
                    if (input) {
                        blockPosPos = ArrayUtils.add(blockPosPos, blockPos);
                    }
                }
            }
        }
        return blockPosPos;
    }
    private static boolean checkQueenSlot(BlockPos pos, ServerWorld world) {
        if (world.getBlockEntity(pos) instanceof ApiaryBlockEntity be) {
            if (!be.getItems().get(2).isEmpty()) {
                return be.getItems().get(2).getNbt() != null;
            }
        }
        return false;
    }
    private static ItemStack getQueenSlot(BlockPos pos, ServerWorld world) {
        ApiaryBlockEntity be = (ApiaryBlockEntity) world.getBlockEntity(pos);
        return be != null ? be.getItems().get(2) : ItemStack.EMPTY;
    }
    public static void generateFlowers(ServerWorld world) {
        if (flowerizerChanged) {
            long startTime1 = System.nanoTime();
            flowerPos = new BlockPos[]{};
            flowerBlocks = new int[]{};
            flowerTags = new int[]{};
            BlockPos[][] blockPosPosPos = generateAllBlockPos(world);
            long elapsedTime2 = System.nanoTime() - startTime1;
            long startTime2 = System.nanoTime();
            BlockPos[] blockPosPos = getAllBlockPos(blockPosPosPos);
            int oldLength = blockPosPos.length;
            long elapsedTime3 = System.nanoTime() - startTime2;
            long startTime3 = System.nanoTime();
            //sortAllBlockPos(blockPosPos);
            BlockPos[] blockPosPos1 = smallifyAllBlockPositions(blockPosPosPos);
            long elapsedTime4 = System.nanoTime() - startTime3;
            long startTime4 = System.nanoTime();
            blockPosPos = smallifyAllBlockPositions(blockPosPos);
            long elapsedTime5 = System.nanoTime() - startTime4;
            long startTime5 = System.nanoTime();
            System.out.println(oldLength + " / " + blockPosPos.length + " / " + blockPosPos1.length);
            for (BlockPos pos : blockPosPos) {
                if (checkFlowerBlocks(pos, world)) {
                    flowerPos = ArrayUtils.add(flowerPos, pos);
                    flowerBlocks = ArrayUtils.add(flowerBlocks, getFlowerBlockArray(pos, world));
                    flowerTags = ArrayUtils.add(flowerTags, -1);
                }
                if (checkFlowerTags(pos, world)) {
                    flowerPos = ArrayUtils.add(flowerPos, pos);
                    flowerBlocks = ArrayUtils.add(flowerBlocks, -1);
                    flowerTags = ArrayUtils.add(flowerTags, getFlowerTagArray(pos, world));
                }
            }
            long elapsedTime6 = System.nanoTime() - startTime5;
            long startTime6 = System.nanoTime();
            System.out.println(oldLength + " / " + blockPosPos.length + " / " + blockPosPos1.length);
            flowerPos = new BlockPos[]{};
            flowerBlocks = new int[]{};
            flowerTags = new int[]{};
            for (BlockPos pos : blockPosPos1) {
                if (checkFlowerBlocks(pos, world)) {
                    flowerPos = ArrayUtils.add(flowerPos, pos);
                    flowerBlocks = ArrayUtils.add(flowerBlocks, getFlowerBlockArray(pos, world));
                    flowerTags = ArrayUtils.add(flowerTags, -1);
                }
                if (checkFlowerTags(pos, world)) {
                    flowerPos = ArrayUtils.add(flowerPos, pos);
                    flowerBlocks = ArrayUtils.add(flowerBlocks, -1);
                    flowerTags = ArrayUtils.add(flowerTags, getFlowerTagArray(pos, world));
                }
            }
            long elapsedTime7 = System.nanoTime() - startTime6;
            long elapsedTime1 = System.nanoTime() - startTime1;
            System.out.println("Overall: " + elapsedTime1 / 1000000 + " / Generating: " + elapsedTime2 / 1000000 + " / Combining: " + elapsedTime3 / 1000000 + " / Sorting: " + elapsedTime4 / 1000000 + " / Smallifying: " + elapsedTime5 / 1000000 + " / Checking + Indexing: " + elapsedTime6 / 1000000 + " / Checking / Indexing 2: " + elapsedTime7 / 1000000);
            flowerizerChanged = false;
        }
    }
}
