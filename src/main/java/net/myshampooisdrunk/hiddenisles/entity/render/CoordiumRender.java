package net.myshampooisdrunk.hiddenisles.entity.render;

import net.myshampooisdrunk.hiddenisles.entity.model.ArmorModel;
import net.myshampooisdrunk.hiddenisles.entity.model.CoordiumArmorModel;
import net.myshampooisdrunk.hiddenisles.item.custom.ModArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class CoordiumRender extends GeoArmorRenderer<ModArmorItem> {
    public CoordiumRender() {
        super(new ArmorModel("textures/entity/coordium_armor.png"));
    }
}
