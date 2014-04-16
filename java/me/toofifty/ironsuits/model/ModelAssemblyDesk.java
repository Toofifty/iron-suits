package me.toofifty.ironsuits.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAssemblyDesk extends ModelBase {
	// fields
	ModelRenderer base;
	ModelRenderer frame1;
	ModelRenderer frame2;
	ModelRenderer frame3;
	ModelRenderer rbase;
	ModelRenderer rframe1;
	ModelRenderer rframe2;
	ModelRenderer rframe3;
	ModelRenderer arm1;
	ModelRenderer arm2;
	ModelRenderer arm3;
	ModelRenderer arm4;

	public ModelAssemblyDesk() {
		textureWidth = 64;
		textureHeight = 32;

		base = new ModelRenderer(this, 0, 0);
		base.addBox(0F, 0F, 0F, 2, 1, 14);
		base.setRotationPoint(5F, 23F, -7F);
		base.setTextureSize(64, 32);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		frame1 = new ModelRenderer(this, 0, 17);
		frame1.addBox(0F, 0F, 0F, 1, 13, 1);
		frame1.setRotationPoint(5F, 10F, -6F);
		frame1.setTextureSize(64, 32);
		frame1.mirror = true;
		setRotation(frame1, 0F, 0F, 0F);
		frame2 = new ModelRenderer(this, 0, 17);
		frame2.addBox(0F, 0F, 0F, 1, 13, 1);
		frame2.setRotationPoint(5F, 10F, 5F);
		frame2.setTextureSize(64, 32);
		frame2.mirror = true;
		setRotation(frame2, 0F, 0F, 0F);
		frame3 = new ModelRenderer(this, 4, 17);
		frame3.addBox(0F, 0F, 0F, 1, 1, 14);
		frame3.setRotationPoint(5F, 9F, -7F);
		frame3.setTextureSize(64, 32);
		frame3.mirror = true;
		setRotation(frame3, 0F, 0F, 0F);
		rbase = new ModelRenderer(this, 0, 0);
		rbase.addBox(0F, 0F, 0F, 2, 1, 14);
		rbase.setRotationPoint(-7F, 23F, -7F);
		rbase.setTextureSize(64, 32);
		rbase.mirror = true;
		setRotation(rbase, 0F, 0F, 0F);
		rframe1 = new ModelRenderer(this, 0, 17);
		rframe1.addBox(0F, 0F, 0F, 1, 13, 1);
		rframe1.setRotationPoint(-6F, 10F, -6F);
		rframe1.setTextureSize(64, 32);
		rframe1.mirror = true;
		setRotation(rframe1, 0F, 0F, 0F);
		rframe2 = new ModelRenderer(this, 0, 17);
		rframe2.addBox(0F, 0F, 0F, 1, 13, 1);
		rframe2.setRotationPoint(-6F, 10F, 5F);
		rframe2.setTextureSize(64, 32);
		rframe2.mirror = true;
		setRotation(rframe2, 0F, 0F, 0F);
		rframe3 = new ModelRenderer(this, 4, 17);
		rframe3.addBox(0F, 0F, 0F, 1, 1, 14);
		rframe3.setRotationPoint(-6F, 9F, -7F);
		rframe3.setTextureSize(64, 32);
		rframe3.mirror = true;
		setRotation(rframe3, 0F, 0F, 0F);
		arm1 = new ModelRenderer(this, 42, 0);
		arm1.addBox(0F, 0F, 0F, 10, 1, 1);
		arm1.setRotationPoint(-5F, 9F, 1F);
		arm1.setTextureSize(64, 32);
		arm1.mirror = true;
		setRotation(arm1, 0F, 0F, 0F);
		arm2 = new ModelRenderer(this, 52, 2);
		arm2.addBox(0F, 0F, 0F, 3, 1, 3);
		arm2.setRotationPoint(0F, 10F, 0F);
		arm2.setTextureSize(64, 32);
		arm2.mirror = true;
		setRotation(arm2, 0F, 0F, 0F);
		arm3 = new ModelRenderer(this, 56, 6);
		arm3.addBox(-1F, 0F, -1F, 2, 1, 2);
		arm3.setRotationPoint(1.5F, 11F, 1.5F);
		arm3.setTextureSize(64, 32);
		arm3.mirror = true;
		setRotation(arm3, 0F, 0.7853982F, 0F);
		arm4 = new ModelRenderer(this, 60, 9);
		arm4.addBox(0F, 0F, 0F, 1, 1, 1);
		arm4.setRotationPoint(1F, 12F, 1F);
		arm4.setTextureSize(64, 32);
		arm4.mirror = true;
		setRotation(arm4, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		base.render(f5);
		frame1.render(f5);
		frame2.render(f5);
		frame3.render(f5);
		rbase.render(f5);
		rframe1.render(f5);
		rframe2.render(f5);
		rframe3.render(f5);
		arm1.render(f5);
		arm2.render(f5);
		arm3.render(f5);
		arm4.render(f5);
	}
	
	public void renderModel(float f5) {
		base.render(f5);
		frame1.render(f5);
		frame2.render(f5);
		frame3.render(f5);
		rbase.render(f5);
		rframe1.render(f5);
		rframe2.render(f5);
		rframe3.render(f5);
		arm1.render(f5);
		arm2.render(f5);
		arm3.render(f5);
		arm4.render(f5);
		
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
