
package net.pinne.sparkymod.init;

import net.pinne.sparkymod.item.SparkySpawnItemItem;
import net.pinne.sparkymod.item.BottleOfElixirItem;
import net.pinne.sparkymod.SparkyModMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class SparkyModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SparkyModMod.MODID);
	public static final RegistryObject<Item> ELIXIR_COLLECTOR = block(SparkyModModBlocks.ELIXIR_COLLECTOR);
	public static final RegistryObject<Item> BOTTLE_OF_ELIXIR = REGISTRY.register("bottle_of_elixir", () -> new BottleOfElixirItem());
	public static final RegistryObject<Item> SPARKY_SPAWN_ITEM = REGISTRY.register("sparky_spawn_item", () -> new SparkySpawnItemItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
