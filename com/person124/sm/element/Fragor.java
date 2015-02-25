package com.person124.sm.element;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.person124.sm.SimpleMagic;
import com.person124.sm.block.BlockBasic;
import com.person124.sm.item.ItemArmorMinor;
import com.person124.sm.item.ItemBasic;
import com.person124.sm.item.ItemFragorSword;

public class Fragor {

	public static final Item FRAGOR_DUST = new ItemBasic("fragordust", 64);
	public static final Item FRAGOR_INGOT = new ItemBasic("fragoringot", 64);
	public static final Item FRAGOR_SWORD = new ItemFragorSword("fragorsword", 19);
	public static final Item FRAGOR_CHESTPLATE = new ItemArmorMinor(SimpleMagic.ELEMENT_MINOR_ARMOR_MATERIAL, 1, "fragorarmor");

	public static final Block FRAGOR_BLOCK = new BlockBasic(Material.tnt, "fragorblock", 0.0F, Block.soundTypeWood, null, 0);

	public static void init() {
		SimpleMagic.registerItem(FRAGOR_DUST);
		SimpleMagic.registerItem(FRAGOR_INGOT);
		SimpleMagic.registerItem(FRAGOR_SWORD);
		SimpleMagic.registerItem(FRAGOR_CHESTPLATE);

		SimpleMagic.registerBlock(FRAGOR_BLOCK);

		GameRegistry.addRecipe(new ItemStack(FRAGOR_DUST, 4), new Object[] { "!@!", "@!@", "!@!", '!', new ItemStack(Base.MAGIC_DUST, 1), '@', new ItemStack(Items.gunpowder) });
		GameRegistry.addSmelting(FRAGOR_BLOCK, new ItemStack(FRAGOR_INGOT, 1), 0.25F);
		GameRegistry.addRecipe(new ItemStack(FRAGOR_SWORD, 1), new Object[] { "!", "!", "@", '!', new ItemStack(FRAGOR_INGOT, 1), '@', new ItemStack(Items.stick, 1) });
		GameRegistry.addRecipe(new ItemStack(FRAGOR_CHESTPLATE, 1), new Object[] { "! !", "!!!", "!!!", '!', new ItemStack(FRAGOR_INGOT, 1) });

		GameRegistry.addRecipe(new ItemStack(FRAGOR_BLOCK, 1), new Object[] { "!!!", "!!!", "!!!", '!', new ItemStack(FRAGOR_DUST, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(FRAGOR_DUST, 9), new ItemStack(FRAGOR_BLOCK, 1));
	}

}
