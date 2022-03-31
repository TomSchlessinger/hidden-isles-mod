package net.myshampooisdrunk.hiddenisles.item.custom;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.math.Vector3d;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.myshampooisdrunk.hiddenisles.client.keybinding.HiddenIslesClient;
import net.myshampooisdrunk.hiddenisles.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import net.myshampooisdrunk.hiddenisles.util.MathUtils;


public class ModArmorItem extends ArmorItem {
    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }
    public boolean abilityActive = false;


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {


                if(hasFullSuitOfArmorOn(player)) {
                    if(hasSameArmor(player)){
                        final ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
                        final ArmorMaterial material = boots.getMaterial();
                        ClientTickEvents.END_CLIENT_TICK.register(client -> {
                            if(HiddenIslesClient.ability.isPressed() && !abilityActive){

                                abilityActive = true;

                                Vector3d posVector = new Vector3d(
                                        player.getX(),
                                        player.getY(),
                                        player.getZ()
                                );
                                RenderTickCounter ref = new RenderTickCounter(0, 0);
                                Vec3d lookVector = player.getRotationVec(1.0f);

                                if(material.equals(ModArmorMaterials.PRIMORDIUM)){
                                    double distance = 15;

                                    player.addVelocity(
                                            distance*lookVector.getX(),
                                            distance*lookVector.getY(),
                                            distance*lookVector.getZ()
                                    );
                                    world.playSound(null, posVector.x,posVector.y,posVector.z, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS,1f,1f);
                                    ((ServerWorld) player.world).spawnParticles(ParticleTypes.POOF, posVector.x,posVector.y,posVector.z, 50, 1D, 0.5D, 1D, 0.0D);


                                    player.velocityModified = true;

                                }
                                else if(material.equals(ModArmorMaterials.PRISTINIUM)){
                                    System.out.println("Wear some real armor");
                                }
                                else if(material.equals(ModArmorMaterials.COORDIUM)){
                                    System.out.println("Wear some real armor");
                                }
                                else if(material.equals(ModArmorMaterials.TROCELLATE)){
                                    System.out.println("Wear some real armor");
                                }
                                else if(material.equals(ModArmorMaterials.DOMDECON)){
                                    System.out.println("Wear some real armor");
                                }
                                else if(material.equals(ModArmorMaterials.ASCONDELLUM)){
                                    System.out.println("Wear some real armor");
                                }
                                else if(material.equals(ModArmorMaterials.ARCONLON)){
                                    System.out.println("Wear some real armor");
                                }
                            }else{
                                abilityActive = false;
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

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasSameArmor(PlayerEntity player){
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());
        return helmet.getMaterial() == breastplate.getMaterial() && breastplate.getMaterial() == leggings.getMaterial() &&
                leggings.getMaterial() == boots.getMaterial();
    }

}
