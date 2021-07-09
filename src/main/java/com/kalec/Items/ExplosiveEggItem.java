package com.kalec.Items;

import com.kalec.entity.projectile.ExplosiveEggEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ExplosiveEggItem extends Item {
    public ExplosiveEggItem() {
        super((new Item.Properties()).maxStackSize(16).group(ItemGroup.COMBAT));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getHeldItem(hand);
        world.playSound((PlayerEntity) null, player.getPosX(), player.getPosY(), player.getPosZ(),
                SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.1F / (random.nextFloat() * 0.1F + 0.4F));
        if(!world.isRemote) {
            ExplosiveEggEntity explosiveEggEntity = new ExplosiveEggEntity(world, player);
            explosiveEggEntity.setItem(itemStack);
            explosiveEggEntity.setDirectionAndMovement(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.addEntity(explosiveEggEntity);
        }
        player.addStat(Stats.ITEM_USED.get(this));
        if(!player.abilities.isCreativeMode) {
            itemStack.shrink(1);
        }
        return ActionResult.resultSuccess(itemStack);
    }
}
