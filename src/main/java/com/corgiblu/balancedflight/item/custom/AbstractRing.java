package com.corgiblu.balancedflight.item.custom;

import com.corgiblu.balancedflight.FlightAPI;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class AbstractRing extends Item implements ICurio {
    public AbstractRing(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack getStack() {
        return null;
    }

    /*public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
            super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

            if (pEntity instanceof Player player) {
                FlightAPI.startFlight(player);
            }

        }*/
    @Override
    public void curioTick(SlotContext slotContext) {
        if (slotContext.entity() instanceof Player player) {
            FlightAPI.startFlight(player);
        }
    }
    @Override
    public boolean canEquipFromUse(SlotContext slotContext) {
        return true;
    }
    @Override
    public void onEquipFromUse(SlotContext slotContext) {
        slotContext.entity().playSound(SoundEvents.ARMOR_EQUIP_ELYTRA,
                1.0F, 1.0F);
    }
    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack) {
        LivingEntity entity = slotContext.entity();
        if (entity instanceof Player player) {
            if (!(player.isSpectator() || player.isCreative())) {
                FlightAPI.stopFlight(player);
            }
        }
    }
}
