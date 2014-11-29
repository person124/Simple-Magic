package com.person124.sm.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.person124.sm.entity.EntityLimboSage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLimboSage extends RenderLiving {
	
	public RenderLimboSage(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	public void renderEntityLimboSage(EntityLimboSage par1EntityEntityLimboSage, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(par1EntityEntityLimboSage, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.renderEntityLimboSage((EntityLimboSage) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderEntityLimboSage((EntityLimboSage) par1Entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return new ResourceLocation("simplemagic:/textures/mob/limbosage.png");
	}

}
