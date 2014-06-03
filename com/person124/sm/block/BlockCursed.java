package com.person124.sm.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.person124.sm.element.Limbo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCursed extends BlockBasic {

	private boolean slow = false;
	private int type;
	@SideOnly(Side.CLIENT)
	private IIcon[] blockIcon = new IIcon[4];

	public BlockCursed(String name, int type) {
		super(Material.iron, name, 5.0F, Block.soundTypeAnvil, null, 0);
		this.type = type;
		setTickRandomly(true);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon[0] = iconRegister.registerIcon("simplemagic:sm-curseddirt");
		blockIcon[1] = iconRegister.registerIcon("simplemagic:sm-cursedstone");
		blockIcon[2] = iconRegister.registerIcon("simplemagic:sm-cursedlog");
		blockIcon[3] = iconRegister.registerIcon("simplemagic:sm-cursedlog_top");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int i, int par2) {
		if (i == 1) {
			if (type == 0) return this.blockIcon[0];
			if (type == 1) return this.blockIcon[1];
			if (type == 2) return this.blockIcon[3];
		}
		if (i == 0) {
			if (type == 0) return this.blockIcon[0];
			if (type == 1) return this.blockIcon[1];
			if (type == 2) return this.blockIcon[3];
		}
		if (i == 2) {
			if (type == 0) return this.blockIcon[0];
			if (type == 1) return this.blockIcon[1];
			if (type == 2) return this.blockIcon[2];
		}
		if (i == 3) {
			if (type == 0) return this.blockIcon[0];
			if (type == 1) return this.blockIcon[1];
			if (type == 2) return this.blockIcon[2];
		}
		if (i == 4) {
			if (type == 0) return this.blockIcon[0];
			if (type == 1) return this.blockIcon[1];
			if (type == 2) return this.blockIcon[2];
		}
		if (i == 5) {
			if (type == 0) return this.blockIcon[0];
			if (type == 1) return this.blockIcon[1];
			if (type == 2) return this.blockIcon[2];
		}
		return null;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World world, int xa, int ya, int za, Random rand) {
		if (!slow && world.getBlock(xa, ya + 1, za) != Limbo.CURSED_DIRT && world.getBlock(xa, ya + 1, za) != Limbo.CURSED_STONE && world.getBlock(xa, ya + 1, za) != Limbo.CURSED_LOG) {
			world.spawnParticle("explode", xa + .5, ya, za + .5, 0.0, 1.0, 0.0);
		}
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random par5Random) {
		if (!world.isRemote) {
			for (int i = 0; i < 4; i++) {
				int xa = x + par5Random.nextInt(3) - 1;
				int ya = y + par5Random.nextInt(5) - 3;
				int za = z + par5Random.nextInt(3) - 1;

				if (world.getBlock(xa, ya, za) == Blocks.dirt || world.getBlock(xa, ya, za) == Blocks.grass) {
					world.setBlock(xa, ya, za, Limbo.CURSED_DIRT, 0, 2);
				}
				if (world.getBlock(xa, ya, za) == Blocks.stone || world.getBlock(xa, ya, za) == Blocks.coal_ore || world.getBlock(xa, ya, za) == Blocks.iron_ore || world.getBlock(xa, ya, za) == Blocks.diamond_ore || world.getBlock(xa, ya, za) == Blocks.redstone_ore || world.getBlock(xa, ya, za) == Blocks.emerald_ore) {
					world.setBlock(xa, ya, za, Limbo.CURSED_STONE, 0, 2);
				}
				if (world.getBlock(xa, ya, za) == Blocks.log || world.getBlock(xa, ya, za) == Blocks.log2) {
					world.setBlock(xa, ya, za, Limbo.CURSED_LOG, 0, 2);
				}
			}
		}
	}
}
