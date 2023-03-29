package net.myshampooisdrunk.hiddenisles.entity.boss;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class AgnarBossEntity extends BossEntity implements GeoEntity {

    private AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);
    private int spawnTicks;

    public AgnarBossEntity(EntityType<? extends AgnarBossEntity> entityType, World world){
        super(entityType,world, BossBar.Color.PURPLE);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 60D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 1500)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 20.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 5.0D)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2.0D);
    }

    public void attack() {

    }

//    public boolean damage(DamageSource source, float amount) {
//        return false;
//    }

    public boolean isFireImmune() {
        return true;
    }

    public boolean isUndead() {
        return false;
    }

    public boolean disablesShield() {
        return true;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(DefaultAnimations.genericWalkIdleController(this));
        controllers.add(DefaultAnimations.genericAttackAnimation(this, DefaultAnimations.ATTACK_STRIKE));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }
}
