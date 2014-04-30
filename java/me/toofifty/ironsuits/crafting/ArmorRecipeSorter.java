package me.toofifty.ironsuits.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class ArmorRecipeSorter implements Comparator {

	final ArmorCraftingManager alloyCraftingManager;
	
	ArmorRecipeSorter(ArmorCraftingManager par1ArmorCraftingManager) {
		this.alloyCraftingManager = par1ArmorCraftingManager;
	}
	
	public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe) {
		return (par2IRecipe instanceof ShapelessAlloy) ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0));
    }
	
	public int compare(Object par1Obj, Object par2Obj) {
		return this.compareRecipes((IRecipe) par1Obj, (IRecipe) par2Obj);
	}
}
