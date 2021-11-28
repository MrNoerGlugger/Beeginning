package mrnoerglugger.beeginning.client;

import mrnoerglugger.beeginning.Beeginning;
import mrnoerglugger.beeginning.blocks.CentrifugeBlock;
import mrnoerglugger.beeginning.screens.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class BeeginningClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(Beeginning.APIARY_SCREEN_HANDLER, ApiaryScreen::new);
        ScreenRegistry.register(Beeginning.CENTRIFUGE_SCREEN_HANDLER, CentrifugeScreen::new);
        ScreenRegistry.register(Beeginning.BEEPHONE_SCREEN_HANDLER, BeePhoneScreen::new);
        ScreenRegistry.register(Beeginning.BEEPACK_SCREEN_HANDLER, BeePackScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(CentrifugeBlock.CENTRIFUGE, RenderLayer.getCutout());
    }
}
