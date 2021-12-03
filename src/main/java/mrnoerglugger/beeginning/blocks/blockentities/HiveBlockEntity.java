package mrnoerglugger.beeginning.blocks.blockentities;

import mrnoerglugger.beeginning.items.ScoopItem;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

import java.util.List;

public class HiveBlockEntity extends BlockEntity {
    int time = 0;

    public HiveBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, HiveBlockEntity be) {
        List<? extends PlayerEntity> list = world.getPlayers();
        for (int i = 0; i < list.size(); i++) {
            PlayerEntity player = list.get(i);
            if (player != null) {
                Position pos2 = player.getPos();
                BlockPos pos3 = new BlockPos(pos.getX() - pos2.getX(), pos.getY() - pos2.getY(), pos.getZ() - pos2.getZ());
                double d = Math.sqrt(pos3.getX() * pos3.getX() + pos3.getY() * pos3.getY() + pos3.getZ() * pos3.getZ());
                if (d < 5) {
                    Position pos4 = player.raycast(5, 0, false).getPos();
                    BlockPos pos1 = new BlockPos(pos4.getX(), pos4.getY(), pos4.getZ());
                    if (checkPos(pos, pos1) && player.handSwinging && !(player.getStackInHand(player.getActiveHand()).getItem() instanceof ScoopItem)) {
                        be.time = 400;
                    }
                    if (be.time > 0) {
                        player.damage(DamageSource.MAGIC, 1);
                    }
                    world.setBlockState(pos, world.getBlockState(pos).getBlock().getDefaultState());
                }
            }
        }
        if (be.time > 0) {
            be.time--;
        }
    }

    private static boolean checkPos(BlockPos pos1, BlockPos pos2) {
        if (pos1.getX() == pos2.getX() && pos1.getY() == pos2.getY() && (pos1.getZ() + 1 == pos2.getZ() || pos1.getZ() - 1 == pos2.getZ())) {
            return true;
        }
        else if (pos1.getX() == pos2.getX() && (pos1.getY() + 1 == pos2.getY() || pos1.getY() - 1 == pos2.getY()) && pos1.getZ() == pos2.getZ()) {
            return true;
        }
        else if ((pos1.getX() + 1 == pos2.getX() || pos1.getX() - 1 == pos2.getX()) && pos1.getY() == pos2.getY() && pos1.getZ() == pos2.getZ()) {
            return true;
        }
        else return false;
    }
}
