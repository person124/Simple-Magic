package com.person124.sm.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.person124.sm.SimpleMagic;

public class BlockBasic extends Block {

	public BlockBasic(Material material, String name, float hard, SoundType sound, String harvestTool, int harvestLvl) {
		super(material);
		//GameRegistry.registerBlock(this, name);
		setUnlocalizedName(name);
		setCreativeTab(SimpleMagic.smTab);
		setHardness(hard);
		setStepSound(sound);
		if (harvestTool != null) setHarvestLevel(harvestTool, harvestLvl);
	}
}
