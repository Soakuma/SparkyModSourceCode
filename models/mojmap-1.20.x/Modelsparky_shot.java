// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelsparky_shot<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "sparky_shot"), "main");
	private final ModelPart tail;
	private final ModelPart bb_main;

	public Modelsparky_shot(ModelPart root) {
		this.tail = root.getChild("tail");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tail = partdefinition.addOrReplaceChild("tail",
				CubeListBuilder.create().texOffs(18, 0)
						.addBox(3.12F, -3.06F, -3.04F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 25)
						.addBox(3.12F, -1.06F, -3.04F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 20)
						.addBox(3.12F, -2.06F, -0.04F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 21)
						.addBox(3.12F, -1.06F, 0.96F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(14, 13)
						.addBox(3.12F, 0.94F, -3.04F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.addBox(3.12F, 1.94F, -0.04F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 11)
						.addBox(-2.88F, -3.06F, -3.04F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(18, 0)
						.addBox(-2.88F, -2.06F, -0.04F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(18, 3)
						.addBox(-2.88F, -0.06F, 0.96F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.88F, -1.06F, 0.96F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 17)
						.addBox(-2.88F, -1.06F, -3.04F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 13)
						.addBox(-2.88F, 0.94F, -3.04F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(2, 0)
						.addBox(-2.88F, 1.94F, -0.04F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.12F, 20.06F, 6.04F));

		PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 19)
						.addBox(0.0F, -0.25F, 0.75F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 18)
						.addBox(0.0F, 1.75F, -0.25F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 19)
						.addBox(0.0F, -2.25F, -0.25F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(14, 11)
						.addBox(0.0F, -3.25F, -3.25F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(20, 24)
						.addBox(0.0F, -1.25F, -3.25F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(14, 9)
						.addBox(0.0F, 0.75F, -3.25F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.37F, 2.94F, 0.21F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r2 = tail.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 3)
						.addBox(0.0F, -3.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 17)
						.addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(6, 15)
						.addBox(0.0F, -2.0F, -4.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.88F, -3.06F, 0.96F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r3 = tail.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -2.0F, 0.0F, 2.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.12F, -3.06F, -1.04F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r4 = tail.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(0.0F, 2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 9)
						.addBox(0.0F, 1.0F, -4.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.12F, -3.06F, 0.96F, 0.0F, 0.0F, 1.5708F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-3.0F, -7.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(14, 13)
						.addBox(-2.0F, -8.0F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(10, 20)
						.addBox(-4.0F, -7.0F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 19)
						.addBox(3.0F, -7.0F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 12)
						.addBox(-2.0F, -1.0F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(24, 0)
						.addBox(-2.0F, -7.0F, -4.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 31)
						.addBox(2.0F, -6.0F, -4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 30)
						.addBox(-3.0F, -6.0F, -4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(19, 30)
						.addBox(3.0F, -6.0F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(15, 30)
						.addBox(3.0F, -6.0F, 2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(26, 23)
						.addBox(2.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(26, 7)
						.addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(11, 30)
						.addBox(-4.0F, -6.0F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(7, 30)
						.addBox(-4.0F, -6.0F, 2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 8)
						.addBox(-3.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(20, 20)
						.addBox(-2.0F, -7.0F, 3.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 28)
						.addBox(2.0F, -6.0F, 3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 13)
						.addBox(-3.0F, -6.0F, 3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, 1.75F, -0.25F, 0.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.25F, -1.0F, 6.25F, 0.0F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bb_main.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.bb_main.xRot = headPitch / (180F / (float) Math.PI);
		this.tail.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.tail.xRot = headPitch / (180F / (float) Math.PI);
	}
}