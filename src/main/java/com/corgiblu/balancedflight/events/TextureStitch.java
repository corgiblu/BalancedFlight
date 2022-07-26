package com.corgiblu.balancedflight.events;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.slf4j.Logger;


public class TextureStitch {
    @SubscribeEvent
    public void RegisterIcons(TextureStitchEvent.Pre event) {
        event.addSprite(new ResourceLocation("balancedflight", "item/empty_flightring_slot"));
        LOGGER.info("Atlas Stitched");
    }

    private static final Logger LOGGER = LogUtils.getLogger();
}
