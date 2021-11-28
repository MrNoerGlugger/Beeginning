package mrnoerglugger.beeginning.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import mrnoerglugger.beeginning.beekeeping.BeeFunctions;
import mrnoerglugger.beeginning.items.BeePhone;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BeePackScreen extends HandledScreen<BeePackScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("beeginning", "textures/gui/beepack_gui.png");

    public BeePackScreen(BeePackScreenHandler screenHandler, PlayerInventory playerInventory, Text text) {
        super(screenHandler, playerInventory, text);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, 348, 243, 512, 512);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected boolean isClickOutsideBounds(double mouseX, double mouseY, int left, int top, int button) {
        return super.isClickOutsideBounds(mouseX, mouseY, (width - backgroundWidth) / 2, (height - backgroundHeight) / 2, button);
    }

    @Override
    protected void init() {
        super.init();
        backgroundWidth = 348;
        backgroundHeight = 243;
        titleX = 10000;
        playerInventoryTitleX = 10000;
    }
}