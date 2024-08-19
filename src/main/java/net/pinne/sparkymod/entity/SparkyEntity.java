
package net.pinne.sparkymod.entity;

import net.pinne.sparkymod.init.SparkyModModEntities;
import net.pinne.sparkymod.entity.SparkyEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.LightningBolt;

import java.util.UUID;


public class SparkyEntity extends PathfinderMob implements RangedAttackMob {
    public static final EntityDataAccessor<Integer> DATA_charge = SynchedEntityData.defineId(SparkyEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DATA_IS_FRIENDLY = SynchedEntityData.defineId(SparkyEntity.class, EntityDataSerializers.BOOLEAN);
    private static final int MAX_CHARGE = 4;
    private int chargeTicks = 0;
    private Player owner;
    private boolean wasStruck = false;
    private int lightningCooldown = 0;

    public SparkyEntity(EntityType<? extends SparkyEntity> type, Level world) {
    	super(type, world);
	    setMaxUpStep(0.6f);
	    xpReward = 5;
	    setNoAi(false);
	    setPersistenceRequired();
	}
	public SparkyEntity(PlayMessages.SpawnEntity packet, Level world) {
    	this(SparkyModModEntities.SPARKY.get(), world);
	}

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_charge, 0);
        this.entityData.define(DATA_IS_FRIENDLY, false);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SparkyRangedAttackGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && !(this.mob.getTarget() instanceof SparkyEntity);
            }
        });
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, (float) 11));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, false, false, 
            (entity) -> {
                if (entity instanceof SparkyEntity) return false;
                if (entity instanceof Player) return !this.isFriendly();
                return entity instanceof Monster;
            }));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("sparky_mod:sparky_step")), 0.15f, 1);
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Datacharge", this.entityData.get(DATA_charge));
        compound.putBoolean("IsFriendly", this.isFriendly());
        if (this.owner != null) {
            compound.putUUID("OwnerUUID", this.owner.getUUID());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Datacharge"))
            this.entityData.set(DATA_charge, compound.getInt("Datacharge"));
        if (compound.contains("IsFriendly"))
            this.setFriendly(compound.getBoolean("IsFriendly"));
        if (compound.hasUUID("OwnerUUID")) {
            UUID ownerUUID = compound.getUUID("OwnerUUID");
            for (Player player : this.level().players()) {
                if (player.getUUID().equals(ownerUUID)) {
                    this.setOwner(player);
                    break;
                }
            }
        }
    }

    @Override
	public void tick() {
	    super.tick();
	    if (!this.level().isClientSide()) {
	        LivingEntity target = this.getTarget();
	        if (target != null && !(target instanceof SparkyEntity)) {
	            chargeTicks++;
	            if (chargeTicks >= 20) { // 1초마다
	                int currentCharge = this.entityData.get(DATA_charge);
	                if (currentCharge < MAX_CHARGE) {
	                    this.entityData.set(DATA_charge, currentCharge + 1);
	                    
	                    if (currentCharge < 3) {
	                        float pitch = 1.0f + (currentCharge * 0.2f);
	                        this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("sparky_mod:sparky_charge")), 1.0f, pitch);
	                    }
	                }
	                chargeTicks = 0;
	            }
	            
	            if (this.entityData.get(DATA_charge) >= MAX_CHARGE) {
	                performRangedAttack(target, 1.0f);
	            }
	        } else {
	            chargeTicks = 0;
	            this.entityData.set(DATA_charge, 0);
	        }
	
	        if (lightningCooldown > 0) {
	            lightningCooldown--;
	        }
	    }
	}
	
	private boolean isStruckByLightning() {
        return this.getRemainingFireTicks() > 0 || (this.level().canSeeSky(this.blockPosition()) && this.level().isThundering() && this.random.nextInt(1000) == 0);
    }
	
    @Override
	public void thunderHit(ServerLevel serverWorld, LightningBolt lightning) {
	    super.thunderHit(serverWorld, lightning);
	    if (this.entityData.get(DATA_charge) > 0 && lightningCooldown == 0) {
	        this.entityData.set(DATA_charge, 0);
	        this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("sparky_mod:sparky_discharge")), 1.0f, 1.0f);
	        lightningCooldown = 100;
	    }
	}

    private boolean isInLightning() {
        return this.level().isThundering() && this.level().canSeeSky(this.blockPosition());
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (this.entityData.get(DATA_charge) >= MAX_CHARGE) {
            SparkyshotEntity.shoot(this, target);
            this.entityData.set(DATA_charge, 0);
        }
    }

    public boolean isFriendly() {
        return this.entityData.get(DATA_IS_FRIENDLY);
    }

    public void setFriendly(boolean friendly) {
        this.entityData.set(DATA_IS_FRIENDLY, friendly);
    }

    public void setOwner(Player player) {
        this.owner = player;
    }

    public Player getOwner() {
        return this.owner;
    }

    public static void init() {
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
        builder = builder.add(Attributes.MAX_HEALTH, 40);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.3);
        return builder;
    }

    public static SparkyEntity spawnFriendlySparky(Level world, BlockPos pos, Player player) {
        SparkyEntity sparky = SparkyModModEntities.SPARKY.get().spawn((ServerLevel)world, pos, MobSpawnType.SPAWN_EGG);
        if (sparky != null) {
            sparky.setFriendly(true);
            sparky.setOwner(player);
        }
        return sparky;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    private class SparkyRangedAttackGoal extends Goal {
        private final SparkyEntity sparky;
        private LivingEntity target;

        public SparkyRangedAttackGoal(SparkyEntity sparky) {
            this.sparky = sparky;
        }

        @Override
        public boolean canUse() {
            LivingEntity livingentity = this.sparky.getTarget();
            if (livingentity != null && livingentity.isAlive() && !(livingentity instanceof SparkyEntity)) {
                this.target = livingentity;
                return true;
            }
            return false;
        }

        @Override
        public void tick() {
            if (this.target == null || !this.target.isAlive() || this.target instanceof SparkyEntity) {
                return;
            }

            this.sparky.getLookControl().setLookAt(this.target, 30.0F, 30.0F);

            double distance = this.sparky.distanceToSqr(this.target);
            if (distance <= 11 * 11) {
                this.sparky.getNavigation().stop();
            } else {
                this.sparky.getNavigation().moveTo(this.target, 1.0);
            }
        }
    }
}