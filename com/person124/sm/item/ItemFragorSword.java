package com.person124.sm.item;

import com.person124.sm.SimpleMagic;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemFragorSword extends ItemSword {

	public ItemFragorSword(ToolMaterial material, String name) {
		super(material);
		setCreativeTab(SimpleMagic.smTab);
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setTextureName("simplemagic:" + name);
	}

	public boolean hitEntity(ItemStack is, EntityLivingBase hurt, EntityLivingBase entity) {
		is.damageItem(1, entity);
		entity.worldObj.createExplosion(entity, hurt.posX, hurt.posY, hurt.posZ, 1.5F, false);
		return true;
	}

}
