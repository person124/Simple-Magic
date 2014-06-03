package com.person124.sm.client;

import com.person124.sm.common.SMCommonProxy;
import com.person124.sm.entity.EntityEarthSage;
import com.person124.sm.model.ModelEarthSage;
import com.person124.sm.render.RenderEarthSage;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class SMClientProxy extends SMCommonProxy {
	
	@Override
	public void registerRenderers() {
		
	}
	
	@Override
	public void registerRenderInfomation() {
		RenderingRegistry.registerEntityRenderingHandler(EntityEarthSage.class, new RenderEarthSage(new ModelEarthSage(), 1.0F));
	}
	
	@Override
	public int addArmor(String path) {
		return RenderingRegistry.addNewArmourRendererPrefix(path);
	}

}
