package net.klode.amogusmod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.klode.amogusmod.AmogusMod;
import net.klode.amogusmod.entity.custom.AmogusEntity;
import net.klode.amogusmod.entity.variant.AmogusVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class AmogusRenderer extends GeoEntityRenderer<AmogusEntity> {
    public static final Map<AmogusVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(AmogusVariant.class), (p_114874_) -> {
                p_114874_.put(AmogusVariant.RED,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/red.png"));
                p_114874_.put(AmogusVariant.BLUE,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/blue.png"));
                p_114874_.put(AmogusVariant.GREEN,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/green.png"));
                p_114874_.put(AmogusVariant.PINK,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/pink.png"));
                p_114874_.put(AmogusVariant.ORANGE,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/orange.png"));
                p_114874_.put(AmogusVariant.YELLOW,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/yellow.png"));
                p_114874_.put(AmogusVariant.GRAY,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/gray.png"));
                p_114874_.put(AmogusVariant.LILAC,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/lilac.png"));
                p_114874_.put(AmogusVariant.BLACK,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/black.png"));
                p_114874_.put(AmogusVariant.WHITE,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/white.png"));
                p_114874_.put(AmogusVariant.PURPLE,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/purple.png"));
                p_114874_.put(AmogusVariant.BROWN,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/brown.png"));
                p_114874_.put(AmogusVariant.CYAN,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/cyan.png"));
                p_114874_.put(AmogusVariant.LIME,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/lime.png"));
                p_114874_.put(AmogusVariant.TAN,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/tan.png"));
                p_114874_.put(AmogusVariant.SALMON,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/salmon.png"));
            });
    
    public AmogusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AmogusModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(AmogusEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public RenderType getRenderType(AmogusEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
