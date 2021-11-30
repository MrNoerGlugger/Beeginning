package mrnoerglugger.beeginning.tags;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ItemTags {
    public static final Tag<Item> PRINCESSES = TagFactory.ITEM.create(new Identifier("beeginning", "princesses"));
    public static final Tag<Item> DRONES = TagFactory.ITEM.create(new Identifier("beeginning", "drones"));
    public static final Tag<Item> QUEENS = TagFactory.ITEM.create(new Identifier("beeginning", "queens"));
    public static final Tag<Item> BEE_FRAMES = TagFactory.ITEM.create(new Identifier("beeginning", "bee_frames"));
    public static final Tag<Item> SCOOP_NETS = TagFactory.ITEM.create(new Identifier("beeginning", "scoop_nets"));
    public static final Tag<Item> COMBS = TagFactory.ITEM.create(new Identifier("beeginning", "combs"));
}
