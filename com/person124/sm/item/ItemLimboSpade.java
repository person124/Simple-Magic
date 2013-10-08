package com.person124.sm.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLimboSpade extends ItemSpade {

	public ItemLimboSpade(int id, EnumToolMaterial par2EnumToolMaterial, String name, CreativeTabs tab) {
		super(id, par2EnumToolMaterial);

		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);
		this.setMaxStackSize(1);
		this.setMaxDamage(200);
	}

	public boolean canHarvestBlock(Block par1Block) {
		return par1Block == Block.snow ? true : par1Block == Block.blockSnow;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("simplemagic" + ":" + (this.getUnlocalizedName().substring(5)));
	}

	@Override
	public boolean onBlockDestroyed(ItemStack is, World world, int par3, int x, int y, int z, EntityLivingBase entity) {
		is.damageItem(1, entity);

		EntityPlayer player = (EntityPlayer) entity;

		if (world.getBlockId(x, y, z) == Block.oreCoal.blockID || world.getBlockId(x, y, z) == Block.oreDiamond.blockID || world.getBlockId(x, y, z) == Block.oreEmerald.blockID || world.getBlockId(x, y, z) == Block.oreGold.blockID || world.getBlockId(x, y, z) == Block.oreIron.blockID || world.getBlockId(x, y, z) == Block.oreLapis.blockID || world.getBlockId(x, y, z) == Block.oreNetherQuartz.blockID || world.getBlockId(x, y, z) == Block.oreRedstone.blockID || world.getBlockId(x, y, z) == Block.oreRedstoneGlowing.blockID) {
			if (world.getBlockId(x, y, z) == Block.oreCoal.blockID) player.inventory.addItemStackToInventory(new ItemStack(Item.coal, 5));
			if (world.getBlockId(x, y, z) == Block.oreDiamond.blockID) player.inventory.addItemStackToInventory(new ItemStack(Item.diamond, 3));
			if (world.getBlockId(x, y, z) == Block.oreEmerald.blockID) player.inventory.addItemStackToInventory(new ItemStack(Item.emerald, 5));
			if (world.getBlockId(x, y, z) == Block.oreGold.blockID) player.inventory.addItemStackToInventory(new ItemStack(Item.ingotGold, 3));
			if (world.getBlockId(x, y, z) == Block.oreIron.blockID) player.inventory.addItemStackToInventory(new ItemStack(Item.ingotIron, 3));
			if (world.getBlockId(x, y, z) == Block.oreLapis.blockID) player.inventory.addItemStackToInventory(new ItemStack(Item.dyePowder, 10, 4));
			if (world.getBlockId(x, y, z) == Block.oreNetherQuartz.blockID) player.inventory.addItemStackToInventory(new ItemStack(Item.netherQuartz, 5));
			if (world.getBlockId(x, y, z) == Block.oreRedstone.blockID || world.getBlockId(x, y, z) == Block.oreRedstoneGlowing.blockID) player.inventory.addItemStackToInventory(new ItemStack(Item.redstone, 10));

			is.damageItem(19, entity);
		}

		return true;
	}

}
