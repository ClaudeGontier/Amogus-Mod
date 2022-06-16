package net.klode.amogusmod.entity.client.armor;

import net.klode.amogusmod.item.custom.SusArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class SusArmorRenderer extends GeoArmorRenderer<SusArmorItem> {
    public SusArmorRenderer() {
        super(new SusArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorLeftArm";
        this.leftArmBone = "armorRightArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}
