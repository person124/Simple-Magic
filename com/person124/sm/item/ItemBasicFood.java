package com.person124.sm.item;

import net.minecraft.item.ItemFood;

import com.person124.sm.SimpleMagic;

public class ItemBasicFood extends ItemFood {

	public ItemBasicFood(String name, int size, int hunger, float saturation) {
		super(hunger, saturation, false);
		setUnlocalizedName(name);
		setMaxStackSize(size);
		setCreativeTab(SimpleMagic.smTab);
	}

}
