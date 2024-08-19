
package net.pinne.sparkymod.init;

import net.pinne.sparkymod.world.inventory.ElixirCollectorGUIMenu;
import net.pinne.sparkymod.SparkyModMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class SparkyModModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SparkyModMod.MODID);
	public static final RegistryObject<MenuType<ElixirCollectorGUIMenu>> ELIXIR_COLLECTOR_GUI = REGISTRY.register("elixir_collector_gui", () -> IForgeMenuType.create(ElixirCollectorGUIMenu::new));
}
