package com.person124.sm.entity;

public class EntityDarkSage extends EntityMob {

  public EntityDarkSage(World world) {
    super(world);
    this.getNavigator().setAvoidsWater(true);
		this.setSize(1.0F, 2.0F);
    
    this.tasks.addTask(0, new EntityAISwimming(this));
    this.tasks.addTask(1, new EntityAIBreakDoor(this));
    this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0D, false));
    this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
    this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
    this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
    this.tasks.addTask(6, new EntityAILookIdle(this));
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
  }
  
  protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(3.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(45.0D);
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected String getLivingSound() {
		return "mob.zombie.say";
	}

	protected String getHurtSound() {
		return "mob.zombie.hurt";
	}

	protected String getDeathSound() {
		return "mob.zombie.death";
	}

	protected int getDropItemId() {
		return 0;
	}

	public int getAttackStrength(Entity entity) {
		return 0;
	}

	public void onDeathUpdate() {
		if (!this.worldObj.isRemote) this.dropItem(Darkness.darkPearl.itemID, 1);
		this.setDead();
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			player.addPotionEffect(new PotionEffect(Potion.wither.id, 5, 0, true));
		}
		return true;
	}

}
