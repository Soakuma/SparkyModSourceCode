
package net.pinne.sparkymod.init;

import net.pinne.sparkymod.entity.SparkyshotEntity;
import net.pinne.sparkymod.entity.SparkyEntity;
import net.pinne.sparkymod.SparkyModMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SparkyModModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SparkyModMod.MODID);
	public static final RegistryObject<EntityType<SparkyEntity>> SPARKY = register("sparky",
			EntityType.Builder.<SparkyEntity>of(SparkyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SparkyEntity::new)

					.sized(1f, 1.6f));
	public static final RegistryObject<EntityType<SparkyshotEntity>> SPARKYSHOT = register("sparkyshot",
			EntityType.Builder.<SparkyshotEntity>of(SparkyshotEntity::new, MobCategory.MISC).setCustomClientFactory(SparkyshotEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SparkyEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SPARKY.get(), SparkyEntity.createAttributes().build());
	}
}
