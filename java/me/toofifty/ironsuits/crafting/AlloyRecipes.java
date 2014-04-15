package me.toofifty.ironsuits.crafting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import me.toofifty.ironsuits.common.IronSuits;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class AlloyRecipes {
	
	private static final AlloyRecipes alloyBase = new AlloyRecipes();
	
	public List recipes = new ArrayList();
	private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
	
	public static AlloyRecipes smelting() {
		return alloyBase;
	}
	
	private AlloyRecipes() {
		this.addShapelessAlloy(new ItemStack(IronSuits.ingotSteel, 1), new Object[]{Items.coal, Items.iron_ingot});
		this.addShapelessAlloy(new ItemStack(Items.iron_ingot, 2), new Object[]{Blocks.iron_ore, Blocks.iron_ore});
		
	}
	
	public void addShapelessAlloy(ItemStack par1ItemStack, Object ... par2ArrayOfObj) {
		ArrayList arraylist = new ArrayList();
		Object[] aobject = par2ArrayOfObj;
		int i = par2ArrayOfObj.length;
		
		for (int j=0; j < i; j++) {
			Object object1 = aobject[j];
			
			if (object1 instanceof ItemStack) {
				arraylist.add(((ItemStack)object1).copy());
			} else if (object1 instanceof Item) {
				arraylist.add(new ItemStack((Item)object1));
			} else {
				if (!(object1 instanceof Block)) {
					throw new RuntimeException("Invalid alloy!");
				}
				
				arraylist.add(new ItemStack((Block)object1));
			}
		}
		
		this.recipes.add(new ShapelessAlloy(par1ItemStack, arraylist));
	}
	
	public static boolean hasRecipe(ItemStack s0, ItemStack s1, ItemStack s2, ItemStack s3) {
		return false;
	}

}
