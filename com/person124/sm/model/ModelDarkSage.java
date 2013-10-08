package com.person124.sm.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDarkSage extends ModelBase {

  ModelRenderer botblock;
  ModelRenderer leg1;
  ModelRenderer leg2;
  ModelRenderer leg3;
  ModelRenderer leg4;
  ModelRenderer spincube;
  ModelRenderer topblock;
  
  public ModelDarkSage() {
    textureWidth = 64;
    textureHeight = 32;
    
    botblock = new ModelRenderer(8, 9);
    botblock.addBox(-4F, 0F, -4F, 8, 1, 8);
    botblock.setPosition(0F, 1F, 0F);

    leg1 = new ModelRenderer(0, 0);
    leg1.addBox(-1F, 0F, -8F, 2, 16, 2);
    leg1.setPosition(0F, 1F, 0F);

    leg2 = new ModelRenderer(0, 0);
    leg2.addBox(6F, 0F, -1F, 2, 16, 2);
    leg2.setPosition(0F, 1F, 0F);

    leg3 = new ModelRenderer(0, 0);
    leg3.addBox(-8F, 0F, -1F, 2, 16, 2);
    leg3.setPosition(0F, 1F, 0F);

    leg4 = new ModelRenderer(0, 0);
    leg4.addBox(-1F, 0F, 6F, 2, 16, 2);
    leg4.setPosition(0F, 1F, 0F);

    spincube = new ModelRenderer(8, 0);
    spincube.addBox(-1F, -1F, -1F, 2, 2, 2);
    spincube.setPosition(0F, 9F, 0F);

    topblock = new ModelRenderer(8, 9);
    topblock.addBox(-4F, 0F, -4F, 8, 1, 8);
    topblock.setPosition(0F, 17F, 0F);
  
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		botblock.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    spincube.render(f5);
    topblock.render(f5);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
		
		topBlock.rotateAngleY += 0.02F;
		botblock.rotateAngleY += 0.02F;
		
		leg1.rotateAngleY -= 0.03F;
		leg2.rotateAngleY -= 0.03F;
		leg3.rotateAngleY -= 0.03F;
		leg4.rotateAngleY -= 0.03F;
		
		spincube.rotateAngleX += 0.01F;
		spincube.rotateAngleY += 0.01F;
		spincube.rotateAngleZ += 0.01F;
	}

}
