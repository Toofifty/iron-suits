package me.toofifty.ironsuits.render;

import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.armor.ArmorBase;
import me.toofifty.ironsuits.armor.ArmorSetExo;
import me.toofifty.ironsuits.model.ModelArmorBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
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
		//case ENTITY: return true;
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
		
		switch (type) {
		case INVENTORY:
			
			GL11.glPushMatrix();
			
			GL11.glRotatef(180, 0F, 1F, 0F); // Flip right side up
			GL11.glScalef(16F, 16F, 16F); // Fix inventory down-sizing
			GL11.glRotatef(30, 1F, 0F, 0F); // Tilt forward
			GL11.glTranslatef(-0.5F, 0.8F, 0F); // Align with slots
			
			
			GL11.glFrontFace(GL11.GL_CW);
			
			// If the item actually exists, it will DEFINITELY have a resourceLocation
			Minecraft.getMinecraft().renderEngine.bindTexture(this.armorItem.resourceLocation);
			GL11.glRotatef(IronSuits.rotator, 0F, 1F, 0F); // Apply subtle rotation
			
			// Any additional translations need to be made in renderInventory!
			this.armorItem.armorModel.renderInventory(0.0625F);

			GL11.glFrontFace(GL11.GL_CCW);
			
			GL11.glPopMatrix();
			
		case EQUIPPED_FIRST_PERSON:
			GL11.glPushMatrix();
			GL11.glRotatef(180, 0F, 1F, 0F); // Flip right side up
			Minecraft.getMinecraft().renderEngine.bindTexture(this.armorItem.resourceLocation);
			this.armorItem.armorModel.renderFirstPerson(0.0625F);
			GL11.glPopMatrix();
			
		case EQUIPPED:
			GL11.glPushMatrix();
			GL11.glRotatef(180, 0F, 1F, 0F); // Flip right side up
			Minecraft.getMinecraft().renderEngine.bindTexture(this.armorItem.resourceLocation);
			this.armorItem.armorModel.renderEquipped(0.0625F);
			GL11.glPopMatrix();
			
		case ENTITY:
			
			GL11.glPushMatrix();
			GL11.glRotatef(180, 1F, 0F, 0F); // Flip right side up
			this.count += 0.02D;
			
			GL11.glTranslatef(0F, -0.8F + (float) (-0.2 * Math.sin(this.count)), 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(this.armorItem.resourceLocation);
			this.armorItem.armorModel.renderEntity(0.0625F);
			GL11.glPopMatrix();
			
		default: break;
		}

	}

}
