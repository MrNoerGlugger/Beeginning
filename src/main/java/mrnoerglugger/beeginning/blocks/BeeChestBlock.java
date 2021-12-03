package mrnoerglugger.beeginning.blocks;

import mrnoerglugger.beeginning.blocks.blockentities.BeeChestBlockEntityType;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

import static mrnoerglugger.beeginning.Beeginning.GENERIC_GROUP;
import static mrnoerglugger.beeginning.Beeginning.MODID;

public class BeeChestBlock extends BeeChest{
    protected BeeChestBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (player.world != null && !player.world.isClient && blockEntity instanceof BeeChestBlockEntityType) {
            player.openHandledScreen((NamedScreenHandlerFactory) blockEntity);
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BeeChestBlockEntityType(pos, state);
    }

    public static BeeChest BEE_CHEST;

    public static void registerBeeChest() {
        BEE_CHEST = new BeeChestBlock(FabricBlockSettings.of(Material.WOOD).strength(4.0f).sounds(BlockSoundGroup.WOOD));
        Registry.register(Registry.BLOCK, new Identifier(MODID, "bee_chest"), BEE_CHEST);
        Registry.register(Registry.ITEM, new Identifier(MODID, "bee_chest"), new BlockItem(BEE_CHEST, new FabricItemSettings().group(GENERIC_GROUP)));
    }
}
