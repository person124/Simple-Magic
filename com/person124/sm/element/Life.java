package com.person124.sm.element;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.person124.sm.SimpleMagic;
import com.person124.sm.block.BlockLifeDust;
import com.person124.sm.item.ItemBasic;

public class Life {

	public static final Item LIFE_DUST = new ItemBasic("lifedust", 64);
	public static final Item LIFE_INGOT = new ItemBasic("lifeingot", 64);

	public static final Block LIFE_BLOCK = new BlockLifeDust("lifeblock");

	public static void init() {
		SimpleMagic.registerItem(LIFE_DUST);
		SimpleMagic.registerItem(LIFE_INGOT);

		SimpleMagic.registerBlock(LIFE_BLOCK);

		GameRegistry.addSmelting(Earth.EARTH_GEM, new ItemStack(LIFE_DUST, 1), 0.5F);
		GameRegistry.addSmelting(LIFE_BLOCK, new ItemStack(LIFE_INGOT, 1), 0.75F);

		GameRegistry.addRecipe(new ItemStack(LIFE_BLOCK, 1), new Object[] { "!!!", "!!!", "!!!", '!', new ItemStack(LIFE_DUST, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(LIFE_DUST, 9), new ItemStack(LIFE_BLOCK, 1));
	}

}
