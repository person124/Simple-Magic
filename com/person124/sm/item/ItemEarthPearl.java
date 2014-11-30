package com.person124.sm.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.person124.sm.element.Earth;

public class ItemEarthPearl extends ItemBasic {

	public ItemEarthPearl(String name) {
		super(name, 1);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		if (world.getBlock(x, y, z) != Blocks.air) {
			if (world.getBlock(x, y, z) == Blocks.stone) {
				if (!world.isRemote) world.func_147480_a(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 1));
				player.inventory.consumeInventoryItem(Earth.EARTH_PEARL);
			}
			if (world.getBlock(x, y, z) == Blocks.coal_ore) {
				if (!world.isRemote) world.func_147480_a(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 2));
				player.inventory.consumeInventoryItem(Earth.EARTH_PEARL);
			}
			if (world.getBlock(x, y, z) == Blocks.iron_ore) {
				if (!world.isRemote) world.func_147480_a(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 3));
				player.inventory.consumeInventoryItem(Earth.EARTH_PEARL);
			}
			if (world.getBlock(x, y, z) == Blocks.lapis_ore) {
				if (!world.isRemote) world.func_147480_a(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 4));
				player.inventory.consumeInventoryItem(Earth.EARTH_PEARL);
			}
			if (world.getBlock(x, y, z) == Blocks.gold_ore) {
				if (!world.isRemote) world.func_147480_a(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 5));
				player.inventory.consumeInventoryItem(Earth.EARTH_PEARL);
			}
			if (world.getBlock(x, y, z) == Blocks.diamond_ore) {
				if (!world.isRemote) world.func_147480_a(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 10));
				player.inventory.consumeInventoryItem(Earth.EARTH_PEARL);
			}
			if (world.getBlock(x, y, z) == Blocks.quartz_ore) {
				if (!world.isRemote) world.func_147480_a(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 6));
				player.inventory.consumeInventoryItem(Earth.EARTH_PEARL);
			}
			if (world.getBlock(x, y, z) == Blocks.emerald_ore) {
				if (!world.isRemote) world.func_147480_a(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 64));
				player.inventory.consumeInventoryItem(Earth.EARTH_PEARL);
			}
		}

		return false;
	}

}
