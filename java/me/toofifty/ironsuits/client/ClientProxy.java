package me.toofifty.ironsuits.client;

import me.toofifty.ironsuits.common.CommonProxy;
import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.common.TickHandler;
import me.toofifty.ironsuits.model.ModelArmorBase;
import me.toofifty.ironsuits.model.ModelExoBoots;
import me.toofifty.ironsuits.model.ModelExoChest;
import me.toofifty.ironsuits.model.ModelExoHelmet;
import me.toofifty.ironsuits.model.ModelExoLegs;
import me.toofifty.ironsuits.model.ModelLightHelmet;
import me.toofifty.ironsuits.render.RenderArmorItem;
import me.toofifty.ironsuits.render.RenderAssemblyDesk;
import me.toofifty.ironsuits.render.RenderAssemblyTable;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {
	
	public static int assemblyDeskRenderID;
	public static int assemblyTableRenderID;
	
	public void registerRenderInformation() {
		
		assemblyDeskRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(assemblyDeskRenderID, new RenderAssemblyDesk());
		
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
		
		MinecraftForgeClient.registerItemRenderer(IronSuits.helmetLightGold, new RenderArmorItem());
		
	}
	
	public void init() {
		FMLCommonHandler.instance().bus().register(new TickHandler());
		MinecraftForge.EVENT_BUS.register(new TickHandler());
	}
	
	private static final ModelExoHelmet exoHelmet = new ModelExoHelmet(1.0F);
	private static final ModelExoChest exoChest = new ModelExoChest(1.0F);
	private static final ModelExoLegs exoLegs = new ModelExoLegs(1.0F);
	private static final ModelExoBoots exoBoots = new ModelExoBoots(1.0F);
	
	private static final ModelLightHelmet lightHelmet = new ModelLightHelmet(1.0F);
	
	@Override
	public ModelArmorBase getArmorModel(int id) {
		switch (id) {
		/**
		 * Exoskeleton suit
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
		 * Light weight suit
		 */
		case 4:
			return lightHelmet;
		}
		return exoHelmet;
	}

}
