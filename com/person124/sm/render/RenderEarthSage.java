package com.person124.sm.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.person124.sm.entity.EntityEarthSage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEarthSage extends RenderLiving {
	
	public RenderEarthSage(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	public void renderEntityEarthSage(EntityEarthSage par1EntityEntityEarthSage, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(par1EntityEntityEarthSage, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.renderEntityEarthSage((EntityEarthSage) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderEntityEarthSage((EntityEarthSage) par1Entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return new ResourceLocation("simplemagic", "textures/mob/earthsage.png");
	}

}
