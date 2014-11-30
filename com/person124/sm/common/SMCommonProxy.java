package com.person124.sm.common;

import com.person124.sm.entity.EntityEarthSage;
import com.person124.sm.entity.EntityFireSage;
import com.person124.sm.entity.EntityLimboSage;

import cpw.mods.fml.common.registry.EntityRegistry;

public class SMCommonProxy {
	
	public void init() {
		registerRenderers();
		registerRenderInfomation();
		
		EntityRegistry.registerGlobalEntityID(EntityEarthSage.class, "earthsage", EntityRegistry.findGlobalUniqueEntityId(), 0x593d29, 0x69a93f);
		EntityRegistry.registerGlobalEntityID(EntityLimboSage.class, "limbosage", EntityRegistry.findGlobalUniqueEntityId(), 0x7f7f7f, 0);
		EntityRegistry.registerGlobalEntityID(EntityFireSage.class, "firesage", EntityRegistry.findGlobalUniqueEntityId(), 0xff0000, 0xff5500);
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
