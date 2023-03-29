package net.myshampooisdrunk.hiddenisles.entity.render;

import net.myshampooisdrunk.hiddenisles.entity.model.ArmorModel;
import net.myshampooisdrunk.hiddenisles.entity.model.CoordiumArmorModel;
import net.myshampooisdrunk.hiddenisles.entity.model.DomdeconArmorModel;
import net.myshampooisdrunk.hiddenisles.item.custom.ModArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DomdeconRender extends GeoArmorRenderer<ModArmorItem> {
    public DomdeconRender() {
        super(new ArmorModel("textures/entity/domdecon_armor.png"));
    }
}
