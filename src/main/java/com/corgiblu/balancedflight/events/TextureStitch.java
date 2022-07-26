package com.corgiblu.balancedflight.events;

import com.corgiblu.balancedflight.BalancedFlight;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;


@Mod.EventBusSubscriber(modid = BalancedFlight.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TextureStitch {

    public static final ResourceLocation SLOT_TEXTURE = new ResourceLocation(BalancedFlight.MOD_ID, "item/empty_flightring_slot");

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void RegisterIcons(TextureStitchEvent.Pre event) {
        event.addSprite(SLOT_TEXTURE);
        LOGGER.info("Atlas Stitched");
    }

    private static final Logger LOGGER = LogUtils.getLogger();
}
