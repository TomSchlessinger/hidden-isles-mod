package net.myshampooisdrunk.hiddenisles.effects;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.MathHelper;
import io.netty.util.internal.ThreadLocalRandom;
import net.minecraft.util.registry.Registry;

public class ModStatusEffects {

    public static StatusEffect PRISTINIUM_STRENGTH;
    public static StatusEffect COORDIUM_STRENGTH;
    public static StatusEffect BROKEN_ARMOR;

    public ModStatusEffects(){}

    private static StatusEffect register(int rawId, String id, StatusEffect entry) {
        return (StatusEffect) Registry.register(Registry.STATUS_EFFECT, rawId, id, entry);
    }

    public static void registerEffects(){
        PRISTINIUM_STRENGTH = register(1000,"hiddenisles:pristinium_strength",(new ModAbsorptionStatusEffect(StatusEffectCategory.BENEFICIAL,82133163){
            public boolean canApplyUpdateEffect(int duration, int amplifier) {return true;}
        })
                .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, (MathHelper.randomUuid(ThreadLocalRandom.current())).toString(),-0.2D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, (MathHelper.randomUuid(ThreadLocalRandom.current())).toString(),-0.15D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, (MathHelper.randomUuid(ThreadLocalRandom.current())).toString(),-0.2D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        COORDIUM_STRENGTH = register(1001, "hiddenisles:coordium_strength",(new StatusEffect(StatusEffectCategory.BENEFICIAL, 18767173){public boolean canApplyUpdateEffect(int duration, int amplifier) {return true;}})
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, (MathHelper.randomUuid(ThreadLocalRandom.current())).toString(),3.0D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        BROKEN_ARMOR = register(1002, "hiddenisles:broken_armor",(new StatusEffect(StatusEffectCategory.HARMFUL,979797){public boolean canApplyUpdateEffect(int duration, int amplifier) {return true;}})
                .addAttributeModifier(EntityAttributes.GENERIC_ARMOR, (MathHelper.randomUuid(ThreadLocalRandom.current())).toString(),-0.45D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

    }

}
