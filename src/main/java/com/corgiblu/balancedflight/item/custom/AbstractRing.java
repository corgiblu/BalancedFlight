package com.corgiblu.balancedflight.item.custom;

import com.corgiblu.balancedflight.FlightAPI;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class AbstractRing extends Item implements ICurioItem {
    public AbstractRing(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (slotContext.entity() instanceof Player player) {
            FlightAPI.startFlight(player);
        }
    }
    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        ICurioItem.super.onUnequip(slotContext, newStack, stack);
        if (stack.getItem() instanceof BasicRingItem || stack.getItem() instanceof AscendedRingItem) {
            if (slotContext.entity() instanceof Player player) {
                if (!(player.isSpectator() || player.isCreative())) {
                    FlightAPI.stopFlight(player);
                }
            }
        }
    }
    @Override
    public void onEquipFromUse(SlotContext slotContext, ItemStack stack) {
        ICurioItem.super.onEquipFromUse(slotContext, stack);
        slotContext.entity().playSound(SoundEvents.ARMOR_EQUIP_ELYTRA,
                1.0F, 1.0F);
    }
}
