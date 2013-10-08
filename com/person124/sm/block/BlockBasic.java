package com.person124.sm.block;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBasic extends Block {

	public BlockBasic(int id, Material material, String name, CreativeTabs tab, Float hard, StepSound sound, Float light, boolean unbreakable) {
		super(id, material);

		setUnlocalizedName(name);
		setCreativeTab(tab);
		setHardness(hard);
		if (unbreakable) setBlockUnbreakable();
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("simplemagic" + ":" + (this.getUnlocalizedName().substring(5)));
	}

}
