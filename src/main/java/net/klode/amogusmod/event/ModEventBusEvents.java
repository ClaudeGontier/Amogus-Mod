package net.klode.amogusmod.event;

import net.klode.amogusmod.AmogusMod;
import net.klode.amogusmod.entity.ModEntityTypes;
import net.klode.amogusmod.entity.client.armor.SusArmorRenderer;
import net.klode.amogusmod.entity.custom.AmogusEntity;
import net.klode.amogusmod.item.custom.SusArmorItem;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = AmogusMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.AMOGUS.get(), AmogusEntity.setAttributes());
    }

    @SubscribeEvent
    public static void registerRecipeTypes(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(SusArmorItem.class, new SusArmorRenderer());
    }

}
