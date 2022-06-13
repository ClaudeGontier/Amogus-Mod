package net.klode.amogusmod.entity.client;

import net.klode.amogusmod.AmogusMod;
import net.klode.amogusmod.entity.custom.AmogusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AmogusModel extends AnimatedGeoModel<AmogusEntity> {
    @Override
    public ResourceLocation getModelLocation(AmogusEntity object) {
        return new ResourceLocation(AmogusMod.MOD_ID, "geo/amogus.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(AmogusEntity object) {
        return new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/amogus.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AmogusEntity animatable) {
        return new ResourceLocation(AmogusMod.MOD_ID, "animations/amogus.animation.json");
    }
}
