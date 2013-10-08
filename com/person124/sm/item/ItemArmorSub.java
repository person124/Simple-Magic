package com.person124.sm.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.person124.sm.element.Darkness;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorSub extends ItemArmor {

	public ItemArmorSub(int id, EnumArmorMaterial material, int par3, int par4, String name, CreativeTabs tab) {
		super(id, material, par3, par4);

		setUnlocalizedName(name);
		setMaxStackSize(1);
		setCreativeTab(tab);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (slot == 0 || slot == 2) return "simplemagic:textures/models/armor/EleSub_1.png";
		if (slot == 3 || slot == 4) return "simplemagic:textures/models/armor/EleSub_2.png";

		return "simplemagic:textures/models/armor/EleSub_1.png";
	}

	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack is) {

		ItemStack helmet = player.getCurrentArmor(3);
		ItemStack chest = player.getCurrentArmor(2);
		ItemStack legs = player.getCurrentArmor(1);
		ItemStack boots = player.getCurrentArmor(0);

		if (helmet != null && helmet.getItem() == Darkness.darkHelmet) {
			if (is.getItemDamage() < 11) {
				if (player.isPotionActive(Potion.blindness.id)) player.removePotionEffect(Potion.blindness.id);
				if (player.isPotionActive(Potion.nightVision.id)) player.removePotionEffect(Potion.nightVision.id);
				is.setItemDamage(is.getMaxDamage());
			}
			PotionEffect nightVision = new PotionEffect(Potion.nightVision.id, 1, 0, true);
			nightVision.setPotionDurationMax(true);
			PotionEffect blind = new PotionEffect(Potion.blindness.id, 1000, 0, true);
			blind.setPotionDurationMax(true);
			if (world.isDaytime()) {
				if (player.worldObj.isRemote && !player.worldObj.canBlockSeeTheSky(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ))) {
					if (player.isPotionActive(Potion.blindness.id)) player.removePotionEffect(Potion.blindness.id);
					if (!player.isPotionActive(Potion.nightVision.id)) player.addPotionEffect(nightVision);
				}
				if (player.worldObj.isRemote && player.worldObj.canBlockSeeTheSky(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ))) {
					if (player.isPotionActive(Potion.nightVision.id)) player.removePotionEffect(Potion.nightVision.id);
					if (!player.isPotionActive(Potion.blindness.id)) player.addPotionEffect(blind);
				}
			}
			if (!world.isDaytime()) {
				if (player.isPotionActive(Potion.blindness.id)) player.removePotionEffect(Potion.blindness.id);
				if (!player.isPotionActive(Potion.nightVision.id)) player.addPotionEffect(nightVision);
			}
		}

	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("simplemagic" + ":" + (this.getUnlocalizedName().substring(5)));
	}

}
