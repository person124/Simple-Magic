package com.person124.sm.common;

import com.person124.sm.client.ClientProxy;
import com.person124.sm.entity.EntityEarthSage;
import com.person124.sm.entity.EntityLimboSage;
import com.person124.sm.entity.EntityWaterSage;

import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxy {

	public void registerRenderInfomation() {
		// client side only
	}

	public void load() {
		registerRenderInfomation();
		registerRenders();

		EntityRegistry.registerGlobalEntityID(EntityEarthSage.class, "sm-entity-earthsage", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerGlobalEntityID(EntityLimboSage.class, "sm-entity-limbosage", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerGlobalEntityID(EntityWaterSage.class, "sm-entity-watersage", EntityRegistry.findGlobalUniqueEntityId());
	}

	public void registerRenders() {
		// client side only
	}

}
