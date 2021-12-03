package mrnoerglugger.beeginning.blocks;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.netty.buffer.Unpooled;
import mrnoerglugger.beeginning.Beeginning;
import mrnoerglugger.beeginning.blocks.blockentities.HiveBlockEntity;
import mrnoerglugger.beeginning.blocks.blockentities.HiveBlockEntityType;
import mrnoerglugger.beeginning.items.bees.PrimordialBee;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class HiveBlock extends BlockWithEntity {
    final Item effect;

    public HiveBlock(Settings settings, Item effect) {
        super(settings);
        this.effect = effect;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, Beeginning.HIVE_BLOCK_ENTITY, HiveBlockEntity::tick);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, new ItemStack(effect)), pos.getX() + 0.5, pos.getY() + 2, pos.getZ() + 0.5, 0.0, 0.0, 0.0);
    }


    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new HiveBlockEntityType(pos, state);
    }
}
