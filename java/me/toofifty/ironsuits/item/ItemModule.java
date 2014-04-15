package me.toofifty.ironsuits.item;

import me.toofifty.ironsuits.common.IronSuits;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemModule extends Item {

	private int modCost;
	private String texture;

	public ItemModule(String par1, int par2) {
		super();
		this.texture = par1;
		this.modCost = par2;
		// TODO Auto-generated constructor stub
	}
	
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(IronSuits.ID + ":" + this.texture);
	}

}
