package me.toofifty.ironsuits.render;

import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.model.ModelAssemblyTable;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderAssemblyTable extends TileEntitySpecialRenderer {

	private static final ResourceLocation resourceLocation = new ResourceLocation(IronSuits.ID, "textures/models/blocks/assembly_table.png");
	
	private ModelAssemblyTable model;
	
	public RenderAssemblyTable() {
		this.model = new ModelAssemblyTable();
	}

	public void renderTileEntityAt(TileEntity var1, double x, double y,
			double z, float var8) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);

		this.bindTexture(resourceLocation);

		GL11.glPushMatrix();
		this.model.renderModel(0.06125F);

		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
