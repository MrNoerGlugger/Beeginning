package mrnoerglugger.beeginning.beekeeping;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.Tag;
import org.apache.commons.lang3.ArrayUtils;

import javax.swing.text.html.HTML;

public class BeeInventory {
    public static ItemStack[][] stackInventories(ItemStack[] input, ItemStack[] current) {
        int in = input.length;
        ItemStack[] inputSave = input.clone();
        ItemStack[] currentSave = current.clone();
        for (int i = 0; i < in; i++) {
            for (int ii = 0; ii < current.length; ii++) {
                if (input[0].getItem() == current[ii].getItem() && input[0].getCount() + current[ii].getCount() <= current[ii].getMaxCount()) {
                    current[ii].setCount(input[0].getCount() + current[ii].getCount());
                    input = ArrayUtils.remove(input, 0);
                    break;
                }
            }
            if (input.length + i == in) {
                for (int ii = 0; ii < current.length; ii++) {
                    if (current[ii].isEmpty()) {
                        current[ii] = input[0].copy();
                        input = ArrayUtils.remove(input, 0);
                        break;
                    }
                }
            }
            if (input.length + i == in) {
                input = inputSave;
                current = currentSave;
                break;
            }
        }
        return new ItemStack[][]{input, current};
    }

    public static boolean checkItemTag(Item item, Tag<Item> tag) {
        if (tag != null) {
            for (int index = 0; index < tag.values().toArray().length; index++) {
                if (item.toString().equals(tag.values().get(index).toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}
