package com.person124.sm.item;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

import com.person124.sm.SimpleMagic;

public class ItemBasicPickaxe extends ItemPickaxe {

	public ItemBasicPickaxe(ToolMaterial material, String name) {
		super(material);
		setCreativeTab(SimpleMagic.smTab);
		setUnlocalizedName(name);
		setMaxStackSize(1);
	}

	@Override
	public boolean getIsRepairable(ItemStack is, ItemStack other) {
		return false;
	}

}
