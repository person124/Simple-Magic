package com.person124.sm.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.person124.sm.SimpleMagic;

public class ItemArmorMinor extends ItemArmor {

	public ItemArmorMinor(ArmorMaterial material, int typeID, String name) {
		super(material, SimpleMagic.proxy.addArmor("sm-armor-minor"), typeID);
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setTextureName("simplemagic:" + name);
		setCreativeTab(SimpleMagic.smTab);
	}
	
	@Override
	public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
		return "simplemagic:textures/armor/EleMinor_1.png";
	}
	
	@Override
	public boolean getIsRepairable(ItemStack is, ItemStack other) {
		return false;
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return false;
	}

}
