package net.klode.amogusmod.sound;

import net.klode.amogusmod.AmogusMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AmogusMod.MOD_ID);

    public static RegistryObject<SoundEvent> AMOGUS_AMBIENT_1
            = registerSoundEvents("amogus_ambient_1");
    public static RegistryObject<SoundEvent> AMOGUS_AMBIENT_2
            = registerSoundEvents("amogus_ambient_2");
    public static RegistryObject<SoundEvent> AMOGUS_AMBIENT_3
            = registerSoundEvents("amogus_ambient_3");
    public static RegistryObject<SoundEvent> AMOGUS_AMBIENT_4
            = registerSoundEvents("amogus_ambient_4");
    public static RegistryObject<SoundEvent> AMOGUS_AMBIENT_5
            = registerSoundEvents("amogus_ambient_5");
    public static RegistryObject<SoundEvent> AMOGUS_DEATH
            = registerSoundEvents("amogus_death");
    public static Supplier<SoundEvent> BOOM
            = registerSoundEvents("boom");


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(AmogusMod.MOD_ID, name);
        return SOUNDS.register(name, () -> new SoundEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}
