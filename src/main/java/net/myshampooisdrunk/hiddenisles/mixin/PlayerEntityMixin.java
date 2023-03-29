package net.myshampooisdrunk.hiddenisles.mixin;

import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.myshampooisdrunk.hiddenisles.util.ArmorCooldown;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin implements ArmorCooldown {
    public ItemCooldownManager armorCooldown = new ItemCooldownManager();

    @Override
    public ItemCooldownManager getManager() {
        return armorCooldown;
    }
    @Inject(at = @At("TAIL"), method = "tick()V")
    private void ArmorCooldown$tick(CallbackInfo ci) {
        armorCooldown.update();
    }



}