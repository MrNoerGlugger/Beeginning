package mrnoerglugger.beeginning.beekeeping;

import mrnoerglugger.beeginning.blocks.blockentities.ApiaryBlockEntity;
import mrnoerglugger.beeginning.items.bees.*;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class BeeDefaultValues {
    static int[] plain = {0, 1, 0, 1, 0, 1, 0, 0, 1, 4, 2, 0, 0};
    static int[] woodland = {0, 1, 0, 1, 0, 2, 0, 0, 1, 4, 3, 3, 1};
    static int[] betula = {0, 1, 0, 1, 0, 2, 0, 0, 1, 3, 2, 0, 2};
    static int[] twilight = {0, 1, 0, 1, 0, 2, 0, 0, 1, 3, 3, 0, 0};
    static int[] thicket = {0, 1, 0, 1, 0, 2, 0, 0, 1, 4, 4, 0, 0};
    static int[] snowing = {0, 1, 0, 1, 2, 2, 0, 0, 1, 2, 3, 1, 1};
    static int[] baobab = {0, 1, 0, 1, 0, 2, 0, 0, 1, 5, 0, 0, 0};
    static int[] warped = {0, 1, 0, 1, 0, 2, 0, 1, 1, 6, 0, 0, 0};
    static int[] crimson = {0, 1, 0, 1, 0, 2, 0, 1, 1, 6, 0, 0, 0};
    static int[] shroomy = {0, 1, 0, 1, 0, 1, 0, 0, 1, 4, 4, 0, 0};
    static int[] dry = {0, 1, 0, 1, 1, 0, 0, 0, 1, 6, 0, 0, 0};
    static int[] mesa = {0, 1, 0, 1, 1, 0, 0, 0, 1, 6, 0, 0, 0};
    static int[] morass = {0, 1, 0, 1, 0, 1, 0, 0, 1, 4, 4, 0, 0};
    static int[] blooming = {0, 1, 0, 1, 0, 1, 0, 0, 1, 3, 3, 0, 0};
    static int[] sea = {0, 1, 0, 1, 0, 1, 0, 1, 1, 3, 2, 0, 0};
    static int[] freezing = {0, 1, 0, 1, 2, 0, 0, 0, 1, 0, 3, 2, 1};
    static int[] mountainous = {0, 1, 0, 1, 0, 3, 0, 0, 1, 3, 1, 0, 0};
    static int[] caving = {0, 1, 0, 1, 0, 3, 0, 1, 1, 3, 2, 0, 3};
    static int[] wasting = {0, 1, 0, 1, 3, 4, 0, 1, 1, 6, 0, 0, 0};
    static int[] valley = {0, 1, 0, 1, 3, 4, 0, 1, 1, 6, 0, 0, 0};
    static int[] delta = {0, 1, 0, 1, 3, 4, 0, 1, 1, 6, 0, 0, 0};
    static int[] finalis = {0, 1, 0, 1, 4, 0, 0, 1, 1, 3, 2, 0, 0};
    static int[] void1 = {0, 1, 0, 1, 4, 0, 0, 1, 1, 3, 2, 0, 0};
    static int[] ordinary = {0, 2, 1, 0, 0, 1, 0, 0, 1, 3, 2, 8, 3};
    static int[] advanced = {0, 3, 2, 0, 0, 1, 0, 0, 1, 3, 2, 8, 3};
    static int[] noteworthy = {0, 4, 2, 0, 0, 1, 1, 0, 1, 3, 2, 8, 3};
    static int[] extraordinary = {0, 5, 3, 0, 0, 1, 1, 1, 1, 3, 2, 8, 3};
    static int[] miraculous = {0, 6, 4, 0, 0, 1, 2, 1, 1, 3, 2, 8, 3};
    static int[] carbo = {0, 4, 2, 2, 0, 5, 1, 1, 1, 3, 2, 0, 3};
    static int[] glowing = {0, 2, 4, 3, 0, 5, 1, 1, 1, 6, 0, 0, 0};
    static int[] cuprum = {0, 3, 1, 2, 0, 5, 1, 1, 1, 3, 2, 0, 3};
    static int[] ferrum = {0, 3, 1, 1, 0, 5, 0, 1, 1, 3, 2, 0, 3};
    static int[] silica = {0, 4, 4, 1, 0, 5, 0, 1, 0, 6, 0, 0, 0};
    static int[] engineered = {0, 0, 6, 2, 0, 5, 0, 1, 1, 3, 2, 0, 3};
    static int[] aurum = {0, 5, 5, 1, 0, 5, 0, 1, 1, 3, 2, 0, 3};
    static int[] lazurite = {0, 2, 4, 0, 0, 5, 0, 1, 1, 3, 2, 0, 3};
    static int[] crystal = {0, 4, 4, 3, 5, 0, 2, 1, 1, 3, 2, 0, 3};
    static int[] shining = {0, 5, 5, 1, 0, 5, 0, 1, 1, 3, 2, 0, 3};
    static int[] smaragdus = {0, 5, 3, 0, 0, 5, 0, 1, 1, 3, 2, 0, 3};
    static int[] primordial = {0, 5, 4, 0, 6, 0, 4, 1, 0, 6, 0, 0, 0};
    static int[] amaryllis = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] begonia = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] fuchsia = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] forget_me_not = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] marigold = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] bells_of_ireland = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] azalea = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] santolina = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] allium = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] ipomoea = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] lavender = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] periwinkle = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] cattleya_velutina = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] gerbera_daisy = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] rose = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] queen_of_the_night_tulip = {0, 4, 4, 1, 0, 1, 3, 0, 1, 3, 3, 0, 0};
    static int[] rainbow = {0, 5, 5, 2, 0, 1, 3, 0, 1, 3, 3, 0, 0};

    static String e0 = "None";
    static String e1 = "Ore-I-Fication";
    static String e2 = "Coloring";

    static String[] species = {};
    static int[][] defaultValues= {};
    static Item[] Queens = {};
    static Item[] Drones = {};
    static Item[] Princesses = {};
    static DefaultedList[] Outputs = {};
    static DefaultedList[] CombOutputs = {};
    static int[][][] MutationList = {{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};
    static double[] MutationChance = {};
    public static int[] effectArray = {};
    public static List listList = new ArrayList();
    public static String[] effectStrings = {};

    public static List createBeeList(int i, String s, int[] ii, Item item1, Item item2, Item item3, DefaultedList list1, DefaultedList list2, String[][] sss, double d, int effect) {
        List list = new ArrayList();
        list.add(0, i);
        list.add(1, s);
        ii[0] = i;
        ii = ArrayUtils.insert(13, ii, effect);
        list.add(2, ii);
        list.add(3, item1);
        list.add(4, item2);
        list.add(5, item3);
        list.add(6, list1);
        list.add(7, list2);
        list.add(8, sss);
        list.add(9, d);
        list.add(10, effect);
        return list;
    }

    public static List createBaseBeeList() {
        List list = new ArrayList();
        list.add(0, createBeeList(0, "plain", plain, PlainBee.PLAIN_QUEEN, PlainBee.PLAIN_DRONE, PlainBee.PLAIN_PRINCESS, PlainBee.PlainOutput, PlainBee.PlainCombOutput, PlainBee.PlainMutations, 0, getEffectInt(e0)));
        list.add(1, createBeeList(1, "woodland", woodland, WoodlandBee.WOODLAND_QUEEN, WoodlandBee.WOODLAND_DRONE, WoodlandBee.WOODLAND_PRINCESS, WoodlandBee.WoodlandOutput, WoodlandBee.WoodlandCombOutput, WoodlandBee.WoodlandMutations, 0, getEffectInt(e0)));
        list.add(2, createBeeList(2, "betula", betula, BetulaBee.BETULA_QUEEN, BetulaBee.BETULA_DRONE, BetulaBee.BETULA_PRINCESS, BetulaBee.BetulaOutput, BetulaBee.BetulaCombOutput, BetulaBee.BetulaMutations, 0, getEffectInt(e0)));
        list.add(3, createBeeList(3, "twilight", twilight, TwilightBee.TWILIGHT_QUEEN, TwilightBee.TWILIGHT_DRONE, TwilightBee.TWILIGHT_PRINCESS, TwilightBee.TwilightOutput, TwilightBee.TwilightCombOutput, TwilightBee.TwilightMutations, 0, getEffectInt(e0)));
        list.add(4, createBeeList(4, "thicket", thicket, ThicketBee.THICKET_QUEEN, ThicketBee.THICKET_DRONE, ThicketBee.THICKET_PRINCESS, ThicketBee.ThicketOutput, ThicketBee.ThicketCombOutput, ThicketBee.ThicketMutations, 0, 0));
        list.add(5, createBeeList(5, "snowing", snowing, SnowingBee.SNOWING_QUEEN, SnowingBee.SNOWING_DRONE, SnowingBee.SNOWING_PRINCESS, SnowingBee.SnowingOutput, SnowingBee.SnowingCombOutput, SnowingBee.SnowingMutations, 0, 0));
        list.add(6, createBeeList(6, "baobab", baobab, BaobabBee.BAOBAB_QUEEN, BaobabBee.BAOBAB_DRONE, BaobabBee.BAOBAB_PRINCESS, BaobabBee.BaobabOutput, BaobabBee.BaobabCombOutput, BaobabBee.BaobabMutations, 0, getEffectInt(e0)));
        list.add(7, createBeeList(7, "warped", warped, WarpedBee.WARPED_QUEEN, WarpedBee.WARPED_DRONE, WarpedBee.WARPED_PRINCESS, WarpedBee.WarpedOutput, WarpedBee.WarpedCombOutput, WarpedBee.WarpedMutations, 0, getEffectInt(e0)));
        list.add(8, createBeeList(8, "crimson", crimson, CrimsonBee.CRIMSON_QUEEN, CrimsonBee.CRIMSON_DRONE, CrimsonBee.CRIMSON_PRINCESS, CrimsonBee.CrimsonOutput, CrimsonBee.CrimsonCombOutput, CrimsonBee.CrimsonMutations, 0, getEffectInt(e0)));
        list.add(9, createBeeList(9, "shroomy", shroomy, ShroomyBee.SHROOMY_QUEEN, ShroomyBee.SHROOMY_DRONE, ShroomyBee.SHROOMY_PRINCESS, ShroomyBee.ShroomyOutput, ShroomyBee.ShroomyCombOutput, ShroomyBee.ShroomyMutations, 0, getEffectInt(e0)));
        list.add(10, createBeeList(10, "dry", dry, DryBee.DRY_QUEEN, DryBee.DRY_DRONE, DryBee.DRY_PRINCESS, DryBee.DryOutput, DryBee.DryCombOutput, DryBee.DryMutations, 0, getEffectInt(e0)));
        list.add(11, createBeeList(11, "mesa", mesa, MesaBee.MESA_QUEEN, MesaBee.MESA_DRONE, MesaBee.MESA_PRINCESS, MesaBee.MesaOutput, MesaBee.MesaCombOutput, MesaBee.MesaMutations, 0, getEffectInt(e0)));
        list.add(12, createBeeList(12, "morass", morass, MorassBee.MORASS_QUEEN, MorassBee.MORASS_DRONE, MorassBee.MORASS_PRINCESS, MorassBee.MorassOutput, MorassBee.MorassCombOutput, MorassBee.MorassMutations, 0, getEffectInt(e0)));
        list.add(13, createBeeList(13, "blooming", blooming, BloomingBee.BLOOMING_QUEEN, BloomingBee.BLOOMING_DRONE, BloomingBee.BLOOMING_PRINCESS, BloomingBee.BloomingOutput, BloomingBee.BloomingCombOutput, BloomingBee.BloomingMutations, 0, getEffectInt(e0)));
        list.add(14, createBeeList(14, "sea", sea, SeaBee.SEA_QUEEN, SeaBee.SEA_DRONE, SeaBee.SEA_PRINCESS, SeaBee.SeaOutput, SeaBee.SeaCombOutput, SeaBee.SeaMutations, 0, getEffectInt(e0)));
        list.add(15, createBeeList(15, "freezing", freezing, FreezingBee.FREEZING_QUEEN, FreezingBee.FREEZING_DRONE, FreezingBee.FREEZING_PRINCESS, FreezingBee.FreezingOutput, FreezingBee.FreezingCombOutput, FreezingBee.FreezingMutations, 0, getEffectInt(e0)));
        list.add(16, createBeeList(16, "mountainous", mountainous, MountainousBee.MOUNTAINOUS_QUEEN, MountainousBee.MOUNTAINOUS_DRONE, MountainousBee.MOUNTAINOUS_PRINCESS, MountainousBee.MountainousOutput, MountainousBee.MountainousCombOutput, MountainousBee.MountainousMutations, 0, getEffectInt(e0)));
        list.add(17, createBeeList(17, "caving", caving, CavingBee.CAVING_QUEEN, CavingBee.CAVING_DRONE, CavingBee.CAVING_PRINCESS, CavingBee.CavingOutput, CavingBee.CavingCombOutput, CavingBee.CavingMutations, 0, getEffectInt(e0)));
        list.add(18, createBeeList(18, "wasting", wasting, WastingBee.WASTING_QUEEN, WastingBee.WASTING_DRONE, WastingBee.WASTING_PRINCESS, WastingBee.WastingOutput, WastingBee.WastingCombOutput, WastingBee.WastingMutations, 0, getEffectInt(e0)));
        list.add(19, createBeeList(19, "valley", valley, ValleyBee.VALLEY_QUEEN, ValleyBee.VALLEY_DRONE, ValleyBee.VALLEY_PRINCESS, ValleyBee.ValleyOutput, ValleyBee.ValleyCombOutput, ValleyBee.ValleyMutations, 0, getEffectInt(e0)));
        list.add(20, createBeeList(20, "delta", delta, DeltaBee.DELTA_QUEEN, DeltaBee.DELTA_DRONE, DeltaBee.DELTA_PRINCESS, DeltaBee.DeltaOutput, DeltaBee.DeltaCombOutput, DeltaBee.DeltaMutations, 0, getEffectInt(e0)));
        list.add(21, createBeeList(21, "finalis", finalis, FinalisBee.FINALIS_QUEEN, FinalisBee.FINALIS_DRONE, FinalisBee.FINALIS_PRINCESS, FinalisBee.FinalisOutput, FinalisBee.FinalisCombOutput, FinalisBee.FinalisMutations, 0, getEffectInt(e0)));
        list.add(22, createBeeList(22, "void", void1, VoidBee.VOID_QUEEN, VoidBee.VOID_DRONE, VoidBee.VOID_PRINCESS, VoidBee.VoidOutput, VoidBee.VoidCombOutput, VoidBee.VoidMutations, 0, getEffectInt(e0)));
        return list;
    }

    public static void registerBeeValues(List list) {
        list.add(list.size(), createBeeList(list.size(), "ordinary", ordinary, OrdinaryBee.ORDINARY_QUEEN, OrdinaryBee.ORDINARY_DRONE, OrdinaryBee.ORDINARY_PRINCESS, OrdinaryBee.OrdinaryOutput, OrdinaryBee.OrdinaryCombOutput, OrdinaryBee.OrdinaryMutations, 0, getEffectInt(e0)));
        list.add(list.size(), createBeeList(list.size(), "advanced", advanced, AdvancedBee.ADVANCED_QUEEN, AdvancedBee.ADVANCED_DRONE, AdvancedBee.ADVANCED_PRINCESS, AdvancedBee.AdvancedOutput, AdvancedBee.AdvancedCombOutput, AdvancedBee.AdvancedMutations, 0, getEffectInt(e0)));
        list.add(list.size(), createBeeList(list.size(), "noteworthy", noteworthy, NoteworthyBee.NOTEWORTHY_QUEEN, NoteworthyBee.NOTEWORTHY_DRONE, NoteworthyBee.NOTEWORTHY_PRINCESS, NoteworthyBee.NoteworthyOutput, NoteworthyBee.NoteworthyCombOutput, NoteworthyBee.NoteworthyMutations, 0, getEffectInt(e0)));
        list.add(list.size(), createBeeList(list.size(), "extraordinary", extraordinary, ExtraordinaryBee.EXTRAORDINARY_QUEEN, ExtraordinaryBee.EXTRAORDINARY_DRONE, ExtraordinaryBee.EXTRAORDINARY_PRINCESS, ExtraordinaryBee.ExtraordinaryOutput, ExtraordinaryBee.ExtraordinaryCombOutput, ExtraordinaryBee.ExtraordinaryMutations, 0, getEffectInt(e0)));
        list.add(list.size(), createBeeList(list.size(), "miraculous", miraculous, MiraculousBee.MIRACULOUS_QUEEN, MiraculousBee.MIRACULOUS_DRONE, MiraculousBee.MIRACULOUS_PRINCESS, MiraculousBee.MiraculousOutput, MiraculousBee.MiraculousCombOutput, MiraculousBee.MiraculousMutations, 0, getEffectInt(e0)));
        list.add(list.size(), createBeeList(list.size(), "carbo", carbo, CarboBee.CARBO_QUEEN, CarboBee.CARBO_DRONE, CarboBee.CARBO_PRINCESS, CarboBee.CarboOutput, CarboBee.CarboCombOutput, CarboBee.CarboMutations, 0.2, getEffectInt(e1)));
        list.add(list.size(), createBeeList(list.size(), "glowing", glowing, GlowingBee.GLOWING_QUEEN, GlowingBee.GLOWING_DRONE, GlowingBee.GLOWING_PRINCESS, GlowingBee.GlowingOutput, GlowingBee.GlowingCombOutput, GlowingBee.GlowingMutations, 0.2, getEffectInt(e1)));
        list.add(list.size(), createBeeList(list.size(), "ferrum", ferrum, FerrumBee.FERRUM_QUEEN, FerrumBee.FERRUM_DRONE, FerrumBee.FERRUM_PRINCESS, FerrumBee.FerrumOutput, FerrumBee.FerrumCombOutput, FerrumBee.FerrumMutations, 0.1, getEffectInt(e1)));
        list.add(list.size(), createBeeList(list.size(), "cuprum", cuprum, CuprumBee.CUPRUM_QUEEN, CuprumBee.CUPRUM_DRONE, CuprumBee.CUPRUM_PRINCESS, CuprumBee.CuprumOutput, CuprumBee.CuprumCombOutput, CuprumBee.CuprumMutations, 0.1, getEffectInt(e1)));
        list.add(list.size(), createBeeList(list.size(), "silica", silica, SilicaBee.SILICA_QUEEN, SilicaBee.SILICA_DRONE, SilicaBee.SILICA_PRINCESS, SilicaBee.SilicaOutput, SilicaBee.SilicaCombOutput, SilicaBee.SilicaMutations, 0.05, getEffectInt(e1)));
        list.add(list.size(), createBeeList(list.size(), "engineered", engineered, EngineeredBee.ENGINEERED_QUEEN, EngineeredBee.ENGINEERED_DRONE, EngineeredBee.ENGINEERED_PRINCESS, EngineeredBee.EngineeredOutput, EngineeredBee.EngineeredCombOutput, EngineeredBee.EngineeredMutations, 0.05, getEffectInt(e1)));
        list.add(list.size(), createBeeList(list.size(), "aurum", aurum, AurumBee.AURUM_QUEEN, AurumBee.AURUM_DRONE, AurumBee.AURUM_PRINCESS, AurumBee.AurumOutput, AurumBee.AurumCombOutput, AurumBee.AurumMutations, 0.05, getEffectInt(e1)));
        list.add(list.size(), createBeeList(list.size(), "lazurite", lazurite, LazuriteBee.LAZURITE_QUEEN, LazuriteBee.LAZURITE_DRONE, LazuriteBee.LAZURITE_PRINCESS, LazuriteBee.LazuriteOutput, LazuriteBee.LazuriteCombOutput, LazuriteBee.LazuriteMutations, 0.05, getEffectInt(e1)));
        list.add(list.size(), createBeeList(list.size(), "crystal", crystal, CrystalBee.CRYSTAL_QUEEN, CrystalBee.CRYSTAL_DRONE, CrystalBee.CRYSTAL_PRINCESS, CrystalBee.CrystalOutput, CrystalBee.CrystalCombOutput, CrystalBee.CrystalMutations, 0.05, getEffectInt(e1)));
        list.add(list.size(), createBeeList(list.size(), "shining", shining, ShiningBee.SHINING_QUEEN, ShiningBee.SHINING_DRONE, ShiningBee.SHINING_PRINCESS, ShiningBee.ShiningOutput, ShiningBee.ShiningCombOutput, ShiningBee.ShiningMutations, 0.025, getEffectInt(e1)));
        list.add(list.size(), createBeeList(list.size(), "smaragdus", smaragdus, SmaragdusBee.SMARAGDUS_QUEEN, SmaragdusBee.SMARAGDUS_DRONE, SmaragdusBee.SMARAGDUS_PRINCESS, SmaragdusBee.SmaragdusOutput, SmaragdusBee.SmaragdusCombOutput, SmaragdusBee.SmaragdusMutations, 0.025, getEffectInt(e1)));
        list.add(list.size(), createBeeList(list.size(), "primordial", primordial, PrimordialBee.PRIMORDIAL_QUEEN, PrimordialBee.PRIMORDIAL_DRONE, PrimordialBee.PRIMORDIAL_PRINCESS, PrimordialBee.PrimordialOutput, PrimordialBee.PrimordialCombOutput, PrimordialBee.PrimordialMutations, 0.0125, getEffectInt(e1)));
        list.add(list.size(), createBeeList(list.size(), "amaryllis", amaryllis, AmaryllisBee.AMARYLLIS_QUEEN, AmaryllisBee.AMARYLLIS_DRONE, AmaryllisBee.AMARYLLIS_PRINCESS, AmaryllisBee.AmaryllisOutput, AmaryllisBee.AmaryllisCombOutput, AmaryllisBee.AmaryllisMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "begonia", begonia, BegoniaBee.BEGONIA_QUEEN, BegoniaBee.BEGONIA_DRONE, BegoniaBee.BEGONIA_PRINCESS, BegoniaBee.BegoniaOutput, BegoniaBee.BegoniaCombOutput, BegoniaBee.BegoniaMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "fuchsia", fuchsia, FuchsiaBee.FUCHSIA_QUEEN, FuchsiaBee.FUCHSIA_DRONE, FuchsiaBee.FUCHSIA_PRINCESS, FuchsiaBee.FuchsiaOutput, FuchsiaBee.FuchsiaCombOutput, FuchsiaBee.FuchsiaMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "forget_me_not", forget_me_not, ForgetMeNotBee.FORGET_ME_NOT_QUEEN, ForgetMeNotBee.FORGET_ME_NOT_DRONE, ForgetMeNotBee.FORGET_ME_NOT_PRINCESS, ForgetMeNotBee.ForgetMeNotOutput, ForgetMeNotBee.ForgetMeNotCombOutput, ForgetMeNotBee.ForgetMeNotMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "marigold", marigold, MarigoldBee.MARIGOLD_QUEEN, MarigoldBee.MARIGOLD_DRONE, MarigoldBee.MARIGOLD_PRINCESS, MarigoldBee.MarigoldOutput, MarigoldBee.MarigoldCombOutput, MarigoldBee.MarigoldMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "bells_of_ireland", bells_of_ireland, BellsOfIrelandBee.BELLS_OF_IRELAND_QUEEN, BellsOfIrelandBee.BELLS_OF_IRELAND_DRONE, BellsOfIrelandBee.BELLS_OF_IRELAND_PRINCESS, BellsOfIrelandBee.BellsOfIrelandOutput, BellsOfIrelandBee.BellsOfIrelandCombOutput, BellsOfIrelandBee.BellsOfIrelandMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "azalea", azalea, AzaleaBee.AZALEA_QUEEN, AzaleaBee.AZALEA_DRONE, AzaleaBee.AZALEA_PRINCESS, AzaleaBee.AzaleaOutput, AzaleaBee.AzaleaCombOutput, AzaleaBee.AzaleaMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "santolina", santolina, SantolinaBee.SANTOLINA_QUEEN, SantolinaBee.SANTOLINA_DRONE, SantolinaBee.SANTOLINA_PRINCESS, SantolinaBee.SantolinaOutput, SantolinaBee.SantolinaCombOutput, SantolinaBee.SantolinaMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "allium", allium, AlliumBee.ALLIUM_QUEEN, AlliumBee.ALLIUM_DRONE, AlliumBee.ALLIUM_PRINCESS, AlliumBee.AlliumOutput, AlliumBee.AlliumCombOutput, AlliumBee.AlliumMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "ipomoea", ipomoea, IpomoeaBee.IPOMOEA_QUEEN, IpomoeaBee.IPOMOEA_DRONE, IpomoeaBee.IPOMOEA_PRINCESS, IpomoeaBee.IpomoeaOutput, IpomoeaBee.IpomoeaCombOutput, IpomoeaBee.IpomoeaMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "lavender", lavender, LavenderBee.LAVENDER_QUEEN, LavenderBee.LAVENDER_DRONE, LavenderBee.LAVENDER_PRINCESS, LavenderBee.LavenderOutput, LavenderBee.LavenderCombOutput, LavenderBee.LavenderMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "periwinkle", periwinkle, PeriwinkleBee.PERIWINKLE_QUEEN, PeriwinkleBee.PERIWINKLE_DRONE, PeriwinkleBee.PERIWINKLE_PRINCESS, PeriwinkleBee.PeriwinkleOutput, PeriwinkleBee.PeriwinkleCombOutput, PeriwinkleBee.PeriwinkleMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "cattleya_velutina", cattleya_velutina, CattleyaVelutinaBee.CATTLEYA_VELUTINA_QUEEN, CattleyaVelutinaBee.CATTLEYA_VELUTINA_DRONE, CattleyaVelutinaBee.CATTLEYA_VELUTINA_PRINCESS, CattleyaVelutinaBee.CattleyaVelutinaOutput, CattleyaVelutinaBee.CattleyaVelutinaCombOutput, CattleyaVelutinaBee.CattleyaVelutinaMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "gerbera_daisy", gerbera_daisy, GerberaDaisyBee.GERBERA_DAISY_QUEEN, GerberaDaisyBee.GERBERA_DAISY_DRONE, GerberaDaisyBee.GERBERA_DAISY_PRINCESS, GerberaDaisyBee.GerberaDaisyOutput, GerberaDaisyBee.GerberaDaisyCombOutput, GerberaDaisyBee.GerberaDaisyMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "rose", rose, RoseBee.ROSE_QUEEN, RoseBee.ROSE_DRONE, RoseBee.ROSE_PRINCESS, RoseBee.RoseOutput, RoseBee.RoseCombOutput, RoseBee.RoseMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "queen_of_the_night_tulip", queen_of_the_night_tulip, QueenOfTheNightTulipBee.QUEEN_OF_THE_NIGHT_TULIP_QUEEN, QueenOfTheNightTulipBee.QUEEN_OF_THE_NIGHT_TULIP_DRONE, QueenOfTheNightTulipBee.QUEEN_OF_THE_NIGHT_TULIP_PRINCESS, QueenOfTheNightTulipBee.QueenOfTheNightTulipOutput, QueenOfTheNightTulipBee.QueenOfTheNightTulipCombOutput, QueenOfTheNightTulipBee.QueenOfTheNightTulipMutations, 0.2, getEffectInt(e2)));
        list.add(list.size(), createBeeList(list.size(), "rainbow", rainbow, RainbowBee.RAINBOW_QUEEN, RainbowBee.RAINBOW_DRONE, RainbowBee.RAINBOW_PRINCESS, RainbowBee.RainbowOutput, RainbowBee.RainbowCombOutput, RainbowBee.RainbowMutations, 0.1, getEffectInt(e2)));
        listList = list;
    }
    public static void createBeeArrays() {
        int i;
        for (i = 0; i < listList.size(); i++) {
            List list1 = (List) listList.get(i);
            species = ArrayUtils.insert(i, species, (String) list1.get(1));
            defaultValues = ArrayUtils.insert(i, defaultValues, (int[]) list1.get(2));
            Queens = ArrayUtils.insert(i, Queens, (Item) list1.get(3));
            Drones = ArrayUtils.insert(i, Drones, (Item) list1.get(4));
            Princesses = ArrayUtils.insert(i, Princesses, (Item) list1.get(5));
            Outputs = ArrayUtils.insert(i, Outputs, (DefaultedList) list1.get(6));
            CombOutputs = ArrayUtils.insert(i, CombOutputs, (DefaultedList) list1.get(7));
            MutationChance = ArrayUtils.insert(i, MutationChance, (double) list1.get(9));
            effectArray = ArrayUtils.insert(i, effectArray, (int) list1.get(10));
        }
        for (i = 0; i < listList.size(); i++) {
            List list1 = (List) listList.get(i);
            String s = (String) list1.get(1);
            String[][] sss1 = (String[][]) list1.get(8);
            int si1 = BeeFunctions.getSpecies(s);
            int index;
            for (index = 0; index < sss1.length; index++) {
                int si2 = BeeFunctions.getSpecies(sss1[index][0]);
                int si3 = BeeFunctions.getSpecies(sss1[index][1]);
                MutationList[si1] = ArrayUtils.add(MutationList[si1], new int[]{si2, si3});
                MutationList[si2] = ArrayUtils.add(MutationList[si2], new int[]{si1, si3});
            }
        }
    }
    public static void createEffects(World world, BlockPos blockPos, BlockState state, ApiaryBlockEntity be, int effect) {
        if (effect == 1) {
            BeeEffects.Ore_I_Fication(world, blockPos, be);
        }
        if (effect == 2) {
            BeeEffects.Coloring(world, blockPos, be);
        }
    }
    public static void createEffectArrays() {
        effectStrings = ArrayUtils.insert(0, effectStrings, "None");
        effectStrings = ArrayUtils.insert(1, effectStrings, "Ore-I-Fication");
        effectStrings = ArrayUtils.insert(2, effectStrings, "Coloring");
    }
    public static int getEffectInt(String name) {
        int index;
        for (index = 0; index < effectStrings.length; index++) {
            if (effectStrings[index].equals(name)) {
                return index;
            }
        }
        return 0;
    }
}
