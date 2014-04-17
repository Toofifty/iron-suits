package me.toofifty.ironsuits.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLightHelmet extends ModelArmorBase {
	// fields
	ModelRenderer facechin;
	ModelRenderer facecentre;
	ModelRenderer facebrowleft;
	ModelRenderer faceleft;
	ModelRenderer faceleftstache;
	ModelRenderer facefore;
	ModelRenderer facerightstache;
	ModelRenderer faceright;
	ModelRenderer facebrowright;
	ModelRenderer topmain;
	ModelRenderer topleftfront;
	ModelRenderer topleftmiddle;
	ModelRenderer topfront;
	ModelRenderer toprightmiddle;
	ModelRenderer toprightfront;
	ModelRenderer leftchin;
	ModelRenderer leftmain;
	ModelRenderer leftear;
	ModelRenderer leftfrontear;
	ModelRenderer leftstripe1;
	ModelRenderer leftstripe2;
	ModelRenderer rightchin;
	ModelRenderer rightmain;
	ModelRenderer rightear;
	ModelRenderer rightfrontear;
	ModelRenderer rightstripe1;
	ModelRenderer rightstripe2;
	ModelRenderer backmain;
	ModelRenderer backcentre;
	ModelRenderer backcentretopleft;
	ModelRenderer backleft;
	ModelRenderer backlower;
	ModelRenderer backcentretopright;
	ModelRenderer backright;
	ModelRenderer bottommain;

	public ModelLightHelmet(float f) {
		super(f, 0, 64, 64);
		
		textureWidth = 64;
		textureHeight = 64;

		facechin = new ModelRenderer(this, 0, 29);
		facechin.addBox(-4F, -1F, -5F, 8, 2, 1);
		facechin.setRotationPoint(0F, 0F, 0F);
		facechin.setTextureSize(64, 64);
		facechin.mirror = true;
		setRotation(facechin, 0F, 0F, 0F);
		
		facecentre = new ModelRenderer(this, 0, 26);
		facecentre.addBox(-1F, -7F, -5F, 2, 2, 1);
		facecentre.setRotationPoint(0F, 0F, 0F);
		facecentre.setTextureSize(64, 64);
		facecentre.mirror = true;
		setRotation(facecentre, 0F, 0F, 0F);
		
		facebrowleft = new ModelRenderer(this, 6, 26);
		facebrowleft.addBox(1F, -8F, -4.7F, 3, 2, 1);
		facebrowleft.setRotationPoint(0F, 0F, 0F);
		facebrowleft.setTextureSize(64, 64);
		facebrowleft.mirror = true;
		setRotation(facebrowleft, 0F, 0F, 0F);
		
		faceleft = new ModelRenderer(this, 60, 16);
		faceleft.addBox(3F, -6F, -4.8F, 1, 5, 1);
		faceleft.setRotationPoint(0F, 0F, 0F);
		faceleft.setTextureSize(64, 64);
		faceleft.mirror = true;
		setRotation(faceleft, 0F, 0F, 0F);
		
		faceleftstache = new ModelRenderer(this, 0, 24);
		faceleftstache.addBox(1F, -2F, -4.9F, 2, 1, 1);
		faceleftstache.setRotationPoint(0F, 0F, 0F);
		faceleftstache.setTextureSize(64, 64);
		faceleftstache.mirror = true;
		setRotation(faceleftstache, 0F, 0F, 0F);
		
		facefore = new ModelRenderer(this, 0, 22);
		facefore.addBox(-1F, -8F, -4.5F, 2, 1, 1);
		facefore.setRotationPoint(0F, 0F, 0F);
		facefore.setTextureSize(64, 64);
		facefore.mirror = true;
		setRotation(facefore, 0F, 0F, 0F);
		
		facerightstache = new ModelRenderer(this, 0, 24);
		facerightstache.addBox(-3F, -2F, -4.9F, 2, 1, 1);
		facerightstache.setRotationPoint(0F, 0F, 0F);
		facerightstache.setTextureSize(64, 64);
		facerightstache.mirror = true;
		setRotation(facerightstache, 0F, 0F, 0F);
		
		faceright = new ModelRenderer(this, 60, 16);
		faceright.addBox(-4F, -6F, -4.8F, 1, 5, 1);
		faceright.setRotationPoint(0F, 0F, 0F);
		faceright.setTextureSize(64, 64);
		faceright.mirror = true;
		setRotation(faceright, 0F, 0F, 0F);
		
		facebrowright = new ModelRenderer(this, 6, 26);
		facebrowright.addBox(-4F, -8F, -4.7F, 3, 2, 1);
		facebrowright.setRotationPoint(0F, 0F, 0F);
		facebrowright.setTextureSize(64, 64);
		facebrowright.mirror = true;
		setRotation(facebrowright, 0F, 0F, 0F);
		
		topmain = new ModelRenderer(this, 0, 32);
		topmain.addBox(-4F, -8.6F, -4F, 8, 1, 8);
		topmain.setRotationPoint(0F, 0F, 0F);
		topmain.setTextureSize(64, 64);
		topmain.mirror = true;
		setRotation(topmain, 0F, 0F, 0F);
		
		topleftfront = new ModelRenderer(this, 0, 41);
		topleftfront.addBox(1F, -9F, -4F, 2, 1, 3);
		topleftfront.setRotationPoint(0F, 0F, 0F);
		topleftfront.setTextureSize(64, 64);
		topleftfront.mirror = true;
		setRotation(topleftfront, 0F, 0F, 0F);
		
		topleftmiddle = new ModelRenderer(this, 10, 41);
		topleftmiddle.addBox(1.5F, -9F, -1F, 2, 1, 4);
		topleftmiddle.setRotationPoint(0F, 0F, 0F);
		topleftmiddle.setTextureSize(64, 64);
		topleftmiddle.mirror = true;
		setRotation(topleftmiddle, 0F, 0F, 0F);
		
		topfront = new ModelRenderer(this, 32, 16);
		topfront.addBox(-0.5F, -8.75F, -3F, 1, 1, 6);
		topfront.setRotationPoint(0F, 0F, 0F);
		topfront.setTextureSize(64, 64);
		topfront.mirror = true;
		setRotation(topfront, 0F, 0F, 0F);
		
		toprightmiddle = new ModelRenderer(this, 10, 41);
		toprightmiddle.addBox(-3.5F, -9F, -1F, 2, 1, 4);
		toprightmiddle.setRotationPoint(0F, 0F, 0F);
		toprightmiddle.setTextureSize(64, 64);
		toprightmiddle.mirror = true;
		setRotation(toprightmiddle, 0F, 0F, 0F);
		
		toprightfront = new ModelRenderer(this, 0, 41);
		toprightfront.addBox(-3F, -9F, -4F, 2, 1, 3);
		toprightfront.setRotationPoint(0F, 0F, 0F);
		toprightfront.setTextureSize(64, 64);
		toprightfront.mirror = true;
		setRotation(toprightfront, 0F, 0F, 0F);
		
		leftchin = new ModelRenderer(this, 0, 16);
		leftchin.addBox(4F, -2F, -4F, 1, 3, 3);
		leftchin.setRotationPoint(0F, 0F, 0F);
		leftchin.setTextureSize(64, 64);
		leftchin.mirror = true;
		setRotation(leftchin, 0F, 0F, 0F);
		
		leftmain = new ModelRenderer(this, 46, 16);
		leftmain.addBox(3.6F, -8F, -4F, 1, 8, 8);
		leftmain.setRotationPoint(0F, 0F, 0F);
		leftmain.setTextureSize(64, 64);
		leftmain.mirror = true;
		setRotation(leftmain, 0F, 0F, 0F);
		
		leftear = new ModelRenderer(this, 14, 22);
		leftear.addBox(4F, -6F, -2F, 1, 2, 5);
		leftear.setRotationPoint(0F, 0F, 0F);
		leftear.setTextureSize(64, 64);
		leftear.mirror = true;
		setRotation(leftear, 0F, 0F, 0F);
		
		leftfrontear = new ModelRenderer(this, 6, 22);
		leftfrontear.addBox(3.8F, -5F, -4F, 1, 2, 2);
		leftfrontear.setRotationPoint(0F, 0F, 0F);
		leftfrontear.setTextureSize(64, 64);
		leftfrontear.mirror = true;
		setRotation(leftfrontear, 0F, 0F, 0F);
		
		leftstripe1 = new ModelRenderer(this, 8, 17);
		leftstripe1.addBox(3.7F, -3.5F, -1F, 1, 1, 4);
		leftstripe1.setRotationPoint(0F, 0F, 0F);
		leftstripe1.setTextureSize(64, 64);
		leftstripe1.mirror = true;
		setRotation(leftstripe1, 0F, 0F, 0F);
		
		leftstripe2 = new ModelRenderer(this, 8, 17);
		leftstripe2.addBox(3.7F, -2F, -1F, 1, 1, 4);
		leftstripe2.setRotationPoint(0F, 0F, 0F);
		leftstripe2.setTextureSize(64, 64);
		leftstripe2.mirror = true;
		setRotation(leftstripe2, 0F, 0F, 0F);
		
		rightchin = new ModelRenderer(this, 0, 16);
		rightchin.addBox(-5F, -2F, -4F, 1, 3, 3);
		rightchin.setRotationPoint(0F, 0F, 0F);
		rightchin.setTextureSize(64, 64);
		rightchin.mirror = true;
		setRotation(rightchin, 0F, 0F, 0F);
		
		rightmain = new ModelRenderer(this, 46, 16);
		rightmain.addBox(-4.6F, -8F, -4F, 1, 8, 8);
		rightmain.setRotationPoint(0F, 0F, 0F);
		rightmain.setTextureSize(64, 64);
		rightmain.mirror = true;
		setRotation(rightmain, 0F, 0F, 0F);
		
		rightear = new ModelRenderer(this, 14, 22);
		rightear.addBox(-5F, -6F, -2F, 1, 2, 5);
		rightear.setRotationPoint(0F, 0F, 0F);
		rightear.setTextureSize(64, 64);
		rightear.mirror = true;
		setRotation(rightear, 0F, 0F, 0F);
		
		rightfrontear = new ModelRenderer(this, 6, 22);
		rightfrontear.addBox(-4.8F, -5F, -4F, 1, 2, 2);
		rightfrontear.setRotationPoint(0F, 0F, 0F);
		rightfrontear.setTextureSize(64, 64);
		rightfrontear.mirror = true;
		setRotation(rightfrontear, 0F, 0F, 0F);
		
		rightstripe1 = new ModelRenderer(this, 8, 17);
		rightstripe1.addBox(-4.7F, -3.5F, -1F, 1, 1, 4);
		rightstripe1.setRotationPoint(0F, 0F, 0F);
		rightstripe1.setTextureSize(64, 64);
		rightstripe1.mirror = true;
		setRotation(rightstripe1, 0F, 0F, 0F);
		
		rightstripe2 = new ModelRenderer(this, 8, 17);
		rightstripe2.addBox(-4.7F, -2F, -1F, 1, 1, 4);
		rightstripe2.setRotationPoint(0F, 0F, 0F);
		rightstripe2.setTextureSize(64, 64);
		rightstripe2.mirror = true;
		setRotation(rightstripe2, 0F, 0F, 0F);
		
		backmain = new ModelRenderer(this, 28, 23);
		backmain.addBox(-4F, -8F, 3.5F, 8, 8, 1);
		backmain.setRotationPoint(0F, 0F, 0F);
		backmain.setTextureSize(64, 64);
		backmain.mirror = true;
		setRotation(backmain, 0F, 0F, 0F);
		
		backcentre = new ModelRenderer(this, 18, 16);
		backcentre.addBox(-3F, -7F, 4F, 6, 2, 1);
		backcentre.setRotationPoint(0F, 0F, 0F);
		backcentre.setTextureSize(64, 64);
		backcentre.mirror = true;
		setRotation(backcentre, 0F, 0F, 0F);
		
		backcentretopleft = new ModelRenderer(this, 18, 19);
		backcentretopleft.addBox(1F, -8F, 3.7F, 2, 1, 1);
		backcentretopleft.setRotationPoint(0F, 0F, 0F);
		backcentretopleft.setTextureSize(64, 64);
		backcentretopleft.mirror = true;
		setRotation(backcentretopleft, 0F, 0F, 0F);
		
		backleft = new ModelRenderer(this, 18, 29);
		backleft.addBox(3F, -6.583333F, 3.733333F, 1, 2, 1);
		backleft.setRotationPoint(0F, 0F, 0F);
		backleft.setTextureSize(64, 64);
		backleft.mirror = true;
		setRotation(backleft, 0F, 0F, 0F);
		
		backlower = new ModelRenderer(this, 40, 18);
		backlower.addBox(-3F, -4F, 3.7F, 6, 3, 1);
		backlower.setRotationPoint(0F, 0F, 0F);
		backlower.setTextureSize(64, 64);
		backlower.mirror = true;
		setRotation(backlower, 0F, 0F, 0F);
		
		backcentretopright = new ModelRenderer(this, 18, 19);
		backcentretopright.addBox(-3F, -8F, 3.7F, 2, 1, 1);
		backcentretopright.setRotationPoint(0F, 0F, 0F);
		backcentretopright.setTextureSize(64, 64);
		backcentretopright.mirror = true;
		setRotation(backcentretopright, 0F, 0F, 0F);
		
		backright = new ModelRenderer(this, 18, 29);
		backright.addBox(-4F, -6.583333F, 3.733333F, 1, 2, 1);
		backright.setRotationPoint(0F, 0F, 0F);
		backright.setTextureSize(64, 64);
		backright.mirror = true;
		setRotation(backright, 0F, 0F, 0F);
		
		bottommain = new ModelRenderer(this, 0, 32);
		bottommain.addBox(-4F, -0.5F, -4F, 8, 1, 8);
		bottommain.setRotationPoint(0F, 0F, 0F);
		bottommain.setTextureSize(64, 64);
		bottommain.mirror = true;
		setRotation(bottommain, 0F, 0F, 0F);
		

		this.bipedHead.addChild(facechin);
		this.bipedHead.addChild(facecentre);
		this.bipedHead.addChild(facebrowleft);
		this.bipedHead.addChild(faceleft);
		this.bipedHead.addChild(faceleftstache);
		this.bipedHead.addChild(facefore);
		this.bipedHead.addChild(facerightstache);
		this.bipedHead.addChild(faceright);
		this.bipedHead.addChild(facebrowright);
		
		this.bipedHead.addChild(topmain);
		this.bipedHead.addChild(topleftfront);
		this.bipedHead.addChild(topleftmiddle);
		this.bipedHead.addChild(topfront);
		this.bipedHead.addChild(toprightfront);
		this.bipedHead.addChild(toprightmiddle);

		this.bipedHead.addChild(leftchin);
		this.bipedHead.addChild(leftmain);
		this.bipedHead.addChild(leftear);
		this.bipedHead.addChild(leftfrontear);
		this.bipedHead.addChild(leftstripe1);
		this.bipedHead.addChild(leftstripe2);

		this.bipedHead.addChild(rightchin);
		this.bipedHead.addChild(rightmain);
		this.bipedHead.addChild(rightear);
		this.bipedHead.addChild(rightfrontear);
		this.bipedHead.addChild(rightstripe1);
		this.bipedHead.addChild(rightstripe2);
		
		this.bipedHead.addChild(backmain);
		this.bipedHead.addChild(backcentre);
		this.bipedHead.addChild(backcentretopleft);
		this.bipedHead.addChild(backleft);
		this.bipedHead.addChild(backlower);
		this.bipedHead.addChild(backcentretopright);
		this.bipedHead.addChild(backright);
		
		this.bipedHead.addChild(bottommain);
		
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	
	public void renderInventory(float f5) {
		facechin.render(f5);
		facecentre.render(f5);
		facebrowleft.render(f5);
		faceleft.render(f5);
		faceleftstache.render(f5);
		facefore.render(f5);
		facerightstache.render(f5);
		faceright.render(f5);
		facebrowright.render(f5);
		topmain.render(f5);
		topleftfront.render(f5);
		topleftmiddle.render(f5);
		topfront.render(f5);
		toprightmiddle.render(f5);
		toprightfront.render(f5);
		leftchin.render(f5);
		leftmain.render(f5);
		leftear.render(f5);
		leftfrontear.render(f5);
		leftstripe1.render(f5);
		leftstripe2.render(f5);
		rightchin.render(f5);
		rightmain.render(f5);
		rightear.render(f5);
		rightfrontear.render(f5);
		rightstripe1.render(f5);
		rightstripe2.render(f5);
		backmain.render(f5);
		backcentre.render(f5);
		backcentretopleft.render(f5);
		backleft.render(f5);
		backlower.render(f5);
		backcentretopright.render(f5);
		backright.render(f5);
		bottommain.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
