package com.person124.sm.event;

import java.util.UUID;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;

import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventPlayerCape {

	@SubscribeEvent
	public void renderCapes(RenderPlayerEvent.Specials.Pre event) {
		if (event.entityPlayer instanceof AbstractClientPlayer) {
			AbstractClientPlayer player = (AbstractClientPlayer) event.entityPlayer;
			if (player.getUniqueID().equals(UUID.fromString("e854a81a-f2c2-4168-bef8-877a5bdd1835"))) {
				player.func_152121_a(Type.CAPE, new ResourceLocation("simplemagic", "textures/mob/cape.png"));
			}
		}
	}

}
