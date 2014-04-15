package me.toofifty.ironsuits.item;

import me.toofifty.ironsuits.common.IronSuits;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSpade;

public class ItemOsmiumSpade extends ItemSpade {

	public ItemOsmiumSpade(ToolMaterial par1ToolMaterial) {
		super(par1ToolMaterial);
		this.setCreativeTab(IronSuits.tabIronSuits);
	}
	
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(IronSuits.ID + ":osmium_spade");
	}

}
