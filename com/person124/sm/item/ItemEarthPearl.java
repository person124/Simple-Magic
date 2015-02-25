package com.person124.sm.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.person124.sm.element.Earth;

public class ItemEarthPearl extends ItemBasic {

	public ItemEarthPearl(String name) {
		super(name, 1);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float x, float y, float z) {
		if (world.getBlockState(pos) != Blocks.air.getBlockState().getBaseState()) {
			boolean b = false;
			if (world.getBlockState(pos) == Blocks.stone.getBlockState().getBaseState()) {
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 1));
				b = true;
			} else if (world.getBlockState(pos) == Blocks.coal_ore.getBlockState().getBaseState()) {
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 2));
				b = true;
			} else if (world.getBlockState(pos) == Blocks.iron_ore.getBlockState().getBaseState()) {
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 3));
				b = true;
			} else if (world.getBlockState(pos) == Blocks.lapis_ore.getBlockState().getBaseState()) {
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 4));
				b = true;
			} else if (world.getBlockState(pos) == Blocks.gold_ore.getBlockState().getBaseState()) {
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 5));
				b = true;
			} else if (world.getBlockState(pos) == Blocks.diamond_ore.getBlockState().getBaseState()) {
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 10));
				b = true;
			} else if (world.getBlockState(pos) == Blocks.quartz_ore.getBlockState().getBaseState()) {
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 6));
				b = true;
			} else if (world.getBlockState(pos) == Blocks.emerald_ore.getBlockState().getBaseState()) {
				player.inventory.addItemStackToInventory(new ItemStack(Earth.EARTH_DUST, 64));
				b = true;
			}

			if (b) {
				if (!world.isRemote) world.destroyBlock(pos, false);
				player.inventory.consumeInventoryItem(Earth.EARTH_PEARL);
			}
		}

		return false;
	}

}
