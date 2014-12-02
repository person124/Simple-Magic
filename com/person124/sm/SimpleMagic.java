package com.person124.sm;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

import com.person124.sm.block.BlockBasic;
import com.person124.sm.block.BlockSummonCircle;
import com.person124.sm.common.SMCommonProxy;
import com.person124.sm.element.Earth;
import com.person124.sm.element.Fire;
import com.person124.sm.element.Fragor;
import com.person124.sm.element.Limbo;
import com.person124.sm.event.EventEntityDammage;
import com.person124.sm.item.ItemBasic;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "simplemagic", name = "Simple Magic", version = "0.2.0")
public class SimpleMagic {
	
	@Instance("simplemagic")
	public static SimpleMagic instance;

	@SidedProxy(clientSide = "com.person124.sm.client.SMClientProxy", serverSide = "com.person124.sm.common.SMCommonProxy")
	public static SMCommonProxy proxy;

	public static CreativeTabs smTab = new SMTab(CreativeTabs.getNextID(), "SMTab");
	public static ArmorMaterial ELEMENT_MINOR_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("ELEMENTMINOR", 10, new int[] { 2, 5, 4, 1 }, 0);
	public static final ArmorMaterial ELEMENT_MAIN_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("ELEMENTMAIN", 15, new int[] { 2, 5, 4, 1 }, 0);
	public static final ArmorMaterial ELEMENT_ALMIGHTY_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("ELEMENTALMIGHTY", 25, new int[] { 2, 5, 4, 1 }, 0);

	public static final Item MAGIC_DUST = new ItemBasic("magicdust", 64);
	public static final Item MAGIC_ORB = new ItemBasic("magicorb", 64);
	public static final Item MAGIC_DUST_INGOT = new ItemBasic("magicingot", 64);

	public static final Block MAGIC_DUST_BLOCK = new BlockBasic(Material.iron, "magicblock", 2.0F, Block.soundTypeCloth, "pickaxe", 1);
	public static final Block SUMMON_CIRCLE = new BlockSummonCircle("summoncircleblock", 0);
	public static final Block SUMMON_CIRCLE_MIDDLE = new BlockSummonCircle("summoncircleblockmid", 1);
	public static final Block SUMMON_CIRCLE_EDGE = new BlockSummonCircle("summoncircleedge", 2);
	public static final Block SUMMON_CIRCLE_EDGE_MIDDLE = new BlockSummonCircle("summoncircleedgemid", 3);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		event.getModMetadata().autogenerated = false;
		event.getModMetadata().url = "http://www.planetminecraft.com/mod/simple-magic-v1/";
		event.getModMetadata().credits = "Thank you ThirstBuster on PMC for some of the textures.";
		event.getModMetadata().authorList.add("person124");
		event.getModMetadata().description = "Magic is Simple, is it not?";
		event.getModMetadata().logoFile = "assets/simplemagic/textures/logo.png";
		
		MinecraftForge.EVENT_BUS.register(new EventEntityDammage());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
		register();
		Earth.init();
		Limbo.init();
		Fire.init();
		Fragor.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	private void register() {
		registerItem(MAGIC_DUST);
		registerItem(MAGIC_ORB);
		registerItem(MAGIC_DUST_INGOT);

		registerBlock(MAGIC_DUST_BLOCK);
		registerBlock(SUMMON_CIRCLE);
		registerBlock(SUMMON_CIRCLE_MIDDLE);
		registerBlock(SUMMON_CIRCLE_EDGE);
		registerBlock(SUMMON_CIRCLE_EDGE_MIDDLE);
		
		GameRegistry.addSmelting(Items.redstone, new ItemStack(MAGIC_DUST, 10), 1.5F);
		GameRegistry.addRecipe(new ItemStack(MAGIC_ORB, 1), new Object[] { "!@!", "@#@", "!@!", '!', new ItemStack(MAGIC_DUST_INGOT, 1), '@', new ItemStack(Blocks.glass, 1), '#', new ItemStack(MAGIC_DUST_BLOCK, 1) });
		GameRegistry.addSmelting(MAGIC_DUST_BLOCK, new ItemStack(MAGIC_DUST_INGOT, 1), 0.0F);
		
		GameRegistry.addRecipe(new ItemStack(MAGIC_DUST_BLOCK, 1), new Object[] { "!!!", "!!!", "!!!", '!', new ItemStack(MAGIC_DUST, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(MAGIC_DUST, 9), new ItemStack(MAGIC_DUST_BLOCK, 1));
		GameRegistry.addRecipe(new ItemStack(SUMMON_CIRCLE, 1), new Object[] { "!!!", "!@!", "!!!", '!', new ItemStack(Blocks.wool, 1, 15), '@', new ItemStack(Items.redstone, 1) });
		GameRegistry.addRecipe(new ItemStack(SUMMON_CIRCLE_MIDDLE, 1), new Object[] { "!@!", "!#!", "!!!", '!', new ItemStack(Blocks.wool, 1, 15), '@', new ItemStack(MAGIC_ORB, 1), '#', new ItemStack(Items.redstone, 1) });
	}
	
	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.", ""));
	}
	
	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().replace("tile.", ""));
	}
	
	// *Earth and *Limbo
	// *Fire and Fragor(Explosive/Creeper)
	// Water and Darkness
	// Time and Air
	// Life and Porcus(Pig)
	// Space and Vacca(I think cow?)
	// Light and Aranea(spider)
	// Death

}
