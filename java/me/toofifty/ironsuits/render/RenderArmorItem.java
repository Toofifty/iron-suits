package me.toofifty.ironsuits.render;

import me.toofifty.ironsuits.armor.ArmorBase;
import me.toofifty.ironsuits.common.IronSuits;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderArmorItem implements IItemRenderer {

	protected ArmorBase armorItem;
	
	private double count;

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch(type) {
		case EQUIPPED_FIRST_PERSON: return true;
		case INVENTORY: return true;
		case EQUIPPED: return true;
		case ENTITY: return true;
		default: 
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		// Don't want to load an entire model every tick, do we...			
		if (this.armorItem == null) {
			this.armorItem = (ArmorBase)item.getItem();
		}
				
		if (type == ItemRenderType.INVENTORY) {
			GL11.glPushMatrix();

			GL11.glRotatef(180, 0F, 1F, 0F); // Flip right side up
			GL11.glScalef(12F, 12F, 12F); // Fix inventory down-sizing
			GL11.glRotatef(10, 1F, 0F, 0F); // Tilt forward
			GL11.glTranslatef(-0.65F, 1F, 0F); // Align with slots

			GL11.glFrontFace(GL11.GL_CW);

			Minecraft.getMinecraft().renderEngine
					.bindTexture(this.armorItem.resourceLocation);
			GL11.glRotatef(IronSuits.rotator, 0F, 1F, 0F); // Apply subtle
															// rotation

			// Any additional translations need to be made in renderInventory!
			this.armorItem.armorModel.renderI(0.0625F);

			GL11.glFrontFace(GL11.GL_CCW);

			GL11.glPopMatrix();

		} else if (type == ItemRenderType.EQUIPPED) {
			GL11.glPushMatrix();
			// GL11.glRotatef(180, 0F, 1F, 0F); // Flip right side up
			GL11.glRotatef(-70, 0F, 0F, 1F);
			GL11.glScalef(0.8F, 0.8F, 0.8F);
			GL11.glTranslatef(-0.2F, 1.5F, 0F);
			Minecraft.getMinecraft().renderEngine
					.bindTexture(this.armorItem.resourceLocation);
			this.armorItem.armorModel.renderI(0.0625F);
			GL11.glPopMatrix();
			
		} else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
			GL11.glPushMatrix();
			GL11.glRotatef(180, 0F, 0F, 1F);
			GL11.glTranslatef(-0.9F, 0F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(this.armorItem.resourceLocation);
			this.armorItem.armorModel.renderI(0.0625F);
			GL11.glPopMatrix();
			
		} else if (type == ItemRenderType.ENTITY) {
			GL11.glPushMatrix();
			GL11.glRotatef(180, 1F, 0F, 0F); // Flip right side up
			GL11.glScalef(2F, 2F, 2F);
			
			GL11.glTranslatef(0F, -0.0F, 0F);
			//GL11.glRotatef(IronSuits.rotator, 0F, 1F, 0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(this.armorItem.resourceLocation);
			this.armorItem.armorModel.renderI(0.0625F);
			GL11.glPopMatrix();
		}

	}

}
