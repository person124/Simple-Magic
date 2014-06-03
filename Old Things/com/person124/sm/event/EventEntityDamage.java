package com.person124.sm.event;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import com.person124.sm.element.Limbo;

public class EventEntityDamage {
	
	private Random rand = new Random();
	
	@ForgeSubscribe
	public void onPlayerDamage(LivingHurtEvent event) {
		if(!(event.entity instanceof EntityPlayer) || event.source == DamageSource.inWall || event.source == DamageSource.drown || event.source == DamageSource.outOfWorld || event.source == DamageSource.onFire || event.source == DamageSource.lava ) return;
		EntityPlayer player = (EntityPlayer)event.entityLiving;
		if(player.getCurrentArmor(1) == new ItemStack(Limbo.limboLeggings)) {
			int chance = rand.nextInt(10);
			if(chance > 5) {
				if(chance > 2) {
					int damage = (int) (event.ammount * -1);
					player.heal(damage);
				} else {
					event.setCanceled(true);
				}
			}
		}
	}

}
