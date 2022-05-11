package net.myshampooisdrunk.hiddenisles.entity.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.myshampooisdrunk.hiddenisles.entity.TrocellateMissile;

public class MissileModel extends Model {
    private final ModelPart rocketbottom;
    private final ModelPart rocketmiddle;
    private final ModelPart rockettop;
    private final ModelPart bottomfins;
    private final ModelPart middlefins;
    private final ModelPart root;

    public MissileModel(ModelPart root) {
        super(RenderLayer::getEntitySolid);
        this.root = root;
        this.rocketbottom = root.getChild("rocketbottom");
        this.rocketmiddle = root.getChild("rocketmiddle");
        this.rockettop = root.getChild("rockettop");
        this.bottomfins = root.getChild("bottomfins");
        this.middlefins = root.getChild("middlefins");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        ModelPartData rocketbottom = root.addChild("rocketbottom", ModelPartBuilder.create().uv(99, 33).cuboid(-2.5F, -1.3F, -2.5F, 5.0F, 1.0F, 5.0F, new Dilation(-0.1F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData leg4 = rocketbottom.addChild("leg4", ModelPartBuilder.create().uv(88, 59).cuboid(-0.5F, 0.0F, 2.5F, 1.0F, 2.0F, 0.0F, new Dilation(0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

        ModelPartData leg3 = rocketbottom.addChild("leg3", ModelPartBuilder.create().uv(90, 49).cuboid(-0.5F, 0.0F, -2.5F, 1.0F, 2.0F, 0.0F, new Dilation(0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        ModelPartData leg2 = rocketbottom.addChild("leg2", ModelPartBuilder.create().uv(110, 26).cuboid(2.5F, 0.0F, -0.5F, 0.0F, 2.0F, 1.0F, new Dilation(0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

        ModelPartData leg1 = rocketbottom.addChild("leg1", ModelPartBuilder.create().uv(80, 35).cuboid(-2.5F, 0.0F, -0.5F, 0.0F, 2.0F, 1.0F, new Dilation(0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

        ModelPartData rocketmiddle = root.addChild("rocketmiddle", ModelPartBuilder.create().uv(3, 14).cuboid(-1.5F, -7.0F, -2.5F, 3.0F, 6.0F, 5.0F, new Dilation(0.0F))
                .uv(4, 12).cuboid(-2.5F, -7.0F, -1.5F, 5.0F, 6.0F, 3.0F, new Dilation(0.0F))
                .uv(4, 8).cuboid(-2.0F, -10.0F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F))
                .uv(4, 12).cuboid(-2.5F, -11.0F, -1.0F, 5.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 12).cuboid(-1.0F, -11.0F, -2.5F, 2.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData rockettop = root.addChild("rockettop", ModelPartBuilder.create().uv(8, 9).cuboid(-2.0F, -14.0F, -1.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F))
                .uv(3, 8).cuboid(-1.0F, -14.0F, -2.0F, 2.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(3, 8).cuboid(-1.5F, -14.0F, -1.5F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData rockettip4 = rockettop.addChild("rockettip4", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -15.0F, -1.5F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-1.5F, -15.0F, -0.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-0.5F, -17.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-1.0F, -16.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData bottomfins = root.addChild("bottomfins", ModelPartBuilder.create().uv(0, 0).cuboid(-4.5F, -3.0F, 0.0F, 9.0F, 2.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.0F, -3.0F, -4.0F, 0.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData middlefins = root.addChild("middlefins", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, 0.0F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-3.5F, -9.0F, 0.0F, 7.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.0F, -8.0F, -4.0F, 0.0F, 2.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.0F, -9.0F, -3.5F, 0.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
