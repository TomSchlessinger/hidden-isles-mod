package net.myshampooisdrunk.hiddenisles.item.custom;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.myshampooisdrunk.hiddenisles.ability.ArmorAbility;
import net.myshampooisdrunk.hiddenisles.client.keybinding.HiddenIslesClient;
import net.myshampooisdrunk.hiddenisles.item.ModArmorMaterials;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;


public class ModArmorItem extends ArmorItem  implements IAnimatable {
    private boolean canUseAbility;
    private AnimationFactory factory = new AnimationFactory(this);
    
    @Override
    public void registerControllers(AnimationData aData) {
        aData.addAnimationController(new AnimationController<ModArmorItem>(this,"controller",20,this::predicate));
    }

    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event){
        event.getController().setAnimation(new AnimationBuilder().addAnimation("default",false));
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
        if(!world.isClient()){
            if (entity instanceof PlayerEntity player){

                ArmorAbility ability = new ArmorAbility(world, player, ModArmorMaterials.PRIMORDIUM);
                ClientTickEvents.START_CLIENT_TICK.register(client -> {
                    if (HiddenIslesClient.ability.isPressed()) {
                        canUseAbility = hasFullSuitOfArmorOn(player);
                        if(canUseAbility){
                            canUseAbility = hasSameArmor(player);
                        }
                        if(canUseAbility){
                            final ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
                            if (boots.getMaterial() instanceof ModArmorMaterials){
                                final ArmorMaterial material = boots.getMaterial();
                                ability.changeMat((ModArmorMaterials) material);
                                ability.useAbility();
                            }
                        }
                    }
                });
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