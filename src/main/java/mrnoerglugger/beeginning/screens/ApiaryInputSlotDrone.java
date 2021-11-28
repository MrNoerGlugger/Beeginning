package mrnoerglugger.beeginning.screens;

import mrnoerglugger.beeginning.tags.ItemTags;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.tag.Tag;

public class ApiaryInputSlotDrone extends Slot {
    private final ApiaryScreenHandler handler;

    public ApiaryInputSlotDrone(ApiaryScreenHandler apiaryScreenHandler, Inventory inventory, int i, int j, int k) {
        super(inventory, i, j, k);
        this.handler = apiaryScreenHandler;
    }

    public static boolean checkByTags(ItemStack stack){
        Tag<Item> tags = ItemTags.DRONES;
        boolean found = false;
        for (int i = 0; i < tags.values().toArray().length; i++) {
            if(stack.getItem().toString().equals(tags.values().get(i).asItem().toString())) {
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
