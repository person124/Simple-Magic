package com.person124.sm.element;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import com.person124.sm.block.BlockBasic;
import com.person124.sm.common.mod_SimpleMagic;
import com.person124.sm.item.ItemArmorMain;
import com.person124.sm.item.ItemBasic;
import com.person124.sm.item.ItemWaterDagger;
import com.person124.sm.item.ItemWaterPearl;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Water {

	private static final int id = mod_SimpleMagic.waterID;
	private static EnumArmorMaterial mainarmor = mod_SimpleMagic.ELEMENTMAIN;

	public static final Item waterPearl = new ItemWaterPearl(id, "sm-waterpearl", 1, mod_SimpleMagic.smTab);
	public static final Item waterDust = new ItemBasic(id + 1, "sm-waterdust", 64, mod_SimpleMagic.smTab);
	public static final Block waterBlock = new BlockBasic(id + 2, Material.water, "sm-waterblock", mod_SimpleMagic.smTab, 2.0F, Block.soundGravelFootstep, 0.0F, false);
	public static final Item waterIngot = new ItemBasic(id + 3, "sm-wateringot", 64, mod_SimpleMagic.smTab);
	public static final Item waterHelmet = new ItemArmorMain(id + 4, mainarmor, 1, 0, "sm-waterarmor", mod_SimpleMagic.smTab);
	public static final Item waterDagger = new ItemWaterDagger(id + 5, "sm-waterdagger", 1, mod_SimpleMagic.smTab);

	public static void load() {
		LanguageRegistry.addName(waterPearl, "Water Pearl");

		LanguageRegistry.addName(waterDust, "Water Dust");

		LanguageRegistry.addName(waterBlock, "Water Dust Block");
		GameRegistry.registerBlock(waterBlock);
		MinecraftForge.setBlockHarvestLevel(waterBlock, "pickaxe", 2);
		GameRegistry.addRecipe(new ItemStack(waterBlock, 1), new Object[] { "***", "***", "***", '*', new ItemStack(waterDust, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(waterDust, 9), new ItemStack(waterBlock, 1));

		LanguageRegistry.addName(waterIngot, "Water Ingot");
		GameRegistry.addSmelting(waterBlock.blockID, new ItemStack(waterIngot, 1), 0.0F);

		LanguageRegistry.addName(waterHelmet, "Helmet of the Water");
		GameRegistry.addRecipe(new ItemStack(waterHelmet), new Object[] { "***", "* *", '*', new ItemStack(waterIngot) });

		LanguageRegistry.addName(waterDagger, "Dagger of the Water");
		GameRegistry.addRecipe(new ItemStack(waterDagger), new Object[] { "*", "&", '*', new ItemStack(waterIngot), '&', new ItemStack(Item.stick) });
	}

}
