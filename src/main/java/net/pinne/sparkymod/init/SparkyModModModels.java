
package net.pinne.sparkymod.init;

import net.pinne.sparkymod.client.model.Modelsparky_shot;
import net.pinne.sparkymod.client.model.Modelsparky;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SparkyModModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelsparky.LAYER_LOCATION, Modelsparky::createBodyLayer);
		event.registerLayerDefinition(Modelsparky_shot.LAYER_LOCATION, Modelsparky_shot::createBodyLayer);
	}
}
