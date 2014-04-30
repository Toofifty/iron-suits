package me.toofifty.ironsuits.block;

import java.util.Random;

import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.gui.GuiHandler;
import me.toofifty.ironsuits.tileentity.TileEntityAlloySmeltery;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAlloySmeltery extends BlockContainer {

	public BlockAlloySmeltery(Material par1Material, String par2BlockName, boolean par3Active) {
		super(par1Material);
		this.setBlockName(par2BlockName);
		this.active = par3Active;
		if (active) {
			this.setLightLevel(0.7F);
		} else {
			this.setCreativeTab(IronSuits.tabIronSuits);
		}
	}
	
	private final boolean active;
	private static boolean keepInventory;

	@SideOnly(Side.CLIENT)
	private IIcon topIcon;
	@SideOnly(Side.CLIENT)
	private IIcon frontIcon;
	@SideOnly(Side.CLIENT)
	private IIcon bottomIcon;

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {		
		this.blockIcon = iconRegister.registerIcon(IronSuits.ID + ":"
				+ "machine_main");
		this.topIcon = iconRegister.registerIcon(IronSuits.ID + ":"
				+ "machine_top");
		this.frontIcon = iconRegister.registerIcon(IronSuits.ID + ":"
				+ this.getUnlocalizedName().substring(5).replace(".name", ""));
		this.bottomIcon = iconRegister.registerIcon(IronSuits.ID + ":"
				+ "machine_bottom");
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
			EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		int rotation = MathHelper
				.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;

		par1World.setBlockMetadataWithNotify(par2, par3, par4, rotation, 2);
		if (par6ItemStack.hasDisplayName()) {
			((TileEntityAlloySmeltery)par1World.getTileEntity(par2, par3, par4)).setGuiDisplayName(par6ItemStack.getDisplayName());
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return par1 == 1 ? this.topIcon
				: (par1 == 0 ? this.topIcon
						: (par2 == 2 && par1 == 2 ? this.frontIcon
								: (par2 == 3 && par1 == 5 ? this.frontIcon
										: (par2 == 0 && par1 == 3 ? this.frontIcon
												: (par2 == 1 && par1 == 4 ? this.frontIcon
														: this.blockIcon)))));
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityAlloySmeltery();
	}
	
	public Block idDropped(int par1, Random par2Random, int par3) {
		return IronSuits.alloySmelteryIdle;
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		if (par1World.isRemote) {
			return true;
		} else if (!par5EntityPlayer.isSneaking()) {
			par5EntityPlayer.openGui(IronSuits.instance, IronSuits.guiAlloySmeltery, par1World, par2, par3, par4);
			return true;
		}
		return false;
	}

	public static void updateAlloySmelteryState(boolean b, World worldObj,
			int xCoord, int yCoord, int zCoord) {
		int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		
		TileEntity tileEntity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;
		
		if (b) {
			worldObj.setBlock(xCoord, yCoord, zCoord, IronSuits.alloySmelteryActive);
		} else {
			worldObj.setBlock(xCoord, yCoord, zCoord, IronSuits.alloySmelteryIdle);
		}
		
		keepInventory = false;
		
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
		
		if (tileEntity != null) {
			tileEntity.validate();
			worldObj.setTileEntity(xCoord, yCoord, zCoord, tileEntity);
		}
		
	}
	
	public boolean hasComparatorInputOverride() {
		return true;
	}

	public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
		return Container.calcRedstoneFromInventory((IInventory)world.getTileEntity(x, y, z));
	}
	
	public Block idPicked(World world, int x, int y, int z) {
		return IronSuits.alloySmelteryIdle;
	}
	
    @SideOnly(Side.CLIENT)
    public Item getItem(World par1World, int par2, int par3, int par4) {
        return Item.getItemFromBlock(IronSuits.alloySmelteryIdle);
    }
}





