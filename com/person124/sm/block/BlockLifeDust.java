package com.person124.sm.block;

import java.util.Random;

import com.person124.sm.element.Limbo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockLifeDust extends BlockBasic {

	public BlockLifeDust(String name) {
		super(Material.plants, name, 0.0F, Block.soundTypeGrass, null, 0);
		setTickRandomly(true);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		updateTick(world, x, y, z, new Random());
		return true;
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		for (int yp = -1; yp <= 1; yp++) {
			int ya = yp + y;
			for (int xp = -1; xp <= 1; xp++) {
				int xa = x + xp;
				for (int zp = -1; zp <= 1; zp++) {
					int za = z + zp;
					if (world.getBlock(xa, ya, za) == Blocks.dirt) world.setBlock(xa, ya, za, Blocks.grass);
					else if (world.getBlock(xa, ya, za) == Limbo.CURSED_DIRT) world.setBlock(xa, ya, za, Blocks.grass);
					else if (world.getBlock(xa, ya, za) == Limbo.CURSED_LOG) world.setBlock(xa, ya, za, Blocks.log);
					else if (world.getBlock(xa, ya, za) == Limbo.CURSED_STONE) world.setBlock(xa, ya, za, Blocks.stone);
				}
			}
		}
	}

}
