package com.corgiblu.balancedflight.events;

import com.corgiblu.balancedflight.FlightAPI;
import com.corgiblu.balancedflight.item.ModItems;
import com.corgiblu.balancedflight.item.custom.AscendedRingItem;
import com.corgiblu.balancedflight.item.custom.BasicRingItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;

public class FlightDeactivation {

    @SubscribeEvent
    void StopFlight(LivingEquipmentChangeEvent event) {
        /*if (event.getEntity() instanceof Player player) {
            if (event.getFrom().getItem() instanceof BasicRingItem || event.getFrom().getItem() instanceof AscendedRingItem)
                if (!(player.isSpectator() || player.isCreative())) {
                    FlightAPI.stopFlight(player);
                    player.onUpdateAbilities();
                }
        }*/
    }
}
