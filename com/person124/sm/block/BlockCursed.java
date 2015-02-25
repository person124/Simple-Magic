package com.person124.sm.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.person124.sm.element.Limbo;

public class BlockCursed extends BlockBasic {

	public static final PropertyEnum BLOCK_TYPE = PropertyEnum.create("type", BlockType.class);
	private boolean slow = false;

	public BlockCursed(String name) {
		super(Material.iron, name, 5.0F, Block.soundTypeAnvil, null, 0);
		setTickRandomly(true);
		setCreativeTab(null);
		setDefaultState(blockState.getBaseState().withProperty(BLOCK_TYPE, BlockType.DIRT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand) {
		if (!slow && world.getBlockState(pos.add(0, 1, 0)).getBlock().getBlockState() != Limbo.CURSED_BLOCK.getBlockState()) {
			world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, pos.getX() + .5, pos.getY(), pos.getZ() + .5, 0.0, 1.0, 0.0);
		}
	}

	@Override
	public void randomTick(World world, BlockPos pos, IBlockState state, Random rand) {
		if (!world.isRemote) {
			for (int i = 0; i < 4; i++) {
				int xa = rand.nextInt(3) - 1;
				int ya = rand.nextInt(5) - 3;
				int za = rand.nextInt(3) - 1;

				if (world.getBlockState(pos.add(xa, ya, za)).getBlock().getBlockState().getBaseState() == Blocks.dirt.getBlockState().getBaseState() || world.getBlockState(pos.add(xa, ya, za)).getBlock().getBlockState().getBaseState() == Blocks.grass.getBlockState().getBaseState()) {
					world.setBlockState(pos.add(xa, ya, za), Limbo.CURSED_BLOCK.getStateFromMeta(0));
				}
				if (world.getBlockState(pos.add(xa, ya, za)).getBlock().getBlockState().getBaseState() == Blocks.stone.getBlockState().getBaseState() || world.getBlockState(pos.add(xa, ya, za)) == Blocks.coal_ore.getBlockState().getBaseState() || world.getBlockState(pos.add(xa, ya, za)) == Blocks.iron_ore.getBlockState().getBaseState() || world.getBlockState(pos.add(xa, ya, za)) == Blocks.diamond_ore.getBlockState().getBaseState() || world.getBlockState(pos.add(xa, ya, za)) == Blocks.redstone_ore.getBlockState().getBaseState() || world.getBlockState(pos.add(xa, ya, za)) == Blocks.emerald_ore.getBlockState().getBaseState()) {
					world.setBlockState(pos.add(xa, ya, za), Limbo.CURSED_BLOCK.getStateFromMeta(1));
				}
				if (world.getBlockState(pos.add(xa, ya, za)).getBlock().getBlockState().getBaseState() == Blocks.log.getBlockState().getBaseState() || world.getBlockState(pos.add(xa, ya, za)).getBlock().getBlockState().getBaseState() == Blocks.log2.getBlockState().getBaseState()) {
					world.setBlockState(pos.add(xa, ya, za), Limbo.CURSED_BLOCK.getStateFromMeta(2));
				}
			}
		}
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(Blocks.air);
	}

	public int damageDropped(IBlockState state) {
		return ((BlockType) state.getValue(BLOCK_TYPE)).getMeta();
	}

	@SuppressWarnings("all")
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		BlockType[] type = BlockType.values();
		int i = type.length;

		for (int j = 0; j < i; ++j) {
			BlockType t = type[j];
			list.add(new ItemStack(item, 1, t.getMeta()));
		}
	}

	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(BLOCK_TYPE, BlockType.getType(meta));
	}

	public int getMetaFromState(IBlockState state) {
		return ((BlockType) state.getValue(BLOCK_TYPE)).getMeta();
	}

	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { BLOCK_TYPE });
	}

	private enum BlockType implements IStringSerializable {
		DIRT("dirt", 0), STONE("stone", 1), LOG("log", 2);

		private String name;
		private int meta;

		private BlockType(String n, int m) {
			name = n;
			meta = m;
		}

		public String getName() {
			return name;
		}

		public int getMeta() {
			return meta;
		}

		public static BlockType getType(int m) {
			switch (m) {
				case 0:
					return DIRT;
				case 1:
					return STONE;
				case 2:
					return LOG;
				default:
					return DIRT;
			}
		}

	}
}
