package net.klode.amogusmod.event;

import net.klode.amogusmod.AmogusMod;
import net.klode.amogusmod.entity.ModEntityTypes;
import net.klode.amogusmod.entity.client.AmogusRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = AmogusMod.MOD_ID, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.AMOGUS.get(), AmogusRenderer::new);
    }
}
