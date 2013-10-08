package com.person124.sm.item;

import com.person124.sm.element.Earth;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEarthPearl extends Item {

	public ItemEarthPearl(int id, String name, int stackSize, CreativeTabs tab) {
		super(id);

		setUnlocalizedName(name);
		setMaxStackSize(stackSize);
		setCreativeTab(tab);
		setTextureName(name);
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (Minecraft.getMinecraft().objectMouseOver != null) {
			int x = Minecraft.getMinecraft().objectMouseOver.blockX;
			int y = Minecraft.getMinecraft().objectMouseOver.blockY;
			int z = Minecraft.getMinecraft().objectMouseOver.blockZ;

			if (world.getBlockId(x, y, z) == Block.stone.blockID) {
				if (!world.isRemote) world.destroyBlock(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.earthDust, 1));
				player.inventory.consumeInventoryItem(Earth.earthPearl.itemID);
			}
			if (world.getBlockId(x, y, z) == Block.oreCoal.blockID) {
				if (!world.isRemote) world.destroyBlock(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.earthDust, 2));
				player.inventory.consumeInventoryItem(Earth.earthPearl.itemID);
			}
			if (world.getBlockId(x, y, z) == Block.oreIron.blockID) {
				if (!world.isRemote) world.destroyBlock(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.earthDust, 3));
				player.inventory.consumeInventoryItem(Earth.earthPearl.itemID);
			}
			if (world.getBlockId(x, y, z) == Block.oreLapis.blockID) {
				if (!world.isRemote) world.destroyBlock(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.earthDust, 4));
				player.inventory.consumeInventoryItem(Earth.earthPearl.itemID);
			}
			if (world.getBlockId(x, y, z) == Block.oreGold.blockID) {
				if (!world.isRemote) world.destroyBlock(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.earthDust, 5));
				player.inventory.consumeInventoryItem(Earth.earthPearl.itemID);
			}
			if (world.getBlockId(x, y, z) == Block.oreDiamond.blockID) {
				if (!world.isRemote) world.destroyBlock(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.earthDust, 10));
				player.inventory.consumeInventoryItem(Earth.earthPearl.itemID);
			}
			if (world.getBlockId(x, y, z) == Block.oreNetherQuartz.blockID) {
				if (!world.isRemote) world.destroyBlock(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.earthDust, 6));
				player.inventory.consumeInventoryItem(Earth.earthPearl.itemID);
			}
			if (world.getBlockId(x, y, z) == Block.oreEmerald.blockID) {
				if (!world.isRemote) world.destroyBlock(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Earth.earthDust, 64));
				player.inventory.consumeInventoryItem(Earth.earthPearl.itemID);
			}
		}

		return false;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("simplemagic" + ":" + (this.getUnlocalizedName().substring(5)));
	}

}
