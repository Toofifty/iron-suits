package me.toofifty.ironsuits.block;

import me.toofifty.ironsuits.client.ClientProxy;
import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.tileentity.TileEntityAssemblyDesk;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAssemblyDesk extends BlockContainer {

	public BlockAssemblyDesk(Material material, String blockName) {
		super(material);
		this.setBlockName(blockName);
		this.setCreativeTab(IronSuits.tabIronSuits);
		this.setBlockBounds(1/16F, 0F, 1/16F, 15/16F, 15/16F, 15/16F);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int i, int j, int k, int l) { return false; }
	
	public boolean renderAsNormalBlock() { return false; }

	public boolean isOpaqueCube() { return false; }
	
	public int getRenderType() {
		return ClientProxy.assemblyDeskRenderID;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(IronSuits.ID + ":" + this.getUnlocalizedName().substring(5).replace(".name", ""));
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityAssemblyDesk();
	}
}
