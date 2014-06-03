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
import com.person124.sm.item.ItemArmorMain;
import com.person124.sm.item.ItemBasic;
import com.person124.sm.item.ItemBasicPickaxe;
import com.person124.sm.item.ItemEarthPearl;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Earth {

	private static final int id = mod_SimpleMagic.earthID;
	private static EnumArmorMaterial elemain = mod_SimpleMagic.ELEMENTMAIN;
	private static EnumToolMaterial earthTool = EnumHelper.addToolMaterial("EARTHTOOL", 2, 500, 5.0F, 2, 100);

	public static final Item earthPearl = new ItemEarthPearl(id, "sm-earthpearl", 1, mod_SimpleMagic.smTab);
	public static final Item earthDust = new ItemBasic(id + 2, "sm-earthdust", 64, mod_SimpleMagic.smTab);
	public static final Block earthBlock = new BlockBasic(id + 3, Material.ground, "sm-earthblock", mod_SimpleMagic.smTab, 3.0F, Block.soundMetalFootstep, 0.0F, false);
	public static final Item earthIngot = new ItemBasic(id + 4, "sm-earthingot", 64, mod_SimpleMagic.smTab);
	public static final Item earthChest = new ItemArmorMain(id + 5, elemain, 1, 1, "sm-eartharmor", mod_SimpleMagic.smTab);
	public static final Item earthPick = new ItemBasicPickaxe(id + 6, earthTool, "sm-earthpickaxe", mod_SimpleMagic.smTab);
	
	public static void load() {
		LanguageRegistry.addName(earthPearl, "Earth Pearl");

		LanguageRegistry.addName(earthDust, "Earth Dust");

		LanguageRegistry.addName(earthBlock, "Earth Dust Block");
		MinecraftForge.setBlockHarvestLevel(earthBlock, "pickaxe", 2);
		GameRegistry.registerBlock(earthBlock);
		GameRegistry.addRecipe(new ItemStack(Earth.earthBlock, 1), new Object[] { "***", "***", "***", '*', new ItemStack(Earth.earthDust, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(Earth.earthDust, 9), new ItemStack(Earth.earthBlock, 1));
	
		LanguageRegistry.addName(earthIngot, "Earth Ingot");
		GameRegistry.addSmelting(Earth.earthBlock.blockID, new ItemStack(Earth.earthIngot, 1), 0.0F);
		
		LanguageRegistry.addName(earthChest, "Chestplate of the Earth");
		GameRegistry.addRecipe(new ItemStack(Earth.earthChest, 1), new Object[] { "* *", "***", "***", '*', new ItemStack(Earth.earthIngot, 1) });
	
		LanguageRegistry.addName(earthPick, "Pickaxe of the Earth");
		GameRegistry.addRecipe(new ItemStack(Earth.earthPick, 1), new Object[] { "***", " & ", " & ", '*', new ItemStack(Earth.earthIngot, 1), '&', new ItemStack(Item.stick, 1) });
	}

}
