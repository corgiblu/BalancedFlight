package com.corgiblu.balancedflight;

import net.minecraft.world.entity.player.Player;

public class FlightAPI {
    public static void startFlight(Player player) {
        player.getAbilities().mayfly = true;
    }
    public static void stopFlight(Player player) {
        player.getAbilities().mayfly = false;
        player.getAbilities().flying = false;
        player.onUpdateAbilities();
    }
}
