package net.myshampooisdrunk.hiddenisles.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    PRIMORDIUM(MiningLevels.NETHERITE, 4500, 13.0F, 6.5F, 15,
            () -> Ingredient.ofItems(ModItems.PRIMORDIUM_INGOT)
    ),PRISTINIUM(MiningLevels.NETHERITE, 4500, 10.0F, 4.5F, 11,
            () -> Ingredient.ofItems(ModItems.PRISTINIUM_INGOT)
    ),COORDIUM(MiningLevels.NETHERITE, 4500, 10.0F, 8.5F, 11,
            () -> Ingredient.ofItems(ModItems.COORDIUM_INGOT)
    ),TROCELLATE(MiningLevels.NETHERITE, 4500, 16.0F, 6.5F, 17,
            () -> Ingredient.ofItems(ModItems.TROCELLATE_INGOT)
    ),DOMDECON(MiningLevels.NETHERITE, 4500, 22.0F, 2.5F, 24,
            () -> Ingredient.ofItems(ModItems.DOMDECON_INGOT)
    ),ASCONDELLUM(MiningLevels.NETHERITE, 4500, 19.0F, 4.5F, 20,
            () -> Ingredient.ofItems(ModItems.ASCONDELLUM_INGOT)
    ),ARCONLON(MiningLevels.NETHERITE, 4500, 16.0F, 4.5F, 17,
            () -> Ingredient.ofItems(ModItems.ARCONLON_INGOT)
    );

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
