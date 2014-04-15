package me.toofifty.ironsuits.block;

import me.toofifty.ironsuits.common.IronSuits;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGrinder extends Block {

	public BlockGrinder(Material par1Material, String par2BlockName) {
		super(par1Material);
		this.setBlockName(par2BlockName);
		this.setCreativeTab(IronSuits.tabIronSuits);
	}

	@SideOnly(Side.CLIENT)
	private IIcon topIcon;
	@SideOnly(Side.CLIENT)
	private IIcon frontIcon;
	@SideOnly(Side.CLIENT)
	private IIcon frontIconActive;
	@SideOnly(Side.CLIENT)
	private IIcon bottomIcon;

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		String baseString = this.getUnlocalizedName().substring(5)
				.replace(".name", "");

		this.blockIcon = iconRegister.registerIcon(IronSuits.ID + ":"
				+ "machine_main");
		this.topIcon = iconRegister.registerIcon(IronSuits.ID + ":"
				+ "machine_top");
		this.frontIcon = iconRegister.registerIcon(IronSuits.ID + ":"
				+ baseString + "_front");
		this.bottomIcon = iconRegister.registerIcon(IronSuits.ID + ":"
				+ "machine_bottom");
		this.frontIconActive = iconRegister.registerIcon(IronSuits.ID + ":"
				+ baseString + "_front_active");
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
			EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		int l = MathHelper
				.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;

		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
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

}
