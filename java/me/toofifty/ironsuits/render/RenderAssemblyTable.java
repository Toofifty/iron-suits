package me.toofifty.ironsuits.render;

import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.model.ModelAssemblyTable;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderAssemblyTable extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler {

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

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId,
			RenderBlocks renderer) {
		GL11.glPushMatrix();

		GL11.glRotatef(180, 0F, 0F, 1F);
		GL11.glRotatef(180, 0F, 1F, 0F);
		GL11.glTranslatef(0F, -1F, 0F);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(resourceLocation);
		this.model.renderModel(0.06125F);
		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
