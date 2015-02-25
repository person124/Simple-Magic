package com.person124.sm.element;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.person124.sm.SimpleMagic;
import com.person124.sm.block.BlockBasic;
import com.person124.sm.item.ItemArmorMain;
import com.person124.sm.item.ItemBasic;
import com.person124.sm.item.ItemBasicShiny;
import com.person124.sm.item.ItemFirePearl;
import com.person124.sm.item.ItemFireSword;

public class Fire {

	public static final ToolMaterial FIRE_TOOL_MATERIAL = EnumHelper.addToolMaterial("FIRETOOL", 1, 425, 25.0F, 2, 0);

	public static final Item FIRE_PEARL = new ItemFirePearl("firepearl");
	public static final Item FIRE_DUST = new ItemBasic("firedust", 64);
	public static final Item FIRE_INGOT = new ItemBasic("fireingot", 64);
	public static final Item FIRE_SWORD = new ItemFireSword(FIRE_TOOL_MATERIAL, "firesword");
	public static final Item FIRE_LEGGINGS = new ItemArmorMain(SimpleMagic.ELEMENT_MAIN_ARMOR_MATERIAL, 2, "firearmor");
	public static final Item FIRE_ORB = new ItemBasic("fireorb", 64);
	public static final Item FIRE_GEM = new ItemBasicShiny("firegem", 64);

	public static final Block FIRE_BLOCK = new BlockBasic(Material.fire, "fireblock", 1.0F, Block.soundTypePiston, null, 0);
	public static final Block FIRE_GEM_BLOCK = new BlockBasic(Material.fire, "firegemblock", 2.5F, Block.soundTypeGravel, "pickaxe", 2);

	public static void init() {
		SimpleMagic.registerItem(FIRE_PEARL);
		SimpleMagic.registerItem(FIRE_DUST);
		SimpleMagic.registerItem(FIRE_INGOT);
		SimpleMagic.registerItem(FIRE_SWORD);
		SimpleMagic.registerItem(FIRE_LEGGINGS);
		SimpleMagic.registerItem(FIRE_ORB);
		SimpleMagic.registerItem(FIRE_GEM);

		SimpleMagic.registerBlock(FIRE_BLOCK);
		SimpleMagic.registerBlock(FIRE_GEM_BLOCK);

		GameRegistry.addSmelting(FIRE_BLOCK, new ItemStack(FIRE_INGOT, 1), 0.25F);
		GameRegistry.addRecipe(new ItemStack(FIRE_SWORD, 1), new Object[] { "!", "!", "@", '!', new ItemStack(FIRE_INGOT, 1), '@', new ItemStack(Items.stick, 1) });
		GameRegistry.addRecipe(new ItemStack(FIRE_LEGGINGS, 1), new Object[] { "!!!", "! !", "! !", '!', new ItemStack(FIRE_INGOT, 1) });
		GameRegistry.addRecipe(new ItemStack(FIRE_ORB, 1), new Object[] { "!@!", "@#@", "!@!", '!', new ItemStack(FIRE_INGOT, 1), '@', new ItemStack(Blocks.glass, 1), '#', new ItemStack(FIRE_BLOCK, 1) });
		GameRegistry.addRecipe(new ItemStack(FIRE_GEM, 1), new Object[] { "!!!", "!@!", "!!!", '!', new ItemStack(Blocks.glass, 1), '@', new ItemStack(FIRE_GEM, 1) });

		GameRegistry.addRecipe(new ItemStack(FIRE_BLOCK, 1), new Object[] { "!!!", "!!!", "!!!", '!', new ItemStack(FIRE_DUST, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(FIRE_DUST, 9), new ItemStack(FIRE_BLOCK, 1));
		GameRegistry.addRecipe(new ItemStack(FIRE_GEM_BLOCK, 1), new Object[] { "!!!", "!!!", "!!!", '!', new ItemStack(FIRE_GEM, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(FIRE_GEM, 9), new ItemStack(FIRE_GEM_BLOCK, 1));
	}

}
