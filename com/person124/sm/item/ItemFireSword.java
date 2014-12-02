package com.person124.sm.item;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import com.person124.sm.SimpleMagic;

public class ItemFireSword extends ItemSword {

	private Random rand = new Random();

	public ItemFireSword(ToolMaterial material, String name) {
		super(material);
		setCreativeTab(SimpleMagic.smTab);
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setTextureName("simplemagic:" + name);
	}

	public boolean hitEntity(ItemStack is, EntityLivingBase hit, EntityLivingBase self) {
		if (!hit.isBurning()) {
			hit.setFire(rand.nextInt(10));
			is.damageItem(4, self);
		} else {
			hit.heal(-(rand.nextInt(6) + 1));
		}

		return super.hitEntity(is, hit, self);
	}

	@Override
	public boolean getIsRepairable(ItemStack is, ItemStack other) {
		if (other.getItem() == Items.flint_and_steel) return true;
		return false;
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return false;
	}

}
