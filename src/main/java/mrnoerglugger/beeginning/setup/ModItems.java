package mrnoerglugger.beeginning.setup;

import static mrnoerglugger.beeginning.items.BeePack.registerBeePack;
import static mrnoerglugger.beeginning.items.BeePhone.registerBeePhone;
import static mrnoerglugger.beeginning.items.Frames.registerFrames;
import static mrnoerglugger.beeginning.items.HoneyDrops.registerHoneyDrops;
import static mrnoerglugger.beeginning.items.ScoopNets.registerScoopNets;
import static mrnoerglugger.beeginning.setup.BeeRegistry.registerBees;
import static mrnoerglugger.beeginning.setup.CombRegistry.registerCombs;

public class ModItems {
    public static void registerItems() {
        registerCombs();
        registerBees();
        registerFrames();
        registerScoopNets();
        registerHoneyDrops();
        registerBeePhone();
        registerBeePack();
    }
}