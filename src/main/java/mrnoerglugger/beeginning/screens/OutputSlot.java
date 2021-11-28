package mrnoerglugger.beeginning.screens;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class OutputSlot extends Slot {
    private int amount;

    public OutputSlot(Inventory inventory, int i, int j, int k) {
        super(inventory, i, j, k);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }
    public ItemStack takeStack(int amount) {
        if (this.hasStack()) {
            this.amount += Math.min(amount, this.getStack().getCount());
        }
        return super.takeStack(amount);
    }
}
