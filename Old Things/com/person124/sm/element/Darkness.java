package com.person124.sm.element;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import com.person124.sm.block.BlockBasic;
import com.person124.sm.common.mod_SimpleMagic;
import com.person124.sm.item.ItemArmorSub;
import com.person124.sm.item.ItemBasic;
import com.person124.sm.item.ItemDarkPearl;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Darkness {

	private static final int id = mod_SimpleMagic.darkID;
	private static EnumArmorMaterial elesub = mod_SimpleMagic.ELEMENTSUB;

	public static final Item darkPearl = new ItemDarkPearl(id, "sm-darkpearl", 1, mod_SimpleMagic.smTab);
	public static final Item darkDust = new ItemBasic(id + 1, "sm-darkdust", 64, mod_SimpleMagic.smTab);
	public static final Block darkBlock = new BlockBasic(id + 2, Material.ground, "sm-darkblock", mod_SimpleMagic.smTab, 3.0F, Block.soundSandFootstep, 0.0F, false);
	public static final Item darkIngot = new ItemBasic(id + 3, "sm-darkingot", 64, mod_SimpleMagic.smTab);
	public static final Item darkHelmet = new ItemArmorSub(id + 4, elesub, 1, 0, "sm-darkarmor", mod_SimpleMagic.smTab);

	public static void load() {
		LanguageRegistry.addName(darkPearl, "Darkness Pearl");

		LanguageRegistry.addName(darkDust, "Darkness Dust");

		LanguageRegistry.addName(darkBlock, "Darkness Dust Block");
		MinecraftForge.setBlockHarvestLevel(darkBlock, "pickaxe", 2);
		GameRegistry.registerBlock(darkBlock);
		GameRegistry.addRecipe(new ItemStack(darkBlock), new Object[] { "***", "***", "***", '*', new ItemStack(darkDust) });
		GameRegistry.addShapelessRecipe(new ItemStack(darkDust, 9), new ItemStack(darkBlock));

		LanguageRegistry.addName(darkIngot, "Darkness Ingot");
		GameRegistry.addSmelting(darkBlock.blockID, new ItemStack(darkIngot), 0.2F);

		LanguageRegistry.addName(darkHelmet, "The Shadow Helm");
		GameRegistry.addRecipe(new ItemStack(darkHelmet), new Object[] { "***", "* *", '*', new ItemStack(darkIngot) });
	}

}
