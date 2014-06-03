package com.person124.sm.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.person124.sm.common.mod_SimpleMagic;
import com.person124.sm.entity.EntityEarthSage;
import com.person124.sm.entity.EntityLimboSage;
import com.person124.sm.entity.EntityWaterSage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSummonCircle extends Block {

	public Icon[] blockIcon = new Icon[5];
	private int type;
	private int many;

	public BlockSummonCircle(int id, Material material, String name, CreativeTabs tab, Float hard, StepSound sound, Float light, boolean unbreakable, int type) {

		super(id, material);

		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);

		this.setHardness(hard);
		if (unbreakable) this.setBlockUnbreakable();
		this.type = type;
		this.setTickRandomly(true);
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int i, int par2) {

		if (i == 1) {
			if (type == 0) return this.blockIcon[0];
			if (type == 1) return this.blockIcon[2];
			if (type == 2) return this.blockIcon[3];
			if (type == 3) return this.blockIcon[4];
		} else {
			return this.blockIcon[1];
		}
		return this.blockIcon[1];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.blockIcon[0] = iconRegister.registerIcon("simplemagic" + ":" + "sm-summoncircleblock");
		this.blockIcon[1] = iconRegister.registerIcon("wool_colored_black");
		this.blockIcon[2] = iconRegister.registerIcon("simplemagic" + ":" + "sm-summoncircleblockmid");
		this.blockIcon[3] = iconRegister.registerIcon("simplemagic" + ":" + "sm-summoncircleedge");
		this.blockIcon[4] = iconRegister.registerIcon("simplemagic" + ":" + "sm-summoncircleedgemid");
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (type == 1) {

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
					if (world.getBlockId(x + xa - xb, y, z + za - zb) == mod_SimpleMagic.summonCircle.blockID) many += 1;
					if (many == 8) this.levelUp(world, x, y, z, player);
					if (i == 2 && u == 2) many = 0;
				}
			}

		}

		if (type == 3) {
			if (world.difficultySetting > 0 && player.inventory.getCurrentItem() != null) {
				if (player.inventory.getCurrentItem().itemID == Block.dirt.blockID) {
					player.inventory.consumeInventoryItem(Block.dirt.blockID);

					double xa = x + .5;
					double ya = y + 1;
					double za = z + .5;
					EntityEarthSage sage = new EntityEarthSage(world);
					sage.setLocationAndAngles(xa, ya, za, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
					sage.rotationYawHead = sage.rotationYaw;
					sage.renderYawOffset = sage.rotationYaw;
					if (!world.isRemote) world.spawnEntityInWorld(sage);
					return true;
				}
				if (player.inventory.getCurrentItem().itemID == Item.enderPearl.itemID) {
					player.inventory.consumeInventoryItem(Item.enderPearl.itemID);

					double xa = x + .5;
					double ya = y + 1;
					double za = z + .5;
					EntityLimboSage sage = new EntityLimboSage(world);
					sage.setLocationAndAngles(xa, ya, za, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
					sage.rotationYawHead = sage.rotationYaw;
					sage.renderYawOffset = sage.rotationYaw;
					if (!world.isRemote) world.spawnEntityInWorld(sage);
					return true;
				}
				if (player.inventory.getCurrentItem().itemID == Item.bucketWater.itemID) {
					player.inventory.consumeInventoryItem(Item.bucketWater.itemID);
					if (!world.isRemote) player.inventory.addItemStackToInventory(new ItemStack(Item.bucketEmpty));

					double xa = x + .5;
					double ya = y + 1;
					double za = z + .5;
					EntityWaterSage sage = new EntityWaterSage(world);
					sage.setLocationAndAngles(xa, ya, za, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
					sage.rotationYawHead = sage.rotationYaw;
					sage.renderYawOffset = sage.rotationYaw;
					if (!world.isRemote) world.spawnEntityInWorld(sage);
					return true;
				}
				if (player.inventory.getCurrentItem().itemID == Item.dyePowder.itemID) {
					player.inventory.consumeInventoryItem(Item.dyePowder.itemID);
					
					double xa = x + .5;
					double ya = y + 1;
					double za = x + .5;
					EntityDarkSage sage = new EntityDarkSage(world);
					sage.setLocationAndAngles(xa, ya, za, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
					sage.rotationYawHead = sage.rotationYaw;
					sage.renderYawOffset = sage.rotationYaw;
					if (!world.isRemote) world.spawnEntityInWorld(sage);
					return true;
				}
			}

			return true;
		}
		return blockConstructorCalled;
	}

	public void levelUp(World world, int x, int y, int z, EntityPlayer player) {
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
				world.setBlock(x + xa - xb, y, z + za - zb, mod_SimpleMagic.summonCircleEdge.blockID);
				world.setBlock(x + xa - xb, y + 1, z + za - zb, 0);
				world.setBlock(x + xa - xb, y + 2, z + za - zb, 0);
				world.setBlock(x, y, z, mod_SimpleMagic.summonCircleEdgeMid.blockID);
			}
		}
	}

	public int idDropped(int par1, Random par2Random, int par3) {
		if (type == 2) return 0;
		if (type == 3) return 0;

		return this.blockID;
	}

	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int par5) {

		if (type == 2) {
			world.setBlock(x, y, z, mod_SimpleMagic.summonCircleEdge.blockID);
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
					world.setBlock(x + xa - xb, y, z + za - zb, mod_SimpleMagic.summonCircle.blockID);
					world.setBlock(x, y, z, mod_SimpleMagic.summonCircleMid.blockID);
					if (world.getBlockId(x + xa - xb, y, z + za - zb) == mod_SimpleMagic.summonCircle.blockID) world.destroyBlock(x + xa - xb, y, z + za - zb, true);
				}
			}
		}
	}

	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion par5Explosion) {
		if (type == 2) {
			world.setBlock(x, y, z, mod_SimpleMagic.summonCircleEdge.blockID);
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
					world.setBlock(x + xa - xb, y, z + za - zb, mod_SimpleMagic.summonCircle.blockID);
					world.setBlock(x, y, z, mod_SimpleMagic.summonCircleMid.blockID);
					if (world.getBlockId(x + xa - xb, y, z + za - zb) == mod_SimpleMagic.summonCircle.blockID) world.destroyBlock(x + xa - xb, y, z + za - zb, true);
				}
			}
		}
	}

}
