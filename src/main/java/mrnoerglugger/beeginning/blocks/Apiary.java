package mrnoerglugger.beeginning.blocks;

import mrnoerglugger.beeginning.blocks.blockentities.ApiaryBlockEntity;
import mrnoerglugger.beeginning.blocks.blockentities.ApiaryBlockEntityType;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Nullable;

public abstract class Apiary extends BlockWithEntity implements InventoryProvider{
    public static int[] Climate = {0, 0};
    public static final DirectionProperty FACING;
    public Apiary(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.getDefaultState()).with(FACING, Direction.NORTH));
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }


    protected abstract void openScreen(World world, BlockPos pos, PlayerEntity player);

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        return (SidedInventory) world.getBlockEntity(pos);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Biome biome = world.getBiome(pos);
        Climate = ArrayUtils.insert(0, Climate, (int) (biome.getTemperature() * 20));
        Climate = ArrayUtils.insert(1, Climate, (int) (biome.getDownfall() * 100));
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            this.openScreen(world, pos, player);
            return ActionResult.CONSUME;
        }
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof ApiaryBlockEntity) {
            ItemScatterer.spawn((World) world, pos, (ApiaryBlockEntity) blockEntity);
            ((World) world).updateComparators(pos, this);
        }
        super.onBroken(world, pos, state);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ApiaryBlockEntity) {
                ItemScatterer.spawn(world, pos, (ApiaryBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }


    static {
        FACING = HorizontalFacingBlock.FACING;
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> checkType(World world, BlockEntityType<T> givenType, BlockEntityType<? extends ApiaryBlockEntityType> expectedType) {
        return world.isClient ? null : checkType(givenType, expectedType, ApiaryBlockEntityType::tick);
    }
}
