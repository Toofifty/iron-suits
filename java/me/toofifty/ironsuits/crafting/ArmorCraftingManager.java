package me.toofifty.ironsuits.crafting;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;

public class ArmorCraftingManager {
	
	private static final ArmorCraftingManager instance = new ArmorCraftingManager();
	
	private List recipes;
	private Map experienceList = new HashMap();
	
	public static final ArmorCraftingManager getInstance() {
		return instance;
	}
	
	private ArmorCraftingManager() {
		this.recipes = new ArrayList();
		
		Collections.sort(this.recipes, new ArmorRecipeSorter(this));
		System.out.println(this.recipes.size() + " armor recipes loaded.");
	}
	
	public ShapedArmor addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj) {
		String s = "";
	}

}
