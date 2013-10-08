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
import com.person124.sm.block.BlockCursed;
import com.person124.sm.common.mod_SimpleMagic;
import com.person124.sm.item.ItemArmorAlmighty;
import com.person124.sm.item.ItemBasic;
import com.person124.sm.item.ItemLimboPearl;
import com.person124.sm.item.ItemLimboSpade;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Limbo {
	
	private static final int id = mod_SimpleMagic.limboID;
	private static EnumToolMaterial limboTool = EnumHelper.addToolMaterial("LIMBOTOOL", 7, 200, 100.0F, 1, 0);
	private static EnumArmorMaterial limboArmor = mod_SimpleMagic.ELEMENTALMIGHTY;
	
	public static final Item limboPearl = new ItemLimboPearl(id, "sm-limbopearl", 1, mod_SimpleMagic.smTab);
	public static final Block cursedDirt = new BlockCursed(id + 1, Material.air, "sm-curseddirt", mod_SimpleMagic.smTab, 5.0F, Block.soundAnvilFootstep, 0.0F, false, 0);
	public static final Block cursedStone = new BlockCursed(id + 2, Material.air, "sm-cursedstone", mod_SimpleMagic.smTab, 5.0F, Block.soundAnvilFootstep, 0.0F, false, 1);
	public static final Block cursedLog = new BlockCursed(id + 3, Material.air, "sm-cursedlog", mod_SimpleMagic.smTab, 5.0F, Block.soundAnvilFootstep, 0.0F, false, 2);
	public static final Item limboDust = new ItemBasic(id + 4, "sm-limbodust", 64, mod_SimpleMagic.smTab);
	public static final Block limboBlock = new BlockBasic(id + 5, Material.cactus, "sm-limboblock", mod_SimpleMagic.smTab, 3.0F, Block.soundGravelFootstep, 0.0F, false);
	public static final Item limboIngot = new ItemBasic(id + 6, "sm-limboingot", 64, mod_SimpleMagic.smTab);
	public static final Item limboSpade = new ItemLimboSpade(id + 7, limboTool, "sm-limbospade", mod_SimpleMagic.smTab);
	public static final Item limboLeggings = new ItemArmorAlmighty(id + 8, limboArmor, 1, 2, "sm-limboarmor", mod_SimpleMagic.smTab);
	
	public static void load() {
		LanguageRegistry.addName(limboPearl, "Limbo Pearl");

		LanguageRegistry.addName(cursedDirt, "Cursed Dirt");
		GameRegistry.registerBlock(cursedDirt);

		LanguageRegistry.addName(cursedStone, "Cursed Stone");
		GameRegistry.registerBlock(cursedStone);

		LanguageRegistry.addName(cursedLog, "Cursed Log");
		GameRegistry.registerBlock(cursedLog);
		
		LanguageRegistry.addName(limboDust, "Limbo Dust");
		
		LanguageRegistry.addName(limboBlock, "Limbo Dust Block");
		MinecraftForge.setBlockHarvestLevel(limboBlock, "pickaxe", 2);
		GameRegistry.registerBlock(limboBlock);
		GameRegistry.addRecipe(new ItemStack(Limbo.limboBlock, 1), new Object[] { "***", "***", "***", '*', new ItemStack(Limbo.limboDust, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(Limbo.limboDust, 9), new ItemStack(Limbo.limboBlock, 1));
	
		LanguageRegistry.addName(limboIngot, "Limbo Ingot");
		GameRegistry.addSmelting(Limbo.limboBlock.blockID, new ItemStack(Limbo.limboIngot, 1), 0.0F);
		
		LanguageRegistry.addName(limboSpade, "Shovel from Limbo");
		GameRegistry.addRecipe(new ItemStack(Limbo.limboSpade, 1), new Object[] { "*", "&", "&", '*', new ItemStack(Limbo.limboIngot, 1), '&', new ItemStack(Item.stick, 1) });
	
		LanguageRegistry.addName(limboLeggings, "Leggings from Limbo");
		GameRegistry.addRecipe(new ItemStack(Limbo.limboLeggings, 1), new Object[] { "***", "* *", "* *", '*', new ItemStack(Limbo.limboIngot, 1) });
	}

}
