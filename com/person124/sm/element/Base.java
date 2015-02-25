package com.person124.sm.element;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.person124.sm.SimpleMagic;
import com.person124.sm.block.BlockBasic;
import com.person124.sm.block.BlockSummonCircle;
import com.person124.sm.block.BlockSummonCircleMiddle;
import com.person124.sm.block.BlockSummonCirclePower;
import com.person124.sm.block.BlockSummonCirclePowerMiddle;
import com.person124.sm.item.ItemBasic;

public class Base {
	
	public static final Item MAGIC_DUST = new ItemBasic("magicdust", 64);
	public static final Item MAGIC_ORB = new ItemBasic("magicorb", 64);
	public static final Item MAGIC_DUST_INGOT = new ItemBasic("magicingot", 64);

	public static final Block MAGIC_DUST_BLOCK = new BlockBasic(Material.iron, "magicblock", 2.0F, Block.soundTypeCloth, "pickaxe", 1);
	public static final Block SUMMON_CIRCLE = new BlockSummonCircle("summoncircleblock");
	public static final Block SUMMON_CIRCLE_MIDDLE = new BlockSummonCircleMiddle("summoncircleblockmid");
	public static final Block SUMMON_CIRCLE_POWER = new BlockSummonCirclePower("summoncircleedge");
	public static final Block SUMMON_CIRCLE_POWER_MIDDLE = new BlockSummonCirclePowerMiddle("summoncircleedgemid");
	
	public static void init() {
		SimpleMagic.registerItem(MAGIC_DUST);
		SimpleMagic.registerItem(MAGIC_ORB);
		SimpleMagic.registerItem(MAGIC_DUST_INGOT);

		SimpleMagic.registerBlock(MAGIC_DUST_BLOCK);
		SimpleMagic.registerBlock(SUMMON_CIRCLE);
		SimpleMagic.registerBlock(SUMMON_CIRCLE_MIDDLE);
		SimpleMagic.registerBlock(SUMMON_CIRCLE_POWER);
		SimpleMagic.registerBlock(SUMMON_CIRCLE_POWER_MIDDLE);
		
		GameRegistry.addSmelting(Items.redstone, new ItemStack(MAGIC_DUST, 10), 1.5F);
		GameRegistry.addRecipe(new ItemStack(MAGIC_ORB, 1), new Object[] { "!@!", "@#@", "!@!", '!', new ItemStack(MAGIC_DUST_INGOT, 1), '@', new ItemStack(Blocks.glass, 1), '#', new ItemStack(MAGIC_DUST_BLOCK, 1) });
		GameRegistry.addSmelting(MAGIC_DUST_BLOCK, new ItemStack(MAGIC_DUST_INGOT, 1), 0.0F);
		
		GameRegistry.addRecipe(new ItemStack(MAGIC_DUST_BLOCK, 1), new Object[] { "!!!", "!!!", "!!!", '!', new ItemStack(MAGIC_DUST, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(MAGIC_DUST, 9), new ItemStack(MAGIC_DUST_BLOCK, 1));
		GameRegistry.addSmelting(Blocks.redstone_block, new ItemStack(MAGIC_DUST_BLOCK, 10), 6.7F);
		GameRegistry.addRecipe(new ItemStack(SUMMON_CIRCLE, 1), new Object[] { "   ", "@@@", "!!!", '!', new ItemStack(Blocks.wool, 1, 15), '@', new ItemStack(Items.redstone, 1) });
		GameRegistry.addRecipe(new ItemStack(SUMMON_CIRCLE_MIDDLE, 1), new Object[] { "   ", "#@#", "!!!", '!', new ItemStack(Blocks.wool, 1, 15), '@', new ItemStack(MAGIC_ORB, 1), '#', new ItemStack(Items.redstone, 1) });
	}

}
