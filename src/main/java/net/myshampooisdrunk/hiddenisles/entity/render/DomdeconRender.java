package net.myshampooisdrunk.hiddenisles.entity.render;

import net.myshampooisdrunk.hiddenisles.entity.model.CoordiumArmorModel;
import net.myshampooisdrunk.hiddenisles.entity.model.DomdeconArmorModel;
import net.myshampooisdrunk.hiddenisles.item.custom.ModArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class DomdeconRender extends GeoArmorRenderer<ModArmorItem> {
    public DomdeconRender() {
        super(new DomdeconArmorModel());

        this.headBone = "Head";
        this.bodyBone = "Body";
        this.rightArmBone = "RightArm";
        this.leftArmBone = "LeftArm";
        this.rightLegBone = "RightLeg";
        this.leftLegBone = "LeftLeg";
        this.rightBootBone = "RightBoot";
        this.leftBootBone = "LeftBoot";
    }
}
