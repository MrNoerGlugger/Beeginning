package mrnoerglugger.beeginning.mixin;

import mrnoerglugger.beeginning.beekeeping.BeeFlowerizing;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.function.BooleanSupplier;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {
    @Inject(method = "tick", at = @At("TAIL"), cancellable = true)
    private void checkFlowers(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        if (BeeFlowerizing.flowerizerPos.length == 0) {
            System.out.println(Arrays.toString(BeeFlowerizing.flowerPos));
            ci.cancel();
        }
        ServerWorld world = ((ServerWorld)(Object)this);
        BeeFlowerizing.generateFlowers(world);
    }
}
