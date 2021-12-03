package mrnoerglugger.beeginning.items;

import mrnoerglugger.beeginning.screens.BeePackScreenHandler;
import mrnoerglugger.beeginning.screens.BeePhoneScreenHandler;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Nullable;

import static mrnoerglugger.beeginning.Beeginning.GENERIC_GROUP;
import static mrnoerglugger.beeginning.Beeginning.MODID;

public class BeePack extends Item implements NamedScreenHandlerFactory {
    public static final BeePack BEEPACK = new BeePack(new FabricItemSettings().maxCount(1).group(GENERIC_GROUP));

    public BeePack(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        openGui(user);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    public void openGui(PlayerEntity player) {
        if (player.world != null && !player.world.isClient) {
            player.openHandledScreen(this);
        }
    }
    public static void registerBeePack() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "beepack"), BEEPACK);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new BeePackScreenHandler(syncId, inv);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("BeePack");
    }
}
