package mrnoerglugger.beeginning.tags;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class BlockTags {
    public static final Tag.Identified<Block> SCOOP_NET_MINEABLE = TagFactory.BLOCK.create(new Identifier("beeginning", "mineable/scoop_nets"));
}
