package com.legacy.aether.client.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

import com.legacy.aether.entities.hostile.EntityCockatrice;

public class CockatriceModel extends EntityModel<EntityCockatrice>
{

	public Cuboid head, body;

	public Cuboid legs, legs2;

	public Cuboid wings, wings2;

	public Cuboid jaw, neck;

	public Cuboid feather1, feather2, feather3;

	public CockatriceModel()
	{
		this.head = new Cuboid(this, 0, 13);
		this.head.addBox(-2.0F, -4.0F, -6.0F, 4, 4, 8, 0.0F);
		this.head.setRotationPoint(0.0F, (float) (-8 + 16), -4.0F);
		this.jaw = new Cuboid(this, 24, 13);
		this.jaw.addBox(-2.0F, -1.0F, -6.0F, 4, 1, 8, -0.1F);
		this.jaw.setRotationPoint(0.0F, (float) (-8 + 16), -4.0F);
		this.body = new Cuboid(this, 0, 0);
		this.body.addBox(-3.0F, -3.0F, 0.0F, 6, 8, 5, 0.0F);
		this.body.setRotationPoint(0.0F, (float) (0 + 16), 0.0F);
		this.legs = new Cuboid(this, 22, 0);
		this.legs.addBox(-1.0F, -1.0F, -1.0F, 2, 9, 2);
		this.legs.setRotationPoint(-2.0F, (float) (0 + 16), 1.0F);
		this.legs2 = new Cuboid(this, 22, 0);
		this.legs2.addBox(-1.0F, -1.0F, -1.0F, 2, 9, 2);
		this.legs2.setRotationPoint(2.0F, (float) (0 + 16), 1.0F);
		this.wings = new Cuboid(this, 52, 0);
		this.wings.addBox(-1.0F, -0.0F, -1.0F, 1, 8, 4);
		this.wings.setRotationPoint(-3.0F, (float) (16), 2.0F);
		this.wings2 = new Cuboid(this, 52, 0);
		this.wings2.addBox(0.0F, -0.0F, -1.0F, 1, 8, 4);
		this.wings2.setRotationPoint(3.0F, (float) (-4 + 16), 0.0F);
		this.neck = new Cuboid(this, 44, 0);
		this.neck.addBox(-1.0F, -6.0F, -1.0F, 2, 6, 2);
		this.neck.setRotationPoint(0.0F, (float) (-2 + 16), -4.0F);
		this.feather1 = new Cuboid(this, 30, 0);
		this.feather1.addBox(-1.0F, -5.0F, 5.0F, 2, 1, 5, -0.3F);
		this.feather1.setRotationPoint(0.0F, (float) (1 + 16), 1.0F);
		this.feather2 = new Cuboid(this, 30, 0);
		this.feather2.addBox(-1.0F, -5.0F, 5.0F, 2, 1, 5, -0.3F);
		this.feather2.setRotationPoint(0.0F, (float) (1 + 16), 1.0F);
		this.feather3 = new Cuboid(this, 30, 0);
		this.feather3.addBox(-1.0F, -5.0F, 5.0F, 2, 1, 5, -0.3F);
		this.feather3.setRotationPoint(0.0F, (float) (1 + 16), 1.0F);
		this.feather1.rotationPointY += 0.5F;
		this.feather2.rotationPointY += 0.5F;
		this.feather3.rotationPointY += 0.5F;
	}

	@Override
	public void render(EntityCockatrice cockatrice, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		this.head.render(scale);
		this.jaw.render(scale);
		this.body.render(scale);
		this.legs.render(scale);
		this.legs2.render(scale);
		this.wings.render(scale);
		this.wings2.render(scale);
		this.neck.render(scale);
		this.feather1.render(scale);
		this.feather2.render(scale);
		this.feather3.render(scale);
	}

	@Override
	public void setAngles(EntityCockatrice cockatrice, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{
		this.head.pitch = headPitch / 57.29578F;
		this.head.yaw = netHeadYaw / 57.29578F;
		this.jaw.pitch = this.head.pitch;
		this.jaw.yaw = this.head.yaw;
		this.body.pitch = 1.570796F;
		this.legs.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.legs2.pitch = MathHelper.cos((float) (limbSwing * 0.6662F + Math.PI)) * 1.4F * limbSwingAmount;

		if (ageInTicks > 0.001F)
		{
			this.wings.rotationPointZ = -1F;
			this.wings2.rotationPointZ = -1F;
			this.wings.rotationPointY = 12F;
			this.wings2.rotationPointY = 12F;
			this.wings.pitch = 0.0F;
			this.wings2.pitch = 0.0F;
			this.wings.roll = ageInTicks;
			this.wings2.roll = -ageInTicks;
			this.legs.pitch = 0.6F;
			this.legs2.pitch = 0.6F;
		}
		else
		{
			this.wings.rotationPointZ = -3F;
			this.wings2.rotationPointZ = -3F;
			this.wings.rotationPointY = 14F;
			this.wings2.rotationPointY = 14F;
			this.wings.pitch = (float) (Math.PI / 2.0F);
			this.wings2.pitch = (float) (Math.PI / 2.0F);
			this.wings.roll = 0.0F;
			this.wings2.roll = 0.0F;
		}

		this.feather1.yaw = -0.375F;
		this.feather2.yaw = 0.0F;
		this.feather3.yaw = 0.375F;
		this.feather1.pitch = 0.25F;
		this.feather2.pitch = 0.25F;
		this.feather3.pitch = 0.25F;
		this.neck.pitch = 0.0F;
		this.neck.yaw = head.yaw;
		this.jaw.pitch += 0.35F;
	}

}