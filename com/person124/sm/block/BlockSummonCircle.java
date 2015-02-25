package com.person124.sm.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSummonCircle extends BlockBasic {

	public BlockSummonCircle(String name) {
		super(Material.glass, name, 0.8F, Block.soundTypeCloth, null, 0);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean isFullCube() {
		return false;
	}

}
