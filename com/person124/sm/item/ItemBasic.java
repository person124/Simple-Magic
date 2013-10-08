package com.person124.sm.item;

import com.person124.sm.common.mod_SimpleMagic;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBasic extends Item {

	public ItemBasic(int id, String name, int stackSize, CreativeTabs tab) {
		super(id);

		setUnlocalizedName(name);
		setMaxStackSize(stackSize);
		setCreativeTab(tab);
		setTextureName(name);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("simplemagic" + ":" + (this.getUnlocalizedName().substring(5)));
	}

}
