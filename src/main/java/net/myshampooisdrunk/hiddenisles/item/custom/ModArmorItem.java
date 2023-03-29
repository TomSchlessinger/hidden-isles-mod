package net.myshampooisdrunk.hiddenisles.item.custom;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.myshampooisdrunk.hiddenisles.ability.ArmorAbility;
import net.myshampooisdrunk.hiddenisles.client.keybinding.HiddenIslesClient;
import net.myshampooisdrunk.hiddenisles.entity.render.*;
import net.myshampooisdrunk.hiddenisles.item.ModArmorMaterials;
import net.myshampooisdrunk.hiddenisles.util.ArmorCooldown;
import software.bernie.example.client.renderer.armor.GeckoArmorRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static net.myshampooisdrunk.hiddenisles.item.ModItems.PRIMORDIUM_CHESTPLATE;


public class ModArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean canUseAbility;
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()){
            if (entity instanceof PlayerEntity player){
                if(((ArmorCooldown)player).getManager().isCoolingDown(PRIMORDIUM_CHESTPLATE) && player.velocityModified){
                   player.velocityModified = false;
                }
                ArmorAbility ability = new ArmorAbility(world, player, null);
                ClientTickEvents.START_CLIENT_TICK.register(client -> {
                    if (HiddenIslesClient.ability.isPressed()) {
                        canUseAbility = hasFullSuitOfArmorOn(player);
                        if(canUseAbility){
                            canUseAbility = hasSameArmor(player);
                        }
                        if(canUseAbility){
                            final ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
                            if (boots.getMaterial() instanceof ModArmorMaterials material){
                                ability.changeMat(material);
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

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private ArmorMaterial material = ModArmorItem.this.getMaterial();
            private GeoArmorRenderer<?> renderer;

            @Override
            public BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if(this.renderer == null){
                    if(material instanceof ModArmorMaterials){
                        switch((ModArmorMaterials)material){
                            case PRIMORDIUM -> this.renderer = new PrimordiumRender();
                            case PRISTINIUM -> this.renderer = new PristiniumRender();
                            case COORDIUM -> this.renderer = new CoordiumRender();
                            case TROCELLATE -> this.renderer = new TrocellateRender();
                            case DOMDECON -> this.renderer = new DomdeconRender();
                            case ASCONDELLUM -> this.renderer = new AscondellumRender();
                            case ARCONLON -> this.renderer = new ArconlonRender();
                        }
                    }
                }

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

                return this.renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return this.renderProvider;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}