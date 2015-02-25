package com.person124.sm.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.person124.sm.element.Fire;

public class ItemFirePearl extends ItemBasic {

	public ItemFirePearl(String name) {
		super(name, 1);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float x, float y, float z) {
		if (!player.isBurning() && !player.isInWater()) {
			player.setFire(19);
			player.inventory.consumeInventoryItem(Fire.FIRE_PEARL);
			player.inventory.addItemStackToInventory(new ItemStack(Fire.FIRE_DUST, 3));

		}
		return true;
	}

}
