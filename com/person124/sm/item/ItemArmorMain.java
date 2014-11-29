package com.person124.sm.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.person124.sm.SimpleMagic;
import com.person124.sm.element.Earth;

public class ItemArmorMain extends ItemArmor {

	public ItemArmorMain(ArmorMaterial material, int typeID, String name) {
		super(material, SimpleMagic.proxy.addArmor("sm-armor-main"), typeID);
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setTextureName("simplemagic:" + name);
		setCreativeTab(SimpleMagic.smTab);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack is) {

		//ItemStack helmet = player.getCurrentArmor(3);
		ItemStack chest = player.getCurrentArmor(2);
		//ItemStack legs = player.getCurrentArmor(1);
		//ItemStack boots = player.getCurrentArmor(0);

		if (chest != null && chest.getItem() == Earth.EARTH_CHESTPLATE) {
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1, 1, false));
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1, 1, false));
		}
		/*if (legs != null && legs.getItem() == Fire.fireLegs) {
			if (player.isBurning()) {
				player.extinguish();
				player.heal(2);
				is.damageItem(-1, player);
			}
		}
		if(helmet != null && helmet.getItem() == Water.waterHelmet) {
			if(player.isInWater()) {
				player.setAir(0);
			}
		}
		*/
	}

	@Override
	public String getArmorTexture(ItemStack is, Entity entity, int slot, String type) {
		/*if (is.itemID == Earth.EARTH_CHESTPLATE || is.itemID == Water.waterHelmet.itemID) {
			return "/person124/sm/textures/armor/EleMain_1.png";
		}
		if (is.itemID == Fire.fireLegs.itemID) {
			return "/person124/sm/textures/armor/EleMain_2.png";
		}*/
		return "simplemagic:/textures/armor/EleMain_1.png";
	}

}
