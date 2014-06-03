package com.person124.sm;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.person124.sm.block.BlockBasic;
import com.person124.sm.block.BlockSummonCircle;
import com.person124.sm.common.SMCommonProxy;
import com.person124.sm.element.Earth;
import com.person124.sm.element.Limbo;
import com.person124.sm.item.ItemBasic;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "simplemagic", name = "Simple Magic", version = "0.1.0")
public class SimpleMagic {

	@Instance("simplemagic")
	public static SimpleMagic instance;

	@SidedProxy(clientSide = "com.person124.sm.client.SMClientProxy", serverSide = "com.person124.sm.common.SMCommonProxy")
	public static SMCommonProxy proxy;

	public static CreativeTabs smTab = new SMTab(CreativeTabs.getNextID(), "SMTab");
	public static final ArmorMaterial ELEMENT_MAIN_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("ELEMENT_MAIN", 15, new int[] { 2, 5, 4, 1 }, 0);

	public static final Item MAGIC_DUST = new ItemBasic("sm-magicdust", 64);
	public static final Item MAGIC_ORB = new ItemBasic("sm-magicorb", 64);
	public static final Item MAGIC_DUST_INGOT = new ItemBasic("sm-magicingot", 64);

	public static final Block MAGIC_DUST_BLOCK = new BlockBasic(Material.iron, "sm-magicblock", 2.0F, Block.soundTypeCloth, "pickaxe", 1);
	public static final Block SUMMON_CIRCLE = new BlockSummonCircle("sm-summoncircleblock", 0);
	public static final Block SUMMON_CIRCLE_MIDDLE = new BlockSummonCircle("sm-summoncircleblockmid", 1);
	public static final Block SUMMON_CIRCLE_EDGE = new BlockSummonCircle("sm-summoncircleedge", 2);
	public static final Block SUMMON_CIRCLE_EDGE_MIDDLE = new BlockSummonCircle("sm-summoncircleedgemid", 3);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		event.getModMetadata().autogenerated = false;
		event.getModMetadata().url = "http://www.planetminecraft.com/mod/simple-magic-v1/";
		event.getModMetadata().credits = "Thank you ThirstBuster on PMC for some of the textures.";
		event.getModMetadata().authorList.add("person124");
		event.getModMetadata().description = "Magic is Simple, is it not?";
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
		register();
		Earth.init();
		Limbo.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	private void register() {
		GameRegistry.registerItem(MAGIC_DUST, MAGIC_DUST.getUnlocalizedName());
		GameRegistry.registerItem(MAGIC_ORB, MAGIC_ORB.getUnlocalizedName());
		GameRegistry.registerItem(MAGIC_DUST_INGOT, MAGIC_DUST_INGOT.getUnlocalizedName());

		GameRegistry.registerBlock(MAGIC_DUST_BLOCK, MAGIC_DUST_BLOCK.getUnlocalizedName());
		GameRegistry.registerBlock(SUMMON_CIRCLE, SUMMON_CIRCLE.getUnlocalizedName());
		GameRegistry.registerBlock(SUMMON_CIRCLE_MIDDLE, SUMMON_CIRCLE_MIDDLE.getUnlocalizedName());
		GameRegistry.registerBlock(SUMMON_CIRCLE_EDGE, SUMMON_CIRCLE_EDGE.getUnlocalizedName());
		GameRegistry.registerBlock(SUMMON_CIRCLE_EDGE_MIDDLE, SUMMON_CIRCLE_EDGE_MIDDLE.getUnlocalizedName());
		
		GameRegistry.addSmelting(Items.redstone, new ItemStack(MAGIC_DUST, 10), 1.5F);
		GameRegistry.addRecipe(new ItemStack(MAGIC_ORB, 1), new Object[] { "!@!", "@#@", "!@!", '!', new ItemStack(MAGIC_DUST_INGOT, 1), '@', new ItemStack(Blocks.glass, 1), '#', new ItemStack(MAGIC_DUST_BLOCK, 1) });
		GameRegistry.addSmelting(MAGIC_DUST_BLOCK, new ItemStack(MAGIC_DUST_INGOT, 1), 0.0F);
		
		GameRegistry.addRecipe(new ItemStack(MAGIC_DUST_BLOCK, 1), new Object[] { "!!!", "!!!", "!!!", '!', new ItemStack(MAGIC_DUST, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(MAGIC_DUST, 9), new ItemStack(MAGIC_DUST_BLOCK, 1));
		GameRegistry.addRecipe(new ItemStack(SUMMON_CIRCLE, 1), new Object[] { "!!!", "!@!", "!!!", '!', new ItemStack(Blocks.wool, 1, 15), '@', new ItemStack(Items.redstone, 1) });
		GameRegistry.addRecipe(new ItemStack(SUMMON_CIRCLE_MIDDLE, 1), new Object[] { "!@!", "!#!", "!!!", '!', new ItemStack(Blocks.wool, 1, 15), '@', new ItemStack(MAGIC_ORB, 1), '#', new ItemStack(Items.redstone, 1) });
	}
	
	// Earth and Limbo
	// Fire and Fragor(Explosive/Creeper)
	// Water and Darkness
	// Time and Air
	// Life and Porcus(Pig)
	// Space and Vacca(I think cow?)
	// Light and Aranea(spider)
	// Death

}
