// Date: 12/04/2014 10:34:06 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package me.toofifty.ironsuits.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelExoLegs extends ModelArmorBase {
	// fields
	ModelRenderer leftbeltbrace;
	ModelRenderer leftknee;
	ModelRenderer leftbeltbraceout;
	ModelRenderer leftkneeconnector;
	ModelRenderer leftbeltbraceback;
	ModelRenderer left;
	ModelRenderer rightbeltbrace;
	ModelRenderer rightknee;
	ModelRenderer rightbeltbraceout;
	ModelRenderer rightkneeconnector;
	ModelRenderer rightbeltbraceback;
	ModelRenderer right;

	public ModelExoLegs(float f) {
		super(f);
		textureWidth = 64;
		textureHeight = 32;

		leftbeltbrace = new ModelRenderer(this, 16, 14);
		leftbeltbrace.addBox(-2F, 0F, -3F, 5, 1, 1);
		leftbeltbrace.setRotationPoint(0F, 0F, 0F);
		leftbeltbrace.setTextureSize(64, 32);
		leftbeltbrace.mirror = true;
		setRotation(leftbeltbrace, 0F, 0F, 0F);
		
		leftknee = new ModelRenderer(this, 0, 13);
		leftknee.addBox(-2F, 4F, -3F, 4, 2, 1);
		leftknee.setRotationPoint(0F, 0F, 0F);
		leftknee.setTextureSize(64, 32);
		leftknee.mirror = true;
		setRotation(leftknee, 0F, 0F, 0F);
		
		leftbeltbraceout = new ModelRenderer(this, 16, 6);
		leftbeltbraceout.addBox(2F, 0F, -2F, 1, 1, 4);
		leftbeltbraceout.setRotationPoint(0F, 0F, 0F);
		leftbeltbraceout.setTextureSize(64, 32);
		leftbeltbraceout.mirror = true;
		setRotation(leftbeltbraceout, 0F, 0F, 0F);
		
		leftkneeconnector = new ModelRenderer(this, 16, 3);
		leftkneeconnector.addBox(2F, 4F, -2F, 1, 1, 2);
		leftkneeconnector.setRotationPoint(0F, 0F, 0F);
		leftkneeconnector.setTextureSize(64, 32);
		leftkneeconnector.mirror = true;
		setRotation(leftkneeconnector, 0F, 0F, 0F);
		
		leftbeltbraceback = new ModelRenderer(this, 16, 11);
		leftbeltbraceback.addBox(-2F, 0F, 2F, 5, 2, 1);
		leftbeltbraceback.setRotationPoint(0F, 0F, 0F);
		leftbeltbraceback.setTextureSize(64, 32);
		leftbeltbraceback.mirror = true;
		setRotation(leftbeltbraceback, 0F, 0F, 0F);
		
		left = new ModelRenderer(this, 0, 0);
		left.addBox(2F, 1F, 0F, 1, 9, 1);
		left.setRotationPoint(0F, 0F, 0F);
		left.setTextureSize(64, 32);
		left.mirror = true;
		setRotation(left, 0F, 0F, 0F);

		rightbeltbrace = new ModelRenderer(this, 16, 14);
		rightbeltbrace.addBox(-3F, 0F, -3F, 5, 1, 1);
		rightbeltbrace.setRotationPoint(0F, 0F, 0F);
		rightbeltbrace.setTextureSize(64, 32);
		rightbeltbrace.mirror = true;
		setRotation(rightbeltbrace, 0F, 0F, 0F);

		rightknee = new ModelRenderer(this, 0, 13);
		rightknee.addBox(-2F, 4F, -3F, 4, 2, 1);
		rightknee.setRotationPoint(0F, 0F, 0F);
		rightknee.setTextureSize(64, 32);
		rightknee.mirror = true;
		setRotation(rightknee, 0F, 0F, 0F);

		rightbeltbraceout = new ModelRenderer(this, 16, 6);
		rightbeltbraceout.addBox(-3F, 0F, -2F, 1, 1, 4);
		rightbeltbraceout.setRotationPoint(0F, 0F, 0F);
		rightbeltbraceout.setTextureSize(64, 32);
		rightbeltbraceout.mirror = true;
		setRotation(rightbeltbraceout, 0F, 0F, 0F);

		rightkneeconnector = new ModelRenderer(this, 16, 3);
		rightkneeconnector.addBox(-3F, 4F, -2F, 1, 1, 2);
		rightkneeconnector.setRotationPoint(0F, 0F, 0F);
		rightkneeconnector.setTextureSize(64, 32);
		rightkneeconnector.mirror = true;
		setRotation(rightkneeconnector, 0F, 0F, 0F);

		rightbeltbraceback = new ModelRenderer(this, 16, 11);
		rightbeltbraceback.addBox(-3F, 0F, 2F, 5, 2, 1);
		rightbeltbraceback.setRotationPoint(0F, 0F, 0F);
		rightbeltbraceback.setTextureSize(64, 32);
		rightbeltbraceback.mirror = true;
		setRotation(rightbeltbraceback, 0F, 0F, 0F);

		right = new ModelRenderer(this, 0, 0);
		right.addBox(-3F, 1F, 0F, 1, 9, 1);
		right.setRotationPoint(0F, 0F, 0F);
		right.setTextureSize(64, 32);
		right.mirror = true;
		setRotation(right, 0F, 0F, 0F);
		right.mirror = false;

		this.bipedLeftLeg.addChild(left);
		this.bipedLeftLeg.addChild(leftbeltbrace);
		this.bipedLeftLeg.addChild(leftknee);
		this.bipedLeftLeg.addChild(leftbeltbraceout);
		this.bipedLeftLeg.addChild(leftkneeconnector);
		this.bipedLeftLeg.addChild(leftbeltbraceback);

		this.bipedRightLeg.addChild(right);
		this.bipedRightLeg.addChild(rightbeltbrace);
		this.bipedRightLeg.addChild(rightknee);
		this.bipedRightLeg.addChild(rightbeltbraceout);
		this.bipedRightLeg.addChild(rightkneeconnector);
		this.bipedRightLeg.addChild(rightbeltbraceback);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	
	public void defaultRender(float f) {
		left.render(f);
		leftbeltbrace.render(f);
		leftknee.render(f);
		leftbeltbraceout.render(f);
		leftkneeconnector.render(f);
		leftbeltbraceback.render(f);
		
		right.render(f);
		rightbeltbrace.render(f);
		rightknee.render(f);
		rightbeltbraceout.render(f);
		rightkneeconnector.render(f);
		rightbeltbraceback.render(f);
	}
	
	public void renderInventory(float f) {
		GL11.glTranslatef(0.2F, -0.5F, 0F);
		
		left.render(f);
		leftbeltbrace.render(f);
		leftknee.render(f);
		leftbeltbraceout.render(f);
		leftkneeconnector.render(f);
		leftbeltbraceback.render(f);
		
		GL11.glTranslatef(-0.4F, 0F, 0F);
		
		right.render(f);
		rightbeltbrace.render(f);
		rightknee.render(f);
		rightbeltbraceout.render(f);
		rightkneeconnector.render(f);
		rightbeltbraceback.render(f);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
