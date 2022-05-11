package net.myshampooisdrunk.hiddenisles.entity.render;

import net.myshampooisdrunk.hiddenisles.entity.model.CoordiumArmorModel;
import net.myshampooisdrunk.hiddenisles.entity.model.TrocellateArmorModel;
import net.myshampooisdrunk.hiddenisles.item.custom.ModArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class TrocellateRender extends GeoArmorRenderer<ModArmorItem> {
    public TrocellateRender() {
        super(new TrocellateArmorModel());

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
