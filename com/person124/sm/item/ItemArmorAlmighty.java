package com.person124.sm.item;

import com.person124.sm.element.Earth;
import com.person124.sm.element.Limbo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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

public class ItemArmorAlmighty extends ItemArmor{
	
	public ItemArmorAlmighty(int id, EnumArmorMaterial material, int par3, int par4, String name, CreativeTabs tab) {
		super(id, material, par3, par4);
		
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setCreativeTab(tab);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (slot == 0 || slot == 1) return "simplemagic:textures/models/armor/EleAlm_1.png";
		if (slot == 2 || slot == 3) return "simplemagic:textures/models/armor/EleAlm_2.png";

		return "simplemagic:textures/models/armor/EleAlm_1.png";
	}

	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack is) {

		ItemStack helmet = player.getCurrentArmor(3);
		ItemStack chest = player.getCurrentArmor(2);
		ItemStack legs = player.getCurrentArmor(1);
		ItemStack boots = player.getCurrentArmor(0);

		//for legs see: "EntityDamageHandler
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("simplemagic" + ":" + (this.getUnlocalizedName().substring(5)));
	}

}
