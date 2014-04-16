package me.toofifty.ironsuits.crafting;

import java.util.ArrayList;
import java.util.Collections;
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
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class AlloyCraftingManager {

	private static final AlloyCraftingManager instance = new AlloyCraftingManager();

	private List recipes;
	private Map experienceList = new HashMap();

	public static final AlloyCraftingManager getInstance() {
		/**
		 * The static instance of this class
		 */
		return instance;
	}

	private AlloyCraftingManager() {
		this.recipes = new ArrayList();
		
		// Vanilla smelting recipes mass-producing
		this.addMassRecipe(Items.iron_ingot, 0.7F, Blocks.iron_ore);
		this.addMassRecipe(Items.gold_ingot, 1.0F, Blocks.gold_ore);
		this.addMassRecipe(Items.diamond, 1.0F, Blocks.diamond_ore);
		this.addMassRecipe(Blocks.glass, 0.1F, Blocks.sand);
		this.addMassRecipe(Items.cooked_porkchop, 0.35F, Items.porkchop);
		this.addMassRecipe(Items.cooked_beef, 0.35F, Items.beef);
		this.addMassRecipe(Items.cooked_chicken, 0.35F, Items.chicken);
		this.addMassRecipe(Blocks.stone, 0.1F, Blocks.cobblestone);
		this.addMassRecipe(Items.brick, 0.3F, Items.clay_ball);
		this.addMassRecipe(Blocks.hardened_clay, 0.35F, Blocks.clay);
		this.addMassRecipe(Items.emerald, 1.0F, Blocks.emerald_ore);
		this.addMassRecipe(Items.netherbrick, 0.1F, Blocks.netherrack);

		this.addMassMDRecipe(new ItemStack(Items.dye, 1, 2), 0.2F, Blocks.cactus);
		this.addMassMDRecipe(new ItemStack(Items.coal, 1, 1), 0.15F, Blocks.log);
		this.addMassMDRecipe(new ItemStack(Items.coal, 1, 1), 0.15F, Blocks.log2);

		this.addMassRecipe(Items.redstone, 0.7F, Blocks.redstone_ore);
		this.addMassMDRecipe(new ItemStack(Items.dye, 1, 4), 0.2F, Blocks.lapis_ore);
		this.addMassRecipe(Items.coal, 0.1F, Blocks.coal_ore);
		this.addMassRecipe(Items.quartz, 0.2F, Blocks.quartz_ore);

		// Vanilla fish! Because I can.
        ItemFishFood.FishType[] afishtype = ItemFishFood.FishType.values();
		int i = afishtype.length;

        for (int j = 0; j < i; ++j) {
            ItemFishFood.FishType fishtype = afishtype[j];

            if (fishtype.func_150973_i()) {
            	this.addMassMDRecipe(new ItemStack(Items.cooked_fished, 1, fishtype.func_150976_a()), 0.35F, new ItemStack(Items.fish, 1, fishtype.func_150976_a()));
            }
        }
		
		// Custom recipes
		this.addMassRecipe(IronSuits.ingotOsmium, 1.0F, IronSuits.oreOsmium);
		this.addMassRecipe(IronSuits.ingotCopper, 0.7F, IronSuits.oreCopper);
		this.addMassRecipe(IronSuits.ingotTin, 0.7F, IronSuits.oreTin);
		
		// Alloy recipes
		this.addShapelessAlloy(new ItemStack(IronSuits.ingotSteel, 1), 0.5F, new Object[] { Items.coal, Items.iron_ingot });
		this.addShapelessAlloy(new ItemStack(Blocks.nether_brick, 1), 0.4F, new Object[] { Blocks.netherrack, Blocks.netherrack, Blocks.netherrack, Blocks.netherrack });
		this.addShapelessAlloy(new ItemStack(IronSuits.ingotBronze, 4), 0.5F, new Object[] { IronSuits.ingotCopper, IronSuits.ingotTin, IronSuits.ingotCopper, IronSuits.ingotCopper });

		Collections.sort(this.recipes, new AlloyRecipeSorter(this));
		System.out.println(this.recipes.size() + " alloy recipes loaded.");
		
	}
	
	public void addMassRecipe(Object output, float XP, Object input) {
		if (output instanceof Block) {
			this.addShapelessAlloy(new ItemStack((Block)output, 1), XP, new Object[] { input });
			this.addShapelessAlloy(new ItemStack((Block)output, 2), XP*2F, new Object[] { input, input });
			this.addShapelessAlloy(new ItemStack((Block)output, 3), XP*3F, new Object[] { input, input, input });
			this.addShapelessAlloy(new ItemStack((Block)output, 4), XP*4F, new Object[] { input, input, input, input });
		} else if (output instanceof Item) {
			this.addShapelessAlloy(new ItemStack((Item)output, 1), XP, new Object[] { input });
			this.addShapelessAlloy(new ItemStack((Item)output, 2), XP*2F, new Object[] { input, input });
			this.addShapelessAlloy(new ItemStack((Item)output, 3), XP*3F, new Object[] { input, input, input });
			this.addShapelessAlloy(new ItemStack((Item)output, 4), XP*4F, new Object[] { input, input, input, input });
		}
	}
	
	public void addMassMDRecipe(ItemStack output, float XP, Object input) {
		this.addShapelessAlloy(new ItemStack(output.getItem(), 1, output.getItemDamage()), XP, new Object[] { input });
		this.addShapelessAlloy(new ItemStack(output.getItem(), 2, output.getItemDamage()), XP*2F, new Object[] { input, input });
		this.addShapelessAlloy(new ItemStack(output.getItem(), 3, output.getItemDamage()), XP*3F, new Object[] { input, input, input });
		this.addShapelessAlloy(new ItemStack(output.getItem(), 4, output.getItemDamage()), XP*4F, new Object[] { input, input, input, input });
		
	}
	
	public ShapedAlloy addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (par2ArrayOfObj[i] instanceof String[])
        {
            String[] astring = (String[])((String[])par2ArrayOfObj[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (par2ArrayOfObj[i] instanceof String)
            {
                String s2 = (String)par2ArrayOfObj[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2)
        {
            Character character = (Character)par2ArrayOfObj[i];
            ItemStack itemstack1 = null;

            if (par2ArrayOfObj[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
            }
            else if (par2ArrayOfObj[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
            }
            else if (par2ArrayOfObj[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        ShapedAlloy shapedAlloy = new ShapedAlloy(j, k, aitemstack, par1ItemStack);
        this.recipes.add(shapedAlloy);
        return shapedAlloy;
    }

	public void addShapelessAlloy(ItemStack par1ItemStack, float XP,
			Object... par2ArrayOfObj) {
		ArrayList arraylist = new ArrayList();
		Object[] aobject = par2ArrayOfObj;
		int i = par2ArrayOfObj.length;

		for (int j = 0; j < i; ++j) {
			Object object1 = aobject[j];

			if (object1 instanceof ItemStack) {
				arraylist.add(((ItemStack) object1).copy());
			} else if (object1 instanceof Item) {
				arraylist.add(new ItemStack((Item) object1));
			} else {
				if (!(object1 instanceof Block)) {
					throw new RuntimeException("Invalid alloy!");
				}

				arraylist.add(new ItemStack((Block) object1));
			}
		}

        this.experienceList.put(par1ItemStack, Float.valueOf(XP));
		this.recipes.add(new ShapelessAlloy(par1ItemStack, arraylist));

	}
	
	public float getExp(ItemStack itemStack) {
		float ret = itemStack.getItem().getSmeltingExperience(itemStack);
		if (ret != -1)
			return ret;

		Iterator iterator = this.experienceList.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return 0.0F;
			}

			entry = (Entry) iterator.next();
		} while (!this.func_151397_a(itemStack, (ItemStack) entry.getKey()));

		return ((Float) entry.getValue()).floatValue();
	}
	
	// I have no fucking clue what this is... ahhhh
	private boolean func_151397_a(ItemStack par1, ItemStack par2) {
		return par2.getItem() == par1.getItem()
				&& (par2.getItemDamage() == 32767 || par2.getItemDamage() == par1
						.getItemDamage());
	}

	public ItemStack findMatchingRecipe(
			InventoryCrafting par1InventoryCrafting, World par2World) {
		int i = 0;
		ItemStack itemstack = null;
		ItemStack itemstack1 = null;
		int j;

		// Active furnace placing hotfix
		if (par1InventoryCrafting == null) {
			return null;
		}
		
		for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j) {
			ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);

			if (itemstack2 != null) {
				if (i == 0) {
					itemstack = itemstack2;
				}

				if (i == 1) {
					itemstack1 = itemstack2;
				}

				++i;
			}
		}
/*
		if (i == 2 && itemstack.getItem() == itemstack1.getItem()
				&& itemstack.stackSize == 1 && itemstack1.stackSize == 1
				&& itemstack.getItem().isRepairable()) {
			Item item = itemstack.getItem();
			int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
			int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
			int l = j1 + k + item.getMaxDamage() * 5 / 100;
			int i1 = item.getMaxDamage() - l;

			if (i1 < 0) {
				i1 = 0;
			}

			return new ItemStack(itemstack.getItem(), 1, i1);
		} else*/ {
			for (j = 0; j < this.recipes.size(); ++j) {
				IRecipe irecipe = (IRecipe) this.recipes.get(j);

				if (irecipe.matches(par1InventoryCrafting, par2World)) {
					ItemStack newItemStack = irecipe.getCraftingResult(par1InventoryCrafting);
					return newItemStack;
				}
			}

			return null;
		}
	}

	/**
	 * returns the List<> of all recipes
	 */
	public List getRecipeList() {
		return this.recipes;
	}
}