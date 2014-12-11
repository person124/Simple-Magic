package com.person124.sm;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

import com.person124.sm.common.SMCommonProxy;
import com.person124.sm.element.Base;
import com.person124.sm.element.Earth;
import com.person124.sm.element.Fire;
import com.person124.sm.element.Fragor;
import com.person124.sm.element.Life;
import com.person124.sm.element.Limbo;
import com.person124.sm.event.EventEntityDammage;
import com.person124.sm.event.EventPlayerCape;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "simplemagic", name = "Simple Magic", version = "0.2.30")
public class SimpleMagic {

	@Instance("simplemagic")
	public static SimpleMagic instance;

	@SidedProxy(clientSide = "com.person124.sm.client.SMClientProxy", serverSide = "com.person124.sm.common.SMCommonProxy")
	public static SMCommonProxy proxy;

	public static CreativeTabs smTab = new SMTab(CreativeTabs.getNextID(), "SMTab");
	public static final ArmorMaterial ELEMENT_MINOR_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("ELEMENTMINOR", 10, new int[] { 2, 0, 4, 1 }, 0);
	public static final ArmorMaterial ELEMENT_MAIN_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("ELEMENTMAIN", 15, new int[] { 2, 5, 4, 1 }, 0);
	public static final ArmorMaterial ELEMENT_ALMIGHTY_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("ELEMENTALMIGHTY", 25, new int[] { 2, 5, 4, 1 }, 0);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		event.getModMetadata().autogenerated = false;
		event.getModMetadata().url = "http://www.planetminecraft.com/mod/simple-magic-v1/";
		event.getModMetadata().authorList.add("person124");
		event.getModMetadata().description = "Magic is Simple, is it not? Thank you ThirstBuster on PMC for some of the textures.";
		event.getModMetadata().logoFile = "assets/simplemagic/textures/logo.png";

		MinecraftForge.EVENT_BUS.register(new EventEntityDammage());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
		Base.init();
		Earth.init();
		Limbo.init();
		Fire.init();
		Fragor.init();
		Life.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new EventPlayerCape());
	}

	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.", ""));
	}

	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().replace("tile.", ""));
	}

	// *Earth and *Limbo
	// *Fire and *Fragor(Explosive/Creeper)
	// Life and Air
	// Time and Darkness
	// Water and Porcus(Pig)
	// Space and Vacca(I think cow?)
	// Light and Aranea(spider)
	// Death

}
