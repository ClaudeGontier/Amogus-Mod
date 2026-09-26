package net.klode.amogusmod;

import com.mojang.logging.LogUtils;
import net.klode.amogusmod.entity.ModEntityTypes;
import net.klode.amogusmod.item.ModCreativeModeTab;
import net.klode.amogusmod.item.ModItems;
import net.klode.amogusmod.sound.ModSounds;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;


@Mod(AmogusMod.MOD_ID)
public class AmogusMod {
    public static final String MOD_ID = "amogusmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AmogusMod(IEventBus eventBus) {
        ModSounds.register(eventBus);
        ModItems.register(eventBus);
        ModCreativeModeTab.register(eventBus);
        ModEntityTypes.register(eventBus);
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
