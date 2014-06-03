package com.person124.sm.item;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.person124.sm.SimpleMagic;

public class ItemLimboSpade extends ItemSpade {

	public ItemLimboSpade(ToolMaterial material, String name) {
		super(material);
		setCreativeTab(SimpleMagic.smTab);
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setTextureName("simplemagic:" + name);
	}
	
	public boolean onBlockDestroyed(ItemStack is, World world, Block block, int x, int y, int z, EntityLivingBase entityLiving) {
		is.damageItem(1, entityLiving);

		EntityPlayer player = (EntityPlayer) entityLiving;

		if (world.getBlock(x, y, z) == Blocks.coal_ore || world.getBlock(x, y, z) == Blocks.diamond_ore || world.getBlock(x, y, z) == Blocks.emerald_ore || world.getBlock(x, y, z) == Blocks.gold_ore || world.getBlock(x, y, z) == Blocks.iron_ore || world.getBlock(x, y, z) == Blocks.lapis_ore || world.getBlock(x, y, z) == Blocks.quartz_ore || world.getBlock(x, y, z) == Blocks.redstone_ore) {
			if (world.getBlock(x, y, z) == Blocks.coal_ore) player.inventory.addItemStackToInventory(new ItemStack(Items.coal, 5));
			if (world.getBlock(x, y, z) == Blocks.diamond_ore) player.inventory.addItemStackToInventory(new ItemStack(Items.diamond, 3));
			if (world.getBlock(x, y, z) == Blocks.emerald_ore) player.inventory.addItemStackToInventory(new ItemStack(Items.emerald, 5));
			if (world.getBlock(x, y, z) == Blocks.gold_ore) player.inventory.addItemStackToInventory(new ItemStack(Items.gold_ingot, 3));
			if (world.getBlock(x, y, z) == Blocks.iron_ore) player.inventory.addItemStackToInventory(new ItemStack(Items.iron_ingot, 3));
			if (world.getBlock(x, y, z) == Blocks.lapis_ore) player.inventory.addItemStackToInventory(new ItemStack(Items.dye, 10, 4));
			if (world.getBlock(x, y, z) == Blocks.quartz_ore) player.inventory.addItemStackToInventory(new ItemStack(Items.quartz, 5));
			if (world.getBlock(x, y, z) == Blocks.redstone_ore) player.inventory.addItemStackToInventory(new ItemStack(Items.redstone, 10));
			
			is.damageItem(19, entityLiving);
		}

		return true;
	}

}
