package net.myshampooisdrunk.hiddenisles.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.myshampooisdrunk.hiddenisles.entity.TrocellateMissile;
import net.myshampooisdrunk.hiddenisles.item.ModItems;

import javax.swing.*;

public class ModSwordItem extends SwordItem {
    public ModSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if(player.getStackInHand(hand).getItem().equals(ModItems.TROCELLATE_BLADE) ){
            if (!world.isClient()) {
                Vec3d pos = player.getPos();
                Vec3d lookVector = player.getRotationVec(1.0f);
                TrocellateMissile missile = new TrocellateMissile(player.getWorld(), pos.x, pos.y + 1 , pos.z, player, 1);
                missile.setVelocity(1.7 * lookVector.x, 1.7 * lookVector.y, 1.7 * lookVector.z);
                player.getWorld().spawnEntity(missile);
            }
        }

        return super.use(world, player, hand);

    }
}
