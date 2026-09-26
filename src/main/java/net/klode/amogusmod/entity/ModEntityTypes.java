package net.klode.amogusmod.entity;

import net.klode.amogusmod.AmogusMod;
import net.klode.amogusmod.entity.custom.AmogusEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, AmogusMod.MOD_ID);

    public static final ResourceKey<EntityType<?>> AMOGUS_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE, AmogusMod.id("amogus"));

    public static final DeferredHolder<EntityType<?>, EntityType<AmogusEntity>> AMOGUS = ENTITY_TYPES.register("amogus",
            () -> EntityType.Builder.of(AmogusEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 0.8f)
                    .build(AMOGUS_KEY));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
