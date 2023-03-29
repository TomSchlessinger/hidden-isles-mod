package net.myshampooisdrunk.hiddenisles.entity.render;

import net.myshampooisdrunk.hiddenisles.entity.model.ArconlonArmorModel;
import net.myshampooisdrunk.hiddenisles.entity.model.ArmorModel;
import net.myshampooisdrunk.hiddenisles.entity.model.CoordiumArmorModel;
import net.myshampooisdrunk.hiddenisles.item.custom.ModArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ArconlonRender extends GeoArmorRenderer<ModArmorItem> {
    public ArconlonRender() {
        super(new ArmorModel("textures/entity/arconlon_armor.png"));
    }
}
