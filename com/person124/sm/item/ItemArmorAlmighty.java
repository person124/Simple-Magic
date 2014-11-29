package com.person124.sm.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.person124.sm.SimpleMagic;

public class ItemArmorAlmighty extends ItemArmor {

	public ItemArmorAlmighty(ArmorMaterial material, int typeID, String name) {
		super(material, SimpleMagic.proxy.addArmor("sm-armor-almighty"), typeID);
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setTextureName("simplemagic:" + name);
		setCreativeTab(SimpleMagic.smTab);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack is) {

		//ItemStack helmet = player.getCurrentArmor(3);
		//ItemStack chest = player.getCurrentArmor(2);
		//ItemStack legs = player.getCurrentArmor(1);
		//ItemStack boots = player.getCurrentArmor(0);

		//for legs see: "EntityDamageHandler"
	}
	
	@Override
	public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
		return "simplemagic:/textures/armor/EleAlm_2.png";
	}

}
