package me.toofifty.ironsuits.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.toofifty.ironsuits.common.IronSuits;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockOsmiumBlock extends Block {
	
	public BlockOsmiumBlock(Material par1Material) {
		super(par1Material);
		this.setCreativeTab(IronSuits.tabIronSuits);
		this.setHardness(10);
		this.setResistance(50);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(IronSuits.ID + ":osmium_block");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2) {
		return blockIcon;
	}
}
