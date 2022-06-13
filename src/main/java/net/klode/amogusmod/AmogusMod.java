package net.klode.amogusmod;

import net.klode.amogusmod.entity.ModEntityTypes;
import net.klode.amogusmod.entity.client.AmogusRenderer;
import net.klode.amogusmod.item.ModItems;
import net.klode.amogusmod.sound.ModSounds;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(AmogusMod.MOD_ID)
public class AmogusMod {
    public static final String MOD_ID = "amogusmod";
    private static final Logger LOGGER = LogManager.getLogger();

    public AmogusMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModSounds.register(eventBus);

        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        EntityRenderers.register(ModEntityTypes.AMOGUS.get(), AmogusRenderer::new);

    }

}
