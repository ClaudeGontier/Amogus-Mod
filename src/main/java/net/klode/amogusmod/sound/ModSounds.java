package net.klode.amogusmod.sound;

import net.klode.amogusmod.AmogusMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(Registries.SOUND_EVENT, AmogusMod.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> AMOGUS_AMBIENT_1
            = registerSoundEvents("amogus_ambient_1");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMOGUS_AMBIENT_2
            = registerSoundEvents("amogus_ambient_2");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMOGUS_AMBIENT_3
            = registerSoundEvents("amogus_ambient_3");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMOGUS_AMBIENT_4
            = registerSoundEvents("amogus_ambient_4");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMOGUS_AMBIENT_5
            = registerSoundEvents("amogus_ambient_5");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMOGUS_DEATH
            = registerSoundEvents("amogus_death");
    public static final DeferredHolder<SoundEvent, SoundEvent> BOOM
            = registerSoundEvents("boom");


    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvents(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(AmogusMod.id(name)));
    }

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}
