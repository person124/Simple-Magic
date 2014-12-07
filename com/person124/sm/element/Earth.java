package com.person124.sm.element;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.person124.sm.SimpleMagic;
import com.person124.sm.block.BlockBasic;
import com.person124.sm.item.ItemArmorMain;
import com.person124.sm.item.ItemBasic;
import com.person124.sm.item.ItemBasicPickaxe;
import com.person124.sm.item.ItemBasicShiny;
import com.person124.sm.item.ItemEarthPearl;

import cpw.mods.fml.common.registry.GameRegistry;

public class Earth {

	public static final ToolMaterial EARTH_TOOL_MATERIAL = EnumHelper.addToolMaterial("EARTHTOOL", 2, 500, 5.0F, 2, 100);

	public static final Item EARTH_PEARL = new ItemEarthPearl("earthpearl");
	public static final Item EARTH_DUST = new ItemBasic("earthdust", 64);
	public static final Item EARTH_INGOT = new ItemBasic("earthingot", 64);
	public static final Item EARTH_CHESTPLATE = new ItemArmorMain(SimpleMagic.ELEMENT_MAIN_ARMOR_MATERIAL, 1, "eartharmor");
	public static final Item EARTH_PICKAXE = new ItemBasicPickaxe(EARTH_TOOL_MATERIAL, "earthpickaxe");
	public static final Item EARTH_ORB = new ItemBasic("earthorb", 64);
	public static final Item EARTH_GEM = new ItemBasicShiny("earthgem", 64);

	public static final Block EARTH_BLOCK = new BlockBasic(Material.ground, "earthblock", 3.0F, Block.soundTypeMetal, "pickaxe", 2);
	public static final Block EARTH_GEM_BLOCK = new BlockBasic(Material.ground, "earthgemblock", 5.0F, Block.soundTypeGravel, "pickaxe", 2);

	public static void init() {
		SimpleMagic.registerItem(EARTH_PEARL);
		SimpleMagic.registerItem(EARTH_DUST);
		SimpleMagic.registerItem(EARTH_INGOT);
		SimpleMagic.registerItem(EARTH_CHESTPLATE);
		SimpleMagic.registerItem(EARTH_PICKAXE);
		SimpleMagic.registerItem(EARTH_ORB);
		SimpleMagic.registerItem(EARTH_GEM);

		SimpleMagic.registerBlock(EARTH_BLOCK);
		SimpleMagic.registerBlock(EARTH_GEM_BLOCK);

		GameRegistry.addSmelting(EARTH_BLOCK, new ItemStack(EARTH_INGOT, 1), 0.2F);
		GameRegistry.addShapedRecipe(new ItemStack(EARTH_CHESTPLATE, 1), new Object[] { "! !", "!!!", "!!!", '!', new ItemStack(EARTH_INGOT, 1) });
		GameRegistry.addShapedRecipe(new ItemStack(EARTH_PICKAXE, 1), new Object[] { "!!!", " @ ", " @ ", '!', new ItemStack(EARTH_INGOT, 1), '@', new ItemStack(Items.stick, 1) });
		GameRegistry.addShapedRecipe(new ItemStack(EARTH_ORB, 1), new Object[] { "!@!", "@#@", "!@!", '!', new ItemStack(EARTH_INGOT, 1), '@', new ItemStack(Blocks.glass, 1), '#', new ItemStack(EARTH_BLOCK, 1) });
		GameRegistry.addShapedRecipe(new ItemStack(EARTH_GEM, 1), new Object[] { "!!!", "!@!", "!!!", '!', new ItemStack(Blocks.glass, 1), '@', new ItemStack(EARTH_ORB, 1) });

		GameRegistry.addRecipe(new ItemStack(EARTH_BLOCK, 1), new Object[] { "!!!", "!!!", "!!!", '!', new ItemStack(EARTH_DUST, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(EARTH_DUST, 9), new ItemStack(EARTH_BLOCK, 1));
		GameRegistry.addRecipe(new ItemStack(EARTH_GEM_BLOCK, 1), new Object[] { "!!!", "!!!", "!!!", '!', new ItemStack(EARTH_GEM, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(EARTH_GEM, 9), new ItemStack(EARTH_GEM_BLOCK, 1));
	}

}
