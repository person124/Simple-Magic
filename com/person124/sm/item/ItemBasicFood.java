package com.person124.sm.item;

import com.person124.sm.SimpleMagic;

import net.minecraft.item.ItemFood;

public class ItemBasicFood extends ItemFood {

	public ItemBasicFood(String name, int size, int hunger, float saturation) {
		super(hunger, saturation, false);
		setUnlocalizedName(name);
		setMaxStackSize(size);
		setCreativeTab(SimpleMagic.smTab);
	}

}
