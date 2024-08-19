
package net.pinne.sparkymod.init;

import net.pinne.sparkymod.client.renderer.SparkyshotRenderer;
import net.pinne.sparkymod.client.renderer.SparkyRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SparkyModModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SparkyModModEntities.SPARKY.get(), SparkyRenderer::new);
		event.registerEntityRenderer(SparkyModModEntities.SPARKYSHOT.get(), SparkyshotRenderer::new);
	}
}
