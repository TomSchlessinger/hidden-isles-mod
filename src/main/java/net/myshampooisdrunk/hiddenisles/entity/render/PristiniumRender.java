package net.myshampooisdrunk.hiddenisles.entity.render;

import net.myshampooisdrunk.hiddenisles.entity.model.ArmorModel;
import net.myshampooisdrunk.hiddenisles.entity.model.PristiniumArmorModel;
import net.myshampooisdrunk.hiddenisles.item.custom.ModArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PristiniumRender extends GeoArmorRenderer<ModArmorItem> {
    public PristiniumRender() {
        super(new ArmorModel("textures/entity/pristinium_armor.png"));
    }
}
