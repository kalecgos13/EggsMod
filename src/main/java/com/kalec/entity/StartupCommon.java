package com.kalec.entity;

import com.kalec.Items.StartUpCommon;
import com.kalec.entity.projectile.ExplosiveEggEntity;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class StartupCommon {
    public static EntityType<ExplosiveEggEntity> explosiveEggEntity;

    @SubscribeEvent
    public static void onEntityTypeRegistration(RegistryEvent.Register<EntityType<?>> entityTypeRegister) {
        explosiveEggEntity = EntityType.Builder.<ExplosiveEggEntity>create(ExplosiveEggEntity::new, EntityClassification.MISC)
                .size(0.25F,0.25F)
                .build("eggs:explosive_egg_entity");
        explosiveEggEntity.setRegistryName("eggs:explosive_egg_entity");
        entityTypeRegister.getRegistry().register(explosiveEggEntity);
        /*DefaultDispenseItemBehavior explosiveItemBehaviour = new DefaultDispenseItemBehavior() {
            public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().get(DispenserBlock.FACING);
                BlockPos position = source.getBlockPos().offset(direction);
                World world = source.getWorld();
                ExplosiveEggEntity dispenserEntity = new ExplosiveEggEntity(world, position.getX(), position.getY(), position.getZ());
                stack.shrink(1);
                return stack;
            }
        };
        DispenserBlock.registerDispenseBehavior(StartUpCommon.explosiveEggItem, explosiveItemBehaviour);*/
    }
}