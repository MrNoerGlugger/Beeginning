package mrnoerglugger.beeginning.setup;

import mrnoerglugger.beeginning.items.BeePhone;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.stream.Stream;

public class ServerNetwork {

    public static Identifier OPEN_BEEPHONE = new Identifier("beeginning", "open_beephone");

    public static void init() {
        registerBeePhonePacketHandler();
    }

    private static void registerBeePhonePacketHandler() {
        ServerPlayNetworking.registerGlobalReceiver(OPEN_BEEPHONE, ServerNetwork::receiveBeePhonePacket);
    }

    private static void receiveBeePhonePacket(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        ItemStack item = Stream.concat(player.getInventory().offHand.stream(), player.getInventory().main.stream())
                .filter((itemStack) -> itemStack.getItem() instanceof BeePhone)
                .findFirst()
                .orElse(ItemStack.EMPTY);
        if (item != ItemStack.EMPTY) {
            BeePhone beePhone = (BeePhone) item.getItem();
            beePhone.openGui(player);
        }
    }
}