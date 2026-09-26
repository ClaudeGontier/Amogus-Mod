package net.klode.amogusmod.entity.client;

import net.klode.amogusmod.AmogusMod;
import net.klode.amogusmod.entity.custom.AmogusEntity;
import net.klode.amogusmod.entity.variant.AmogusVariant;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class AmogusModel extends GeoModel<AmogusEntity> {
    private static final Identifier MODEL = AmogusMod.id("entity/amogus");
    private static final Identifier ANIMATION = AmogusMod.id("entity/amogus");

    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return MODEL;
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        AmogusVariant variant = renderState.getOrDefaultGeckolibData(AmogusRenderer.VARIANT, AmogusVariant.RED);

        return AmogusRenderer.LOCATION_BY_VARIANT.get(variant);
    }

    @Override
    public Identifier getAnimationResource(AmogusEntity animatable) {
        return ANIMATION;
    }
}
