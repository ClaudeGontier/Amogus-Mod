package net.klode.amogusmod.entity.client.armor;

import net.klode.amogusmod.AmogusMod;
import net.klode.amogusmod.item.custom.SusArmorItem;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class SusArmorModel extends GeoModel<SusArmorItem> {
    private static final Identifier MODEL = AmogusMod.id("armor/sus_armor");
    private static final Identifier TEXTURE = AmogusMod.id("textures/models/armor/sus_armor_texture.png");
    private static final Identifier ANIMATION = AmogusMod.id("armor/sus_armor");

    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return MODEL;
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return TEXTURE;
    }

    @Override
    public Identifier getAnimationResource(SusArmorItem animatable) {
        return ANIMATION;
    }
}
