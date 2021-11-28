package mrnoerglugger.beeginning.mixin;

import mrnoerglugger.beeginning.Beeginning;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.TheEndBiomeCreator;
import net.minecraft.world.gen.GenerationStep;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TheEndBiomeCreator.class)
public class EndBiomeMixin {
    @Inject(method = "createEndBiome",at = @At("HEAD"))
    private static void addHiveFeatures(GenerationSettings.Builder builder, CallbackInfoReturnable<Biome> cir) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Beeginning.END_HIVING_FEATURE);
    }
}
