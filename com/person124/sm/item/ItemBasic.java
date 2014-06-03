package com.person124.sm.item;

import net.minecraft.item.Item;

import com.person124.sm.SimpleMagic;

public class ItemBasic extends Item {
	
	public ItemBasic(String name, int size) {
		setCreativeTab(SimpleMagic.smTab);
		setUnlocalizedName(name);
		setMaxStackSize(size);
		setTextureName("simplemagic:" + name);
	}

}
