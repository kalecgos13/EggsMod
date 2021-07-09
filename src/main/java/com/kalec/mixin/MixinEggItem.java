package com.kalec.mixin;

import com.kalec.Items.StartUpCommon;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EggItem.class)
public class MixinEggItem {
    public ActionResultType onItemUse(ItemUseContext context) {
        if (!context.getWorld().isRemote) {
            PlayerEntity player = context.getPlayer();
            if (!player.abilities.isCreativeMode) {
                ItemStack itemstack = player.getHeldItem(context.getHand());
                itemstack.shrink(1);
                player.inventory.setInventorySlotContents(player.inventory.currentItem, itemstack);
            }
            ItemStack itemStackBrokenEgg = new ItemStack(StartUpCommon.brokenEggItem, 1);
            ItemHandlerHelper.giveItemToPlayer(player, itemStackBrokenEgg);
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.SUCCESS;
    }
}