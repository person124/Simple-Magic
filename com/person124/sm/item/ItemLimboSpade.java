package com.person124.sm.item;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.person124.sm.SimpleMagic;
import com.person124.sm.element.Limbo;

public class ItemLimboSpade extends ItemSpade {

	public ItemLimboSpade(ToolMaterial material, String name) {
		super(material);
		setCreativeTab(SimpleMagic.smTab);
		setUnlocalizedName(name);
		setMaxStackSize(1);
	}

	public boolean onBlockDestroyed(ItemStack is, World world, Block block, BlockPos pos, EntityLivingBase entityLiving) {
		is.damageItem(1, entityLiving);

		EntityPlayer player = (EntityPlayer) entityLiving;

		if (world.getBlockState(pos) == Blocks.coal_ore.getBlockState().getBaseState() || world.getBlockState(pos) == Blocks.diamond_ore.getBlockState().getBaseState() || world.getBlockState(pos) == Blocks.emerald_ore.getBlockState().getBaseState() || world.getBlockState(pos) == Blocks.gold_ore.getBlockState().getBaseState() || world.getBlockState(pos) == Blocks.iron_ore.getBlockState().getBaseState() || world.getBlockState(pos) == Blocks.lapis_ore.getBlockState().getBaseState() || world.getBlockState(pos) == Blocks.quartz_ore.getBlockState().getBaseState() || world.getBlockState(pos) == Blocks.redstone_ore.getBlockState().getBaseState()) {
			if (world.getBlockState(pos) == Blocks.coal_ore.getBlockState().getBaseState()) player.inventory.addItemStackToInventory(new ItemStack(Items.coal, 5));
			if (world.getBlockState(pos) == Blocks.diamond_ore.getBlockState().getBaseState()) player.inventory.addItemStackToInventory(new ItemStack(Items.diamond, 3));
			if (world.getBlockState(pos) == Blocks.emerald_ore.getBlockState().getBaseState()) player.inventory.addItemStackToInventory(new ItemStack(Items.emerald, 5));
			if (world.getBlockState(pos) == Blocks.gold_ore.getBlockState().getBaseState()) player.inventory.addItemStackToInventory(new ItemStack(Items.gold_ingot, 3));
			if (world.getBlockState(pos) == Blocks.iron_ore.getBlockState().getBaseState()) player.inventory.addItemStackToInventory(new ItemStack(Items.iron_ingot, 3));
			if (world.getBlockState(pos) == Blocks.lapis_ore.getBlockState().getBaseState()) player.inventory.addItemStackToInventory(new ItemStack(Items.dye, 10, 4));
			if (world.getBlockState(pos) == Blocks.quartz_ore.getBlockState().getBaseState()) player.inventory.addItemStackToInventory(new ItemStack(Items.quartz, 5));
			if (world.getBlockState(pos) == Blocks.redstone_ore.getBlockState().getBaseState()) player.inventory.addItemStackToInventory(new ItemStack(Items.redstone, 10));

			is.damageItem(19, entityLiving);
		}

		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack is, ItemStack other) {
		if (other.getItem() == Limbo.LIMBO_INGOT) return true;
		return false;
	}
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return false;
	}

}
