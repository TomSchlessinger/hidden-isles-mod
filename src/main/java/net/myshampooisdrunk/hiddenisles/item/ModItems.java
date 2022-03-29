package net.myshampooisdrunk.hiddenisles.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.myshampooisdrunk.hiddenisles.HiddenIsles;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    //ores
    public static final Item PRIMORDIUM_CLUSTER = registerItem( "primordium_cluster", new Item(new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)) );
    public static final Item PRISTINIUM_CLUSTER = registerItem( "pristinium_cluster", new Item(new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)) );
    public static final Item COORDIUM_CLUSTER = registerItem( "coordoium_cluster", new Item(new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)) );
    public static final Item TROCELLATE_CLUSTER = registerItem( "trocellate_cluster", new Item(new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)) );
    public static final Item DOMDECON_CLUSTER = registerItem( "domdecon_cluster", new Item(new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)) );
    public static final Item ASCONDELLUM_CLUSTER = registerItem( "ascondellum_cluster", new Item(new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)) );
    public static final Item ARCONLON_CLUSTER = registerItem( "arconlon_cluster", new Item(new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)) );

    public static final Item PRIMORDIUM_INGOT = registerItem( "primordium_ingot", new Item(new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)) );
    public static final Item PRISTINIUM_INGOT = registerItem( "pristinium_ingot", new Item(new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)) );
    public static final Item COORDIUM_INGOT = registerItem( "coordoium_ingot", new Item(new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)) );
    public static final Item TROCELLATE_INGOT = registerItem( "trocellate_ingot", new Item(new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)) );
    public static final Item DOMDECON_INGOT = registerItem( "domdecon_ingot", new Item(new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)) );
    public static final Item ASCONDELLUM_INGOT = registerItem( "ascondellum_ingot", new Item(new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)) );
    public static final Item ARCONLON_INGOT = registerItem( "arconlon_ingot", new Item(new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)) );


    //tools/weapons
    public static final Item PRIMORDIUM_BLADE = registerItem("primordium_sword",
            new SwordItem(ModToolMaterials.PRIMORDIUM , 11, -2.4f , new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)));//base attack speed is 4 so negative numbers are needed for desirable outcome

    public static final Item PRISTINIUM_BLADE = registerItem("pristinium_sword",
            new SwordItem(ModToolMaterials.PRISTINIUM , 8, -2.4f , new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)));

    public static final Item COORDIUM_BLADE = registerItem("coordium_sword",
            new SwordItem(ModToolMaterials.COORDIUM , 14, -2.4f , new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)));

    public static final Item TROCELLATE_BLADE = registerItem("trocellate_sword",
            new SwordItem(ModToolMaterials.TROCELLATE , 11, -2.4f , new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)));

    public static final Item DOMDECON_BLADE = registerItem("domdecon_sword",
            new SwordItem(ModToolMaterials.DOMDECON , 5, -2.4f , new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)));

    public static final Item ASCONDELLUM_BLADE = registerItem("ascondellum_sword",
            new SwordItem(ModToolMaterials.ASCONDELLUM , 8, -2.4f , new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)));

    public static final Item ARCONLON_BLADE = registerItem("arconlon_sword",
            new SwordItem(ModToolMaterials.ARCONLON , 8, -2.4f , new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)));

    //armor
    public static final Item PRIMORDIUM_HELMET = registerItem("primordium_helmet", new ArmorItem(ModArmorMaterials.PRIMORDIUM, EquipmentSlot.HEAD,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item PRIMORDIUM_CHESTPLATE = registerItem("primordium_chestplate", new ArmorItem(ModArmorMaterials.PRIMORDIUM, EquipmentSlot.CHEST,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item PRIMORDIUM_LEGGINGS = registerItem("primordium_leggings", new ArmorItem(ModArmorMaterials.PRIMORDIUM, EquipmentSlot.LEGS,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item PRIMORDIUM_BOOTS = registerItem("primordium_boots", new ArmorItem(ModArmorMaterials.PRIMORDIUM, EquipmentSlot.FEET,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));

    public static final Item PRISTINIUM_HELMET = registerItem("pristinium_helmet", new ArmorItem(ModArmorMaterials.PRISTINIUM, EquipmentSlot.HEAD,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item PRISTINIUM_CHESTPLATE = registerItem("pristinium_chestplate", new ArmorItem(ModArmorMaterials.PRISTINIUM, EquipmentSlot.CHEST,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item PRISTINIUM_LEGGINGS = registerItem("pristinium_leggings", new ArmorItem(ModArmorMaterials.PRISTINIUM, EquipmentSlot.LEGS,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item PRISTINIUM_BOOTS = registerItem("pristinium_boots", new ArmorItem(ModArmorMaterials.PRISTINIUM, EquipmentSlot.FEET,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));


    public static final Item COORDIUM_HELMET = registerItem("coordium_helmet", new ArmorItem(ModArmorMaterials.COORDIUM, EquipmentSlot.HEAD,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item COORDIUM_CHESTPLATE = registerItem("coordium_chestplate", new ArmorItem(ModArmorMaterials.COORDIUM, EquipmentSlot.CHEST,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item COORDIUM_LEGGINGS = registerItem("coordium_leggings", new ArmorItem(ModArmorMaterials.COORDIUM, EquipmentSlot.LEGS,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item COORDIUM_BOOTS = registerItem("coordium_boots", new ArmorItem(ModArmorMaterials.COORDIUM, EquipmentSlot.FEET,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));


    public static final Item TROCELLATE_HELMET = registerItem("trocellate_helmet", new ArmorItem(ModArmorMaterials.TROCELLATE, EquipmentSlot.HEAD,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item TROCELLATE_CHESTPLATE = registerItem("trocellate_chestplate", new ArmorItem(ModArmorMaterials.TROCELLATE, EquipmentSlot.CHEST,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item TROCELLATE_LEGGINGS = registerItem("trocellate_leggings", new ArmorItem(ModArmorMaterials.TROCELLATE, EquipmentSlot.LEGS,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item TROCELLATE_BOOTS = registerItem("trocellate_boots", new ArmorItem(ModArmorMaterials.TROCELLATE, EquipmentSlot.FEET,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));


    public static final Item DOMDECON_HELMET = registerItem("domdecon_helmet", new ArmorItem(ModArmorMaterials.DOMDECON, EquipmentSlot.HEAD,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item DOMDECON_CHESTPLATE = registerItem("domdecon_chestplate", new ArmorItem(ModArmorMaterials.DOMDECON, EquipmentSlot.CHEST,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item DOMDECON_LEGGINGS = registerItem("domdecon_leggings", new ArmorItem(ModArmorMaterials.DOMDECON, EquipmentSlot.LEGS,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item DOMDECON_BOOTS = registerItem("domdecon_boots", new ArmorItem(ModArmorMaterials.DOMDECON, EquipmentSlot.FEET,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));


    public static final Item ASCONDELLUM_HELMET = registerItem("ascondellum_helmet", new ArmorItem(ModArmorMaterials.ASCONDELLUM, EquipmentSlot.HEAD,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item ASCONDELLUM_CHESTPLATE = registerItem("ascondellum_chestplate", new ArmorItem(ModArmorMaterials.ASCONDELLUM, EquipmentSlot.CHEST,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item ASCONDELLUM_LEGGINGS = registerItem("ascondellum_leggings", new ArmorItem(ModArmorMaterials.ASCONDELLUM, EquipmentSlot.LEGS,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item ASCONDELLUM_BOOTS = registerItem("ascondellum_boots", new ArmorItem(ModArmorMaterials.ASCONDELLUM, EquipmentSlot.FEET,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));


    public static final Item ARCONLON_HELMET = registerItem("arconlon_helmet", new ArmorItem(ModArmorMaterials.ARCONLON, EquipmentSlot.HEAD,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item ARCONLON_CHESTPLATE = registerItem("arconlon_chestplate", new ArmorItem(ModArmorMaterials.ARCONLON, EquipmentSlot.CHEST,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item ARCONLON_LEGGINGS = registerItem("arconlon_leggings", new ArmorItem(ModArmorMaterials.ARCONLON, EquipmentSlot.LEGS,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));
    public static final Item ARCONLON_BOOTS = registerItem("arconlon_boots", new ArmorItem(ModArmorMaterials.ARCONLON, EquipmentSlot.FEET,
            new FabricItemSettings().group(ModItemGroup.HIDDENISLESTAB)
    ));


    //misc

    //food

    private String id = HiddenIsles.MOD_ID;
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(HiddenIsles.MOD_ID, name), item);
    }
    public static void registerModItems(){
        HiddenIsles.LOGGER.info("Registering Mod Items for " + HiddenIsles.MOD_ID);
    }
}
