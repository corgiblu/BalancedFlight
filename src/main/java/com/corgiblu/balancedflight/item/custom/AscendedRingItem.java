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

public class AscendedRingItem extends Item {
    public AscendedRingItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);

        pTooltipComponents.add(new TranslatableComponent("tooltip.balancedflight.ascendedring.tooltip.description"));

        if (BalancedFlightCommonConfig.ElytraAscended.get() && BalancedFlightCommonConfig.CreativeAscended.get()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.balancedflight.ring.tooltip.both"));
        } else if (BalancedFlightCommonConfig.CreativeAscended.get()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.balancedflight.ring.tooltip.creative"));
        } else if (BalancedFlightCommonConfig.ElytraAscended.get()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.balancedflight.ring.tooltip.elytra"));
        }

    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

        if (pEntity instanceof Player player) {
            player.getAbilities().mayfly = true;
        }

    }
}
