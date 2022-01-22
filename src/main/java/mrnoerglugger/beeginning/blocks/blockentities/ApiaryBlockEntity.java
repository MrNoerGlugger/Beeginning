package mrnoerglugger.beeginning.blocks.blockentities;

import mrnoerglugger.beeginning.Beeginning;
import mrnoerglugger.beeginning.beekeeping.BeeDefaultValues;
import mrnoerglugger.beeginning.beekeeping.BeeFlowerizing;
import mrnoerglugger.beeginning.beekeeping.BeeFunctions;
import mrnoerglugger.beeginning.beekeeping.BeeInventory;
import mrnoerglugger.beeginning.screens.*;
import mrnoerglugger.beeginning.setup.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class ApiaryBlockEntity extends BlockEntity implements ImplementedInventory, SidedInventory, NamedScreenHandlerFactory {
    final protected DefaultedList<ItemStack> items = DefaultedList.ofSize(28, ItemStack.EMPTY);
    int breedingTime;
    int breedingTimeTotal = 60;
    int lifespan = 2000;
    int productionTime = 1200;
    int y = 0;
    int y2 = 0;
    int y3 = 0;
    int y4 = 0;
    int y5 = 0;
    int lifetime;
    NbtCompound queenNbt;
    Item queenItem;
    public BlockPos flowerPos;
    BlockPos[] possibleFlowerPos;
    public ApiaryBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState state) {
        super(Beeginning.APIARY_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, ApiaryBlockEntity be) {
        long startTime = System.nanoTime();
        ItemStack princess = be.items.get(0);
        ItemStack drone = be.items.get(1);
        ItemStack queen = be.items.get(2);
        be.lifetime = queen.getDamage();
        boolean flowers = false;
        boolean time = false;
        boolean climate = false;
        if (!princess.isEmpty() && princess.getNbt() == null) {
            BeeFunctions.setPrincessValues(princess);
        }
        if (!drone.isEmpty() && drone.getNbt() == null) {
            BeeFunctions.setDroneValues(drone);
        }
        if (!princess.isEmpty() && !drone.isEmpty() && be.breedingTime < be.breedingTimeTotal && be.y2 == 0) {
            ++be.breedingTime;
        }
        if (princess.isEmpty() || drone.isEmpty()) {
            be.breedingTime = 0;
        }
        if (queen.isEmpty() || be.queenItem != queen.getItem()) {
            be.y = 0;
            be.y3 = 0;
            be.y5 = 0;
            be.queenItem = queen.getItem();
            be.possibleFlowerPos = null;
        }
        if (!queen.isEmpty() && queen.getNbt() == null) {
            BeeFunctions.setDefaultQueenValues(queen);
        }
        if (be.y2 == 1 && !queen.isEmpty()) {
            be.y2 = 0;
            be.y = 0;
            be.possibleFlowerPos = null;
            BeeFunctions.setQueenValues(queen, BeeFunctions.getPrincessValues(princess.getNbt())[0], BeeFunctions.getPrincessValues(princess.getNbt())[1], BeeFunctions.getDroneValues(drone.getNbt())[0], BeeFunctions.getDroneValues(drone.getNbt())[1]);
            be.queenNbt = queen.getNbt();
            be.lifetime = queen.getDamage();
            princess.decrement(1);
            drone.decrement(1);
            BeeFlowerizing.flowerizerChanged = true;
        }

        if (!queen.isEmpty() && queen.getNbt() == null) {
            queen.setDamage(be.lifetime);
        }
        if (!queen.isEmpty()) {
            be.queenNbt = queen.getNbt();
            be.y5++;
            if (be.y5 >= 50) {
                be.y5 = 0;
            }
        }
        if (!queen.isEmpty() && queen.getNbt().getIntArray("princess").length == 0) {
            queen.setNbt(be.queenNbt);
            if (queen.getNbt().getIntArray("princess").length == 0) {
                BeeFunctions.setDefaultQueenValues(queen);
            }
            queen.setDamage(be.lifetime);
        }
        if (!queen.isEmpty()) {
            //if (be.possibleFlowerPos == null) {
            //    be.possibleFlowerPos = BeeFunctions.generateAoEPositions(queen.getNbt(), pos);
            //}
            //if (be.flowerPos != null) {
            //    flowers = BeeFunctions.checkFlowerBlock(world, be.flowerPos, queen.getNbt());
            //}
            //if (!flowers) {
            //    be.flowerPos = null;
            //    int x = be.possibleFlowerPos.length / 50 * be.y5;
            //    if (x < be.possibleFlowerPos.length / 50 * 49) {
            //        flowers = BeeFunctions.checkFlower(world, be.possibleFlowerPos, queen.getNbt(), be, x, x + be.possibleFlowerPos.length / 50);
            //    }
            //    else flowers = BeeFunctions.checkFlower(world, be.possibleFlowerPos, queen.getNbt(), be, x, be.possibleFlowerPos.length + 1);
            //}
            time = BeeFunctions.checkTime(queen.getNbt(), world, pos);
            climate = BeeFunctions.checkClimate(world, pos, queen.getNbt());
            NbtCompound nbt = queen.getNbt();
            nbt.putBoolean("flowers", flowers);
            nbt.putBoolean("time", time);
            nbt.putBoolean("climate", climate);
            queen.setNbt(nbt);
        }
        if (flowers && time) {
            be.y4 = 1;
        }
        if (!flowers || !time) {
            be.y4 = 0;
        }
        if (!princess.isEmpty() && !drone.isEmpty() && be.breedingTime == be.breedingTimeTotal && queen.isEmpty()) {
            Item item = BeeFunctions.getQueenItem(princess);
            be.queenItem = item;
            be.items.set(2, item == null ? ItemStack.EMPTY : new ItemStack(item));
            be.breedingTime = 0;
            be.y2 = 1;
        }

        if (!queen.isEmpty() && be.y4 == 1) {
            if (queen.getDamage() <= be.lifespan && java.lang.Math.random() < 0.3 / BeeFunctions.getLifetime(queen.getNbt())) {
                ++be.lifetime;
                queen.setDamage(be.lifetime);
            }
            else if (queen.getDamage() > be.lifespan) {
                be.y3 = 1;
            }
        }
        if (be.y3 == 1) {
            NbtCompound queenNbt = queen.getNbt();
            ItemStack[] stack = BeeFunctions.generateDescendantItemStackArray(BeeFunctions.generatePrincessItemStack(queenNbt), BeeFunctions.generateDroneItemStack(queenNbt, 0), BeeFunctions.generateDroneItemStack(queenNbt, 1), BeeFunctions.generateDroneItemStack(queenNbt, 2), BeeFunctions.generateDroneItemStack(queenNbt, 3));
            ItemStack[] stack2 = {be.items.get(3), be.items.get(4), be.items.get(5), be.items.get(6), be.items.get(7), be.items.get(8), be.items.get(9)};
            ItemStack[][] stackstack = BeeInventory.stackInventories(stack, stack2);
            stack = stackstack[0];
            stack2 = stackstack[1];
            for (int c3 = 0; c3 < stack2.length; ++c3) {
                be.items.set(3 + c3, stack2[c3]);
            }
            if (stack.length == 0) {
                queen.decrement(1);
                be.y3 = 0;
                BeeFlowerizing.flowerizerChanged = true;
            }
        }
        if (be.productionTime > be.y && !queen.isEmpty() && !queen.getNbt().isEmpty() && be.y4 == 1) {
            ++be.y;
        }
        else if (queen.getDamage() <= be.lifespan && be.y4 == 1) {
            for (int i = 1; i <= 6; ++i) {
                int i1 = i + 9;
                int i2 = i * 2 + 14;
                int i3 = i * 2 + 15;
                ItemStack frame = be.items.get(i1);
                ItemStack outputGeneral = be.items.get(i2);
                ItemStack outputSpecial = be.items.get(i3);
                if (!frame.isEmpty() && !be.items.get(2).isEmpty()) {
                    DefaultedList<ItemStack> output = BeeFunctions.getBeeOutput(queen.getNbt());
                    Item item = output.get(0).getItem();
                    Item item2 = output.get(1).getItem();
                    if (java.lang.Math.random() < 0.5 * BeeFunctions.getProduction(queen.getNbt())) {
                        if (outputGeneral.isEmpty()) {
                            be.items.set(i2, item == null ? ItemStack.EMPTY : new ItemStack(item));
                        } else if (outputGeneral.getItem() == item && outputGeneral.getCount() < 64) {
                            outputGeneral.increment(1);
                        }
                    }
                    if (java.lang.Math.random() < 0.25 * BeeFunctions.getProduction(queen.getNbt()) && climate) {
                        if (outputSpecial.isEmpty()) {
                            be.items.set(i3, item2 == null ? ItemStack.EMPTY : new ItemStack(item2));
                        } else if (outputSpecial.getItem() == item2 && outputSpecial.getCount() < 64) {
                            outputSpecial.increment(1);
                        }
                    }
                }
                be.y = 0;
            }
        }
        if (flowers && time && !queen.isEmpty() && queen.getNbt() != null && queen.getNbt().getIntArray("princess").length != 0){
            BeeDefaultValues.createEffects(world, pos, state, be, BeeFunctions.getEffect(queen.getNbt()));
        }
        markDirty(world, pos, state);
        long elapsedTime = System.nanoTime() - startTime;
        //System.out.println(elapsedTime);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public int[] getAvailableSlots(Direction var1) {
        int[] result = new int[getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new ApiaryScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }
    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, items);
        super.writeNbt(nbt);
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        if (slot == 0 && ApiaryInputSlotPrincess.checkByTags(stack)) {
            return true;
        }
        if (slot == 1 && ApiaryInputSlotDrone.checkByTags(stack)) {
            return true;
        }
        if (slot == 2 && ApiaryInputSlotQueen.checkByTags(stack)) {
            return true;
        }
        if (slot > 9 && slot < 16 && ApiaryInputSlotFrame.checkByTags(stack)) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        if (slot < 3){
            return false;
        }
        else if (slot > 9 && slot < 16) {
            return false;
        }
        else {
            return true;
        }
    }
}

