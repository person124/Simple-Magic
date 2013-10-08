package com.person124.sm.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.person124.sm.element.Limbo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCursed extends Block {

	private int dropped;
	private int type;
	private Icon[] blockIcon = new Icon[4];

	public BlockCursed(int id, Material material, String name, CreativeTabs tab, Float hard, StepSound sound, Float light, boolean unbreakable, int type) {

		super(id, material);

		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);

		this.setHardness(hard);
		if (unbreakable) this.setBlockUnbreakable();
		this.setTickRandomly(true);
		this.type = type;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		if (type == 0) blockIcon[0] = iconRegister.registerIcon("simplemagic" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
		if (type == 1) blockIcon[1] = iconRegister.registerIcon("simplemagic" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
		if (type == 2) {
			blockIcon[2] = iconRegister.registerIcon("simplemagic" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
			blockIcon[3] = iconRegister.registerIcon("simplemagic" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "_top");
		}
	}
	public void updateTick(World world, int x, int y, int z, Random par5Random) {

		if (!world.isRemote) {
			for (int l = 0; l < 100; l++) {
				int xa = x + par5Random.nextInt(3) - 1;
				int ya = y + par5Random.nextInt(5) - 3;
				int za = z + par5Random.nextInt(3) - 1;
				int xyz = world.getBlockId(x, y + 1, z);

				if (world.getBlockId(xa, ya, za) == Block.dirt.blockID || world.getBlockId(xa, ya, za) == Block.grass.blockID) {
					world.setBlock(xa, ya, za, Limbo.cursedDirt.blockID);
					world.setBlock(xa, ya, za, Limbo.cursedDirt.blockID, 0, 2);
				}
				if (world.getBlockId(xa, ya, za) == Block.stone.blockID || world.getBlockId(xa, ya, za) == Block.oreCoal.blockID || world.getBlockId(xa, ya, za) == Block.oreIron.blockID || world.getBlockId(xa, ya, za) == Block.oreDiamond.blockID || world.getBlockId(xa, ya, za) == Block.oreRedstone.blockID || world.getBlockId(xa, ya, za) == Block.oreRedstoneGlowing.blockID || world.getBlockId(xa, ya, za) == Block.oreEmerald.blockID) {
					world.setBlock(xa, ya, za, Limbo.cursedStone.blockID, 0, 2);
				}
				if (world.getBlockId(xa, ya, za) == Block.wood.blockID) {
					world.setBlock(xa, ya, za, Limbo.cursedLog.blockID, 0, 2);
				}
			}
		}
	}

	public Icon getIcon(int i, int par2) {

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
}
