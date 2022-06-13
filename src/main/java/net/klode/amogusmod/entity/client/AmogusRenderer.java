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
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/redamogus.png"));
                p_114874_.put(AmogusVariant.GREEN,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/greenamogus.png"));
                p_114874_.put(AmogusVariant.BLUE,
                        new ResourceLocation(AmogusMod.MOD_ID, "textures/entity/amogus/blueamogus.png"));
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
