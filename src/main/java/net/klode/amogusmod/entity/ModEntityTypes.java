package net.klode.amogusmod.entity;

import net.klode.amogusmod.AmogusMod;
import net.klode.amogusmod.entity.custom.AmogusEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, AmogusMod.MOD_ID);

    public static final RegistryObject<EntityType<AmogusEntity>> AMOGUS = ENTITY_TYPES.register("amogus",
            () -> EntityType.Builder.of(AmogusEntity::new, MobCategory.MONSTER)
                    .sized(0.8f, 1.4f)
                    .build(new ResourceLocation(AmogusMod.MOD_ID, "amogus").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
