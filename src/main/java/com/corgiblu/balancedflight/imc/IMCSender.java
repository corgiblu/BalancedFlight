package com.corgiblu.balancedflight.imc;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.InterModComms;
import top.theillusivec4.curios.api.SlotTypeMessage;

public class IMCSender {
    public static void sendImc() {
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("flight_ring").icon(new ResourceLocation("balancedflight", "item/empty_flightring_slot")).build());
    }
}
