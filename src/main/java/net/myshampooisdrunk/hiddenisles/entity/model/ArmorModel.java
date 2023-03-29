package net.myshampooisdrunk.hiddenisles.entity.model;

import net.minecraft.util.Identifier;
import net.myshampooisdrunk.hiddenisles.HiddenIsles;
import net.myshampooisdrunk.hiddenisles.item.custom.ModArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class ArmorModel extends GeoModel<ModArmorItem> {
    String file;
    public ArmorModel(String fileLocation){
        this.file = fileLocation;
    }

    @Override
    public Identifier getModelResource(ModArmorItem object) {
        return new Identifier(HiddenIsles.MOD_ID, "geo/pristinium_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(ModArmorItem object) {
        return new Identifier(HiddenIsles.MOD_ID, this.file);
    }

    @Override
    public Identifier getAnimationResource(ModArmorItem animatable) {
        return new Identifier(HiddenIsles.MOD_ID, "animations/armor_animation.json");
    }
}