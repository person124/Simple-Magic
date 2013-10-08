package com.person124.sm.client;

import com.person124.sm.common.CommonProxy;
import com.person124.sm.entity.EntityEarthSage;
import com.person124.sm.entity.EntityLimboSage;
import com.person124.sm.entity.EntityWaterSage;
import com.person124.sm.model.ModelEarthSage;
import com.person124.sm.model.ModelLimboSage;
import com.person124.sm.model.ModelWaterSage;
import com.person124.sm.render.RenderEarthSage;
import com.person124.sm.render.RenderLimboSage;
import com.person124.sm.render.RenderWaterSage;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderInfomation() {
		RenderingRegistry.registerEntityRenderingHandler(EntityEarthSage.class, new RenderEarthSage(new ModelEarthSage(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLimboSage.class, new RenderLimboSage(new ModelLimboSage(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWaterSage.class, new RenderWaterSage(new ModelWaterSage(), 0.5F));
	}

	@Override
	public void registerRenders() {

	}

}
