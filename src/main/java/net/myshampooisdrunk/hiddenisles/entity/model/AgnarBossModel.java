package net.myshampooisdrunk.hiddenisles.entity.model;

import net.minecraft.util.Identifier;
import net.myshampooisdrunk.hiddenisles.HiddenIsles;
import net.myshampooisdrunk.hiddenisles.entity.boss.AgnarBossEntity;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class AgnarBossModel  extends DefaultedEntityGeoModel<AgnarBossEntity> {
    public AgnarBossModel() {
        super(new Identifier(HiddenIsles.MOD_ID, "agnar_boss"),true);
    }

}
