
package net.pinne.sparkymod.entity;

import net.pinne.sparkymod.procedures.SparkyshotWhileProjectileFlyingTickProcedure;
import net.pinne.sparkymod.init.SparkyModModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class SparkyshotEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(Blocks.AIR);

	public SparkyshotEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(SparkyModModEntities.SPARKYSHOT.get(), world);
	}

	public SparkyshotEntity(EntityType<? extends SparkyshotEntity> type, Level world) {
		super(type, world);
	}

	public SparkyshotEntity(EntityType<? extends SparkyshotEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public SparkyshotEntity(EntityType<? extends SparkyshotEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void tick() {
		super.tick();
		SparkyshotWhileProjectileFlyingTickProcedure.execute(this);
		if (this.inGround)
			this.discard();
	}

	public static SparkyshotEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 2f, 20, 0);
	}

	public static SparkyshotEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
		return shoot(world, entity, source, pullingPower * 2f, 20, 0);
	}

	public static SparkyshotEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		SparkyshotEntity entityarrow = new SparkyshotEntity(SparkyModModEntities.SPARKYSHOT.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(true);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("sparky_mod:sparky_shot")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static SparkyshotEntity shoot(LivingEntity entity, LivingEntity target) {
		SparkyshotEntity entityarrow = new SparkyshotEntity(SparkyModModEntities.SPARKYSHOT.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 2f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(20);
		entityarrow.setKnockback(0);
		entityarrow.setCritArrow(true);
		entity.level().addFreshEntity(entityarrow);
		entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("sparky_mod:sparky_shot")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
