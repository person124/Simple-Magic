package com.person124.sm.element;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.person124.sm.block.BlockBasic;
import com.person124.sm.block.BlockCursed;
import com.person124.sm.item.ItemBasic;
import com.person124.sm.item.ItemLimboPearl;
import com.person124.sm.item.ItemLimboSpade;

import cpw.mods.fml.common.registry.GameRegistry;

public class Limbo {

	public static final ToolMaterial LIMBO_TOOL_MATERIAL = EnumHelper.addToolMaterial("LIMBOTOOL", 7, 200, 100.0F, 1, 0);

	public static final Item LIMBO_PEARL = new ItemLimboPearl("sm-limbopearl");
	public static final Item LIMBO_DUST = new ItemBasic("sm-limbodust", 64);
	public static final Item LIMBO_INGOT = new ItemBasic("sm-limboingot", 64);
	public static final Item LIMBO_SPADE = new ItemLimboSpade(LIMBO_TOOL_MATERIAL, "sm-limbospade");

	public static final Block CURSED_DIRT = new BlockCursed("sm-curseddirt", 0);
	public static final Block CURSED_STONE = new BlockCursed("sm-cursedstone", 1);
	public static final Block CURSED_LOG = new BlockCursed("sm-cursedlog", 2);
	public static final Block LIMBO_BLOCK = new BlockBasic(Material.cactus, "sm-limboblock", 3.0F, Block.soundTypeGravel, "pickaxe", 2);

	public static void init() {
		GameRegistry.registerItem(LIMBO_PEARL, LIMBO_PEARL.getUnlocalizedName());
		GameRegistry.registerItem(LIMBO_DUST, LIMBO_DUST.getUnlocalizedName());
		GameRegistry.registerItem(LIMBO_INGOT, LIMBO_INGOT.getUnlocalizedName());
		GameRegistry.registerItem(LIMBO_SPADE, LIMBO_SPADE.getUnlocalizedName());

		GameRegistry.registerBlock(CURSED_DIRT, CURSED_DIRT.getUnlocalizedName());
		GameRegistry.registerBlock(CURSED_STONE, CURSED_STONE.getUnlocalizedName());
		GameRegistry.registerBlock(CURSED_LOG, CURSED_LOG.getUnlocalizedName());
		GameRegistry.registerBlock(LIMBO_BLOCK, LIMBO_BLOCK.getUnlocalizedName());

		GameRegistry.addSmelting(LIMBO_BLOCK, new ItemStack(LIMBO_INGOT, 1), 0.24F);
		GameRegistry.addRecipe(new ItemStack(LIMBO_SPADE, 1), new Object[] { "!", "@", "@", '!', new ItemStack(LIMBO_INGOT, 1), '@', new ItemStack(Items.stick, 1) });

		GameRegistry.addRecipe(new ItemStack(LIMBO_BLOCK, 1), new Object[] { "!!!", "!!!", "!!!", '!', new ItemStack(LIMBO_DUST, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(LIMBO_DUST, 9), new ItemStack(LIMBO_BLOCK, 1));
	}

}
