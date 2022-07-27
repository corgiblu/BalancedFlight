package com.corgiblu.balancedflight;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class DebuggingThings {
    public static void ApplyPotion(Player player) {
        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 400, 0, true, false));
    }
}
