package me.toofifty.ironsuits.item;

import me.toofifty.ironsuits.common.IronSuits;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemCircuit extends Item {

	public ItemCircuit() {
		super();
		this.setCreativeTab(IronSuits.tabIronSuits);
	}
	
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(IronSuits.ID + ":circuit");
	}

}
