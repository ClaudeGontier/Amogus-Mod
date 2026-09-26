package net.klode.amogusmod.entity.client.armor;

import net.klode.amogusmod.item.custom.SusArmorItem;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class SusArmorRenderer<R extends HumanoidRenderState & GeoRenderState> extends GeoArmorRenderer<SusArmorItem, R> {
    public SusArmorRenderer() {
        super(new SusArmorModel());
    }

    // The arm bones of the sus armor model are swapped compared to GeckoLib's defaults
    @Override
    public String getBoneNameForSegment(R renderState, ArmorSegment segment) {
        return switch (segment) {
            case LEFT_ARM -> "armorRightArm";
            case RIGHT_ARM -> "armorLeftArm";
            default -> super.getBoneNameForSegment(renderState, segment);
        };
    }
}
