package com.corgiblu.balancedflight;

import com.corgiblu.balancedflight.block.ModBlocks;
import com.corgiblu.balancedflight.config.BalancedFlightCommonConfig;
import com.corgiblu.balancedflight.events.TextureStitch;
import com.corgiblu.balancedflight.events.FlightDeactivation;
import com.corgiblu.balancedflight.imc.IMCSender;
import com.corgiblu.balancedflight.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BalancedFlight.MOD_ID)
public class BalancedFlight
{
    public static final String MOD_ID = "balancedflight";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public BalancedFlight()
    {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        MinecraftForge.EVENT_BUS.register(new FlightDeactivation());
        MinecraftForge.EVENT_BUS.register(new TextureStitch());

        IMCSender.sendImc();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BalancedFlightCommonConfig.SPEC, "balancedflight-common.toml");
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
