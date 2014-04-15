package me.toofifty.ironsuits.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.toofifty.ironsuits.common.IronSuits;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabIronSuits extends CreativeTabs {

	public CreativeTabIronSuits(int par1, String par2Str) {
		super(par1, par2Str);
	}
	
	public String getTranslatedTabLabel() {
		return "Iron Suits";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return IronSuits.chestExoIron;
	}

}
