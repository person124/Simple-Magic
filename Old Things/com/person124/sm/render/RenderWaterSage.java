package com.person124.sm.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.person124.sm.entity.EntityWaterSage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWaterSage extends RenderLiving {
	public RenderWaterSage(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	public void renderEntityWaterSage(EntityWaterSage par1EntityEntityWaterSage, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(par1EntityEntityWaterSage, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.renderEntityWaterSage((EntityWaterSage) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderEntityWaterSage((EntityWaterSage) par1Entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		ResourceLocation res = new ResourceLocation("simplemagic", "textures/entity/water_sage.png");
		return res;
	}
}
