package me.toofifty.ironsuits.tileentity;

import me.toofifty.ironsuits.block.BlockAlloySmeltery;
import me.toofifty.ironsuits.crafting.AlloyCraftingManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityAlloySmeltery extends TileEntity implements ISidedInventory {

	private String localizedName;

	private static final int[] slots_top = new int[]{0, 1, 2, 3};
	private static final int[] slots_sides = new int[]{4};
	private static final int[] slots_bottom = new int[]{5};
	
	private ItemStack[] slots = new ItemStack[6];
	
	private InventoryCrafting craftMatrix;
	
	public int furnaceSpeed = 100;
	public int originalSpeed = 100;
	
	/* Time needed */
	public int burnTime;
	
	/* Time left */
	public int currentItemBurnTime; 
	
	/* Time done */
	public int cookTime;
	
	public int getSizeInventory() {
		return this.slots.length;
	}
	
	public void initIC(InventoryCrafting inventoryCrafting) {
		this.craftMatrix = inventoryCrafting;
	}
	
	public String getInvName() {
		return this.isInvNameLocalized() ? this.localizedName : "container.alloy_smeltery";
	}
	
	public boolean isInvNameLocalized() {
		return this.localizedName != null && this.localizedName.length() > 0;
	}
	
	public void setGuiDisplayName(String name) {
		this.localizedName = name;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return this.slots[var1];
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		if(this.slots[var1] != null) {
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
	
	public void readFromNBT(NBTTagCompound nbt) {
		
	}

	public void writeToNBT(NBTTagCompound nbt) {
		
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord,
				this.zCoord) != this ? false : var1.getDistanceSq(
				(double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
				(double) this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {
		
	}
	
	public void updateEntity() {		
		boolean flag = this.burnTime > 0;
		boolean dirty = false;
		
		if (this.isBurning()) {
			this.burnTime--;
		}
		
		if (!this.worldObj.isRemote) {
			if (this.burnTime == 0 && this.canSmelt()) {
				this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[4]);
				
				if (this.isBurning()) {
					dirty = true;
					
					if (this.slots[4] != null) {
						this.slots[4].stackSize--;
						
						if (this.slots[4].stackSize == 0) {
							this.slots[4] = this.slots[4].getItem().getContainerItem(this.slots[4]);
						}
					}
				}
			}
			if (flag != this.isBurning()) {
				dirty = true;
				BlockAlloySmeltery.updateAlloySmelteryState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		
			if (this.isBurning() && this.canSmelt()) {
				this.furnaceSpeed = this.originalSpeed * this.getNumberOfItems();
				
				this.cookTime++;

				if (this.cookTime >= this.furnaceSpeed) {
					this.cookTime = 0;
					this.smeltItem();
					dirty = true;
				}
			} else {
				this.cookTime = 0;
			}

		}
		
		if (dirty) {
			this.markDirty();
		}
	}

	private void smeltItem() {
		if (this.canSmelt()) {
			ItemStack itemStack = AlloyCraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj);
			
			if (this.slots[5] == null) {
				this.slots[5] = itemStack.copy();
			} else if (this.slots[5].isItemEqual(itemStack)) {
				this.slots[5].stackSize += itemStack.stackSize;
			}

			for (int i = 0; i < 4; i++) {

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
	
	private boolean canSmelt() {
		ItemStack itemStack = AlloyCraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj);
		
		if (itemStack != null) {
			if (this.slots[5] == null) return true;
			if (!this.slots[5].isItemEqual(itemStack)) return false;
			
			int result = this.slots[5].stackSize + itemStack.stackSize;
			
			return (result <= 64 && getInventoryStackLimit() <= itemStack.getMaxStackSize());
		}
		return false;
	}
	
	
	/**
	 * Slow the furnace down when there's extra items
	 * @return 0-4
	 */
	public int getNumberOfItems() {
		int n = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				ItemStack itemStack = this.craftMatrix.getStackInRowAndColumn(i, j);
				if (itemStack != null) {
					n++;
				}
			}
		}
		return n;
	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return var1 == 4 ? false : var1 == 3 ? isItemFuel(var2) : true;
	}

	private static boolean isItemFuel(ItemStack itemStack) {
		return getItemBurnTime(itemStack) > 0;
	}

	private static int getItemBurnTime(ItemStack itemStack) {
		if (itemStack == null) {
			return 0;
		} else {
			Item item = itemStack.getItem();
			
			if(item == Items.coal) return 1600;
			
			return GameRegistry.getFuelValue(itemStack);
		}
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1 == 0 ? slots_bottom : var1 == 1 ? slots_top : slots_sides;
	}

	@Override
	public boolean canInsertItem(int var1, ItemStack var2, int var3) {
		return this.isItemValidForSlot(var1, var2);
	}

	@Override
	public boolean canExtractItem(int var1, ItemStack var2, int var3) {
		return var3 != 0 || var1 != 1 || var2.getItem() == Items.bucket;
	}

	public boolean isBurning() {
		return this.burnTime > 0;
	}

	public int getBurnTimeRemainingScaled(int i) {
		if (this.currentItemBurnTime == 0) {
			this.currentItemBurnTime = this.originalSpeed;
		}
		
		return this.burnTime * i / this.currentItemBurnTime;
	}

	public int getCookProgressScaled(int i) {
		int mult = Math.max(this.getNumberOfItems(), 1);
		return (this.cookTime * i) / (this.furnaceSpeed * mult);
	}

}
