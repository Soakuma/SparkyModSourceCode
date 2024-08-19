
package net.pinne.sparkymod.client.renderer;

import net.pinne.sparkymod.procedures.SparkyDisplayConditionProcedure;
import net.pinne.sparkymod.procedures.SparkyDisplayCondition3Procedure;
import net.pinne.sparkymod.procedures.SparkyDisplayCondition2Procedure;
import net.pinne.sparkymod.entity.SparkyEntity;
import net.pinne.sparkymod.client.model.Modelsparky;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SparkyRenderer extends MobRenderer<SparkyEntity, Modelsparky<SparkyEntity>> {
	public SparkyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsparky(context.bakeLayer(Modelsparky.LAYER_LOCATION)), 1f);
		this.addLayer(new RenderLayer<SparkyEntity, Modelsparky<SparkyEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("sparky_mod:textures/entities/sparky_carge1.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SparkyEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SparkyDisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelsparky(Minecraft.getInstance().getEntityModels().bakeLayer(Modelsparky.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<SparkyEntity, Modelsparky<SparkyEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("sparky_mod:textures/entities/sparky_carge2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SparkyEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SparkyDisplayCondition2Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelsparky(Minecraft.getInstance().getEntityModels().bakeLayer(Modelsparky.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<SparkyEntity, Modelsparky<SparkyEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("sparky_mod:textures/entities/sparky_carge3.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SparkyEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SparkyDisplayCondition3Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelsparky(Minecraft.getInstance().getEntityModels().bakeLayer(Modelsparky.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(SparkyEntity entity) {
		return new ResourceLocation("sparky_mod:textures/entities/sparky.png");
	}
}
