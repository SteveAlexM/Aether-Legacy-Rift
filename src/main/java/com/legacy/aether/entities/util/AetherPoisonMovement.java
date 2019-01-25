package com.legacy.aether.entities.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class AetherPoisonMovement
{

	public int ticks = 0;

	public double rotD, motD;

	private LivingEntity entity;

	public AetherPoisonMovement(LivingEntity entity)
	{
		this.entity = entity;
	}

	public void onUpdate()
	{
		int timeUntilHit = this.ticks % 50;

		if (!this.entity.isValid())
		{
			this.ticks = 0;
		}
		else
		{
			if (this.ticks < 0)
			{
				this.ticks++;

				return;
			}

			if (this.ticks == 0)
			{
				return;
			}

			this.distract();

			if (timeUntilHit == 0)
			{
				this.entity.damage(DamageSource.MAGIC, 1.0F);
			}

			this.ticks--;
		}
	}

	public boolean inflictPoison(int ticks)
	{
		if (this.ticks != 0)
		{
			return false;
		}

		this.ticks = ticks;

		return true;
	}

	public boolean applyCure(int ticks)
	{
		if (this.ticks != 0)
		{
			return false;
		}

		this.ticks = ticks;

		return true;
	}

	public void distract()
	{
		double gaussian = this.entity.world.random.nextGaussian();
		double newMotD = 0.1D * gaussian;
		double newRotD = (Math.PI / 4D) * gaussian;

		this.motD = 0.2D * newMotD + (0.8D) * this.motD;
		this.entity.velocityX += this.motD;
		this.entity.velocityZ += this.motD;
		this.rotD = 0.125D * newRotD + (1.0D - 0.125D) * this.rotD;

		this.entity.yaw = (float) ((double) this.entity.yaw + rotD);
		this.entity.pitch = (float) ((double) this.entity.pitch + rotD);
	}

}