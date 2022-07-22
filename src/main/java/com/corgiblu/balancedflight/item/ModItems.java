package com.corgiblu.balancedflight.item;

import com.corgiblu.balancedflight.BalancedFlight;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BalancedFlight.MOD_ID);

    public static final RegistryObject<Item> BASICRING = ITEMS.register("basicring",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BALANCEDFLIGHT_TAB).stacksTo(1)));

    public static final RegistryObject<Item> DIAMONDRING = ITEMS.register("diamondring",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BALANCEDFLIGHT_TAB).stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> FLIGHTCORE = ITEMS.register("flightcore",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BALANCEDFLIGHT_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
