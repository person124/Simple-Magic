package com.person124.sm.item;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.person124.sm.element.Limbo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLimboPearl extends Item {
	
	public ItemLimboPearl(int id, String name, int size, CreativeTabs tab) {
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
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		
		if (Minecraft.getMinecraft().objectMouseOver != null) {
			int x = Minecraft.getMinecraft().objectMouseOver.blockX;
			int y = Minecraft.getMinecraft().objectMouseOver.blockY;
			int z = Minecraft.getMinecraft().objectMouseOver.blockZ;
			boolean done = false;

			if (world.getBlockId(x, y, z) == Block.dirt.blockID || world.getBlockId(x, y, z) == Block.grass.blockID) {
				if (!world.isRemote) world.setBlock(x, y, z, Limbo.cursedDirt.blockID, 0, 2);
				world.spawnParticle("hugeexplosion", x + .5, y - .5, z + .5, 0.0, 0.0, 0.0);
				player.inventory.consumeInventoryItem(Limbo.limboPearl.itemID);
				done = true;
			}
			if (world.getBlockId(x, y, z) == Block.stone.blockID || world.getBlockId(x, y, z) == Block.oreIron.blockID || world.getBlockId(x, y, z) == Block.oreCoal.blockID || world.getBlockId(x, y, z) == Block.oreDiamond.blockID || world.getBlockId(x, y, z) == Block.oreRedstone.blockID || world.getBlockId(x, y, z) == Block.oreEmerald.blockID) {
				if (!world.isRemote) world.setBlock(x, y, z, Limbo.cursedStone.blockID, 0, 2);
				world.spawnParticle("hugeexplosion", x + .5, y - .5, z + .5, 0.0, 0.0, 0.0);
				player.inventory.consumeInventoryItem(Limbo.limboPearl.itemID);
				done = true;
			}
			if (world.getBlockId(x, y, z) == Block.wood.blockID || world.getBlockId(x, y, z) == Block.wood.blockID) {
				if (!world.isRemote) world.setBlock(x, y, z, Limbo.cursedLog.blockID, 0, 2);
				world.spawnParticle("hugeexplosion", x + .5, y - .5, z + .5, 0.0, 0.0, 0.0);
				player.inventory.consumeInventoryItem(Limbo.limboPearl.itemID);
				done = true;
			}
			if (world.getBlockId(x, y, z) == Limbo.cursedDirt.blockID || world.getBlockId(x, y, z) == Limbo.cursedLog.blockID || world.getBlockId(x, y, z) == Limbo.cursedStone.blockID) {
				if (!done) {
					if (!world.isRemote) world.destroyBlock(x, y, z, false);
					player.inventory.addItemStackToInventory(new ItemStack(Limbo.limboDust, 3));
				}
			}

		}
		return true;
	}

}
