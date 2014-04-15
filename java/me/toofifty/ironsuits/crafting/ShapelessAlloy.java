package me.toofifty.ironsuits.crafting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ShapelessAlloy implements IRecipe {
	
	private final ItemStack recipeOutput;
	
	public final List recipeItems;
	
	public ShapelessAlloy(ItemStack par1ItemStack, List par2List) {
		this.recipeOutput = par1ItemStack;
		this.recipeItems = par2List;
	}
	
	public ItemStack getRecipeOutput() {
		return this.recipeOutput;
	}

	@Override
	public boolean matches(InventoryCrafting var1, World var2) {

		ArrayList arraylist = new ArrayList(this.recipeItems);

		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 2; ++j) {
				ItemStack itemstack = var1.getStackInRowAndColumn(j, i);

				if (itemstack != null) {
					boolean flag = false;
					Iterator iterator = arraylist.iterator();

					while (iterator.hasNext()) {
						ItemStack itemstack1 = (ItemStack) iterator.next();

						if (itemstack.getItem() == itemstack1.getItem()
								&& (itemstack1.getItemDamage() == 32767 || itemstack
										.getItemDamage() == itemstack1
										.getItemDamage())) {
							flag = true;
							arraylist.remove(itemstack1);
							break;
						}
					}

					if (!flag) {
						return false;
					}
				}
			}
		}

		return arraylist.isEmpty();
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

}
