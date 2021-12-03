package mrnoerglugger.beeginning.screens;

import mrnoerglugger.beeginning.Beeginning;
import mrnoerglugger.beeginning.beekeeping.BeeFunctions;
import mrnoerglugger.beeginning.items.BeePhone;
import mrnoerglugger.beeginning.setup.ImplementedInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;

public class BeePhoneScreenHandler extends ScreenHandler implements ImplementedInventory {
    protected final DefaultedList<ItemStack> items = DefaultedList.ofSize(3, ItemStack.EMPTY);
    protected final PlayerEntity player;
    int mode = 0;
    int background = 0;

    public BeePhoneScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, playerInventory.player);
    }

    public BeePhoneScreenHandler(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        super(Beeginning.BEEPHONE_SCREEN_HANDLER, syncId);
        this.player = player;
        if (this.player.getStackInHand(this.player.getActiveHand()).getNbt() == null) {
            createNbt(this.player.getStackInHand(this.player.getActiveHand()));
        }
        readNbt(items, player.getStackInHand(player.getActiveHand()));
        writeNbt();

        if (!(this.player.getStackInHand(this.player.getActiveHand()).getItem() instanceof BeePhone)) {
            this.close(this.player);
        }
        else setupBeePhone(playerInventory);
    }

    void setupBeePhone(PlayerInventory playerInventory) {
        int m;
        int l;
        this.addSlot(new BeePhoneInputSlotHoneyDrop(this, this, 0, 7, 0));
        this.addSlot(new BeePhoneInputSlotDrone(this, this, 1, 7, 18));
        this.addSlot(new BeePhoneInputSlotPrincess(this, this, 2, 7, 49));
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 98 + m * 18));
            }
        }
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 156));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return player.getStackInHand(player.getActiveHand()).getItem() instanceof BeePhone;
    }

    protected void readNbt(DefaultedList<ItemStack> stacks, ItemStack item) {
        NbtCompound nbt = item.getNbt();
        assert nbt != null;
        Inventories.readNbt(nbt, stacks);
        mode = nbt.getInt("mode");
        background = nbt.getInt("background");
    }

    void writeNbt() {
        NbtCompound nbt = player.getStackInHand(player.getActiveHand()).getNbt();
        Inventories.writeNbt(nbt, items);
        assert nbt != null;
        nbt.putInt("mode", mode);
        nbt.putInt("background", background);
        player.getStackInHand(player.getActiveHand()).setNbt(nbt);
        markDirty();
        player.getInventory().markDirty();
    }

    protected void updateInventory(ItemStack stack0, ItemStack stack1, ItemStack stack2) {
        items.set(0, stack0);
        items.set(1, stack1);
        items.set(2, stack2);
    }

    private void createNbt(ItemStack item) {
        DefaultedList<ItemStack> stack = DefaultedList.ofSize(3, ItemStack.EMPTY);
        NbtCompound nbt = new NbtCompound();
        Inventories.writeNbt(nbt, stack);
        nbt.putInt("mode", mode);
        nbt.putInt("background", background);
        item.setNbt(nbt);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (index < this.items.size()) {
                if (!this.insertItem(originalStack, this.items.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.items.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        ItemStack honey = items.get(0);
        ItemStack drone = items.get(1);
        ItemStack princess = items.get(2);
        if (!drone.isEmpty() && drone.getNbt() == null) {
            BeeFunctions.setDroneValues(drone);
        }
        if (!princess.isEmpty() && princess.getNbt() == null) {
            BeeFunctions.setPrincessValues(princess);
        }
        if (!honey.isEmpty()) {
            if (!drone.isEmpty() && drone.getNbt() != null && drone.getNbt().getIntArray("checked").length != 5) {
                honey.decrement(1);
                NbtCompound nbt = drone.getNbt();
                nbt.putIntArray("checked", new int[]{0, 1, 2, 3, 4});
                drone.setNbt(nbt);
            }
            if (!princess.isEmpty() && princess.getNbt() != null && princess.getNbt().getIntArray("checked").length != 5) {
                honey.decrement(1);
                NbtCompound nbt = princess.getNbt();
                nbt.putIntArray("checked", new int[]{0, 1, 2, 3, 4});
                princess.setNbt(nbt);
            }
        }
        items.set(0, honey);
        items.set(1, drone);
        items.set(2, princess);
        DefaultedList<ItemStack> stacks = DefaultedList.ofSize(3, ItemStack.EMPTY);
        if (items.get(0) != stacks.get(0) || items.get(1) != stacks.get(1) || items.get(2) != stacks.get(2)) {
            writeNbt();
        }
        return items;
    }
}
