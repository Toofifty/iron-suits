package me.toofifty.ironsuits.gui;

import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.tileentity.TileEntityAlloySmeltery;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.sun.org.apache.xml.internal.security.utils.I18n;

public class GuiAlloySmeltery extends GuiContainer {
	
	private static final ResourceLocation gui = new ResourceLocation(IronSuits.ID, "textures/gui/container/alloy_smeltery.png");
	
	private TileEntityAlloySmeltery alloySmeltery;

	public GuiAlloySmeltery(InventoryPlayer par1InventoryPlayer, TileEntityAlloySmeltery par2TileEntity) {
		super(new ContainerAlloySmeltery(par1InventoryPlayer, par2TileEntity));
		
		this.alloySmeltery = par2TileEntity;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		String name = this.alloySmeltery.isInvNameLocalized() ? this.alloySmeltery.getInvName() : StatCollector.translateToLocal(this.alloySmeltery.getInvName());

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(gui);

		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if (this.alloySmeltery.burnTime > 0) {
			int k = this.alloySmeltery.getBurnTimeRemainingScaled(14);
			drawTexturedModalRect(guiLeft + 23, guiTop + 25 + 14 - k, 176, 14 - k, 10, k + 2);
		}
		
		int k = this.alloySmeltery.getCookProgressScaled(31);
		drawTexturedModalRect(guiLeft + 86, guiTop + 29, 176, 15, k + 1, 24);
	}
	
}
