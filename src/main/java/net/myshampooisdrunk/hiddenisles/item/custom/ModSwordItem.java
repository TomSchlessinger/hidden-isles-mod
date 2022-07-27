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
        if(player.getMainHandStack().getItem().equals(ModItems.COORDIUM_BLADE)){
            if (world.isClient()) {
                Vec3d pos = player.getPos();
                Vec3d lookVector = player.getRotationVec(1.0f);
                TrocellateMissile missile = new TrocellateMissile(player.getWorld(), pos.x + lookVector.x, pos.y + lookVector.y, pos.z + lookVector.z, player);
                missile.setVelocity(1.45 * lookVector.x, 1.45 * lookVector.y, 1.45 * lookVector.z);
                player.getWorld().spawnEntity(missile);
                System.out.println("hi");
            }
        }

        return super.use(world, player, hand);

    }

    public ActionResult useOnBlock(ItemUsageContext context){
        if(context.getWorld().isClient()) {
            PlayerEntity player = context.getPlayer();
            Vec3d pos = player.getPos();
            Vec3d lookVector = player.getRotationVec(1.0f);
            TrocellateMissile missile = new TrocellateMissile(player.getWorld(), pos.x+lookVector.x, pos.y+lookVector.y, pos.z+lookVector.z, player);
            missile.setVelocity(1.45 * lookVector.x, 1.45 * lookVector.y, 1.45 * lookVector.z);
            player.getWorld().spawnEntity(missile);
            System.out.println("hi");
        }
        context.getStack().damage(10, context.getPlayer(),
                (player) -> player.sendToolBreakStatus(player.getActiveHand()));
        return super.useOnBlock(context);
    }
}
