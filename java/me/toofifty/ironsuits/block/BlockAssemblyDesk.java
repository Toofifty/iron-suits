package me.toofifty.ironsuits.block;

import java.util.Random;

import me.toofifty.ironsuits.client.ClientProxy;
import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.tileentity.TileEntityAlloySmeltery;
import me.toofifty.ironsuits.tileentity.TileEntityAssemblyDesk;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAssemblyDesk extends BlockContainer {

	public BlockAssemblyDesk(Material material, String blockName, Boolean active) {
		super(material);
		this.setBlockName(blockName);
		this.setCreativeTab(IronSuits.tabIronSuits);
		this.setBlockBounds(1/16F, 0F, 1/16F, 15/16F, 15/16F, 15/16F);
		this.active = active;
	}
	
	private final boolean active;
	private static boolean keepInventory;
	
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
			EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		int rotation = MathHelper
				.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;

		par1World.setBlockMetadataWithNotify(par2, par3, par4, rotation, 2);
		if (par6ItemStack.hasDisplayName()) {
			((TileEntityAssemblyDesk)par1World.getTileEntity(par2, par3, par4)).setGuiDisplayName(par6ItemStack.getDisplayName());
		}
	}
	
	public Block idDropped(int par1, Random par2Random, int par3) {
		return IronSuits.assemblyDeskIdle;
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		if (par1World.isRemote) {
			return true;
		} else if (!par5EntityPlayer.isSneaking()) {
			par5EntityPlayer.openGui(IronSuits.instance, IronSuits.guiAssemblyDesk, par1World, par2, par3, par4);
			return true;
		}
		return false;
	}

	public static void updateAssemblyDeskState(boolean b, World worldObj,
			int xCoord, int yCoord, int zCoord) {
		int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		
		TileEntity tileEntity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;
		
		if (b) {
			worldObj.setBlock(xCoord, yCoord, zCoord, IronSuits.assemblyDeskActive);
		} else {
			worldObj.setBlock(xCoord, yCoord, zCoord, IronSuits.assemblyDeskIdle);
		}
		
		keepInventory = false;
		
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
		
		if (tileEntity != null) {
			tileEntity.validate();
			worldObj.setTileEntity(xCoord, yCoord, zCoord, tileEntity);
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int i, int j, int k, int l) { return false; }
	
	public boolean renderAsNormalBlock() { return false; }

	public boolean isOpaqueCube() { return false; }
	
	public int getRenderType() {
		return active ? ClientProxy.assemblyDeskActiveRenderID : ClientProxy.assemblyDeskIdleRenderID;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(IronSuits.ID + ":" + this.getUnlocalizedName().substring(5).replace(".name", ""));
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityAssemblyDesk();
	}
	
	public boolean hasComparatorInputOverride() {
		return true;
	}

	public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
		return Container.calcRedstoneFromInventory((IInventory)world.getTileEntity(x, y, z));
	}
	
	public Block idPicked(World world, int x, int y, int z) {
		return IronSuits.assemblyDeskIdle;
	}
	
    @SideOnly(Side.CLIENT)
    public Item getItem(World par1World, int par2, int par3, int par4) {
        return Item.getItemFromBlock(IronSuits.assemblyDeskIdle);
    }
}
