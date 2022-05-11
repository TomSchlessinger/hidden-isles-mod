package net.myshampooisdrunk.hiddenisles.client.render;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.myshampooisdrunk.hiddenisles.entity.registry.EntityRegistry;
import net.myshampooisdrunk.hiddenisles.entity.render.*;
import net.myshampooisdrunk.hiddenisles.item.ModItems;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ModRenderRegistry {

    public static void init(){
        GeoArmorRenderer.registerArmorRenderer(new PristiniumRender(), ModItems.PRISTINIUM_BOOTS, ModItems.PRISTINIUM_CHESTPLATE,ModItems.PRISTINIUM_HELMET,ModItems.PRISTINIUM_LEGGINGS);
        GeoArmorRenderer.registerArmorRenderer(new CoordiumRender(), ModItems.COORDIUM_BOOTS, ModItems.COORDIUM_CHESTPLATE,ModItems.COORDIUM_HELMET,ModItems.COORDIUM_LEGGINGS);
        GeoArmorRenderer.registerArmorRenderer(new PrimordiumRender(), ModItems.PRIMORDIUM_BOOTS, ModItems.PRIMORDIUM_CHESTPLATE,ModItems.PRIMORDIUM_HELMET,ModItems.PRIMORDIUM_LEGGINGS);
        GeoArmorRenderer.registerArmorRenderer(new TrocellateRender(), ModItems.TROCELLATE_BOOTS, ModItems.TROCELLATE_CHESTPLATE,ModItems.TROCELLATE_HELMET,ModItems.TROCELLATE_LEGGINGS);
        GeoArmorRenderer.registerArmorRenderer(new DomdeconRender(), ModItems.DOMDECON_BOOTS, ModItems.DOMDECON_CHESTPLATE,ModItems.DOMDECON_HELMET,ModItems.DOMDECON_LEGGINGS);
        GeoArmorRenderer.registerArmorRenderer(new AscondellumRender(), ModItems.ASCONDELLUM_BOOTS, ModItems.ASCONDELLUM_CHESTPLATE,ModItems.ASCONDELLUM_HELMET,ModItems.ASCONDELLUM_LEGGINGS);
        GeoArmorRenderer.registerArmorRenderer(new ArconlonRender(), ModItems.ARCONLON_BOOTS, ModItems.ARCONLON_CHESTPLATE,ModItems.ARCONLON_HELMET,ModItems.ARCONLON_LEGGINGS);

        EntityRendererRegistry.register(EntityRegistry.MISSILE, MissileEntityRender::new);


    }
}
