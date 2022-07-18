package com.corgiblu.balancedflight.block;

import com.corgiblu.balancedflight.BalancedFlight;
import com.corgiblu.balancedflight.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BalancedFlight.MOD_ID);

    public static final RegistryObject<Block> BASICFLIGHTANCHOR = registerBlock("basicflightanchor",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(100).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> GILDEDFLIGHTANCHOR = registerBlock("gildedflightanchor",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(100).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> ASCENDEDFLIGHTANCHOR = registerBlock("ascendedflightanchor",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(100).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> ASCENDEDBLACKSTONE = registerBlock("ascendedblackstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5).requiresCorrectToolForDrops().sound(SoundType.GILDED_BLACKSTONE)), CreativeModeTab.TAB_MISC);

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
