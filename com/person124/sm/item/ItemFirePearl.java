package com.person124.sm.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.person124.sm.element.Fire;

public class ItemFirePearl extends ItemBasic {

	public ItemFirePearl(String name) {
		super(name, 1);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		player.setFire(19);
		player.inventory.consumeInventoryItem(Fire.FIRE_PEARL);
		player.inventory.addItemStackToInventory(new ItemStack(Fire.FIRE_DUST, 3));
		
		return true;
	}

}
