package com.legacy.aether.client.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;

import com.legacy.aether.entities.hostile.EntityAechorPlant;
import com.mojang.blaze3d.platform.GlStateManager;

public class AechorPlantModel extends EntityModel<EntityAechorPlant>
{

	private Cuboid petal[];

	private Cuboid leaf[];

	private Cuboid stamen[];

	private Cuboid stamen2[];

	private Cuboid thorn[];

	private Cuboid stem;

	private Cuboid head;

	public float sinage;

	public float sinage2;

	public float size;

	public AechorPlantModel()
	{
		this(0.0F);
	}

	public AechorPlantModel(float modelSize)
	{
		this(modelSize, 0.0F);
	}

	public AechorPlantModel(float modelSize, float rotationPointY)
	{
		this.size = 1.0F;
		this.petal = new Cuboid[10];
		this.leaf = new Cuboid[10];
		this.stamen = new Cuboid[3];
		this.stamen2 = new Cuboid[3];
		this.thorn = new Cuboid[4];

		for (int i = 0; i < 10; i++)
		{
			this.petal[i] = new Cuboid(this, 0, 0);

			if (i % 2 == 0)
			{
				this.petal[i] = new Cuboid(this, 29, 3);
				this.petal[i].addBox(-4F, -1F, -12F, 8, 1, 9, modelSize - 0.25F);
				this.petal[i].setRotationPoint(0.0F, 1.0F + rotationPointY, 0.0F);
			}
			else
			{
				this.petal[i].addBox(-4F, -1F, -13F, 8, 1, 10, modelSize - 0.125F);
				this.petal[i].setRotationPoint(0.0F, 1.0F + rotationPointY, 0.0F);
			}

			this.leaf[i] = new Cuboid(this, 38, 13);
			this.leaf[i].addBox(-2F, -1F, -9.5F, 4, 1, 8, modelSize - 0.15F);
			this.leaf[i].setRotationPoint(0.0F, 1.0F + rotationPointY, 0.0F);
		}

		for (int i = 0; i < 3; i++)
		{
			this.stamen[i] = new Cuboid(this, 36, 13);
			this.stamen[i].addBox(0F, -9F, -1.5F, 1, 6, 1, modelSize - 0.25F);
			this.stamen[i].setRotationPoint(0.0F, 1.0F + rotationPointY, 0.0F);
		}

		for (int i = 0; i < 3; i++)
		{
			this.stamen2[i] = new Cuboid(this, 32, 15);
			this.stamen2[i].addBox(0F, -10F, -1.5F, 1, 1, 1, modelSize + 0.125F);
			this.stamen2[i].setRotationPoint(0.0F, 1.0F + rotationPointY, 0.0F);
		}

		this.head = new Cuboid(this, 0, 12);
		this.head.addBox(-3F, -3F, -3F, 6, 2, 6, modelSize + 0.75F);
		this.head.setRotationPoint(0.0F, 1.0F + rotationPointY, 0.0F);
		this.stem = new Cuboid(this, 24, 13);
		this.stem.addBox(-1F, 0F, -1F, 2, 6, 2, modelSize);
		this.stem.setRotationPoint(0.0F, 1.0F + rotationPointY, 0.0F);

		for (int i = 0; i < 4; i++)
		{
			this.thorn[i] = new Cuboid(this, 32, 13);
			this.thorn[i].setRotationPoint(0.0F, 1.0F + rotationPointY, 0.0F);
		}

		this.thorn[0].addBox(-1.75F, 1.25F, -1F, 1, 1, 1, modelSize - 0.25F);
		this.thorn[1].addBox(-1F, 2.25F, 0.75F, 1, 1, 1, modelSize - 0.25F);
		this.thorn[2].addBox(0.75F, 1.25F, 0F, 1, 1, 1, modelSize - 0.25F);
		this.thorn[3].addBox(0F, 2.25F, -1.75F, 1, 1, 1, modelSize - 0.25F);
	}

	@Override
	public void render(EntityAechorPlant aechorPlant, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		GlStateManager.pushMatrix();
		GlStateManager.translatef(0.0F, 1.2F, 0.0F);
		GlStateManager.scalef(this.size, this.size, this.size);

		for (int i = 0; i < 10; i++)
		{
			this.petal[i].render(scale);
			this.leaf[i].render(scale);
		}

		for (int i = 0; i < 3; i++)
		{
			this.stamen[i].render(scale);
			this.stamen2[i].render(scale);
		}

		this.head.render(scale);
		this.stem.render(scale);

		for (int i = 0; i < 4; i++)
		{
			this.thorn[i].render(scale);
		}

		GlStateManager.popMatrix();
	}

	@Override
	public void setAngles(EntityAechorPlant aechorPlant, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{
		this.head.pitch = 0.0F;
		this.head.yaw = headPitch / 57.29578F;
		float boff = this.sinage2;
		this.stem.yaw = head.yaw;
		this.stem.rotationPointY = boff * 0.5F;

		for (int i = 0; i < 10; i++)
		{
			if (i < 3)
			{
				this.stamen[i].pitch = 0.2F + ((float) i / 15F);
				this.stamen[i].yaw = head.yaw + 0.1F;
				this.stamen[i].yaw += ((Math.PI * 2) / (float) 3) * (float) i;
				this.stamen[i].pitch += sinage * 0.4F;
				this.stamen2[i].pitch = 0.2F + ((float) i / 15F);
				this.stamen2[i].yaw = head.yaw + 0.1F;
				this.stamen2[i].yaw += ((Math.PI * 2) / (float) 3) * (float) i;
				this.stamen2[i].pitch += sinage * 0.4F;
				this.stamen[i].rotationPointY = boff + ((sinage) * 2F);
				this.stamen2[i].rotationPointY = boff + ((sinage) * 2F);
			}

			if (i < 4)
			{
				this.thorn[i].yaw = head.yaw;
				this.thorn[i].rotationPointY = boff * 0.5F;
			}

			this.petal[i].pitch = ((i % 2 == 0) ? -0.25F : -0.4125F);
			this.petal[i].pitch += sinage;
			this.petal[i].yaw = head.yaw;
			this.petal[i].yaw += ((Math.PI * 2) / (float) 10) * (float) i;
			this.leaf[i].pitch = ((i % 2 == 0) ? 0.1F : 0.2F);
			this.leaf[i].pitch += sinage * 0.75F;
			this.leaf[i].yaw = (float) (head.yaw + ((Math.PI * 2) / (float) 10 / 2F));
			this.leaf[i].yaw += ((Math.PI * 2) / (float) 10) * (float) i;
			this.petal[i].rotationPointY = boff;
			this.leaf[i].rotationPointY = boff;
		}

		this.head.rotationPointY = boff + ((sinage) * 2F);
	}

}