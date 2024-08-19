
package net.pinne.sparkymod.init;

import net.pinne.sparkymod.block.entity.ElixirCollectorBlockEntity;
import net.pinne.sparkymod.SparkyModMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class SparkyModModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SparkyModMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ELIXIR_COLLECTOR = register("elixir_collector", SparkyModModBlocks.ELIXIR_COLLECTOR, ElixirCollectorBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
