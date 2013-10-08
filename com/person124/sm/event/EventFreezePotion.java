package com.person124.sm.event;

import java.util.Random;

import com.person124.sm.common.mod_SimpleMagic;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class EventFreezePotion {
	
	private Random rand = new Random();

	@ForgeSubscribe
	public void onEntityUpdate(LivingUpdateEvent event) {
		EntityLivingBase entity = event.entityLiving;
		if (entity.isPotionActive(mod_SimpleMagic.freezePotion)) {
			entity.rotationPitch = 0;
			entity.rotationYaw = 0;
			entity.motionX = 0;
			entity.motionY = 0;
			entity.motionZ = 0;

			if (entity.isBurning()) {
				entity.removePotionEffect(mod_SimpleMagic.freezePotion.id);
			}
			if (entity instanceof EntityBlaze) entity.heal(-100);
			if (entity instanceof EntitySnowman) entity.heal(5);
			if (entity instanceof EntityPlayer) {
				//if(entity.getCurrentArmor(1) == new ItemStack(Fire.fireLegs)) entity.removePotionEffect(mod_SimpleMagic.freezePotion.id);
			}
		}
		/*
		 * if
		 * (event.entityLiving.getActivePotionEffect(mod_SimpleMagic.freezePotion
		 * ).getDuration() == 0) {
		 * event.entityLiving.removePotionEffect(mod_SimpleMagic
		 * .freezePotion.id); return; }
		 */
	}

}
