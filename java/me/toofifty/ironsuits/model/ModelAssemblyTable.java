package me.toofifty.ironsuits.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAssemblyTable extends ModelBase {
	// fields
	ModelRenderer top;
	ModelRenderer base;
	ModelRenderer beam1;
	ModelRenderer beam2;
	ModelRenderer leg1p1;
	ModelRenderer leg1p2;
	ModelRenderer leg2p1;
	ModelRenderer leg2p2;
	ModelRenderer leg3p1;
	ModelRenderer leg3p2;
	ModelRenderer leg4p1;
	ModelRenderer leg4p2;

	public ModelAssemblyTable() {
		textureWidth = 64;
		textureHeight = 64;

		//0.7853982F
		top = new ModelRenderer(this, 0, 0);
		top.addBox(0F, 0F, 0F, 16, 1, 16);
		top.setRotationPoint(-8F, 8F, -8F);
		top.setTextureSize(64, 64);
		top.mirror = true;
		setRotation(top, 0F, 0F, 0F);
		base = new ModelRenderer(this, 0, 17);
		base.addBox(-5F, 4F, -5F, 10, 9, 10);
		base.setRotationPoint(0F, 7F, 0F);
		base.setTextureSize(64, 64);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		beam1 = new ModelRenderer(this, 40, 17);
		beam1.addBox(0F, 0F, 0F, 1, 11, 1);
		beam1.setRotationPoint(3.9F, 9F, -6F);
		beam1.setTextureSize(64, 64);
		beam1.mirror = true;
		setRotation(beam1, 1.308997F, 0F, 0F);
		beam2 = new ModelRenderer(this, 40, 17);
		beam2.addBox(0F, 0F, 0F, 1, 11, 1);
		beam2.setRotationPoint(-4.9F, 9F, -6F);
		beam2.setTextureSize(64, 64);
		beam2.mirror = true;
		setRotation(beam2, 1.308997F, 0F, 0F);
		leg1p1 = new ModelRenderer(this, 44, 17);
		leg1p1.addBox(0F, 0F, -0.5F, 6, 1, 1);
		leg1p1.setRotationPoint(4F, 20F, 4F);
		leg1p1.setTextureSize(64, 64);
		leg1p1.mirror = true;
		setRotation(leg1p1, 0F, -0.7853982F, 0F);
		leg1p2 = new ModelRenderer(this, 44, 20);
		leg1p2.addBox(0F, 0F, -0.5F, 1, 8, 1);
		leg1p2.setRotationPoint(7F, 16F, 7F);
		leg1p2.setTextureSize(64, 64);
		leg1p2.mirror = true;
		setRotation(leg1p2, 0F, -0.7853982F, 0F);
		leg2p1 = new ModelRenderer(this, 44, 17);
		leg2p1.addBox(0F, 0F, -0.5F, 6, 1, 1);
		leg2p1.setRotationPoint(4F, 20F, -4F);
		leg2p1.setTextureSize(64, 64);
		leg2p1.mirror = true;
		setRotation(leg2p1, 0F, 0.7853982F, 0F);
		leg2p2 = new ModelRenderer(this, 44, 20);
		leg2p2.addBox(0F, 0F, -0.5F, 1, 8, 1);
		leg2p2.setRotationPoint(7F, 16F, -7F);
		leg2p2.setTextureSize(64, 64);
		leg2p2.mirror = true;
		setRotation(leg2p2, 0F, 0.7853982F, 0F);
		leg3p1 = new ModelRenderer(this, 44, 17);
		leg3p1.addBox(0F, 0F, -0.5F, 6, 1, 1);
		leg3p1.setRotationPoint(-4F, 20F, -4F);
		leg3p1.setTextureSize(64, 64);
		leg3p1.mirror = true;
		setRotation(leg3p1, 0F, 2.356194F, 0F);
		leg3p2 = new ModelRenderer(this, 44, 20);
		leg3p2.addBox(0F, 0F, -0.5F, 1, 8, 1);
		leg3p2.setRotationPoint(-7F, 16F, -7F);
		leg3p2.setTextureSize(64, 64);
		leg3p2.mirror = true;
		setRotation(leg3p2, 0F, 2.356194F, 0F);
		leg4p1 = new ModelRenderer(this, 44, 17);
		leg4p1.addBox(0F, 0F, -0.5F, 6, 1, 1);
		leg4p1.setRotationPoint(-4F, 20F, 4F);
		leg4p1.setTextureSize(64, 64);
		leg4p1.mirror = true;
		setRotation(leg4p1, 0F, -2.356194F, 0F);
		leg4p2 = new ModelRenderer(this, 44, 20);
		leg4p2.addBox(0F, 0F, -0.5F, 1, 8, 1);
		leg4p2.setRotationPoint(-7F, 16F, 7F);
		leg4p2.setTextureSize(64, 64);
		leg4p2.mirror = true;
		setRotation(leg4p2, 0F, -2.356194F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		top.render(f5);
		base.render(f5);
		beam1.render(f5);
		beam2.render(f5);
		leg1p1.render(f5);
		leg1p2.render(f5);
		leg2p1.render(f5);
		leg2p2.render(f5);
		leg3p1.render(f5);
		leg3p2.render(f5);
		leg4p1.render(f5);
		leg4p2.render(f5);
	}
	
	public void renderModel(float f) {
		top.render(f);
		base.render(f);
		beam1.render(f);
		beam2.render(f);
		leg1p1.render(f);
		leg1p2.render(f);
		leg2p1.render(f);
		leg2p2.render(f);
		leg3p1.render(f);
		leg3p2.render(f);
		leg4p1.render(f);
		leg4p2.render(f);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
