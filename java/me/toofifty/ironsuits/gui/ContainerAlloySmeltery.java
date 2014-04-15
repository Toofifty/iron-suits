package me.toofifty.ironsuits.gui;

import me.toofifty.ironsuits.tileentity.TileEntityAlloySmeltery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerAlloySmeltery extends Container {

	private TileEntityAlloySmeltery alloySmeltery;
	
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 2, 2);
	
	private int lastBurnTime;
	
	private int lastItemBurnTime;
	
	private int lastCookTime;

	public ContainerAlloySmeltery(InventoryPlayer inventoryPlayer,
			TileEntityAlloySmeltery tileEntity) {
		this.alloySmeltery = tileEntity;

		this.addSlotToContainer(new Slot(tileEntity, 0, 44, 25));
		this.addSlotToContainer(new Slot(tileEntity, 1, 62, 25));
		this.addSlotToContainer(new Slot(tileEntity, 2, 44, 43));
		this.addSlotToContainer(new Slot(tileEntity, 3, 62, 43));
		this.addSlotToContainer(new Slot(tileEntity, 4, 20, 43));
		this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tileEntity, 5, 133, 35));
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(inventoryPlayer, j + i*9 + 9, j*18 + 8, i*18 + 84));
			}
		}
		
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventoryPlayer, i, i*18 + 8, 142));
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
		if (slot == 0) this.alloySmeltery.cookTime = par2;
		if (slot == 1) this.alloySmeltery.cookTime = par2;
		if (slot == 2) this.alloySmeltery.cookTime = par2;
		if (slot == 3) this.alloySmeltery.cookTime = par2;
		if (slot == 4) this.alloySmeltery.burnTime = par2;
		if (slot == 5) this.alloySmeltery.currentItemBurnTime = par2;
	}
	
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slot) {
		return null;
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return this.alloySmeltery.isUseableByPlayer(var1);
	}

}
