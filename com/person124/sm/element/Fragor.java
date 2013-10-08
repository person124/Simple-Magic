package com.person124.sm.element;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

import com.person124.sm.block.BlockBasic;
import com.person124.sm.common.mod_SimpleMagic;
import com.person124.sm.item.ItemArmorMinor;
import com.person124.sm.item.ItemBasic;
import com.person124.sm.item.ItemFragorSword;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Fragor {

	private static final int id = mod_SimpleMagic.fragorID;
	private static EnumArmorMaterial eleminor = mod_SimpleMagic.ELEMENTMINOR;
	private static EnumToolMaterial fragorwep = EnumHelper.addToolMaterial("FRAGORSWORD", 2, 200, 1.5F, 3, 0);

	public static final Item fragorDust = new ItemBasic(id, "sm-fragordust", 64, mod_SimpleMagic.smTab);
	public static final Block fragorBlock = new BlockBasic(id + 1, Material.cloth, "sm-fragorblock", mod_SimpleMagic.smTab, 3.0F, Block.soundClothFootstep, 0.0F, false);
	public static final Item fragorIngot = new ItemBasic(id + 2, "sm-fragoringot", 64, mod_SimpleMagic.smTab);
	public static final Item fragorChest = new ItemArmorMinor(id + 3, eleminor, 1, 1, "sm-fragorarmor", mod_SimpleMagic.smTab);
	public static final Item fragorSword = new ItemFragorSword(id + 4, fragorwep, "sm-fragorsword", mod_SimpleMagic.smTab);

	public static void load() {

		LanguageRegistry.addName(fragorDust, "Fragor Dust");
		GameRegistry.addShapelessRecipe(new ItemStack(fragorDust, 1), new ItemStack(mod_SimpleMagic.magicDust, 1), new ItemStack(Item.gunpowder, 1));

		LanguageRegistry.addName(fragorBlock, "Fragor Dust Block");
		MinecraftForge.setBlockHarvestLevel(fragorBlock, "pickaxe", 2);
		GameRegistry.registerBlock(fragorBlock);
		GameRegistry.addRecipe(new ItemStack(fragorBlock, 1), new Object[] { "***", "***", "***", '*', new ItemStack(fragorDust, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(fragorDust, 9), new ItemStack(fragorBlock, 1));

		LanguageRegistry.addName(fragorIngot, "Fragor Ingot");
		GameRegistry.addSmelting(fragorBlock.blockID, new ItemStack(fragorIngot), 0.3F);

		LanguageRegistry.addName(fragorChest, "The Creeper's Chestplate");
		GameRegistry.addRecipe(new ItemStack(fragorChest), new Object[] { "* *", "***", "***", '*', new ItemStack(fragorIngot) });

		LanguageRegistry.addName(fragorSword, "The Creeper's Sword");
		GameRegistry.addRecipe(new ItemStack(fragorSword), new Object[] { "*", "*", "&", '*', new ItemStack(fragorIngot), '&', new ItemStack(Item.stick) });
	}

}
