package me.toofifty.ironsuits.gui;

import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.tileentity.TileEntityAlloySmeltery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (ID) {
			case IronSuits.guiAlloySmeltery:
				return world.getBlock(x, y, z) == IronSuits.alloySmelteryIdle
						|| world.getBlock(x, y, z) == IronSuits.alloySmelteryActive ? new ContainerAlloySmeltery(
						player.inventory, world, x, y, z, (TileEntityAlloySmeltery)entity) : null;
			}
		}
		return null;
	}

	// case 0: return id == 0 && world.getBlockId(x, y, z) ==
	// Snowcones.snowconeMachine.blockID ? new ContainerSCM(player.inventory,
	// world, x, y, z) : null;

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (ID) {
			case IronSuits.guiAlloySmeltery:
				return new GuiAlloySmeltery(player.inventory, world, x, y, z, (TileEntityAlloySmeltery)entity);
			}
		}
		return null;
	}

}
