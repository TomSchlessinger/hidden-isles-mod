package net.myshampooisdrunk.hiddenisles.entity.render;

import net.myshampooisdrunk.hiddenisles.entity.model.ArmorModel;
import net.myshampooisdrunk.hiddenisles.entity.model.CoordiumArmorModel;
import net.myshampooisdrunk.hiddenisles.entity.model.TrocellateArmorModel;
import net.myshampooisdrunk.hiddenisles.item.custom.ModArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class TrocellateRender extends GeoArmorRenderer<ModArmorItem> {
    public TrocellateRender() {
        super(new ArmorModel("textures/entity/trocellate_armor.png"));
    }
}
