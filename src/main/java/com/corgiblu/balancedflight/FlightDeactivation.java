package com.corgiblu.balancedflight;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

public class FlightDeactivation {

    private static final Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    void StopFlight(LivingEquipmentChangeEvent event) {
        //LOGGER.error("Event is called");
        //if (event.getFrom().equals(new ItemStack(ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse("balancedflight:basicring"))))) {
        if (event.getTo().equals(ItemStack.EMPTY)) {
            LOGGER.error("It works!");
        }
    }
}
