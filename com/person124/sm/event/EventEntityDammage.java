package com.person124.sm.event;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import com.person124.sm.element.Limbo;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventEntityDammage {
	
	private Random rand = new Random();
	
	@SubscribeEvent
	public void onPlayerDamage(LivingHurtEvent event) {
		if (!(event.entity instanceof EntityPlayer)) return;
		EntityPlayer player = (EntityPlayer)event.entityLiving;
		if (player.getCurrentArmor(1) == new ItemStack(Limbo.LIMBO_LEGGINGS)) {
			int chance = rand.nextInt(10);
			if (chance > 5) {
				if (chance > 2) {
					int damage = (int) (event.ammount * -1);
					player.heal(damage);
				} else {
					event.setCanceled(true);
				}
			}
		}
	}

}