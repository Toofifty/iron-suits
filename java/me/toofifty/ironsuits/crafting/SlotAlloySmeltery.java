package me.toofifty.ironsuits.crafting;

import me.toofifty.ironsuits.tileentity.TileEntityAlloySmeltery;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import cpw.mods.fml.common.FMLCommonHandler;

public class SlotAlloySmeltery extends Slot {

	private TileEntityAlloySmeltery smeltery;
	private final IInventory craftMatrix;
	private int amountCrafted;
	private EntityPlayer player;

	public SlotAlloySmeltery(TileEntityAlloySmeltery smeltery, EntityPlayer player, IInventory par2IInventory, IInventory par3IInventory, int par4, int par5,
			int par6) {
		super(par3IInventory, par4, par5, par6);
		this.player = player;
		this.smeltery = smeltery;
		this.craftMatrix = par2IInventory;
	}
	
	public boolean isItemValid(ItemStack par1ItemStack) {
		return false;
	}
	
	public ItemStack decrStackSize(int par1) {
		if (this.getHasStack()) {
			this.amountCrafted += Math.min(par1, this.getStack().stackSize);
		}
		return super.decrStackSize(par1);
	}
	
	protected void onCrafting(ItemStack par1ItemStack, int par2) {
		this.amountCrafted += par2;
		this.onCrafting(par1ItemStack);
	}
	
	protected void onCrafting(ItemStack par1ItemStack) {
		par1ItemStack.onCrafting(this.smeltery.getWorldObj(), this.player, this.amountCrafted);
		
		if (!this.smeltery.getWorldObj().isRemote) {
			int i = this.amountCrafted;
			float f = AlloyCraftingManager.getInstance().getExp(par1ItemStack);
			int j;
			
			if (f == 0.0F) i = 0;
			else if (f < 1.0F) {
				j = MathHelper.floor_float((float)i * f);
				
				if (j < MathHelper.ceiling_float_int((float)i * f) && (float)Math.random() < (float)i * f - (float)j) {
					j++;
				}
				i = j;
			}
			
			while (i > 0) {
				j = EntityXPOrb.getXPSplit(i);
				i -= j;
				this.smeltery.getWorldObj().spawnEntityInWorld(new EntityXPOrb(this.smeltery.getWorldObj(), 
						this.smeltery.xCoord, this.smeltery.yCoord + 0.5D, this.smeltery.zCoord + 0.5D, j));
			}
		}
		
		this.amountCrafted = 0;
		
		FMLCommonHandler.instance().firePlayerSmeltedEvent(this.player, par1ItemStack);
		
		// Add any achievemnts here, if itemstack.getItem() = item, player.addStat
	}

	public void onPickupFromSlot(EntityPlayer par1EntityPlayer,
			ItemStack par2ItemStack) {
		FMLCommonHandler.instance().firePlayerCraftingEvent(par1EntityPlayer,
				par2ItemStack, craftMatrix);
		this.onCrafting(par2ItemStack);

		for (int i = 0; i < this.craftMatrix.getSizeInventory(); ++i) {
			ItemStack itemstack1 = this.craftMatrix.getStackInSlot(i);

			if (itemstack1 != null) {
				this.craftMatrix.decrStackSize(i, 1);

				if (itemstack1.getItem().hasContainerItem(itemstack1)) {
					ItemStack itemstack2 = itemstack1.getItem()
							.getContainerItem(itemstack1);

					if (itemstack2 != null
							&& itemstack2.isItemStackDamageable()
							&& itemstack2.getItemDamage() > itemstack2
									.getMaxDamage()) {
						MinecraftForge.EVENT_BUS
								.post(new PlayerDestroyItemEvent(par1EntityPlayer,
										itemstack2));
						continue;
					}

					if (!itemstack1.getItem()
							.doesContainerItemLeaveCraftingGrid(itemstack1)
							|| !par1EntityPlayer.inventory
									.addItemStackToInventory(itemstack2)) {
						if (this.craftMatrix.getStackInSlot(i) == null) {
							this.craftMatrix.setInventorySlotContents(i,
									itemstack2);
						} else {
							par1EntityPlayer.dropPlayerItemWithRandomChoice(
									itemstack2, false);
						}
					}
				}
			}
		}
	}
	
}
