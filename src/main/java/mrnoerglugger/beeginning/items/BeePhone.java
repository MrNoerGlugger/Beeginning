package mrnoerglugger.beeginning.items;

import mrnoerglugger.beeginning.screens.BeePhoneScreenHandler;
import mrnoerglugger.beeginning.setup.ImplementedInventory;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static mrnoerglugger.beeginning.Beeginning.GENERIC_GROUP;
import static mrnoerglugger.beeginning.Beeginning.MODID;

public class BeePhone extends Item implements NamedScreenHandlerFactory {
    public static final BeePhone BEEPHONE = new BeePhone(new FabricItemSettings().maxCount(1).group(GENERIC_GROUP));
    public static int[] Climate = {0, 0};

    public BeePhone(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        openGui(user);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    public void openGui(PlayerEntity player) {
        BlockPos pos = player.getBlockPos();
        Biome biome = player.getWorld().getBiome(pos);
        Climate = ArrayUtils.insert(0, Climate, (int) (biome.getTemperature(pos) * 20));
        Climate = ArrayUtils.insert(1, Climate, (int) (biome.getDownfall() * 10));
        if (player.world != null && !player.world.isClient) {
            player.openHandledScreen(this);
        }
    }

    public static void registerBeePhone() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "beephone"), BEEPHONE);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new BeePhoneScreenHandler(syncId, playerInventory, playerEntity);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("BeePhone");
    }
}
