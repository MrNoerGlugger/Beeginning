package mrnoerglugger.beeginning.screens;

import mrnoerglugger.beeginning.Beeginning;
import mrnoerglugger.beeginning.items.BeePack;
import mrnoerglugger.beeginning.items.BeePhone;
import mrnoerglugger.beeginning.setup.InventoryUtils;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import org.lwjgl.system.CallbackI;

public class BeePackScreenHandler extends ScreenHandler {
    private Inventory inventory;

    public BeePackScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(171));
    }

    public BeePackScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(Beeginning.BEEPACK_SCREEN_HANDLER, syncId);
        checkSize(inventory, 171);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        setupBeePack(playerInventory, playerInventory.player.getStackInHand(playerInventory.player.getActiveHand()));
    }

    private void setupBeePack(PlayerInventory playerInventory, ItemStack item) {
        if (item.getItem() instanceof BeePack) {
            NbtList nbt = item.getOrCreateNbt().getList("Inventory", NbtElement.COMPOUND_TYPE);
            this.inventory = new SimpleInventory(171) {
                @Override
                public void markDirty() {
                    item.getOrCreateNbt().put("Inventory", InventoryUtils.toTag(this));
                    super.markDirty();
                }
            };
            InventoryUtils.fromTag(nbt, this.inventory);
        }
        int m;
        int l;
        for (m = 0; m < 9; m++) {
            for (l = 0; l < 19; l++) {
                this.addSlot(new BeePackInputSlot(this, inventory, l + m * 19, -82 + l * 18, -35 + m * 18));
            }
        }
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 129 + m * 18));
            }
        }
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 184));
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
