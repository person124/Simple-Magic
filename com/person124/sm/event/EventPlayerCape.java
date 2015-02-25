package com.person124.sm.event;

import java.util.UUID;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventPlayerCape {

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void renderCapes(RenderPlayerEvent.Specials.Pre event) {
		if (event.entityPlayer instanceof AbstractClientPlayer) {
			AbstractClientPlayer player = (AbstractClientPlayer) event.entityPlayer;
			if (player.getUniqueID().equals(UUID.fromString("e854a81a-f2c2-4168-bef8-877a5bdd1835"))) {
				//player.func_152121_a(Type.CAPE, new ResourceLocation("simplemagic", "textures/mob/cape.png"));
			}
		}
	}

}
