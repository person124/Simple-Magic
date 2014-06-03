package com.person124.sm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWaterSage extends ModelBase {
	// fields
	ModelRenderer head;
	ModelRenderer spincube;
	ModelRenderer head2;
	ModelRenderer head3;
	ModelRenderer head4;
	private boolean isSneak;

	public ModelWaterSage() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 16F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		spincube = new ModelRenderer(this, 32, 0);
		spincube.addBox(-2F, -2F, -2F, 4, 4, 4);
		spincube.setRotationPoint(0F, 20F, 0F);
		spincube.setTextureSize(64, 32);
		spincube.mirror = true;
		setRotation(spincube, 0F, 0F, 0F);
		head2 = new ModelRenderer(this, 0, 16);
		head2.addBox(-3F, -14F, -3F, 6, 6, 6);
		head2.setRotationPoint(0F, 16F, 0F);
		head2.setTextureSize(64, 32);
		head2.mirror = true;
		setRotation(head2, 0F, 0F, 0F);
		head3 = new ModelRenderer(this, 36, 8);
		head3.addBox(-2F, -18F, -2F, 4, 4, 4);
		head3.setRotationPoint(0F, 16F, 0F);
		head3.setTextureSize(64, 32);
		head3.mirror = true;
		setRotation(head3, 0F, 0F, 0F);
		head4 = new ModelRenderer(this, 28, 18);
		head4.addBox(-1F, -20F, -1F, 2, 2, 2);
		head4.setRotationPoint(0F, 16F, 0F);
		head4.setTextureSize(64, 32);
		head4.mirror = true;
		setRotation(head4, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		spincube.render(f5);
		head2.render(f5);
		head3.render(f5);
		head4.render(f5);
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
		
		this.head2.rotateAngleX = this.head.rotateAngleX;
		this.head2.rotateAngleY = this.head.rotateAngleY;
		this.head3.rotateAngleX = this.head.rotateAngleX;
		this.head3.rotateAngleY = this.head.rotateAngleY;
		this.head4.rotateAngleX = this.head.rotateAngleX;
		this.head4.rotateAngleY = this.head.rotateAngleY;
		
		float var8;
		float var9;
		
		if (this.onGround > -9990.0F) {
			var8 = this.onGround;
			var8 = 1.0F - this.onGround;
			var8 *= var8;
			var8 *= var8;
			var8 = 1.0F - var8;
			var9 = MathHelper.sin(var8 * (float) Math.PI);
			float var10 = MathHelper.sin(this.onGround * (float) Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
			this.spincube.rotateAngleX += 0.01F;
			this.spincube.rotateAngleY += 0.01F;
			this.spincube.rotateAngleZ += 0.01F;
		}
		
		if (this.isSneak) {
			this.head.rotationPointY = 1.0F;
		} else {
			this.head.rotationPointY = 0.0F;
		}
	}

}
