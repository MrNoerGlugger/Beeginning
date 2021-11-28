package mrnoerglugger.beeginning.screens;

import mrnoerglugger.beeginning.items.HoneyDrops;
import mrnoerglugger.beeginning.tags.ItemTags;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.tag.Tag;

public class BeePhoneInputSlotHoneyDrop extends Slot {
    private final BeePhoneScreenHandler handler;

    public BeePhoneInputSlotHoneyDrop(BeePhoneScreenHandler beePhoneScreenHandler, Inventory inventory, int i, int j, int k) {
        super(inventory, i, j, k);
        this.handler = beePhoneScreenHandler;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        if (stack.getItem().asItem() == HoneyDrops.HONEY_DROP.asItem()){
            return true;
        }
        return false;
    }
}
