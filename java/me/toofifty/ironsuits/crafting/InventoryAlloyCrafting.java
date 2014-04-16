package me.toofifty.ironsuits.crafting;

import me.toofifty.ironsuits.tileentity.TileEntityAlloySmeltery;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;

public class InventoryAlloyCrafting extends InventoryCrafting {
	
	private TileEntityAlloySmeltery smeltery;

	public InventoryAlloyCrafting(Container par1Container, TileEntityAlloySmeltery par2, int par3, int par4) {
		super(par1Container, par3, par4);
		this.smeltery = par2;
	}

}
