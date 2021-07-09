package com.kalec.entity.projectile;

import com.kalec.Items.ExplosiveEggItem;
import com.kalec.Items.StartUpCommon;
import com.kalec.entity.StartupCommon;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.Collection;

public class ExplosiveEggEntity extends ProjectileItemEntity {

    public ExplosiveEggEntity(EntityType<ExplosiveEggEntity> entityType, World world) {
        super(entityType, world);
    }
    public ExplosiveEggEntity(World world, LivingEntity thrower) {
        super(StartupCommon.explosiveEggEntity, thrower, world);
    }
    public ExplosiveEggEntity(World world, double x, double y, double z) {
        super(StartupCommon.explosiveEggEntity, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return StartUpCommon.explosiveEggItem;
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            double d0 = 0.08D;

            for(int i = 0; i < 8; ++i) {
                this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getItem()), this.getPosX(), this.getPosY(), this.getPosZ(), ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D);
            }
        }
    }
    protected void onEntityHit(EntityRayTraceResult result) {
        super.onEntityHit(result);
        result.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), 0.0F);
    }

    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if(!this.world.isRemote) {
            Explosion.Mode explosionMode = Explosion.Mode.NONE;
            float explosionRadius = 1.0F;
            this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), explosionRadius, explosionMode);
            this.world.setEntityState(this, (byte) 3);
            this.remove();
        }
    }
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
