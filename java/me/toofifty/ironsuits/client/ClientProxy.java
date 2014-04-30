package me.toofifty.ironsuits.client;

import me.toofifty.ironsuits.common.CommonProxy;
import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.common.TickHandler;
import me.toofifty.ironsuits.model.ModelArmor;
import me.toofifty.ironsuits.render.RenderArmorItem;
import me.toofifty.ironsuits.render.RenderAssemblyDesk;
import me.toofifty.ironsuits.render.RenderAssemblyTable;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {
	
	public static int assemblyTableRenderID;
	public static int assemblyDeskActiveRenderID;
	public static int assemblyDeskIdleRenderID;
	
	public void registerRenderInformation() {
		
		assemblyDeskActiveRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(assemblyDeskActiveRenderID, new RenderAssemblyDesk());
		
		assemblyDeskIdleRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(assemblyDeskIdleRenderID, new RenderAssemblyDesk());
		
		assemblyTableRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(assemblyTableRenderID, new RenderAssemblyTable());

		MinecraftForgeClient.registerItemRenderer(IronSuits.chestExoBronze, new RenderArmorItem());
		MinecraftForgeClient.registerItemRenderer(IronSuits.helmetExoBronze, new RenderArmorItem());
		MinecraftForgeClient.registerItemRenderer(IronSuits.legsExoBronze, new RenderArmorItem());
		MinecraftForgeClient.registerItemRenderer(IronSuits.bootsExoBronze, new RenderArmorItem());
		
		MinecraftForgeClient.registerItemRenderer(IronSuits.chestExoIron, new RenderArmorItem());
		MinecraftForgeClient.registerItemRenderer(IronSuits.helmetExoIron, new RenderArmorItem());
		MinecraftForgeClient.registerItemRenderer(IronSuits.legsExoIron, new RenderArmorItem());
		MinecraftForgeClient.registerItemRenderer(IronSuits.bootsExoIron, new RenderArmorItem());

		MinecraftForgeClient.registerItemRenderer(IronSuits.chestExoGold, new RenderArmorItem());
		MinecraftForgeClient.registerItemRenderer(IronSuits.helmetExoGold, new RenderArmorItem());
		MinecraftForgeClient.registerItemRenderer(IronSuits.legsExoGold, new RenderArmorItem());
		MinecraftForgeClient.registerItemRenderer(IronSuits.bootsExoGold, new RenderArmorItem());

		MinecraftForgeClient.registerItemRenderer(IronSuits.chestExoSteel, new RenderArmorItem());
		MinecraftForgeClient.registerItemRenderer(IronSuits.helmetExoSteel, new RenderArmorItem());
		MinecraftForgeClient.registerItemRenderer(IronSuits.legsExoSteel, new RenderArmorItem());
		MinecraftForgeClient.registerItemRenderer(IronSuits.bootsExoSteel, new RenderArmorItem());

		MinecraftForgeClient.registerItemRenderer(IronSuits.helmetReinforcedBronze, new RenderArmorItem());
		MinecraftForgeClient.registerItemRenderer(IronSuits.chestReinforcedBronze, new RenderArmorItem());
		MinecraftForgeClient.registerItemRenderer(IronSuits.legsReinforcedBronze, new RenderArmorItem());
		
	}
	
	public void init() {
		FMLCommonHandler.instance().bus().register(new TickHandler());
		MinecraftForge.EVENT_BUS.register(new TickHandler());
	}

	ModelArmor exoHelmet = new ModelArmor("exo_helmet", 64, 32);
	ModelArmor exoChest = new ModelArmor("exo_chest", 64, 32);
	ModelArmor exoLegs = new ModelArmor("exo_legs", 64, 32);
	ModelArmor exoBoots = new ModelArmor("exo_boots", 64, 32);
	
	ModelArmor reinforcedHelmet = new ModelArmor("reinforced_helmet", 64, 64);
	ModelArmor reinforcedChest = new ModelArmor("reinforced_chest", 64, 64);
	ModelArmor reinforcedLegs = new ModelArmor("reinforced_legs", 64, 32);
	
	@Override
	public ModelArmor getArmorModel(int id) {
		switch (id) {
		/**
		 * Exoskeleton suits
		 */
		case 0:
			return exoHelmet;
		case 1:
			return exoChest;
		case 2:
			return exoLegs;
		case 3:
			return exoBoots;
		/**
		 * Light weight suits
		 */
			
		/**
		 * Heavy weight suits
		 */
			
		/**
		 * Reinforced suits
		 */
		case 12:
			return reinforcedHelmet;
		case 13:
			return reinforcedChest;
		case 14:
			return reinforcedLegs;
			
		/**
		 * Steel Alloy suits
		 */
		}
		return null;
	}

}
