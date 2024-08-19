
package net.pinne.sparkymod.init;

import net.pinne.sparkymod.block.ElixirCollectorBlock;
import net.pinne.sparkymod.SparkyModMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class SparkyModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SparkyModMod.MODID);
	public static final RegistryObject<Block> ELIXIR_COLLECTOR = REGISTRY.register("elixir_collector", () -> new ElixirCollectorBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
