package net.myshampooisdrunk.hiddenisles.entity.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.myshampooisdrunk.hiddenisles.HiddenIsles;
import net.myshampooisdrunk.hiddenisles.entity.TrocellateMissile;
import net.myshampooisdrunk.hiddenisles.entity.boss.AgnarBossEntity;

import java.util.LinkedHashMap;

public class EntityRegistry {

    public static final LinkedHashMap<EntityType<?>, Identifier> ENTITIES = new LinkedHashMap<>();
    public static final EntityType<TrocellateMissile> MISSILE = create("missile",
            FabricEntityTypeBuilder.<TrocellateMissile>create(SpawnGroup.MISC, TrocellateMissile::new).dimensions(EntityDimensions.fixed(1F, 1F)).build());
    public static final EntityType<AgnarBossEntity> AGNAR_BOSS = create("agnar_boss",
            FabricEntityTypeBuilder.create(SpawnGroup.MISC,AgnarBossEntity::new).dimensions(EntityDimensions.fixed(3.5F,9F)).build());

    public static void init(){
        Registry.register(Registries.ENTITY_TYPE, new Identifier("hiddenisles","missile"),MISSILE);
        Registry.register(Registries.ENTITY_TYPE, new Identifier("hiddenisles","agnar_boss"),AGNAR_BOSS);
        FabricDefaultAttributeRegistry.register(AGNAR_BOSS, AgnarBossEntity.createAttributes());
    }

    public static void register() {
        ENTITIES.keySet().forEach(entityType -> Registry.register(Registries.ENTITY_TYPE, ENTITIES.get(entityType), entityType));
    }

    private static <T extends Entity> EntityType<T> create(String name, EntityType<T> type) {
        ENTITIES.put(type, new Identifier(HiddenIsles.MOD_ID, name));
        return type;
    }

}
