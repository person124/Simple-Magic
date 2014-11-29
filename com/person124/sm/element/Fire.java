package com.person124.sm.element;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.person124.sm.SimpleMagic;
import com.person124.sm.block.BlockBasic;
import com.person124.sm.item.ItemBasic;
import com.person124.sm.item.ItemFirePearl;

import cpw.mods.fml.common.registry.GameRegistry;

public class Fire {
	
	public static final Item FIRE_PEARL = new ItemFirePearl("firepearl");
	public static final Item FIRE_DUST = new ItemBasic("firedust", 64);
	public static final Item FIRE_INGOT = new ItemBasic("fireingot", 64);
	
	public static final Block FIRE_BLOCK = new BlockBasic(Material.fire, "fireblock", 1.0F, Block.soundTypePiston, null, 0);
	
	public static void init() {
		SimpleMagic.registerItem(FIRE_PEARL);
		SimpleMagic.registerItem(FIRE_DUST);
		SimpleMagic.registerItem(FIRE_INGOT);
		
		SimpleMagic.registerBlock(FIRE_BLOCK);
		
		GameRegistry.addSmelting(FIRE_BLOCK, new ItemStack(FIRE_INGOT, 1), 0.25F);
		
		GameRegistry.addRecipe(new ItemStack(FIRE_BLOCK, 1), new Object[] { "!!!", "!!!", "!!!", '!', new ItemStack(FIRE_DUST, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(FIRE_DUST, 9), new ItemStack(FIRE_BLOCK, 1));
	}

}
