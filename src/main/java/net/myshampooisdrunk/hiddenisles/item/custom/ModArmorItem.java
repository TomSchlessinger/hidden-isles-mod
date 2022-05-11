package net.myshampooisdrunk.hiddenisles.item.custom;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.AmbientEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import net.minecraft.world.World;
import net.myshampooisdrunk.hiddenisles.client.keybinding.HiddenIslesClient;
import net.myshampooisdrunk.hiddenisles.effects.ModStatusEffects;
import net.myshampooisdrunk.hiddenisles.entity.TrocellateMissile;
import net.myshampooisdrunk.hiddenisles.item.ModArmorMaterials;
import net.myshampooisdrunk.hiddenisles.util.ArmorCooldown;
import net.myshampooisdrunk.hiddenisles.util.MathUtils;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import net.minecraft.util.hit.HitResult.Type;
import java.util.ArrayList;
import java.util.List;

import static net.myshampooisdrunk.hiddenisles.item.ModItems.*;


public class ModArmorItem extends ArmorItem  implements IAnimatable {

    private AnimationFactory factory = new AnimationFactory(this);

    @Override
    public void registerControllers(AnimationData aData) {
        aData.addAnimationController(new AnimationController<ModArmorItem>(this,"controller",20,this::predicate));
    }

    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event){
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle",true));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                assert hasFullSuitOfArmorOn(player);
                if(hasFullSuitOfArmorOn(player)) {
                    if(hasFullSuitOfArmorOn(player)){
                        final ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
                        final ArmorMaterial material = boots.getMaterial();
                        ClientTickEvents.END_CLIENT_TICK.register(client -> {
                            if(HiddenIslesClient.ability.isPressed()){
                                Vec3d pos = player.getPos();
                                Vec3d lookVector = player.getRotationVec(1.0f);

                                if( ((ArmorItem) player.getInventory().getArmorStack(0).getItem()).getMaterial().equals(ModArmorMaterials.PRIMORDIUM)){
                                    if(!((ArmorCooldown)player).getManager().isCoolingDown(PRIMORDIUM_CHESTPLATE)){
                                        player.setVelocity(1.92 * lookVector.getX(), 1.92 * lookVector.getY(), 1.92 * lookVector.getZ());
                                        player.velocityModified = true;
                                        ((ArmorCooldown) player).getManager().set(PRIMORDIUM_CHESTPLATE, 300);
                                    }
                                }
                                else if(((ArmorItem) player.getInventory().getArmorStack(0).getItem()).getMaterial().equals(ModArmorMaterials.PRISTINIUM)){
                                    if(!((ArmorCooldown)player).getManager().isCoolingDown(PRISTINIUM_CHESTPLATE)) {

                                        player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.PRISTINIUM_STRENGTH, 600, 0, true, true, false));
                                        ((ArmorCooldown) player).getManager().set(PRISTINIUM_CHESTPLATE, 1200);
                                    }
                                }
                                else if(((ArmorItem) player.getInventory().getArmorStack(0).getItem()).getMaterial().equals(ModArmorMaterials.COORDIUM)){
                                    if(!((ArmorCooldown)player).getManager().isCoolingDown(COORDIUM_CHESTPLATE)){
                                        player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.COORDIUM_STRENGTH, 400, 0, true, true, false));
                                        ((ArmorCooldown) player).getManager().set(COORDIUM_CHESTPLATE, 900);
                                    }
                                }
                                else if(((ArmorItem) player.getInventory().getArmorStack(0).getItem()).getMaterial().equals(ModArmorMaterials.TROCELLATE)){
                                    if(!((ArmorCooldown)player).getManager().isCoolingDown(TROCELLATE_CHESTPLATE)){
                                        Box targetBox = new Box(pos.x, pos.y, pos.z, pos.x, pos.y, pos.z);
                                        targetBox = targetBox.expand(20);
                                        List<Entity> PotTargets = player.getWorld().getOtherEntities(player, targetBox);//potential targets
                                        List<LivingEntity> PotTargets2 = new ArrayList<>(List.of());
                                        List<LivingEntity> PotTargets3 = new ArrayList<>(List.of());
                                        List<LivingEntity> PotTargets4 = new ArrayList<>(List.of());
                                        List<LivingEntity> Targets = new ArrayList<>(List.of());
                                        System.out.println(PotTargets.size());
                                        PotTargets.forEach(E -> {
                                            if (E instanceof LivingEntity L) {
                                                PotTargets2.add(L);
                                            }
                                        });
                                        System.out.println(PotTargets2.size());
                                        PotTargets2.forEach(L -> {
                                            if(!(L instanceof PassiveEntity P || L instanceof AmbientEntity A || L instanceof WaterCreatureEntity W)){
                                                PotTargets3.add(L);
                                            }

                                        });
                                        System.out.println(PotTargets3.size());
                                        PotTargets3.forEach(L -> {
                                            if (!player.isTeammate(L)) {
                                                PotTargets4.add(L);
                                            }
                                        });
                                        System.out.println(PotTargets4.size());
                                        PotTargets4.forEach(L -> {
                                            if(!(L instanceof TameableEntity T)){
                                                Targets.add(L);
                                            }
                                            if (L instanceof TameableEntity T) {
                                                if (T.getOwnerUuid() != null) {if (T.getOwnerUuid() != player.getUuid()) {Targets.add(T);}}
                                            }
                                        });
                                        System.out.println(Targets.size());
                                        Targets.forEach(T -> {
                                            Vec3d TargetPos = T.getPos();
                                            TrocellateMissile missile = new TrocellateMissile(player.getWorld(), TargetPos.x, TargetPos.y + 7.5d, TargetPos.z, player);
                                            missile.setVelocity(0.0d, -1.0d, 0.0d);
                                            player.getWorld().spawnEntity(missile);
                                        });

                                        ((ArmorCooldown) player).getManager().set(TROCELLATE_CHESTPLATE, 300);
                                    }
                                }
                                else if(((ArmorItem) player.getInventory().getArmorStack(0).getItem()).getMaterial().equals(ModArmorMaterials.DOMDECON)){
                                    if(!((ArmorCooldown)player).getManager().isCoolingDown(DOMDECON_CHESTPLATE)){
                                        Box effectBox = new Box(pos.x, pos.y, pos.z, pos.x, pos.y, pos.z);
                                        effectBox = effectBox.expand(55.0);
                                        List<Entity> EList = player.getWorld().getOtherEntities(player, effectBox);
                                        System.out.println(EList.size());
                                        EList.forEach(E -> {
                                            if (E instanceof LivingEntity L) {
                                                ((LivingEntity) L).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 600, 0, true, false, false));
                                            }
                                        });
                                        ((ArmorCooldown) player).getManager().set(DOMDECON_CHESTPLATE, 1200);
                                    }
                                }
                                else if(((ArmorItem) player.getInventory().getArmorStack(0).getItem()).getMaterial().equals(ModArmorMaterials.ARCONLON)){
                                    if(!((ArmorCooldown)player).getManager().isCoolingDown(ARCONLON_CHESTPLATE)){
                                        Vec3d min = new Vec3d(pos.x,player.getEyeY(),pos.z);
                                        Vec3d deltaDist = lookVector.multiply(50.0d);
                                        double x = 49.0;

                                        Vec3d deltaDist2 = lookVector.multiply(x);
                                        Vec3d max = new Vec3d(min.x+deltaDist.x,min.y+deltaDist.y,min.z+deltaDist.z);
                                        Vec3d max2 = new Vec3d(min.x+deltaDist2.x,min.y+deltaDist2.y,min.z+deltaDist2.z);
                                        BlockHitResult result = world.raycast(new RaycastContext(min,max, ShapeType.COLLIDER, FluidHandling.NONE, player ) );
                                        BlockHitResult result2 = world.raycast(new RaycastContext(min,max2, ShapeType.COLLIDER, FluidHandling.NONE, player ) );

                                        if(result.getType() == Type.MISS){
                                            player.setVelocity(0.0d,0.0d,0.0d);
                                            player.requestTeleport(max.x,max.y,max.z);
                                        }
                                        else{
                                            while(!MathUtils.isValidPosition(result2.getBlockPos(),world, world)){
                                                assert x>= -25;
                                                deltaDist2 = lookVector.multiply(x);
                                                max2 = new Vec3d(min.x+deltaDist2.x,min.y+deltaDist2.y,min.z+deltaDist2.z);
                                                result2 = world.raycast(new RaycastContext(min,max2, ShapeType.COLLIDER, FluidHandling.NONE, player ) );
                                                if(MathUtils.isValidPosition(result2.getBlockPos(),world,world)){
                                                    player.setVelocity(0.0d,0.0d,0.0d);
                                                    player.requestTeleport(max2.x,max2.y,max2.z);
                                                    break;
                                                }
                                                --x;
                                            }
                                        }
                                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,150,3,true,false,false));
                                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,100,0,true,false,false));
                                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,150,0,true,false,false));
                                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE,100,1,true,false,false));
                                        ((ArmorCooldown) player).getManager().set(ARCONLON_CHESTPLATE, 900);
                                    }
                                }
                            }
                        });
                    }
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasSameArmor(PlayerEntity player){
        if(!hasFullSuitOfArmorOn(player)){
            return false;
        }
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());
        return helmet.getMaterial().equals(breastplate.getMaterial()) && breastplate.getMaterial().equals(leggings.getMaterial()) && leggings.getMaterial().equals(boots.getMaterial());
    }

}
