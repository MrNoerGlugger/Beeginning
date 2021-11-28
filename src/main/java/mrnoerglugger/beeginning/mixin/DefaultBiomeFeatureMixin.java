package mrnoerglugger.beeginning.mixin;

import mrnoerglugger.beeginning.Beeginning;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeatureMixin {
    @Inject(method = "addDefaultOres(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V", at = @At("TAIL"))
    private static void addHiveFeatures(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, Beeginning.HIVE_ORE_FEATURE);
        builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, Beeginning.HIVING_FEATURE);
        builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, Beeginning.TREE_HIVING_FEATURE);
    }
    @Inject(method = "addAncientDebris(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V", at = @At("TAIL"))
    private static void addNetherHiveFeatures(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, Beeginning.NETHER_HIVING_FEATURE);

    }
}
