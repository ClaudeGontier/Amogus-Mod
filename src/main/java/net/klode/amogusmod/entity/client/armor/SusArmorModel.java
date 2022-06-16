package net.klode.amogusmod.entity.client.armor;

import net.klode.amogusmod.AmogusMod;
import net.klode.amogusmod.item.custom.SusArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SusArmorModel extends AnimatedGeoModel<SusArmorItem> {
    @Override
    public ResourceLocation getModelLocation(SusArmorItem object) {
        return new ResourceLocation(AmogusMod.MOD_ID, "geo/sus_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SusArmorItem object) {
        return new ResourceLocation(AmogusMod.MOD_ID, "textures/models/armor/sus_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SusArmorItem animatable) {
        return new ResourceLocation(AmogusMod.MOD_ID, "animations/armor_animation.json");
    }
}
