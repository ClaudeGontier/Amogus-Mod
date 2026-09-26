package net.klode.amogusmod.item;

import net.klode.amogusmod.AmogusMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AmogusMod.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> AMOGUS_TAB = CREATIVE_MODE_TABS.register("amogustab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.amogustab"))
                    .icon(() -> new ItemStack(Items.COARSE_DIRT))
                    .displayItems((parameters, output) -> ModItems.ITEMS.getEntries()
                            .forEach(item -> output.accept(item.get())))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
