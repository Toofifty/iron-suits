package me.toofifty.ironsuits.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ShapedArmor implements IRecipe {
	
	public final int recipeWidth;
	public final int recipeHeight;
	public final ItemStack[] recipeItems;
	private ItemStack recipeOutput;
	private boolean field_92101_f;
	
	public ShapedArmor(int par1, int par2, ItemStack[] par3, ItemStack par4) {
		this.recipeOutput = par4;
		this.recipeWidth = par1;
		this.recipeHeight = par2;
		this.recipeItems = par3;
	}

	@Override
	public boolean matches(InventoryCrafting var1, World var2) {
		for (int i = 0; i <= 2 - this.recipeWidth; ++i) {
			for (int j = 0; j <= 2 - this.recipeHeight; ++j) {
				if (this.checkMatch(var1, i, j, true)) {
					return true;
				}

				if (this.checkMatch(var1, i, j, false)) {
					return true;
				}
			}
		}

		return false;
	}
	
	private boolean checkMatch(InventoryCrafting par1InventoryCrafting,
			int par2, int par3, boolean par4) {
		for (int k = 0; k < 2; ++k) {
			for (int l = 0; l < 2; ++l) {
				int i1 = k - par2;
				int j1 = l - par3;
				ItemStack itemstack = null;

				if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth
						&& j1 < this.recipeHeight) {
					if (par4) {
						itemstack = this.recipeItems[this.recipeWidth - i1 - 1
								+ j1 * this.recipeWidth];
					} else {
						itemstack = this.recipeItems[i1 + j1 * this.recipeWidth];
					}
				}

				ItemStack itemstack1 = par1InventoryCrafting
						.getStackInRowAndColumn(k, l);

				if (itemstack1 != null || itemstack != null) {
					if (itemstack1 == null && itemstack != null
							|| itemstack1 != null && itemstack == null) {
						return false;
					}

					if (itemstack.getItem() != itemstack1.getItem()) {
						return false;
					}

					if (itemstack.getItemDamage() != 32767
							&& itemstack.getItemDamage() != itemstack1
									.getItemDamage()) {
						return false;
					}
				}
			}
		}

		return true;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRecipeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return this.recipeOutput;
	}

}
