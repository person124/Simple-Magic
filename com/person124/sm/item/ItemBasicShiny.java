package com.person124.sm.item;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBasicShiny extends ItemBasic {

	public ItemBasicShiny(String name, int size) {
		super(name, size);
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack is) {
		return true;
	}

}
