
package net.pinne.sparkymod.init;

import net.pinne.sparkymod.SparkyModMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public class SparkyModModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SparkyModMod.MODID);
	public static final RegistryObject<SoundEvent> SPARKY_STEP = REGISTRY.register("sparky_step", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("sparky_mod", "sparky_step")));
	public static final RegistryObject<SoundEvent> SPARKY_CHARGE = REGISTRY.register("sparky_charge", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("sparky_mod", "sparky_charge")));
	public static final RegistryObject<SoundEvent> SPARKY_SHOT = REGISTRY.register("sparky_shot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("sparky_mod", "sparky_shot")));
	public static final RegistryObject<SoundEvent> SPARKY_SUMMON = REGISTRY.register("sparky_summon", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("sparky_mod", "sparky_summon")));
	public static final RegistryObject<SoundEvent> SPARKY_DISCHARGE = REGISTRY.register("sparky_discharge", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("sparky_mod", "sparky_discharge")));
}
