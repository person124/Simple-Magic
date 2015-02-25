package com.person124.sm.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

import com.person124.sm.element.Limbo;

public class ItemLimboPearl extends ItemBasic {

	private boolean slow = false;

	public ItemLimboPearl(String name) {
		super(name, 1);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float x, float y, float z) {
		if (world.getBlockState(pos).getBlock().getBlockState().getBaseState() == Blocks.dirt.getBlockState().getBaseState() || world.getBlockState(pos).getBlock().getBlockState().getBaseState() == Blocks.grass.getBlockState().getBaseState()) {
			if (!world.isRemote) world.setBlockState(pos, Limbo.CURSED_BLOCK.getStateFromMeta(0));
			explode(world, x, y, z);
			player.inventory.consumeInventoryItem(Limbo.LIMBO_PEARL);
			return true;
		}
		if (world.getBlockState(pos) == Blocks.stone.getBlockState().getBaseState() || world.getBlockState(pos) == Blocks.coal_ore.getBlockState().getBaseState() || world.getBlockState(pos) == Blocks.iron_ore.getBlockState().getBaseState() || world.getBlockState(pos) == Blocks.diamond_ore.getBlockState().getBaseState() || world.getBlockState(pos) == Blocks.redstone_ore.getBlockState().getBaseState() || world.getBlockState(pos) == Blocks.emerald_ore.getBlockState().getBaseState()) {
			if (!world.isRemote) world.setBlockState(pos, Limbo.CURSED_BLOCK.getStateFromMeta(1));
			explode(world, x, y, z);
			player.inventory.consumeInventoryItem(Limbo.LIMBO_PEARL);
			return true;
		}
		if (world.getBlockState(pos).getBlock().getBlockState().getBaseState() == Blocks.log.getBlockState().getBaseState() || world.getBlockState(pos).getBlock().getBlockState().getBaseState() == Blocks.log2.getBlockState().getBaseState()) {
			if (!world.isRemote) world.setBlockState(pos, Limbo.CURSED_BLOCK.getStateFromMeta(2));
			explode(world, x, y, z);
			player.inventory.consumeInventoryItem(Limbo.LIMBO_PEARL);
			return true;
		}
		if (world.getBlockState(pos).getBlock().getBlockState().getBaseState() == Limbo.CURSED_BLOCK.getBlockState().getBaseState()) {
			if (!world.isRemote) world.destroyBlock(pos, false);
			player.inventory.addItemStackToInventory(new ItemStack(Limbo.LIMBO_DUST, 3));
			return true;
		}
		return true;
	}

	private void explode(World world, float x, float y, float z) {
		if (!slow) world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, x + .5, y - .5, z + .5, 0.0, 0.0, 0.0);
		if (slow) world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, x + .5, y - .5, z + .5, 0.0, 0.0, 0.0);
	}

}
