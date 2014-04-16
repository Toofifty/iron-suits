package me.toofifty.ironsuits.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

public class ModelArmorBase extends ModelBiped {
	
	public ModelArmorBase(float par1) {
		super(par1, 0, 64, 32);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
	}
	
	public void defaultRender(float f) {}
	
	public void renderEntity(float f) {
		this.defaultRender(f);
	}
	
	public void renderFirstPerson(float f) {
		this.defaultRender(f);
	}
	
	public void renderEquipped(float f) {
		this.defaultRender(f);
	}
	
	public void renderInventory(float f) {
		this.defaultRender(f);
	}

}
