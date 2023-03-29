package net.myshampooisdrunk.hiddenisles.entity.render;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.myshampooisdrunk.hiddenisles.entity.boss.AgnarBossEntity;
import net.myshampooisdrunk.hiddenisles.entity.model.AgnarBossModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AgnarBossRender extends GeoEntityRenderer<AgnarBossEntity> {
    public AgnarBossRender(EntityRendererFactory.Context context){
        super(context, new AgnarBossModel());
        this.shadowRadius = 2f;
    }

    @Override
    public void render(AgnarBossEntity entity, float entityYaw, float partialTicks, MatrixStack stack, VertexConsumerProvider bufferIn, int packedLightIn) {
        stack.scale(10f,10f,10f);
        super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
    }
}
