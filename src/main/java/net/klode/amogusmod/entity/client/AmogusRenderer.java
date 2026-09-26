package net.klode.amogusmod.entity.client;

import com.google.common.collect.Maps;
import net.klode.amogusmod.AmogusMod;
import net.klode.amogusmod.entity.custom.AmogusEntity;
import net.klode.amogusmod.entity.variant.AmogusVariant;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import org.jspecify.annotations.Nullable;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

import java.util.Locale;
import java.util.Map;

public class AmogusRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<AmogusEntity, R> {
    public static final DataTicket<AmogusVariant> VARIANT = DataTicket.create("amogusmod_variant", AmogusVariant.class);

    public static final Map<AmogusVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(AmogusVariant.class), map -> {
                for (AmogusVariant variant : AmogusVariant.values()) {
                    map.put(variant, AmogusMod.id("textures/entity/amogus/" + variant.name().toLowerCase(Locale.ROOT) + ".png"));
                }
            });

    public AmogusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AmogusModel());
        this.shadowRadius = 0.3f;
        withScale(0.8F);
    }

    // Capture the variant so the model can pick the matching texture
    @Override
    public void addRenderData(AmogusEntity animatable, @Nullable Void relatedObject, R renderState, float partialTick) {
        renderState.addGeckolibData(VARIANT, animatable.getVariant());
    }
}
