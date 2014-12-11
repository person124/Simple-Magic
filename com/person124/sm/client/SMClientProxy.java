package com.person124.sm.client;

import com.person124.sm.common.SMCommonProxy;
import com.person124.sm.entity.EntityEarthSage;
import com.person124.sm.entity.EntityFireSage;
import com.person124.sm.entity.EntityLimboSage;
import com.person124.sm.model.ModelEarthSage;
import com.person124.sm.model.ModelFireSage;
import com.person124.sm.model.ModelLimboSage;
import com.person124.sm.render.RenderCustomMob;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class SMClientProxy extends SMCommonProxy {
	
	@Override
	public void registerRenderers() {
		
	}
	
	@Override
	public void registerRenderInfomation() {
		RenderingRegistry.registerEntityRenderingHandler(EntityEarthSage.class, new RenderCustomMob(new ModelEarthSage(), 0.65F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLimboSage.class, new RenderCustomMob(new ModelLimboSage(), 0.25F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireSage.class, new RenderCustomMob(new ModelFireSage(), 0.5F));
	}
	
	@Override
	public int addArmor(String path) {
		return RenderingRegistry.addNewArmourRendererPrefix(path);
	}

}
