package com.person124.sm;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.person124.sm.element.Base;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SMTab extends CreativeTabs {
	
	public SMTab(int id, String name) {
		super(id, name);
	}
	
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Base.MAGIC_DUST;
	}
	
	public String getTranslatedTabLabel() {
		return "Simple Magic";	
	}

}
