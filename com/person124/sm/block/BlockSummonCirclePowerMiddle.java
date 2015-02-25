package com.person124.sm.block;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.person124.sm.element.Base;
import com.person124.sm.entity.EntityEarthSage;
import com.person124.sm.entity.EntityFireSage;
import com.person124.sm.entity.EntityLimboSage;

public class BlockSummonCirclePowerMiddle extends BlockSummonCircle {

	public BlockSummonCirclePowerMiddle(String name) {
		super(name);
		setCreativeTab(null);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float x, float y, float z) {
		if (world.getDifficulty().getDifficultyId() > 0 && player.inventory.getCurrentItem() != null) {
			Entity entity = null;

			if (hasItem(player, Item.getItemFromBlock(Blocks.dirt))) entity = new EntityEarthSage(world);
			else if (hasItem(player, Items.ender_pearl)) entity = new EntityLimboSage(world);
			else if (hasItem(player, Items.fire_charge)) entity = new EntityFireSage(world);
			if (entity == null) return true;

			double xa = pos.getX() + .5;
			double ya = pos.getY() + .5;
			double za = pos.getZ() + .5;
			entity.setPosition(xa, ya, za);
			if (!world.isRemote) world.spawnEntityInWorld(entity);
		}

		return true;
	}
	
	private boolean hasItem(EntityPlayer p, Item i) {
		if (p.inventory.getCurrentItem().isItemEqual(new ItemStack(i))) {
			p.inventory.consumeInventoryItem(i);
			return true;
		}
		return false;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(Blocks.air);
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos) {
		return null;
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state) {
		doBreak(world, pos);
	}

	@Override
	public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion explosionIn) {
		doBreak(world, pos);
	}

	private void doBreak(World world, BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		for (int zp = -1; zp < 2; zp++) {
			for (int xp = -1; xp < 2; xp++) {
				if (!(zp == 0 && xp == 0)) {
					BlockPos bp = new BlockPos(x + xp, y, z + zp);
					world.setBlockState(bp, Base.SUMMON_CIRCLE.getDefaultState());
					world.destroyBlock(bp, true);
				}
			}
		}
		world.setBlockState(pos, Base.SUMMON_CIRCLE_MIDDLE.getDefaultState());
	}

}
