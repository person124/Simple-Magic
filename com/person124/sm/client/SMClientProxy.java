package com.person124.sm.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.person124.sm.common.SMCommonProxy;
import com.person124.sm.entity.EntityEarthSage;
import com.person124.sm.entity.EntityFireSage;
import com.person124.sm.entity.EntityLimboSage;
import com.person124.sm.model.ModelEarthSage;
import com.person124.sm.model.ModelFireSage;
import com.person124.sm.model.ModelLimboSage;
import com.person124.sm.render.RenderCustomMob;

public class SMClientProxy extends SMCommonProxy {
	
	@Override
	public void registerRenderers() {
		
	}
	
	@Override
	public void registerRenderInfomation() {
		RenderManager rm = Minecraft.getMinecraft().getRenderManager();
		
		RenderingRegistry.registerEntityRenderingHandler(EntityEarthSage.class, new RenderCustomMob(rm, new ModelEarthSage(), 0.65F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLimboSage.class, new RenderCustomMob(rm, new ModelLimboSage(), 0.25F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireSage.class, new RenderCustomMob(rm, new ModelFireSage(), 0.5F));
	}
}
