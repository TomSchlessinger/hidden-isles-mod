package net.myshampooisdrunk.hiddenisles.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial{
    PRIMORDIUM("primordium", 60, new int[]{3, 8, 9, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3F, 0.1F, () -> Ingredient.ofItems(ModItems.PRIMORDIUM_INGOT)
    ),PRISTINIUM("pristinium", 80, new int[]{5, 10, 11, 6}, 11, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4F, 0.1F, () -> Ingredient.ofItems(ModItems.PRISTINIUM_INGOT)
    ),COORDIUM("coordium", 60, new int[]{3, 8, 9, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3F, 0.1F, () -> Ingredient.ofItems(ModItems.COORDIUM_INGOT)
    ),TROCELLATE("trocellate", 50, new int[]{3, 7, 8, 4}, 19, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.5F, 0.1F, () -> Ingredient.ofItems(ModItems.TROCELLATE_INGOT)
    ),DOMDECON("domdecon", 50, new int[]{3, 7, 8, 4}, 23, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.5F, 0.1F, () -> Ingredient.ofItems(ModItems.DOMDECON_INGOT)
    ),ASCONDELLUM("ascondellum", 70, new int[]{4, 10, 9, 5}, 28, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5F, 0.1F, () -> Ingredient.ofItems(ModItems.ASCONDELLUM_INGOT)
    ),ARCONLON("arcanlon", 60, new int[]{3, 8, 9, 4}, 19, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3F, 0.1F, () -> Ingredient.ofItems(ModItems.ARCONLON_INGOT)
    );

    private static final int[] BASE_DURABILITY = new int[]{15, 18, 17, 13};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy(repairIngredientSupplier);
    }

    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredientSupplier.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
