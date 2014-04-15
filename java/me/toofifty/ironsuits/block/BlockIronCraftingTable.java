package me.toofifty.ironsuits.block;

import me.toofifty.ironsuits.common.IronSuits;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIronCraftingTable extends Block {
	
	@SideOnly(Side.CLIENT)
	private IIcon topIcon;

	public BlockIronCraftingTable(Material par1Material) {
		super(par1Material);
		this.setCreativeTab(IronSuits.tabIronSuits);
		this.setHardness(5.0F);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(IronSuits.ID + ":iron_crafting_table_side");
		this.topIcon = iconRegister.registerIcon(IronSuits.ID + ":iron_crafting_table_top");
	}

	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2) {
        return par1 == 1 ? this.topIcon : this.blockIcon;
    }
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        if (par1World.isRemote) {
            return true;
        } else {
            par5EntityPlayer.displayGUIWorkbench(par2, par3, par4);
            return true;
        }
    }
}
