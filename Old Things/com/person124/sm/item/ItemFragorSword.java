package com.person124.sm.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFragorSword extends ItemSword {

	private int weaponDamage;
	private final EnumToolMaterial toolMaterial;

	public ItemFragorSword(int id, EnumToolMaterial material, String name, CreativeTabs tab) {
		super(id, material);
		this.toolMaterial = material;
		this.maxStackSize = 1;
		this.setMaxDamage(material.getMaxUses());
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.weaponDamage = 0;
		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);
		this.setMaxDamage(200);
		this.setMaxStackSize(1);
	}

	public boolean hitEntity(ItemStack is, EntityLiving entity, EntityLiving player) {
		is.damageItem(1, player);
		entity.heal(-5);
		entity.spawnExplosionParticle();
		entity.addPotionEffect(new PotionEffect(Potion.blindness.id, 300, 0, false));
		entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 150, 0, false));
		return true;
	}

	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("simplemagic" + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
