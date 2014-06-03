package com.person124.sm.item;

import com.person124.sm.SimpleMagic;

import net.minecraft.item.ItemPickaxe;

public class ItemBasicPickaxe extends ItemPickaxe {
	
	public ItemBasicPickaxe(ToolMaterial material, String name) {
		super(material);
		setCreativeTab(SimpleMagic.smTab);
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setTextureName("simplemagic:" + name);
	}
	
	

}
