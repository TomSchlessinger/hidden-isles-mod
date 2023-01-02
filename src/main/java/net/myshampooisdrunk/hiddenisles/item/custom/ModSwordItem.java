package net.myshampooisdrunk.hiddenisles.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.myshampooisdrunk.hiddenisles.entity.TrocellateMissile;
import net.myshampooisdrunk.hiddenisles.item.ModItems;

public class ModSwordItem extends SwordItem {
    public ModSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if(player.getStackInHand(hand).getItem().equals(ModItems.TROCELLATE_BLADE) ){
            if (!world.isClient()) {
                TrocellateMissile missile = new TrocellateMissile(world, player, 1,true);
                missile.setPosition(missile.getX(),missile.getY()-0.5,missile.getZ());
                missile.setVelocity(player,player.getPitch(),player.getYaw(),0.0f,2.3f,0.0f);
                world.spawnEntity(missile);
            }
        }

        return super.use(world, player, hand);

    }
}
