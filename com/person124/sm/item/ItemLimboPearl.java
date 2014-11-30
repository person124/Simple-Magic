package com.person124.sm.item;

import com.person124.sm.element.Limbo;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLimboPearl extends ItemBasic {

	private boolean slow = false;

	public ItemLimboPearl(String name) {
		super(name, 1);
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		if (world.getBlock(x, y, z) != Blocks.air) {
			if (world.getBlock(x, y, z) == Blocks.dirt || world.getBlock(x, y, z) == Blocks.grass) {
				if (!world.isRemote) world.setBlock(x, y, z, Limbo.CURSED_DIRT, 0, 2);
				if (!slow) world.spawnParticle("hugeexplosion", x + .5, y - .5, z + .5, 0.0, 0.0, 0.0);
				if (slow) world.spawnParticle("explosion", x + .5, y - .5, z + .5, 0.0, 0.0, 0.0);
				player.inventory.consumeInventoryItem(Limbo.LIMBO_PEARL);
				return true;
			}
			if (world.getBlock(x, y, z) == Blocks.stone || world.getBlock(x, y, z) == Blocks.coal_ore || world.getBlock(x, y, z) == Blocks.iron_ore || world.getBlock(x, y, z) == Blocks.diamond_ore || world.getBlock(x, y, z) == Blocks.redstone_ore || world.getBlock(x, y, z) == Blocks.emerald_ore) {
				if (!world.isRemote) world.setBlock(x, y, z, Limbo.CURSED_STONE, 0, 2);
				if (!slow) world.spawnParticle("hugeexplosion", x + .5, y - .5, z + .5, 0.0, 0.0, 0.0);
				if (slow) world.spawnParticle("explosion", x + .5, y - .5, z + .5, 0.0, 0.0, 0.0);
				player.inventory.consumeInventoryItem(Limbo.LIMBO_PEARL);
				return true;
			}
			if (world.getBlock(x, y, z) == Blocks.log || world.getBlock(x, y, z) == Blocks.log2) {
				if (!world.isRemote) world.setBlock(x, y, z, Limbo.CURSED_LOG, 0, 2);
				if (!slow) world.spawnParticle("hugeexplosion", x + .5, y - .5, z + .5, 0.0, 0.0, 0.0);
				if (slow) world.spawnParticle("explosion", x + .5, y - .5, z + .5, 0.0, 0.0, 0.0);
				player.inventory.consumeInventoryItem(Limbo.LIMBO_PEARL);
				return true;
			}
			if (world.getBlock(x, y, z) == Limbo.CURSED_DIRT || world.getBlock(x, y, z) == Limbo.CURSED_LOG || world.getBlock(x, y, z) == Limbo.CURSED_STONE) {
				if (!world.isRemote) world.func_147480_a(x, y, z, false);
				player.inventory.addItemStackToInventory(new ItemStack(Limbo.LIMBO_DUST, 3));
				return true;
			}
		}
		return true;
	}

}
