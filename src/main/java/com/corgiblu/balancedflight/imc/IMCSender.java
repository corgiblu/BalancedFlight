package com.corgiblu.balancedflight.imc;

import com.corgiblu.balancedflight.events.TextureStitch;
import net.minecraftforge.fml.InterModComms;
import top.theillusivec4.curios.api.SlotTypeMessage;

public class IMCSender {
    public static void sendImc() {
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("flight_ring").icon(TextureStitch.SLOT_TEXTURE).build());
    }
}
