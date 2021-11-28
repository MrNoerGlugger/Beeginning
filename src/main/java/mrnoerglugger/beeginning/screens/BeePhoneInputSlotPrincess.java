package mrnoerglugger.beeginning.screens;

import mrnoerglugger.beeginning.tags.ItemTags;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.tag.Tag;

public class BeePhoneInputSlotPrincess extends Slot {
    private final BeePhoneScreenHandler handler;

    public BeePhoneInputSlotPrincess(BeePhoneScreenHandler beePhoneScreenHandler, Inventory inventory, int i, int j, int k) {
        super(inventory, i, j, k);
        this.handler = beePhoneScreenHandler;
    }

    public static boolean checkByTags(ItemStack stack){
        Tag<Item> tags2 = ItemTags.PRINCESSES;
        Tag<Item> tags3 = ItemTags.QUEENS;
        boolean found = false;
        for (int i = 0; i < tags2.values().toArray().length; i++) {
            if(stack.getItem().toString().equals(tags2.values().get(i).asItem().toString())) {
                found = true; break;
            }
        }
        for (int i = 0; i < tags3.values().toArray().length; i++) {
            if(stack.getItem().toString().equals(tags3.values().get(i).asItem().toString())) {
                found = true; break;
            }
        }
        return found;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return checkByTags(stack);
    }
}
