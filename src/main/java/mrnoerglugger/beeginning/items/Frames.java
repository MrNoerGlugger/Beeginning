package mrnoerglugger.beeginning.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static mrnoerglugger.beeginning.Beeginning.GENERIC_GROUP;
import static mrnoerglugger.beeginning.Beeginning.MODID;

public class Frames {
    public static final Item FRAME = new Item(new FabricItemSettings().maxCount(1).group(GENERIC_GROUP));

    public static void registerFrames() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "frame"), FRAME);
    }
}
