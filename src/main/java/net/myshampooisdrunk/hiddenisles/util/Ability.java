package net.myshampooisdrunk.hiddenisles.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.myshampooisdrunk.hiddenisles.item.ModArmorMaterials;

public abstract class Ability {
    protected final World world;
    protected final PlayerEntity player;
    protected ModArmorMaterials mat;
    public Ability(World world, PlayerEntity player, ModArmorMaterials material){
        this.world = world;
        this.player = player;
        this.mat = material;
    }
    public ModArmorMaterials getMat(){return this.mat;}

    public void changeMat(ModArmorMaterials material){
        this.mat = material;
    }

    public abstract void useAbility();
}
