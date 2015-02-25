package com.person124.sm.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.person124.sm.element.Base;

public class BlockSummonCircleMiddle extends BlockSummonCircle {

	public BlockSummonCircleMiddle(String name) {
		super(name);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float x, float y, float z) {
		int many = 0;
		int xa = pos.getX();
		int ya = pos.getY();
		int za = pos.getZ();
		for (int zp = -1; zp < 2; zp++) {
			for (int xp = -1; xp < 2; xp++) {
				if (world.getBlockState(new BlockPos(xa + xp, ya, za + zp)) == Base.SUMMON_CIRCLE.getBlockState().getBaseState()) many += 1;
			}
		}
		if (many == 8) levelUp(world, pos, player);

		return true;
	}

	private void levelUp(World world, BlockPos pos, EntityPlayer player) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		for (int zp = -1; zp < 2; zp++) {
			for (int xp = -1; xp < 2; xp++) {
				world.setBlockState(new BlockPos(x + xp, y, z + zp), Base.SUMMON_CIRCLE_POWER.getDefaultState());
			}
		}
		world.setBlockState(pos, Base.SUMMON_CIRCLE_POWER_MIDDLE.getDefaultState());
	}

}
