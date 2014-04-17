package me.toofifty.ironsuits.common;

import me.toofifty.ironsuits.armor.ArmorSetExo;
import me.toofifty.ironsuits.armor.ArmorSetLight;
import me.toofifty.ironsuits.block.BlockAlloySmeltery;
import me.toofifty.ironsuits.block.BlockAssemblyDesk;
import me.toofifty.ironsuits.block.BlockAssemblyTable;
import me.toofifty.ironsuits.block.BlockBase;
import me.toofifty.ironsuits.block.BlockGrinder;
import me.toofifty.ironsuits.block.BlockIronCraftingTable;
import me.toofifty.ironsuits.creativetab.CreativeTabIronSuits;
import me.toofifty.ironsuits.gui.GuiHandler;
import me.toofifty.ironsuits.item.ItemBase;
import me.toofifty.ironsuits.render.RenderAssemblyDesk;
import me.toofifty.ironsuits.render.RenderAssemblyTable;
import me.toofifty.ironsuits.tileentity.TileEntityAlloySmeltery;
import me.toofifty.ironsuits.tileentity.TileEntityAssemblyDesk;
import me.toofifty.ironsuits.tileentity.TileEntityAssemblyTable;
import me.toofifty.ironsuits.worldgen.OreOsmiumWorldgen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = IronSuits.ID, name = IronSuits.NAME, version = IronSuits.VERSION)
public class IronSuits {

	@Instance(value = IronSuits.ID)
	public static IronSuits instance;

	@SidedProxy(clientSide = "me.toofifty.ironsuits.client.ClientProxy", serverSide = "me.toofifty.ironsuits.common.CommonProxy")
	public static CommonProxy proxy;

	public static final String ID = "ironsuits";
	public static final String VERSION = "1.7.2-0.1.0a";
	public static final String NAME = "Toofifty's Iron Suits";
	
	public static float rotator = 0F;

	/**
	 * ===== Armour Materials =====
	 */
	public static ArmorMaterial armorSetISBronze;
	public static ArmorMaterial armorSetISIron;
	public static ArmorMaterial armorSetISGold;
	public static ArmorMaterial armorSetISSteel;
	public static ArmorMaterial armorSetISReinforcedBronze;
	public static ArmorMaterial armorSetISInvar;
	public static ArmorMaterial armorSetISHardenedSteel;
	public static ArmorMaterial armorSetISOsmium;
	public static ArmorMaterial armorSetISUnstableSteel;
	public static ArmorMaterial armorSetISUltraSteel;

	/**
	 * ===== World Generation =====
	 */
	public static OreOsmiumWorldgen WorldgenOsmiumOre;
	
	/**
	 * ===== GUI =====
	 */
	
	public static final int guiAlloySmeltery = 0;

	/**
	 * ===== Creative Tabs =====
	 */
	public static CreativeTabs tabIronSuits;

	/**
	 * ===== Blocks =====
	 */
	
	// Ores
	public static Block oreIRQuartz;
	public static Block oreOsmium;
	public static Block oreCopper;
	public static Block oreTin;
	
	public static Block blockIRQuartz;
	public static Block blockOsmium;
	
	// Machines
	public static Block assemblyTable;
	public static Block assemblyDesk;
	
	public static Block ironCraftingTable;
	public static Block equipStationFrame;
	public static Block alloySmelteryActive;
	public static Block alloySmelteryIdle;
	public static Block grinder;
	public static Block chargeGenerator;
	
	public static Block copperCoil;
	public static Block advancedCoil;

	/**
	 * ===== Non-module Items =====
	 */

	// Main
	public static Item circuit;
	public static Item grinderHead;
	public static Item shardIRQuartz;
	
	// Dusts
	public static Item dustOsmium;
	public static Item dustCopper;
	public static Item dustTin;
	public static Item dustSteel;
	public static Item dustBronze;
	public static Item dustDiamond;
	public static Item dustIRQuartz;
	public static Item mixCastIron;
	public static Item mixSteelDiamond;
	public static Item mixBronzeDiamond;
	public static Item mixOsmiumSteel;
	public static Item mixIRSteel;
	public static Item mixUltraSteel;
	
	// Process Ingots
	public static Item ingotTemperedIron;
	public static Item ingotTemperedSteel;
	public static Item ingotTemperedOsmiumSteel;
	public static Item ingotTemperedIRSteel;
	public static Item ingotTemperedUltraSteel;
	public static Item ingotCooledUltraSteel;
	
	// End Ingots
	public static Item ingotOsmium;
	public static Item ingotCopper;
	public static Item ingotTin;
	public static Item ingotSteel;
	public static Item ingotBronze;
	public static Item ingotCastIron;
	public static Item ingotHardenedSteel;
	public static Item ingotHardenedBronze;
	public static Item ingotOsmiumSteel;
	public static Item ingotIRSteel;
	public static Item ingotUltraStree;

	/**
	 * ===== Armour Pieces =====
	 */

	/*
	 * Exo Skeleton - Bronze, Iron, Gold, Steel
	 */
	public static Item helmetExoBronze;
	public static Item chestExoBronze;
	public static Item legsExoBronze;
	public static Item bootsExoBronze;

	public static Item helmetExoIron;
	public static Item chestExoIron;
	public static Item legsExoIron;
	public static Item bootsExoIron;

	public static Item helmetExoGold;
	public static Item chestExoGold;
	public static Item legsExoGold;
	public static Item bootsExoGold;

	public static Item helmetExoSteel;
	public static Item chestExoSteel;
	public static Item legsExoSteel;
	public static Item bootsExoSteel;

	public static Item helmetLightGold;
	public static Item chestLightGold;
	public static Item legsLightGold;
	public static Item bootsLightGold;
	/*
	 * Light weight - Bronze, Iron, Gold, Steel
	 */
	
	/*
	 * Heavy weight - Bronze, Iron, Steel
	 */
	
	/*
	 * High-tier - Reinforced Bronze, Cast Iron, Hardened Steel
	 */
	
	/*
	 * End-tier - Osmium Infused Steel, Unstable Steel, Ultra Steel
	 */

	/**
	 * ===== Modules =====
	 */

	/*
	 * 4 tiers per main module, 2 tiers sub-modules, 1 tier special-modules
	 */

	// Defence
	public static Item moduleLowProtect;
	public static Item moduleMedProtect;
	public static Item moduleHighProtect;
	public static Item moduleUltraProtect;

	// Charge Capacity
	public static Item moduleLVBattery;
	public static Item moduleMVBattery;
	public static Item moduleHVBattery;
	public static Item moduleUltraBattery;

	// Modular Space
	public static Item moduleLowSpace;
	public static Item moduleMedSpace;
	public static Item moduleHighSpace;
	public static Item moduleUltraSpace;

	// Chargers
	public static Item moduleLowCharge;
	public static Item moduleHighCharge;

	public static Item moduleLowSolar;
	public static Item moduleHighSolar;

	public static Item moduleLowReactor;
	public static Item moduleHighReactor;

	public static Item moduleLowThermal;
	public static Item moduleHighThermal;

	public static Item moduleLowKinetic;
	public static Item moduleHighKinetic;

	public static Item moduleLowElastic;
	public static Item moduleHighElastic;

	public static Item moduleLowStorage;
	public static Item moduleHighStorage;

	public static Item moduleLowFlyPack;
	public static Item moduleHighFlyPack;

	public static Item moduleLowStimPack;
	public static Item moduleHighStimPack;

	// Special
	public static Item moduleCharged;
	public static Item moduleChargedProjectiles;
	public static Item moduleChutePack;
	public static Item moduleGliderPack;
	public static Item moduleRespirator;
	public static Item moduleAffinity;
	public static Item modulePlasmaProjectiles;
	public static Item moduleWither;
	public static Item moduleSavior;
	public static Item moduleCamoActive;
	public static Item moduleCamoRobot1;
	public static Item moduleCamoRobot2;
	public static Item moduleCamoZombie;
	public static Item moduleCamoSkeleton;

	// Other mods
	public static Item moduleThaumSight;
	public static Item moduleCCSight;

	// ===== END OBJECTS =====
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		setObjects();
		registerObjects();
		registerOreDictionary();

	}

	@EventHandler
	public void initialize(FMLInitializationEvent event) {

		proxy.init();
		proxy.registerRenderInformation();
		addRecipes();
		addSmelting();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	public void setObjects() {
		/**
		 * Armour Materials
		 * 
		 * armorSet = EnumHelper.addArmorMaterial(String armourName, 
		 * int durability, int[] reductionAmounts, int enchantability)
		 * 
		 */
		armorSetISBronze = EnumHelper.addArmorMaterial("IS_BRONZE", 10, new int[] { 1, 4, 3, 1 }, 6);
		armorSetISIron = EnumHelper.addArmorMaterial("IS_IRON", 15, new int[] {2, 6, 5, 2 }, 9);
		armorSetISGold = EnumHelper.addArmorMaterial("IS_GOLD", 7, new int[] {2, 5, 3, 1 }, 25);
		armorSetISSteel = EnumHelper.addArmorMaterial("IS_STEEL", 20, new int[] { 2, 7, 5, 2 }, 12);
		armorSetISReinforcedBronze = EnumHelper.addArmorMaterial("IS_RE_BRONZE", 20, new int[] { 2, 8, 6, 2 }, 10);
		armorSetISInvar = EnumHelper.addArmorMaterial("IS_INVAR", 25, new int[] { 3, 8, 5, 3 }, 20);
		armorSetISHardenedSteel = EnumHelper.addArmorMaterial("IS_HA_STEEL", 30, new int[] { 3, 8, 6, 3 }, 20);
		armorSetISOsmium = EnumHelper.addArmorMaterial("IS_IRON", 33, new int[] { 4, 8, 6, 4 }, 25);
		armorSetISUnstableSteel = EnumHelper.addArmorMaterial("IS_UN_STEEL", 37, new int[] { 4, 9, 7, 4 }, 30);
		armorSetISUltraSteel = EnumHelper.addArmorMaterial("IS_UL_STEEL", 40, new int[] { 6, 10, 8, 6 }, 20);

		/**
		 * Armour Pieces
		 * 
		 * armourTypeMaterial = new ArmorSetMaterial(ArmorMaterial armorSetISMaterial, 
		 * int renderIndex, int armourType, Str unlocalizedName)
		 * 
		 */
		helmetExoBronze = new ArmorSetExo(armorSetISBronze, 0, 0, "exo_bronze_helmet");
		chestExoBronze = new ArmorSetExo(armorSetISBronze, 0, 1, "exo_bronze_chest");
		legsExoBronze = new ArmorSetExo(armorSetISBronze, 0, 2, "exo_bronze_legs");
		bootsExoBronze = new ArmorSetExo(armorSetISBronze, 0, 3, "exo_bronze_boots");
		
		helmetExoIron = new ArmorSetExo(armorSetISIron, 0, 0, "exo_iron_helmet");
		chestExoIron = new ArmorSetExo(armorSetISIron, 0, 1, "exo_iron_chest");
		legsExoIron = new ArmorSetExo(armorSetISIron, 0, 2, "exo_iron_legs");
		bootsExoIron = new ArmorSetExo(armorSetISIron, 0, 3, "exo_iron_boots");
		
		helmetExoGold = new ArmorSetExo(armorSetISGold, 0, 0, "exo_gold_helmet");
		chestExoGold = new ArmorSetExo(armorSetISGold, 0, 1, "exo_gold_chest");
		legsExoGold = new ArmorSetExo(armorSetISGold, 0, 2, "exo_gold_legs");
		bootsExoGold = new ArmorSetExo(armorSetISGold, 0, 3, "exo_gold_boots");
		
		helmetExoSteel = new ArmorSetExo(armorSetISSteel, 0, 0, "exo_steel_helmet");
		chestExoSteel = new ArmorSetExo(armorSetISSteel, 0, 1, "exo_steel_chest");
		legsExoSteel = new ArmorSetExo(armorSetISSteel, 0, 2, "exo_steel_legs");
		bootsExoSteel = new ArmorSetExo(armorSetISSteel, 0, 3, "exo_steel_boots");
		
		helmetLightGold = new ArmorSetLight(armorSetISGold, 0, 0, "light_gold_helmet");

		/**
		 * World Generation
		 */
		WorldgenOsmiumOre = new OreOsmiumWorldgen();

		/**
		 * Creative Tabs
		 */
		tabIronSuits = new CreativeTabIronSuits(CreativeTabs.getNextID(), "IronSuitsTab");

		/**
		 * Blocks
		 */
		assemblyTable = new BlockAssemblyTable(Material.iron, "assembly_table");
		assemblyDesk = new BlockAssemblyDesk(Material.iron, "assembly_desk");
		alloySmelteryIdle = new BlockAlloySmeltery(Material.iron, "alloy_smeltery_idle", false);
		alloySmelteryActive = new BlockAlloySmeltery(Material.iron, "alloy_smeltery_active", true);
		grinder = new BlockGrinder(Material.iron, "grinder");
		ironCraftingTable = new BlockIronCraftingTable(Material.iron).setBlockName("iron_workbench");
		oreOsmium = new BlockBase(Material.rock, "osmium_ore").setHardness(30F);
		oreCopper = new BlockBase(Material.rock, "copper_ore").setHardness(10F);
		oreTin = new BlockBase(Material.rock, "tin_ore").setHardness(10F);
		blockOsmium = new BlockBase(Material.rock, "osmium_block").setHardness(15F);

		/**
		 * Items
		 */		
		circuit = new ItemBase("circuit");
		grinderHead = new ItemBase("grinder_head");
		ingotOsmium = new ItemBase("osmium_ingot");

		ingotCopper = new ItemBase("copper_ingot");
		ingotTin = new ItemBase("tin_ingot");
		ingotSteel = new ItemBase("steel_ingot");
		ingotBronze = new ItemBase("bronze_ingot");

	}
	
	public void addRecipes() {

		/**
		 * Blocks
		 */
		GameRegistry.addRecipe(new ItemStack(blockOsmium, 1), 
				new Object[] {
				"OOO",
				"OOO",
				"OOO",
				'O', ingotOsmium 
		});
		
		GameRegistry.addRecipe(new ItemStack(ironCraftingTable, 1),
				new Object[] { 
				" I ", 
				"ICI", 
				" I ", 
				'I', Items.iron_ingot, 
				'C', Blocks.crafting_table 
		});
		
		GameRegistry.addRecipe(new ItemStack(alloySmelteryIdle, 1),
				new Object[] {
				"SIS",
				"IFI",
				"SCS",
				'S', Blocks.stone,
				'I', Items.iron_ingot,
				'F', Blocks.furnace,
				'C', circuit
		});
		
		GameRegistry.addRecipe(new ItemStack(grinder, 1),
				new Object[] {
				"IGI",
				"IFI",
				"ICI",
				'G', grinderHead,
				'I', Items.iron_ingot,
				'F', Blocks.furnace,
				'C', circuit
		});
		
		GameRegistry.addRecipe(new ItemStack(chestExoGold, 1),
				new Object[] {
				"S",
				"C",
				'S', chestExoGold,
				'C', circuit
		});
		
		
		/**
		 * Items
		 */
		
		GameRegistry.addRecipe(new ItemStack(circuit, 4),
				new Object[] {
				"GRG",
				"RIR",
				'G', Items.gold_ingot,
				'R', Items.redstone,
				'I', Items.iron_ingot
		});
		
		GameRegistry.addRecipe(new ItemStack(circuit, 1),
				new Object[] {
				"IR",
				"RI",
				'R', Items.redstone,
				'I', Items.iron_ingot
		});
		
		GameRegistry.addRecipe(new ItemStack(grinderHead, 1),
				new Object[] {
				"S S",
				"DSD",
				" D ",
				'D', Items.diamond,
				'S', ingotSteel
		});
		
		

	}

	public void addSmelting() {

		GameRegistry.addSmelting(IronSuits.oreOsmium, new ItemStack(
				IronSuits.ingotOsmium), 10.0F);

	}

	public void registerObjects() {
		/**
		 * Register Blocks
		 */
		registerBlock(assemblyTable);
		registerBlock(assemblyDesk);
		registerBlock(ironCraftingTable);
		registerBlock(oreOsmium);
		registerBlock(oreCopper);
		registerBlock(oreTin);
		registerBlock(blockOsmium);
		registerBlock(alloySmelteryIdle);
		registerBlock(alloySmelteryActive);
		registerBlock(grinder);

		/**
		 * Register Items
		 */
		registerItem(circuit);
		registerItem(grinderHead);
		registerItem(ingotOsmium);
		registerItem(ingotCopper);
		registerItem(ingotTin);
		registerItem(ingotSteel);
		registerItem(ingotBronze);

		/**
		 * Register Armour Pieces
		 */
		registerItem(helmetExoBronze);
		registerItem(chestExoBronze);
		registerItem(legsExoBronze);
		registerItem(bootsExoBronze);
		
		registerItem(helmetExoIron);
		registerItem(chestExoIron);
		registerItem(legsExoIron);
		registerItem(bootsExoIron);
		
		registerItem(helmetExoGold);
		registerItem(chestExoGold);
		registerItem(legsExoGold);
		registerItem(bootsExoGold);
		
		registerItem(helmetExoSteel);
		registerItem(chestExoSteel);
		registerItem(legsExoSteel);
		registerItem(bootsExoSteel);
		
		registerItem(helmetLightGold);
		

		/**
		 * World Generation
		 */
		GameRegistry.registerWorldGenerator(WorldgenOsmiumOre, 0);
		
		/**
		 * Tile Entities
		 */
		GameRegistry.registerTileEntity(TileEntityAlloySmeltery.class, "tile_entity_alloy_smeltery");
		GameRegistry.registerTileEntity(TileEntityAssemblyTable.class, "tile_entity_assembly_table");
		GameRegistry.registerTileEntity(TileEntityAssemblyDesk.class, "tile_entity_assembly_desk");
		
		/**
		 * GUI
		 */
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		/**
		 * Renderers
		 */
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAssemblyTable.class, new RenderAssemblyTable());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAssemblyDesk.class, new RenderAssemblyDesk());
		//RenderingRegistry.registerBlockHandler(handler);

	}
	
	public void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5).replace(".name", ""));
	}
	
	public void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5).replace(".name", ""));
	}

	public void registerOreDictionary() {

		// OreDictionary.registerOre("oreCopper", new ItemStack(oreCopper));
		// OreDictionary.registerOre("oreTin", new ItemStack(oreTin));
		// OreDictionary.registerOre("dustCopper", new ItemStack(dustCopper));
		// OreDictionary.registerOre("dustTin", new ItemStack(dustTin));
		OreDictionary.registerOre("dustSteel", new ItemStack(dustSteel));
		OreDictionary.registerOre("ingotCopper", new ItemStack(ingotCopper));
		OreDictionary.registerOre("ingotTin", new ItemStack(ingotTin));
		OreDictionary.registerOre("ingotSteel", new ItemStack(ingotSteel));

	}

}
