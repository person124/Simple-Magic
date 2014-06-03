package com.person124.sm.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class SMTab extends CreativeTabs {
	
	public SMTab(int par1, String par2) {
		super(par1, par2);
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return mod_SimpleMagic.magicDust.itemID;
	}
	
	public String getTranslatedTabLabel() {
		return "Simple Magic";
	}

}
