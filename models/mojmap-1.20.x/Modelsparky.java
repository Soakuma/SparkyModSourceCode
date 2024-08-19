// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelsparky<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "sparky"), "main");
	private final ModelPart bb_main;

	public Modelsparky(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(50, 25).addBox(-1.0F, -7.0F, 1.0F, 2.0F, 4.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.6029F, -12.0F, -13.6029F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(50, 33)
						.addBox(-1.0F, -7.0F, 1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 21)
						.addBox(-1.0F, -4.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 27)
						.addBox(-1.0F, -8.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(50, 79)
						.addBox(-2.0F, -5.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.3971F, -12.0F, -13.6029F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(34, 21).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 8.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.3971F, -16.0F, -9.6029F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(50, 33)
						.addBox(-1.0F, -6.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(62, 35)
						.addBox(-1.0F, -14.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.3971F, -8.0F, -9.6029F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 45).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 8.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.6029F, -16.0F, -9.6029F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(50, 54)
						.addBox(-1.0F, -7.0F, -5.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(62, 0)
						.addBox(-1.0F, -19.0F, -5.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.6029F, -5.0F, -5.6029F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 12.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.6029F, -16.0F, -5.6029F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r8 = bb_main.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 12.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.3971F, -16.0F, -5.6029F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r9 = bb_main.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(42, 21).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.3971F, -16.0F, -8.6029F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r10 = bb_main.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(0, 73).addBox(-2.0F, -5.0F, -4.0F, 3.0F, 8.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.3971F, -16.0F, -5.6029F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r11 = bb_main.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(0, 91).addBox(-1.0F, -2.0F, -11.0F, 2.0F, 2.0F, 22.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.3971F, -2.5F, 6.8971F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r12 = bb_main.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(74, 33).addBox(-3.5F, -3.5F, -1.0F, 7.0F, 7.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.3971F, -3.5F, 6.8971F, -1.5708F, -0.7854F, 1.5708F));

		PartDefinition cube_r13 = bb_main.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(77, 66).addBox(-3.5F, -3.5F, -1.0F, 7.0F, 7.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.3971F, -3.5F, 6.8971F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r14 = bb_main.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(78, 0).addBox(-3.5F, -3.5F, -1.0F, 7.0F, 7.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.6029F, -3.5F, 6.8971F, -1.5708F, -0.7854F, 1.5708F));

		PartDefinition cube_r15 = bb_main.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(78, 14).addBox(-3.5F, -3.5F, -1.0F, 7.0F, 7.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.6029F, -3.5F, 6.8971F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r16 = bb_main.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(18, 45).addBox(-1.0F, -6.0F, -5.0F, 1.0F, 4.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.3971F, -13.0F, 11.3971F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r17 = bb_main.addOrReplaceChild("cube_r17",
				CubeListBuilder.create().texOffs(50, 21)
						.addBox(-6.0F, -2.0F, -8.0F, 9.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 21)
						.addBox(-7.0F, -14.0F, -9.0F, 11.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-16.0F, 0.0F, -11.0F, 23.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.3971F, -9.0F, 4.3971F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r18 = bb_main.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(0, 45).addBox(-7.0F, -14.0F, -10.0F, 2.0F, 14.0F, 14.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.3971F, -10.0F, 15.3971F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r19 = bb_main.addOrReplaceChild("cube_r19",
				CubeListBuilder.create().texOffs(32, 54).addBox(-7.0F, -14.0F, -10.0F, 2.0F, 14.0F, 14.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.3971F, -10.0F, 2.3971F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r20 = bb_main.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(0, 91).addBox(-1.0F, -2.0F, -11.0F, 2.0F, 2.0F, 22.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.3971F, -2.5F, -7.1029F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r21 = bb_main.addOrReplaceChild("cube_r21",
				CubeListBuilder.create().texOffs(22, 82).addBox(-3.5F, -3.5F, -1.0F, 7.0F, 7.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.3971F, -3.5F, -7.1029F, -1.5708F, -0.7854F, 1.5708F));

		PartDefinition cube_r22 = bb_main.addOrReplaceChild("cube_r22",
				CubeListBuilder.create().texOffs(79, 45).addBox(-3.5F, -3.5F, -1.0F, 7.0F, 7.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.3971F, -3.5F, -7.1029F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r23 = bb_main.addOrReplaceChild("cube_r23",
				CubeListBuilder.create().texOffs(40, 82).addBox(-3.5F, -3.5F, -1.0F, 7.0F, 7.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.6029F, -3.5F, -7.1029F, -1.5708F, -0.7854F, 1.5708F));

		PartDefinition cube_r24 = bb_main.addOrReplaceChild("cube_r24",
				CubeListBuilder.create().texOffs(84, 83).addBox(-3.5F, -3.5F, -1.0F, 7.0F, 7.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.6029F, -3.5F, -7.1029F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r25 = bb_main.addOrReplaceChild("cube_r25",
				CubeListBuilder.create().texOffs(66, 45).addBox(-1.0F, -4.0F, -4.5F, 2.0F, 8.0F, 9.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.1029F, -7.0F, -12.6029F, -2.3908F, -1.1965F, 2.3574F));

		PartDefinition cube_r26 = bb_main.addOrReplaceChild("cube_r26",
				CubeListBuilder.create().texOffs(64, 68).addBox(-1.0F, -4.0F, -4.5F, 2.0F, 8.0F, 9.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.8971F, -7.0F, -12.6029F, -0.7508F, -1.1965F, 0.7842F));

		PartDefinition cube_r27 = bb_main.addOrReplaceChild("cube_r27",
				CubeListBuilder.create().texOffs(28, 27).addBox(-1.0F, -4.5F, -9.0F, 2.0F, 9.0F, 18.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.3971F, -7.0F, 12.3971F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}