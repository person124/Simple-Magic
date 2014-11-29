package com.person124.sm.element;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.person124.sm.SimpleMagic;
import com.person124.sm.block.BlockBasic;
import com.person124.sm.block.BlockCursed;
import com.person124.sm.item.ItemArmorAlmighty;
import com.person124.sm.item.ItemBasic;
import com.person124.sm.item.ItemLimboPearl;
import com.person124.sm.item.ItemLimboSpade;

import cpw.mods.fml.common.registry.GameRegistry;

public class Limbo {

	public static final ToolMaterial LIMBO_TOOL_MATERIAL = EnumHelper.addToolMaterial("LIMBOTOOL", 7, 200, 100.0F, 1, 0);

	public static final Item LIMBO_PEARL = new ItemLimboPearl("limbopearl");
	public static final Item LIMBO_DUST = new ItemBasic("limbodust", 64);
	public static final Item LIMBO_INGOT = new ItemBasic("limboingot", 64);
	public static final Item LIMBO_SPADE = new ItemLimboSpade(LIMBO_TOOL_MATERIAL, "limbospade");
	public static final Item LIMBO_LEGGINGS = new ItemArmorAlmighty(SimpleMagic.ELEMENT_ALMIGHTY_ARMOR_MATERIAL, 2, "limboarmor");

	public static final Block CURSED_DIRT = new BlockCursed("curseddirt", 0);
	public static final Block CURSED_STONE = new BlockCursed("cursedstone", 1);
	public static final Block CURSED_LOG = new BlockCursed("cursedlog", 2);
	public static final Block LIMBO_BLOCK = new BlockBasic(Material.cactus, "limboblock", 3.0F, Block.soundTypeGravel, "pickaxe", 2);

	public static void init() {
		SimpleMagic.registerItem(LIMBO_PEARL);
		SimpleMagic.registerItem(LIMBO_DUST);
		SimpleMagic.registerItem(LIMBO_INGOT);
		SimpleMagic.registerItem(LIMBO_SPADE);
		SimpleMagic.registerItem(LIMBO_LEGGINGS);

		SimpleMagic.registerBlock(CURSED_DIRT);
		SimpleMagic.registerBlock(CURSED_STONE);
		SimpleMagic.registerBlock(CURSED_LOG);
		SimpleMagic.registerBlock(LIMBO_BLOCK);

		GameRegistry.addSmelting(LIMBO_BLOCK, new ItemStack(LIMBO_INGOT, 1), 0.24F);
		GameRegistry.addRecipe(new ItemStack(LIMBO_SPADE, 1), new Object[] { "!", "@", "@", '!', new ItemStack(LIMBO_INGOT, 1), '@', new ItemStack(Items.stick, 1) });
		GameRegistry.addRecipe(new ItemStack(LIMBO_LEGGINGS, 1), new Object[] { "!!!", "! !", "! !", '!', new ItemStack(LIMBO_INGOT, 1) });

		GameRegistry.addRecipe(new ItemStack(LIMBO_BLOCK, 1), new Object[] { "!!!", "!!!", "!!!", '!', new ItemStack(LIMBO_DUST, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(LIMBO_DUST, 9), new ItemStack(LIMBO_BLOCK, 1));
		
	}

}
