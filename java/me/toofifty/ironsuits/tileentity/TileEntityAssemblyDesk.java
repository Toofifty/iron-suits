package me.toofifty.ironsuits.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import me.toofifty.ironsuits.crafting.AlloyCraftingManager;
import me.toofifty.ironsuits.crafting.ArmorCraftingManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAssemblyDesk extends TileEntity implements IInventory {
	
	private String localizedName;

	private ItemStack[] slots = new ItemStack[13];
	
	private InventoryCrafting craftMatrix;
	
	public int speed = 100;
	public int origSpeed = 100;
	
	public int burnTime;
	public int currentItemBurnTime;
	public int cookTime;

	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;
	}

	@Override
	public int getSizeInventory() {
		return this.slots.length;
	}
	
	public void initIC(InventoryCrafting inventoryCrafting) {
		this.craftMatrix = inventoryCrafting;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return this.slots[var1];
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		if (this.slots[var1] != null) {
			ItemStack itemStack;

			if (this.slots[var1].stackSize <= var2) {
				itemStack = this.slots[var1];
				this.slots[var1] = null;
				return itemStack;
			} else {
				itemStack = this.slots[var1].splitStack(var2);

				if (this.slots[var1].stackSize == 0) {
					this.slots[var1] = null;
				}

				return itemStack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		if (this.slots[var1] != null) {
			ItemStack itemStack = this.slots[var1];
			this.slots[var1] = null;
			return itemStack;
		}
		
		return null;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		this.slots[var1] = var2;
		
		if (var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
			var2.stackSize = this.getInventoryStackLimit();
		}		
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord,
				this.zCoord) != this ? false : var1.getDistanceSq(
				(double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
				(double) this.zCoord + 0.5D) <= 64.0D;
	}

	private void craftItem() {
		if (this.canCraft()) {
			ItemStack itemStack = AlloyCraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj);
			
			if (this.slots[12] == null) {
				this.slots[12] = itemStack.copy();
			} else if (this.slots[12].isItemEqual(itemStack)) {
				this.slots[12].stackSize += itemStack.stackSize;
			}

			for (int i = 0; i < 11; i++) {

				ItemStack slot = this.craftMatrix.getStackInSlot(i);
				
				if (slot != null) {
					slot = this.craftMatrix.decrStackSize(i, 1);

					if (slot.stackSize <= 0) {
						this.craftMatrix.setInventorySlotContents(i, null);
					}
				}
			}
		}
		
	}

	private boolean canCraft() {
		ItemStack itemStack = ArmorCraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj);
		
		if (itemStack != null) {
			if (this.slots[12] == null) return true;
			if (!this.slots[12].isItemEqual(itemStack)) return false;
			
			int result = this.slots[12].stackSize + itemStack.stackSize;
			
			return (result <= 64 && getInventoryStackLimit() <= itemStack.getMaxStackSize());
		}
		return false;
	}

	@Override
	public void openInventory() { }

	@Override
	public void closeInventory() { }

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return var1 == 12 ? false : var1 == 11 ? isItemFuel(var2) : true;
	}

	private boolean isItemFuel(ItemStack itemStack) {
		return getItemBurnTime(itemStack) > 0;
	}

	private int getItemBurnTime(ItemStack itemStack) {
		if (itemStack == null) {
			return 0;
		} else {
			Item item = itemStack.getItem();
			
			if(item == Items.coal) return 1600;
			
			return GameRegistry.getFuelValue(itemStack);
		}
	}

	public boolean isBurning() {
		return this.burnTime > 0;
	}

	public int getBurnTimeRemainingScaled(int i) {
		if (this.currentItemBurnTime == 0) {
			this.currentItemBurnTime = this.origSpeed;
		}
		
		return this.burnTime * i / this.currentItemBurnTime;
	}

	public int getCookProgressScaled(int i) {
		return (this.cookTime * i) / (this.speed);
	}

}
