package net.myshampooisdrunk.hiddenisles.entity.model;

import net.minecraft.util.Identifier;
import net.myshampooisdrunk.hiddenisles.HiddenIsles;
import net.myshampooisdrunk.hiddenisles.item.custom.ModArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArmorModel extends AnimatedGeoModel<ModArmorItem> {
    String file;
    public ArmorModel(String fileLocation){
        this.file = fileLocation;
    }

    @Override
    public Identifier getModelLocation(ModArmorItem object) {
        return new Identifier(HiddenIsles.MOD_ID, "geo/pristinium_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(ModArmorItem object) {
        return new Identifier(HiddenIsles.MOD_ID, this.file);
    }

    @Override
    public Identifier getAnimationFileLocation(ModArmorItem animatable) {
        return new Identifier(HiddenIsles.MOD_ID, "animations/armor_animation.json");
    }
}