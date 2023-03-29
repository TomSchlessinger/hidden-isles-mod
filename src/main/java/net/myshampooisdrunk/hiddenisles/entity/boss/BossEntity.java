package net.myshampooisdrunk.hiddenisles.entity.boss;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public abstract class BossEntity extends HostileEntity{
    private final ServerBossBar bossBar;
    private final BossPhaseManager manager = new BossPhaseManager(this);
    private final BossBar.Color color;
    protected List<Item> drops = new ArrayList<>();

    public BossEntity(EntityType<? extends BossEntity> entityType, World world, BossBar.Color color){
        super(entityType,world);
        this.color = color;
        this.bossBar = (ServerBossBar)(new ServerBossBar(this.getDisplayName(), this.color, BossBar.Style.PROGRESS)).setDarkenSky(true);
        this.setHealth(this.getMaxHealth());
        this.experiencePoints = 750;
    }

    public void mobTick(){
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }

    public abstract void attack();

    //public abstract boolean damage(DamageSource source, float amount);

    protected void addDrop(Item item) {
        this.drops.add(item);
    }

    @Override
    protected void dropEquipment(DamageSource source, int lootingMultiplier, boolean allowDrops) {
        super.dropEquipment(source, lootingMultiplier, allowDrops);
        for (Item item : drops) {
            ItemEntity entity = this.dropItem(item);
            if (entity != null) entity.setCovetedItem();
        }
    }

    public List<LivingEntity> getAttackers(int range) {
        Box box = this.getBoundingBox().expand(range);
        List<Entity> entities = this.world.getOtherEntities(this, box);
        List<LivingEntity> attackers = new ArrayList<>();
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity && ((LivingEntity)entity).getAttacking() == this) {
                attackers.add((LivingEntity) entity);
            }
        }
        return attackers;
    }

    /**
     * Returns a list of all attacking players only within 10 blocks radius of the boss' bounding box.
     */
    public List<PlayerEntity> getAttackingPlayers(int range) {
        List<LivingEntity> entities = this.getAttackers(range);
        List<PlayerEntity> players = new ArrayList<>();
        for (LivingEntity entity : entities) {
            if (entity instanceof PlayerEntity) {
                players.add((PlayerEntity) entity);
            }
        }
        return players;
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (this.hasCustomName()) {
            this.bossBar.setName(this.getDisplayName());
        }
    }

    @Override
    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossBar.setName(this.getDisplayName());
    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
    }

    @Override
    protected boolean shouldAlwaysDropXp() {
        return true;
    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected boolean canStartRiding(Entity entity) {
        return false;
    }

    @Override
    public abstract boolean isFireImmune();

    @Override
    public abstract boolean isUndead();

    @Override
    public abstract boolean disablesShield();

}
