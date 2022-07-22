package com.corgiblu.balancedflight.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BalancedFlightCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> enableElytraFlightFromGround;
    public static final ForgeConfigSpec.ConfigValue<Boolean> enableTakeOff;
    public static final ForgeConfigSpec.ConfigValue<Boolean> infiniteRockets;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ElytraBasic;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ElytraAscended;
    public static final ForgeConfigSpec.ConfigValue<Boolean> disableFallDamageWithRings;
    public static final ForgeConfigSpec.ConfigValue<Boolean> disableElytraDamageWithRings;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CreativeBasic;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CreativeAscended;
    public static final ForgeConfigSpec.ConfigValue<Double> anchorDistanceMultiplier;

    static {
        BUILDER.push("Balanced Flight Settings");

        CreativeAscended = BUILDER.comment("Flight Options").define("Ascended Ring Gives Unlimited Creative Flight (will fall back to Basic tier inside range)", true);
        ElytraAscended = BUILDER.define("Ascended Ring Also Works As Elytra", true);
        CreativeBasic = BUILDER.define("Basic Ring Gives Creative Flight", true);
        ElytraBasic = BUILDER.define("Basic Flight Ring Also Works As Elytra", false);

        anchorDistanceMultiplier = BUILDER.comment("Balancing Options").defineInRange("Anchor Distance Multiplier", 1.0, 0.0, 10.0);
        disableFallDamageWithRings = BUILDER.define("Disable Fall Damage When Wearing Rings", true);
        disableElytraDamageWithRings = BUILDER.define("Disable Elytra Damage When Wearing Rings", true);

        enableElytraFlightFromGround = BUILDER.comment("Enhanced Elytra Options").define("Enable Elytra Flight From Ground", true);
        enableTakeOff =  BUILDER.define("Enable Take Off Mechanic", true);
        infiniteRockets = BUILDER.define("Infinite Rockets", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}