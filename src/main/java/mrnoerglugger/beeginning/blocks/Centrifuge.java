package mrnoerglugger.beeginning.blocks;

import mrnoerglugger.beeginning.blocks.blockentities.ApiaryBlockEntity;
import mrnoerglugger.beeginning.blocks.blockentities.ApiaryBlockEntityType;
import mrnoerglugger.beeginning.blocks.blockentities.CentrifugeBlockEntity;
import mrnoerglugger.beeginning.blocks.blockentities.CentrifugeBlockEntityType;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import static mrnoerglugger.beeginning.Beeginning.GENERIC_GROUP;
import static mrnoerglugger.beeginning.Beeginning.MODID;

public abstract class Centrifuge extends BlockWithEntity implements InventoryProvider {
    public static final DirectionProperty FACING;
    protected Centrifuge(AbstractBlock.Settings settings) {
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
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            this.openScreen(world, pos, player);
            return ActionResult.CONSUME;
        }
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        world = (World) world;
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof CentrifugeBlockEntity) {
            ItemScatterer.spawn((World) world, pos, (CentrifugeBlockEntity) blockEntity);
            ((World) world).updateComparators(pos, this);
        }
        super.onBroken(world, pos, state);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CentrifugeBlockEntity) {
                ItemScatterer.spawn(world, pos, (CentrifugeBlockEntity)blockEntity);
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
    protected static <T extends BlockEntity> BlockEntityTicker<T> checkType(World world, BlockEntityType<T> givenType, BlockEntityType<? extends CentrifugeBlockEntityType> expectedType) {
        return world.isClient ? null : checkType(givenType, expectedType, CentrifugeBlockEntityType::tick);
    }
}
