package com.corgiblu.balancedflight.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab BALANCEDFLIGHT_TAB = new CreativeModeTab("balancedflighttab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ASCENDEDRING.get());
        }
    };
}
