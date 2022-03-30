package net.myshampooisdrunk.hiddenisles.item.custom;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.util.math.Vector3d;
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
import net.myshampooisdrunk.hiddenisles.util.MathUtils;


public class ModArmorItem extends ArmorItem {
    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if(!world.isClient()) {
            if(entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity)entity;

                if(hasFullSuitOfArmorOn(player)) {
                    if(hasSameArmor(player)){
                        final ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
                        final ArmorMaterial material = boots.getMaterial();
                        ClientTickEvents.END_CLIENT_TICK.register(client -> {
                            while(HiddenIslesClient.ability.isPressed()){

                                Vector3d posVector = new Vector3d(
                                        player.getX(),
                                        player.getY(),
                                        player.getZ()
                                );
                                Vec3d lookVector = player.getRotationVector();




                                if(material.equals(ModArmorMaterials.PRIMORDIUM)){

                                    double extraPitch = 10;
                                    double magnitude = 2.25;

                                    Vector3d dashVector = new Vector3d(
                                            lookVector.getX(),
                                            lookVector.getY(),
                                            lookVector.getZ()
                                    );

                                    float initialYaw = (float) MathUtils.getYaw(dashVector);

                                    dashVector = MathUtils.rotateYaw(dashVector, initialYaw);

                                    double dashPitch = Math.toDegrees(MathUtils.getPitch(dashVector));

                                    if (dashPitch + extraPitch > 90) {
                                        dashVector = new Vector3d(0, 1, 0);
                                        dashPitch = 90;
                                    } else {
                                        dashVector = MathUtils.rotateRoll(dashVector, (float) Math.toRadians(-extraPitch));
                                        dashVector = MathUtils.rotateYaw(dashVector, -initialYaw);
                                        dashVector = MathUtils.normalize(dashVector);
                                    }

                                    double coef = 1.6 - MathUtils.map( Math.abs(dashPitch),
                                            0.0d, 90.0d,
                                            0.6, 1.0d);

                                    dashVector.multiply(magnitude * coef);
                                    //System.out.println("x vel: " + dashVector.x + " \ny vel:"+ dashVector.y + " \nz vel:"+ dashVector.z);
                                    player.addVelocity(
                                            dashVector.x,
                                            dashVector.y,
                                            dashVector.z
                                    );

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
