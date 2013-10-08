package com.person124.sm.potion;

import net.minecraft.potion.Potion;

public class PotionFreeze extends Potion {

	public PotionFreeze(int par1, boolean par2, int par3, int index1, int index2, String name) {
		super(par1, par2, par3);

		this.setIconIndex(index1, index2);
		this.setPotionName(name);
	}

	public Potion setIconIndex(int par1, int par2) {
		super.setIconIndex(par1, par2);
		return this;
	}

}
