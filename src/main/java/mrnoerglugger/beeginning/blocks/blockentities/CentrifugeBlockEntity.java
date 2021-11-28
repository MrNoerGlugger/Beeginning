package mrnoerglugger.beeginning.blocks.blockentities;

import mrnoerglugger.beeginning.Beeginning;
import mrnoerglugger.beeginning.beekeeping.BeeFunctions;
import mrnoerglugger.beeginning.screens.CentrifugeInputSlotComb;
import mrnoerglugger.beeginning.screens.CentrifugeScreenHandler;
import mrnoerglugger.beeginning.setup.ImplementedInventory;
import net.minecraft.block.BlockState;
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
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CentrifugeBlockEntity extends BlockEntity implements ImplementedInventory, SidedInventory, NamedScreenHandlerFactory {
    final protected DefaultedList<ItemStack> items = DefaultedList.ofSize(19, ItemStack.EMPTY);
    int craftingTime;
    int craftingTimeTotal = 40;
    public CentrifugeBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(Beeginning.CENTRIFUGE_BLOCK_ENTITY, blockPos, blockState);
    }

    public static void tick(World world, BlockPos pos, BlockState state, CentrifugeBlockEntity be) {
        ItemStack comb = be.items.get(9);
        if (comb.isEmpty()) {
            int i;
            for (i = 0; i < 9; i++) {
                ItemStack input = be.items.get(i);
                if (!input.isEmpty()) {
                    be.items.set(9, new ItemStack(input.getItem(), 1));
                    input.decrement(1);
                    break;
                }
            }
        }
        if (!comb.isEmpty()) {
            if (be.craftingTime < be.craftingTimeTotal) {
                be.craftingTime++;
            }
            else {
                DefaultedList<ItemStack> list = BeeFunctions.getCombOutput(comb);
                Random random = new Random();
                int i = random.ints(0, list.size()).findFirst().getAsInt();
                Item item = list.get(i).getItem();
                int count = list.get(i).getCount();
                ItemStack stack = new ItemStack(item, count);
                ItemStack[] stack3 = {be.items.get(10), be.items.get(11), be.items.get(12), be.items.get(13), be.items.get(14), be.items.get(15), be.items.get(16), be.items.get(17), be.items.get(18)};
                int c2;
                for (c2 = 0; c2 < stack3.length; ++c2) {
                    if (stack3[c2].getItem().asItem() == Items.AIR) {
                        stack3[c2] = stack;
                        stack = null;
                        break;
                    }
                    if (!stack3[c2].isEmpty() && stack.getItem() == stack3[c2].getItem() && (stack.getCount() + stack3[c2].getCount()) < 65) {
                        stack3[c2].increment(1);
                        stack = null;
                        break;
                    }
                }
                int c3;
                for (c3 = 0; c3 < stack3.length; ++c3) {
                    be.items.set(10 + c3, stack3[c3]);
                }
                if (stack == null) {
                    comb.decrement(1);
                    be.craftingTime = 0;
                }
            }
        }
        markDirty(world, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
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
        return new CentrifugeScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, items);
        super.writeNbt(nbt);
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        if (slot < 10 && CentrifugeInputSlotComb.checkByTags(stack)) {
            return true;
        }
        else return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        if (slot < 10) {
            return false;
        }
        else return true;
    }
}
