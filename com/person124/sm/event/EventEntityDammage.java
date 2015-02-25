package com.person124.sm.event;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.person124.sm.element.Fragor;
import com.person124.sm.element.Limbo;

public class EventEntityDammage {

	private Random rand = new Random();

	@SubscribeEvent
	public void onPlayerDamage(LivingHurtEvent event) {
		if (!(event.entity instanceof EntityPlayer)) return;
		EntityPlayer player = (EntityPlayer) event.entityLiving;
		if (player.getCurrentArmor(1) != null) if (player.getCurrentArmor(1).getItem() == Limbo.LIMBO_LEGGINGS) limboLeggings(event);
		if (player.getCurrentArmor(2) != null) if (player.getCurrentArmor(2).getItem() == Fragor.FRAGOR_CHESTPLATE) fragorChestplate(event);
	}

	private void limboLeggings(LivingHurtEvent event) {
		if (event.source == DamageSource.fall || event.source == DamageSource.magic || event.source == DamageSource.generic) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			int chance = rand.nextInt(10);
			if (chance < 5) {
				if (chance < 2) {
					player.heal(event.ammount);
				}
				player.getCurrentArmor(1).damageItem(2, player);
				event.setCanceled(true);
			}
		}
	}
	
	private void fragorChestplate(LivingHurtEvent event) {
		if (event.source.isExplosion()) {
			event.setCanceled(true);
		}
	}

}