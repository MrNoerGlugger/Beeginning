package mrnoerglugger.beeginning.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import mrnoerglugger.beeginning.blocks.Apiary;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ApiaryScreen extends HandledScreen<ApiaryScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("beeginning", "textures/gui/apiary_gui.png");
    private static final Identifier TEXTURE2 = new Identifier("beeginning", "textures/gui/checkmark.png");
    private static final Identifier TEXTURE3 = new Identifier("beeginning", "textures/gui/red_x.png");

    public ApiaryScreen(ApiaryScreenHandler handler, PlayerInventory inventory, Text text) {
        super(handler, inventory, text);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        int x2 = width / 2;
        int y2 = height / 2;
        drawTexture(matrices, x, y, 0, 0, 235, 184);
        String temp = new BigDecimal(Apiary.Climate[0]).setScale(0, RoundingMode.HALF_UP) + "°C";
        String down = Apiary.Climate[1] + "%";
        textRenderer.draw(matrices, temp, x2 + 92, y2 - 73, 0);
        textRenderer.draw(matrices, down, x2 + 92, y2 - 55, 0);
        ItemStack queen = getScreenHandler().slots.get(2).getStack();
        if (!queen.isEmpty()) {
            NbtCompound nbt = queen.getNbt();
            boolean flowers = nbt.getBoolean("flowers");
            boolean time = nbt.getBoolean("time");
            boolean climate = nbt.getBoolean("climate");
            RenderSystem.setShaderTexture(0, TEXTURE2);
            if (!flowers) {
                RenderSystem.setShaderTexture(0, TEXTURE3);
            }
            drawTexture(matrices, x + 9, y + 11, 0, 0, 12, 12, 12, 12);
            RenderSystem.setShaderTexture(0, TEXTURE2);
            if (!time) {
                RenderSystem.setShaderTexture(0, TEXTURE3);
            }
            drawTexture(matrices, x + 9, y + 23, 0, 0, 12, 12, 12, 12);
            RenderSystem.setShaderTexture(0, TEXTURE2);
            if (!climate) {
                RenderSystem.setShaderTexture(0, TEXTURE3);
            }
            drawTexture(matrices, x + 9, y + 35, 0, 0, 12, 12, 12, 12);
        }
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
        backgroundWidth = 220;
        backgroundHeight = 184;
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2 + 10000;
        playerInventoryTitleX = (backgroundWidth - textRenderer.getWidth(title)) / 2 + 10000;
    }
}
