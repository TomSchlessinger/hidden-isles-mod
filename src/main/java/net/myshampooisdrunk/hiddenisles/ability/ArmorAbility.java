package net.myshampooisdrunk.hiddenisles.ability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.AmbientEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.myshampooisdrunk.hiddenisles.effects.ModStatusEffects;
import net.myshampooisdrunk.hiddenisles.entity.TrocellateMissile;
import net.myshampooisdrunk.hiddenisles.item.ModArmorMaterials;
import net.myshampooisdrunk.hiddenisles.util.*;

import java.util.ArrayList;
import java.util.List;

import static net.myshampooisdrunk.hiddenisles.item.ModItems.*;
import net.myshampooisdrunk.hiddenisles.util.Ability;
import net.myshampooisdrunk.hiddenisles.util.ArmorCooldown;

public class ArmorAbility extends Ability {
    private int cooldown;
    public ArmorAbility(World world, PlayerEntity player, ModArmorMaterials material){
        super(world,player,material);
        if(material instanceof ModArmorMaterials){
            if(material.equals(ModArmorMaterials.PRIMORDIUM)){
                cooldown = ArmorAbilities.PRIMORDIUM.cooldown;
            }else if(material.equals(ModArmorMaterials.PRISTINIUM) || material.equals(ModArmorMaterials.ARCONLON)){
                cooldown = ArmorAbilities.PRISTINUM.cooldown;
            }else{
                cooldown = ArmorAbilities.COORDIUM.cooldown;
            }
        }else{
            cooldown = 0;
        }

    }

    @Override
    public void useAbility() {
        Vec3d pos = player.getPos();
        Vec3d lookVector = player.getRotationVector();
        switch(mat){
            default:
            case PRIMORDIUM:
                if(!((ArmorCooldown)player).getManager().isCoolingDown(PRIMORDIUM_CHESTPLATE)){
                    double dashMult = 2.3;
                    ((ArmorCooldown)player).getManager().set(PRIMORDIUM_CHESTPLATE, cooldown);
                    player.setVelocity(dashMult * lookVector.getX(), dashMult * lookVector.getY(), dashMult * lookVector.getZ());
                    player.velocityModified = true;
                }

                break;


            case PRISTINIUM:
                if(!((ArmorCooldown)player).getManager().isCoolingDown(PRISTINIUM_CHESTPLATE)) {
                    ((ArmorCooldown) player).getManager().set(PRISTINIUM_CHESTPLATE, cooldown);
                    player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.PRISTINIUM_STRENGTH, 600, 0, true, true, false));
                }

                break;

            case COORDIUM:
                if(!((ArmorCooldown)player).getManager().isCoolingDown(COORDIUM_CHESTPLATE)){
                    ((ArmorCooldown) player).getManager().set(COORDIUM_CHESTPLATE, cooldown);
                    player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.COORDIUM_STRENGTH, 400, 0, true, true, false));
                }
                //System.out.println("Coordium: " + ((ArmorCooldown)player).getManager().isCoolingDown(COORDIUM_CHESTPLATE));
                break;

            case TROCELLATE:
                if(!((ArmorCooldown)player).getManager().isCoolingDown(TROCELLATE_CHESTPLATE)){
                    ((ArmorCooldown) player).getManager().set(TROCELLATE_CHESTPLATE, cooldown);
                    Box targetBox = new Box(pos.x, pos.y, pos.z, pos.x, pos.y, pos.z);
                    targetBox = targetBox.expand(20);
                    List<Entity> PotTargets = player.getWorld().getOtherEntities(player, targetBox);//potential targets
                    List<LivingEntity> Targets = new ArrayList<>(List.of());
                    PotTargets.forEach(E -> {
                        if (E instanceof LivingEntity L) {
                            if(!(L instanceof PassiveEntity || L instanceof AmbientEntity || L instanceof WaterCreatureEntity || L instanceof ArmorStandEntity)){
                                if(!player.isTeammate(L)){
                                    Targets.add(L);
                                    /*if(L instanceof TameableEntity T){
                                        if(T.getOwnerUuid() != null) {
                                            if (T.getOwnerUuid() != player.getUuid()) {
                                                Targets.add(T);
                                            }
                                        }
                                    }else{
                                        Targets.add(L);
                                    }we don't talk about my lack of thinking here 🤦🤦🤦 if it isn't passive it CANT BE A FUCKING TAMABLE ENTITY*/
                                }
                            }
                        }
                    });
                    Targets.forEach(T -> {
                        Vec3d TargetPos = T.getPos();
                        TrocellateMissile missile = new TrocellateMissile(player.getWorld(), TargetPos.x, TargetPos.y + 7.5d, TargetPos.z, player,0,true);
                        missile.setVelocity(0.0d, -2.0d, 0.0d);
                        player.getWorld().spawnEntity(missile);
                    });
                }
                break;

            case DOMDECON:
                if(!((ArmorCooldown)player).getManager().isCoolingDown(DOMDECON_CHESTPLATE)){
                    ((ArmorCooldown) player).getManager().set(DOMDECON_CHESTPLATE, cooldown);
                    Box effectBox = new Box(pos.x, pos.y, pos.z, pos.x, pos.y, pos.z);
                    effectBox = effectBox.expand(55.0);
                    List<Entity> EList = player.getWorld().getOtherEntities(player, effectBox);
                    EList.forEach(E -> {
                        if (E instanceof LivingEntity L && !(E instanceof ArmorStandEntity)) {
                            L.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 0, true, false, false));
                        }
                    });
                }
                break;

            case ASCONDELLUM:
                if(!((ArmorCooldown)player).getManager().isCoolingDown(ASCONDELLUM_CHESTPLATE)){
                    ((ArmorCooldown) player).getManager().set(ASCONDELLUM_CHESTPLATE, cooldown);
                    Box targetBox = new Box(pos.x, pos.y, pos.z, pos.x, pos.y, pos.z);
                    targetBox = targetBox.expand(12,4,12);
                    List<Entity> PotTargets = player.getWorld().getOtherEntities(player, targetBox);//potential targets
                    List<LivingEntity> Targets = new ArrayList<>(List.of());
                    PotTargets.forEach(E -> {
                        if (E instanceof LivingEntity L) {
                            if(!(L instanceof PassiveEntity || L instanceof AmbientEntity || L instanceof WaterCreatureEntity || L instanceof ArmorStandEntity)){
                                if(!player.isTeammate(L)){
                                    Targets.add(L);
                                }
                            }
                        }
                    });
                    Targets.forEach(T -> {
                        T.addStatusEffect(new StatusEffectInstance(ModStatusEffects.ASCONDELLUM_WEAKNESS,200,0,true,false,false),player);
                        T.setOnFireFor(15);
                    });
                    player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.STRONG_ARMS,200,0,true,false,false));
                }
                break;

            case ARCONLON:
                if(!((ArmorCooldown)player).getManager().isCoolingDown(ARCONLON_CHESTPLATE)){
                    ((ArmorCooldown) player).getManager().set(ARCONLON_CHESTPLATE, 900);
                    Vec3d finalPos = player.raycast(50d,1,false).getPos();
                    world.playSound(null,player.getX(),player.getY(),player.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.NEUTRAL,50f,0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
                    world.playSound(null,finalPos.x,finalPos.y,finalPos.z, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.NEUTRAL,50f,0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
                    player.teleport(finalPos.x,finalPos.y,finalPos.z);
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,150,3,true,false,false));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,100,0,true,false,false));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE,100,1,true,false,false));
                }
                break;
        }



    }

    @Override
    public void changeMat(ModArmorMaterials material){
        if(material instanceof ModArmorMaterials){
            if(material.equals(ModArmorMaterials.PRIMORDIUM)){
                cooldown = ArmorAbilities.PRIMORDIUM.cooldown;
            }else if(material.equals(ModArmorMaterials.PRISTINIUM) || material.equals(ModArmorMaterials.ARCONLON)){
                cooldown = ArmorAbilities.PRISTINUM.cooldown;
            }else{
                cooldown = ArmorAbilities.COORDIUM.cooldown;
            }
        }else{
            cooldown = 0;
        }
        super.changeMat(material);

    }
}