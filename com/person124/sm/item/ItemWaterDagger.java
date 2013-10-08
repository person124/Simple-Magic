package com.person124.sm.item;

import com.person124.sm.common.mod_SimpleMagic;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWaterDagger extends Item{
	
	public ItemWaterDagger(int id, String name, int size, CreativeTabs tab) {
		super(id);

		this.setCreativeTab(tab);
		this.setMaxStackSize(size);
		this.setUnlocalizedName(name);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("simplemagic" + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	@Override
	public boolean hitEntity(ItemStack is, EntityLivingBase entity, EntityLivingBase you)
    {
		entity.addPotionEffect(new PotionEffect(mod_SimpleMagic.freezePotion.id, 100, 0, false));
		entity.heal(1);
		return false;
    }

}
