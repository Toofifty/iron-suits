package me.toofifty.ironsuits.item;

import me.toofifty.ironsuits.common.IronSuits;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemBase extends Item {

	public ItemBase(String par1) {
		super();
		this.setCreativeTab(IronSuits.tabIronSuits);
		this.setUnlocalizedName(par1);
	}
	
	public String texture;
	
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(IronSuits.ID + ":" + this.getUnlocalizedName().substring(5).replace(".name", ""));
	}

}
