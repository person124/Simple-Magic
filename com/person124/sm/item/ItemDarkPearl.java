package com.person124.sm.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.person124.sm.element.Darkness;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDarkPearl extends Item {

	public ItemDarkPearl(int id, String name, int size, CreativeTabs tab) {
		super(id);

		setUnlocalizedName(name);
		setMaxStackSize(size);
		setCreativeTab(tab);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("simplemagic" + ":" + (this.getUnlocalizedName().substring(5)));
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {

		if (player.worldObj.getLightBrightness((int) player.posX, (int) player.posY, (int) player.posZ) <= 0.0F) {
			player.inventory.consumeInventoryItem(Darkness.darkPearl.itemID);
			player.inventory.addItemStackToInventory(new ItemStack(Darkness.darkDust, 3));
		}

		return false;
	}
}
