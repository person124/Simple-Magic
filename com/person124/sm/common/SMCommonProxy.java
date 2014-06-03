package com.person124.sm.common;

import com.person124.sm.entity.EntityEarthSage;

import cpw.mods.fml.common.registry.EntityRegistry;

public class SMCommonProxy {
	
	public void init() {
		registerRenderers();
		registerRenderInfomation();
		
		EntityRegistry.registerGlobalEntityID(EntityEarthSage.class, "sm-entity-earthsage", EntityRegistry.findGlobalUniqueEntityId(), 123456, 654321);
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
