package com.kalec.handler;

import com.kalec.EggsMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = EggsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigHandler {

    public static class Common {
        public final ForgeConfigSpec.IntValue omeletFoodAmount;
        public final ForgeConfigSpec.DoubleValue omeletSaturationAmount;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("omeletFood");
            omeletFoodAmount = builder
                    .comment("The amount of food an omelet gives")
                    .defineInRange("foodAmount", 5, 0, 20);
            omeletSaturationAmount = builder
                    .comment("The amount of saturation an omelet gives")
                    .defineInRange("saturationAmount", 4.2, 0.0, 20.0);
            builder.pop();

        }
    }

    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static int getOmeletFoodAmountInt() {
        return omeletFoodAmountInt;
    }

    public static float getOmeletSaturationAmountFloat() {
        return omeletSaturationAmountFloat;
    }

    private static int omeletFoodAmountInt;
    private static float omeletSaturationAmountFloat;

    public static void bakeConfig() {
        omeletFoodAmountInt = COMMON.omeletFoodAmount.get();
        omeletSaturationAmountFloat = COMMON.omeletSaturationAmount.get().floatValue();
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
        if(configEvent.getConfig().getSpec() == ConfigHandler.COMMON_SPEC) {
            bakeConfig();
        }
    }
}
