package me.toofifty.ironsuits.item;

import me.toofifty.ironsuits.common.IronSuits;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;

public class ItemOsmiumPickaxe extends ItemPickaxe {

	public ItemOsmiumPickaxe(ToolMaterial par1ToolMaterial) {
		super(par1ToolMaterial);
		this.setCreativeTab(IronSuits.tabIronSuits);
	}
	
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(IronSuits.ID + ":osmium_pickaxe");
	}

}
