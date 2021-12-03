package mrnoerglugger.beeginning.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import mrnoerglugger.beeginning.beekeeping.BeeFunctions;
import mrnoerglugger.beeginning.items.BeePhone;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BeePhoneScreen extends HandledScreen<BeePhoneScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("beeginning", "textures/gui/beephone_wiki_gui.png");
    private static final Identifier TEXTURE2 = new Identifier("beeginning", "textures/gui/beephone_wiki_light_gui.png");

    private static final Identifier TEXTURE3 = new Identifier("beeginning", "textures/gui/beephone_analyzer_gui.png");
    private static final Identifier TEXTURE4 = new Identifier("beeginning", "textures/gui/beephone_analyzer_light_gui.png");

    public BeePhoneScreen(BeePhoneScreenHandler screenHandler, PlayerInventory playerInventory, Text text) {
        super(screenHandler, playerInventory, text);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        if (handler.background == 0) {
            WikiBackground(matrices);
        }
        else {
            AnalyzerBackground(matrices);
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
        if (handler.background == 0) {
            x = (width - backgroundWidth) / 2 + 10000;
        }
        backgroundWidth = 422;
        backgroundHeight = 194;
        titleX = 10000;
        playerInventoryTitleX = 10000;
        int x2 = width / 2;
        int y2 = height / 2;
        Text text = Text.of("Analyzer");
        assert client != null;
        assert client.player != null;
        addSelectableChild(new ButtonWidget(x2 - 19, y2 - 97, 70, 12, text, backgroundSwitcher));
        addSelectableChild(new ButtonWidget(x2, y2, 20, 20, Text.of("Mode_Switcher"), textureSwitcher));
    }

    private void WikiBackground(MatrixStack matrices) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0f, 1.0f, 1.0f);
        if (handler.mode == 1) {
            RenderSystem.setShaderTexture(0, TEXTURE2);
        }
        else {
            RenderSystem.setShaderTexture(0, TEXTURE);
        }
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, 422, 194, 512, 512);
    }

    private void AnalyzerBackground(MatrixStack matrices) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0f, 1.0f, 1.0f);
        if (handler.mode == 1) {
            RenderSystem.setShaderTexture(0, TEXTURE4);
        }
        else {
            RenderSystem.setShaderTexture(0, TEXTURE3);
        }
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        int x2 = width / 2;
        int y2 = height / 2;
        drawTexture(matrices, x, y, 0, 0, 422, 194, 512, 512);
        String temp = new BigDecimal(BeePhone.Climate[0]).setScale(0, RoundingMode.HALF_UP) + "°C";
        String down = BeePhone.Climate[1] + "%";
        textRenderer.draw(matrices, temp, x2 + 55, y2 - 54, 0);
        textRenderer.draw(matrices, down, x2 + 55, y2 - 42, 0);
        BeePhoneScreenHandler screen = handler;
        ItemStack honey = screen.getSlot(0).getStack();
        ItemStack drone = screen.getSlot(1).getStack();
        ItemStack princess = screen.getSlot(2).getStack();
        String[] species = BeeFunctions.species;
        double[] lifespan = BeeFunctions.lifespan;
        double[] production = BeeFunctions.production;
        int[] drones = BeeFunctions.drones;
        String[] flowerblocks = {"", "Cactus", "Snow", "Soul", "Chorus", "Amethyst", "Debris"};
        String[] flowertags = {"", "Flowers", "Wood", "Stone", "Nether", "Ore"};
        int[][] AoE = BeeFunctions.AoE;
        String[] time = {"Affected", "Unaffected"};
        String[] framing = {"Unaffected", "Affected"};
        int[][] climate = {BeeFunctions.temperature, BeeFunctions.downfall};
        int[][][] tolerance = {BeeFunctions.temperatureTolerance, BeeFunctions.downfallTolerance};
        if (!drone.isEmpty() && princess.isEmpty() && drone.getNbt() != null) {
            boolean checked = drone.getNbt().getIntArray("checked").length != 0;
            if (drone.getNbt().getIntArray("drone").length != 0 && checked) {
                int[] active = drone.getNbt().getIntArray("drone");
                int[] inactive = drone.getNbt().getIntArray("drone_inactive");
                textRenderer.draw(matrices, species[active[0]], x2 - 164, y2 - 69, 0);
                textRenderer.draw(matrices, species[inactive[0]], x2 + 140, y2 - 69, 0);
                textRenderer.draw(matrices, (int) (lifespan[active[1]] * 100) + "%", x2 - 159, y2 - 55, 0);
                textRenderer.draw(matrices, (int) (lifespan[inactive[1]] * 100) + "%", x2 + 145, y2 - 55, 0);
                textRenderer.draw(matrices, (int) (production[active[2]] * 100) + "%", x2 - 148, y2 - 41, 0);
                textRenderer.draw(matrices, (int) (production[inactive[2]] * 100) + "%", x2 + 156, y2 - 41, 0);
                textRenderer.draw(matrices, drones[active[3]] + "", x2 - 166, y2 - 27, 0);
                textRenderer.draw(matrices, drones[inactive[3]] + "", x2 + 138, y2 - 27, 0);
                if (active[4] != 0) {
                    if (active[5] != 0) {
                        textRenderer.draw(matrices, flowerblocks[active[4]] + ", " + flowertags[active[5]], x2 - 163, y2 - 13, 0);
                    }
                    else {
                        textRenderer.draw(matrices, flowerblocks[active[4]], x2 - 163, y2 - 13, 0);
                    }
                }
                else {
                    textRenderer.draw(matrices, flowertags[active[5]], x2 - 163, y2 - 13, 0);
                }
                if (inactive[4] != 0) {
                    if (inactive[5] != 0) {
                        textRenderer.draw(matrices, flowerblocks[inactive[4]] + ", " + flowertags[inactive[5]], x2 + 141, y2 - 13, 0);
                    }
                    else {
                        textRenderer.draw(matrices, flowerblocks[inactive[4]], x2 + 141, y2 - 13, 0);
                    }
                }
                else {
                    textRenderer.draw(matrices, flowertags[inactive[5]], x2 + 141, y2 - 13, 0);
                }
                textRenderer.draw(matrices, AoE[active[6]][0] + "/" + AoE[active[6]][1] + "/" + AoE[active[6]][2], x2 - 184, y2 + 1, 0);
                textRenderer.draw(matrices, AoE[inactive[6]][0] + "/" + AoE[inactive[6]][1] + "/" + AoE[inactive[6]][2], x2 + 120, y2 + 1, 0);
                textRenderer.draw(matrices, BeeFunctions.effectStrings[active[13]], x2 - 170, y2 + 15, 0);
                textRenderer.draw(matrices, BeeFunctions.effectStrings[inactive[13]], x2 + 134, y2 + 15, 0);
                textRenderer.draw(matrices, framing[active[8]], x2 - 164, y2 + 29, 0);
                textRenderer.draw(matrices, framing[inactive[8]], x2 + 140, y2 + 29, 0);
                textRenderer.draw(matrices, time[active[7]], x2 - 182, y2 + 43, 0);
                textRenderer.draw(matrices, time[inactive[7]], x2 + 122, y2 + 43, 0);
                textRenderer.draw(matrices, climate[0][active[9]] + "°C/" + climate[1][active[10]] + "%", x2 - 169, y2 + 57, 0);
                textRenderer.draw(matrices, climate[0][inactive[9]] + "°C/" + climate[1][inactive[10]] + "%", x2 + 135, y2 + 57, 0);
                textRenderer.draw(matrices, (tolerance[0][active[11]][0] - 10) + "°C/" + (tolerance[0][active[11]][1] + 10) + "°C", x2 - 161, y2 + 71, 0);
                textRenderer.draw(matrices, (tolerance[0][inactive[11]][0] - 10) + "°C/" + (tolerance[0][inactive[11]][1] + 10) + "°C", x2 + 143, y2 + 71, 0);
                textRenderer.draw(matrices, (tolerance[1][active[12]][0] - 20) + "%/" + (tolerance[1][active[12]][1] + 20) + "%", x2 - 161, y2 + 85, 0);
                textRenderer.draw(matrices, (tolerance[1][inactive[12]][0] - 20) + "%/" + (tolerance[1][inactive[12]][1] + 20) + "%", x2 + 143, y2 + 85, 0);
            }
        }
        if (!princess.isEmpty() && princess.getNbt() != null) {
            boolean checked = princess.getNbt().getIntArray("checked").length != 0;
            if (princess.getNbt().getIntArray("princess").length != 0 && checked) {
                int[] active = princess.getNbt().getIntArray("princess");
                int[] inactive = princess.getNbt().getIntArray("princess_inactive");
                textRenderer.draw(matrices, species[active[0]], x2 - 164, y2 - 69, 0);
                textRenderer.draw(matrices, species[inactive[0]], x2 + 140, y2 - 69, 0);
                textRenderer.draw(matrices, (int) (lifespan[active[1]] * 100) + "%", x2 - 159, y2 - 55, 0);
                textRenderer.draw(matrices, (int) (lifespan[inactive[1]] * 100) + "%", x2 + 145, y2 - 55, 0);
                textRenderer.draw(matrices, (int) (production[active[2]] * 100) + "%", x2 - 148, y2 - 41, 0);
                textRenderer.draw(matrices, (int) (production[inactive[2]] * 100) + "%", x2 + 156, y2 - 41, 0);
                textRenderer.draw(matrices, drones[active[3]] + "", x2 - 166, y2 - 27, 0);
                textRenderer.draw(matrices, drones[inactive[3]] + "", x2 + 138, y2 - 27, 0);
                if (active[4] != 0) {
                    if (active[5] != 0) {
                        textRenderer.draw(matrices, flowerblocks[active[4]] + ", " + flowertags[active[5]], x2 - 163, y2 - 13, 0);
                    }
                    else {
                        textRenderer.draw(matrices, flowerblocks[active[4]], x2 - 163, y2 - 13, 0);
                    }
                }
                else {
                    textRenderer.draw(matrices, flowertags[active[5]], x2 - 163, y2 - 13, 0);
                }
                if (inactive[4] != 0) {
                    if (inactive[5] != 0) {
                        textRenderer.draw(matrices, flowerblocks[inactive[4]] + ", " + flowertags[inactive[5]], x2 + 141, y2 - 13, 0);
                    }
                    else {
                        textRenderer.draw(matrices, flowerblocks[inactive[4]], x2 + 141, y2 - 13, 0);
                    }
                }
                else {
                    textRenderer.draw(matrices, flowertags[inactive[5]], x2 + 141, y2 - 13, 0);
                }
                textRenderer.draw(matrices, AoE[active[6]][0] + "/" + AoE[active[6]][1] + "/" + AoE[active[6]][2], x2 - 184, y2 + 1, 0);
                textRenderer.draw(matrices, AoE[inactive[6]][0] + "/" + AoE[inactive[6]][1] + "/" + AoE[inactive[6]][2], x2 + 120, y2 + 1, 0);
                textRenderer.draw(matrices, BeeFunctions.effectStrings[active[13]], x2 - 170, y2 + 15, 0);
                textRenderer.draw(matrices, BeeFunctions.effectStrings[inactive[13]], x2 + 134, y2 + 15, 0);
                textRenderer.draw(matrices, framing[active[8]], x2 - 164, y2 + 29, 0);
                textRenderer.draw(matrices, framing[inactive[8]], x2 + 140, y2 + 29, 0);
                textRenderer.draw(matrices, time[active[7]], x2 - 182, y2 + 43, 0);
                textRenderer.draw(matrices, time[inactive[7]], x2 + 122, y2 + 43, 0);
                textRenderer.draw(matrices, climate[0][active[9]] + "°C/" + climate[1][active[10]] + "%", x2 - 169, y2 + 57, 0);
                textRenderer.draw(matrices, climate[0][inactive[9]] + "°C/" + climate[1][inactive[10]] + "%", x2 + 135, y2 + 57, 0);
                textRenderer.draw(matrices, (tolerance[0][active[11]][0] - 10) + "°C/" + (tolerance[0][active[11]][1] + 10) + "°C", x2 - 161, y2 + 71, 0);
                textRenderer.draw(matrices, (tolerance[0][inactive[11]][0] - 10) + "°C/" + (tolerance[0][inactive[11]][1] + 10) + "°C", x2 + 143, y2 + 71, 0);
                textRenderer.draw(matrices, (tolerance[1][active[12]][0] - 20) + "%/" + (tolerance[1][active[12]][1] + 20) + "%", x2 - 161, y2 + 85, 0);
                textRenderer.draw(matrices, (tolerance[1][inactive[12]][0] - 20) + "%/" + (tolerance[1][inactive[12]][1] + 20) + "%", x2 + 143, y2 + 85, 0);
            }
        }
        assert client != null;
        assert client.player != null;
        handler.updateInventory(honey, drone, princess);
    }

    ButtonWidget.PressAction backgroundSwitcher = button -> {
        if (handler.background == 0) {
            handler.background = 1;
        }
        else handler.background = 0;
        if (x < 10000) {
            x = x + 10000;
        }
        else x = x - 10000;
        handler.writeNbt();
    };

    ButtonWidget.PressAction textureSwitcher = button -> {
        if (handler.mode == 0) {
            handler.mode = 1;
        }
        else handler.mode = 0;
        handler.writeNbt();
    };
}