package mrnoerglugger.beeginning.setup;

import static mrnoerglugger.beeginning.items.combs.BaseCombs.registerBaseCombs;
import static mrnoerglugger.beeginning.items.combs.DyeCombs.registerDyeCombs;
import static mrnoerglugger.beeginning.items.combs.OreCombs.registerOreCombs;
import static mrnoerglugger.beeginning.items.combs.TierCombs.registerTierCombs;

public class CombRegistry {
    public static void registerCombs() {
        registerTierCombs();
        registerBaseCombs();
        registerOreCombs();
        registerDyeCombs();
    }
}
