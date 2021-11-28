package mrnoerglugger.beeginning.screens;

import mrnoerglugger.beeginning.Beeginning;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class ApiaryScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public ApiaryScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(28));
    }

    public ApiaryScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(Beeginning.APIARY_SCREEN_HANDLER, syncId);
        checkSize(inventory, 28);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        int m;
        int l;

        this.addSlot(new ApiaryInputSlotPrincess(this, inventory, 0 , 8 , 18));
        this.addSlot(new ApiaryInputSlotDrone(this, inventory, 1 , 8, 52));
        this.addSlot(new ApiaryInputSlotQueen(this, inventory, 2 , 36 , 35));
        for (m = 0 ; m < 2 ; ++m) {
            this.addSlot(new OutputSlot(inventory, m + 3, 129 + 18 * m , 17));
        }
        for (m = 0 ; m < 3 ; ++m) {
            this.addSlot(new OutputSlot(inventory, m + 5, 120 + 18 * m , 35));
        }
        for (m = 0 ; m < 2 ; ++m) {
            this.addSlot(new OutputSlot(inventory, m + 8, 129 + 18 * m , 53));
        }
        for (m = 0 ; m < 3 ; ++m) {
            this.addSlot(new ApiaryInputSlotFrame(this, inventory, m + 10, 34 + 37 * m , 14));
        }
        for (m = 0 ; m < 3 ; ++m) {
            this.addSlot(new ApiaryInputSlotFrame(this, inventory, m + 13, 34 + 37 * m , 56));
        }
        for (m = 0 ; m < 3 ; ++m) {
            for (l = 0 ; l < 2 ; ++l) {
                this.addSlot(new OutputSlot(inventory, m * 2 + l + 16, 25 + l * 18 + m * 37, -4));
            }
        }
        for (m = 0 ; m < 3 ; ++m) {
            for (l = 0 ; l < 2 ; ++l) {
                this.addSlot(new OutputSlot(inventory, m * 2 + l + 22, 25 + l * 18 + m * 37, 74));
            }
        }
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 9 + l * 18, 95 + m * 18));
            }
        }
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 9 + m * 18, 151));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (index < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
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
}
