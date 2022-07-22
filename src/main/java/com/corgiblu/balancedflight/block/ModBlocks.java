package com.corgiblu.balancedflight.block;

import com.corgiblu.balancedflight.BalancedFlight;
import com.corgiblu.balancedflight.config.BalancedFlightCommonConfig;
import com.corgiblu.balancedflight.item.ModCreativeModeTab;
import com.corgiblu.balancedflight.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import net.minecraft.client.resources.language.I18n;

import java.util.List;
import java.util.function.Supplier;



public class ModBlocks {
    static double BasicEffectDistance = 25 * BalancedFlightCommonConfig.anchorDistanceMultiplier.get();
    static double GildedEffectDistance = 50 * BalancedFlightCommonConfig.anchorDistanceMultiplier.get();
    static double AscendedEffectDistance = 100 * BalancedFlightCommonConfig.anchorDistanceMultiplier.get();
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BalancedFlight.MOD_ID);


    public static final RegistryObject<Block> BASICFLIGHTANCHOR = registerBlock("basicflightanchor",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(100).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)), ModCreativeModeTab.BALANCEDFLIGHT_TAB, "Allows flight in a " + BasicEffectDistance + " block distance.");

    public static final RegistryObject<Block> GILDEDFLIGHTANCHOR = registerBlock("gildedflightanchor",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(100).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)), ModCreativeModeTab.BALANCEDFLIGHT_TAB, "Allows flight in a " + GildedEffectDistance + " block distance.");

    public static final RegistryObject<Block> ASCENDEDFLIGHTANCHOR = registerBlock("ascendedflightanchor",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(100).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)), ModCreativeModeTab.BALANCEDFLIGHT_TAB, "Allows flight in a " + AscendedEffectDistance + " block distance.");

    public static final RegistryObject<Block> ASCENDEDBLACKSTONE = registerBlock("ascendedblackstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5).requiresCorrectToolForDrops().sound(SoundType.GILDED_BLACKSTONE)), ModCreativeModeTab.BALANCEDFLIGHT_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab, String tooltip) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltip);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab, String tooltip) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
                pTooltip.add(new TextComponent(tooltip).withStyle(ChatFormatting.GRAY));
            }
        });
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
