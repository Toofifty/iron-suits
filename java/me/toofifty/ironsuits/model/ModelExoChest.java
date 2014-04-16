package me.toofifty.ironsuits.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelExoChest extends ModelArmorBase {
	// fields
	ModelRenderer chestmiddle;
	ModelRenderer chestmiddlesides;
	ModelRenderer frontbelt;
	ModelRenderer spine;
	ModelRenderer backbelt;
	ModelRenderer neckplateback;
	ModelRenderer rightbelt;
	ModelRenderer neckplate;
	ModelRenderer leftbelt;
	ModelRenderer frontrightneck;
	ModelRenderer frontleftconnector1;
	ModelRenderer frontleftneck;
	ModelRenderer frontrightconnector2;
	ModelRenderer frontrightconnector1;
	ModelRenderer frontleftconnector2;
	ModelRenderer vert1;
	ModelRenderer vert2;
	ModelRenderer vert3;
	ModelRenderer vert4;
	ModelRenderer leftshoulder;
	ModelRenderer leftarmmain;
	ModelRenderer leftfistfb;
	ModelRenderer leftfistsides;
	ModelRenderer leftfistknuckles;
	ModelRenderer leftelbow;
	ModelRenderer leftelbowsides;
	ModelRenderer rightshoulder;
	ModelRenderer rightarmmain;
	ModelRenderer rightfistfb;
	ModelRenderer rightfistsides;
	ModelRenderer rightfistknuckles;
	ModelRenderer rightelbowsides;
	ModelRenderer rightelbow;

	public ModelExoChest(float f) {
		super(f);
		
		textureWidth = 64;
		textureHeight = 32;
		
		chestmiddle = new ModelRenderer(this, 0, 25);
		chestmiddle.addBox(-2F, 1F, -3F, 4, 6, 1);
		chestmiddle.setRotationPoint(0F, 0F, 0F);
		chestmiddle.setTextureSize(64, 32);
		chestmiddle.mirror = true;
		setRotation(chestmiddle, 0F, 0F, 0F);
		
		chestmiddlesides = new ModelRenderer(this, 2, 16);
		chestmiddlesides.addBox(-3F, 2F, -3F, 6, 4, 1);
		chestmiddlesides.setRotationPoint(0F, 0F, 0F);
		chestmiddlesides.setTextureSize(64, 32);
		chestmiddlesides.mirror = true;
		setRotation(chestmiddlesides, 0F, 0F, 0F);
		
		frontbelt = new ModelRenderer(this, 34, 13);
		frontbelt.addBox(-5F, 10F, -3F, 10, 2, 1);
		frontbelt.setRotationPoint(0F, 0F, 0F);
		frontbelt.setTextureSize(64, 32);
		frontbelt.mirror = true;
		setRotation(frontbelt, 0F, 0F, 0F);
		
		spine = new ModelRenderer(this, 10, 21);
		spine.addBox(-1F, 0F, 2F, 2, 10, 1);
		spine.setRotationPoint(0F, 0F, 0F);
		spine.setTextureSize(64, 32);
		spine.mirror = true;
		setRotation(spine, 0F, 0F, 0F);
		
		backbelt = new ModelRenderer(this, 34, 10);
		backbelt.addBox(-5F, 10F, 2F, 10, 2, 1);
		backbelt.setRotationPoint(0F, 0F, 0F);
		backbelt.setTextureSize(64, 32);
		backbelt.mirror = true;
		setRotation(backbelt, 0F, 0F, 0F);
		
		neckplateback = new ModelRenderer(this, 0, 14);
		neckplateback.addBox(-1F, -1F, 3F, 2, 1, 1);
		neckplateback.setRotationPoint(0F, 0F, 0F);
		neckplateback.setTextureSize(64, 32);
		neckplateback.mirror = true;
		setRotation(neckplateback, 0F, 0F, 0F);
		
		rightbelt = new ModelRenderer(this, 46, 4);
		rightbelt.addBox(-5F, 10F, -2F, 1, 2, 4);
		rightbelt.setRotationPoint(0F, 0F, 0F);
		rightbelt.setTextureSize(64, 32);
		rightbelt.mirror = true;
		setRotation(rightbelt, 0F, 0F, 0F);
		
		neckplate = new ModelRenderer(this, 16, 10);
		neckplate.addBox(-2F, -1F, -2F, 4, 1, 5);
		neckplate.setRotationPoint(0F, 0F, 0F);
		neckplate.setTextureSize(64, 32);
		neckplate.mirror = true;
		setRotation(neckplate, 0F, 0F, 0F);
		
		leftbelt = new ModelRenderer(this, 36, 4);
		leftbelt.addBox(4F, 10F, -2F, 1, 2, 4);
		leftbelt.setRotationPoint(0F, 0F, 0F);
		leftbelt.setTextureSize(64, 32);
		leftbelt.mirror = true;
		setRotation(leftbelt, 0F, 0F, 0F);
		
		frontrightneck = new ModelRenderer(this, 30, 12);
		frontrightneck.addBox(-3F, -1F, -3F, 1, 2, 1);
		frontrightneck.setRotationPoint(0F, 0F, 0F);
		frontrightneck.setTextureSize(64, 32);
		frontrightneck.mirror = true;
		setRotation(frontrightneck, 0F, 0F, 0F);
		
		frontleftconnector1 = new ModelRenderer(this, 42, 5);
		frontleftconnector1.addBox(2F, 7F, -3F, 1, 2, 1);
		frontleftconnector1.setRotationPoint(0F, 0F, 0F);
		frontleftconnector1.setTextureSize(64, 32);
		frontleftconnector1.mirror = true;
		setRotation(frontleftconnector1, 0F, 0F, 0F);
		
		frontleftneck = new ModelRenderer(this, 16, 12);
		frontleftneck.addBox(2F, -1F, -3F, 1, 2, 1);
		frontleftneck.setRotationPoint(0F, 0F, 0F);
		frontleftneck.setTextureSize(64, 32);
		frontleftneck.mirror = true;
		setRotation(frontleftneck, 0F, 0F, 0F);
		
		frontrightconnector2 = new ModelRenderer(this, 36, 6);
		frontrightconnector2.addBox(-4F, 9F, -3F, 1, 1, 1);
		frontrightconnector2.setRotationPoint(0F, 0F, 0F);
		frontrightconnector2.setTextureSize(64, 32);
		frontrightconnector2.mirror = true;
		setRotation(frontrightconnector2, 0F, 0F, 0F);
		
		frontrightconnector1 = new ModelRenderer(this, 46, 5);
		frontrightconnector1.addBox(-3F, 7F, -3F, 1, 2, 1);
		frontrightconnector1.setRotationPoint(0F, 0F, 0F);
		frontrightconnector1.setTextureSize(64, 32);
		frontrightconnector1.mirror = true;
		setRotation(frontrightconnector1, 0F, 0F, 0F);
		
		frontleftconnector2 = new ModelRenderer(this, 36, 4);
		frontleftconnector2.addBox(3F, 9F, -3F, 1, 1, 1);
		frontleftconnector2.setRotationPoint(0F, 0F, 0F);
		frontleftconnector2.setTextureSize(64, 32);
		frontleftconnector2.mirror = true;
		setRotation(frontleftconnector2, 0F, 0F, 0F);
		
		vert1 = new ModelRenderer(this, 0, 21);
		vert1.addBox(-2F, 2F, 2F, 4, 1, 1);
		vert1.setRotationPoint(0F, 0F, 0F);
		vert1.setTextureSize(64, 32);
		vert1.mirror = true;
		setRotation(vert1, 0F, 0F, 0F);
		
		vert2 = new ModelRenderer(this, 0, 23);
		vert2.addBox(-2F, 4F, 2F, 4, 1, 1);
		vert2.setRotationPoint(0F, 0F, 0F);
		vert2.setTextureSize(64, 32);
		vert2.mirror = true;
		setRotation(vert2, 0F, 0F, 0F);
		
		vert3 = new ModelRenderer(this, 6, 14);
		vert3.addBox(-2F, 6F, 2F, 4, 1, 1);
		vert3.setRotationPoint(0F, 0F, 0F);
		vert3.setTextureSize(64, 32);
		vert3.mirror = true;
		setRotation(vert3, 0F, 0F, 0F);
		
		vert4 = new ModelRenderer(this, 6, 12);
		vert4.addBox(-2F, 8F, 2F, 4, 1, 1);
		vert4.setRotationPoint(0F, 0F, 0F);
		vert4.setTextureSize(64, 32);
		vert4.mirror = true;
		setRotation(vert4, 0F, 0F, 0F);
		
		leftshoulder = new ModelRenderer(this, 36, 1);
		leftshoulder.addBox(-3F, -3F, -1F, 7, 1, 2);
		leftshoulder.setRotationPoint(0F, 0F, 0F);
		leftshoulder.setTextureSize(64, 32);
		leftshoulder.mirror = true;
		setRotation(leftshoulder, 0F, 0F, 0F);
		
		leftarmmain = new ModelRenderer(this, 58, 21);
		leftarmmain.addBox(3F, -2F, -1F, 1, 9, 2);
		leftarmmain.setRotationPoint(0F, 0F, 0F);
		leftarmmain.setTextureSize(64, 32);
		leftarmmain.mirror = true;
		setRotation(leftarmmain, 0F, 0F, 0F);
		
		leftfistfb = new ModelRenderer(this, 16, 1);
		leftfistfb.addBox(-1F, 7F, -3F, 4, 3, 6);
		leftfistfb.setRotationPoint(0F, 0F, 0F);
		leftfistfb.setTextureSize(64, 32);
		leftfistfb.mirror = true;
		setRotation(leftfistfb, 0F, 0F, 0F);
		
		leftfistsides = new ModelRenderer(this, 16, 3);
		leftfistsides.addBox(-2F, 7F, -2F, 6, 3, 4);
		leftfistsides.setRotationPoint(0F, 0F, 0F);
		leftfistsides.setTextureSize(64, 32);
		leftfistsides.mirror = true;
		setRotation(leftfistsides, 0F, 0F, 0F);
		
		leftfistknuckles = new ModelRenderer(this, 0, 7);
		leftfistknuckles.addBox(-1F, 10F, -2F, 4, 1, 4);
		leftfistknuckles.setRotationPoint(0F, 0F, 0F);
		leftfistknuckles.setTextureSize(64, 32);
		leftfistknuckles.mirror = true;
		setRotation(leftfistknuckles, 0F, 0F, 0F);
		
		leftelbow = new ModelRenderer(this, 0, 5);
		leftelbow.addBox(-1F, 3F, 2F, 4, 1, 1);
		leftelbow.setRotationPoint(0F, 0F, 0F);
		leftelbow.setTextureSize(64, 32);
		leftelbow.mirror = true;
		setRotation(leftelbow, 0F, 0F, 0F);
		
		leftelbowsides = new ModelRenderer(this, 0, 3);
		leftelbowsides.addBox(3F, 3F, 1F, 1, 1, 1);
		leftelbowsides.setRotationPoint(0F, 0F, 0F);
		leftelbowsides.setTextureSize(64, 32);
		leftelbowsides.mirror = true;
		setRotation(leftelbowsides, 0F, 0F, 0F);
		
		rightshoulder = new ModelRenderer(this, 36, 1);
		rightshoulder.addBox(-4F, -3F, -1F, 7, 1, 2);
		rightshoulder.setRotationPoint(0F, 0F, 0F);
		rightshoulder.setTextureSize(64, 32);
		rightshoulder.mirror = true;
		setRotation(rightshoulder, 0F, 0F, 0F);
		
		rightarmmain = new ModelRenderer(this, 58, 21);
		rightarmmain.addBox(-4F, -2F, -1F, 1, 9, 2);
		rightarmmain.setRotationPoint(0F, 0F, 0F);
		rightarmmain.setTextureSize(64, 32);
		rightarmmain.mirror = true;
		setRotation(rightarmmain, 0F, 0F, 0F);
		
		rightfistfb = new ModelRenderer(this, 16, 1);
		rightfistfb.addBox(-3F, 7F, -3F, 4, 3, 6);
		rightfistfb.setRotationPoint(0F, 0F, 0F);
		rightfistfb.setTextureSize(64, 32);
		rightfistfb.mirror = true;
		setRotation(rightfistfb, 0F, 0F, 0F);
		
		rightfistsides = new ModelRenderer(this, 16, 3);
		rightfistsides.addBox(-4F, 7.0F, -2F, 6, 3, 4);
		rightfistsides.setRotationPoint(0F, 0F, 0F);
		rightfistsides.setTextureSize(64, 32);
		rightfistsides.mirror = true;
		setRotation(rightfistsides, 0F, 0F, 0F);
		
		rightfistknuckles = new ModelRenderer(this, 0, 7);
		rightfistknuckles.addBox(-3F, 10F, -2F, 4, 1, 4);
		rightfistknuckles.setRotationPoint(0F, 0F, 0F);
		rightfistknuckles.setTextureSize(64, 32);
		rightfistknuckles.mirror = true;
		setRotation(rightfistknuckles, 0F, 0F, 0F);
		
		rightelbowsides = new ModelRenderer(this, 0, 3);
		rightelbowsides.addBox(-4F, 3F, 1F, 1, 1, 1);
		rightelbowsides.setRotationPoint(0F, 0F, 0F);
		rightelbowsides.setTextureSize(64, 32);
		rightelbowsides.mirror = true;
		setRotation(rightelbowsides, 0F, 0F, 0F);
		
		rightelbow = new ModelRenderer(this, 0, 5);
		rightelbow.addBox(-3F, 3F, 2F, 4, 1, 1);
		rightelbow.setRotationPoint(0F, 0F, 0F);
		rightelbow.setTextureSize(64, 32);
		rightelbow.mirror = true;
		setRotation(rightelbow, 0F, 0F, 0F);
		

		this.bipedBody.addChild(chestmiddle);
		this.bipedBody.addChild(chestmiddlesides);
		this.bipedBody.addChild(frontbelt);
		this.bipedBody.addChild(spine);
		this.bipedBody.addChild(backbelt);
		this.bipedBody.addChild(neckplateback);
		this.bipedBody.addChild(rightbelt);
		this.bipedBody.addChild(neckplate);
		this.bipedBody.addChild(leftbelt);
		this.bipedBody.addChild(frontrightneck);
		this.bipedBody.addChild(frontleftconnector1);
		this.bipedBody.addChild(frontleftneck);
		this.bipedBody.addChild(frontrightconnector2);
		this.bipedBody.addChild(frontrightconnector1);
		this.bipedBody.addChild(frontleftconnector2);
		this.bipedBody.addChild(vert1);
		this.bipedBody.addChild(vert2);
		this.bipedBody.addChild(vert3);
		this.bipedBody.addChild(vert4);

		this.bipedLeftArm.addChild(leftshoulder);
		this.bipedLeftArm.addChild(leftarmmain);
		this.bipedLeftArm.addChild(leftfistfb);
		this.bipedLeftArm.addChild(leftfistsides);
		this.bipedLeftArm.addChild(leftfistknuckles);
		this.bipedLeftArm.addChild(leftelbow);
		this.bipedLeftArm.addChild(leftelbowsides);

		this.bipedRightArm.addChild(rightshoulder);
		this.bipedRightArm.addChild(rightarmmain);
		this.bipedRightArm.addChild(rightfistfb);
		this.bipedRightArm.addChild(rightfistsides);
		this.bipedRightArm.addChild(rightfistknuckles);
		this.bipedRightArm.addChild(rightelbow);
		this.bipedRightArm.addChild(rightelbowsides);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	
	public void defaultRender(float f) {
		this.chestmiddle.render(f);
		this.chestmiddlesides.render(f);
		this.frontbelt.render(f);
		this.spine.render(f);
		this.backbelt.render(f);
		this.neckplateback.render(f);
		this.rightbelt.render(f);
		this.leftbelt.render(f);
		this.neckplate.render(f);
		this.frontrightneck.render(f);
		this.frontleftconnector1.render(f);
		this.frontleftneck.render(f);
		this.frontrightconnector2.render(f);
		this.frontrightconnector1.render(f);
		this.frontleftconnector2.render(f);
		this.vert1.render(f);
		this.vert2.render(f);
		this.vert3.render(f);
		this.vert4.render(f);
	}
	
	public void renderInventory(float f) {
		GL11.glTranslatef(0F, -0.6F, 0F);
		
		this.chestmiddle.render(f);
		this.chestmiddlesides.render(f);
		this.frontbelt.render(f);
		this.spine.render(f);
		this.backbelt.render(f);
		this.neckplateback.render(f);
		this.rightbelt.render(f);
		this.leftbelt.render(f);
		this.neckplate.render(f);
		this.frontrightneck.render(f);
		this.frontleftconnector1.render(f);
		this.frontleftneck.render(f);
		this.frontrightconnector2.render(f);
		this.frontrightconnector1.render(f);
		this.frontleftconnector2.render(f);
		this.vert1.render(f);
		this.vert2.render(f);
		this.vert3.render(f);
		this.vert4.render(f);
		
		GL11.glTranslatef(0.2F, 0.2F, 0F);
		
		leftshoulder.render(f);
		leftarmmain.render(f);
		//leftfistfb.render(f);
		//leftfistsides.render(f);
		//leftfistknuckles.render(f);
		leftelbow.render(f);
		leftelbowsides.render(f);

		GL11.glTranslatef(-0.4F, 0F, 0F);
		
		rightshoulder.render(f);
		rightarmmain.render(f);
		//rightfistfb.render(f);
		//rightfistsides.render(f);
		//rightfistknuckles.render(f);
		rightelbow.render(f);
		rightelbowsides.render(f);
		
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
