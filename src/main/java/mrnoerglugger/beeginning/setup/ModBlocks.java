package mrnoerglugger.beeginning.setup;

import static mrnoerglugger.beeginning.blocks.ApiaryBlock.registerApiary;
import static mrnoerglugger.beeginning.blocks.CentrifugeBlock.registerCentrifuge;

public class ModBlocks {
    public static void RegisterBlocks() {
        registerCentrifuge();
        registerApiary();
    }
}
