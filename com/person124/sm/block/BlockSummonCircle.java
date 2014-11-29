package com.person124.sm.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.person124.sm.SimpleMagic;
import com.person124.sm.entity.EntityEarthSage;
import com.person124.sm.entity.EntityLimboSage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSummonCircle extends BlockBasic {

	@SideOnly(Side.CLIENT)
	private IIcon[] blockIcon = new IIcon[5];
	private int type;

	public BlockSummonCircle(String name, int type) {
		super(Material.cloth, name, 0.8F, Block.soundTypeCloth, null, 0);
		this.type = type;
		setTickRandomly(true);
		if (this.type > 1) setCreativeTab(null);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int par2) {

		if (i == 1) {
			if (type == 0) return blockIcon[0];
			if (type == 1) return blockIcon[2];
			if (type == 2) return blockIcon[3];
			if (type == 3) return blockIcon[4];
		} else return blockIcon[1];

		return blockIcon[1];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon[0] = iconRegister.registerIcon("simplemagic:" + "summoncircleblock");
		this.blockIcon[1] = iconRegister.registerIcon("wool_colored_black");
		this.blockIcon[2] = iconRegister.registerIcon("simplemagic:" + "summoncircleblockmid");
		this.blockIcon[3] = iconRegister.registerIcon("simplemagic:" + "summoncircleedge");
		this.blockIcon[4] = iconRegister.registerIcon("simplemagic:" + "summoncircleedgemid");
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (type == 1) {
			int many = 0;
			for (int i = 0; i < 3; i++) {
				for (int u = 0; u < 3; u++) {
					int xa = 0;
					int za = 0;
					int xb = 0;
					int zb = 0;
					if (u > 0) xa = u - 1;
					if (i > 0) za = i - 1;
					if (u == 0) xb = 1;
					if (i == 0) zb = 1;
					if (world.getBlock(x + xa - xb, y, z + za - zb) == SimpleMagic.SUMMON_CIRCLE) many += 1;
					if (many == 8) levelUp(world, x, y, z, player);
					if (i == 2 && u == 2) many = 0;
				}
			}

		}

		if (type == 3 && world.difficultySetting.getDifficultyId() > 0 && player.inventory.getCurrentItem() != null) {
			if (player.inventory.getCurrentItem().isItemEqual(new ItemStack(Blocks.dirt))) {
				player.inventory.consumeInventoryItem(Item.getItemFromBlock(Blocks.dirt));
				double xa = x + .5;
				double ya = y + 1;
				double za = z + .5;

				EntityEarthSage sage = new EntityEarthSage(world);
				sage.setPosition(xa, ya, za);
				if (!world.isRemote) world.spawnEntityInWorld(sage);
				return true;
			}
			if (player.inventory.getCurrentItem().isItemEqual(new ItemStack(Items.ender_pearl))) {
				player.inventory.consumeInventoryItem(Items.ender_pearl);
				double xa = x + .5;
				double ya = y + 1;
				double za = z + .5;

				EntityLimboSage sage = new EntityLimboSage(world);
				sage.setPosition(xa, ya, za);
				if (!world.isRemote) world.spawnEntityInWorld(sage);
				return true;
			}
		}

		return true;
	}

	private void levelUp(World world, int x, int y, int z, EntityPlayer player) {
		for (int i = 0; i < 3; i++) {
			for (int u = 0; u < 3; u++) {
				int xa = 0;
				int za = 0;
				int xb = 0;
				int zb = 0;
				if (u > 0) xa = u - 1;
				if (i > 0) za = i - 1;
				if (u == 0) xb = 1;
				if (i == 0) zb = 1;
				world.setBlock(x + xa - xb, y, z + za - zb, SimpleMagic.SUMMON_CIRCLE_EDGE);
				world.setBlock(x + xa - xb, y + 1, z + za - zb, Blocks.air);
				world.setBlock(x + xa - xb, y + 2, z + za - zb, Blocks.air);
				world.setBlock(x, y, z, SimpleMagic.SUMMON_CIRCLE_EDGE_MIDDLE);
			}
		}
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3) {
		if (type > 1) return Item.getItemFromBlock(Blocks.air);

		return Item.getItemFromBlock(this);
	}

	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int par5) {

		if (type == 2) {
			world.setBlock(x, y, z, SimpleMagic.SUMMON_CIRCLE_EDGE);
		}

		if (type == 3) {
			for (int i = 0; i < 3; i++) {
				for (int u = 0; u < 3; u++) {
					int xa = 0;
					int za = 0;
					int xb = 0;
					int zb = 0;
					if (u > 0) xa = u - 1;
					if (i > 0) za = i - 1;
					if (u == 0) xb = 1;
					if (i == 0) zb = 1;
					world.setBlock(x + xa - xb, y, z + za - zb, SimpleMagic.SUMMON_CIRCLE);
					world.setBlock(x, y, z, SimpleMagic.SUMMON_CIRCLE_MIDDLE);
					if (world.getBlock(x + xa - xb, y, z + za - zb) == SimpleMagic.SUMMON_CIRCLE) world.func_147480_a(x + xa - xb, y, z + za - zb, true);
				}
			}
		}
	}

	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion par5Explosion) {
		if (type == 2) world.setBlock(x, y, z, SimpleMagic.SUMMON_CIRCLE_EDGE);

		if (type == 3) {
			for (int i = 0; i < 3; i++) {
				for (int u = 0; u < 3; u++) {
					int xa = 0;
					int za = 0;
					int xb = 0;
					int zb = 0;
					if (u > 0) xa = u - 1;
					if (i > 0) za = i - 1;
					if (u == 0) xb = 1;
					if (i == 0) zb = 1;
					world.setBlock(x + xa - xb, y, z + za - zb, SimpleMagic.SUMMON_CIRCLE);
					world.setBlock(x, y, z, SimpleMagic.SUMMON_CIRCLE_MIDDLE);
					if (world.getBlock(x + xa - xb, y, z + za - zb) == SimpleMagic.SUMMON_CIRCLE) world.func_147480_a(x + xa - xb, y, z + za - zb, true);
				}
			}
		}
	}

}
