package com.person124.sm.common;

import com.person124.sm.entity.EntityEarthSage;
import com.person124.sm.entity.EntityLimboSage;

import cpw.mods.fml.common.registry.EntityRegistry;

public class SMCommonProxy {
	
	public void init() {
		registerRenderers();
		registerRenderInfomation();
		
		EntityRegistry.registerGlobalEntityID(EntityEarthSage.class, "earthsage", EntityRegistry.findGlobalUniqueEntityId(), 123456, 654321);
		EntityRegistry.registerGlobalEntityID(EntityLimboSage.class, "limbosage", EntityRegistry.findGlobalUniqueEntityId(), 0xffffff, 0);
	}
	
	public void registerRenderers() {
		//Client only
	}
	
	public void registerRenderInfomation() {
		//Client only
	}
	
	public int addArmor(String path) {
		return 0;
	}

}
