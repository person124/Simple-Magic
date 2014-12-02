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
import com.person124.sm.item.ItemArmorMain;
import com.person124.sm.item.ItemBasic;
import com.person124.sm.item.ItemFirePearl;
import com.person124.sm.item.ItemFireSword;

import cpw.mods.fml.common.registry.GameRegistry;

public class Fire {

	public static final ToolMaterial FIRE_TOOL_MATERIAL = EnumHelper.addToolMaterial("FIRETOOL", 1, 425, 25.0F, 2, 0);

	public static final Item FIRE_PEARL = new ItemFirePearl("firepearl");
	public static final Item FIRE_DUST = new ItemBasic("firedust", 64);
	public static final Item FIRE_INGOT = new ItemBasic("fireingot", 64);
	public static final Item FIRE_SWORD = new ItemFireSword(FIRE_TOOL_MATERIAL, "firesword");
	public static final Item FIRE_LEGGINGS = new ItemArmorMain(SimpleMagic.ELEMENT_MAIN_ARMOR_MATERIAL, 2, "firearmor");

	public static final Block FIRE_BLOCK = new BlockBasic(Material.fire, "fireblock", 1.0F, Block.soundTypePiston, null, 0);

	public static void init() {
		SimpleMagic.registerItem(FIRE_PEARL);
		SimpleMagic.registerItem(FIRE_DUST);
		SimpleMagic.registerItem(FIRE_INGOT);
		SimpleMagic.registerItem(FIRE_SWORD);
		SimpleMagic.registerItem(FIRE_LEGGINGS);

		SimpleMagic.registerBlock(FIRE_BLOCK);

		GameRegistry.addSmelting(FIRE_BLOCK, new ItemStack(FIRE_INGOT, 1), 0.25F);
		GameRegistry.addRecipe(new ItemStack(FIRE_SWORD, 1), new Object[] { "!", "!", "@", '!', new ItemStack(FIRE_INGOT, 1), '@', new ItemStack(Items.stick, 1) });
		GameRegistry.addRecipe(new ItemStack(FIRE_LEGGINGS, 1), new Object[] { "!!!", "! !", "! !", '!', new ItemStack(FIRE_INGOT, 1) });

		GameRegistry.addRecipe(new ItemStack(FIRE_BLOCK, 1), new Object[] { "!!!", "!!!", "!!!", '!', new ItemStack(FIRE_DUST, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(FIRE_DUST, 9), new ItemStack(FIRE_BLOCK, 1));
	}

}