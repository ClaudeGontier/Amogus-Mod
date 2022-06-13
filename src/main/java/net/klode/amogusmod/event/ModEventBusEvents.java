package net.klode.amogusmod.event;

import net.klode.amogusmod.AmogusMod;
import net.klode.amogusmod.entity.ModEntityTypes;
import net.klode.amogusmod.entity.custom.AmogusEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AmogusMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.AMOGUS.get(), AmogusEntity.setAttributes());
    }
}
