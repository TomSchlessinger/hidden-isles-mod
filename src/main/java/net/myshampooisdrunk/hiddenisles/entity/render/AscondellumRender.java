package net.myshampooisdrunk.hiddenisles.entity.render;

import net.myshampooisdrunk.hiddenisles.entity.model.ArmorModel;
import net.myshampooisdrunk.hiddenisles.entity.model.AscondellumArmorModel;
import net.myshampooisdrunk.hiddenisles.entity.model.CoordiumArmorModel;
import net.myshampooisdrunk.hiddenisles.item.custom.ModArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class AscondellumRender extends GeoArmorRenderer<ModArmorItem> {
    public AscondellumRender() {
        super(new ArmorModel("textures/entity/ascondellum_armor.png"));
    }
}
