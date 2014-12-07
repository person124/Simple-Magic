package com.person124.sm.item;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFragorSword extends ItemBasic {

	public ItemFragorSword(String name, int uses) {
		super(name, 1);
		setMaxDamage(uses);
	}

	public boolean hitEntity(ItemStack is, EntityLivingBase hurt, EntityLivingBase entity) {
		is.damageItem(1, entity);
		entity.worldObj.createExplosion(entity, hurt.posX, hurt.posY, hurt.posZ, 1.5F, false);
		return true;
	}

	public boolean onBlockDestroyed(ItemStack is, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
		if ((double) block.getBlockHardness(world, x, y, z) != 0.0D) is.damageItem(2, entity);

		return true;
	}

}
