package mrnoerglugger.beeginning.blocks.blockentities;

import mrnoerglugger.beeginning.Beeginning;
import mrnoerglugger.beeginning.beekeeping.BeeDefaultValues;
import mrnoerglugger.beeginning.beekeeping.BeeFunctions;
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
    int lifetime;
    public ApiaryBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState state) {
        super(Beeginning.APIARY_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, ApiaryBlockEntity be) {
        ItemStack princess = (ItemStack) be.items.get(0);
        ItemStack drone = (ItemStack) be.items.get(1);
        ItemStack queen = (ItemStack) be.items.get(2);
        NbtCompound queenNbt = null;
        be.lifetime = queen.getDamage();
        boolean flowers = false;
        boolean time = false;
        boolean climate = false;
        if (!princess.isEmpty() && princess.getNbt() == null) {
            princess = BeeFunctions.setPrincessValues(princess);
        }
        if (!drone.isEmpty() && drone.getNbt() == null) {
            drone = BeeFunctions.setDroneValues(drone);
        }
        if (!princess.isEmpty() && !drone.isEmpty() && be.breedingTime < be.breedingTimeTotal && be.y2 == 0) {
            ++be.breedingTime;
        }
        if (princess.isEmpty() || drone.isEmpty()) {
            be.breedingTime = 0;
        }
        if (queen.isEmpty()) {
            be.y = 0;
            be.y3 = 0;
        }
        if (!queen.isEmpty() && queen.getNbt() == null) {
            queen = BeeFunctions.setDefaultQueenValues(queen);
        }
        if (be.y2 == 1 && !queen.isEmpty()) {
            be.y2 = 0;
            be.y = 0;
            queen = BeeFunctions.setQueenValues(queen, BeeFunctions.getPrincessValues(princess.getNbt())[0], BeeFunctions.getPrincessValues(princess.getNbt())[1], BeeFunctions.getDroneValues(drone.getNbt())[0], BeeFunctions.getDroneValues(drone.getNbt())[1]);
            be.lifetime = queen.getDamage();
            princess.decrement(1);
            drone.decrement(1);
        }

        if (!queen.isEmpty() && queen.getNbt() == null) {
            queen.setDamage(be.lifetime);
        }
        if (!queen.isEmpty()) {
            queenNbt = queen.getNbt();
        }
        if (!queen.isEmpty() && queen.getNbt().getIntArray("princess").length == 0) {
            queen.setNbt(queenNbt);
            if (queen.getNbt().getIntArray("princess").length == 0) {
                BeeFunctions.setDefaultQueenValues(queen);
            }
            queen.setDamage(be.lifetime);
        }
        if (!queen.isEmpty()) {
            flowers = BeeFunctions.checkFlower(world, pos, queen.getNbt());
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
            queenNbt = queen.getNbt();
            ItemStack[] stack = BeeFunctions.generateDescendantItemStackArray(BeeFunctions.generatePrincessItemStack(queenNbt), BeeFunctions.generateDroneItemStack(queenNbt, 0), BeeFunctions.generateDroneItemStack(queenNbt, 1), BeeFunctions.generateDroneItemStack(queenNbt, 2), BeeFunctions.generateDroneItemStack(queenNbt, 3));
            ItemStack[] stack2 = {be.items.get(3), be.items.get(4), be.items.get(5), be.items.get(6), be.items.get(7), be.items.get(8), be.items.get(9)};
            int c1;
            int c2;
            for (c1 = stack.length - 1; c1 > -1; --c1) {
                for (c2 = 0; c2 < stack2.length; ++c2) {
                    if (stack2[c2].getItem().asItem() == Items.AIR) {
                        stack2[c2] = stack[c1];
                        stack = ArrayUtils.remove(stack, c1);
                        if (stack.length == 0) {
                            stack = null;
                        }
                        break;
                    }
                    if (stack2[c2].getItem().asItem() != Items.AIR && stack[c1].getItem() == stack2[c2].getItem() && (stack[c1].getCount() + stack2[c2].getCount()) < 65 && BeeFunctions.nbtComparison(stack[c1].getNbt(), stack2[c2].getNbt())) {
                        stack2[c2].increment(1);
                        stack = ArrayUtils.remove(stack, c1);
                        if (stack.length == 0) {
                            stack = null;
                        }
                        break;
                    }
                    if (c2 == 6) {
                        stack = BeeFunctions.generateDescendantItemStackArray(BeeFunctions.generatePrincessItemStack(queenNbt), BeeFunctions.generateDroneItemStack(queenNbt, 0), BeeFunctions.generateDroneItemStack(queenNbt, 1), BeeFunctions.generateDroneItemStack(queenNbt, 2), BeeFunctions.generateDroneItemStack(queenNbt, 3));
                        stack2 = new ItemStack[]{be.items.get(3), be.items.get(4), be.items.get(5), be.items.get(6), be.items.get(7), be.items.get(8), be.items.get(9)};
                        break;
                    }
                }
                if (!(stack == null) && stack.length > c1) {
                    break;
                }
            }
            int c3;
            for (c3 = 0; c3 < stack2.length; ++c3) {
                be.items.set(3 + c3, stack2[c3]);
            }
            if (stack == null) {
                queen.decrement(1);
                be.y3 = 0;
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

