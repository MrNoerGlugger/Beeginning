package mrnoerglugger.beeginning.mixin;

import com.google.common.collect.Multimap;
import mrnoerglugger.beeginning.beekeeping.BeeFunctions;
import mrnoerglugger.beeginning.items.BeeItem;
import mrnoerglugger.beeginning.screens.ApiaryInputSlotDrone;
import mrnoerglugger.beeginning.screens.ApiaryInputSlotPrincess;
import mrnoerglugger.beeginning.screens.ApiaryInputSlotQueen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class BeeItemMixin {
    @Inject(method = "getAttributeModifiers", at = @At("RETURN"), cancellable = true)
    private void setBeeItem(EquipmentSlot slot, CallbackInfoReturnable<Multimap<EntityAttribute, EntityAttributeModifier>> cir) {
        ItemStack stack = ((ItemStack)(Object) this);
        Item item = stack.getItem();
        if (item instanceof BeeItem) {
            if (ApiaryInputSlotPrincess.checkByTags(stack)) {
                if (stack.getNbt() == null) {
                    BeeFunctions.setPrincessValues(stack);
                }
            }
            if (ApiaryInputSlotDrone.checkByTags(stack)) {
                if (stack.getNbt() == null) {
                    BeeFunctions.setDroneValues(stack);
                }
            }
            if (stack.getNbt() != null && ApiaryInputSlotQueen.checkByTags(stack) && stack.getNbt().getIntArray("princess").length == 0) {
                BeeFunctions.setDefaultQueenValues(stack);
            }
        }
    }
}