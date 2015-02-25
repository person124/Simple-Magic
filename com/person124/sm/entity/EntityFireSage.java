package com.person124.sm.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.person124.sm.element.Fire;

public class EntityFireSage extends EntityMob {

	public EntityFireSage(World world) {
		super(world);

		this.setSize(0.6F, 1.8F);
		this.setHealth(30F);
		this.setMoveForward(0.46F);
		this.experienceValue = 5;
		this.isImmuneToFire = true;

		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.46D, false));
		this.tasks.addTask(2, new EntityAIWander(this, 0.46D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, null));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.46D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
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

	protected Item getDropItem() {
		return Item.getItemFromBlock(Blocks.air);
	}

	public void onLivingUpdate() {
		if (!this.worldObj.isRemote) {
			if (this.isInWater() || (this.worldObj.isRaining() && this.worldObj.canBlockSeeSky(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))))) this.attackEntityFrom(DamageSource.drown, 5.0F);
		}
		super.onLivingUpdate();
	}

	public boolean attackEntityAsMob(Entity e) {
		EntityPlayer entity = (EntityPlayer) e;
		entity.setFire(10);
		return true;
	}

	public void onDeathUpdate() {
		if (!this.worldObj.isRemote) this.dropItem(Fire.FIRE_PEARL, 2);
		this.setDead();
	}

}
