package net.myshampooisdrunk.hiddenisles.entity.render;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.myshampooisdrunk.hiddenisles.HiddenIsles;
import net.myshampooisdrunk.hiddenisles.client.render.ModRenderRegistry;
import net.myshampooisdrunk.hiddenisles.entity.TrocellateMissile;
import net.myshampooisdrunk.hiddenisles.entity.model.MissileModel;

public class MissileEntityRender extends EntityRenderer<TrocellateMissile> {
    private static final Identifier TEXTURE = new Identifier(HiddenIsles.MOD_ID,"textures/entity/missile.png");
    private final MissileModel model = new MissileModel(MissileModel.getTexturedModelData().createModel());

    public MissileEntityRender(EntityRendererFactory.Context context){super(context);}



    @Override
    public void render(TrocellateMissile missile, float f, float g, MatrixStack stack, VertexConsumerProvider provider, int i){
        stack.push();
        VertexConsumer consumer = provider.getBuffer(this.model.getLayer(this.getTexture(missile)));
        model.render(stack,consumer,i, OverlayTexture.DEFAULT_UV,1.0f,1.0f,1.0f,1.0f);
        stack.scale(1.5f,1.5f,1.5f);
        stack.pop();
        super.render(missile,f,g,stack,provider,i);
    }

    @Override
    public Identifier getTexture(TrocellateMissile entity) {
        return TEXTURE;
    }
}
