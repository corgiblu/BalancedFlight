package com.corgiblu.balancedflight.item.custom;

import com.corgiblu.balancedflight.config.BalancedFlightCommonConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BasicRingItem extends Item {
    public BasicRingItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);

        pTooltipComponents.add(new TranslatableComponent("tooltip.balancedflight.basicring.tooltip.description"));

        if (BalancedFlightCommonConfig.ElytraBasic.get() && BalancedFlightCommonConfig.CreativeBasic.get()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.balancedflight.ring.tooltip.both"));
        } else if (BalancedFlightCommonConfig.CreativeBasic.get()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.balancedflight.ring.tooltip.creative"));
        } else if (BalancedFlightCommonConfig.ElytraBasic.get()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.balancedflight.ring.tooltip.elytra"));
        }
        pTooltipComponents.add(new TranslatableComponent("tooltip.balancedflight.basicring.tooltip.overworld"));

    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

        if (pEntity instanceof Player player) {
            player.getAbilities().mayfly = true;
        }

    }


    private void stopFlying(Player player) {
        player.getAbilities().flying = false;
        player.getAbilities().mayfly = false;
        player.onUpdateAbilities();
    }
}
