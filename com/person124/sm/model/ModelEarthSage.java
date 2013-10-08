package com.person124.sm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelEarthSage extends ModelBase {
	// fields
	ModelRenderer head;
	ModelRenderer horn1;
	ModelRenderer horn2;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer spincube;
	private boolean isSneak;

	public ModelEarthSage() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		horn1 = new ModelRenderer(this, 32, 0);
		horn1.addBox(4F, -12F, -1F, 2, 5, 2);
		horn1.setRotationPoint(0F, 0F, 0F);
		horn1.setTextureSize(64, 32);
		horn1.mirror = true;
		setRotation(horn1, 0F, 0F, 0F);
		horn2 = new ModelRenderer(this, 32, 0);
		horn2.addBox(-6F, -12F, -1F, 2, 5, 2);
		horn2.setRotationPoint(0F, 0F, 0F);
		horn2.setTextureSize(64, 32);
		horn2.mirror = true;
		setRotation(horn2, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 16);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 40, 16);
		rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
		rightarm.setRotationPoint(-5F, 2F, 0F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 40, 16);
		leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
		leftarm.setRotationPoint(5F, 2F, 0F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		spincube = new ModelRenderer(this, 40, 0);
		spincube.addBox(-1F, -1F, -1F, 2, 2, 2);
		spincube.setRotationPoint(0F, -13F, 0F);
		spincube.setTextureSize(64, 32);
		spincube.mirror = true;
		setRotation(spincube, 0.7063936F, -0.5948578F, 0.4833219F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		horn1.render(f5);
		horn2.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
		spincube.render(f5);
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
		this.horn1.rotateAngleY = this.head.rotateAngleY;
		this.horn1.rotateAngleX = this.head.rotateAngleX;
		this.horn2.rotateAngleY = this.head.rotateAngleY;
		this.horn2.rotateAngleX = this.head.rotateAngleX;
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 2.0F * par2 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 1.4F * par2;
		this.rightleg.rotateAngleY = 0.0F;
		this.leftleg.rotateAngleY = 0.0F;

		if (this.isRiding) {
			this.rightarm.rotateAngleX += -((float) Math.PI / 5F);
			this.leftarm.rotateAngleX += -((float) Math.PI / 5F);
			this.rightleg.rotateAngleX = -((float) Math.PI * 2F / 5F);
			this.leftleg.rotateAngleX = -((float) Math.PI * 2F / 5F);
			this.rightleg.rotateAngleY = ((float) Math.PI / 10F);
			this.leftleg.rotateAngleY = -((float) Math.PI / 10F);
		}

		this.rightarm.rotateAngleY = 0.0F;
		this.leftarm.rotateAngleY = 0.0F;
		float var8;
		float var9;

		if (this.onGround > -9990.0F) {
			var8 = this.onGround;
			this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(var8) * (float) Math.PI * 2.0F) * 0.2F;
			this.rightarm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
			this.rightarm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
			this.leftarm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
			this.leftarm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
			this.rightarm.rotateAngleY += this.body.rotateAngleY;
			this.leftarm.rotateAngleY += this.body.rotateAngleY;
			this.leftarm.rotateAngleX += this.body.rotateAngleY;
			var8 = 1.0F - this.onGround;
			var8 *= var8;
			var8 *= var8;
			var8 = 1.0F - var8;
			var9 = MathHelper.sin(var8 * (float) Math.PI);
			float var10 = MathHelper.sin(this.onGround * (float) Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
			this.rightarm.rotateAngleX = (float) ((double) this.rightarm.rotateAngleX - ((double) var9 * 1.2D + (double) var10));
			this.rightarm.rotateAngleY += this.body.rotateAngleY * 2.0F;
			this.rightarm.rotateAngleZ = MathHelper.sin(this.onGround * (float) Math.PI) * -0.4F;
			this.spincube.rotateAngleX += 0.01F;
			this.spincube.rotateAngleY += 0.01F;
			this.spincube.rotateAngleZ += 0.01F;
		}

		if (this.isSneak) {
			this.body.rotateAngleX = 0.5F;
			this.rightarm.rotateAngleX += 0.4F;
			this.leftarm.rotateAngleX += 0.4F;
			this.rightleg.rotationPointZ = 4.0F;
			this.leftleg.rotationPointZ = 4.0F;
			this.rightleg.rotationPointY = 9.0F;
			this.leftleg.rotationPointY = 9.0F;
			this.head.rotationPointY = 1.0F;
			this.horn1.rotationPointY = 1.0F;
			this.horn2.rotationPointY = 1.0F;
		} else {
			this.body.rotateAngleX = 0.0F;
			this.rightleg.rotationPointZ = 0.1F;
			this.leftleg.rotationPointZ = 0.1F;
			this.rightleg.rotationPointY = 12.0F;
			this.leftleg.rotationPointY = 12.0F;
			this.head.rotationPointY = 0.0F;
			this.horn1.rotationPointY = 0.0F;
			this.horn2.rotationPointY = 0.0F;
		}

		this.rightarm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
		this.leftarm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
		this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
		this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;

	}

}
