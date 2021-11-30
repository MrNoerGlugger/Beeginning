package mrnoerglugger.beeginning.blocks;

import mrnoerglugger.beeginning.Beeginning;
import mrnoerglugger.beeginning.blocks.blockentities.ApiaryBlockEntity;
import mrnoerglugger.beeginning.blocks.blockentities.ApiaryBlockEntityType;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Nullable;

import static mrnoerglugger.beeginning.Beeginning.GENERIC_GROUP;
import static mrnoerglugger.beeginning.Beeginning.MODID;

public class ApiaryBlock extends Apiary {
    public static float[] Climate = {0, 0};
    protected ApiaryBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, Beeginning.APIARY_BLOCK_ENTITY, ApiaryBlockEntity::tick);
    }

    protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
        Biome biome = world.getBiome(pos);
        Climate = ArrayUtils.insert(0, Climate, biome.getTemperature());
        Climate = ArrayUtils.insert(1, Climate, biome.getDownfall());
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (player.world != null && !player.world.isClient && blockEntity instanceof ApiaryBlockEntityType) {
            player.openHandledScreen((NamedScreenHandlerFactory)blockEntity);
            player.incrementStat(Beeginning.APIARY_INTERACTIONS);
        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ApiaryBlockEntityType(pos, state);
    }

    public static Apiary APIARY;
    public static Apiary APIARY2;

    public static void registerApiary() {
        APIARY = new ApiaryBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).strength(4.0f).sounds(BlockSoundGroup.WOOD));
        APIARY2 = new ApiaryBlock(FabricBlockSettings.of(Material.WOOD).luminance(12).strength(4.0f).sounds(BlockSoundGroup.WOOD));
        Registry.register(Registry.BLOCK, new Identifier(MODID, "apiary"), APIARY);
        Registry.register(Registry.ITEM, new Identifier(MODID, "apiary"), new BlockItem(APIARY, new FabricItemSettings().group(GENERIC_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(MODID, "apiary2"), APIARY2);
        Registry.register(Registry.ITEM, new Identifier(MODID, "apiary2"), new BlockItem(APIARY2, new FabricItemSettings()));
    }
}
