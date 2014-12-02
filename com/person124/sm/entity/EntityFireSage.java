package com.person124.sm.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.person124.sm.element.Fire;

public class EntityFireSage extends EntityBlaze {
	
	public EntityFireSage(World world) {
		super(world);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
	}
	
	protected String getLivingSound() {
		return "simplemagic:mob.firesage.say";
	}

	protected String getHurtSound() {
		return "simplemagic:mob.firesage.hurt";
	}

	protected String getDeathSound() {
		return "simplemagic:mob.firesage.death";
	}
	
	protected Item getDropItem(){
		return Item.getItemFromBlock(Blocks.air);
    }
	
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {}
	
	public void onDeathUpdate() {
		if (!this.worldObj.isRemote) this.dropItem(Fire.FIRE_PEARL, 2);
		this.setDead();
	}

}
