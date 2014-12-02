package com.person124.sm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLimboSage extends ModelBase {
	// fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	private boolean isSneak;

	public ModelLimboSage() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 16);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 0, 16);
		rightarm.addBox(-2F, -2F, -2F, 4, 4, 4);
		rightarm.setRotationPoint(-7F, 2F, 0F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, 0.7063936F, -0.5948578F, 0.4833219F);
		leftarm = new ModelRenderer(this, 0, 16);
		leftarm.addBox(-2F, -2F, -2F, 4, 4, 4);
		leftarm.setRotationPoint(7F, 2F, 0F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, 0.7063936F, -0.5948578F, 0.4833219F);
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-2F, -2F, -2F, 4, 4, 4);
		rightleg.setRotationPoint(-4F, 15F, 0F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0.7063936F, -0.5948578F, 0.4833219F);
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-1F, -2F, -2F, 4, 4, 4);
		leftleg.setRotationPoint(2F, 15F, 0F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0.7063936F, -0.5948578F, 0.4833219F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);

		this.head.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.head.rotateAngleX = par5 / (180F / (float) Math.PI);

		float var8;

		if (this.onGround > -9990.0F) {
			var8 = this.onGround;
			this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(var8) * (float) Math.PI * 2.0F) * 0.2F;
			var8 = 1.0F - this.onGround;
			var8 *= var8;
			var8 *= var8;
			var8 = 1.0F - var8;

			this.leftarm.rotateAngleX += 0.01F;
			this.leftarm.rotateAngleY += 0.01F;
			this.leftarm.rotateAngleZ += 0.01F;
			this.rightarm.rotateAngleX += 0.01F;
			this.rightarm.rotateAngleY += 0.01F;
			this.rightarm.rotateAngleZ += 0.01F;
			this.leftleg.rotateAngleX += 0.01F;
			this.leftleg.rotateAngleY += 0.01F;
			this.leftleg.rotateAngleZ += 0.01F;
			this.rightleg.rotateAngleX += 0.01F;
			this.rightleg.rotateAngleY += 0.01F;
			this.rightleg.rotateAngleZ += 0.01F;
		}

		if (this.isSneak) {
			this.body.rotateAngleX = 0.5F;
			this.head.rotationPointY = 1.0F;
		} else {
			this.body.rotateAngleX = 0.0F;
			this.head.rotationPointY = 0.0F;
		}

	}
}
