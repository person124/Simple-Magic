package com.person124.sm.block;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.person124.sm.element.Base;

public class BlockSummonCirclePower extends BlockSummonCircle {

	public BlockSummonCirclePower(String name) {
		super(name);
		setCreativeTab(null);
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
		world.setBlockState(pos, Base.SUMMON_CIRCLE_POWER.getBlockState().getBaseState());
	}

}
