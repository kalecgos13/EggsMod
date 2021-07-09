package com.kalec;

import com.kalec.Items.StartUpCommon;
import com.kalec.handler.ConfigHandler;
import com.kalec.usefultools.debugging.ForgeLoggerTweaker;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import net.minecraft.block.DispenserBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("eggs")
public class EggsMod {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "eggs";

    public static volatile boolean configLoaded = false;

    public EggsMod() {
        final boolean HIDE_CONSOLE_NOISE = true;
        if (HIDE_CONSOLE_NOISE) {
            ForgeLoggerTweaker.setMinimumLevel(Level.WARN);
            ForgeLoggerTweaker.applyLoggerFilter();
        }
        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHandler.COMMON_SPEC);
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final ClientSide clientSide = new ClientSide(modEventBus);
        register(modEventBus);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> clientSide::registerClientOnlyEvents);
    }

    public void register(IEventBus eventBus) {
        eventBus.register(com.kalec.entity.StartupCommon.class);
        eventBus.register(com.kalec.Items.StartUpCommon.class);
        eventBus.register(com.kalec.ItemGroups.StartupCommon.class);
    }
}
