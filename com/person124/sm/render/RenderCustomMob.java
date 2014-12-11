package com.person124.sm.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.person124.sm.entity.EntityEarthSage;
import com.person124.sm.entity.EntityFireSage;
import com.person124.sm.entity.EntityLimboSage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCustomMob extends RenderLiving {
	public RenderCustomMob(ModelBase model, float shadowSize) {
		super(model, shadowSize);
	}
	
	public void renderEntity(EntityLiving entity, double x, double y, double z, float pitch, float yaw) {
		super.doRender(entity, x, y, z, pitch, yaw);
	}

	public void doRenderLiving(EntityLiving entity, double x, double y, double z, float pitch, float yaw) {
		this.renderEntity(entity, x, y, z, pitch, yaw);
	}

	public void doRender(Entity entity, double x, double y, double z, float pitch, float yaw) {
		this.renderEntity((EntityLiving) entity, x, y, z, pitch, yaw);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity e) {
		if (e instanceof EntityEarthSage) return new ResourceLocation("simplemagic", "textures/mob/earthsage.png");
		else if (e instanceof EntityLimboSage) return new ResourceLocation("simplemagic", "textures/mob/limbosage.png");
		else if (e instanceof EntityFireSage) return new ResourceLocation("simplemagic", "textures/mob/firesage.png");
		return null;
	}
}
