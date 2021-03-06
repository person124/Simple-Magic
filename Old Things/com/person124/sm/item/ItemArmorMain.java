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
import net.minecraft.world.World;

import com.person124.sm.element.Earth;
import com.person124.sm.element.Water;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorMain extends ItemArmor {

	public ItemArmorMain(int id, EnumArmorMaterial material, int par3, int par4, String name, CreativeTabs tab) {
		super(id, material, par3, par4);
		
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setCreativeTab(tab);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (slot == 0 || slot == 2) return "simplemagic:textures/models/armor/EleMain_1.png";
		if (slot == 3 || slot == 4) return "simplemagic:textures/models/armor/EleMain_2.png";

		return "simplemagic:textures/models/armor/EleMain_1.png";
	}

	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack is) {

		ItemStack helmet = player.getCurrentArmor(3);
		ItemStack chest = player.getCurrentArmor(2);
		ItemStack legs = player.getCurrentArmor(1);
		ItemStack boots = player.getCurrentArmor(0);

		if (chest != null && chest.getItem() == Earth.earthChest) {
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1, 1, false));
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1, 1, false));
		}
		if(helmet != null && helmet.getItem() == Water.waterHelmet) {
			if(player.isInWater()) {
				player.setAir(0);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("simplemagic" + ":" + (this.getUnlocalizedName().substring(5)));
	}

}
