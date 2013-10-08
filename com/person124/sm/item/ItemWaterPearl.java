package com.person124.sm.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.person124.sm.element.Water;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWaterPearl extends Item{
	
	public ItemWaterPearl(int id, String name, int size, CreativeTabs tab) {
		super(id);
		
		this.setUnlocalizedName(name);
		this.setMaxStackSize(size);
		this.setCreativeTab(tab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("simplemagic" + ":" + (this.getUnlocalizedName().substring(5)));
	}

	
	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		
		for(int xa = 0; xa < 3; xa++) {
			for(int ya = 0; ya < 3; ya++) {
				for(int za = 0; za < 3; za++) {
					int xb = xa - 1;
					int yb = ya - 1;
					int zb = za - 1;
					if(world.getBlockId(x + xb, y + yb, z + zb) == Block.waterStill.blockID) {
						world.setBlock(x + xb, y + yb, z + zb, Block.ice.blockID);
						player.inventory.consumeInventoryItem(Water.waterPearl.itemID);
						player.inventory.addItemStackToInventory(new ItemStack(Water.waterDust, 1));
					}
				}
			}
		}
		
		return true;
	}

}
