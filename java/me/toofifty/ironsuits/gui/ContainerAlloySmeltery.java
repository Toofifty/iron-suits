package me.toofifty.ironsuits.gui;

import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.crafting.AlloyCraftingManager;
import me.toofifty.ironsuits.crafting.InventoryAlloyCrafting;
import me.toofifty.ironsuits.tileentity.TileEntityAlloySmeltery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerAlloySmeltery extends Container {
	
	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	public TileEntityAlloySmeltery alloySmeltery;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	
	private int lastBurnTime;
	
	private int lastItemBurnTime;
	
	private int lastCookTime;

	public ContainerAlloySmeltery(InventoryPlayer par1InventoryPlayer,
			World par2World, int par3, int par4, int par5, TileEntityAlloySmeltery par6) {	
		this.craftMatrix = new InventoryAlloyCrafting(this, par6, 2, 2);
		par6.initIC(craftMatrix);
		this.craftResult = new InventoryCraftResult();
		this.alloySmeltery = par6;
		this.worldObj = par2World;
		this.posX = par3;
		this.posY = par4;
		this.posZ = par5;
		// Fuel slot. Made it 4 because I think I have to
		this.addSlotToContainer(new Slot(par6, 4, 20, 43));
		this.addSlotToContainer(new SlotFurnace(par1InventoryPlayer.player, par6, 5, 133, 35));
		// Output slot
		//this.addSlotToContainer(new SlotAlloySmeltery(par6, 
		//		par1InventoryPlayer.player, this.craftMatrix, this.craftResult,
		//		0, 133, 35));
		int var6;
		int var7;

		int i;
		int j;
		for (i = 0; i < 2; i++) {
			for (j = 0; j < 2; j++) {
				// Slots 0, 1, 2, 3 are input
				this.addSlotToContainer(new Slot(this.craftMatrix, j+i*2, 44 + j*18, 25 + i*18));
				//this.addSlotToContainer(new SlotAlloySmelteryGrid(par6TileEntityAlloySmeltery, this.craftMatrix, j+i*2, 44 + j*18, 25 + i*18));
			}
		}
		
		// Below are different types of slots - hence they use 0, 1, 2 etc as well
		
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i*9 + 9, j*18 + 8, i*18 + 84));
			}
		}
		
		for (i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(par1InventoryPlayer, i, i*18 + 8, 142));
		}
		
		//this.onCraftMatrixChanged(this.craftMatrix);
	}
	
	public void onCraftMatrixChanged(IInventory par1IInventory) {
		// Call cooking method here
		this.craftResult.setInventorySlotContents(0, AlloyCraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
	}
	
	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
		super.onContainerClosed(par1EntityPlayer);

		if (!this.worldObj.isRemote) {
			for (int var2 = 0; var2 < 4; ++var2) {
				ItemStack var3 = this.craftMatrix.getStackInSlotOnClosing(var2);

				if (var3 != null) {
					par1EntityPlayer.dropItem(var3.getItem(), var3.stackSize);
				}
			}
		}
	}

	public void addCraftingToCrafters(ICrafting iCrafting) {
		super.addCraftingToCrafters(iCrafting);
		iCrafting.sendProgressBarUpdate(this, 0, this.alloySmeltery.cookTime);
		iCrafting.sendProgressBarUpdate(this, 1, this.alloySmeltery.cookTime);
		iCrafting.sendProgressBarUpdate(this, 2, this.alloySmeltery.cookTime);
		iCrafting.sendProgressBarUpdate(this, 3, this.alloySmeltery.cookTime);
		iCrafting.sendProgressBarUpdate(this, 4, this.alloySmeltery.burnTime);
		iCrafting.sendProgressBarUpdate(this, 5, this.alloySmeltery.currentItemBurnTime);
	}
	
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for (int i = 0; i < this.crafters.size(); i++) {
			ICrafting iCrafting = (ICrafting)this.crafters.get(i);
			
			if (this.lastCookTime != this.alloySmeltery.cookTime) {
				iCrafting.sendProgressBarUpdate(this, 0, this.alloySmeltery.cookTime);
				iCrafting.sendProgressBarUpdate(this, 1, this.alloySmeltery.cookTime);
				iCrafting.sendProgressBarUpdate(this, 2, this.alloySmeltery.cookTime);
				iCrafting.sendProgressBarUpdate(this, 3, this.alloySmeltery.cookTime);
			}
			
			if (this.lastBurnTime != this.alloySmeltery.burnTime) {
				iCrafting.sendProgressBarUpdate(this, 4, this.alloySmeltery.burnTime);
			}
			
			if (this.lastItemBurnTime != this.alloySmeltery.currentItemBurnTime) {
				iCrafting.sendProgressBarUpdate(this, 5, this.alloySmeltery.currentItemBurnTime);
			}
		}
		
		this.lastCookTime = this.alloySmeltery.cookTime;
		this.lastBurnTime = this.alloySmeltery.burnTime;
		this.lastItemBurnTime = this.alloySmeltery.currentItemBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int par2) {
		if (slot == 0 || slot == 1 || slot == 2 || slot == 3)
			this.alloySmeltery.cookTime = par2;
		if (slot == 4) this.alloySmeltery.burnTime = par2;
		if (slot == 5) this.alloySmeltery.currentItemBurnTime = par2;
	}

	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 3 && par2 < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(entityPlayer, itemstack1);
        }

        return itemstack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return this.worldObj.getBlock(this.posX, this.posY, this.posZ) != IronSuits.alloySmelteryIdle
				&& this.worldObj.getBlock(this.posX, this.posY, this.posZ) != IronSuits.alloySmelteryActive ? false
				: var1.getDistanceSq((double) this.posX + 0.5D,
						(double) this.posY + 0.5D, (double) this.posZ + 0.5D) <= 64.0D;
	}

}
