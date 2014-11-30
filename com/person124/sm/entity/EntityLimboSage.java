package com.person124.sm.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.person124.sm.element.Limbo;

public class EntityLimboSage extends EntityMob {

	public EntityLimboSage(World world) {
		super(world);
		this.getNavigator().setAvoidsWater(true);
		this.getNavigator().setAvoidSun(true);
		this.setSize(0.6F, 1.8F);
		this.setHealth(30F);
		this.setMoveForward(0.75F);
		this.experienceValue = 20;
		
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.46D, false));
		this.tasks.addTask(2, new EntityAIWander(this, 0.46D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.75D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
	}
	
	public boolean isAIEnabled() {
		return true;
	}
	
	protected String getLivingSound() {
		return "simplemagic:mob.limbosage.say";
	}

	protected String getHurtSound() {
		return "simplemagic:mob.limbosage.hurt";
	}

	protected String getDeathSound() {
		return "simplemagic:mob.limbosage.death";
	}
	
	protected Item getDropItem() {
		return Item.getItemFromBlock(Blocks.air);
	}
	
	public boolean attackEntityAsMob(Entity e) {
		EntityPlayer entity = (EntityPlayer) e;
		entity.addPotionEffect(new PotionEffect(Potion.poison.getId(), 160, 0));
		entity.heal(-0.5F);
		this.heal(0.5F);
		return true;
	}
	
	public void onDeathUpdate() {
		if (!this.worldObj.isRemote) this.dropItem(Limbo.LIMBO_PEARL, 2);
		this.setDead();
	}

}
