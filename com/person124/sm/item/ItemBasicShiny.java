package com.person124.sm.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBasicShiny extends ItemBasic {

	public ItemBasicShiny(String name, int size) {
		super(name, size);
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack is) {
		return true;
	}

}
