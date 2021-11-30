package mrnoerglugger.beeginning.blocks;

import mrnoerglugger.beeginning.Beeginning;
import mrnoerglugger.beeginning.blocks.blockentities.CentrifugeBlockEntity;
import mrnoerglugger.beeginning.blocks.blockentities.CentrifugeBlockEntityType;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static mrnoerglugger.beeginning.Beeginning.GENERIC_GROUP;
import static mrnoerglugger.beeginning.Beeginning.MODID;

public class CentrifugeBlock extends Centrifuge{
    protected CentrifugeBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, Beeginning.CENTRIFUGE_BLOCK_ENTITY, CentrifugeBlockEntity::tick);
    }

    protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof CentrifugeBlockEntity) {
            player.openHandledScreen((NamedScreenHandlerFactory)blockEntity);
            player.incrementStat(Beeginning.APIARY_INTERACTIONS);
        }
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CentrifugeBlockEntityType(pos, state);
    }

    public static Centrifuge CENTRIFUGE;
    public static void registerCentrifuge() {
        CENTRIFUGE = new CentrifugeBlock(FabricBlockSettings.of(Material.METAL).nonOpaque().requiresTool().strength(5.0f, 30.0f));
        Registry.register(Registry.BLOCK, new Identifier(MODID, "centrifuge"), CENTRIFUGE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "centrifuge"), new BlockItem(CENTRIFUGE, new FabricItemSettings().group(GENERIC_GROUP)));
    }
}
