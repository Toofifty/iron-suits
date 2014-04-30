package me.toofifty.ironsuits.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;

public class ModelArmor extends ModelBiped {
	
	private HashMap model;
	private HashMap pieceMap = new HashMap();
	private int textureX;
	private int textureY;

	private int[] textureOffset = new int[2];
	private float[] position = new float[3];
	private int[] size = new int[3];
	private float[] rotation = new float[3];
	private String bipedPiece = null;
	
	private ModelRenderer temp = null;
	
	public ModelArmor(String file, int tX, int tY) {
		super(1, 0, tX, tY);

		model = ParseModel.model(file);
		
		Set k = model.entrySet();
		
		Iterator i = k.iterator();
		
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry)i.next();
			if (me.getValue() instanceof Integer) {
				if (me.getKey().equals("textureX")) {
					textureX = (Integer) me.getValue();
					this.textureWidth = textureX;
				} else if (me.getKey().equals("textureY")) {
					textureY = (Integer) me.getValue();
					this.textureHeight = textureY;
				} else {
					System.out.println("Incorrect formatting at " + me.getKey());
				}
			} else if (me.getValue() instanceof HashMap) {
				textureOffset = (int[]) ((HashMap)me.getValue()).get("textureOffset");
				position = (float[]) ((HashMap)me.getValue()).get("position");
				size = (int[]) ((HashMap)me.getValue()).get("size");
				rotation = (float[]) ((HashMap)me.getValue()).get("rotation");
				bipedPiece = (String) ((HashMap)me.getValue()).get("bipedPiece");
				
				//System.out.println("'"+me.getKey()+"' found, texture " +
				//		textureOffset[0] +","+  textureOffset[1] +
				//		" | position: "+position[0]+","+position[1]+","+position[2]+
				//		" | size: "+size[0]+","+size[1]+","+size[2]+
				//		" | rotation: "+rotation[0]+","+rotation[1]+","+rotation[2]+
				//		" | bipedPiece: " + bipedPiece);
				
				drawPiece(textureOffset, position, size, rotation, bipedPiece);
				
			} else {
				System.out.println("Value of following is not a HashMap or int: " + me.getKey());
			}
		}
		
		drawChildren();
		
	}
	
	private void drawPiece(int[] textureOffset, float[] position, int[] size, float[] rotation, String bipedPiece) {
		temp = new ModelRenderer(this, textureOffset[0], textureOffset[1]);
		temp.addBox(position[0], position[1], position[2], size[0], size[1], size[2]);
		temp.setTextureSize(textureX, textureY);
		temp.mirror = false;
		setRotation(temp, rotation[0], rotation[1], rotation[2]);
		pieceMap.put(temp, bipedPiece);
	}
	
	private void drawChildren() {
		Set i = pieceMap.entrySet();
		Iterator j = i.iterator();
		while (j.hasNext()) {
			Map.Entry me = (Map.Entry)j.next();
			String str = (String)me.getValue();
			ModelRenderer obj = (ModelRenderer) me.getKey();
			System.out.println("Attaching "+me.getKey()+" to "+me.getValue());
			
			if (str.equals("bipedHead")) {
				this.bipedHead.addChild(obj);
			} else if (str.equals("bipedBody")) {
				this.bipedBody.addChild(obj);
			} else if (str.equals("bipedCloak")) {
				this.bipedCloak.addChild(obj);
			} else if (str.equals("bipedHeadwear")) {
				this.bipedHeadwear.addChild(obj);
			} else if (str.equals("bipedLeftArm")) {
				this.bipedLeftArm.addChild(obj);
			} else if (str.equals("bipedLeftLeg")) {
				this.bipedLeftLeg.addChild(obj);
			} else if (str.equals("bipedRightArm")) {
				this.bipedRightArm.addChild(obj);
			} else if (str.equals("bipedRightLeg")) {
				this.bipedRightLeg.addChild(obj);
			} else if (str.equals("bipedEars")) {
				this.bipedEars.addChild(obj);
			}
		}
	}
	
	public void renderI(float f) {
		// No extra offsets are needed for helmets, they are the standard.
		// Other pieces will need separate offsets for arms, legs, etc.
		Set i = pieceMap.entrySet();
		Iterator j = i.iterator();
		while (j.hasNext()) {
			Map.Entry me = (Map.Entry)j.next();
			ModelRenderer obj = (ModelRenderer)me.getKey();
			String str = (String)me.getValue();
			
			GL11.glScalef(1F, 1F, 1F);
			
			if (str.equals("bipedHead")) {
				obj.render(f);
			} else if (str.equals("bipedBody")) {
				GL11.glTranslatef(0F, -0.65F, 0F);
				obj.render(f);
				GL11.glTranslatef(0F, 0.65F, 0F);
			} else if (str.equals("bipedCloak")) {
			} else if (str.equals("bipedHeadwear")) {
			} else if (str.equals("bipedLeftArm")) {
				GL11.glTranslatef(0.35F, -0.55F, 0F);
				obj.render(f);
				GL11.glTranslatef(-0.35F, 0.55F, 0F);
			} else if (str.equals("bipedRightArm")) {
				GL11.glTranslatef(-0.35F, -0.55F, 0F);
				obj.render(f);
				GL11.glTranslatef(0.35F, 0.55F, 0F);
			} else if (str.equals("bipedLeftLeg")) {
				GL11.glTranslatef(0.15F, -0.65F, 0F);
				obj.render(f);
				GL11.glTranslatef(-0.15F, 0.65F, 0F);
			} else if (str.equals("bipedRightLeg")) {
				GL11.glTranslatef(-0.15F, -0.65F, 0F);
				obj.render(f);
				GL11.glTranslatef(0.15F, 0.65F, 0F);
			} else if (str.equals("bipedEars")) {
			}
		}
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
