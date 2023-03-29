package net.myshampooisdrunk.hiddenisles.entity.render;

import net.myshampooisdrunk.hiddenisles.entity.model.ArmorModel;
import net.myshampooisdrunk.hiddenisles.entity.model.PrimordiumArmorModel;
import net.myshampooisdrunk.hiddenisles.item.custom.ModArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PrimordiumRender extends GeoArmorRenderer<ModArmorItem> {
    public PrimordiumRender() {
        super(new ArmorModel("textures/entity/primordium_armor.png"));
    }
}
