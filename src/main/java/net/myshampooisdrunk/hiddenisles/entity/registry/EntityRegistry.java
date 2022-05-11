package net.myshampooisdrunk.hiddenisles.entity.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.myshampooisdrunk.hiddenisles.HiddenIsles;
import net.myshampooisdrunk.hiddenisles.entity.TrocellateMissile;
import software.bernie.example.registry.EntityRegistryBuilder;
import software.bernie.geckolib3.GeckoLib;

import java.util.LinkedHashMap;

public class EntityRegistry {

    public static final LinkedHashMap<EntityType<?>, Identifier> ENTITIES = new LinkedHashMap<>();
    public static final EntityType<TrocellateMissile> MISSILE = create("missile",
            FabricEntityTypeBuilder.<TrocellateMissile>create(SpawnGroup.MISC, TrocellateMissile::new).dimensions(EntityDimensions.fixed(1F, 1F)).build());

    public static void init(){
        Registry.register(Registry.ENTITY_TYPE, new Identifier("hiddenisles","missile"),MISSILE);
    }

    public static void register() {
        ENTITIES.keySet().forEach(entityType -> Registry.register(Registry.ENTITY_TYPE, ENTITIES.get(entityType), entityType));
    }

    private static <T extends Entity> EntityType<T> create(String name, EntityType<T> type) {
        ENTITIES.put(type, new Identifier(HiddenIsles.MOD_ID, name));
        return type;
    }

}
