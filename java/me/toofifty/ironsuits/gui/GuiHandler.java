package me.toofifty.ironsuits.gui;

import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.tileentity.TileEntityAlloySmeltery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if (entity != null) {
			switch(ID) {
			case IronSuits.guiAlloySmeltery:
				if (entity instanceof TileEntityAlloySmeltery) {
					return new ContainerAlloySmeltery(player.inventory, (TileEntityAlloySmeltery)entity);
				}
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if (entity != null) {
			switch(ID) {
			case IronSuits.guiAlloySmeltery:
				if (entity instanceof TileEntityAlloySmeltery) {
					return new GuiAlloySmeltery(player.inventory, (TileEntityAlloySmeltery)entity);
				}
			}
		}
		return null;
	}

}
