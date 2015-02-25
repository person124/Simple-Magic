package com.person124.sm.block;

import java.util.Random;

import com.person124.sm.element.Limbo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockLifeDust extends BlockBasic {

	public BlockLifeDust(String name) {
		super(Material.plants, name, 0.0F, Block.soundTypeGrass, null, 0);
		setTickRandomly(true);
	}

	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float x, float y, float z) {
		updateTick(world, pos, state, new Random());
		return true;
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		for (int yp = -1; yp <= 1; yp++) {
			int ya = pos.getY() + yp;
			for (int xp = -1; xp <= 1; xp++) {
				int xa = pos.getX() + xp;
				for (int zp = -1; zp <= 1; zp++) {
					int za = pos.getZ() + zp;
					
					BlockPos p = new BlockPos(xa, ya, za);
					if (world.getBlockState(p).getBlock() == Blocks.dirt) world.setBlockState(p, Blocks.grass.getBlockState().getBaseState());
					else if (world.getBlockState(p) == Limbo.CURSED_BLOCK.getStateFromMeta(0)) world.setBlockState(p, Blocks.grass.getBlockState().getBaseState());
					else if (world.getBlockState(p) == Limbo.CURSED_BLOCK.getStateFromMeta(2)) world.setBlockState(p, Blocks.log.getBlockState().getBaseState());
					else if (world.getBlockState(p) == Limbo.CURSED_BLOCK.getStateFromMeta(1)) world.setBlockState(p, Blocks.stone.getBlockState().getBaseState());
				}
			}
		}
	}

}
